package Controler;

import Models.Empleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import views.EmpleadoFrame;
import views.RegistroEmpleado;

public class EmpleadosController implements ActionListener, ItemListener {

    private RegistroEmpleado ra;
    private EmpleadoFrame aframe;
    private Empleados empleado;
    private int std;
    
    
    JFileChooser d;

    
    public EmpleadosController() {

    }

    public EmpleadosController(EmpleadoFrame frame) {
        d = new JFileChooser();
        aframe = frame;
    }

    public EmpleadosController(RegistroEmpleado reg) {
        ra = reg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Nuevo" ->
            {
                aframe.nuevo();
            }
            case "OPEN" -> {
                std = d.showOpenDialog(aframe);
                if (std == JFileChooser.APPROVE_OPTION) {
                    empleado = open(d.getSelectedFile());
                    aframe.openACT(empleado);
                } else if (std == JFileChooser.CANCEL_OPTION) {
                }
            }
            case "SAVE" -> {
                std = d.showSaveDialog(aframe);
                if (std == JFileChooser.APPROVE_OPTION) {
                    File file = d.getSelectedFile();
                    empleado = aframe.saveACT();
                    if (save(file)) {
                        JOptionPane.showMessageDialog(aframe, "Se ha guardado con exito");
                    }
                } else if (std == JFileChooser.CANCEL_OPTION) {
                }
            }
            case "Borrar" -> {
                //ra.clear();
                aframe.returRegistro().clear();
            }
            case "EXIT" -> {
                System.exit(0);
            }

        }
    } // fin de actionPerformed

    public boolean save(File file) {
        try {
            ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream(file));
            w.writeObject(empleado);
            w.flush();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public Empleados open(File file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return (Empleados) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}
