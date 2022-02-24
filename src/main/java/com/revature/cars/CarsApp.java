package com.revature.cars;

import org.apache.catalina.LifecycleException;

public class CarsApp {

    //static List<String> lines;

    public static void main(String[] args) {
//        final String carCSVFile = "cars.csv";
//        BufferedReader br = CarsAppContext.loadCSV(carCSVFile);

        //CarsApp carsApp = new CarsApp();
//        URI uri = null;
//        try {
//            uri = CarsApp.class.getClassLoader().getResource("cars.csv").toURI();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        Path filepath = Paths.get(uri);
//        List<BrandName> brandNames = null;
//        try {
//            brandNames = CarsAppContext.parseBrandName(br);
//        } catch (IOException e) {
//            System.err.println("IOE exception");
//            //e.printStackTrace();
//        } catch (CsvException e) {
//            System.err.println("Could not parse the file");
//            //e.printStackTrace();
        //}
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
//      }

        // lines.forEach(System.out::println);
//        String searchCar = "Buick";
//        System.out.println(CarsAppContext.searchByName(searchCar, brandNames));
        CarsAppContext.build();

//        server.getConnector();
//        server.addContext("", null);

        try {
            CarsAppContext.getTomcat().start();
        } catch (LifecycleException e) {
            System.err.println("Server failed to start");
            //e.printStackTrace();
        }


        //for (String car : lines){
        //   if (car.contains(searchCar))
        //       System.out.println(car);
        // }
//    }
    }
}

