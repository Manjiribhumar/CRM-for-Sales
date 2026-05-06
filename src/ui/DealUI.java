package ui;

import service.CRMService;
import javax.swing.*;

public class DealUI {

    public DealUI() {
        CRMService service = new CRMService();

        JFrame frame = new JFrame("Deals");
        frame.setSize(300, 250);
        frame.setLayout(null);

        JTextField id = new JTextField();
        id.setBounds(100, 20, 150, 25);

        JTextField cust = new JTextField();
        cust.setBounds(100, 60, 150, 25);

        JTextField status = new JTextField();
        status.setBounds(100, 100, 150, 25);

        JButton add = new JButton("Add Deal");
        add.setBounds(100, 140, 120, 30);

        frame.add(id);
        frame.add(cust);
        frame.add(status);
        frame.add(add);

        add.addActionListener(e -> {
            service.addDeal(
                Integer.parseInt(id.getText()),
                Integer.parseInt(cust.getText()),
                status.getText()
            );
            JOptionPane.showMessageDialog(frame, "Deal Added");
        });

        frame.setVisible(true);
    }
}
