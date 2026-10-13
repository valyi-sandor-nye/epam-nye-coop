package hu.nye.progtech.event.listener;

import hu.nye.progtech.event.GameEvent;
import hu.nye.progtech.event.GameEventListener;
import hu.nye.progtech.event.GameEventType;

public class ErrorCounter implements GameEventListener {

    private int errorCount = 0;

    @Override
    public void onEvent(GameEvent event) {
        if (event.type() == GameEventType.ERROR || event.type() == GameEventType.VALIDATION_FAILED) {
            errorCount ++;
        }
    }

    public int getErrorCount() {
        return errorCount;
    }
}
