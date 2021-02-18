package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class A4_269_TablaProductos {
	public static void main(String[]args) {
		
		MarcoProductos miMarco = new MarcoProductos();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}
}



class MarcoProductos extends JFrame{
	
	public MarcoProductos(){
		
		setTitle("Productos");		
		setBounds(500,300,800,400);
		JPanel superior = new JPanel();
		nombresDeTablas= new JComboBox();
		
		//------CONEXIÓN
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			datosBBDD = miConexion.getMetaData();
			rs = datosBBDD.getTables(null, null, null, null); 
			
			while(rs.next()) {
				
				nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		}catch(Exception e){
			System.out.println("No Conecta");
			e.printStackTrace();
		}
		
		//------
		
		//------PONEMOS A LA ESCUCHA AL JCOMBOBOX
		
		nombresDeTablas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tablaSeleccionada = (String) nombresDeTablas.getSelectedItem();
				
				String consulta = "SELECT * FROM " + tablaSeleccionada; 
				
				try {
					sentencia = miConexion.createStatement();
					rs = sentencia.executeQuery(consulta);
					
					//while(rs.next()) {
						//System.out.println(rs.getString("NOMBREARTÍCULO") + " " + rs.getString("CÓDIGOARTÍCULO"));
					//}
					
					modelo = new ResultSetModeloTabla(rs);
					JTable tabla = new JTable(modelo);
					add(new JScrollPane(tabla),BorderLayout.CENTER);
					validate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
		superior.add(nombresDeTablas);
		add(superior,BorderLayout.NORTH);
		
	}
	
	private JComboBox nombresDeTablas;
	private DatabaseMetaData datosBBDD;
	private ResultSet rs;
	private Connection miConexion;
	private Statement sentencia;
	private ResultSetModeloTabla modelo;
}

class ResultSetModeloTabla extends AbstractTableModel{

	public ResultSetModeloTabla(ResultSet unResultSet) {
		
		rsRegistros = unResultSet;
		try {
			resmd =rsRegistros.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return resmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		try {
			rsRegistros.last();
			return rsRegistros.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
			
		}
		
		
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		try {
			rsRegistros.absolute(arg0+1);
			return rsRegistros.getObject(arg1+1);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String getColumnName(int c) {
		
		try {
			
			return resmd.getColumnName(c+1);
			
		}catch(Exception e ) {
			
			e.printStackTrace();
			
			return null;
			
		}
		
		
	}
	
	private ResultSet rsRegistros;
	private ResultSetMetaData resmd;
	
}
