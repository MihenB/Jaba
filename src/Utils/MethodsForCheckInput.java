package Utils;

import Exceptions.*;
import WorkerClasses.Status;
import WorkerClasses.Worker;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
/**
 * Класс методов проверки ввода коллекции
 */
public class MethodsForCheckInput {
    /**
     * Метод для проверки наличия 1 аргумента команды
     * @param length значение для проверки
     */
    public void checkLengthArraysOfOne(Integer length){
        if (length != 1){
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    /**
     * Метод для проверки наличия 2 аргумента команды
     * @param length значение для проверки
     */
    public void checkLengthArraysOfTwo(Integer length){
        if (length != 2 ){
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    /**
     * Метод для проверки правильности команды
     * @exception RightCommandException исключение правильности команды
     * @param command значение для проверки
     */
    public void checkCommand(String command) throws RightCommandException {
        if (!(command.equals("help") | command.equals("info") | command.equals("show") | command.equals("add")
                | command.equals("update") | command.equals("remove_by_id") | command.equals("clear")
                | command.equals("save") | command.equals("execute_script") | command.equals("exit")
                | command.equals("add_if_max") | command.equals("add_if_min") | command.equals("remove_lower")
                | command.equals("average_of_salary") | command.equals("filter_by_status")
                | command.equals("print_unique_status") | command.equals("sort"))) {
            throw new RightCommandException();
        }
    }
    /**
     * Метод для проверки существования status в коллекции
     *
     * @exception ExistenceStatusException исключение существования статуса
     * @param hashSet проверяемая коллекция
     * @param input искомый статус
     */
    public void checkStatusExistence(LinkedHashSet<Worker> hashSet, String input) throws ExistenceStatusException {
        boolean verify = true;
        Status status = Status.valueOf(input);
        for (Worker worker : hashSet) {
            if (worker.getStatus().equals(status)) {
                verify = false;
                break;
            }
        }
        if (verify){
            throw new ExistenceStatusException();
        }
    }
    /**
     * Метод для проверки наличия уникальных status
     *
     * @exception UniqueStatusException исключение наличия уникальных статусов\
     * @param list значение для проверки
     */
    public void checkAvailabilityUniqueStatus(ArrayList<Status> list) throws UniqueStatusException {
        if (list.size() == 0){
            throw new UniqueStatusException();
        }
    }
    /**
     * Метод для проверки изменения размера коллекции
     *
     * @exception ChangeException исключение изменения размера коллекции\
     * @param lengthOld длина коллекции в предыдущем состоянии
     * @param lengthNew длина коллекции в новом состоянии
     */
    public void checkChange(int lengthOld, int lengthNew) throws ChangeException {
        if (lengthNew == lengthOld){
            throw new ChangeException();
        }
    }
    /**
     * Метод для проверки пустоты коллекции
     *
     * @exception EmptyCollectionException исключение пустоты коллекции\
     * @param hashSet коллекция для проверки
     */
    public void checkEmptyCollection(LinkedHashSet<Worker> hashSet) throws EmptyCollectionException {
        if (hashSet.size() == 0){
            throw new EmptyCollectionException();
        }
    }
    /**
     * Метод для проверки наличия элемента с данным id
     *
     * @param inputID id для проверки
     * @param checkSet коллекция для проверки
     */
    public void checkVolumeId(String inputID, LinkedHashSet<Worker> checkSet){
        int id = Integer.parseInt(inputID);
        boolean checkId = true;
        for (Worker worker : checkSet) {
            if (Objects.equals(id, worker.getId())) {
                checkId = false;
                break;
            }
        }
        if (checkId){
            throw new IllegalArgumentException();
        }
    }
}
