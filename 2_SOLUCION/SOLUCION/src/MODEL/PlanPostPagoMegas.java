package MODEL;

public class PlanPostPagoMegas extends Plan {
    public int minutos;
    public double costoMinutos;
    public double megasEnGigas;
    public double costoGigas;
    public double porcentajeDescuento;


    public PlanPostPagoMegas(String cedula, int minutos, double costoMinutos, double megasEnGigas, double costoGigas, double porcentajeDescuento) {
        super(cedula);
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.megasEnGigas = megasEnGigas;
        this.costoGigas = costoGigas;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double calcularTotal() {
        double t = (minutos * costoMinutos) + (megasEnGigas * costoGigas) -
                (((minutos * costoMinutos) + (megasEnGigas * costoGigas)) * (porcentajeDescuento / 100));
        return t;
    }

    public String toString() {
        return String.format("%s%nMinutos: %d%nCosto Minutos: %.2f%nMegas en Gigas: %.2f%nCosto Gigas:%.2f%nPorcentaje Descuento: %.2f%nTotal: %.2f%n",
                super.toString(), minutos, costoMinutos, megasEnGigas, costoGigas, porcentajeDescuento, calcularTotal());
    }
}
