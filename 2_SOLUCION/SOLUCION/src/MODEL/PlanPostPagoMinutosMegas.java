package MODEL;

public class PlanPostPagoMinutosMegas extends Plan {
    public int megasExpresadosGigas;
    public double costoGiga;
    public double tarifaBase;

    public PlanPostPagoMinutosMegas(String cedula, int megasExpresadosGigas, double costoGiga, double tarifaBase) {
        super(cedula);
        this.megasExpresadosGigas = megasExpresadosGigas;
        this.costoGiga = costoGiga;
        this.tarifaBase = tarifaBase;
    }

    public double calcularTotal() {
        double t = ((megasExpresadosGigas) * costoGiga) + tarifaBase;
        System.out.println(t);
        return t;
    }

    public String toString() {
        return String.format("%s%nGigas: %d%nCosto Giga: %.2f%nTarifa Base: %.2f%nTotal: %.2f%n",
                super.toString(), megasExpresadosGigas, costoGiga, tarifaBase, calcularTotal());
    }
}
