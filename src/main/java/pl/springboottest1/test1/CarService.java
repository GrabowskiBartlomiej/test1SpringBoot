package pl.springboottest1.test1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> carList;

    public CarService(){
        this.carList = new ArrayList<>();
        carList.add(new Car("A4","Audi",2016));
        carList.add(new Car("320D","BMW",2006));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
