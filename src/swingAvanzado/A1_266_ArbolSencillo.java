package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class A1_266_ArbolSencillo {

		public static void main(String[]args) {
		
			marco miMarco = new marco();
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			miMarco.setVisible(true);
			
		}
		
}


class marco extends JFrame{
	
	public marco() {
		
		setTitle("Arbol Sencillo");
		setBounds(350,100,600,600);
		
		//Construimos el nodo que corresponderá a la raíz
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
		
		DefaultMutableTreeNode pais = new DefaultMutableTreeNode("España");
		
		raiz.add(pais);
		
		DefaultMutableTreeNode comunidad = new DefaultMutableTreeNode("Madrid");
		
		pais.add(comunidad);
		
		DefaultMutableTreeNode mostoles= new DefaultMutableTreeNode("Mostoles");
		
		comunidad.add(mostoles);
		
		DefaultMutableTreeNode alcobendas = new DefaultMutableTreeNode("Alcobendas");
		
		comunidad.add(alcobendas);
		
		
		//--------
		
		
		comunidad = new DefaultMutableTreeNode("Cantabria");
		
		pais.add(comunidad);
		
		DefaultMutableTreeNode santillana= new DefaultMutableTreeNode("Santillana del Mar");
		
		comunidad.add(santillana);
		
		
		//---------
		
		
		pais = new DefaultMutableTreeNode("Alemania");
		
		raiz.add(pais);
		
		comunidad = new DefaultMutableTreeNode("Baviera");
		
		pais.add(comunidad);
		
		DefaultMutableTreeNode munich = new DefaultMutableTreeNode("Munich");
		
		comunidad.add(munich);
		
		
		//CREAMOS EL ARBOL
		JTree arbol = new JTree(raiz);
		//LaminaArbol lamina = new LaminaArbol(arbol);
		//add(lamina);
		
		
		//CONSTRUIMOS BARRAS DE DESPLAZAMIENTO....el método nos devuelve un obj de tipo container
		Container laminaContenido = getContentPane();
		
		
		laminaContenido.add(new JScrollPane(arbol));
	}

}









/*
class LaminaArbol extends JPanel {
	//EL CONSTRUCTOR RECIBE UN OBJ DE TIPO JTREE
	public LaminaArbol(JTree miArbol) {
		//ESTABLECEMOS UN LAYOUT PARA LA DISTRIBUCIÓN DENTRO DE LA LAMINA
		setLayout(new BorderLayout());
		add(miArbol, BorderLayout.NORTH);
	}
}  
*/
