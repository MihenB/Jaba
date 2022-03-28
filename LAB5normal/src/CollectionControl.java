import Commands.*;
import WorkerClasses.Worker;

import java.util.LinkedHashSet;

public class CollectionControl {
    /** Поле для инициализации функционала класса HelpCommand */
    HelpCommand help = new HelpCommand();
    /** Поле для инициализации функционала класса InfoCommand */
    InfoCommand info = new InfoCommand();
    /** Поле для инициализации функционала класса ShowCommand */
    ShowCommand show = new ShowCommand();
    /** Поле для инициализации функционала класса AddCommand */
    AddCommand add = new AddCommand();
    /** Поле для инициализации функционала класса ClearCommand */
    ClearCommand clear = new ClearCommand();
    /** Поле для инициализации функционала класса UpdateCommand */
    UpdateCommand update = new UpdateCommand();
    /** Поле для инициализации функционала класса RemoveCommand */
    RemoveCommand remove = new RemoveCommand();
    /** Поле для инициализации функционала класса AverageSalary */
    AverageSalary average = new AverageSalary();
    /** Поле для инициализации функционала класса FilterStatus */
    FilterStatus filter = new FilterStatus();
    /** Поле для инициализации функционала класса UniqueStatusCommand */
    UniqueStatusCommand unique = new UniqueStatusCommand();
    /** Поле для инициализации функционала класса RemoveLowerCommand */
    RemoveLowerCommand removeLower = new RemoveLowerCommand();
    /** Поле для инициализации функционала класса AddIfMaxCommand */
    AddIfMaxCommand addIfMax = new AddIfMaxCommand();
    /** Поле для инициализации функционала класса AddIfMinCommand */
    AddIfMinCommand addIfMin = new AddIfMinCommand();
    /** Поле для инициализации функционала класса SaveCommand */
    SaveCommand save = new SaveCommand();
    /** Поле для инициализации функционала класса ExecuteScript */
    ExecuteScript executeScript = new ExecuteScript();
    /** Основная коллекция */
    private LinkedHashSet<Worker> workerHashSet = new LinkedHashSet<>();
    /**
     * Метод для получения коллекции
     * @return workerHashSet возвращает коллекцию
     * */
    public LinkedHashSet<Worker> getCollection(){
        return workerHashSet;
    }
    /**
     * Метод для записи коллекции
     * @param hashSet коллекция, которую нужно записать
     * */
    public void setCollection(LinkedHashSet<Worker> hashSet){
        this.workerHashSet = hashSet;
    }
}
