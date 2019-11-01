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
		if(widerstand != 0.0 && leistung != 0.0 && spannung == 0.0 && strom == 0.0) {
			spannung = uAusPundR(leistung, widerstand);
			strom = iAusPundR(leistung, widerstand);
		} else if (widerstand != 0.0 && leistung == 0.0 && spannung != 0.0 && strom == 0.0) {
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusUundR(spannung, widerstand);
		} else if (widerstand != 0.0 && leistung == 0.0 && spannung == 0.0 && strom != 0.0) {
			spannung = uAusRundI(widerstand, strom);
			leistung = pAusRundI(widerstand, strom);
		} else if (widerstand == 0.0 && leistung != 0.0 && spannung != 0.0 && strom == 0.0) {
			widerstand = rAusUundP(spannung, leistung);
			strom = iAusPundU(leistung, spannung);
		} else if (widerstand == 0.0 && leistung != 0.0 && spannung == 0.0 && strom != 0.0) {
			widerstand = rAusPundI(leistung, strom);
			spannung = uAusPundI(leistung, strom);
		} else if (widerstand == 0.0 && leistung == 0.0 && spannung != 0.0 && strom != 0.0) {
			widerstand = rAusUundI(spannung, strom);
			leistung = pAusUundI(spannung, strom);
		}
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

	private double uAusRundI(double r, double i) {
		return r * i;
	}

	private double uAusPundI(double p, double i) {
		return p / i;
	}

	private double uAusPundR(double p, double r) {
		return Math.sqrt(p * r);
	}

	private double iAusUundR(double u, double r) {
		return u / r;
	}

	private double iAusPundU(double p, double u) {
		return p / u;
	}

	private double iAusPundR(double p, double r) {
		return Math.sqrt(p / r);
	}
	
	private double rAusUundI(double u, double i) {
        return u / i;
    }

    private double rAusPundI(double p, double i) {
        return p / (i * i);
    }

    private double rAusUundP(double u, double p) {
        return (u * u) / p;
    }
}
