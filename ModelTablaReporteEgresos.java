package clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author programadorbipolar
 */
public class ModelTablaReporteEgresos extends ModelTablaPagos{
    
    private String[] nombreColumnas = {"ID Pago","Fecha de Pago","Motivo del Pago","Monto del Pago","Observación","ID OTB"};
    private ArrayList<Pago> pagos;

    public ModelTablaReporteEgresos(Date fechaInicio, Date fechaFinal) {
        
        pagos = Pago.getPagos(this.getFormatearFecha(fechaInicio, null),this.getFormatearFecha(fechaFinal, null));
     }
     
    @Override
    public Pago getPago(int index) {
        return pagos.get(index); 
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

    @Override
    public int getRowCount() {
        return pagos.size(); 
    }
     
     

    @Override
    public String getColumnName(int column) {
        return this.nombreColumnas[column];
    }
     
     
    
     public int getColumnCount() {
        return nombreColumnas.length;
    }
    
     public Object getValueAt(int rowIndex, int columnIndex) {
         if(pagos.size() == 0)
             return null;
        Pago pago = pagos.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return pago.getid_pago();
            case 1: return pago.getFormatearFecha(pago.getfecha_pago(), "dd/MM/yyyy");
            case 2: return pago.getmotivo_pago();
            case 4: return pago.getmonto_pago();
            case 5: return pago.getobs();
            case 6: return pago.getid_otb();                
            default: return null;
        }
    }
     
     public float getTotales()
     {
         float total = 0;
         for(Pago pago: pagos)
         {             
            total += pago.getmonto_pago();
         }
         return total;
     }

    @Override
    public boolean estVacio() {
        return this.pagos.isEmpty();
    }
     
     public void limpiar()
     {
         pagos.clear();
         this.fireTableRowsDeleted(pagos.size(), pagos.size());
     }
}
