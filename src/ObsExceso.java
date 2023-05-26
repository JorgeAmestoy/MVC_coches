import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer {
    /**
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        //hay que castear el Objeto a tipo Coche
        Coche auxCoche = (Coche) arg;
        System.out.println("Yo también me entero del cambio! "+auxCoche.velocidad.toString());
        //llamamos a View para que muestra la velocidad
        View.mostrarVelocidad(auxCoche.matricula, auxCoche.velocidad);
        //en este metodo tambien accedemos al observable(el model),
        //por lo que tenemos acceso al ArrayList de parking

    }
}
