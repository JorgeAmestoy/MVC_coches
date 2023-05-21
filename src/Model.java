import java.util.ArrayList;

public class Model {
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
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Metodo llamado getCoche(recibeCoche) que buscar y recibe coche segun la matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }


     //Metodo en el que cambio la velocidad
   /**
    public Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }
    **/

    /**
     * Metodo en el que escribiendo la matricula hacemos que suba la velocidad
     * @param matricula matricula del coche
     * @param v km/h que queremos aumentar de velocidad
     * @return la velocidad actualizada
     */


    public Integer aumentarVelocidad(String matricula, int v){

        getCoche(matricula).velocidad=v+getCoche(matricula).velocidad;

        return  getCoche(matricula).velocidad;


    }

    /**
     * Escribiendo la matricula hacemos que baje la velocidad 20km/hora
     * @param matricula matricula del coche
     * @param v km/h que queremos reducir de velocidad
     * @return la velocidad actualizada
     */
    public Integer reducirVelocidad(String matricula, int v){

        getCoche(matricula).velocidad=getCoche(matricula).velocidad-v;

        return  getCoche(matricula).velocidad;

    }

    /**
     * Metodo que me devuelve la velocidad según la matricula que escriba
     * @param matricula que escribo
     * @return velocidad según el coche
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
