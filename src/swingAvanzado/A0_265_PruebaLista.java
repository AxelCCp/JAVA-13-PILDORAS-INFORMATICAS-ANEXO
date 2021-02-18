package swingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class A0_265_PruebaLista {
	
	public static void main(String [] args) {
		
		MarcoL miMarcoZ = new MarcoL();
		
		miMarcoZ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarcoZ.setVisible(true);
		
	}
}



class MarcoL extends JFrame{
	
	public MarcoL() {
	
		setTitle("Prueba de lista");
		setBounds(400,300,400,300);
		
		String [] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		
		//INSTANCIAMOS EL JLIST Y LO NOMBRAMOS "MESES"
		listaDeMeses=new JList<String>(meses);
		
		//CON ESTE MÉTODO DETERMINAMOS LA CANTIDAD DE ELEMENTOS QUE QUEREMOS VER
		listaDeMeses.setVisibleRowCount(4);
		
		//LAMINA DE LA BARRA DE DESPLAZAMIENTO Y SE LO AGREGAMOS A LISTADEMESES
		JScrollPane laminaDeDesplazamiento =new JScrollPane(listaDeMeses);
		
		laminaDeLista = new JPanel();
		
		laminaDeLista.add(laminaDeDesplazamiento);
		
		//PONEMOS A LISTADEMESES A LA ESCUCHA
		listaDeMeses.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				//PARA CAPTURAR LOS ELEMENTOS SELECCIONADOS Y DEVOLVERLOS EN UNA LISTA
				List<String>valores = listaDeMeses.getSelectedValuesList();
				
				//PARA QUE LA LISTA DE VALORES SELECCIONADOS SE VAYAN AGREGANDO AL RÓTULO
				StringBuilder texto = new StringBuilder("Mes Seleccionado: " );
				
				//RECORREMOS LA LISTA DE VALORES
				for(String X : valores) {
					String palabra = X;
					texto.append(palabra);
					texto.append("	");
					
				}
				
				//LE DECIMOS QUE A NUESTRO RÓTULO LE ESTABLEZCA COMO TEXTO, EL STRINGBUILDER, EL QUE A SU VEZ ES
				//..CONVERTIDO A STRING
				rotulo.setText(texto.toString());
			}
			
		});
		
		
		laminaDeTexto = new JPanel();
		
		rotulo = new JLabel("Mes seleccionado");
		
		laminaDeTexto.add(rotulo);
		
		add(laminaDeLista,BorderLayout.NORTH);
		
		add(laminaDeTexto,BorderLayout.SOUTH);
	
		
	}
	
	//CAMPOS DE CLASE
	private JList<String> listaDeMeses;
	private JPanel laminaDeLista, laminaDeTexto;
	private JLabel rotulo;
	
}
