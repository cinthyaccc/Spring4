package grupo5;

public class Revision {
	//se crean los atributos de la clase Revision
	private  int idRevision;
	private  int idVisitaEnTerreno;
	private  String nombreRevision;
	private String detalleRevision;
	private  int estado;
	 //se crea el constructor con todos los atributos de la clase
	public Revision() {
		
	}
	
	public Revision(int idRevision, int idVisitaEnTerreno, String nombreRevision, String detalleRevision, int estado) {
		super();
		this.idRevision = idRevision;
		this.idVisitaEnTerreno = idVisitaEnTerreno;
		this.nombreRevision = nombreRevision;
		this.detalleRevision = detalleRevision;
		this.estado = estado;
	}
	//se crean los metodos de acceso y modificadores de yodos los atributos
	public int getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}

	public int getIdVisitaEnTerreno() {
		return idVisitaEnTerreno;
	}

	public void setIdVisitaEnTerreno(int idVisitaEnTerreno) {
		this.idVisitaEnTerreno = idVisitaEnTerreno;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalleRevision() {
		return detalleRevision;
	}

	public void setDetalleRevision(String detalleRevision) {
		this.detalleRevision = detalleRevision;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	//se crea metodo toString

	public String toString() {
		return "Revision [idRevision=" + idRevision + ", idVisitaEnTerreno=" + idVisitaEnTerreno + ", nombreRevision="
				+ nombreRevision + ", detalleRevision=" + detalleRevision + ", estado=" + estado + "]";
	}
	
	
	
	
}
