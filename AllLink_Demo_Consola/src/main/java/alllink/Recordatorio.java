package alllink;

import java.util.ArrayList;
import java.util.List;

public class Recordatorio implements Subject {
    private final List<Observer> observadores = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notifyObservers(String mensaje) {
        for (Observer o : observadores) o.update(mensaje);
    }
}
