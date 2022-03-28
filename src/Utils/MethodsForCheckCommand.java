package Utils;

import Exceptions.*;
import WorkerClasses.OrganizationType;
import WorkerClasses.Position;
import WorkerClasses.Status;
import WorkerClasses.Worker;

import java.util.LinkedHashSet;

/**
 * Класс методов проверки внутри команд
 */
public class MethodsForCheckCommand {
    /**
     * Метод для проверки согласия пользователя
     *
     * @param agree значение для проверки
     */
    public void checkAgree(String agree){
        if (!(agree.equals("YES")) & !(agree.equals("NO"))){
            throw new IllegalArgumentException();
        }
    }
    /**
     * Метод для проверки формата имени
     *
     * @exception NameException исключение формата имени
     * @param name значение для проверки
     */
    public void nameCheck(String name) throws NameException {
        if (name.equals("")){
            throw new NameException();
        }
    }
    /**
     * Метод для проверки формата Salary
     *
     * @exception SalaryException исключение формата Salary
     * @param number значение для проверки
     */
    public void salaryCheck(Double number) throws SalaryException {
        if (number <= 0){
            throw new SalaryException();
        }
    }
    /**
     * Метод для проверки формата координаты X
     *
     * @exception CoordinatesException исключение формата Coordinates
     * @param xCoordinate значение для проверки
     */
    public void xCheck(int xCoordinate) throws CoordinatesException {
        if (xCoordinate <= -46){
            throw new CoordinatesException();
        }
    }
    /**
     * Метод для проверки формата координаты Y
     *
     * @exception CoordinatesException исключение формата Coordinates
     * @param yCoordinate значение для проверки
     */
    public void yCheck(Long yCoordinate) throws CoordinatesException {
        if (yCoordinate <= -836){
            throw new CoordinatesException();
        }
    }
    /**
     * Метод для проверки формата employeesCount при вводе значений
     *
     * @param employeesCount значение для проверки
     */
    public void checkOrganizationEmployeesCount(String employeesCount){
        if (!employeesCount.equals("")) {
            if (Long.parseLong(employeesCount) <= 0) {
                throw new NumberFormatException();
            }
        }
    }
    /**
     * Метод для проверки формата Id
     *
     * @exception IdException исключение формата id
     * @param input значение для проверки
     */
    public void checkId(String input) throws IdException {
        try {
            int id = Integer.parseInt(input);
            if (id <= 0) {
                throw new IdException();
            }
        }catch (NumberFormatException e){
            throw new IdException();
        }
    }
    /**
     * Метод для проверки формата position
     *
     * @exception PositionException исключение формата position
     * @param input значение для проверки
     */
    public void checkPosition(String input) throws PositionException {
        try{
            Position.valueOf(input);
        }catch(IllegalArgumentException e){
            throw new PositionException();
        }
    }
    /**
     * Метод для проверки формата status
     *
     * @exception StatusException исключение формата status
     * @param input значение для проверки
     */
    public void checkStatus(String input) throws StatusException{
        try{
            Status.valueOf(input);
        }catch (IllegalArgumentException e){
            throw new StatusException();
        }
    }
    /**
     * Метод для проверки формата employeesCount при чтении из файла
     *
     * @exception EmployerCountException исключение формата employeesCount
     * @param input значение для проверки
     */
    public void checkEmployerCount(String input) throws EmployerCountException{
        try{
            if (!input.equals("null") ) {
                Long.parseLong(input);
                if (Long.parseLong(input) <= 0) {
                    throw new EmployerCountException();
                }
            }
        }catch (NumberFormatException e){
            throw new EmployerCountException();
        }
    }
    /**
     * Метод для проверки формата organizationType
     *
     * @exception TypeException исключение формата organizationType
     * @param input значение для проверки
     */
    public void checkType(String input) throws TypeException {
        try {
            if (!input.equals("null") ) {
                OrganizationType.valueOf(input);
            }
        }catch (IllegalArgumentException e){
            throw new TypeException();
        }
    }
    /**
     * Метод для проверки формата address
     *
     * @exception AddressException исключение формата address
     * @param input значение для проверки
     */
    public void checkAddress(String input) throws AddressException {
        if (input.equals("null")){
            throw new AddressException();
        }
    }
    /**
     * Метод для проверки наличия повторяющихся id
     *
     * @exception IdException исключение формата id
     * @param hashSet коллекция для проверки
     */
    public void checkSameId(LinkedHashSet<Worker> hashSet) throws IdException {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (Worker worker : hashSet){
            set.add(worker.getId());
        }
        if (set.size() != hashSet.size()){
            throw new IdException();
        }
    }
}
