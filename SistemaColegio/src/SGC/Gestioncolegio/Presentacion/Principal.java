package SGC.Gestioncolegio.Presentacion;

import SGC.Gestioncolegio.Entidades.Usuario;
import SGC.Gestioncolegio.LogicaNegocios.UsuarioLN;
import Util.Util;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JDialog {
    Usuario usuario = new Usuario();
    UsuarioLN usuarioLN = new UsuarioLN();
    public Principal() throws Exception {
        initComponents();               

        
        this.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        
        Util.AplicarIcono(this);
        
        String user = IngresoSistema.txtUsuario.getText();
        String clave  =  IngresoSistema.txtContrasena.getText();
        Usuario usuarioEncotrado = usuarioLN.ConsultarUsuario(user, clave);
        lblUsuario.setText("Usuario: "+usuarioEncotrado.getApepatUsu()+" "+usuarioEncotrado.getApematUsu()+" "+usuarioEncotrado.getNomUsu());
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAlumnos = new javax.swing.JMenuItem();
        mnuProfesores = new javax.swing.JMenuItem();
        mnuSecretaria = new javax.swing.JMenuItem();
        mnuDirector = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario: ");

        jLabel6.setText("Fecha y Hora: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setToolTipText("SISTEMA DE BIBLIOTECA");
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
            .addGap(0, 254, Short.MAX_VALUE)
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
        jMenu1.add(mnuProfesores);

        mnuSecretaria.setText("Secretaria");
        jMenu1.add(mnuSecretaria);

        mnuDirector.setText("Director");
        mnuDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDirectorActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDirector);

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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlumnosActionPerformed
        Usuarios oUsuarios = new Usuarios();
        oUsuarios.setVisible(true);
    }//GEN-LAST:event_mnuAlumnosActionPerformed

    private void mnuDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDirectorActionPerformed
        
    }//GEN-LAST:event_mnuDirectorActionPerformed

    private void pnlPrincipalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseMoved
        if(evt.getClickCount()==2){
            JOptionPane.showMessageDialog(null, "Ha presionado dos veces");
        }
    }//GEN-LAST:event_pnlPrincipalMouseMoved



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuAlumnos;
    private javax.swing.JMenuItem mnuDirector;
    private javax.swing.JMenuItem mnuProfesores;
    private javax.swing.JMenuItem mnuSecretaria;
    private javax.swing.JDesktopPane pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
