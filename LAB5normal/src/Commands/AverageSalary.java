package Commands;

import WorkerClasses.Worker;

import java.util.LinkedHashSet;
/**
 * Класс для расчёта среднего salary
 */
public class AverageSalary {
    /**
     * Основной метод класса AverageSalary, реализующий его смысл
     *
     * @param hashSet коллекция, из которой вычисляются средние значения Salary
     * @return avgSalary среднее значение Salary данной коллекции
     */
    public double mainMethod(LinkedHashSet<Worker> hashSet){
        double avgSalary = 0.0d;
        int count = 0;
        for (Worker worker : hashSet){
            count++;
            avgSalary += worker.getSalary();
        }
        avgSalary /= count;
        return avgSalary;
    }
}
