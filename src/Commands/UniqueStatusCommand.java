package Commands;

import WorkerClasses.Status;
import WorkerClasses.Worker;
import java.util.ArrayList;
import java.util.LinkedHashSet;
/**
 * Класс для вывода уникальных status
 */
public class UniqueStatusCommand {
    /**
     * Основной метод класса UniqueStatusCommand, реализующий его смысл
     *
     * @param hashSet коллекция для обработки
     * @return uniqueStatusCollection список уникальных Status
     */
    public ArrayList<Status> mainMethod(LinkedHashSet<Worker> hashSet){
            ArrayList<Status> uniqueStatusCollection = new ArrayList<>();
            for (Worker worker1 : hashSet) {
                int count = 0;
                Status status = worker1.getStatus();
                for (Worker worker2 : hashSet) {
                    if (status.equals(worker2.getStatus())) {
                        count++;
                    }
                }
                if (count == 1) {
                    uniqueStatusCollection.add(status);
                }
            }
            return uniqueStatusCollection;
    }
}
