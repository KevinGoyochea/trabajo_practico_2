package ar.edu.unju.fi.ejercicio5.model;

public class Producto {

		private short codigo;
		private String descripcion;
		private double precioUnitario;
		private Origenes origenFabricacion;
		private Categorias categoria;
		private boolean estado;

		
		public Producto(short codigo, String descripcion, double precioUnitario, Origenes origenFabricacion,
				Categorias categoria, boolean estado) {
			super();
			this.codigo = codigo;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
			this.origenFabricacion = origenFabricacion;
			this.categoria = categoria;
			this.estado = estado;
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

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}		
	}