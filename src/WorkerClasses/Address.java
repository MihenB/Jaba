package WorkerClasses;
/**
 * Класс хранящий поля OrganizationAddress
 * */
public class Address {
    /** Поле названия улицы*/
    private String street; //Строка не может быть пустой, Поле может быть null
    /**
     * Метод, задающий название улицы
     *
     * @param street значение названия улицы
     * */
    public void setStreet(String street){
        this.street = street;
    }
    /**
     * Метод для получения значения названия улицы
     * @return street возврат названия улицы
     * */
    public String getStreet(){
        return street;
    }
}