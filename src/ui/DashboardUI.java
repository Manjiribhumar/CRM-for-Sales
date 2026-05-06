package ui;

import service.CRMService;
import javax.swing.*;

public class DashboardUI {

    public DashboardUI() {
        CRMService service = new CRMService();

        JFrame frame = new JFrame("Dashboard");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JButton custBtn = new JButton("Customers");
        custBtn.setBounds(100, 50, 200, 30);

        JButton dealBtn = new JButton("Deals");
        dealBtn.setBounds(100, 100, 200, 30);

        JLabel count = new JLabel("Total Customers: " + service.getCustomerCount());
        count.setBounds(100, 150, 200, 30);

        frame.add(custBtn);
        frame.add(dealBtn);
        frame.add(count);

        custBtn.addActionListener(e -> new CRMGUI());
        dealBtn.addActionListener(e -> new DealUI());

        frame.setVisible(true);
    }
}
