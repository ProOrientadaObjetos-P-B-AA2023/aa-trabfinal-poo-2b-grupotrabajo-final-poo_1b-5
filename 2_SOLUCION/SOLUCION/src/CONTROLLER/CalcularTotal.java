package CONTROLLER;


import MODEL.Plan;

import java.util.ArrayList;

public class CalcularTotal {
    public CalcularTotal() {
    }

    public double total(ArrayList<Plan> planes) {
        double ac = 0;
        for (Plan p : planes) {
            ac += p.calcularTotal();
        }
        return ac;
    }
}
