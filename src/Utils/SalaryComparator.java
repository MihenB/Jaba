package Utils;

import Exceptions.ExitException;
import WorkerClasses.Worker;

import java.util.Comparator;
/**
 * Класс, задающий условие для сравнения
 */
public class SalaryComparator implements Comparator<Worker> {
    /**
     * Переопределённый метод для сравнения Salary
     *
     * @param obj1 первый объект сравнения
     * @param obj2 второй объект сравнения
     * @return результат сравнения для Comparable
     */
    @Override
    public int compare(Worker obj1, Worker obj2) {
        return (int) (obj1.getSalary() - obj2.getSalary());
    }
}
