package Commands;
import WorkerClasses.Worker;
import java.util.LinkedHashSet;
/**
 * Класс для очистки коллекции
 */
public class ClearCommand {
    /**
     * Основной метод класса ClearCommand, реализующий его смысл
     *
     * @param hashSet коллекция, из которой вычисляются средние значения Salary
     * @return hashSet возвращаемая очищенная коллекция
     */
    public LinkedHashSet<Worker>mainMethod(LinkedHashSet<Worker> hashSet){
        hashSet.clear();
        return hashSet;
    }
}
