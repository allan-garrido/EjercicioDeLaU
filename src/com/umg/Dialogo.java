package com.umg;

import com.umg.clases.Asignatura;
import com.umg.clases.Estudiante;
import com.umg.clases.Profesor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class Dialogo extends JDialog {

    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2 = new DefaultTableModel();

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JTextField nombreProfesorTXT;
    private JTextField especialidadProfesorTXT;
    private JTextField nombreEstudianteTXT;
    private JTextField edadEstudianteTXT;
    private JTextField asignaturaNombreTXT;
    private JButton añadirButton;
    private JTable table1;
    private JButton eliminarButton;
    private JButton añadirButton1;
    private JButton añadirButton2;
    private JButton eliminarButton1;
    private JTable table2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField asignaturaNotaTXT;
    private JTextField asignaturaCantEvaluacionesTXT;
    private Profesor p = new Profesor();

    public Dialogo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("Nombre");
        tableModel.addColumn("Edad");
        table2.setModel(tableModel);

        tableModel2.addColumn("Materia");
        tableModel2.addColumn("Nota");
        tableModel2.addColumn("Evaluaciones");
        table1.setModel(tableModel2);

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
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        añadirButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        añadirButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                p.setNombre(nombreProfesorTXT.getText());
                p.setEspecialidad(especialidadProfesorTXT.getText());



                JOptionPane.showMessageDialog(null,p.getNombre()+" con especialidad: "+p.getEspecialidad());
            }
        });
        añadirButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                Estudiante e1 = new Estudiante();

                e1.setNombre(nombreEstudianteTXT.getText());
                e1.setEdad(Integer.parseInt(edadEstudianteTXT.getText()));

                p.addEstudiante(e1);

                //JOptionPane.showMessageDialog(null,e1.getNombre() + " " + e1.getEdad());

                //tableModel.addRow(new Object[]{e1.getNombre(), e1.getEdad()});

                //limpiando grid

                for (int i= tableModel.getRowCount()-1; i >=0; i--){
                    tableModel.removeRow(i);
                }

                for (Estudiante etemp:p.getEstudiantes()
                     ) {
                    tableModel.addRow(new Object[]{etemp.getNombre(), etemp.getEdad()});
                }


                nombreEstudianteTXT.setText("");
                edadEstudianteTXT.setText("");


            }
        });
        añadirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);


            }
        });
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                String existe;

                List<Estudiante> tempE = p.getEstudiantes();

                existe = tempE.get(table2.getSelectedRow()).getNombre();

                JOptionPane.showMessageDialog(null, "Agregue las notas de " + existe );
            // JOptionPane.showMessageDialog(null, table2.getValueAt(table2.getSelectedRow(),0));

                for (int i= tableModel2.getRowCount()-1; i >=0; i--){
                    tableModel2.removeRow(i);
                }

                for (Asignatura tempM:tempE.get(table2.getSelectedRow()).getMaterias()
                        ) {
                    tableModel2.addRow(new Object[]{tempM.getNombre(),tempM.getNota(),tempM.getCantEvaluaciones()});
                }
            }
        });
        añadirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                List<Estudiante> tempE = p.getEstudiantes();

                Asignatura tempA = new Asignatura(asignaturaNombreTXT.getText(), Integer.parseInt(asignaturaNotaTXT.getText()),Integer.parseInt(asignaturaCantEvaluacionesTXT.getText()));

                tempE.get(table2.getSelectedRow()).addMateria(tempA);

                for (int i= tableModel2.getRowCount()-1; i >=0; i--){
                    tableModel2.removeRow(i);
                }

                for (Asignatura tempM:tempE.get(table2.getSelectedRow()).getMaterias()
                        ) {
                    tableModel2.addRow(new Object[]{tempM.getNombre(),tempM.getNota(),tempM.getCantEvaluaciones()});
                }

                asignaturaNombreTXT.setText("");
                asignaturaNotaTXT.setText("");
                asignaturaCantEvaluacionesTXT.setText("");

                //System.out.println(p.getEstudiantes().get(table2.getSelectedRow()).getNombre());

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

    public static void main(String[] args) {
        Dialogo dialog = new Dialogo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
