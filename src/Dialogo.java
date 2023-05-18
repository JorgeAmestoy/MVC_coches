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
     * Metodo en el que instancio ventana
     *
     */
    public static void ventanaDialogo() {
        Dialogo dialogo = new Dialogo();
        dialogo.pack();
        dialogo.eVelocidad.setText("COCHES");
        dialogo.setVisible(true);

    }
}
