package ExamenEjercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaConversor extends JFrame implements ActionListener {
    private JTextField stones, libras;
    private JLabel resultado;
    private JButton convertir;

    public VentanaConversor() {
        setTitle("Conversor Stones y Libras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(400, 250);
        setLocationRelativeTo(null);

        add(new JLabel("Stones:"));
        stones = new JTextField();
        add(stones);

        add(new JLabel("Libras:"));
        libras = new JTextField();
        add(libras);

        convertir = new JButton("CONVERTIR");
        add(convertir);

        resultado = new JLabel("Resultado: ");
        add(resultado);

        convertir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int stones = Integer.parseInt(this.stones.getText().trim());
            int libras = Integer.parseInt(this.libras.getText().trim());
            double resultado = Conversor.convertir(stones, libras);
            this.resultado.setText(String.format("Resultado: %.3f", resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce números enteros válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
