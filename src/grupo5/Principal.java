package grupo5;

//Integrantes: Cinthya Caldera, Claudio Azocar
//@Versión Final
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Contenedor contenedor = new Contenedor();

		// Menú principal
		// se crea variable opcion para utilizar en switch del menu principal
		int opcion;
		do {
			System.out.println("\u001B[34m=== MENÚ PRINCIPAL ===\u001B[34m");
			System.out.println("\u001B[30m1. Agregar Cliente\u001B[30m");
			System.out.println("2. Agregar Profesional");
			System.out.println("3. Agregar Administrativo");
			System.out.println("4. Agregar Capacitación");
			System.out.println("5. Eliminar Usuario");
			System.out.println("6. Mostrar Todos los Usuarios");
			System.out.println("7. Mostrar Usuarios por tipo");
			System.out.println("8. Mostrar Capacitaciones");
			System.out.println("9. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea
			// segun la opcion selecciona se entra al case que se solicite
			switch (opcion) {
			case 1:
				// Agregar Cliente
				System.out.println("=== AGREGAR CLIENTE ===");
				crearClienteDesdeConsola(contenedor);
				System.out.println("Cliente agregado exitosamente.");
				break;

			case 2:
				// Agregar Profesional
				System.out.println("=== AGREGAR PROFESIONAL ===");
				crearProfesionalDesdeConsola(contenedor);
				System.out.println("Profesional agregado exitosamente.");
				break;
			case 3:
				// Agregar Administrativo
				System.out.println("=== AGREGAR ADMINISTRATIVO ===");
				crearAdministrativoDesdeConsola(contenedor);

				System.out.println("Administrativo agregado exitosamente.");
				break;
			case 4:
				// Agregar Capacitación
				System.out.println("=== AGREGAR CAPACITACIÓN ===");
				crearCapacitacionDesdeConsola(contenedor);
				System.out.println("Capacitación agregada exitosamente.");
				break;
			case 5:
				// Eliminar Usuario
				System.out.println("Ingrese RUN del Usuario que desea Eliminar");
				/*
				 * Se crea variable rutCompara en donde almacena el rut que se quiere eliminar
				 */
				int rutCompara = scanner.nextInt();
				/*
				 * Se llama al metodo eliminarUsuario y se la pasa la variable rutCompara como
				 * parametro
				 */
				contenedor.eliminarUsuario(rutCompara);
				break;
			case 6:
				// Mostrar lista de todos los Usuarios Registrados
				System.out.println("Usuarios Registrados: ");
				// Se llama al metodo listar Usuarios de la clase contenedor
				contenedor.listarUsuarios();
				break;
			case 7:
				// Mostrar Lista de Usuario por Tipo
				System.out.println(
						"Ingrese el tipo de Usuario que desea visualizar: Cliente, Adiministrativo o Profesional");
				String tipoUsuario = scanner.nextLine();
				/*
				 * se llama al metodo listarUsuarioPorTipo y se le pasa la variable tipoUsuario
				 * como parametro
				 */
				contenedor.listarUsuariosPorTipo(tipoUsuario);
				break;
			case 8:
				// Mostrar Capacitaciones
				System.out.println("Capacitaciones Registradas:");
				// se llama al metodo listarCapacitacione
				contenedor.listarCapacitaciones();
				break;
			case 9:
				// Salir del programa
				System.out.println("***Fin del Pograma***");
				break;
			default:
				/*
				 * se muestra el mensaje opcion invalida si se introduce un opcion difente a las
				 * disponible en el menu
				 */
				System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
				break;
			}

			System.out.println(); // Línea en blanco para separar el menú de la próxima iteración
		} while (opcion != 9);

		scanner.close();
	}

	// Método para agregar un tipo de usuario cliente desde la consola
	private static Cliente crearClienteDesdeConsola(Contenedor contenedor) {
		Scanner scanner = new Scanner(System.in);
		// se crea el objeto de la clase cliente
		Cliente cliente = new Cliente();
		// guardando nombre y aplicando la validacion requerida
		do {
			System.out.println("Ingrese el nombre de usuario (**entre 10 y 50 caracteres**)");
			String nombreUsuario = scanner.nextLine();
			if (nombreUsuario.length() > 11 && nombreUsuario.length() < 51) {
				cliente.setNombre(nombreUsuario);
				break; // Salir del ciclo
			} else {
				System.out.println("El nombre de usuario no cumple con la longitud requerida.");
			}
		} while (true);

		// Introduciendo los datos de Usuario
		// guardando RUN
		int runUsuario;
		do {
			System.out.print("Ingrese el RUN del Usuario: (**corresponde a un número menor a 99.999.999**)");
			runUsuario = scanner.nextInt();

			if (runUsuario > 100000000) {
				System.out.println("Error: El RUT debe ser menor a 99.999.999. Vuelva a ingresar.");
			}
		} while (runUsuario > 100000000);
		cliente.setRun(runUsuario);
		scanner.nextLine(); // Consumir el salto de línea

		// guardando fecha de nacimiento
		do {
			System.out.print("Ingrese la fecha de nacimiento (formato: dd/mm/yyyy)");
			String fechaNacimientoStr = scanner.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
				String fecha = sdf.format(fechaNacimiento);
				cliente.setFechaDeNacimiento(fecha);
				break; // El formato de fecha es válido, salir del ciclo
			} catch (ParseException e) {
				System.out.println("Error en formato de la fecha de nacimiento. Vuelva a ingresar.");
			}
		} while (true);
		// Introduciendo los datos de Cliente
		// guardando RUT

		int RUT;
		do {
			System.out.print("Ingrese el RUT del Cliente: (**corresponde a un número menor a 99.999.999**)");
			RUT = scanner.nextInt();

			if (RUT >= 100000000) {
				System.out.println("Error: El RUT debe ser menor a 99.999.999. Vuelva a ingresar.");
			}
		} while (RUT >= 100000000);
		cliente.setRut(RUT);
		scanner.nextLine(); // Consumir el salto de línea

		// guardando nombres
		do {
			System.out.println("Ingrese el nombres del cliente (entre 5 y 30 caracteres):");
			String nombres = scanner.nextLine();
			if (nombres.length() > 4 && nombres.length() < 31) {
				cliente.setNombres(nombres);
				break; // salir del ciclo
			} else {
				System.out.println("Nombres del CLiente no cumple con la longitud requerida.");
			}
		} while (true);

		// guardando apellidos
		do {
			System.out.println("Ingrese el Apellidos del cliente (entre 5 y 30 caracteres):");
			String apellidos = scanner.nextLine();
			if (apellidos.length() > 4 && apellidos.length() < 31) {
				cliente.setApellidos(apellidos);
				break; // salir del ciclo
			} else {
				System.out.println("Apellidos del CLiente no cumple con la longitud requerida.");
			}
		} while (true);

		// guardando número de telefono

		String telefono;
		do {
			System.out.println("Ingrese Fono:");
			telefono = scanner.nextLine();
			if (telefono.length() > 0) {
				int numeroTelefono = Integer.parseInt(telefono);
				cliente.setTelefono(numeroTelefono);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir numero de telefono (**campo obligatorio**)");
			}
		} while (true);
		// guardando AFP
		do {
			System.out.println("Ingrese AFP (entre 4 y 30 caracteres):");
			String afp = scanner.nextLine();
			if (afp.length() > 3 && afp.length() < 31) {
				cliente.setAfp(afp);
				break; // Salir del ciclo
			} else {
				System.out.println("AFP no cumple con la longitud requerida.");
			}
		} while (true);
		// guardando sistema de salud

		do {
			System.out.print(
					"Ingrese el sistema de salud (1: Fonasa, 2: Isapre)**debe ser solo una de las dos opciones**");
			String sistemaDeSalud = scanner.nextLine();
			if (sistemaDeSalud.equals("1") || sistemaDeSalud.equals("2")) {
				// Se llama al método obtenerSistemaDeSalud
				String resultado = cliente.obtenerSistemaSalud(sistemaDeSalud);
				// Se guarda el resultado
				cliente.setSistemaDeSalud(resultado);
				break; // Salir del ciclo
			} else {
				System.out.println("Debe introducir un sistema de salud válido (1: Fonasa, 2: Isapre):");
			}
		} while (true);

		// guardando la dirección
		do {
			System.out.print("Ingrese la dirección:(**menor de 70 caracteres**)");
			String direccion = scanner.nextLine();
			if (direccion.length() < 71) {
				cliente.setDireccion(direccion);
				break; // salir del ciclo
			} else {
				System.out.println("Direccion debe ser menor de 70 caracteres");
			}
		} while (true);

		// guardando la comuna

		do {
			System.out.print("Ingrese la comuna: (**maximo 50 caracteres**)");
			String comuna = scanner.nextLine();
			if (comuna.length() < 51) {
				cliente.setComuna(comuna);
				break; // salir del ciclo
			} else {
				System.out.println("comuna debe ser menor de 50 caracteres");
			}
		} while (true);

		// guardando la edad

		String edad;
		do {
			System.out.println("Ingrese Edad: (** campo obligatorio, número mayor o igual a cero, y menor a 150**) ");
			edad = scanner.nextLine();
			if (edad.length() > 0) {
				int validarEdad = Integer.parseInt(edad);
				if (validarEdad > 0 && validarEdad < 150) {
					cliente.setEdad(validarEdad);
					break; // salir del ciclo
				} else {
					System.out.println("Debe introducir Edad Correcta");
				}
			}
		} while (true);

		// llamando al metodo agregarCliente
		contenedor.agregarCliente(cliente);
		return cliente;

	}

	// Método para introducir datos del usuario tipo profesional desde la consola
	private static Profesional crearProfesionalDesdeConsola(Contenedor contenedor) {
		Scanner scanner = new Scanner(System.in);
		Profesional profesional = new Profesional();
		// creando datos del Usuario
		do {
			System.out.println("Ingrese el nombre de usuario (**entre 10 y 50 caracteres**)");
			String nombreUsuario = scanner.nextLine();
			if (nombreUsuario.length() >= 10 && nombreUsuario.length() <= 50) {
				profesional.setNombre(nombreUsuario);
				break; // Salir del ciclo
			} else {
				System.out.println("El nombre de usuario no cumple con la longitud requerida.");
			}
		} while (true);

		int runUsuario;
		do {
			System.out.print("Ingrese el RUN del Usuario:(**corresponde a un número menor a 99.999.999**)");
			runUsuario = scanner.nextInt();

			if (runUsuario >= 100000000) {
				System.out.println("Error: El RUT debe ser menor a 99.999.999. Vuelva a ingresar.");
			}
		} while (runUsuario >= 100000000);
		profesional.setRun(runUsuario);
		scanner.nextLine(); // Consumir el salto de línea

		// guardando fecha de nacimiento
		do {
			System.out.print("Ingrese la fecha de nacimiento (formato: dd/mm/yyyy)");
			String fechaNacimientoStr = scanner.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
				String fecha = sdf.format(fechaNacimiento);
				profesional.setFechaDeNacimiento(fecha);
				break; // El formato de fecha es válido, salir del ciclo
			} catch (ParseException e) {
				System.out.println("Error en formato de la fecha de nacimiento. Vuelva a ingresar.");
			}
		} while (true);
		// creando datos del profesional

		do {
			System.out.println("Ingrese Título del Profesional (**entre 10 y 50 caracteres**)");
			String titulo = scanner.nextLine();
			if (titulo.length() >= 10 && titulo.length() <= 50) {
				profesional.setTitulo(titulo);
				break; // Salir del ciclo
			} else {
				System.out.println("El Titulo del Profesional no cumple con la longitud requerida.");
			}
		} while (true);

		// guardando fecha de ingreso

		do {
			System.out.print("Ingrese la Fecha de Ingreso del Profesional (formato: dd/mm/yyyy)");
			String fechaNacimientoStr = scanner.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
				String fecha = sdf.format(fechaNacimiento);
				profesional.setFechaDeIngreso(fecha);
				break; // El formato de fecha es válido, salir del ciclo
			} catch (ParseException e) {
				System.out.println("Error en formato de la Fecha de Ingreso. Vuelva a ingresar.");
			}
		} while (true);
		// llamando al metodo agregar Proseional de la clase contenedor
		contenedor.agregarProfesional(profesional);
		return profesional;
	}

	// Método para crear un objeto Administrativo desde la consola
	private static Adiministrativo crearAdministrativoDesdeConsola(Contenedor contenedor) {
		Scanner scanner = new Scanner(System.in);
		Adiministrativo administrativo = new Adiministrativo();

		// creando datos del Usuario

		do {
			System.out.println("Ingrese el nombre de usuario (**entre 10 y 50 caracteres**)");
			String nombreUsuario = scanner.nextLine();
			if (nombreUsuario.length() > 9 && nombreUsuario.length() < 51) {
				administrativo.setNombre(nombreUsuario);
				break; // Salir del ciclo
			} else {
				System.out.println("El nombre de usuario no cumple con la longitud requerida.");
			}
		} while (true);

		int runUsuario;
		do {
			System.out.print("Ingrese el RUN del Usuario (**corresponde a un número menor a 99.999.999**)");
			runUsuario = scanner.nextInt();

			if (runUsuario >= 100000000) {
				System.out.println("Error: El RUT debe ser menor a 99.999.999. Vuelva a ingresar.");
			}
		} while (runUsuario >= 100000000);
		administrativo.setRun(runUsuario);
		scanner.nextLine(); // Consumir el salto de línea

		// guardando fecha de nacimiento

		do {
			System.out.print("Ingrese la fecha de nacimiento (formato: dd/mm/yyyy)");
			String fechaNacimientoStr = scanner.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
				String fecha = sdf.format(fechaNacimiento);
				administrativo.setFechaDeNacimiento(fecha);
				break; // El formato de fecha es válido, salir del ciclo
			} catch (ParseException e) {
				System.out.println("Error en formato de la fecha de nacimiento. Vuelva a ingresar.");
			}
		} while (true);

		// ingresando datos del Usuario Administrativo

		// ingresando Area
		do {
			System.out.print("Ingrese el área: (**entre 5 y 20 caracteres**)");
			String area = scanner.nextLine();
			if (area.length() > 4 && area.length() < 21) {
				administrativo.setArea(area);
				break; // Salir del ciclo
			} else {
				System.out.println("El area del usuario administrativo no cumple con la longitud requerida.");
			}
		} while (true);

		// ingresando experiencia previa
		do {
			System.out.print("Ingrese Experiencia: (**menor a 100 caracteres**)");
			String experienciaPrevia = scanner.nextLine();
			if (experienciaPrevia.length() < 100) {
				administrativo.setExperienciaPrevia(experienciaPrevia);
				break; // Salir del ciclo
			} else {
				System.out.println(
						"La experiencia ingresada del usuario administrativo no cumple con la longitud requerida.");
			}
		} while (true);

		// Creando objeto de la clase Contenedor y llamando al metodo agregarProseional

		contenedor.agregarAdministrativo(administrativo);

		return administrativo;
	}

	// Método para crear un objeto Capacitacion desde la consola
	private static Capacitacion crearCapacitacionDesdeConsola(Contenedor contenedor) {
		Scanner scanner = new Scanner(System.in);
		Capacitacion capacitacion = new Capacitacion();

		String identificador;
		do {
			System.out.println("Ingrese Número de identificador: (**campo obligatorio**)");
			identificador = scanner.nextLine();
			if (identificador.length() > 0) {
				int id = Integer.parseInt(identificador);
				capacitacion.setIdentificador(id);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir nro. de Identificador");
			}
		} while (true);

		// Guardando RUT del Cliente

		String rut;
		do {
			System.out.println(
					"Ingrese RUT del Cliente: (**Campo Obligatorio, corresponde a un número menor a 99.999.999**) ");
			rut = scanner.nextLine();
			if (rut.length() > 0) {
				int id = Integer.parseInt(rut);
				capacitacion.setRutCliente(id);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir RUT del cliente");
			}
		} while (true);

		// Guardando Día de la capacitación

		String dia;
		do {
			System.out.println("Ingrese el Día de la capacitacion: (**En formato: lunes - domingo**) ");
			dia = scanner.nextLine();
			if (dia.equals("lunes") || dia.equals("martes") || dia.equals("miercoles") || dia.equals("jueves")
					|| dia.equals("viernes") || dia.equals("sabado") || dia.equals("domingo")) {

				capacitacion.setDia(dia);
				break; // salir del ciclo
			} else {
				System.out.println("Formato de Día incorrecto");
			}
		} while (true);

		// Guardando Hora de la Capacitación

		String hora;

		do {
			System.out.print("Ingrese la hora: (**En formato HH:MM** 24H)  ");
			hora = scanner.nextLine();

			if (hora.length() == 5) {
				String dosPrimerosCaracteres = hora.charAt(0) + "" + hora.charAt(1);
				String tercerCaracter = Character.toString(hora.charAt(2));
				String ultimosCaracteres = hora.charAt(3) + "" + hora.charAt(4);

				// comparo
				int numero = Integer.parseInt(dosPrimerosCaracteres);
				int numero2 = Integer.parseInt(ultimosCaracteres);

				if (numero < 24 && tercerCaracter.equals(":") && numero2 < 60) {
					capacitacion.setHora(hora);
					break; // Salir del ciclo
				}

			} else {
				System.out.println("Hora en formato no valido");
			}
		} while (true);

		// Almacenando Lugar de la Capacitación

		do {
			System.out.print("Ingrese el lugar: (**campo obligario, min 10 cacteres max 50**) ");
			String lugar = scanner.nextLine();
			if (lugar.length() > 9 && lugar.length() < 51) {
				capacitacion.setLugar(lugar);
				break; // Salir del ciclo
			} else {
				System.out.println("El Lugar de la capacitación no cumple con la longitud requerida.");
			}
		} while (true);

		// Almacenando la duración de la Capacitación
		do {
			System.out.print("Ingrese la duración: (**campo obligario, min 10 cacteres max 50**) ");
			String duracion = scanner.nextLine();
			if (duracion.length() < 71) {
				capacitacion.setDuracion(duracion);
				break; // Salir del ciclo
			} else {
				System.out.println("La duración de la capacitación no cumple con la longitud requerida.");
			}
		} while (true);

		// Almacenando la cantidad de asistentes a la capacitación
		String cant;
		do {
			System.out.print("Ingrese la cantidad de asistentes: (**campo obligario, número entero < 1000**)");

			cant = scanner.nextLine();
			if (cant.length() > 0) {
				int cantidad = Integer.parseInt(cant);
				if (cantidad < 1000) {
					capacitacion.setCantidadAsistentes(cantidad);
					break; // salir del ciclo
				}
			} else {
				System.out.println("Debe introducir cantidad de asistente valida");
			}
		} while (true);
		// Agregando todos los datos a la lista capacitación
		contenedor.agregarCapacitacion(capacitacion);

		return capacitacion;
	}

	private static void crearAccidente() {
		// se crea funcion para almacenar datos en la clase accidente
		Scanner scanner = new Scanner(System.in);
		Accidente accidente = new Accidente();
		String identificador;
		do {
			System.out.println("Ingrese Número de identificador: (**campo obligatorio");
			identificador = scanner.nextLine();
			if (identificador.length() > 0) {
				int id = Integer.parseInt(identificador);
				accidente.setIdAccidente(id);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir nro. de Identificador");
			}
		} while (true);

		String rut;
		do {
			System.out.println("Ingrese RUT: (**campo obligatorio, corresponde a un número menor a 99.999.999");
			rut = scanner.nextLine();
			if (rut.length() > 0) {
				int rutC = Integer.parseInt(identificador);
				accidente.setRutCliente(rutC);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir RUT");
			}
		} while (true);

		do {
			System.out.print("Ingrese Día (formato: dd/mm/yyyy)");
			String fechaNacimientoStr = scanner.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
				String fecha = sdf.format(fechaNacimiento);
				accidente.setDiaAccidente(fecha);
				break; // El formato de fecha es válido, salir del ciclo
			} catch (ParseException e) {
				System.out.println("Error en formato del día. Vuelva a ingresar.");
			}
		} while (true);

		String hora;
		do {
			System.out.print("Ingrese la hora: (**En formato HH:MM** 24H)");
			hora = scanner.nextLine();

			if (hora.length() == 5) {
				String dosPrimerosCaracteres = hora.charAt(0) + "" + hora.charAt(1);
				String tercerCaracter = Character.toString(hora.charAt(2));
				String ultimosCaracteres = hora.charAt(3) + "" + hora.charAt(4);

				// comparo
				int numero = Integer.parseInt(dosPrimerosCaracteres);
				int numero2 = Integer.parseInt(ultimosCaracteres);

				if (numero < 24 && tercerCaracter.equals(":") && numero2 < 60) {
					accidente.setHoraAccidente(hora);
					break; // Salir del ciclo
				}

			} else {
				System.out.println("Hora en formato no valido");
			}
		} while (true);

		do {
			System.out.print("Ingrese el lugar: (**campo obligario, min 10 cacteres max 50**) ");
			String lugar = scanner.nextLine();
			if (lugar.length() > 9 && lugar.length() < 51) {
				accidente.setLugarAccidente(lugar);
				break; // Salir del ciclo
			} else {
				System.out.println("El Lugar de la capacitación no cumple con la longitud requerida.");
			}
		} while (true);

		do {
			System.out.print("Ingrese Origen Accidente: (**campo obligario, cacteres max 100**) ");
			String consecuencia = scanner.nextLine();
			if (consecuencia.length() < 101) {
				accidente.setOrigenAccidente(consecuencia);
				break; // Salir del ciclo
			} else {
				System.out.println("texto no cumple con la longitud requerida.");
			}
		} while (true);

		do {
			System.out.print("Ingrese Consecuencia: (**campo obligario, cacteres max 100**) ");
			String comentarios = scanner.nextLine();
			if (comentarios.length() < 101) {
				accidente.setConsecuencias(comentarios);
				break; // Salir del ciclo
			} else {
				System.out.println("texto no cumple con la longitud requerida.");
			}
		} while (true);

	}

	// se crea funcion para almacenar datos en la clase visita
	private static void crearDatosVisita() {
		VisitaEnTerreno visita = new VisitaEnTerreno();
		Scanner scanner = new Scanner(System.in);
		String identificador;
		do {
			System.out.println("Ingrese Número de identificador: (**campo obligatorio");
			identificador = scanner.nextLine();
			if (identificador.length() > 0) {
				int id = Integer.parseInt(identificador);
				visita.setIdVisita(id);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir nro. de Identificador");
			}
		} while (true);

		String rut;
		do {
			System.out.println("Ingrese RUT: (**campo obligatorio, corresponde a un número menor a 99.999.999**)");
			rut = scanner.nextLine();
			if (rut.length() > 0) {
				int rutC = Integer.parseInt(identificador);
				visita.setRutCliente(rutC);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir RUT");
			}
		} while (true);

		do {
			System.out.print("Ingrese Día (formato: dd/mm/yyyy)");
			String fechaNacimientoStr = scanner.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
				String fecha = sdf.format(fechaNacimiento);
				visita.setDíaVisita(fecha);
				break; // El formato de fecha es válido, salir del ciclo
			} catch (ParseException e) {
				System.out.println("Error en formato del día. Vuelva a ingresar.");
			}
		} while (true);

		String hora;
		do {
			System.out.print("Ingrese la hora: (**En formato HH:MM** 24H)");
			hora = scanner.nextLine();

			if (hora.length() == 5) {
				String dosPrimerosCaracteres = hora.charAt(0) + "" + hora.charAt(1);
				String tercerCaracter = Character.toString(hora.charAt(2));
				String ultimosCaracteres = hora.charAt(3) + "" + hora.charAt(4);

				// comparo
				int numero = Integer.parseInt(dosPrimerosCaracteres);
				int numero2 = Integer.parseInt(ultimosCaracteres);

				if (numero < 24 && tercerCaracter.equals(":") && numero2 < 60) {
					visita.setHoraVisita(hora);
					break; // Salir del ciclo
				}

			} else {
				System.out.println("Hora en formato no valido");
			}
		} while (true);

		do {
			System.out.print("Ingrese el lugar: (**campo obligario, min 10 cacteres max 50**) ");
			String lugar = scanner.nextLine();
			if (lugar.length() > 9 && lugar.length() < 51) {
				visita.setLugarVisita(lugar);
				break; // Salir del ciclo
			} else {
				System.out.println("El Lugar de la capacitación no cumple con la longitud requerida.");
			}
		} while (true);

		do {
			System.out.print("Ingrese compatrios: (**campo obligario, cacteres max 100**) ");
			String comentarios = scanner.nextLine();
			if (comentarios.length() < 101) {
				visita.setComentarios(comentarios);
				break; // Salir del ciclo
			} else {
				System.out.println("Los comentarios no cumple con la longitud requerida.");
			}
		} while (true);

	}

	// se crea funcion para almacenar datos en la clase revisión
	private static void crearDatosRevision() {
		Revision revision = new Revision();
		Scanner scanner = new Scanner(System.in);

		String identificador;
		do {
			System.out.println("Ingrese Número de identificador de la Revision: (**campo obligatorio");
			identificador = scanner.nextLine();
			if (identificador.length() > 0) {
				int id = Integer.parseInt(identificador);
				revision.setIdRevision(id);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir nro. de Identificador");
			}
		} while (true);

		do {
			System.out.print("Ingrese nombre de la Revisión: (**campo obligario, cacteres max 100**) ");
			String nombre = scanner.nextLine();
			if (nombre.length() > 19 && nombre.length() < 51) {
				revision.setNombreRevision(nombre);
				break; // Salir del ciclo
			} else {
				System.out.println("El nombre no cumple con la longitud requerida.");
			}
		} while (true);

		String identificador2;
		do {
			System.out.println("Ingrese Número de identificador de la Visita en Terreno: (**campo obligatorio");
			identificador2 = scanner.nextLine();
			if (identificador2.length() > 0) {
				int id = Integer.parseInt(identificador2);
				revision.setIdVisitaEnTerreno(id);
				break; // salir del ciclo
			} else {
				System.out.println("Debe introducir nro. de Identificador");
			}
		} while (true);

		do {
			System.out.print("Ingrese Detalle de la Revisión: (**campo obligario, cacteres max 100**) ");
			String detalle = scanner.nextLine();
			if (detalle.length() < 101) {
				revision.setNombreRevision(detalle);
				break; // Salir del ciclo
			} else {
				System.out.println("El Detalle no cumple con la longitud requerida.");
			}
		} while (true);

		do {
			System.out.println("Indique el estado de la Revisión: (**campo obligatorio");
			String estado = scanner.nextLine();
			if (estado.length() > 0) {
				if (estado.equals("1") || estado.equals("2") || estado.equals("3")) {
					int id = Integer.parseInt(estado);
					revision.setEstado(id);
					break; // salir del ciclo
				}
			} else {
				System.out.println("Debe introducir Estado");
			}
		} while (true);

		while (true)
			;

	}
}