package Commands;

import WorkerClasses.Worker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
/**
 * Класс для сохранения коллекции
 */
public class SaveCommand {
    /**
     * Основной метод класса SaveCommand, реализующий его смысл
     * @param fileName место сохранения файла
     * @param hashSet коллекция, которую нужно сохранить
     */
    public void mainMethod(String fileName, LinkedHashSet<Worker> hashSet){
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for (Worker worker : hashSet){
                writer.write(worker.getStringCollection());
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
