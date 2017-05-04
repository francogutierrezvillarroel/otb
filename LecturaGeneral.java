package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author skysoftgo
 */
public class LecturaGeneral {
    
    private String nombre;
    private int ncasa;
    private int medida;
    private int mt3;
    private double apagar;
    
    //consultas sql
    public static String NOMBRE_TABLA = "tblmedida";
    public static String SELECCIONAR_TODO = "select * from "+Lectura.NOMBRE_TABLA;
    public static Integer second =0;

    public LecturaGeneral(String nombre,int ncasa, int medida, int mt3 , double apagar) {
        this.nombre = nombre;
        this.ncasa = ncasa;
        this.medida = medida;
        this.mt3 = mt3;
        this.apagar = apagar;
    }

    public LecturaGeneral() {    }
    /*
    public Lectura(int id_propiedad, int medida, int mt3 , Double apagar, Date fecha_medida,String mes ,String observacion_medida) {
        this.id_propiedad = id_propiedad;
        this.medida = medida;
        this.mt3 = mt3;
        this.apagar = apagar;
        this.fecha_medida = fecha_medida;
        this.mes = mes;
        this.observacion_medida = observacion_medida;
    }
    */
    
    
    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getncasa() {
        return ncasa;
    }
    public void setncasa(int ncasa) {
        this.ncasa = ncasa;
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
      
    public double getapagar() {
        return apagar;
    }
    public void setapagar(double apagar) {
        this.apagar = apagar;
    }

    /*    
    public int grabar()
    {
        String sql = "INSERT INTO tblmedida (id_propiedad,                     medida,         mt3,            apagar,    fecha_medida, mes, observacion_medida)"+
                                    "VALUES ('"+this.id_propiedad+"',    '"+this.medida+"','"+this.mt3+"','"+this.apagar+"','"+this.getFormatearFecha(this.fecha_medida,null)+"','"+this.mes+"','"+this.observacion_medida+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblmedida SET id_propiedad = '"+this.id_propiedad+"',"+
                      "medida = '"+this.medida+"',"+
                      "mt3 = '"+this.mt3+"',"+
                      "apagar = '"+this.apagar+"',"+
                      "fecha_medida = '"+this.getFormatearFecha(this.fecha_medida,null)+"'"+
                      "mes = '"+this.mes+"',"+
                      "observacion_medida = '"+this.observacion_medida+"',"+
                      " WHERE id_propiedad = "+this.id_propiedad;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        String sql = "DELETE FROM tblmedida WHERE ID_MEDIDA = "+this.id_medida;
        return Conexion.guardarRegistro(sql);
    }
    */
    public static ArrayList<LecturaGeneral> getLecturaGeneral(){
        LecturaGeneral lectura = new LecturaGeneral();
        ResultSet lecturas = Conexion.getRegistros("SELECT * FROM propiedad ");
        ArrayList<LecturaGeneral> ListaLecturas= new ArrayList();
         try{
            while(lecturas.next()){
                int indice = lecturas.getInt(1);
                int indice1 = lecturas.getInt(3);
                lectura.setncasa(lecturas.getInt(4));
                //System.out.print(lecturas.getInt(4)+"\n");
                ResultSet lecturaname = Conexion.getRegistros("SELECT * FROM tblcliente where NoCuenta="+indice1+"");
                try{
                    while(lecturaname.next()){    
                        lectura.setnombre(lecturaname.getString(3));
                        //System.out.print(lecturaname.getString(3)+"\n");
                    }
                        lecturaname.close();
                       
                }catch(SQLException ex){ex.printStackTrace();}
                ResultSet lecturasxid = Conexion.getRegistros("SELECT * FROM tblmedida where ID_PROPIEDAD="+indice+"");
                try{                    
                        while(lecturasxid.next()){
                            //System.out.print(lecturasxid.getInt(3)+"\n");
                            //System.out.print(lecturasxid.getInt(4)+"\n");
                            //System.out.print(lecturasxid.getDouble(5)+"\n");
                            lectura.setmedida(lecturasxid.getInt(3));
                            lectura.setmt3(lecturasxid.getInt(4));
                            lectura.setapagar(lecturasxid.getDouble(5));                            
                        }
                        lecturasxid.close();
                        Conexion.con.close();                        
                    //}else{System.out.print("no entro ala consulta \n");}
                }catch(SQLException ex){ex.printStackTrace();} 
                ListaLecturas.add(lectura);
            }
        }catch(SQLException ex){ex.printStackTrace();}
         
        return ListaLecturas;        
    }
    /*
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
    */
    public static LecturaGeneral getLectura(int medida)
    {
        ResultSet lecturas = Conexion.getRegistros("SELECT * FROM propiedad Where MEDIDA="+medida+"");
        LecturaGeneral Lectura= new LecturaGeneral();
         try{
            while(lecturas.next()){
                int indice = lecturas.getInt(1);
                int indice1 = lecturas.getInt(3);
                Lectura.setncasa(lecturas.getInt(4));
                ResultSet lecturaname = Conexion.getRegistros("SELECT Nombre FROM tblcliente where NoCuenta="+indice1+"");
                try{
                    while(lecturaname.next()){    
                        Lectura.setnombre(lecturaname.getString(0));
                    }
                        lecturaname.close();
                        Conexion.con.close(); 
                }catch(SQLException ex){ex.printStackTrace();}
                ResultSet lecturasxid = Conexion.getRegistros("SELECT * FROM tblmedida where ID_PROPIEDAD="+indice+"");
                try{                    
                        while(lecturasxid.next()){
                            //System.out.print(lecturasxid.getDouble(5)+"\n");
                            Lectura.setmedida(lecturasxid.getInt(3));
                            Lectura.setmt3(lecturasxid.getInt(4));
                            //Lectura.setapagar(lecturasxid.getDouble(5));                            
                        }
                        lecturasxid.close();
                        Conexion.con.close();                        
                    //}else{System.out.print("no entro ala consulta \n");}
                }catch(SQLException ex){ex.printStackTrace();}                 
            }
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return Lectura;
    }
    /*
    public static Lectura getCasa(int id_propiedad)
    {
        ResultSet lecturas = Conexion.getRegistros(Lectura.SELECCIONAR_TODO+" where id_propiedad = "+id_propiedad);
        LecturaGeneral lectura = null;
        try{
            while(lecturas.next())
            {
                lectura = new LecturaGeneral();
                lectura.setnombre(lecturas.getString(1));
                lectura.setncasa(lecturas.getInt(2));
                lectura.setmedida(lecturas.getInt(3));
                lectura.setmt3(lecturas.getInt(4));
                lectura.setapagar(lecturas.getDouble(5));               
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
    */
}
