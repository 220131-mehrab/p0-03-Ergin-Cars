package com.revature.cars;

public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    public String searchByName(String searchCar) {
        for (BrandName car : carRepository.getBrandNames()) {
            if (car.getCar().equalsIgnoreCase(searchCar))
                return car.getCar();
        }
        return null;
    }
    public void saveCar(BrandName brandName) {
        carRepository.save(brandName);

    }
}
