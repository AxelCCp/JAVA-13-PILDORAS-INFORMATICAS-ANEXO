package swingAvanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class A3_268_UsoJTable2 {
	public static void main(String[]arg) {
		
		JFrame miMarco = new MarcoTablaPersonalizado();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}
}


class MarcoTablaPersonalizado extends JFrame {
	public MarcoTablaPersonalizado() {
		setTitle("Tabla personalizada");
		setBounds(300,300,200,400);
		
		TableModel miModelo = new ModeloTablaPersonalizada();
		JTable miTabla = new JTable(miModelo);
		
		add(new JScrollPane(miTabla));
	}
}


class ModeloTablaPersonalizada extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		int z = rowIndex + 1;
		int y = columnIndex + 2;
		
		return " " + z + " " + y;
		
	}
	
	public String getColumnName(int c) {
		
		return "Columna " + c;
		
	}
	
}



