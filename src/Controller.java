public class Controller {


    //creo una varibale de tipo Model para instanciar luego
    static Model miModelo;


    public static void main(String[] args) {

        //instancio clase observable (Model)
        miModelo = new Model();

        //instanciamos el observador
        ObserverVelocidad observoVelocidad = new ObserverVelocidad();
        //añado observador al modelo para que
        //que este nuevo objeto sea notificado de los cambios
        //en miModelo
        miModelo.addObserver(observoVelocidad);

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
        miModelo.reducirVelocidad(matricula,v);
    }
    /**
     * Metodo que llamando a Model aumenta la velocidad y que llamando al View nos lo muestra por pantalla
     * @param matricula del coche
     * @param v velocidad a aumentar
     */
    public static void aumentarVelocidad(String matricula, int v){

        miModelo.reducirVelocidad(matricula,v);
    }


}