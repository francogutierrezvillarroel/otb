package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author skysoftgo
 */
public class ModelTablaLecturas extends AbstractTableModel{

    //private String[] Meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    private String[] nombreColumnas = {"Nombre","Nº de Casa","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.",
                                      "Lectura", "MT3", "Bs.", "Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs."};
    private ArrayList<LecturaGeneral> lecturas;
    private LecturaGeneral lecturas1;
    
     public ModelTablaLecturas(ArrayList<LecturaGeneral> lecturas) {
        this.lecturas = lecturas;
    }

    public ModelTablaLecturas() {
        lecturas = LecturaGeneral.getLecturaGeneral();  
    }  
    
    public ModelTablaLecturas(int busquedaint) {
        lecturas1 = LecturaGeneral.getLectura(busquedaint);
    }

    
    @Override
    public int getRowCount() {
        return lecturas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LecturaGeneral lectur = lecturas.get(rowIndex);
        switch(columnIndex)
        {
            
            case 0: return lectur.getnombre();
            case 1: return lectur.getncasa();
            case 2: return lectur.getmedida();
            case 3: return lectur.getmt3();
            case 4: return lectur.getapagar();
            default: return null;
            
        }
    }    
    /*
    public int Eliminar(int rowIndex)
    {
        LecturaGeneral lectura = lecturas.get(rowIndex);
        lecturas.remove(rowIndex);
        int borrar = lectura.borrar();
        this.fireTableRowsDeleted(lecturas.size(), lecturas.size());
        return borrar;
    }
    */
    public LecturaGeneral getLectura(int indice)
    {
        return lecturas.get(indice);
    }
    
    public boolean estVacio()
    {
        if(lecturas == null)
            return true;
        return false;
    }
    
}
