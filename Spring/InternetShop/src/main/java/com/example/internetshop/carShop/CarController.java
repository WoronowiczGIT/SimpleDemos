package com.example.internetshop.carShop;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {

    private AtomicInteger idCounter= new AtomicInteger(1);

    private List<Car> cars = new ArrayList<>();

    @PostMapping
    public Car addCar(@Validated @RequestBody CreateCarDto carDto){
        Car car = Car.builder()
                .brand(carDto.getBrand())
                .id(idCounter.getAndIncrement())
                .mileage(carDto.getMileage())
                .model(carDto.getModel())
                .year(carDto.getYear())
                .build();

        cars.add(car);
        return car;
    }
    @GetMapping(value = "/all")
    public List<Car> showCars(){
        return cars;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Car showCar(@PathVariable int id){
        return cars.stream().filter(car -> car.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @RequestMapping(method = RequestMethod.DELETE, path ="/{id}")
    public Car deleteCar(@PathVariable Integer id){
        Car car = cars.stream().filter(c->c.getId().equals(id)).findAny().orElse(null);
        if(car != null)cars.remove(car);
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, path="/{id}")
    public Car updateCar(@Validated @RequestBody CreateCarDto carDto,@PathVariable Integer id){
        Car car = null;
        car = Car.builder()
                .year(carDto.getYear())
                .model(carDto.getModel())
                .mileage(carDto.getMileage())
                .brand(carDto.getBrand())
                .id(id)
                .build();

        Car oldCar = cars.stream().filter(c->c.getId().equals(id))
                .findAny()
                .orElse(null);

        if(car.getId().equals(oldCar.getId())){
            cars.remove(oldCar);
            cars.add(car);
        }
        return car;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/find/year/{year}")
    public List<Car> getByAge(@PathVariable Integer year){
        return cars.stream().filter(car -> car.getYear()
                .equals(year)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/find/brand/{brand}")
    public List<Car> getByBrand(@PathVariable Brand brand){
        return cars.stream().filter(car -> car.getBrand()
                .equals(brand)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/find/mileage/lessThen/{mileage}")
    public List<Car> getByBrand(@PathVariable Integer mileage){
        return cars.stream().filter(car -> car.getMileage() < mileage)
                .collect(Collectors.toList());
    }
}
