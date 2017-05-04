package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author skysoftgo
 */
public class Cliente {
    
    private int NumeroCuenta;
    private int ci;
    private String nombre;
    private String direccion;
    private String telefono;
    private int cel;
    private String sexo;
    private String fnacimiento;
    private String email;
    private String ocupacion;
    private Date fregistro;
    
    //consultas sql
    public static String NOMBRE_TABLA = "tblcliente";
    public static String SELECCIONAR_TODO = "select * from "+Cliente.NOMBRE_TABLA;

    public Cliente(int NumeroCuenta,int ci, String nombre, String direccion, String telefono, int cel, String sexo, String fnacimiento, String email, String ocupacion, Date fregistro) {
        this.NumeroCuenta = NumeroCuenta;
        this.ci = ci;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cel = cel;
        this.sexo = sexo;
        this.fnacimiento = fnacimiento;
        this.email = email;
        this.ocupacion = ocupacion;
        this.fregistro = fregistro;
    }

    public Cliente() {    }

    public Cliente(int ci, String nombre, String direccion, String telefono, int cel, String sexo, String fnacimiento, String email, String ocupacion, Date fregistro) {
        this.ci = ci;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cel = cel;
        this.sexo = sexo;
        this.fnacimiento = fnacimiento;
        this.email = email;
        this.ocupacion = ocupacion;
        this.fregistro = fregistro;
    }
    
    public int getNumeroCuenta() {
        return NumeroCuenta;
    }
    public void setNumeroCuenta(int NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }
    
    public int getci() {
        return ci;
    }
    public void setci(int ci) {
        this.ci = ci;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getcel() {
        return cel;
    }
    public void setcel(int cel) {
        this.cel = cel;
    }

    public String getsexo() {
        return sexo;
    }
    public void setsexo(String sexo) {
        this.sexo = sexo;
    }

    public String getfnacimiento() {
        return fnacimiento;
    }
    public void setfnacimiento(String fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }

    public String getocupacion() {
        return ocupacion;
    }
    public void setocupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Date getfregistro() {
        return fregistro;
    }
    public void setfregistro(Date fregistro) {
        this.fregistro = fregistro;
    }
   
    
    public String getFormatearFecha(Date fecha, String formato)
    {   
        SimpleDateFormat sdf = null;
        if(formato == null)
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        else
          sdf = new SimpleDateFormat(formato);  
        return sdf.format(fecha);
    }
    
    public int grabar()
    {
        String sql = "INSERT INTO tblcliente (ci, Nombre, Direccion,Telefono,cel, sexo,fnacimiento,email,ocupacion,fregistro)"+
                    "VALUES ('"+this.ci+"','"+this.nombre+"','"+this.direccion+"',"+"'"+this.telefono+"','"+this.cel+"','"+this.sexo+"','"+this.fnacimiento+"',"+"'"+this.email+"','"+this.ocupacion+"',"+"'"+this.getFormatearFecha(this.fregistro,null)+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblcliente SET ci = '"+this.ci+"',"+
                      "Nombre = '"+this.nombre+"',"+
                      "Direccion = '"+this.direccion+"',"+
                      "Telefono = '"+this.telefono+"',"+
                      "cel = '"+this.cel+"',"+
                      "sexo = '"+this.sexo+"',"+
                      "fnacimiento = '"+this.fnacimiento+"',"+
                      "email = '"+this.email+"',"+
                      "ocupacion = '"+this.ocupacion+"',"+
                      "fregistro = '"+this.getFormatearFecha(this.fregistro,null)+"'"+
                     " WHERE NoCuenta = "+this.NumeroCuenta;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        String sql = "DELETE FROM tblcliente WHERE NoCuenta = "+this.NumeroCuenta;
        return Conexion.guardarRegistro(sql);
    }
    
    public static ArrayList<Cliente> getClientes(){
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO);
        ArrayList<Cliente> ListaClientes= new ArrayList();
         try{
             
            while(clientes.next())
            {
                Cliente cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setci(clientes.getInt(2));
                cliente.setNombre(clientes.getString(3));
                cliente.setDireccion(clientes.getString(4));
                cliente.setTelefono(clientes.getString(5));
                cliente.setcel(clientes.getInt(6));
                cliente.setsexo(clientes.getString(7));
                cliente.setfnacimiento(clientes.getString(8));
                cliente.setemail(clientes.getString(9));
                cliente.setocupacion(clientes.getString(10));
                cliente.setfregistro(clientes.getDate(11));
                ListaClientes.add(cliente);
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaClientes;
    }
    
    public static ArrayList<Cliente> getCliente(String nombre)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where Nombre like '"+nombre+"%'");
        ArrayList<Cliente> ListaClientes= new ArrayList();
         try{
            while(clientes.next())
            {
                Cliente cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setci(clientes.getInt(2));
                cliente.setNombre(clientes.getString(3));
                cliente.setDireccion(clientes.getString(4));
                cliente.setTelefono(clientes.getString(5));
                cliente.setcel(clientes.getInt(6));
                cliente.setsexo(clientes.getString(7));
                cliente.setfnacimiento(clientes.getString(8));
                cliente.setemail(clientes.getString(9));
                cliente.setocupacion(clientes.getString(10));
                cliente.setfregistro(clientes.getDate(11));
                ListaClientes.add(cliente);
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         if(ListaClientes.size()>0)
            return ListaClientes;
         return null;
    }
    
    public static Cliente getCliente(int idCliente)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where NoCuenta = "+idCliente);
        Cliente cliente = null;
        try{
            while(clientes.next())
            {
                cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setci(clientes.getInt(2));
                cliente.setNombre(clientes.getString(3));
                cliente.setDireccion(clientes.getString(4));
                cliente.setTelefono(clientes.getString(5));
                cliente.setcel(clientes.getInt(6));
                cliente.setsexo(clientes.getString(7));
                cliente.setfnacimiento(clientes.getString(8));
                cliente.setemail(clientes.getString(9));
                cliente.setocupacion(clientes.getString(10));
                cliente.setfregistro(clientes.getDate(11));                
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return cliente;
    }
    
    public static ArrayList<Cliente> getClienteci(int ciCliente)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where ci = "+ciCliente);
        ArrayList<Cliente> listaclientes= new ArrayList();
        try{
            while(clientes.next())
            {
                Cliente cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setci(clientes.getInt(2));
                cliente.setNombre(clientes.getString(3));
                cliente.setDireccion(clientes.getString(4));
                cliente.setTelefono(clientes.getString(5));
                cliente.setcel(clientes.getInt(6));
                cliente.setsexo(clientes.getString(7));
                cliente.setfnacimiento(clientes.getString(8));
                cliente.setemail(clientes.getString(9));
                cliente.setocupacion(clientes.getString(10));
                cliente.setfregistro(clientes.getDate(11));
                listaclientes.add(cliente);                
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return listaclientes;
    }
    
    public static Cliente getClientePorNombre(String nombre)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where Nombre like '"+nombre+"%' limit 1");
         Cliente cliente = null;
        try{
            while(clientes.next())
            {
                cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setci(clientes.getInt(2));
                cliente.setNombre(clientes.getString(3));
                cliente.setDireccion(clientes.getString(4));
                cliente.setTelefono(clientes.getString(5));
                cliente.setcel(clientes.getInt(6));
                cliente.setsexo(clientes.getString(7));
                cliente.setfnacimiento(clientes.getString(8));
                cliente.setemail(clientes.getString(9));
                cliente.setocupacion(clientes.getString(10));
                cliente.setfregistro(clientes.getDate(11));
               
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return  cliente;
    }
}
