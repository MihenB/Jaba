
import java.util.*;

import Exceptions.*;
import Utils.MethodsForCheckInput;
import Utils.ReadCollectionFile;
import Utils.SalaryComparator;
import WorkerClasses.Worker;

public class InputManager {
    /** Поле для использования методов команд */
    CollectionControl control = new CollectionControl();
    /** Булево поле для завершения программы */
    private boolean flag = true;
    /** Поле для хранения даты инициализации */
    Date initDate = new Date();
    /** Поле для использования методов проверки */
    MethodsForCheckInput check = new MethodsForCheckInput();
    /** Поле, хранящее имя файла */
    String fileNameCollection;
    /** Поле для использования сортировки */
    Comparator<Worker> sortSalary = new SalaryComparator();
    /** Поле для использования метода чтения и обработки файла */
    private final ReadCollectionFile read = new ReadCollectionFile();

    public InputManager(String nameSource) {
        this.fileNameCollection = System.getenv(nameSource).replaceAll("\"", "");
    }
    /**
     * Метод переводящий консоль в режим ввода команд
     * @param command команда из консоли
     */
    public void interactiveMod(String command){
        LinkedHashSet<Worker> localCollection = control.getCollection();

        String[] finalUserCommand = command.trim().split(" +", 3);
        try {
            check.checkCommand(finalUserCommand[0]);
            switch (finalUserCommand[0]) {
                case "help":
                    try {
                        System.out.println(control.help.mainMethod());
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }
                    break;
                case "exit":
                    try {
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        flag = false;
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }
                    break;
                case "info":
                    try {
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        System.out.println(control.info.mainMethod(localCollection, initDate));
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }
                    break;
                case "show":
                    try {
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        check.checkEmptyCollection(localCollection);
                        for (String output : control.show.mainMethod(localCollection)){
                            System.out.println(output);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }catch (EmptyCollectionException e){
                        System.err.println("Коллекция пуста");
                    }
                    break;
                case "add":
                    try {
                        localCollection = control.add.mainMethod(localCollection,initDate, finalUserCommand[1]);
                        control.setCollection(localCollection);
                        System.out.println("Выполнение завершено, продолжайте ввод");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда введена неверно: проверьте наличие пробелов в {element} " +
                                "или количество аргументов команды, а также наличие полей объекта");
                    }
                    break;
                case "clear":
                    try {
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        localCollection = control.clear.mainMethod(localCollection);
                        control.setCollection(localCollection);
                        System.out.println("Коллекция очищена");
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }
                    break;
                case "update":
                    try {
                        check.checkVolumeId(finalUserCommand[1], localCollection);
                        localCollection = control.update.mainMethod(localCollection, finalUserCommand[1],
                                initDate, finalUserCommand[2]);
                        control.setCollection(localCollection);
                        System.out.println("Выполнение завершено, продолжайте ввод");
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.err.println("Команда введена неверно.");
                    }catch (IllegalArgumentException e){
                        System.err.println("Элемент с данным индексом не существует");
                    }
                    break;
                case "remove_by_id":
                    try {
                        check.checkLengthArraysOfTwo(finalUserCommand.length);
                        check.checkVolumeId(finalUserCommand[1], localCollection);
                        localCollection = control.remove.mainMethod(localCollection, finalUserCommand[1]);
                        control.setCollection(localCollection);
                        System.out.println("Команда успешно выполнена");
                    }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
                        System.err.println("Команда введена неверно.");
                    }catch (IllegalArgumentException e){
                        System.err.println("Элемента с данным индексом не существует");
                    }
                    break;
                case "average_of_salary":
                    try {
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        check.checkEmptyCollection(localCollection);
                        System.out.println(control.average.mainMethod(localCollection));
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }catch (EmptyCollectionException e){
                        System.err.println("В коллекции отсутствуют элементы, значение не может быть посчитано");
                    }
                    break;
                case "filter_by_status":
                    try {
                        check.checkLengthArraysOfTwo(finalUserCommand.length);
                        check.checkStatusExistence(localCollection,finalUserCommand[1]);
                        for (String output : control.filter.mainMethod(localCollection, finalUserCommand[1])){
                            System.out.println(output);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }catch(IllegalArgumentException e) {
                        System.err.println("Неправильный критерий фильтрации");
                    }catch (ExistenceStatusException e){
                        System.err.println("Элемента с данным статусом не существует");
                    }

                    break;
                case "print_unique_status":
                    try {
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        check.checkAvailabilityUniqueStatus(control.unique.mainMethod(localCollection));
                        check.checkEmptyCollection(localCollection);
                        System.out.println(control.unique.mainMethod(localCollection));
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }catch (UniqueStatusException e){
                        System.err.println("Уникальных статусов элементов в данной коллекции нет");
                    }catch (EmptyCollectionException e) {
                        System.err.println("В коллекции отсутствуют элементы");
                    }
                    break;
                case "remove_lower":
                    try {
                        check.checkLengthArraysOfTwo(finalUserCommand.length);
                        check.checkEmptyCollection(localCollection);
                        int sizeOld = localCollection.size();
                        localCollection = control.removeLower.mainMethod(localCollection,initDate, finalUserCommand[1]);
                        int sizeNew = localCollection.size();
                        check.checkChange(sizeOld, sizeNew);
                        control.setCollection(localCollection);
                        System.out.println("Выполнение завершено, продолжайте ввод");
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда введена неверно: проверьте наличие пробелов в {element} " +
                                "или количество аргументов команды, а также наличие полей объекта");
                    }catch (ChangeException e){
                        System.err.println("В коллекции отсутствует элемент меньше заданного, команда не выполнена");
                    }catch (EmptyCollectionException e){
                        System.err.println("В коллекции отсутствуют элементы");
                    }
                    break;
                case "add_if_max":
                    try{
                        check.checkLengthArraysOfTwo(finalUserCommand.length);
                        check.checkEmptyCollection(localCollection);
                        int sizeOld = localCollection.size();
                        localCollection = control.addIfMax.mainMethod(localCollection,initDate, finalUserCommand[1]);
                        int sizeNew = localCollection.size();
                        check.checkChange(sizeOld, sizeNew);
                        System.out.println("Выполнение завершено, продолжайте ввод");
                    }catch (ChangeException e){
                        System.err.println("Введенный элемент меньше либо равен по критерию сравнения" +
                                ", чем самый большой в коллекции, " +
                                "добавление не удалось");
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда введена неверно: проверьте наличие пробелов в {element} " +
                                "или количество аргументов команды, а также наличие полей объекта");
                    }catch (EmptyCollectionException e){
                        System.err.println("Коллекция, в которой вы сравниваете введенный объект с уже существующими пуста" +
                                " для начала заполните коллекцию");
                    }
                    break;
                case "add_if_min":
                    try{
                        check.checkLengthArraysOfTwo(finalUserCommand.length);
                        check.checkEmptyCollection(localCollection);
                        int sizeOld = localCollection.size();
                        localCollection = control.addIfMin.mainMethod(localCollection,initDate, finalUserCommand[1]);
                        int sizeNew = localCollection.size();
                        check.checkChange(sizeOld, sizeNew);
                        System.out.println("Выполнение завершено, продолжайте ввод");
                    }catch (ChangeException e){
                        System.err.println("Введенный элемент больше либо равен по критерию сравнения" +
                                ", чем самый минимальный в коллекции, " +
                                "добавление не удалось");
                    }catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда введена неверно: проверьте наличие пробелов в {element} " +
                                "или количество аргументов команды, а также наличие полей объекта");
                    }catch (EmptyCollectionException e){
                        System.err.println("Коллекция, в которой вы сравниваете введенный объект с уже существующими пуста" +
                                " для начала заполните коллекцию");
                    }
                    break;
                case "save":
                    localCollection = control.getCollection();
                    control.save.mainMethod(fileNameCollection, localCollection);
                    System.out.println("Выполнение команды завершено");
                    break;
                case "execute_script":
                    try {
                        check.checkLengthArraysOfTwo(finalUserCommand.length);
                        ArrayList<String> commandList = control.executeScript.mainMethod(finalUserCommand[1]
                                .replaceAll("\"", ""));
                        for (String userCommand : commandList) {
                            interactiveMod(userCommand);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }catch (ExitException e){
                        System.err.println("Файл не найден");
                    }
                    break;
                case "sort":
                    try {
                        check.checkEmptyCollection(localCollection);
                        check.checkLengthArraysOfOne(finalUserCommand.length);
                        ArrayList<Worker> listForSortSalary = new ArrayList<>(localCollection);
                        listForSortSalary.sort(sortSalary);
                        localCollection = new LinkedHashSet<>(listForSortSalary);
                        control.setCollection(localCollection);
                        System.out.println("Коллекция отсортирована по возрастанию Salary");
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.err.println("Команда введена неверно");
                    }catch (EmptyCollectionException e){
                        System.err.println("Коллекция пуста, сортировать нечего");
                    }
            }
        }catch (RightCommandException e){
            System.err.println("Данная команда не существует. Для справки введите: 'help'");
        }
    }
    /**
     * Метод запускающий работу программы
     */
    public void run(){
        try {
            LinkedHashSet<Worker> localCollectionRead = read.mainMethod(fileNameCollection);
            ArrayList<Worker> listSortId = new ArrayList<>(localCollectionRead);
            Collections.sort(listSortId);
            localCollectionRead = new LinkedHashSet<>(listSortId);
            control.setCollection(localCollectionRead);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Коллекция в файле повреждена либо отсутствует");
            flag = false;
        }catch (ExitException e){
            flag = false;
        }
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String userCommand = scanner.nextLine();
            interactiveMod(userCommand);

        }
    }
}
