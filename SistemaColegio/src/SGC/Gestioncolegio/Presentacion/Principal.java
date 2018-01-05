package SGC.Gestioncolegio.Presentacion;

import SGC.Gestioncolegio.Entidades.Usuario;
import SGC.Gestioncolegio.LogicaNegocios.UsuarioLN;
import Util.Util;
import com.lowagie.text.pdf.codec.Base64;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Principal extends javax.swing.JFrame {
    Usuario usuario = new Usuario();
    public UsuarioLN usuarioLN = new UsuarioLN();
    public Principal() {
        initComponents();               
        pnlPrincipal.setBorder(new ImageFondo());
        
//       this.setExtendedState(Principal.MAXIMIZED_BOTH);
        this.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        
        Util.AplicarIcono(this);
        
        try {
            String user = IngresoSistema.txtUsuario.getText().toUpperCase();
            String clave  =  IngresoSistema.txtContrasena.getText().toUpperCase();
            Usuario usuarioEncotrado = usuarioLN.ConsultarUsuario(user, clave);
        
            this.lblUsuario.setText("USUARIO: "+usuarioEncotrado.getNomUsu()+" "+usuarioEncotrado.getApepatUsu()+" "+usuarioEncotrado.getApematUsu());
            lblRol.setText("ROL: "+usuarioEncotrado.getRol());
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        
        Timer tiempo = new Timer(100, new Principal.horas());
        tiempo.start();
//        lblFechayHora.setText("FECHA: "+Fecha()+" HORA:"+String.format(format.format(date), hoy));
        
    }
    
    
    public String Fecha(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String Fecha = sdf.format(date);
        return Fecha;
    }
    
    class horas implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Date date = new Date();
            String Hora = "HH.mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(Hora);
            Calendar hoy = Calendar.getInstance();
            lblFechayHora.setText("FECHA: "+Fecha()+" HORA:"+String.format(format.format(date), hoy));
            
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblFechayHora = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAlumnos = new javax.swing.JMenuItem();
        mnuProfesores = new javax.swing.JMenuItem();
        mnuSecretaria = new javax.swing.JMenuItem();
        mnuDirector = new javax.swing.JMenuItem();
        mnuSession = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA ESCOLAR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuario: ");

        lblFechayHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechayHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechayHora.setText("FECHAY  HORA: ");

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("Rol:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(lblFechayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setToolTipText("SISTEMA DE COLEGIO");
        pnlPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1066, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        jMenu1.setText("Mantenimiento");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        mnuAlumnos.setText("Alumnos");
        mnuAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlumnosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAlumnos);

        mnuProfesores.setText("Profesores");
        mnuProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProfesoresActionPerformed(evt);
            }
        });
        jMenu1.add(mnuProfesores);

        mnuSecretaria.setText("Secretaria");
        mnuSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSecretariaActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSecretaria);

        mnuDirector.setText("Director");
        mnuDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDirectorActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDirector);

        mnuSession.setText("CerrarSesión");
        mnuSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSessionActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSession);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Operaciones");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem5.setText("Matricula");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Horario");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Consultas");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Utilitarios");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Aceca de..");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlumnosActionPerformed
        Usuarios oUsuarios = new Usuarios();
        oUsuarios.setVisible(true);
        oUsuarios.setTitle("[MANTENIMIENTO]-REGISTRO DE ALUMNOS");
        oUsuarios.Alumno();
    }//GEN-LAST:event_mnuAlumnosActionPerformed

    private void mnuDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDirectorActionPerformed
        Usuarios oUsuarios = new Usuarios();
        oUsuarios.setVisible(true);
        oUsuarios.setTitle("[MANTENIMIENTO]-REGISTRO DEL DIRECTOR");
        oUsuarios.Director();        
    }//GEN-LAST:event_mnuDirectorActionPerformed

    private void pnlPrincipalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseMoved
        if(evt.getClickCount()==2){
            JOptionPane.showMessageDialog(null, "Ha presionado dos veces");
        }
    }//GEN-LAST:event_pnlPrincipalMouseMoved

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null,"¿Desea salir del Sistema?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        else{
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(JOptionPane.showConfirmDialog(null,"¿Desea salir del Sistema?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            else{
                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void mnuProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProfesoresActionPerformed
        Usuarios oUsuarios = new Usuarios();
        oUsuarios.setVisible(true);
        oUsuarios.setTitle("[MANTENIMIENTO]-REGISTRO DE PROFESORES");
        oUsuarios.Profesor();
    }//GEN-LAST:event_mnuProfesoresActionPerformed

    private void mnuSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSecretariaActionPerformed
        Usuarios oUsuarios = new Usuarios();
        oUsuarios.setVisible(true);
        oUsuarios.setTitle("[MANTENIMIENTO]-REGISTRO DE SECRETARIA");
        oUsuarios.Secretaria();        
    }//GEN-LAST:event_mnuSecretariaActionPerformed

    private void mnuSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSessionActionPerformed
        this.dispose();
        IngresoSistema oIngresoSistema = new IngresoSistema();
        oIngresoSistema.setVisible(true);
    }//GEN-LAST:event_mnuSessionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFechayHora;
    public static javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    public static javax.swing.JMenuItem mnuAlumnos;
    public static javax.swing.JMenuItem mnuDirector;
    public static javax.swing.JMenuItem mnuProfesores;
    public static javax.swing.JMenuItem mnuSecretaria;
    public static javax.swing.JMenuItem mnuSession;
    private javax.swing.JDesktopPane pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
