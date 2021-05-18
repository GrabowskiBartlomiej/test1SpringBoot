package pl.springboottest1.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/getCars")
    public List<Car> getCars(){
        return carService.getCarList();
    }

    @GetMapping("/addCar")
    public Car addCar(@RequestParam String mark, String model, int yop){
        Car car = new Car(mark,model,yop);
        carRepo.save(car);
        return car;
    }

    @GetMapping("/addFromTheList")
    public void addAll(HttpServletResponse response) throws IOException {
        List<Car> cars = carService.getCarList();
        for(Car car : cars){
            carRepo.save(car);
        }
        response.sendRedirect("/allFromDb");
    }

    @GetMapping("/allFromDb")
    public List<Car> allFromDb(){
        return carRepo.findAll();
    }
}
