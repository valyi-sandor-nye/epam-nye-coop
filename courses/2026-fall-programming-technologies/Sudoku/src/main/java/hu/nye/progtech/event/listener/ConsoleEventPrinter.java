package hu.nye.progtech.event.listener;

import hu.nye.progtech.event.GameEvent;
import hu.nye.progtech.event.GameEventListener;

public class ConsoleEventPrinter implements GameEventListener {

    @Override
    public void onEvent(GameEvent event) {
        System.out.println((event.message()));
    }
}
