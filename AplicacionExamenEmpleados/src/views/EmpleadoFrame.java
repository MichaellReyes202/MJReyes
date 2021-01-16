package views;

import Controler.EmpleadosController;
import Models.Empleados;

public class EmpleadoFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private RegistroEmpleado registro = new RegistroEmpleado(this);

    public void nuevo()
    {
        ShowChild(registro,true);
    }
    
    public void openACT(Empleados auto) {
        registro.setAutoData(auto);
    }

    public Empleados saveACT() {
        Empleados auto = registro.getAutoData();
        return auto;
    }

    public RegistroEmpleado setRegistro() {
        return registro;
    }

    // constructor 
    public EmpleadoFrame() {
        initComponents();
        setLocationRelativeTo(null);
        ShowChild(registro, true);
        setupController();

    }

    public void setupController() {
        EmpleadosController ac = new EmpleadosController(EmpleadoFrame.this);
        JM_Open.addActionListener(ac);
        JM_Save.addActionListener(ac);
        JM_Exit.addActionListener(ac);
        JB_Clear.addActionListener(ac);
        JM_New.addActionListener(ac);
        
    }

    public void EditJMenu(boolean B) {
        //JM_Save.setEnabled(B);
    }

    public RegistroEmpleado returRegistro() {
        return registro;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pantalla = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAutoFrame = new javax.swing.JMenu();
        JM_New = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        JM_Open = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JM_Save = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JM_Exit = new javax.swing.JMenuItem();
        JB_Clear = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Vihicular");
        setAlwaysOnTop(true);

        javax.swing.GroupLayout PantallaLayout = new javax.swing.GroupLayout(Pantalla);
        Pantalla.setLayout(PantallaLayout);
        PantallaLayout.setHorizontalGroup(
            PantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        PantallaLayout.setVerticalGroup(
            PantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        MenuAutoFrame.setText("File");
        MenuAutoFrame.setActionCommand("Borrar");

        JM_New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JM_New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/new.PNG"))); // NOI18N
        JM_New.setText("New");
        JM_New.setActionCommand("Nuevo");
        JM_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JM_NewActionPerformed(evt);
            }
        });
        MenuAutoFrame.add(JM_New);
        MenuAutoFrame.add(jSeparator3);

        JM_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JM_Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/open.PNG"))); // NOI18N
        JM_Open.setText("Open File");
        JM_Open.setActionCommand("OPEN");
        MenuAutoFrame.add(JM_Open);
        MenuAutoFrame.add(jSeparator2);

        JM_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JM_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save.PNG"))); // NOI18N
        JM_Save.setText("Save File");
        JM_Save.setActionCommand("SAVE");
        MenuAutoFrame.add(JM_Save);
        MenuAutoFrame.add(jSeparator1);

        JM_Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JM_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/exit.PNG"))); // NOI18N
        JM_Exit.setText("Exit");
        JM_Exit.setActionCommand("EXIT");
        MenuAutoFrame.add(JM_Exit);

        JB_Clear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JB_Clear.setText("Borrar");
        MenuAutoFrame.add(JB_Clear);

        jMenuBar1.add(MenuAutoFrame);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pantalla)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pantalla)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JM_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JM_NewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JM_NewActionPerformed

    public void ShowChild(javax.swing.JInternalFrame frame, boolean maximizeFrame) {
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        int xy[] = getPosition(frame);
        Pantalla.add(frame);
        frame.setLocation(xy[0], xy[1]);
        frame.setVisible(true);
        if (maximizeFrame) {
            Pantalla.getDesktopManager().maximizeFrame(frame);
        }
        setCursor(java.awt.Cursor.getDefaultCursor());
    }

    // Calculala posicion que deberia de ubicarse un formulario.
    // basado en las dimenciones para que aparezca centrado en el JDesktop
    public int[] getPosition(javax.swing.JInternalFrame inter) {
        int position[] = new int[2];
        position[0] = (Pantalla.getWidth() - inter.getWidth()) / 2;
        position[1] = (Pantalla.getHeight() - inter.getHeight()) / 2;

        return position;
    }
    //

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JB_Clear;
    private javax.swing.JMenuItem JM_Exit;
    private javax.swing.JMenuItem JM_New;
    private javax.swing.JMenuItem JM_Open;
    private javax.swing.JMenuItem JM_Save;
    private javax.swing.JMenu MenuAutoFrame;
    private javax.swing.JDesktopPane Pantalla;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

}
