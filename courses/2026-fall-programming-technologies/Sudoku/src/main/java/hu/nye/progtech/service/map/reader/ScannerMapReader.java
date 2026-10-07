package hu.nye.progtech.service.map.reader;

import hu.nye.progtech.service.exceptions.MapReaderException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerMapReader implements MapReaderInterface {

    private final Scanner scanner;

    public ScannerMapReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> readMap() throws MapReaderException {
        scanner.useDelimiter("\\n");
        List<String> result = new ArrayList<>();
        int i = 0;
        while (scanner.hasNext() && i++ < 9) {
            result.add(scanner.nextLine());
        }
        return result;
    }
}
