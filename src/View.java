public class View {
    /**
     * Constructor de la ventana
     */
    public static void crearVentana(){
        IU.crearVentana();
        //Dialogo.mostrarCoche();
    }

    /**
     * Metodo que me muestra la velocidad al crear coche
     * @param matricula del coche
     * @param v velocidad
     * @return true
     */
   public static boolean mostrarVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        Dialogo.crearDialogo(String.valueOf(v));
        return true;
    }

    /**
     * Metodo que muestra el coche buscado
     * @param matricula del coche buscado
     * @param modelo del coche
     * @param v velocidad del coche
     * @return true
     */
    public static boolean mostrarCoche(String matricula, String modelo, Integer v){
       String msg = "Coche con matricula: "+matricula+ ", Modelo: "+modelo+ " y Velocidad: "+v+ " km/h";
        System.out.println(msg);
        Dialogo.crearDialogo(msg);
        return true;
    }


}
