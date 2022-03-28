package Commands;


import WorkerClasses.Status;
import WorkerClasses.Worker;

import java.util.ArrayList;
import java.util.LinkedHashSet;
/**
 * Класс для фильтрации коллекции
 */
public class FilterStatus {
    /**
     * Основной метод класса FilterStatus, реализующий его смысл
     *
     * @param hashSet коллекция, из которой вычисляются средние значения Salary
     * @param input критерий фильтрации
     * @return list отфильтрованная коллекция
     */
    public ArrayList<String> mainMethod(LinkedHashSet<Worker> hashSet, String input){
        ArrayList<String> list = new ArrayList<>();
        Status status = Status.valueOf(input);
        for (Worker worker : hashSet) {
            if (worker.getStatus().equals(status)) {
                list.add(worker.showValues());
            }
        }
        return list;
    }
}
