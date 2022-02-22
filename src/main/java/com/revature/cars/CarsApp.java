package com.revature.cars;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarsApp {

    //static List<String> lines;

    public static void main(String[] args){
        //CarsApp carsApp = new CarsApp();
//        URI uri = null;
//        try {
//            uri = CarsApp.class.getClassLoader().getResource("cars.csv").toURI();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        Path filepath = Paths.get(uri);
        List<BrandName> brandNames = loadCars();
        //1. Loading the file to class loader. if you make a change to the file will not be reflected
        //here you have to restart the program and reload the file.
        //we are going to store it as an inputstream to use it everywhere and that will not make any changes on the file
        //InputStream carsFile = carsApp.class.getClassLoader().getResourceAsStream("cars.csv");
        //3. Now we need to create a path to the file for program to find where it is.
        //2. Reading the file. BufferReader is an option. Earlier we used scanner to read.

//        try {
//            lines =  Files.readAllLines(filepath, StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // lines.forEach(System.out::println);
        String searchCar = "Buick";
        System.out.println(searchByName(searchCar, brandNames));
        //for (String car : lines){
        //   if (car.contains(searchCar))
        //       System.out.println(car);
       // }
    }

    public static List<BrandName> loadCars(){
        URI uri = null;
        try {
            uri = CarsApp.class.getClassLoader().getResource("cars.csv").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Path filepath = Paths.get(uri);
        List<BrandName> brandNames= new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(filepath);
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
            //List<String[]>
            List<String[]> lines = reader.readAll();
            reader.close();
            for (String[] columns : lines){
                brandNames.add(new BrandName(columns[0],Integer.parseInt(columns[1])));
            }

//            while (br.ready()) {
//                String line = br.readLine();
//                String[] columns = line.split(" ");
//                lines.add(columns[0]);
//            }
            //lines =  Files.readAllLines(filepath, StandardCharsets.UTF_8);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return brandNames;
    }
    public static String searchByName(String searchCar, List<BrandName> brandNames) {
        for (BrandName car : brandNames) {
            if (car.getCar().equalsIgnoreCase(searchCar))
                return car.getCar();
        }
        return null;
    }
}
