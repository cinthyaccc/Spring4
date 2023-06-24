package grupo5;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisitaEnTerreno {
	//se crean los atributos de la clase VisitaEnTerreno
	private int idVisita;
	private int rutCliente;
	private String díaVisita;
	private String horaVisita;
	private String lugarVisita;
	private String comentarios;
	
	 //se crea el constructor con todos los atributos de la clase
	public VisitaEnTerreno() {
		
	}
	
	
	public VisitaEnTerreno(int idVisita, int rutCliente, String díaVisita, String horaVisita, String lugarVisita,
			String comentarios) {
		super();
		this.idVisita = idVisita;
		this.rutCliente = rutCliente;
		this.díaVisita = díaVisita;
		this.horaVisita = horaVisita;
		this.lugarVisita = lugarVisita;
		this.comentarios = comentarios;
	}

	//se crean los metodos de acceso y modificadores de yodos los atributos
	public int getIdVisita() {
		return idVisita;
	}


	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}


	public int getRutCliente() {
		return rutCliente;
	}


	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}


	public String getDíaVisita() {
		return díaVisita;
	}


	public void setDíaVisita(String díaVisita) {
		this.díaVisita = díaVisita;
	}


	public String getHoraVisita() {
		return horaVisita;
	}


	public void setHoraVisita(String horaVisita) {
		this.horaVisita = horaVisita;
	}


	public String getLugarVisita() {
		return lugarVisita;
	}


	public void setLugarVisita(String lugarVisita) {
		this.lugarVisita = lugarVisita;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	//se crea metodo toString

	
	public String toString() {
		return "VisitaEnTerreno [idVisita=" + idVisita + ", rutCliente=" + rutCliente + ", díaVisita=" + díaVisita
				+ ", horaVisita=" + horaVisita + ", lugarVisita=" + lugarVisita + ", comentarios=" + comentarios + "]";
	}
	
	
	
	
}
