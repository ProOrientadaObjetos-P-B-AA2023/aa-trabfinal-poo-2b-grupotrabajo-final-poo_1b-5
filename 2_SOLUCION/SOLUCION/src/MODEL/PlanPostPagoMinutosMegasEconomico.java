package MODEL;

public class PlanPostPagoMinutosMegasEconomico extends Plan {
    public int minutos;
    public double costoMinutos;
    public int megasExpresadosGigas;
    public double costoPorCadaGiga;

    public PlanPostPagoMinutosMegasEconomico(String cedula, int minutos, double costoMinutos, int megasExpresadosGigas, double costoPorCadaGiga) {
        super(cedula);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoPorCadaGiga = costoPorCadaGiga;
    }

    public double calcularTotal() {
        double t = (minutos * costoMinutos) + ((megasExpresadosGigas) * costoPorCadaGiga);
        return t;
    }

    public String toString() {
        return String.format("%s%nMinutos: %d%nCosto Minutos: %.2f%nGigas: %d%nCosto Por Giga: %.2f%nTotal: %.2f%n",
                super.toString(), minutos, costoMinutos, megasExpresadosGigas, costoPorCadaGiga, calcularTotal());
    }
}
