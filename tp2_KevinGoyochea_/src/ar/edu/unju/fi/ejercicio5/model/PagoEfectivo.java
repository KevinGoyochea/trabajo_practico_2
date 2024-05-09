package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private LocalDate fechaPago;
	private double montoPagado;
	
	
	
	public PagoEfectivo() {
	}
	
	

	public PagoEfectivo(LocalDate fechaPago, double montoPagado) {
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}



	@Override
	public double realizarPago(double monto) {
		double descuento = (this.montoPagado*1.10)-this.montoPagado;
		this.montoPagado= monto - descuento;
		return montoPagado;
	}

	@Override
	public void imprimirRecibo() {
		DecimalFormat df = new DecimalFormat("#.##");
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("--------------------------------"+"\n"+
						   "Fecha de pago: "+ getFechaPago().format(formatoFecha)+"\n"+
						   "Monto pagado: $"+df.format((realizarPago(montoPagado)))+"\n"+
						   "--------------------------------");
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	
	
}
