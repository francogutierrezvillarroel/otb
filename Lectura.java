package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author skysoftgo
 */
public class Lectura {
    
    private int id_medida;
    private int id_propiedad;
    private int medida;
    private int mt3;
    private Double apagar;
    private Date fecha_medida;
    private String mes;
    private String observacion_medida;
    private int estado;
    //consultas sql
    public static String NOMBRE_TABLA = "tblmedida";
    public static String SELECCIONAR_TODO = "select * from "+Lectura.NOMBRE_TABLA;
    public static Integer second =0;

    public Lectura(int id_medida,int id_propiedad, int medida, int mt3 , Double apagar, Date fecha_medida, String mes, String observacion_medida, int estado) {
        this.id_medida = id_medida;
        this.id_propiedad = id_propiedad;
        this.medida = medida;
        this.mt3 = mt3;
        this.apagar = apagar;
        this.fecha_medida = fecha_medida;
        this.mes = mes;
        this.observacion_medida = observacion_medida;
        this.estado= estado;
    }

    public Lectura() {    }

    public Lectura(int id_propiedad, int medida, int mt3 , Double apagar, Date fecha_medida, String mes ,String observacion_medida, int estado) {
        this.id_propiedad = id_propiedad;
        this.medida = medida;
        this.mt3 = mt3;
        this.apagar = apagar;
        this.fecha_medida = fecha_medida;
        this.mes = mes;
        this.observacion_medida = observacion_medida;
        this.estado= estado;
    }
    
    public int getid_medida() {
        return id_medida;
    }
    public void setid_medida(int id_medida) {
        this.id_medida = id_medida;
    }
    
    public int getid_propiedad() {
        return id_propiedad;
    }
    public void setid_propiedad(int id_propiedad) {
        this.id_propiedad = id_propiedad;
    }
    
    public int getmedida() {
        return medida;
    }
    public void setmedida(int medida) {
        this.medida = medida;
    }
    
    public int getmt3() {
        return mt3;
    }
    public void setmt3(int mt3) {
        this.mt3 = mt3;
    }
      
    public Double getapagar() {
        return apagar;
    }
    public void setapagar(Double apagar) {
        this.apagar = apagar;
    }
    
    public Date getfecha_medida() {
        return fecha_medida;
    }
    public void setfecha_medida(Date fecha_medida) {
        this.fecha_medida = fecha_medida;
    }
    
    public String getmes() {
        return mes;
    }
    public void setmes(String mes) {
        this.mes = mes;
    }
   
    public String getobservacion_medida() {
        return observacion_medida;
    }
    public void setobservacion_medida(String observacion_medida) {
        this.observacion_medida = observacion_medida;
    }
      
