package hu.nye.progtech.service.map.parser;

import hu.nye.progtech.model.MapVO;
import hu.nye.progtech.service.exceptions.MapParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MapParser {

    private final static Logger LOGGER = LoggerFactory.getLogger(MapParser.class.getName());

    private int numberOfRows;
    private int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    private int[][] getMap(List<String> rawMap) {
        if (rawMap.size() != this.numberOfRows) {
            LOGGER.error("Túl kevés sorból áll a tábla.");
            throw new MapParserException("Túl kevés sorból áll a tábla.");
        }
        int[][] result = new int[numberOfRows][];

        for(int i = 0; i < numberOfRows; i++) {
            result[i] = new int[numberOfColumns];

            String line = rawMap.get(i);
            if (line.length() != this.numberOfColumns) {
                throw new MapParserException("Az %d sor túl kevés oszlopból áll.".formatted(i));
            }
            String[] parts = line.split("");

            for(int j = 0; j < numberOfColumns; j++) {
                result[i][j] = Integer.parseInt(parts[j]);
            }
        }

        return result;
    }

    private boolean[][] getFixed(int[][] map) {
        boolean[][] result = new boolean[numberOfRows][];

        for (int i = 0; i < numberOfRows; i++) {
            result[i] = new boolean[numberOfColumns];

            for(int j = 0; j < numberOfColumns; j++) {
                result[i][j] = map[i][j] != 0;
            }
        }

        return result;
    }

    public MapVO parseMap(List<String> rawMap) {
        int[][] map = getMap(rawMap);
        boolean[][] fixed = getFixed(map);

        return new MapVO(numberOfRows, numberOfColumns, map, fixed);
    }
}
