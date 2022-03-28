package Commands;

import WorkerClasses.Worker;

import java.util.ArrayList;
import java.util.LinkedHashSet;
/**
 * Класс для вывода элементов коллекции на экран
 */
public class ShowCommand {
    /**
     * Основной метод класса ShowCommand, реализующий его смысл
     *
     * @param hashSet коллекция, элементы которой выводятся на экран
     * @return list список значений элементов, выводимых на экран
     */
    public ArrayList<String> mainMethod(LinkedHashSet<Worker> hashSet) {
        ArrayList<String> list = new ArrayList<>();
        for (Worker worker : hashSet){
            list.add(worker.showValues());
            }
        return list;
        }
}
