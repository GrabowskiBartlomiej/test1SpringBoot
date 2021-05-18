package pl.springboottest1.test1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mark;
    private String model;
    private int yearOfProduction;
    public Car() {
    }

    public Car(String mark, String model, int yearOfProduction) {
        this.mark = mark;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
