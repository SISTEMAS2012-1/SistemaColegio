package SGC.Gestioncolegio.Presentacion;

import SGC.Gestioncolegio.Entidades.Usuario;
import SGC.Gestioncolegio.LogicaNegocios.UsuarioLN;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import Util.Util;
import Util.mdlGeneral;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Usuarios extends javax.swing.JDialog {
    boolean modificar = false;
    String [] columnas = {"Id","Nº","Código","Apellido Paterno","Apellido Materno","Nombre","Genero","Colegio de Procedencia","Usuario","Contraseña"};
    Integer fila = 0;
    Usuario usuario = new Usuario();
    public Usuarios() {
        initComponents();

        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getSize().height/2);
        Util.AplicarIcono(this);
        tblUsuarios.setModel(new mdlGeneral(columnas));

        Integer [] anchos = {0,100,150,150,150,150,150,150,150,150};
        Integer[] alineaciones = {JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT};
        String[] formatos = {"Cadena","Cadena","Cadena","Cadena","Cadena","Cadena","Cadena","Cadena","Cadena","Cadena"};
        String[] modos = {"Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal","Normal"};
        
        Util.AplicarEstilos(tblUsuarios, anchos, alineaciones, formatos, modos);

        Buscar();

        tblUsuarios.setAutoResizeMode(tblUsuarios.AUTO_RESIZE_OFF);
        tblUsuarios.doLayout();
        Bloquear();
    }
    
    private List aVector(List<Usuario> lista){
        List datos = new ArrayList();
        Object[] newdata;
        
        for (int i = 0; i < lista.size(); i++) {
            newdata = new Object[10];
            
            newdata[0] = lista.get(i).getIdUsu();
            newdata[1] = (i + 1);
            newdata[2] = lista.get(i).getCodUsu();
            newdata[3] = lista.get(i).getApepatUsu();
            newdata[4] = lista.get(i).getApematUsu();
            newdata[5] = lista.get(i).getNomUsu();
            newdata[6] = lista.get(i).getGenUsu();
            newdata[7] = lista.get(i).getColProc();
            newdata[8] = lista.get(i).getNick();
            newdata[9] = lista.get(i).getPass();
            
            datos.add(newdata);           
        }
        return datos;
    }
    
    private void ListarUsuarioAlumno() throws Exception{
        try {
            UsuarioLN usuarioLN = new UsuarioLN();
            ((mdlGeneral)(tblUsuarios.getModel())).setData(aVector(usuarioLN.ConsultarUsuariosAlumnos(txtBuscarNombre.getText().trim().toUpperCase())));
            if(((mdlGeneral)(tblUsuarios.getModel())).getRowCount() > 0){
                tblUsuarios.changeSelection(fila, 0, false,false);                
            } else {                 
                txtBuscarNombre.requestFocus();
                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void ListarUsuarioProfesor() throws Exception{
        try {
            UsuarioLN usuarioLN = new UsuarioLN();
            ((mdlGeneral)(tblUsuarios.getModel())).setData(aVector(usuarioLN.ConsultarUsuariosAlumnos(txtBuscarNombre.getText().trim().toUpperCase())));
            if(((mdlGeneral)(tblUsuarios.getModel())).getRowCount() > 0){
                tblUsuarios.changeSelection(fila, 0, false,false);
                btnBuscar.setEnabled(false);
            } else { 
                txtBuscarNombre.requestFocus();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Bloquear(){
       btnModificar.setEnabled(false);
       btnEliminar.setEnabled(false);       
       btnBuscar.setEnabled(false);
       txtApepat.setEnabled(false);
       txtApemat.setEnabled(false);
       txtNombre.setEnabled(false);
       cbxGenero.setEnabled(false);
       txtEdad.setEnabled(false);
       txtDireccion.setEnabled(false);
       txtColPro.setEnabled(false);
       txtUsuario.setEnabled(false);
       txtClave.setEnabled(false);
       txtTelefono.setEnabled(false);
       txtCorreo.setEnabled(false); 
       lblFoto.setEnabled(false);
       btnFoto.setEnabled(false);
       btnGuardar.setEnabled(false);
       btnCancelar.setEnabled(false);
    }
    
    public void Desbloquear(){
       btnModificar.setEnabled(true);
       btnEliminar.setEnabled(true);       
       btnBuscar.setEnabled(true);
       btnGuardar.setEnabled(false);
       btnCancelar.setEnabled(false);
    }
    
    public void Nuevo(){
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtApepat.requestFocus();
        txtBuscarNombre.setText("");
        ((mdlGeneral)(tblUsuarios.getModel())).removeData();
        btnBuscar.setEnabled(false);
        txtApepat.setEnabled(true);
        txtApemat.setEnabled(true);
        txtNombre.setEnabled(true);
        cbxGenero.setEnabled(true);
        txtEdad.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtColPro.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtClave.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCorreo.setEnabled(true); 
        lblFoto.setEnabled(true);
        btnFoto.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    }
    
    public void limpiar(){
        txtCodigo.setText("");
        txtApepat.setText("");
        txtApemat.setText("");
        txtNombre.setText("");
        cbxGenero.setSelectedItem("");
        txtEdad.setText("");
        txtDireccion.setText("");
        txtColPro.setText("");
        txtUsuario.setText("");
        txtClave.setText("");;
        txtTelefono.setText("");
        txtCorreo.setText("");
        lblFoto.setText("");
        
        
    }
    
    public void Alumno(){
        txtRol.setText("ALUMNO");        
    }
    
    public void Profesor(){
        lblCodigo.setVisible(false);
        lblColProc.setVisible(false);
        txtRol.setText("PROFESOR");
        txtCodigo.setVisible(false);
        txtColPro.setVisible(false); 
        this.tblUsuarios.getColumnModel().getColumn(2).setMaxWidth(0);
        this.tblUsuarios.getColumnModel().getColumn(2).setMinWidth(0);
        this.tblUsuarios.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        this.tblUsuarios.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        this.tblUsuarios.getColumnModel().getColumn(7).setMaxWidth(0);
        this.tblUsuarios.getColumnModel().getColumn(7).setMinWidth(0);
        this.tblUsuarios.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        this.tblUsuarios.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
    }
    
    public void Director(){
        lblCodigo.setVisible(false);
        lblColProc.setVisible(false);
        txtRol.setText("DIRECTOR");
        txtCodigo.setVisible(false);
        txtColPro.setVisible(false);       
        pnlDetalle2.setVisible(false);
        int ancho = 615; 
        int alto = 520;
        int ancho1 = 597; 
        this.setSize(ancho,alto);        
        this.pnlDetalle.setSize(ancho1,alto);
    }
    
    public void Secretaria(){
        lblCodigo.setVisible(false);
        lblColProc.setVisible(false);
        txtRol.setText("SECRETARIA");
        txtCodigo.setVisible(false);
        txtColPro.setVisible(false); 
        pnlDetalle2.setVisible(false);
        pnlDetalle2.setVisible(false);
        int ancho = 615; 
        int alto = 520;
        int ancho1 = 597; 
        this.setSize(ancho,alto);        
        this.pnlDetalle.setSize(ancho1,alto);
    }
            
    private void Buscar(){
        try {
            if(Util.EsExpresionGeneralPermitida(txtBuscarNombre.getText().trim().toUpperCase())){
                fila = 0;
                if(txtRol.getText().equals("ALUMNO")){
                    ListarUsuarioAlumno();
                }
                if(txtRol.getText().equals("PROFESOR")){
                    ListarUsuarioProfesor();
                }
                
            } else {
                if(((mdlGeneral)(tblUsuarios.getModel())).getRowCount() > 0){
                    ((mdlGeneral)(tblUsuarios.getModel())).removeData();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetalle = new javax.swing.JPanel();
        lblSubencabezado = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblApepat = new javax.swing.JLabel();
        txtApepat = new javax.swing.JTextField();
        lblApemat = new javax.swing.JLabel();
        txtApemat = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtColPro = new javax.swing.JTextField();
        lblColProc = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblRol = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        btnFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        pnlDetalle2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscarNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pnlDetalle.setPreferredSize(new java.awt.Dimension(443, 338));

        lblSubencabezado.setBackground(new java.awt.Color(255, 255, 255));
        lblSubencabezado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSubencabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubencabezado.setText(" ");
        lblSubencabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblSubencabezado.setOpaque(true);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCodigo.setEnabled(false);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        lblApepat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblApepat.setText("Apellido Paterno: ");

        txtApepat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApepat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApepatFocusGained(evt);
            }
        });
        txtApepat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApepatKeyPressed(evt);
            }
        });

        lblApemat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblApemat.setText("Apellido Materno:");

        txtApemat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre.setText("Nombres:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGenero.setText("Genero:");

        cbxGenero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "M", "FEMENINO" }));

        lblEdad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEdad.setText("Edad:");

        txtEdad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDireccion.setText("Direccion:");

        txtColPro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtColPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColProActionPerformed(evt);
            }
        });

        lblColProc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblColProc.setText("Colegio Procedencia:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Contraseña:");

        txtClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefono.setText("Telefono:");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCorreo.setText("Correo:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblCodigo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigo2.setText("Foto");

        btnGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRol.setText("Rol:");

        txtRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtRol.setEnabled(false);
        txtRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRolActionPerformed(evt);
            }
        });

        btnFoto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFoto.setText("Agregar Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSubencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblApemat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEdad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblColProc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(lblRol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo)
                            .addComponent(txtTelefono)
                            .addComponent(txtClave)
                            .addComponent(txtUsuario)
                            .addComponent(txtColPro)
                            .addComponent(txtDireccion)
                            .addComponent(txtNombre)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApemat, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRol)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(txtApepat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblApepat, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                            .addComponent(lblCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66))
                        .addGroup(pnlDetalleLayout.createSequentialGroup()
                            .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)))
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(lblSubencabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApepat, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApepat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApemat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApemat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenero)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEdad)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColProc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRol)
                            .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnFoto))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlDetalle2.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlDetalle2.setPreferredSize(new java.awt.Dimension(443, 338));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        btnNuevo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setMnemonic(new Character('B'));
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        txtBuscarNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyReleased(evt);
            }
        });

        lblNombre1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombre1.setText("Nombre");

        javax.swing.GroupLayout pnlDetalle2Layout = new javax.swing.GroupLayout(pnlDetalle2);
        pnlDetalle2.setLayout(pnlDetalle2Layout);
        pnlDetalle2Layout.setHorizontalGroup(
            pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalle2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDetalle2Layout.createSequentialGroup()
                        .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtBuscarNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDetalle2Layout.setVerticalGroup(
            pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalle2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addComponent(pnlDetalle2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtApepatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApepatFocusGained
        txtApepat.selectAll();
    }//GEN-LAST:event_txtApepatFocusGained

    private void txtApepatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApepatKeyPressed
        
    }//GEN-LAST:event_txtApepatKeyPressed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtColProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColProActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(null,"¿Desea registrar "+txtRol.getText()+"?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if(txtApepat.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el Apellido Paterno del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtApepat.requestFocus();
                    return;
                }
                if(txtApemat.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el Apellido Materno del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtApemat.requestFocus();
                    return;
                }
                
                if(txtNombre.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el Nombre del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtNombre.requestFocus();
                    return;
                }
                
                if(cbxGenero.getSelectedItem().equals("")){
                    JOptionPane.showMessageDialog(null,"Debe elegir el genero "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    cbxGenero.requestFocus();
                    return;
                }
                
                if(txtEdad.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar la Edad del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtEdad.requestFocus();
                    return;
                }
                
                if(txtDireccion.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar la Direccion del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtDireccion.requestFocus();
                    return;
                }
                
                if(txtUsuario.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar el usuario del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtUsuario.requestFocus();
                    return;
                }
                
                if(txtClave.getText().trim().toUpperCase().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Debe ingresar la clave del "+txtRol.getText()+"","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                    txtClave.requestFocus();                    
                    return;
                }
                
                Usuario usuario = new Usuario();
                usuario.setApepatUsu(txtApepat.getText().trim().toUpperCase());
                usuario.setApematUsu(txtApemat.getText().trim().toUpperCase());
                usuario.setNomUsu(txtNombre.getText().trim().toUpperCase());
                usuario.setGenUsu(cbxGenero.getSelectedItem().toString().substring(0,1));
                usuario.setEdadUsu(txtEdad.getText().trim().toUpperCase());
                usuario.setDirUsu(txtDireccion.getText().trim().toUpperCase());
                usuario.setColProc(txtColPro.getText().trim().toUpperCase());
                usuario.setNick(txtUsuario.getText().trim().toUpperCase());
                usuario.setPass(txtClave.getText().trim().toUpperCase());
                usuario.setTelefono(txtTelefono.getText().trim().toUpperCase());
                usuario.setCorreo(txtCorreo.getText().trim().toUpperCase());
                usuario.setImagen(lblFoto.getText().trim().toUpperCase());
                usuario.setRol(txtRol.getText().trim().toUpperCase());
                UsuarioLN usuarioLN = new UsuarioLN();
                Usuario usuarioEncontrado =  usuarioLN.ConsultarUsuario(usuario);
                
                if(usuarioEncontrado != null){
                    JOptionPane.showMessageDialog(null,"Este usuario ya existe","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    if(txtRol.getText().trim().toUpperCase().equals("ALUMNO")){
                        
//                        if(modificar){
//                            usuarioLN.ModificarUsuarioAlumno(usuario);
//                            JOptionPane.showMessageDialog(null,"Se modifico con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                            modificar = false;
//                        }else{
                            usuarioLN.ModificarUsuarioAlumno(usuario);
                            JOptionPane.showMessageDialog(null,"Se registro con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                        }
                    }
//                    if(txtRol.getText().trim().toUpperCase().equals("PROFESOR")){
//                        if(modificar){
//                            usuarioLN.ModificarUsuarioProfesor(usuario);
//                            JOptionPane.showMessageDialog(null,"Se modifico con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                            modificar = false;
//                        }else{
//                            usuarioLN.RegistrarUsuarioProfesor(usuario);
//                            JOptionPane.showMessageDialog(null,"Se registro con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                        }
//                    }
//                    if(txtRol.getText().trim().toUpperCase().equals("SECRETARIA")){
//                        if(modificar){
//                            usuarioLN.ModificarUsuarioSecretaria(usuario);
//                            JOptionPane.showMessageDialog(null,"Se modifico con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                            modificar = false;
//                        }else{
//                            usuarioLN.RegistrarSecretaria(usuario);
//                            JOptionPane.showMessageDialog(null,"Se registro con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                        }
//                    }
//                    if(txtRol.getText().trim().toUpperCase().equals("DIRECTOR")){
//                        if(modificar){
//                            usuarioLN.ModificarUsuarioDirector(usuario);
//                            JOptionPane.showMessageDialog(null,"Se modifico con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                            modificar = false;
//                        }else{
//                            usuarioLN.RegistrarDirector(usuario);
//                            JOptionPane.showMessageDialog(null,"Se registro con éxito el usuario "+txtRol.getText(),"Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE );
//                        }
//                    }
                }                
            }
            ListarUsuarioAlumno();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
        
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            limpiar();
            Nuevo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            Integer id = Integer.parseInt(((mdlGeneral)(tblUsuarios.getModel())).getValueAt(tblUsuarios.getSelectedRow(), 0).toString());

            UsuarioLN usuarioLN = new UsuarioLN();
            Usuario usuario = usuarioLN.ConsultarUsuariosAlumnos(id);

            if(usuario != null){
                txtCodigo.setText(usuario.getCodUsu());
                txtApepat.setText(usuario.getApepatUsu());
                txtApemat.setText(usuario.getApematUsu());
                txtNombre.setText(usuario.getNomUsu());
                cbxGenero.setSelectedItem(usuario.getGenUsu());
    //                    if(((mdlGeneral)(tblUsuarios.getModel())).getValueAt(tblUsuarios.getSelectedRow(), 6).toString().equals(usuario.getGenUsu().substring(0,1))){
    //                        String genero = "MASCULINO";
    //                        cbxGenero.setSelectedItem(genero);
    //                    }
    //                    else if(((mdlGeneral)(tblUsuarios.getModel())).getValueAt(tblUsuarios.getSelectedRow(), 6).toString().equals(usuario.getGenUsu().substring(0,1))){
    //                        String genero = "FEMENINO";
    //                        cbxGenero.setSelectedItem(genero);
    //                    }
                txtEdad.setText(usuario.getEdadUsu());
                txtDireccion.setText(usuario.getDirUsu());
                txtColPro.setText(usuario.getColProc());
                txtUsuario.setText(usuario.getNick());
                txtClave.setText(usuario.getPass());
                txtTelefono.setText(usuario.getTelefono());
                txtCorreo.setText(usuario.getCorreo()); 
                Nuevo();
    //                    modificar = true;
            } else {
                JOptionPane.showMessageDialog(null,"Usuaro no registrado","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);                 
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if(tblUsuarios.getSelectedRow() != -1){
                if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar el Usuario "+txtRol.getText()+"?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Integer id = Integer.parseInt(((mdlGeneral)(tblUsuarios.getModel())).getValueAt(tblUsuarios.getSelectedRow(),0).toString());
                    
                    UsuarioLN usuarioLN = new UsuarioLN();
                    usuarioLN.EliminarUsuarioAlumno(new Usuario(id));
                    
                    JOptionPane.showMessageDialog(null,"Usuario "+txtRol.getText()+" eliminado correctamente","Mensaje del Sistema",JOptionPane.INFORMATION_MESSAGE);

                    if(fila > 0){
                        fila--;
                    }
                    ListarUsuarioAlumno();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Usuario"+txtRol.getName(),"Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null,"¿Desea salir de la ventana registros?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
        }
        else{
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        if(JOptionPane.showConfirmDialog(null,"¿Desea salir de la venta "+usuario.getRol()+"?","Mensaje del Sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            this.dispose();
//        }
//        else{
//            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
//        }
    }//GEN-LAST:event_formWindowClosed

    private void txtRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void txtBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblUsuarios.requestFocus();            
        }
        else {
//            btnBuscar.setEnabled(true);
//            Buscar();
              if(!txtBuscarNombre.getText().trim().toUpperCase().isEmpty()){
                  Buscar();
                  Bloquear();
                  btnBuscar.setEnabled(true);
              }else {
                  btnBuscar.setEnabled(false);
                  Bloquear();
                  limpiar();
                  ((mdlGeneral)(tblUsuarios.getModel())).removeData();
                  
              }
//            
        }
    }//GEN-LAST:event_txtBuscarNombreKeyReleased

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Imagen","jpg");
        JFileChooser fichero = new JFileChooser();
        fichero.setFileFilter(filtro);
        
        int option = fichero.showOpenDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            String fil = fichero.getSelectedFile().getPath();
            String file = fichero.getSelectedFile().toString();
            lblFoto.setIcon(new ImageIcon(fil));
            ImageIcon icon = new ImageIcon(fil);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(130, 109, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            lblFoto.setIcon(newIcon);
            lblFoto.setSize(130,109);
            lblFoto.setText(fil);
                  
        }
        
        
    }//GEN-LAST:event_btnFotoActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            if(evt.getClickCount() == 1){
                fila = tblUsuarios.getSelectedRow();
                Desbloquear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Mensaje del Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApemat;
    private javax.swing.JLabel lblApepat;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblColProc;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblSubencabezado;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlDetalle2;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApemat;
    public static javax.swing.JTextField txtApepat;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColPro;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
