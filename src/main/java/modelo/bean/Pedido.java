package modelo.bean;

public class Pedido {
	
	Material material;
	Proveedor proveedor;
	
	public Pedido() {
		super();
	}

	public Pedido(Material material, Proveedor proveedor) {
		super();
		this.material = material;
		this.proveedor = proveedor;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Pedido [material=" + material + ", proveedor=" + proveedor + "]";
	}

	
	

}
