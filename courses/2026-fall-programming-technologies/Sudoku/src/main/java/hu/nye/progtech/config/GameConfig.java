package hu.nye.progtech.config;

public final class GameConfig {

    private static class Holder {
        private static final GameConfig INSTANCE = new GameConfig();
    }

    private final int numberOfRows = 9;
    private final int numberOfColumns = 9;
    private final String beginnerMapPath = "map/beginner.txt";
    private final String firstMapPath = "map/first_step.txt";

    private GameConfig() {
    }

    public static GameConfig getInstance() {
        return Holder.INSTANCE;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public String getBeginnerMapPath() {
        return beginnerMapPath;
    }

    public String getFirstMapPath() {
        return firstMapPath;
    }
}
