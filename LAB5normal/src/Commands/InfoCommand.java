package Commands;
import WorkerClasses.Worker;

import java.util.Date;
import java.util.LinkedHashSet;
/**
 * Класс для вывода информации по коллекции
 */
public class InfoCommand {
    /**
     * Основной метод класса InfoCommand, реализующий его смысл
     *
     * @param hashSet коллекция, по которой выводится информация
     * @param unitDate дата инициализации коллекции
     * @return информация о коллекции
     */
    public String mainMethod(LinkedHashSet<Worker> hashSet, Date unitDate) {
        return ("Тип коллекции: " + hashSet.getClass() +
                "\nДата инициализации: " + unitDate +
                "\nКоличество элементов: " + hashSet.size());
    }
}
