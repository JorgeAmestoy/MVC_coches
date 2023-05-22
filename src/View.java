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
}
