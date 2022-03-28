package Commands;

import Exceptions.ExitException;

import java.io.*;
import java.util.ArrayList;
/**
 * Класс для запуска скрипта
 */
public class ExecuteScript {
    /** Список, в котором хранятся команды */
    ArrayList<String> list = new ArrayList<>();
    /**
     * Основной метод класса ExecuteScript, реализующий его смысл
     *
     * @exception ExitException исключение проверки выхода
     * @param fileName имя файла, из которого считывается скрипт
     * @return list возвращаемый список строк файла
     */
    public ArrayList<String> mainMethod(String fileName) throws ExitException {
        try {
            String source = System.getenv("sourceOfFiles").replaceAll("\"", "");
            File file = new File(source, fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e){
            throw new ExitException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
