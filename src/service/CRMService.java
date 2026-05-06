package service;

import db.DBConnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CRMService {

    public void addCustomer(int id, String name, String email) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO customers VALUES (?, ?, ?)"
            );
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, String name, String email) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE customers SET name=?, email=? WHERE id=?"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM customers WHERE id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel getCustomersTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");

        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customers");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public void addDeal(int id, int customerId, String status) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO deals VALUES (?, ?, ?)"
            );
            ps.setInt(1, id);
            ps.setInt(2, customerId);
            ps.setString(3, status);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCustomerCount() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM customers");
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
