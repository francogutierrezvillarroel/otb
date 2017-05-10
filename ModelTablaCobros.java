package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author programadorbipolar
 */
public class ModelTablaCobros extends AbstractTableModel{

    private String[] nombreColumnas = {"Vecino","Fec. Inicial","Meses Transcurridos","Fec. de Pago","Rezago","Pago Calculado","Recargo","Total","Fec. de Registro"};
    private ArrayList<Cobro> pagos;
    
    
    public ModelTablaCobros(ArrayList<Cobro> pagos) {
        this.pagos = pagos;
    }

    public ModelTablaCobros() {
        pagos = Cobro.getPagos();
    }  
    
    public ModelTablaCobros(String nombreBuscar) {
        pagos = Cobro.getPagos(nombreBuscar);
    }
    
    
    @Override
    public int getRowCount() {
       return pagos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public Cobro getPago(int index)
    {
        return pagos.get(index);
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cobro pago = pagos.get(rowIndex);
        switch(columnIndex)
        {
            
            case 0: return pago.getNroCuenta().getNombre();
            case 1: return pago.getFormatearFecha(pago.getFechaCubierta(), "dd/MM/yyyy");
            case 2: return pago.getMesesTranscurridos();
            case 3: return pago.getFormatearFecha(pago.getFechaDePago(), "dd/MM/yyyy");
            case 4: return pago.getRezago();
            case 5: return pago.getPagoCalculado();
            case 6: return pago.getRecargo();
            case 7: return pago.getTotal();
            case 8: return pago.getFormatearFecha(pago.getFechaDeRegistro(), "dd/MM/yyyy");    
            default: return null;
        }
    }
    
    public boolean estVacio()
    {
        if(pagos == null)
            return true;
        return false;
    }
    
}
