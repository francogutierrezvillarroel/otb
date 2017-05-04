package ventanas;

//import clases.Lectura;
//import clases.Cliente;
import clases.Conexion;
//import clases.ModelTablaClientes;
//import clases.ModelTablaUsuarios;
//import javax.swing.*;
import java.awt.Rectangle;
//import java.awt.Color; 
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JDesktopPane;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
//import javax.swing.border.*;
//import javax.swing.table.TableColumn;


/**
 * @author skysoftgo
 */
public class IHistorialVecino extends javax.swing.JInternalFrame {

    /**
     * Creates new form IRegistroVecinos
     */
    //private ModelTablaClientes mdlCliente;
    int ancho;int alto;
    public IHistorialVecino(JDesktopPane mainApp) {
        ancho = (int)((this.getToolkit().getScreenSize().getWidth()));
        alto = (int)((this.getToolkit().getScreenSize().getHeight()));
        initComponents();
        //mdlCliente = new ModelTablaClientes();
        //this.tblhistorial.setModel(mdlCliente);
        Rectangle visibleRect1 = mainApp.getVisibleRect(); 
        this.setLocation(5, 0);
        this.setSize(visibleRect1.width-10, visibleRect1.height-10);
        //this.tblhistorial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.txtNombreCliente.getDocument().addDocumentListener(EscuchadorBuscar);

        //tblhistorial.setBorder(BorderFactory.createLineBorder(Color.RED,1));
        /*tblhistorial.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblhistorial.getColumnModel().getColumn(2).setPreferredWidth(280);
        tblhistorial.getColumnModel().getColumn(7).setPreferredWidth(170);
        tblhistorial.getColumnModel().getColumn(8).setPreferredWidth(120);
        tblhistorial.getColumnModel().getColumn(9).setPreferredWidth(150);*/
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lbNoExiste = new javax.swing.JLabel();
        
        jPanel2 = new javax.swing.JPanel();
        
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhistorial = new javax.swing.JTable();
        
        jLabel2 = new javax.swing.JLabel("DATOS PERSONALES");
        jLabel3 = new javax.swing.JLabel("HISTORIAL");
        
        jPanel3 = new javax.swing.JPanel();
        casa = new javax.swing.JLabel();
        medidor = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        ci = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        fnacimiento = new javax.swing.JLabel();
        ocupacion = new javax.swing.JLabel();
        deuda = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        manzano = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        casadato = new javax.swing.JLabel();
        medidordato = new javax.swing.JLabel();
        nombredato = new javax.swing.JLabel();
        cidato = new javax.swing.JLabel();
        direcciondato = new javax.swing.JLabel();
        telefonodato = new javax.swing.JLabel();
        celulardato = new javax.swing.JLabel();
        emaildato = new javax.swing.JLabel();
        fnacimientodato = new javax.swing.JLabel();
        ocupaciondato = new javax.swing.JLabel();
        deudadato = new javax.swing.JLabel();
        tipodato = new javax.swing.JLabel();
        manzanodato = new javax.swing.JLabel();
        estadodato = new javax.swing.JLabel();
                
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Historial del Vecino");
        
        jPanel1.setLayout(new java.awt.BorderLayout());
        
        /* Find */
        jPanel4.setLayout(new java.awt.GridBagLayout());
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));  
        jLabel1.setText("Nombre del Vecino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 9, 10, 10);
        jPanel4.add(jLabel1, gridBagConstraints);

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14));  
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 8);
        jPanel4.add(txtNombreCliente, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14));  
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_find.png")));  
        jButton4.setPreferredSize(new java.awt.Dimension(33, 30));
        jButton4.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 12);
        jPanel4.add(jButton4, gridBagConstraints);
        
        lbNoExiste.setFont(new java.awt.Font("Tahoma", 0, 14));  
        lbNoExiste.setForeground(new java.awt.Color(255, 51, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 6);
        jPanel4.add(lbNoExiste, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);
        /* end find */
        
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        
        jPanel2.setLayout(new FlowLayout());
        jPanel2.setLocation(0, 94);
        //jPanel2.setBorder(BorderFactory.createLineBorder(Color.red));

        jPanel3 = new javax.swing.JPanel();
        jPanel3.setLayout(null);        
        jPanel3.setLocation(0, 94);
        jPanel3.setPreferredSize(new Dimension((ancho/4),(alto-300)));
        //jPanel3.setBorder(BorderFactory.createLineBorder(Color.green));
        jPanel2.add(jPanel3);
        
        jPanel5 = new javax.swing.JPanel();
        jPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel5.setLocation(0, 94);
        jPanel5.setPreferredSize(new Dimension((ancho/2),(alto-300)));
        //jPanel5.setBorder(BorderFactory.createLineBorder(Color.green));
        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        
        jLabel2.setFont(new java.awt.Font("ARIAL", Font.BOLD, 16)); 
        jLabel2.setBounds(new Rectangle( 50,0,200,80));        
        jLabel2.setAlignmentX(CENTER_ALIGNMENT);
        jPanel3.add(jLabel2);
        
        casa.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        casa.setBounds(new Rectangle( 0,30,150,80));
        casa.setText("CASA # :");
        jPanel3.add(casa);
        
        medidor.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        medidor.setBounds(new Rectangle( 0,50,150,80));
        medidor.setText("MEDIDOR:");
        jPanel3.add(medidor);
        
        nombre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        nombre.setBounds(new Rectangle( 0,70,150,80));
        nombre.setText("NOMBRE:");
        jPanel3.add(nombre);
        
        ci.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        ci.setBounds(new Rectangle( 0,90,150,80));
        ci.setText("CI:");
        jPanel3.add(ci);
        
        direccion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        direccion.setBounds(new Rectangle(0,110,150,80));
        direccion.setText("DIR.:");
        jPanel3.add(direccion);
        
        telefono.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        telefono.setBounds(new Rectangle( 0,130,150,80));
        telefono.setText("TELF.:");
        jPanel3.add(telefono);
        
        celular.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        celular.setBounds(new Rectangle( 0,150,150,80));
        celular.setText("CELULAR:");
        jPanel3.add(celular);
        
        email.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        email.setBounds(new Rectangle( 0,170,150,80));
        email.setText("EMAIL:");
        jPanel3.add(email);
        
        fnacimiento.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        fnacimiento.setBounds(new Rectangle( 0,190,150,80));
        fnacimiento.setText("F.NAC.:");
        jPanel3.add(fnacimiento);
        
        ocupacion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        ocupacion.setBounds(new Rectangle( 0,210,150,80));
        ocupacion.setText("OCUPACIÓN:");
        jPanel3.add(ocupacion);
                
        tipo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        tipo.setBounds(new Rectangle( 0,230,150,80));
        tipo.setText("TIPO CASA:");
        jPanel3.add(tipo);
        
        manzano.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        manzano.setBounds(new Rectangle( 0,250,150,80));
        manzano.setText("MANZANO:");
        jPanel3.add(manzano);
        
        estado.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        estado.setBounds(new Rectangle( 0,270,150,80));
        estado.setText("ESTADO:");
        jPanel3.add(estado);
        
        deuda.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        deuda.setBounds(new Rectangle( 0,290,150,80));
        deuda.setText("DEUDA:");
        jPanel3.add(deuda);
        
        
        casadato.setFont(new java.awt.Font("Arial", 4, 12)); 
        casadato.setBounds(new Rectangle( 75,30,150,80));
        casadato.setText("- - - - -");
        jPanel3.add(casadato);
        
        medidordato.setFont(new java.awt.Font("Tahoma", 0, 12));
        medidordato.setBounds(new Rectangle( 75,50,150,80));
        medidordato.setText("00000");
        jPanel3.add(medidordato);
        
        nombredato.setFont(new java.awt.Font("Tahoma", 0, 12));
        nombredato.setBounds(new Rectangle( 75,70,300,80));
        nombredato.setText("- - - - -");
        jPanel3.add(nombredato);
        
        cidato.setFont(new java.awt.Font("Tahoma", 0, 12));
        cidato.setBounds(new Rectangle( 75,90,300,80));
        cidato.setText("00000000");
        jPanel3.add(cidato);
        
        direcciondato.setFont(new java.awt.Font("Tahoma", 0, 12));
        direcciondato.setBounds(new Rectangle(75,110,300,80));
        direcciondato.setText("- - - - -");
        jPanel3.add(direcciondato);
        
        telefonodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        telefonodato.setBounds(new Rectangle(75,130,150,80));
        telefonodato.setText("0000000");
        jPanel3.add(telefonodato);
        
        celulardato.setFont(new java.awt.Font("Tahoma", 0, 12));
        celulardato.setBounds(new Rectangle(75,150,150,80));
        celulardato.setText("00000000");
        jPanel3.add(celulardato);
        
        emaildato.setFont(new java.awt.Font("Tahoma", 0, 12));
        emaildato.setBounds(new Rectangle( 75,170,150,80));
        emaildato.setText("- - - - -");
        jPanel3.add(emaildato);
        
        fnacimientodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        fnacimientodato.setBounds(new Rectangle( 75,190,150,80));
        fnacimientodato.setText("00/00/00:");
        jPanel3.add(fnacimientodato);
        
        ocupaciondato.setFont(new java.awt.Font("Tahoma", 0, 12));
        ocupaciondato.setBounds(new Rectangle( 75,210,150,80));
        ocupaciondato.setText("- - - - -");
        jPanel3.add(ocupaciondato);
        
        tipodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        tipodato.setBounds(new Rectangle( 75,230,150,80));
        tipodato.setText("- - - - -");
        jPanel3.add(tipodato);
        
        manzanodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        manzanodato.setBounds(new Rectangle( 75,250,150,80));
        manzanodato.setText("00000000");
        jPanel3.add(manzanodato);
        
        estadodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        estadodato.setBounds(new Rectangle( 75,270,150,80));
        estadodato.setText("- - - - -");
        jPanel3.add(estadodato);
        
        deudadato.setFont(new java.awt.Font("Tahoma", 0, 12));
        deudadato.setBounds(new Rectangle(75,290,150,80));
        deudadato.setText("000.00");
        jPanel3.add(deudadato);

        
        jPanel5.setLayout(new java.awt.BorderLayout());
        tblhistorial.setFont(new java.awt.Font("Tahoma", 0, 12));  
        tblhistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { {},  {},  {}, {} },
            new String [] { }
        ));
        
        tblhistorial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblhistorial);
        jPanel5.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);
        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        llenardatos(0);
        pack();
    }
    
    private void llenardatos(int numero){
        int idpropietario=0;
        int idpropiedad=0;
        
        ResultSet datos;
        if(numero == 0)
        {
            datos = Conexion.getRegistros("select * from tblcliente  ORDER BY NoCuenta ASC LIMIT 1");   
        } else{
            datos = Conexion.getRegistros("select * from tblcliente where ci="+numero);
        }
            try{
                while(datos.next())
                {
                    idpropietario=datos.getInt(1);
                    cidato.setText(String.valueOf(datos.getInt(2)));
                    nombredato.setText(datos.getString(3));
                    direcciondato.setText(datos.getString(4));
                    telefonodato.setText(String.valueOf(datos.getInt(5)));
                    celulardato.setText(String.valueOf(datos.getInt(6)));
                    emaildato.setText(datos.getString(9));
                    fnacimientodato.setText(String.valueOf(datos.getDate(8)));
                    ocupaciondato.setText(datos.getString(10));
                }
                 datos.close(); 
            }catch(SQLException e){e.printStackTrace();}
            
            ResultSet datos1=Conexion.getRegistros("select * from propiedad where id_propietario="+idpropietario);
            try{
                while(datos1.next())
                {
                    idpropiedad = datos1.getInt(1);
                    casadato.setText(String.valueOf(datos1.getInt(4)));
                    medidordato.setText(String.valueOf(datos1.getInt(5)));
                    tipodato.setText(datos1.getString(6));
                    manzanodato.setText(String.valueOf(datos1.getInt(7)));
                    estadodato.setText(datos1.getString(8));
                    deudadato.setText(String.valueOf(datos1.getInt(9)));
                }
                datos1.close();
            }catch(SQLException e){e.printStackTrace();}
        
            
        Calendar fecha = Calendar.getInstance();
        int ano = fecha.get(Calendar.YEAR);
        int anoinicio = 2012;
        String[][] datas=new String[10][13];
        for(int i=0;i<10;i++){
            for(int j=0;j<13;j++){
                if(j == 0){ datas[i][j]=""+(anoinicio=anoinicio+1);
                }else{
                    if(anoinicio > ano){datas[i][j]=" ";}else{datas[i][j]="debe";}
                }
            }
        }
        
        
        String[] columns = {"AÑO","ENERO","FEBRERO","MARZO", "ABRIL","MAYO","JUMIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
        
        ResultSet datos2=Conexion.getRegistros("select * from tblmedida where id_propiedad="+idpropiedad);
            try{
                while(datos2.next())
                {
                    String abc=(String.valueOf(datos2.getDate(6)));
                    int anos = Integer.valueOf(abc.substring(0,4));
                    int i=0; int j=0;
                    
                    switch(anos){
                        case 2013:
                            i = 0;
                            break;
                        case 2014:
                            i = 1;
                            break;
                        case 2015:
                            i = 2;
                            break;
                        case 2016:
                            i = 3;
                            break;
                        case 2017:
                            i = 4;
                            break;
                        case 2018:
                            i = 5;
                            break;
                        case 2019:
                            i = 6;
                            break;
                        case 2020:
                            i = 7;
                            break;
                        case 2021:
                            i = 8;
                            break;
                        case 2022:
                            i = 9;
                            break;       
                    }
                    String mes = datos2.getString(7);
                    switch(mes){
                        case "enero":
                            j = 1;
                            break;
                        case "febrero":
                            j = 2;
                            break;
                        case "marzo":
                            j = 3;
                            break;
                        case "abril":
                            j = 4;
                            break;
                        case "mayo":
                            j = 5;
                            break;
                        case "junio":
                            j = 6;
                            break;
                        case "julio":
                            j = 7;
                            break;
                        case "agosto":
                            j = 8;
                            break;
                        case "septiembre":
                            j = 9;
                            break;
                        case "octubre":
                            j = 10;
                            break;
                        case "noviembre":
                            j = 11;
                            break;
                        case "diciembre":
                            j = 12;
                            break;       
                    }
                    
                    if(datos2.getInt(9) > 0){datas[i][j]="pagado";}
                }
                datos2.close();
                Conexion.con.close();
            }catch(SQLException e){e.printStackTrace();}
           
        tblhistorial.updateUI();
        tblhistorial.setModel(new javax.swing.table.DefaultTableModel(datas,columns));   
    }
    
    private void reiniciarTabla()
    {
         //mdlCliente = new ModelTablaClientes(); 
         //this.tblhistorial.setModel(mdlCliente);   
    }

    
    DocumentListener EscuchadorBuscar = new DocumentListener(){
        @Override
        public void insertUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }
    };
    
    
    public void mostrarRegistrosEncontrados(DocumentEvent e)
    {
        if(e.getDocument().getLength() > 5)
        {
            try {
                String nombreBuscar = e.getDocument().getText(0, e.getDocument().getLength());
                int ciBuscar = (Integer.valueOf(nombreBuscar));
                //ModelTablaClientes mtu = new ModelTablaClientes(nombreBuscar);
                if(!nombreBuscar.isEmpty())
                {
                    llenardatos(ciBuscar);
                    this.lbNoExiste.setText("");
                    /*if(mtu.estVacio())
                    {
                        this.lbNoExiste.setText("El C.I. "+ciBuscar+" no se encuentra!");
                        mdlCliente = new ModelTablaClientes();                
                    }else{
                        mdlCliente = mtu;       
                        this.lbNoExiste.setText("");
                    } */              
                }else
                {
                    llenardatos(0);
                    //mdlCliente = new ModelTablaClientes();
                }
                 //this.tblhistorial.setModel(mdlCliente);
                if(nombreBuscar.isEmpty())
                {
                    this.lbNoExiste.setText("Sin Resultados");
                }

            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }else{llenardatos(0);this.lbNoExiste.setText("Sin Resultados");}
    } 
     
     
     
    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
       
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
       
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
      
    }//GEN-LAST:event_bntEliminarActionPerformed


    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbNoExiste;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JButton jButton4;
    
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
    public javax.swing.JLabel casa;
    public javax.swing.JLabel medidor;
    public javax.swing.JLabel nombre;
    public javax.swing.JLabel ci;
    public javax.swing.JLabel direccion;
    public javax.swing.JLabel telefono;
    public javax.swing.JLabel celular;
    public javax.swing.JLabel email;
    public javax.swing.JLabel fnacimiento;
    public javax.swing.JLabel ocupacion;
    public javax.swing.JLabel deuda;
    public javax.swing.JLabel tipo;
    public javax.swing.JLabel manzano;
    public javax.swing.JLabel estado;
    
    public javax.swing.JLabel casadato;
    public javax.swing.JLabel medidordato;
    public javax.swing.JLabel nombredato;
    public javax.swing.JLabel cidato;
    public javax.swing.JLabel direcciondato;
    public javax.swing.JLabel telefonodato;
    public javax.swing.JLabel celulardato;
    public javax.swing.JLabel emaildato;
    public javax.swing.JLabel fnacimientodato;
    public javax.swing.JLabel ocupaciondato;
    public javax.swing.JLabel deudadato;
    public javax.swing.JLabel tipodato;
    public javax.swing.JLabel manzanodato;
    public javax.swing.JLabel estadodato;
    
    private javax.swing.JTable tblhistorial;
    private javax.swing.JScrollPane jScrollPane1;
   
}
