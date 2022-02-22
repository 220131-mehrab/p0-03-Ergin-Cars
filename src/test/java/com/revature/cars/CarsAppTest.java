package com.revature.cars;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsAppTest {
    @Test
    //public void searchCarByNameTest(){
      public void givenCarName_ThenReturnCar(){
        List<BrandName> brandNames = CarsApp.loadCars();

        String searchCar = "Buick";
        //CarsApp carsApp = new CarsApp();
        String result = CarsApp.searchByName(searchCar,brandNames);
        //after typing this we will go back to main carsApp
        //and create a method which calls a car by givenName of the car
        assertEquals(searchCar,result);
    }

}