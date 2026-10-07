package hu.nye.progtech.service.map.reader;

import hu.nye.progtech.service.exceptions.MapReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderMapReader implements MapReaderInterface {
    BufferedReader bufferedReader;

    public BufferedReaderMapReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> readMap() throws MapReaderException {
        String line;

        List<String> result = new ArrayList<>();

        try {
            while((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch(IOException e) {
            throw new MapReaderException(e.getMessage());
        }

        return result;
    }
}
