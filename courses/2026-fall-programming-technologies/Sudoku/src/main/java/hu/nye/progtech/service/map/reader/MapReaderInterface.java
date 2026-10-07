package hu.nye.progtech.service.map.reader;

import hu.nye.progtech.service.exceptions.MapReaderException;

import java.util.List;

public interface MapReaderInterface {
    List<String> readMap() throws MapReaderException;
}
