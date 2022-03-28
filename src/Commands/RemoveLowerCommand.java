package Commands;

import Exceptions.CoordinatesException;
import Exceptions.NameException;
import Exceptions.SalaryException;
import Utils.MethodsForCheckCommand;
import WorkerClasses.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Класс для удаления элементов меньше чем заданный
 */
public class RemoveLowerCommand {
    /** Поле хранения согласия */
    private String agreement;
    /** Поле для использования методов проверки */
    private final MethodsForCheckCommand check = new MethodsForCheckCommand();
    /** Поле для чтения ввода */
    final Scanner read = new Scanner(System.in);
    /**
     * Основной метод класса RemoveLowerCommand, реализующий его смысл
     *
     * @param hashSet изменяемая коллекция
     * @param initDate дата инициализации
     * @param obj строковое представление объекта
     * @return hashSet изменённая коллекция
     */
    public LinkedHashSet<Worker> mainMethod(LinkedHashSet<Worker> hashSet, Date initDate, String obj){
        try {
            boolean repeater = true;
            Scanner scanner = new Scanner(System.in);
            Worker worker = new Worker();
            Coordinates coordinates = new Coordinates();
            Organization organization = new Organization();
            Address address = new Address();
            obj = obj.replaceAll("'", "");
            obj = obj.replace("{", "");
            obj = obj.replace("}", "");
            String[] words = obj.split(",", 3);
            ArrayList<Integer> list = new ArrayList<>();
            int ID;
            for (Worker mrWorker : hashSet) {
                list.add(mrWorker.getId());
            }
            ID = Collections.max(list);
            list.clear();
            for (int i = 0; i < 3; i++) {
                String[] el = words[i].split("=");
                switch (i) {
                    case 0:
                        check.nameCheck(el[1]);
                        worker.setName(el[1]);
                        break;
                    case 1:
                        check.salaryCheck(Double.parseDouble(el[1]));
                        worker.setSalary(Double.parseDouble(el[1]));
                        break;
                    case 2:
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        Date y = s.parse(el[1]);
                        worker.setStartDate(y);
                        break;
                }
            }
            //Начало блока ввода координат
            while (repeater) {
                try {
                    System.out.println("Введите координату X, значение должно быть больше -46");
                    String input = scanner.nextLine();
                    int numX = Integer.parseInt(input);
                    check.xCheck(numX);
                    repeater = false;
                    coordinates.setX(numX);
                } catch (NumberFormatException | CoordinatesException e) {
                    System.err.println("Неправильный формат координаты X, попробуйте ввести снова!");
                }
            }
            repeater = true;
            while (repeater) {
                try {
                    System.out.println("Введите координату Y, значение должно быть больше -836");
                    String input = scanner.nextLine();
                    Long numY = Long.parseLong(input);
                    check.yCheck(numY);
                    repeater = false;
                    coordinates.setY(numY);
                } catch (NumberFormatException | CoordinatesException e) {
                    System.err.println("Неправильный формат координаты Y, попробуйте ввести снова!");
                }
            }
            worker.setCoordinates(coordinates);
            //Конец блока ввода координат
            repeater = true;
            // Начало блока ввода Position
            while (repeater) {
                try {
                    System.out.println("Введите POSITION, возможные варианты:\n" +
                            "    DIRECTOR,\n" +
                            "    MANAGER,\n" +
                            "    LABORER,\n" +
                            "    HEAD_OF_DIVISION,\n" +
                            "    BAKER");
                    String input = scanner.nextLine();
                    Position position = Position.valueOf(input);
                    worker.setPosition(position);
                    repeater = false;
                } catch (IllegalArgumentException e) {
                    System.err.println("Данный Position не существует, попробуйте снова!");
                }
            }
            // конец блока ввода Position
            repeater = true;
            // Начало блока ввода Status
            while (repeater) {
                try {
                    System.out.println("Введите Status, возможные варианты:\n" +
                            "    FIRED\n" +
                            "    HIRED\n" +
                            "    RECOMMENDED_FOR_PROMOTION");
                    String input = scanner.nextLine();
                    Status status = Status.valueOf(input);
                    worker.setStatus(status);
                    repeater = false;
                } catch (IllegalArgumentException e) {
                    System.err.println("Данный Status не существует, попробуйте снова!");
                }
            }
            // конец блока ввода статуса
            repeater = true;
            // Начало блока ввода поля Organization
            // начало блока проверки Null поля Organization
            while (repeater) {
                try {
                    System.out.println("Хотите, чтобы поле Organization было null? \n" +
                            "Для подтверждения введите: YES\n" +
                            "Для отказа: NO");
                    agreement = read.nextLine();
                    check.checkAgree(agreement);
                    repeater = false;
                } catch (IllegalArgumentException e) {
                    System.err.println("Неправильный ввод, попробуйте снова!");
                }
            }
            // Конец блока проверки Null поля Organization
            repeater = true;
            // Блок ввода полей Organization, если пользователь решил не оставлять данное поле null
            if (agreement.equals("NO")) {
                // Блок ввода employeesCount
                while (repeater) {
                    try {
                        System.out.println("Введите поле employeesCount класса Organization, employeesCount должен быть " +
                                "> 0 или null ");
                        String input = scanner.nextLine();
                        check.checkOrganizationEmployeesCount(input);
                        if (!input.equals("")) {
                            Long employeesCount = Long.parseLong(input);
                            organization.setEmployeesCount(employeesCount);
                        }
                        repeater = false;
                    } catch (NumberFormatException e) {
                        System.err.println("Неправильный формат employeesCount, попробуйте снова!");
                    }
                }
                // Конец блока ввода employeesCount
                repeater = true;
                // Начало блока ввода Type
                while (repeater) {
                    try {
                        System.out.println("Введите OrganizationType, возможные варианты:\n" +
                                "    PUBLIC,\n" +
                                "    GOVERNMENT,\n" +
                                "    OPEN_JOINT_STOCK_COMPANY" +
                                " поле также может быть null");
                        String input = scanner.nextLine();
                        if (!input.equals("")) {
                            OrganizationType organizationType = OrganizationType.valueOf(input);
                            organization.setType(organizationType);
                        }
                        repeater = false;
                    } catch (IllegalArgumentException e) {
                        System.err.println("Данный organizationType не существует, попробуйте снова!");
                    }
                }
                //Конец блока ввода Type
                repeater = true;
                //Начало блока ввода Address
                while (repeater) {
                    try {
                        System.out.println("Введите адрес:");
                        String input = scanner.nextLine();
                        organization.checkAddress(input);
                        address.setStreet(input);
                        organization.setOfficialAddress(address);
                        repeater = false;
                    } catch (NullPointerException e) {
                        System.err.println("Адрес не может быть пустым");
                    }
                }
            }
            worker.setOrganization(organization);
            //Конец блока ввода организации
            worker.setId(ID + 1);
            worker.setCreationDate(initDate);
            LinkedHashSet<Worker> editHashSet = new LinkedHashSet<>(hashSet);
            for (Worker element : hashSet) {
                if (element.getSalary() < worker.getSalary()) {
                    editHashSet.remove(element);
                }
            }
            hashSet = editHashSet;
        }catch (SalaryException e){
            System.err.println("Ошибка ввода Salary, значение не удовлетворяет условиям");
        }catch (NameException e){
            System.err.println("Ошибка ввода Name, значение не удовлетворяет условиям");
        }catch (NullPointerException | ParseException e) {
            System.err.println("Неправильный формат даты или она отсутствует");
        }
        return hashSet;
    }
}
