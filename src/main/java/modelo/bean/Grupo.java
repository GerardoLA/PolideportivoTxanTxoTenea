package modelo.bean;

public class Grupo {
	
	private String id_grupo;
	private String dias;
	private String horarios; 
	private int maxPartic;
	private int numPartic;
	
	
	public Grupo(String id_grupo, String dias, String horarios, int maxPartic, int numPartic) {
		this.id_grupo = id_grupo;
		this.dias = dias;
		this.horarios = horarios;
		this.maxPartic = maxPartic;
		this.numPartic = numPartic;
	}
	
	public Grupo() {
	}
	
	public String getId_grupo() {
		return id_grupo;
	}
	
	public void setId_grupo(String id_grupo) {
		this.id_grupo = id_grupo;
	}
	
	public String getDias() {
		return dias;
	}
	
	public void setDias(String dias) {
		this.dias = dias;
	}
	
	public String getHorarios() {
		return horarios;
	}
	
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	
	public int getMaxPartic() {
		return maxPartic;
	}
	
	public void setMaxPartic(int maxPartic) {
		this.maxPartic = maxPartic;
	}
	
	public int getNumPartic() {
		return numPartic;
	}
	
	public void setNumPartic(int numPartic) {
		this.numPartic = numPartic;
	}
	
	public boolean comprobarId(String id_actividad) {
		boolean correcto = false;
		
		if(this.id_grupo.contains(id_actividad) && this.id_grupo.length()>id_actividad.length()) {
			correcto = true;
		}
		
		
		return correcto;
	}
	
	@Override
	public String toString() {
		return "Grupo [id_grupo=" + id_grupo + ", dias=" + dias + ", horarios=" + horarios + ", maxPartic=" + maxPartic
				+ ", numPartic=" + numPartic + "]";
	}
	
	

}
