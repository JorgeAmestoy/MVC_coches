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
        Dialogo.crearDialogo("La velocidad es: "+String.valueOf(v));
        return true;
    }

    /**
     * Metodo que muestra la velocidad
     * y que avisa si se ha superadp
     * @param matricula del coche
     * @param v velocidad
     * @return true si es verdadero
     */
    public static boolean mostrarVelocidad2(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        Dialogo.crearDialogo("Has superado!!");
        return true;
    }



}
