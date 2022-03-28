package Commands;
import Utils.MethodsForCheckCommand;
import WorkerClasses.Worker;
import java.util.*;
/**
 * Класс для удаления элемента по id
 */
public class RemoveCommand {
    /**
     * Основной метод класса RemoveCommand, реализующий его смысл
     *
     * @param hashSet изменяемая коллекция
     * @param inputID id удаляемого элемента
     * @return hashSet возвращение изменённой коллекции
     */
    public LinkedHashSet<Worker> mainMethod(LinkedHashSet<Worker> hashSet,String inputID){
            int id = Integer.parseInt(inputID);
            Iterator<Worker> i = hashSet.iterator();
            List<Worker> list = new ArrayList<>(hashSet);
            while (i.hasNext()) {
                Worker worker1 = i.next();
                if (Objects.equals(worker1.getId(), id)) {
                    list.remove(worker1);
                    hashSet = new LinkedHashSet<>(list);
                    break;
                }
            }
        return hashSet;
        }


}
