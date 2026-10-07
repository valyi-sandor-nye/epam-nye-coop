package hu.nye.progtech.service.map.validation;

import hu.nye.progtech.model.MapVO;
import hu.nye.progtech.service.exceptions.MapValidationException;

import java.util.HashSet;
import java.util.Set;

public class RowValidator implements MapValidatorInterface {
    @Override
    public void validate(MapVO map) throws MapValidationException {
        var lines = map.getMap();
        for (int i=0; i<lines.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<lines[i].length; j++) {
                if (lines[i][j] <= 0 || lines[i][j] > 9) {
                    throw new MapValidationException("Nem megfelelő érték (%d, %d): %d".formatted(i, j, lines[i][j]));
                } else {
                    set.add(lines[i][j]);
                }
            }
            if (set.size() < 9) {
                throw new MapValidationException("Ismétlődő szám a %d. sorban.".formatted(i));
            }
        }
    }
}
