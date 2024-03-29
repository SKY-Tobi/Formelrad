package application;

/**
 * Berechnet das Formelrad
 * 
 * @author Eric Gahlinger, Tobias Heierli
 * @version 15.11.2019
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

	public void calculate() throws IllegalArgumentException {
		int notNullCounter = 0;
		if (leistung != 0.0) {
			notNullCounter++;
		}
		if (spannung != 0.0) {
			notNullCounter++;
		}
		if (strom != 0.0) {
			notNullCounter++;
		}
		if (widerstand != 0.0) {
			notNullCounter++;
		}
		if (notNullCounter > 2) {
			System.err.println("Warnung: Es wurden mehr als 2 Parameter eingegeben!");
			throw new IllegalArgumentException("Es wurden mehr als 2 Parameter eingegeben!");
		} else if (notNullCounter < 2) {
			System.err.println("Achtung: Es wurden weniger als 2 Parameter angegeben!");
			throw new IllegalArgumentException("Es wurden wenger als 2 Parameter eingegeben!");
		}
		
		if (widerstand != 0.0 && leistung != 0.0) {
			spannung = uAusPundR(leistung, widerstand);
			strom = iAusPundR(leistung, widerstand);
		} else if (widerstand != 0.0 && spannung != 0.0) {
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusUundR(spannung, widerstand);
		} else if (widerstand != 0.0 && strom != 0.0) {
			spannung = uAusRundI(widerstand, strom);
			leistung = pAusRundI(widerstand, strom);
		} else if (leistung != 0.0 && spannung != 0.0) {
			widerstand = rAusUundP(spannung, leistung);
			strom = iAusPundU(leistung, spannung);
		} else if (leistung != 0.0 && strom != 0.0) {
			widerstand = rAusPundI(leistung, strom);
			spannung = uAusPundI(leistung, strom);
		} else if (spannung != 0.0 && strom != 0.0) {
			widerstand = rAusUundI(spannung, strom);
			leistung = pAusUundI(spannung, strom);
		}
	}

	private double pAusUundI(double u, double i) {
		System.out.println("Berechne Leistung aus Spannung und Strom");
		return u * i;
	}

	private double pAusUundR(double u, double r) {
		System.out.println("Berechne Leistung aus Spannung und Widerstand");
		return (u * u) / r;
	}

	private double pAusRundI(double r, double i) {
		System.out.println("Berechne Leistung aus Widerstand und Strom");
		return r * i * i;
	}

	private double uAusRundI(double r, double i) {
		System.out.println("Berechne Spannung aus Widerstand und Strom");
		return r * i;
	}

	private double uAusPundI(double p, double i) {
		System.out.println("Berechne Spannung aus Leistung und Strom");
		return p / i;
	}

	private double uAusPundR(double p, double r) {
		System.out.println("Berechne Spannung aus leistung und Widerstand");
		return Math.sqrt(p * r);
	}

	private double iAusUundR(double u, double r) {
		System.out.println("Berechne Strom aus Spannung und Widerstand");
		return u / r;
	}

	private double iAusPundU(double p, double u) {
		System.out.println("Berechne Strom aus Leistung und Spannung");
		return p / u;
	}

	private double iAusPundR(double p, double r) {
		System.out.println("Berechne Strom aus Leistung und Widerstand");
		return Math.sqrt(p / r);
	}

	private double rAusUundI(double u, double i) {
		System.out.println("Berechne Widerstand aus Spannung und Strom");
		return u / i;
	}

	private double rAusPundI(double p, double i) {
		System.out.println("Berechne Widerstand aus Leistung und Strom");
		return p / (i * i);
	}

	private double rAusUundP(double u, double p) {
		System.out.println("Berechne Widerstand aus Spannung und Leistung");
		return (u * u) / p;
	}

}
