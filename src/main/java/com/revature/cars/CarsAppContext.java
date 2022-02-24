package com.revature.cars;

//import com.opencsv.CSVParser;
//import com.opencsv.CSVParserBuilder;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
//import com.opencsv.exceptions.CsvException;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;

import jakarta.servlet.http.HttpServlet;
import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarsAppContext {
    private static final String carCSVFile = "cars.csv";
    private static CarRepository carRepository;
    private static CarService carService;
    private static Tomcat server;
    private static CarController carController;
    private static Connection connection;

//    static BufferedReader br;
//    static List<BrandName> brandNames;

    public static void build() {
        carRepository = new CarRepository(carCSVFile);
        carService = new CarService(carRepository);
        carController = new CarController();
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "carsServlet", carController).addMapping("/brandNames");
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:","cars","cars");
            connection.createStatement().execute("CREATE TABLE CARS(car varchar(255) primary key, mpg int)");
            carRepository.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        loadCSV(carCSVFile);
//        try {
//            parseBrandName();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (CsvException e) {
//            e.printStackTrace();
//        }
    }

    public static CarRepository getCarRepository() {
        return carRepository;
    }

    public static CarService getCarService() {
        return carService;
    }

    public static Tomcat getTomcat(){
        return server;
    }
}
