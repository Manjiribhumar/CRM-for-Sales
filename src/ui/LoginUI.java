package ui;

import service.AuthService;
import javax.swing.*;

public class LoginUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setLayout(null);

        JTextField user = new JTextField();
        user.setBounds(80, 30, 150, 25);
        frame.add(user);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(80, 70, 150, 25);
        frame.add(pass);

        JButton btn = new JButton("Login");
        btn.setBounds(100, 110, 80, 25);
        frame.add(btn);

        AuthService auth = new AuthService();

        btn.addActionListener(e -> {
            if (auth.login(user.getText(), new String(pass.getPassword()))) {
                frame.dispose();
                new DashboardUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Login");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
