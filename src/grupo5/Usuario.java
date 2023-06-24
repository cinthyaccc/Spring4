package grupo5;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Usuario implements Asesoria{
	//se crean los atributos de la clase Usuario
	 private String nombre;
	 private String fechaDeNacimiento;
	 private int run;
	//se crea el  constructor vacio 
	 public Usuario() {
		}
	 public Usuario(String nombre) {
		this.nombre = nombre;
	 }
	 public Usuario(int run) {
			this.run = run;
		 }
	 
	 //se crea el constructor con todos los atributos de la clase
	public Usuario(String nombre, String fechaDeNacimiento, int run) {
		super();
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.run = run;
	}
	
	//se crean los metodos de acceso y modificadores de yodos los atributos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	//se crea metodo toString
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + ", run=" + run + "]";
	}
	//falta desplegar rut en analizar usuario
	
	public void analizarUsuario() {
        System.out.println("Nombre de usuario: " + nombre);
    }
    
	
	  public void mostrarEdad() {
		    
	        LocalDate fechaNac = LocalDate.parse(fechaDeNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        LocalDate ahora = LocalDate.now();
	        Period periodo = Period.between(fechaNac, ahora);
	        int edad = periodo.getYears();
	        System.out.println("El usuario tiene " + edad + " años");
	    }

	
	 
}
