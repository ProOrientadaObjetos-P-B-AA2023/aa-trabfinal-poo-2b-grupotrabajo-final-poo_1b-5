package MODEL;

public class PlanPostPagoMinutos extends Plan {
    public int minutosNacionales;
    public double costoMinutosNacional;
    public int minutosInternacionales;
    public double costoMinutoInternacional;

    public PlanPostPagoMinutos(String cedula, int minutosNacionales, double costoMinutosNacional, int minutosInternacionales, double costoMinutoInternacional) {
        super(cedula);
        this.minutosNacionales = minutosNacionales;
        this.costoMinutosNacional = costoMinutosNacional;
        this.minutosInternacionales = minutosInternacionales;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }

    public double calcularTotal() {
        double t = (minutosInternacionales * costoMinutoInternacional) + (minutosNacionales * costoMinutosNacional);
        return t;
    }

    public String toString() {
        return String.format("%s%nMinutos Nacionales: %d%nCosto Minutos Nacional: %.2f%n" +
                        "Minutos Internacionales: %d%nCosto Minuto Internacional: %.2f%nTotal: %.2f%n",
                super.toString(), minutosNacionales, costoMinutosNacional, minutosInternacionales, costoMinutoInternacional, calcularTotal());
    }
}
