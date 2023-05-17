package modelo.bean;

public class Asignacion {
	
	Actividad actividad;
	Material material;
	
	public Asignacion() {
		super();
	}
	
	public Asignacion(Actividad actividad, Material material) {
		super();
		this.actividad = actividad;
		this.material = material;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Asignacion [actividad=" + actividad + ", material=" + material + "]";
	}
	
	
	
	
	
	

}
