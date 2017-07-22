package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class docente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JTextField edad;
    private JTextField nombre;
    private JTextField curso;
    private JButton adicionarButton;
    private JButton borrarButton;
    private JButton regresarButton;
    private JTextField trabajadores;
    private JComboBox comboBox1;
    private JTextField cantidadCursos;
    private JComboBox comboBox2;


    private DefaultTableModel model;

    public docente() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

            model=new DefaultTableModel();
            model.addColumn("nombre Del estudiandte");
            model.addColumn("Curso ");
            model.addColumn("Edad");
            model.addColumn("Grado académico actual");
            model.addColumn("Ha recibido cursos en Intecap anteriormente");
            model.addColumn("Cuantos?");
            table1.setModel(model);





        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom=nombre.getText();
                String direc= curso.getText();
                int eda=Integer.parseInt(edad.getText());//cantidad de comesalesind
                String trabajador= trabajadores.getText();
                int cantidad= Integer.parseInt(cantidadCursos.getText());

                nombre.setText("");
                edad.setText("");
                curso.setText("");
                trabajadores.setText("");
                comboBox1.setSelectedItem(1);
               boolean selec;
                //selec=comboBox1.getSelectedItem();
                String agregar, agregar2=new String();
                agregar =(String)comboBox1.getSelectedItem();
                //agregar2 =(String)comboBox2.getSelectedItem();


                model.addRow(new Object[]{nom,direc,eda, trabajador, agregar, cantidad});
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel dtm = (DefaultTableModel) table1.getModel(); //TableProducto es el nombre de mi tabla ;)
                dtm.removeRow(table1.getSelectedRow());







            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                principal doc = new principal();

                doc.pack();
                doc.setLocationRelativeTo(null);
                dispose();
                doc.setVisible(true);













            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
