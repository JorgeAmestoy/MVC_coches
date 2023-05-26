import java.util.Observable;
import java.util.Observer;

//implemento Interfaz Observer para usar método update
public class ObserverVelocidad implements Observer {

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
        //hay que castear el Objeto a tipo Coche
        Coche auxCoche = (Coche) arg;
        System.out.println("Se ha cambiado la velocidad a"+auxCoche.velocidad.toString()+ "km/h");
        //llamamos a View para que muestra la velocidad
        View.mostrarVelocidad(auxCoche.matricula, auxCoche.velocidad);

        //en este metodo tambien accedemos al observable(el model),
        //por lo que tenemos acceso al ArrayList de parking

    }
}
