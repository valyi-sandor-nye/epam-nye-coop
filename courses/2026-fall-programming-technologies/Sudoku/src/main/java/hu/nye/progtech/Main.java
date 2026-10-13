package hu.nye.progtech;

import hu.nye.progtech.config.GameConfig;
import hu.nye.progtech.event.GameEvent;
import hu.nye.progtech.event.GameEventPublisher;
import hu.nye.progtech.event.GameEventType;
import hu.nye.progtech.event.listener.AuditLoggerListener;
import hu.nye.progtech.event.listener.ConsoleEventPrinter;
import hu.nye.progtech.event.listener.ErrorCounter;
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

        GameConfig config = GameConfig.getInstance();

        GameEventPublisher publisher = new GameEventPublisher();
        ErrorCounter errorCounter = new ErrorCounter();
        publisher.subscribe(new ConsoleEventPrinter());
        publisher.subscribe(new AuditLoggerListener());
        publisher.subscribe(errorCounter);

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(config.getBeginnerMapPath());
//        InputStream inputStream = System.in;
        MapReaderInterface mapReader = getMapReaderInterface(inputStream);
        publisher.publish(new GameEvent(GameEventType.MAP_LOADED, "Debug: Beginner Map"));
        InputStream inputStream2nd = Main.class.getClassLoader().getResourceAsStream(config.getFirstMapPath());

        BufferedReader bufferedReader2nd = new BufferedReader(new InputStreamReader(inputStream2nd));
        MapReaderInterface mapReader2nd = new BufferedReaderMapReader(bufferedReader2nd);
        publisher.publish(new GameEvent(GameEventType.MAP_LOADED, " First Step Map"));
        try {
            List<String> rawMap = mapReader.readMap();
            List<String> rawMap2nd = mapReader2nd.readMap();

            MapParser mapParser = new MapParser(config.getNumberOfRows(), config.getNumberOfColumns());

            MapVO mapVO1 = mapParser.parseMap(rawMap);

            System.out.println("Elotte: " + mapVO1.getMap()[0][0]);
            mapVO1.getMap()[0][0] = 7;
            System.out.println("Utanna: " + mapVO1.getMap()[0][0]);

            MapVO ujTabla = mapVO1.withValue(0, 1, 7);
            System.out.println("ujTabla: " + ujTabla.getMap()[0][1]);


            MapVO mapVO2 = mapParser.parseMap(rawMap2nd);

            publisher.publish(new GameEvent(GameEventType.MAPS_COMPARED, "A táblák megegyeznek: " + mapVO1.equals(mapVO2)));

            new RowValidator().validate(mapVO1);

        } catch(MapReaderException | MapValidationException e) {
            publisher.publish(new GameEvent(GameEventType.VALIDATION_FAILED, e.getMessage()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            publisher.publish(new GameEvent(GameEventType.ERROR, e.getMessage()));
        }


        System.out.println("Hibak Szama " + errorCounter.getErrorCount());
    }

    private static MapReaderInterface getMapReaderInterface(InputStream inputStream) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        return new BufferedReaderMapReader(bufferedReader);
        return new ScannerMapReader(new Scanner(inputStream));
    }
}