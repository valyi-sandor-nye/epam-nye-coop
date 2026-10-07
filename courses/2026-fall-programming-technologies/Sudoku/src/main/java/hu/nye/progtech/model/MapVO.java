package hu.nye.progtech.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVO {
    private int numberOfRows;
    private int numberOfColumns;
    private int[][] map;
    private boolean[][] fixed;

    public MapVO(int numberOfRows, int numberOfColumns, int[][] map, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = deepCopy(map);
        this.fixed = deepCopy(fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return map;
    }

    public boolean[][] getFixed() {
        return fixed;
    }

    private int[][] deepCopy(int[][] map) {
        int[][] result = new int[numberOfRows][];

        for(int i = 0; i < numberOfRows; i++) {
            result[i] = new int[numberOfColumns];

            for(int j = 0; j < numberOfColumns; j++) {
                result[i][j] = map[i][j];
            }
        }

        return result;
    }

    private boolean[][] deepCopy(boolean[][] map) {
        boolean[][] result = new boolean[numberOfRows][];

        for(int i = 0; i < numberOfRows; i++) {
            result[i] = new boolean[numberOfColumns];

            for(int j = 0; j < numberOfColumns; j++) {
                result[i][j] = map[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MapVO mapVO = (MapVO) o;

        return numberOfRows == mapVO.getNumberOfRows() &&
            numberOfColumns == mapVO.getNumberOfColumns() &&
                Arrays.deepEquals(map, mapVO.getMap()) &&
                Arrays.deepEquals(fixed, mapVO.getFixed());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result += Arrays.deepHashCode(map);
        result += Arrays.deepHashCode(fixed);

        return result;
    }
}
