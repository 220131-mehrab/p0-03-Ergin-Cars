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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRepository {
    private final List<BrandName> brandNames;
    private Connection connection;

    public CarRepository(String csvFile){
        brandNames = new ArrayList<>();
        parseBrandName(loadCSV(csvFile));
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<BrandName> getBrandNames() {
        return brandNames;
    }

    public void save(BrandName brandName){
        try{
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO cars VALUES(" + brandName.getCar() +", '" + brandName.getMpg()+ "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private BufferedReader loadCSV(String csvFile) {
        if (!csvFile.endsWith(".csv"))
            throw new IllegalArgumentException("Not a CSV File!");
        //URI uri = null;
       // try {
        URI uri = null;
        try {
            uri = Objects.requireNonNull(Objects.requireNonNull(CarsApp.class.getClassLoader().getResource(csvFile)).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Path filepath = Paths.get(Objects.requireNonNull(uri));
        try {
            return Files.newBufferedReader(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // parseBrandName(br);
//        } catch (URISyntaxException) {
//            System.err.println("Could not load the file");
         //   e.printStackTrace();
//        } catch (URISyntaxException | IOException e) {
//       //     e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    //List<BrandName> brandNames= new ArrayList<>();
//        try {
//
////            List<BrandName> brandNames= new ArrayList<>();
////            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
////            CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
////            //List<String[]>
////            List<String[]> lines = reader.readAll();
////            reader.close();
////            for (String[] columns : lines){
////                brandNames.add(new BrandName(columns[0],Integer.parseInt(columns[1])));
////            }
//
////            while (br.ready()) {
////                String line = br.readLine();
////                String[] columns = line.split(" ");
////                lines.add(columns[0]);
////            }
//            //lines =  Files.readAllLines(filepath, StandardCharsets.UTF_8);
//        } catch (IOException | CsvException e) {
//            System.err.println("OpenCSV Failed to parse!");
//            //e.printStackTrace();
//        }
    //return null;
    private void parseBrandName(BufferedReader br) {

        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
        //List<String[]>
        List<String[]> lines = null;
        try {
            lines = reader.readAll();
            reader.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        //
        for (String[] columns : lines) {
            brandNames.add(new BrandName(columns[0], Integer.parseInt(columns[1])));
        }
        //return brandNames;
    }

}
