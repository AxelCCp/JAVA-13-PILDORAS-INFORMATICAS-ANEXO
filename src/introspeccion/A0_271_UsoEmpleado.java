package introspeccion;

public class A0_271_UsoEmpleado {
	
	public static void main(String[]args) {
	
		Persona antonio = new Persona("Antonio");
		System.out.println(antonio.getNombre());
		
		Empleado ana = new Empleado("Ana", 5000);
		System.out.println(ana.getNombre());
		System.out.println(ana.getSalario());
		
		System.out.println(antonio.getClass());
	}
}

/**
 * 
 * @author Fantasma
 *
 */

class Persona{
	
	/**
	 * 
	 * @param nombre
	 */
	public Persona(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		
		return nombre;
	}
	private String nombre;
}



class Empleado extends Persona{

	public Empleado(String nombre, double salario) {
		super(nombre);
		// TODO Auto-generated constructor stub
		
		this.salario = salario;
	}
	
	public void setInsentivo(double	insentivo) {
		
		salario = salario + insentivo; 
		
	}
	public String getSalario() {
		return "El salario es: " + salario;
	}
	private double salario;
	
}
