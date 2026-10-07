package hu.nye.progtech.service.map.validation;

import hu.nye.progtech.model.MapVO;
import hu.nye.progtech.service.exceptions.MapValidationException;

public interface MapValidatorInterface {

    void validate(MapVO map) throws MapValidationException;

}
