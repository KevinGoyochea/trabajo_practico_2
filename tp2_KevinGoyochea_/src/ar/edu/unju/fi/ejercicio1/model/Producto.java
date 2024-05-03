package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private short codigo;
	private String descripcion;
	private double precioUnitario;
	private Origenes origenFabricacion;
	private Categorias categoria;

	public Producto(short codigo, String descripcion, double precioUnitario, Origenes origenFabricacion,
			Categorias categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	public enum Origenes {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	public enum Categorias{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}
	
	@Override
	public String toString() {
		return	"Codigo: "+codigo+"\n"+
				"Descripcion: "+descripcion+"\n"+
				"Precio por unidad: "+precioUnitario+"\n"+
				"Origen de fabricacion: "+getOrigenFabricacion()+"\n"+
				"Categoria: "+getCategoria()+"\n";
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Origenes getOrigenFabricacion() {
		return origenFabricacion;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setOrigenFabricacion(Origenes origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}		
}