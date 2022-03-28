package WorkerClasses;
/**
 * Класс координат
 * */
public class Coordinates {
    /** Поле со значением координаты X */
    private int x;
    /** Поле со значением координаты Y */
    private Long y;
    /**
     * Метод для получения X
     * @return x возвращает значение координаты X
     * */
    public Integer getX(){
        return x;
    }
    /**
     * Метод для установки X
     *
     * @param x подаваемое значение X
     * */
    public void setX(Integer x){
        this.x = x;
    }
    /**
     * Метод для получения Y
     * @return y возвращает значение координаты Y
     * */
    public Long getY(){
        return y;
    }
    /**
     * Метод для установки Y
     *
     * @param y подаваемое значение Y
     * */
    public void setY(Long y){
        this.y = y;
    }
}