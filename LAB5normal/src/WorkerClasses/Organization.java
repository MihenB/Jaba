package WorkerClasses;
/**
 * Класс данных организации
 * */
public class Organization {
    /** Поле для хранения employeesCount */
    private Long employeesCount;
    /** Поле для хранения organizationType */
    private OrganizationType type;
    /** Поле для хранения officialAddress */
    private Address officialAddress;

    /**
     * Метод для установки employeesCount
     * @param employeesCount задаваемое значение
     * */
    public void setEmployeesCount(Long employeesCount){
        this.employeesCount = employeesCount;
    }
    /**
     * Метод для установки organizationType
     * @param type задаваемое значение
     * */
    public void setType(OrganizationType type){
        this.type = type;
    }
    /**
     * Метод для установки address
     * @param officialAddress задаваемое значение
     * */
    public void setOfficialAddress(Address officialAddress){
        this.officialAddress = officialAddress;
    }
    /**
     * Метод для получения employeesCount
     * @return возвращает значение employeesCount
     * */
    public Long getEmployeesCount(){
        return employeesCount;
    }
    /**
     * Метод для получения type
     * @return возвращает organizationType
     * */
    public OrganizationType getType(){
        return type;
    }
    /**
     * Метод для получения address
     * @return возвращает officialAddress
     * */
    public String getOfficialAddress(){
        try {
            return officialAddress.getStreet();
        }catch (NullPointerException e){
            return "null";
        }
    }
    /**
     * Метод для проверки формата address
     *
     * @param address проверяемое значение
     * */
    public void checkAddress(String address){
        if (address.equals("")){
            throw new NullPointerException();
        }
    }
}
