package pl.springboottest1.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarNormalController {

    @Autowired
    private CarService carService;
    @Autowired
    private CarRepo carRepo;

    @GetMapping("/formAddCar")
    public String formAdd() {
        return "add";
    }

    @GetMapping("/hi")
    public String hi() {
        return "redirect:/hello";
    }

    @PostMapping("/formAddCar")
    public String formSave(@RequestParam String mark, @RequestParam String model, @RequestParam int yop) {
        Car car = new Car(mark, model, yop);
        carRepo.save(car);
        return "redirect:/htmlAllDb";
    }

    @GetMapping("/htmlAllDb")
    public String showAll(Model model){
        model.addAttribute("cars", carRepo.findAll());
        return "showAll";
    }
}
