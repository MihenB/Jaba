package Utils;

import Exceptions.*;
import WorkerClasses.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
/**
 * Класс, для чтения и обработки файла
 */
public class ReadCollectionFile {
    /** Поле для использования методов проверки */
    MethodsForCheckCommand check = new MethodsForCheckCommand();
    /** Возвращаемая коллекция */
    LinkedHashSet<Worker> hashSet = new LinkedHashSet<>();
    /**
     * Основной метод класса ReadCollectionFile для выполнения его основной задачи
     *
     * @exception ExitException исключение условия выхода из программы
     * @param fileName имя файла для обработки
     * @return hashSet возвращаемая коллекция
     */
    public LinkedHashSet<Worker> mainMethod(String fileName) throws ExitException {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String obj = reader.readLine();
            while (obj != null) {
                String statusEmployerCount = "null";
                String statusType = "null";
                Worker worker = new Worker();
                Coordinates coordinates = new Coordinates();
                Organization organization = new Organization();
                Address address = new Address();
                obj = obj.replaceAll("'", "");
                obj = obj.replace("{", "");
                obj = obj.replace("}", "");
                String[] words = obj.split(",", 12);
                for (int i = 0; i < 12; i++){
                    String[] el = words[i].split("=");
                    switch (i) {
                        case 0:
                            check.checkId(el[1]);
                            worker.setId(Integer.parseInt(el[1]));
                        case 1:
                            check.nameCheck(el[1]);
                            worker.setName(el[1]);
                            break;
                        case 2:
                            check.xCheck(Integer.parseInt(el[1]));
                            coordinates.setX(Integer.parseInt(el[1]));
                            break;
                        case 3:
                            check.yCheck(Long.parseLong(el[1]));
                            coordinates.setY(Long.parseLong(el[1]));
                            break;
                        case 4:
                            SimpleDateFormat dateCreationFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date creationDate = dateCreationFormat.parse(el[1]);
                            worker.setCreationDate(creationDate);
                            break;
                        case 5:
                            check.salaryCheck(Double.parseDouble(el[1]));
                            worker.setSalary(Double.parseDouble(el[1]));
                            break;
                        case 6:
                            SimpleDateFormat dateStartFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date startDate = dateStartFormat.parse(el[1]);
                            worker.setStartDate(startDate);
                            break;
                        case 7:
                            check.checkPosition(el[1]);
                            Position position = Position.valueOf(el[1]);
                            worker.setPosition(position);
                            break;
                        case 8:
                            check.checkStatus(el[1]);
                            Status status = Status.valueOf(el[1]);
                            worker.setStatus(status);
                            break;
                        case 9:
                            if (!el[1].equals("null")) {
                                statusEmployerCount = el[1];
                                check.checkEmployerCount(el[1]);
                                Long employeesCount = Long.parseLong(el[1]);
                                organization.setEmployeesCount(employeesCount);
                            }
                            break;
                        case 10:
                            if (!el[1].equals("null") ) {
                                check.checkType(el[1]);
                                statusType = el[1];
                                organization.setType(OrganizationType.valueOf(el[1]));
                            }
                            break;
                        case 11:
                            if (!statusEmployerCount.equals("null") | !statusType.equals("null")) {
                                check.checkAddress(el[1]);
                                address.setStreet(el[1]);
                                organization.setOfficialAddress(address);
                            }
                            break;
                    }
                }
                worker.setCoordinates(coordinates);
                worker.setOrganization(organization);
                hashSet.add(worker);
                obj = reader.readLine();
            }
        check.checkSameId(hashSet);
        } catch (FileNotFoundException e){
            System.err.println("Не удаётся найти файл");
            throw new ExitException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExitException();
        }catch (SalaryException e){
            System.err.println("Ошибка парсинга, значение Salary не удовлетворяет условиям");
            throw new ExitException();
        }catch (NameException e){
            System.err.println("Ошибка парсинга, значение Name не удовлетворяет условиям");
            throw new ExitException();
        }catch (NullPointerException | ParseException e) {
            System.err.println("Ошибка парсинга, неправильный формат даты или она отсутствует");
            throw new ExitException();
        }catch (IdException e){
            System.err.println("Ошибка парсинга, неправильный формат Id или в коллекции есть совпадающие id");
            throw new ExitException();
        }catch (CoordinatesException e) {
            System.err.println("Ошибка парсинга, неправильный формат координат");
            throw new ExitException();
        }catch (PositionException e){
            System.err.println("Ошибка парсинга, неправильный формат Position");
            throw new ExitException();
        }catch (StatusException e){
            System.err.println("Ошибка парсинга, неправильный формат Status");
            throw new ExitException();
        }catch (EmployerCountException e){
            System.err.println("Ошибка парсинга, неправильный формат EmployerCount");
            throw new ExitException();
        }catch (TypeException e){
            System.err.println("Ошибка парсинга, неправильный формат OrganizationType");
            throw new ExitException();
        }catch (AddressException e){
            System.err.println("Ошибка парсинга, неправильный формат Address");
            throw new ExitException();
        }
        return hashSet;
    }
}
