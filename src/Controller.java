public class Controller {



    /**
     * Metodo main con el que llamo a la vista para visualizar ventana
     * @param args
     */
    public static void main(String[] args) {

        View.crearVentana();

    }

    /**
     *Metodo que crea coche y muestra la velocidad de este
     * @param modelo del coche
     * @param matricula del coche
     */
    public static void crearCoche(String modelo, String matricula) {
        Coche aux = Model.crearCoche(modelo, matricula);
        if (aux != null) {
            View.mostrarVelocidad(aux.matricula, aux.velocidad);

        }


    }

    /**
     * Metodo que llamando a Model baja la velocidad y que llamando al View nos lo muestra por pantalla
     * @param matricula del coche
     * @param v velocidad a reducir
     */
    public static void reducirVelocidad(String matricula, int v){
        int aux = Model.reducirVelocidad(matricula,v);
        View.mostrarVelocidad(matricula,aux);
    }
    /**
     * Metodo que llamando a Model aumenta la velocidad y que llamando al View nos lo muestra por pantalla
     * @param matricula del coche
     * @param v velocidad a aumentar
     */
    public static void aumentarVelocidad(String matricula, int v){

        int aux = Model.aumentarVelocidad(matricula,v);
        View.mostrarVelocidad(matricula,aux);
    }


}