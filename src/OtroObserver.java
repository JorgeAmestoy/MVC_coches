import java.util.Observable;
import java.util.Observer;

public class OtroObserver implements Observer {
    /**
     * LLamamos a este cada vez que se produzca un cambio
     * El observable(Model) cuando hace el notifyObservers
     * activa los updates(actualizaciones) de los Observers
     * @param o  es el observable, el Model
     * @param arg es el coche actualizado, el arg pasado por
     *           el observable
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Yo tambien me enteré que la velocidad cambió en "+arg.toString());
    }
}
