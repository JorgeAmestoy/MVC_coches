import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IU {
    private JPanel panel1;
    private JButton bCrear;
    private JButton bAumentar;
    private JButton bReducir;
    private JLabel eModelo;
    private JLabel eMatricula;
    private JTextField tModelo;
    private JTextField tMatricula;
    private JButton bBuscarCoche;

    /**
     * Constructor de la clase IU para inicializar botones y poder usar actionListener
     */
    public IU() {

        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.crearCoche(tModelo.getText(), tMatricula.getText());


            }
        });
        bAumentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.aumentarVelocidad(tMatricula.getText(),20);
            }
        });
        bReducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.reducirVelocidad(tMatricula.getText(),20);
            }
        });
        bBuscarCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.buscarCoche(tMatricula.getText());
            }
        });


    }

    /**
     * Metodo en el que instancio la ventana
     */
    public static void crearVentana() {
        JFrame frame = new JFrame("COCHES");
        frame.setContentPane(new IU().panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);//deja de runnear la app
    }


}
