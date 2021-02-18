package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class A2_267_LosPlanetas {
	
	public static void main(String[]args) {
	
		
		MarcoPlanetas miMarco = new MarcoPlanetas();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
		
	}
	
	
}


class MarcoPlanetas extends JFrame{
	
	public MarcoPlanetas() {
		
		setTitle("Los Planetas");
		setBounds(350,100,600,600);
		JTable tablaPlanetas = new JTable(datosFila,nombreColumnas); 
		add(new JScrollPane(tablaPlanetas),BorderLayout.CENTER);
		JButton botonImprimir = new JButton("Imprimir Tabla");
		botonImprimir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					
					tablaPlanetas.print();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		
		JPanel laminaBoton = new JPanel();
		
		laminaBoton.add(botonImprimir);
		
		add(laminaBoton,BorderLayout.SOUTH);
		
	}
	
	private String[]nombreColumnas = {"Nombre","Radio","Lunas","Gaseoso"};
	
	private Object[][]datosFila = {
			
			{"Mercurio",2440.0, 0, false},
			{"Venus",2440.0, 0, false},
			{"Tierra",2440.0, 0, false},
			{"Marte",2440.0, 0, false},
			{"Jupiter",2440.0, 0, false},
			{"Saturno",2440.0, 0, false},
			{"Urano",2440.0, 0, false},
			{"Neptuno",2440.0, 0, false},
			{"Plutón",2440.0, 0, false},
	};
	
}
