import java.util.ArrayList;
import java.util.Observable;

/**
 * Hereda de Observale para poder usar los Notify
 * Usamos el Observer en el Model y así observar
 * los cambios en las variables
 *
 */
public class Model extends Observable {
    /**
     * ArrayList de tipo Coche en el que voy a guardar diferentes coches
     */
    static ArrayList<Coche> parking = new ArrayList<>();


    /**
     * Crea un coche y lo mete en el ArrayList parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Metodo que busca un coche según la matrícula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

/**
     //Metodo en el que cambio la velocidad
    public void cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;

        //anotamos el cambio
        setChanged();

        //notificamos a los observadores
        notifyObservers(getCoche(matricula));

        // ahora el metodo es void y no hace falta
        //retornar la velocidad porque vamos a usar
        //el patron observer
       // return getCoche(matricula).velocidad;
    }
   **/

    /**
     * Metodo que aumenta la velocidad del coche
     *
     * @param matricula matricula del coche
     * @param v km/h que queremos aumentar de velocidad
     * @return la velocidad actualizada
     */
    public void aumentarVelocidad(String matricula, Integer v){
        //busca el coche y aumenta la velocidad
       getCoche(matricula).velocidad = getCoche(matricula).velocidad+v;
       //anotamos cambio
       setChanged();
       //notifico a los observadores del cambio
       notifyObservers(getCoche(matricula));


    }

    /**
     * Metodo que reduce la velocidad del coche
     * @param matricula matricula del coche
     * @param v km/h que queremos reducir de velocidad
     * @return la velocidad actualizada
     */
    public void reducirVelocidad(String matricula, Integer v){
        //busca el coche y aumenta la velocidad
       getCoche(matricula).velocidad = getCoche(matricula).velocidad -v;
       //anotamos el cambio
       setChanged();
       //notificamos a los observadores del cambio
       notifyObservers(matricula);

    }

    /**
     * Metodo que me devuelve la velocidad según la matricula que escriba
     * @param matricula que escribo
     * @return velocidad según el coche
     */
    public static Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
