
/**
 * @author Mikhin Nikita
 * Главный класс, через который программа начинает работу
 */
public class Main {
    public static void main(String[] args) {
        try {
            InputManager command = new InputManager("CollectionFile");
            command.run();
        }catch (NullPointerException e){
            System.err.println("Данная переменная окружения не существует");
        }
    }
}
