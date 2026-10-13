package hu.nye.progtech.event.listener;

import hu.nye.progtech.event.GameEvent;
import hu.nye.progtech.event.GameEventListener;

import hu.nye.progtech.event.GameEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditLoggerListener implements GameEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditLoggerListener.class);

    @Override
    public void onEvent(GameEvent event){
        if (event.type() == GameEventType.ERROR) {
            LOGGER.error(event.message());
        } else if (event.type() == GameEventType.VALIDATION_FAILED) {
            LOGGER.warn(event.message());
        } else {
            LOGGER.info(event.message());
        }
    }
}
