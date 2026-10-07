package hu.nye.progtech;

import hu.nye.progtech.model.MapVO;
import hu.nye.progtech.service.exceptions.MapReaderException;
import hu.nye.progtech.service.map.parser.MapParser;
import hu.nye.progtech.service.map.reader.BufferedReaderMapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReaderMapReader mapReader = new BufferedReaderMapReader(bufferedReader);

        InputStream inputStream2nd = Main.class.getClassLoader().getResourceAsStream("map/first_step.txt");
        BufferedReader bufferedReader2nd = new BufferedReader(new InputStreamReader(inputStream2nd));
        BufferedReaderMapReader mapReader2nd = new BufferedReaderMapReader(bufferedReader2nd);

        try {
            int numberOfRows = 9;
            int numberOfColumns = 9;

            List<String> rawMap = mapReader.readMap();
            List<String> rawMap2nd = mapReader2nd.readMap();

            MapParser mapParser = new MapParser(numberOfRows, numberOfColumns);

            MapVO mapVO1 = mapParser.parseMap(rawMap);

            MapVO mapVO2 = mapParser.parseMap(rawMap2nd);

            System.out.println(mapVO1.equals(mapVO2));

        } catch(MapReaderException e) {
            System.out.println(e.getMessage());
        }
    }
}