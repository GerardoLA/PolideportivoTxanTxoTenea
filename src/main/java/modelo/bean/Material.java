package modelo.bean;

public class Material {
	
	private String id_material;
	private String nombreMaterial;
	private int stock;
	Proveedor provedor;
	private int preciounidad;
	
	public Material() {
		super();
	}

	public Material(String id_material, String nombreMaterial, int stock, Proveedor provedor, int preciounidad) {
		super();
		this.id_material = id_material;
		this.nombreMaterial = nombreMaterial;
		this.stock = stock;
		this.provedor = provedor;
		this.preciounidad = preciounidad;
	}

	public String getId_material() {
		return id_material;
	}

	public void setId_material(String id_material) {
		this.id_material = id_material;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Proveedor getProvedor() {
		return provedor;
	}

	public void setProvedor(Proveedor provedor) {
		this.provedor = provedor;
	}

	public int getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(int preciounidad) {
		this.preciounidad = preciounidad;
	}

	@Override
	public String toString() {
		return "Material [id_material=" + id_material + ", nombreMaterial=" + nombreMaterial + ", stock=" + stock
				+ ", provedor=" + provedor + ", preciounidad=" + preciounidad + "]";
	}
	
	
	

}
