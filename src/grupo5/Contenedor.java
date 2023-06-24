package grupo5;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class Contenedor {
	//Se cran las listas
	private List<Asesoria> usuarios;
	private List<Capacitacion> capacitaciones;
	int cantidadUsuarios;

	public Contenedor() {
		//se inicializan las listas
		usuarios = new ArrayList<>();
		capacitaciones = new ArrayList<>();
	
	}
	//se crea el metodo agregarCliente
	public void agregarCliente(Cliente cliente) {
		usuarios.add(cliente);
		System.out.println(usuarios);

	}
	//se crea el metodo agregarPorfesional
	public void agregarProfesional(Profesional profesional) {
		usuarios.add(profesional);
		System.out.println(usuarios);
	}
	//se crea el metodo agregarAdministrativo
	public void agregarAdministrativo(Adiministrativo administrativo) {
		usuarios.add(administrativo);
		System.out.println(usuarios);
	}
	//se crea el metodo agregarCapacitacion
	public void agregarCapacitacion(Capacitacion capacitacion) {
		capacitaciones.add(capacitacion);

	}
	//se crea el metodo eliminarUsuario
	public void eliminarUsuario(int runCompara) {
		boolean usuarioEncontrado = false;
		for (Asesoria asesoria : usuarios) {
			if (asesoria instanceof Usuario) {
				Usuario usuario = (Usuario) asesoria;
				System.out.println("run" + usuario.getRun());

				if (usuario.getRun() == runCompara) {
					usuarios.remove(asesoria);
					System.out.println("Usuario eliminado con éxito");
					usuarioEncontrado = true;
					break;
				}
			}
		}
		if (!usuarioEncontrado) {
			System.out.println("Usuario no registrado");
		}
	}
	//se crea el metodo listarUsuarios
	public void listarUsuarios() {

		System.out.println("Lista de usuarios:");
		for (Asesoria usuario : usuarios) {
			usuario.analizarUsuario();
			System.out.println(usuario.toString());
			System.out.println("--------------------------");
		}
	}
	//se crea el metodo listarUsuariosPorTipo
	public void listarUsuariosPorTipo(String tipoUsuario) {
		for (Asesoria asesoria : usuarios) {

			if (asesoria instanceof Usuario) {
				Usuario usuario = (Usuario) asesoria;
				if (usuario.getClass().getSimpleName().equals(tipoUsuario)) {
					System.out.println(usuario);
					System.out.println("-----------------------");
				}
			}
		}
	}
	//se crea el metodo listarCapacitaciones
	public void listarCapacitaciones() {

		for (Capacitacion capacitacion : capacitaciones) {
			System.out.println(capacitacion);
			System.out.println("-----------------------");
		}
		// System.out.println(capacitaciones.size());
	}
}
