package ExamenEjercicio1B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConversor extends JFrame implements ActionListener {
    private JTextField pies, pulgadas;
    private JLabel resultado;
    private JButton convertir;

    public VentanaConversor() {
        setTitle("Conversor Pies y Pulgadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(400, 250);
        setLocationRelativeTo(null);

        add(new JLabel("Pies:"));
        pies = new JTextField();
        add(pies);

        add(new JLabel("Pulgadas:"));
        pulgadas = new JTextField();
        add(pulgadas);

        convertir = new JButton("CONVERTIR");
        add(convertir);

        resultado = new JLabel("Resultado: ");
        add(resultado);

        convertir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int pies = Integer.parseInt(this.pies.getText().trim());
            int pulgadas = Integer.parseInt(this.pulgadas.getText().trim());
            double resultado = Conversor.convertir(pies, pulgadas);
            this.resultado.setText(String.format("Resultado: %.2f", resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce números enteros válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
