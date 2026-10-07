package hu.nye.progtech;

import hu.nye.progtech.model.MapVO;
import hu.nye.progtech.service.exceptions.MapReaderException;
import hu.nye.progtech.service.exceptions.MapValidationException;
import hu.nye.progtech.service.map.parser.MapParser;
import hu.nye.progtech.service.map.reader.BufferedReaderMapReader;
import hu.nye.progtech.service.map.reader.MapReaderInterface;
import hu.nye.progtech.service.map.reader.ScannerMapReader;
import hu.nye.progtech.service.map.validation.RowValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
//        InputStream inputStream = System.in;
        MapReaderInterface mapReader = getMapReaderInterface(inputStream);
        LOGGER.debug("Debug: Beginner Map");
        LOGGER.info("Beginner Map");
        InputStream inputStream2nd = Main.class.getClassLoader().getResourceAsStream("map/first_step.txt");
        BufferedReader bufferedReader2nd = new BufferedReader(new InputStreamReader(inputStream2nd));
        MapReaderInterface mapReader2nd = new BufferedReaderMapReader(bufferedReader2nd);
        LOGGER.info("First Step Map");
        try {
            int numberOfRows = 9;
            int numberOfColumns = 9;

            List<String> rawMap = mapReader.readMap();
            List<String> rawMap2nd = mapReader2nd.readMap();

            MapParser mapParser = new MapParser(numberOfRows, numberOfColumns);

            MapVO mapVO1 = mapParser.parseMap(rawMap);

            MapVO mapVO2 = mapParser.parseMap(rawMap2nd);

            System.out.println("A táblák megegyeznek: " + mapVO1.equals(mapVO2));

            new RowValidator().validate(mapVO1);

        } catch(MapReaderException | MapValidationException e) {
            System.out.println(e.getMessage());
            LOGGER.warn(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage());
        }
    }

    private static MapReaderInterface getMapReaderInterface(InputStream inputStream) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        return new BufferedReaderMapReader(bufferedReader);
        return new ScannerMapReader(new Scanner(inputStream));
    }
}