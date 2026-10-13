package hu.nye.progtech.model;

import java.util.Arrays;
import java.util.Objects;

public final class MapVO {
    private final int numberOfRows;
    private final int numberOfColumns;
    private final int[][] map;
    private final boolean[][] fixed;

    private MapVO(Builder builder) {
        this.numberOfRows = builder.numberOfRows;
        this.numberOfColumns = builder.numberOfColumns;
        this.map = deepCopy(builder.map);
        this.fixed = deepCopy(builder.fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return deepCopy(map);
    }

    public boolean[][] getFixed() {
        return deepCopy(fixed);
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

    public MapVO withValue(int row, int column, int value) {
        int[][] newMap = deepCopy(map);
        newMap[row][column] = value;

        return builder()
                .withNumberOfRows(numberOfRows)
                .withNumberOfColumns(numberOfColumns)
                .withMap(newMap)
                .withFixed(fixed)
                .build();
    }

    public int getValue(int row, int column){
        return map[row][column];
    }

    public boolean getFixed(int row, int column){
        return fixed[row][column];
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private int numberOfRows;
        private int numberOfColumns;
        private int[][] map;
        private boolean[][] fixed;

        public Builder withNumberOfRows(int numberOfRows) {
            this.numberOfRows = numberOfRows;
            return this;
        }

        public Builder withNumberOfColumns(int numberOfColumns) {
            this.numberOfColumns = numberOfColumns;
            return this;
        }

        public Builder withMap(int[][] map) {
            this.map = map;
            return this;
        }

        public Builder withFixed(boolean[][] fixed) {
            this.fixed = fixed;
            return this;
        }

        public MapVO build() {
            if (numberOfRows <= 0 || numberOfColumns <= 0 ){
                throw new IllegalStateException("A tabla nem lehet kisseb mint nulla.");
            }

            if (map == null || fixed == null){
                throw new IllegalStateException("A map es a fixed nem lehet null.");
            }

            if (map.length != numberOfRows || fixed.length != numberOfRows)
            {
                throw new IllegalStateException("A tomb merete nem egyezi a megadott sorszammal.");
            }

            return new MapVO(this);
        }

    }
}
