import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer {
    /**
     * LLamamos a este cada vez que se produzca un cambio
     * El observable(Model) cuando hace el notifyObservers
     * activa los updates(actualizaciones) de los Observers
     * Si la velocidad supera 120 llamo a View para mostrar aviso
     * @param o  es el observable, el Model
     * @param arg es el coche actualizado, el arg pasado por
     *           el observable
     */
    @Override
    public void update(Observable o, Object arg) {
        //hay que castear el Objeto a tipo Coche
        Coche auxCoche = (Coche) arg;
        if(auxCoche.velocidad > 120){
            View.mostrarVelocidad2(auxCoche.matricula, auxCoche.velocidad);
        }

    }




}
