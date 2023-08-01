package MODEL;

public abstract class Plan {
    public String cedula;

    public Plan(String cedula) {
        this.cedula = cedula;
    }

    public abstract double calcularTotal();

    public String toString() {
        return String.format("Cedula: %s", cedula);
    }
}
