package application;

/**
 * Berechnet das Formelrad
 * 
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;

	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}

	public double getLeistung() {
		return leistung;
	}

	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
				+ widerstand + "]";
	}

	public void calculate() {
		/*
		 * Hier auf Grund der vorhanden Werte entscheiden welche Methode unten
		 * aufgerufen werden muss.
		 */
	}

	private double pAusUundI(double u, double i) {
		return u * i;
	}

	private double pAusUundR(double u, double r) {
		return (u * u) / r;
	}

	private double pAusRundI(double r, double i) {
		return r * i * i;
	}

	private double UausRundI(double r, double i) {
		return r * i;
	}

	private double UausPundI(double p, double i) {
		return p / i;
	}

	private double UausPundR(double p, double r) {
		return Math.sqrt(p * r);
	}

	private double IausUundR(double u, double r) {
		return u / r;
	}

	private double IausPundU(double p, double u) {
		return p / u;
	}

	private double IausPundR(double p, double r) {
		return Math.sqrt(p / r);
	}
}
