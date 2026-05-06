package ui;

import service.CRMService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CRMGUI {

    public CRMGUI() {

        CRMService service = new CRMService();

        JFrame frame = new JFrame("Customers");
        frame.setSize(600, 400);

        frame.setLayout(new BorderLayout());

        JTable table = new JTable(service.getCustomersTable());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JTextField id = new JTextField(5);
        JTextField name = new JTextField(10);
        JTextField email = new JTextField(10);

        JButton add = new JButton("Add");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");

        panel.add(id);
        panel.add(name);
        panel.add(email);
        panel.add(add);
        panel.add(update);
        panel.add(delete);

        frame.add(panel, BorderLayout.SOUTH);

        add.addActionListener(e -> {
            service.addCustomer(Integer.parseInt(id.getText()), name.getText(), email.getText());
            table.setModel(service.getCustomersTable());
        });

        update.addActionListener(e -> {
            service.updateCustomer(Integer.parseInt(id.getText()), name.getText(), email.getText());
            table.setModel(service.getCustomersTable());
        });

        delete.addActionListener(e -> {
            service.deleteCustomer(Integer.parseInt(id.getText()));
            table.setModel(service.getCustomersTable());
        });

        frame.setVisible(true);
    }
}
