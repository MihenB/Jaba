package WorkerClasses;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс, объекты которого помещаются в коллекцию
 */
public class Worker implements Comparable<Worker> {
    /** Поле, хранящее id */
    private Integer id;
    /** Поле, хранящее имя объекта */
    private String name;
    /** Поле, хранящее координаты объекта */
    private Coordinates coordinates;
    /** Поле, хранящее дату создания объекта */
    private java.util.Date creationDate;
    /** Поле, хранящее salary объекта */
    private Double salary;
    /** Поле, хранящее дату начала работы объекта */
    private java.util.Date startDate;
    /** Поле, хранящее position объекта */
    private Position position;
    /** Поле, хранящее status объекта */
    private Status status;
    /** Поле, хранящее organization объекта */
    private Organization organization;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Конструктор - пустой конструктор для создания экземпляра класса без параметров
     */
    public Worker(){

    }
    /**
     * Конструктор - конструктор для создания экземпляра класса с параметрами
     * @see Worker#Worker(String, Coordinates, Double, Date, Position, Status, Organization)
     * @param name имя
     * @param coordinates координаты
     * @param salary salary
     * @param startDate дата начала работы
     * @param position позиция
     * @param status статус работника
     * @param organization организация
     */
    public Worker(String name, Coordinates coordinates, Double salary, java.util.Date startDate,
                  Position position, Status status, Organization organization){
        this.name = name;
        this.coordinates = coordinates;
        this.salary = salary;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }
    /**
     * Переопределенный метод Comparable
     * @param obj объект для сравнения
     * */
    @Override
    public int compareTo(Worker obj) {
        return this.getId() - obj.getId();
    }
    /**
     * Метод для строкового представления объекта с его полями с последующим выводом на экран
     * @return возвращает строковое представление объекта
     * */
    public String showValues() {
        return "Worker [id=" + id
                + ", Name=" + name
                + ", coordinatesX=" + coordinates.getX()
                + ", coordinatesY=" + coordinates.getY()
                + ", creationDate=" + dateFormat.format(creationDate)
                + ", salary=" + salary
                + ", startDate=" + dateFormat.format(startDate)
                + ", position=" + position
                + ", status=" + status
                + ", organizationEmployeesCount=" + organization.getEmployeesCount()
                + ", organizationType=" + organization.getType()
                + ", organizationOfficialAddress=" + organization.getOfficialAddress()
                + "]";
    }
    /**
     * Метод для строкового представления объекта с его полями с последующей записью в файл
     * @return возвращает строковое представление объекта для записи в файл
     * */
    public String getStringCollection(){
        return "{id=" + id
                + ",Name=" + name
                + ",coordinatesX=" + coordinates.getX()
                + ",coordinatesY=" + coordinates.getY()
                + ",creationDate=" + dateFormat.format(creationDate)
                + ",salary=" + salary
                + ",startDate=" + dateFormat.format(startDate)
                + ",position=" + position
                + ",status=" + status
                + ",organizationEmployeesCount=" + organization.getEmployeesCount()
                + ",organizationType=" + organization.getType()
                + ",organizationOfficialAddress=" + organization.getOfficialAddress()
                + "}";
    }
    /**
     * Получает id объекта
     * @return id
     */
    public Integer getId(){
        return id;
    }
    /**
     * Устанавливает
     * @param id объекту
     */
    public void setId(Integer id){
        this.id = id;
    }
    /**
     * Получает name объекта
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * Получает salary объекта
     * @return salary
     */
    public double getSalary(){
        return salary;
    }
    /**
     * Получает status объекта
     * @return status
     */
    public Status getStatus(){
        return status;
    }
    /**
     * Устанавливает name объекту
     * @param name объекту
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Устанавливает salary объекту
     * @param salary объекту
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
    /**
     * Устанавливает startDate объекту
     * @param startDate объекту
     */
    public void setStartDate(java.util.Date startDate){
        this.startDate = startDate;
    }
    /**
     * Устанавливает position объекту
     * @param position объекту
     */
    public void setPosition(Position position){
        this.position = position;
    }
    /**
     * Устанавливает status объекту
     * @param status объекту
     */
    public void setStatus(Status status){
        this.status = status;
    }
    /**
     * Устанавливает organization объекту
     * @param organization объекту
     */
    public void setOrganization(Organization organization){
        this.organization = organization;
    }
    /**
     * Устанавливает
     * @param coordinates объекту
     */
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    /**
     * Устанавливает
     * @param creationDate объекту
     */
    public void setCreationDate(java.util.Date creationDate){
        this.creationDate = creationDate;
    }


}







