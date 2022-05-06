package pickyeater.UI.RegisterPage;

import pickyeater.basics.user.WeightGoal;
import pickyeater.executors.RegisterExecutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class Register3 extends JFrame {
    private JPanel panel1;
    private JButton btLoseWeight;
    private JButton btGainWeight;
    private JButton btMaintainWeight;
    private JPanel mainPanel;
    private JButton btBack;
    private JPanel buttonPanel;

    WeightGoal weightGoal;

    public Register3(RegisterExecutor registerExecutor) {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btLoseWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btLoseWeight.setBackground(Color.green);
                btGainWeight.setBackground(Color.white);
                btMaintainWeight.setBackground(Color.white);
                weightGoal = WeightGoal.LOSE_WEIGHT;

                Continue(registerExecutor);
            }
        });
        btGainWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btLoseWeight.setBackground(Color.white);
                btGainWeight.setBackground(Color.green);
                btMaintainWeight.setBackground(Color.white);
                weightGoal = WeightGoal.INCREASE_WEIGHT;

                Continue(registerExecutor);
            }
        });
        btMaintainWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btLoseWeight.setBackground(Color.white);
                btGainWeight.setBackground(Color.white);
                btMaintainWeight.setBackground(Color.green);
                weightGoal = WeightGoal.MANTAIN_WEIGHT;

                Continue(registerExecutor);
            }
        });

    btBack.addComponentListener(new ComponentAdapter() { } );
        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                new Register2(registerExecutor);
            }
        });
    }
    private void Continue(RegisterExecutor registerExecutor){
        if (weightGoal != null){
            JOptionPane.showMessageDialog(buttonPanel, "Goal: " + weightGoal);

            setVisible(false);

            new Register4(registerExecutor);
        }
    }
}
