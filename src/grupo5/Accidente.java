package grupo5;

import java.time.LocalDate;
import java.time.LocalTime;

public class Accidente {
	//se crean los atributos de la clase Accidente
	private  int idAccidente;
	private  int rutCliente;
	private  String diaAccidente;
	private  String horaAccidente;
	private  String lugarAccidente;
	private  String origenAccidente;
	private  String Consecuencias;
	 //se crea el constructor con todos los atributos de la clase
	public Accidente() {
		
	}
	public Accidente(int idAccidente, int rutCliente, String diaAccidente, String horaAccidente,
			String lugarAccidente, String origenAccidente, String consecuencias) {
		super();
		this.idAccidente = idAccidente;
		this.rutCliente = rutCliente;
		this.diaAccidente = diaAccidente;
		this.horaAccidente = horaAccidente;
		this.lugarAccidente = lugarAccidente;
		this.origenAccidente = origenAccidente;
		Consecuencias = consecuencias;
	}
	//se crean los metodos de acceso y modificadores de yodos los atributos
	public int getIdAccidente() {
		return idAccidente;
	}
	public void setIdAccidente(int idAccidente) {
		this.idAccidente = idAccidente;
	}
	public int getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getDiaAccidente() {
		return diaAccidente;
	}
	public void setDiaAccidente(String diaAccidente) {
		this.diaAccidente = diaAccidente;
	}
	public String getHoraAccidente() {
		return horaAccidente;
	}
	public void setHoraAccidente(String horaAccidente) {
		this.horaAccidente = horaAccidente;
	}
	public String getLugarAccidente() {
		return lugarAccidente;
	}
	public void setLugarAccidente(String lugarAccidente) {
		this.lugarAccidente = lugarAccidente;
	}
	public String getOrigenAccidente() {
		return origenAccidente;
	}
	public void setOrigenAccidente(String origenAccidente) {
		this.origenAccidente = origenAccidente;
	}
	public String getConsecuencias() {
		return Consecuencias;
	}
	public void setConsecuencias(String consecuencias) {
		Consecuencias = consecuencias;
	}
	//se crea metodo toString

	public String toString() {
		return "Accidente [idAccidente=" + idAccidente + ", rutCliente=" + rutCliente + ", diaAccidente=" + diaAccidente
				+ ", horaAccidente=" + horaAccidente + ", lugarAccidente=" + lugarAccidente + ", origenAccidente="
				+ origenAccidente + ", Consecuencias=" + Consecuencias + "]";
	}
	
	
	
	
	
	
}
