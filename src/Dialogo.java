import javax.swing.*;


public class Dialogo extends JDialog {
    private JPanel panel1;
    private JLabel eVelocidad;

    /**
     * Constructor de la clase Dialogo para instanciar componentes
     */
    public Dialogo() {
        setContentPane(panel1);
        setModal(true);
        setDefaultCloseOperation(1);
    }

    /**
     * Metodo en el que instancio la ventana dialogo
     *
     */
    public static void crearDialogo(String mensaje) {
        Dialogo dialogo = new Dialogo();
        dialogo.pack();
        dialogo.eVelocidad.setText("La velocidad es: "+mensaje);
        dialogo.setVisible(true);


    }
}
