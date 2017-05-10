package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author skysoftgo
 */
public class Pago {
    private int id_pago;
    private Date fecha_pago;
    private String motivo_pago;
    private double monto_pago;
    private String obs;
    private int id_otb; 
    private int nrofolio;
    
    //consultas sql
    public static String NOMBRE_TABLA = "tblpago";
    public static String SELECCIONAR_TODO = "select * from "+Pago.NOMBRE_TABLA;
    
    public Pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Pago(int id_pago, Date fecha_pago) {
        this.id_pago = id_pago;
        this.fecha_pago = fecha_pago;
    }

    public Pago(int id_pago, Date fecha_pago, double monto_pago, String motivo_pago, String obs, int id_otb, int nrofolio) {
        this.id_pago = id_pago;
        this.fecha_pago = fecha_pago;
        this.monto_pago = monto_pago;
        this.motivo_pago = motivo_pago;
        this.obs = obs;
        this.id_otb = id_otb;
        this.nrofolio = nrofolio;
    }

    public Pago() {
    }    
    

    public int getid_pago() {
        return id_pago;
    }

    public void setid_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getfecha_pago() {
        return fecha_pago;
    }

    public void setfecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    public Double getmonto_pago() {
        return monto_pago;
    }

    public void setmonto_pago(Double monto_pago) {
        this.monto_pago = monto_pago;
    }
    
    public String getmotivo_pago() {
        return motivo_pago;
    }

    public void setmotivo_pago(String motivo_pago) {
        this.motivo_pago = motivo_pago;
    }

    public String getobs() {
        return obs;
    }

    public void setobs(String obs) {
        this.obs = obs;
    }

    public int getid_otb() {
        return id_otb;
    }

    public void setid_otb(int id_otb) {
        this.id_otb = id_otb;
    }

    public int getnrofolio() {
        return nrofolio;
    }

    public void setnrofolio(int nrofolio) {
        this.nrofolio = nrofolio;
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
        String sql = "INSERT INTO tblpago (Fecha_Pago,Monto_Pago,Motivo_Pago,Observacion,ID_OTB,NroFolio)"+
             "VALUES ('"+this.getFormatearFecha(this.fecha_pago, null)+"','"+this.monto_pago+"','"+this.motivo_pago+"','"+this.obs+"','"+this.id_otb+"','"+this.nrofolio+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblpago SET ID_PAGO = '"+this.id_pago+"',"+
                    "Fecha_Pago  = '"+this.getFormatearFecha(this.fecha_pago, null)+"',"+
                    "Monto_Pago  = '"+this.monto_pago+"',"+
                    "Motivo_Pago = '"+this.motivo_pago+"',"+
                    "Observacion = '"+this.obs+"',"+
                    "ID_OTB      = '"+this.id_otb+"',"+
                    "NroFolio    = '"+this.nrofolio+"'"+
                    " WHERE ID_PAGO = "+this.id_pago;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        String sql = "DELETE FROM tblpago WHERE ID_PAGO = "+this.id_pago;
        return Conexion.guardarRegistro(sql);
    }
    
    public static ArrayList<Pago> getPagos(){
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO);
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setid_pago(pagos.getInt(1));
                pago.setfecha_pago(pagos.getDate(2));
                pago.setmonto_pago(pagos.getDouble(3));
                pago.setmotivo_pago(pagos.getString(4));
                pago.setobs(pagos.getString(5));
                pago.setid_otb(pagos.getInt(6));
                pago.setnrofolio(pagos.getInt(7));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaPagos;
    }
    
    public static ArrayList<Pago> getPagos(String fechaInicio, String FechaFinal){
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO+" where Fecha_Pago >= '"+fechaInicio+"' and Fecha_Pago<='"+FechaFinal+"'");
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setid_pago(pagos.getInt(1));
                pago.setfecha_pago(pagos.getDate(2));
                pago.setmonto_pago(pagos.getDouble(3));
                pago.setmotivo_pago(pagos.getString(4));
                pago.setobs(pagos.getString(5));
                pago.setid_otb(pagos.getInt(6));
                pago.setnrofolio(pagos.getInt(7));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaPagos;
    }
    
    
    public static ArrayList<Pago> getPagos(String nombreCliente)
    {
        Cliente cliente = Cliente.getClientePorNombre(nombreCliente);
        if(cliente == null)
            return null;
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO+" where NoCuenta = "+cliente.getNumeroCuenta());
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setid_pago(pagos.getInt(1));
                pago.setfecha_pago(pagos.getDate(2));
                pago.setmonto_pago(pagos.getDouble(3));
                pago.setmotivo_pago(pagos.getString(4));
                pago.setobs(pagos.getString(5));
                pago.setid_otb(pagos.getInt(6)); 
                pago.setnrofolio(pagos.getInt(7));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         if(ListaPagos.size()>0)
            return ListaPagos;
         return null;
    }
    
    public static ArrayList<Pago> getPagos(int nPago)
    {
        //Cliente cliente = Cliente.getClientePorNombre(nPago);
        //if(cliente == null)
        //    return null;
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO+" where Monto_Pago = "+nPago);
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setid_pago(pagos.getInt(1));
                pago.setfecha_pago(pagos.getDate(2));
                pago.setmonto_pago(pagos.getDouble(3));
                pago.setmotivo_pago(pagos.getString(4));
                pago.setobs(pagos.getString(5));
                pago.setid_otb(pagos.getInt(6)); 
                pago.setnrofolio(pagos.getInt(7));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         if(ListaPagos.size()>0)
            return ListaPagos;
         return null;
    }
    
    
}
