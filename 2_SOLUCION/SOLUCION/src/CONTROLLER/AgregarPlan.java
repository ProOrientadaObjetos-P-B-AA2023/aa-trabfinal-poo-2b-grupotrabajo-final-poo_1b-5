package CONTROLLER;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPlan {
    private JPanel panelPrincipal;
    private JButton planPostPagoMegasButton;
    private JButton planPostPagoMinutosButton;
    private JButton planPostPagoMinutosMegasButton;
    private JButton planPostPagoMinutosMegasEconomicoButton;
    private JButton btn_cerrar;
    private JFrame jFrame;

    public AgregarPlan() {
        planPostPagoMegasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarPlan1().inciarAgregarPanel();
                jFrame.dispose();
            }
        });
        btn_cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        planPostPagoMinutosMegasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarPlan3().inciarAgregarPanel();
                jFrame.dispose();
            }
        });
        planPostPagoMinutosMegasEconomicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarPlan4().inciarAgregarPanel();
                jFrame.dispose();
            }
        });
        planPostPagoMinutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarPlan2().inciarAgregarPanel();
                jFrame.dispose();
            }
        });
    }

    public void inciarAgregarPanel() {
        jFrame = new JFrame("Agregar Plan1");
        jFrame.setContentPane(panelPrincipal);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
