package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author programadorbipolar
 */
public class ModelTablaPagos extends AbstractTableModel{

    private String[] nombreColumnas = {"ID Pago","Fecha del Pago","Monto del Pago","Motivo del Pago","Observación","ID_OTB","Nro Folio"};
    private ArrayList<Pago> pagos;
    
    
    public ModelTablaPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    public ModelTablaPagos() {
        pagos = Pago.getPagos();
    }  
    
    public ModelTablaPagos(String nombreBuscar) {
        pagos = Pago.getPagos(nombreBuscar);
    }
    public ModelTablaPagos(int nBuscar) {
        pagos = Pago.getPagos(nBuscar);
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
    
    public Pago getPago(int index)
    {
        return pagos.get(index);
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pago pago = pagos.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return pago.getid_pago();
            case 1: return pago.getFormatearFecha(pago.getfecha_pago(), "dd/MM/yyyy");
            case 2: return pago.getmonto_pago();
            case 3: return pago.getmotivo_pago();
            case 4: return pago.getobs();
            case 5: return pago.getid_otb();
            case 6: return pago.getnrofolio();
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
