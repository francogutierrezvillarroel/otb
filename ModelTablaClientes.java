package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author skysoftgo
 */
public class ModelTablaClientes extends AbstractTableModel{

    private String[] nombreColumnas = {"ci","Nombre Completo ","Direccion","Telefono","celular","sexo","fecha nacimiento","email","ocupacion","fecha Resgistro"};
    private ArrayList<Cliente> clientes;
    
     public ModelTablaClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ModelTablaClientes() {
        clientes = Cliente.getClientes();
    }  
    
    public ModelTablaClientes(String nombreBuscar) {
        clientes = Cliente.getCliente(nombreBuscar);
    }
    
    public ModelTablaClientes(int ciBuscar) {
        clientes = Cliente.getClienteci(ciBuscar);
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return cliente.getci();
            case 1: return cliente.getNombre();
            case 2: return cliente.getDireccion();
            case 3: return cliente.getTelefono();
            case 4: return cliente.getcel();
            case 5: return cliente.getsexo();
            case 6: return cliente.getfnacimiento();
            case 7: return cliente.getemail();
            case 8: return cliente.getocupacion();
            case 9: return cliente.getFormatearFecha(cliente.getfregistro(),"dd/MM/yyyy");
            default: return null;    
                
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public int Eliminar(int rowIndex)
    {
        Cliente cliente = clientes.get(rowIndex);
        clientes.remove(rowIndex);
        int borrar = cliente.borrar();
        this.fireTableRowsDeleted(clientes.size(), clientes.size());
        return borrar;
    }
    
    public Cliente getCliente(int indice)
    {
        return clientes.get(indice);
    }
    
    public Cliente getClienteci(int indice)
    {
        return clientes.get(indice);
    }
    
    public boolean estVacio()
    {
        if(clientes == null)
            return true;
        return false;
    }
    
}