    public int getestado() {
        return estado;
    }
    public void setestado(int estado) {
        this.estado = estado;
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
    
    public int grabar(){
        String sql = "INSERT INTO tblmedida (id_propiedad,                     medida,         mt3,            apagar,    fecha_medida, mes, observacion_medida, estado)"+
                                    "VALUES ('"+this.id_propiedad+"',    '"+this.medida+"','"+this.mt3+"','"+this.apagar+"','"+this.getFormatearFecha(this.fecha_medida,null)+"','"+this.mes+"','"+this.observacion_medida+"','"+this.estado+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblmedida SET id_propiedad = '"+this.id_propiedad+"', medida = '"+this.medida+"', mt3 = '"+this.mt3+"', apagar = '"+this.apagar+"', fecha_medida = '"+this.getFormatearFecha(this.fecha_medida,null)+"', mes = '"+this.mes+"',"+
                      "observacion_medida = '"+this.observacion_medida+"', estado = '"+this.estado+"' WHERE id_medida = "+this.id_medida;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        
        String sql = "DELETE FROM tblmedida WHERE ID_MEDIDA = "+this.id_medida;
        return Conexion.guardarRegistro(sql);
        
    }
    
    public static ArrayList getLecturasnew(){
        ResultSet lecturas = Conexion.getRegistros("SELECT * FROM propiedad ");
        ArrayList ListaLecturas= new ArrayList();
         try{
            while(lecturas.next()){
                int indice = lecturas.getInt(1);
                Object o= null;
                Double[][] campo=new Double[100][3];
                
                campo[0][0] = lecturas.getDouble(4);
                campo[0][1] = lecturas.getDouble(4);
                campo[0][2] = lecturas.getDouble(4);
                ResultSet lecturasxid = Conexion.getRegistros("SELECT * FROM tblmedida where ID_PROPIEDAD="+indice+"");
                try{
                    //if(lecturasxid.getRow() > 0){
                        int i=1; int j=0;
                        while(lecturasxid.next()){
                            //System.out.print(lecturasxid.getDouble(5)+"\n");
                            campo[i][0]=Double.valueOf(lecturasxid.getInt(3));
                            campo[i][1]=Double.valueOf(lecturasxid.getInt(4));
                            campo[i][2]=lecturasxid.getDouble(5);
                            i++;
                            
                        }
                        lecturasxid.close();
                        Conexion.con.close();
                        ListaLecturas.add(campo);
                    //}else{System.out.print("no entro ala consulta \n");}
                }catch(SQLException ex){ex.printStackTrace();}
                
            }
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaLecturas;
        //return campo[][];
    }
    
    public static ArrayList<Lectura> getLecturas(){
        ResultSet lecturas = Conexion.getRegistros(Lectura.SELECCIONAR_TODO);
        ArrayList<Lectura> ListaLecturas= new ArrayList();
         try{
            while(lecturas.next())
            {
                Lectura lectura1 = new Lectura();
                lectura1.setid_medida(lecturas.getInt(1));
                lectura1.setid_propiedad(lecturas.getInt(2));
                lectura1.setmedida(lecturas.getInt(3));
                lectura1.setmt3(lecturas.getInt(4));
                lectura1.setapagar(lecturas.getDouble(5));
                lectura1.setfecha_medida(lecturas.getDate(6));
                lectura1.setmes(lecturas.getString(7));
                lectura1.setobservacion_medida(lecturas.getString(8));
                ListaLecturas.add(lectura1);
            }
            lecturas.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaLecturas;
    }
    
    public static ArrayList<Lectura> getLectura(int medida)
    {
        ResultSet lecturas = Conexion.getRegistros(Lectura.SELECCIONAR_TODO+" where MEDIDA like '"+medida+"%'");
        ArrayList<Lectura> ListaLecturas= new ArrayList();
         try{
            while(lecturas.next())
            {
                Lectura lectura = new Lectura();
                lectura.setid_medida(lecturas.getInt(1));
                lectura.setid_propiedad(lecturas.getInt(2));
                lectura.setmedida(lecturas.getInt(3));
                lectura.setmt3(lecturas.getInt(4));
                lectura.setapagar(lecturas.getDouble(5));
                lectura.setfecha_medida(lecturas.getDate(6));
                lectura.setmes(lecturas.getString(7));
                lectura.setobservacion_medida(lecturas.getString(8));
                ListaLecturas.add(lectura);
            }
            lecturas.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         if(ListaLecturas.size()>0)
            return ListaLecturas;
         return null;
    }
    
    public static Lectura getCasa(int id_propiedad)
    {
        ResultSet lecturas = Conexion.getRegistros(Lectura.SELECCIONAR_TODO+" where id_propiedad = "+id_propiedad);
        Lectura lectura = null;
        try{
            while(lecturas.next())
            {
                lectura = new Lectura();
                lectura.setid_medida(lecturas.getInt(1));
                lectura.setid_propiedad(lecturas.getInt(2));
                lectura.setmedida(lecturas.getInt(3));
                lectura.setmt3(lecturas.getInt(4));
                lectura.setapagar(lecturas.getDouble(5));
                lectura.setfecha_medida(lecturas.getDate(6));
                lectura.setmes(lecturas.getString(7));
                lectura.setobservacion_medida(lecturas.getString(8));                
            }
            lecturas.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return lectura;
    }
    
    public static ArrayList<Lectura> getNCasa(int ncasa)
    {
        ResultSet first = Conexion.getRegistros("select * from propiedad where numero = "+ncasa);
        try{
            while(first.next()){
                second = first.getInt(1);
            }
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        ResultSet lecturas = Conexion.getRegistros("select * from tblmedida where id_propiedad = "+second);
        ArrayList<Lectura> ListaLecturas= new ArrayList();
        Lectura lectura = null;
        try{
            while(lecturas.next())
            {
                lectura = new Lectura();
                lectura.setid_medida(lecturas.getInt(1));
                lectura.setid_propiedad(lecturas.getInt(2));
                lectura.setmedida(lecturas.getInt(3));
                lectura.setmt3(lecturas.getInt(4));
                lectura.setapagar(lecturas.getDouble(5));
                lectura.setfecha_medida(lecturas.getDate(6));
                lectura.setmes(lecturas.getString(7));
                lectura.setobservacion_medida(lecturas.getString(8));
                ListaLecturas.add(lectura);                
            }
            lecturas.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return ListaLecturas;
    }
    
    public static Lectura getLecuraPorMes(int mes)
    {
        ResultSet lecturas = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where mes like '"+mes+"%'");
        Lectura lectura = null;
        try{
            while(lecturas.next())
            {lectura = new Lectura();
                lectura.setid_medida(lecturas.getInt(1));
                lectura.setid_propiedad(lecturas.getInt(2));
                lectura.setmedida(lecturas.getInt(3));
                lectura.setmt3(lecturas.getInt(4));
                lectura.setapagar(lecturas.getDouble(5));
                lectura.setfecha_medida(lecturas.getDate(6));
                lectura.setmes(lecturas.getString(7));
                lectura.setobservacion_medida(lecturas.getString(8));
               
            }
            lecturas.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return  lectura;
    }
}
