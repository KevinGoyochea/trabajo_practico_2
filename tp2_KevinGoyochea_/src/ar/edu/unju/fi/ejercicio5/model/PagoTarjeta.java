package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta ;
	private LocalDate fechaPago;
	private double montoPagado;

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public double realizarPago(double monto) {
		montoPagado=(monto*1.15);	
		return montoPagado;
	}

	@Override
	public void imprimirRecibo() {
		DecimalFormat df = new DecimalFormat("#.##");
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 System.out.println("--------------------------------"+"\n"+
				 			"Numero de tarjeta: "+ getNumeroTarjeta()+"\n"+
				 			"Fecha de pago: "+getFechaPago().format(formatoFecha)+"\n"+
				 			"Monto pagado: $" +  df.format(realizarPago(montoPagado)) +"\n"+
				 			"--------------------------------");
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
}
