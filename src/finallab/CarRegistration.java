package finallab;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CarRegistration extends JFrame implements ActionListener {

    private JTextField carNumberField;
    private JTextField modelField;
    private JTextField nameField;
    private JRadioButton yes;
    private JRadioButton no;
    private JButton findCar;
    private JComboBox<String> yearOptions;
    private JCheckBox registred;
    private JButton addCar;
    private JButton updateCar;
    private JButton removeCar;
    private JButton clear;

    private String driver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost/carregistration";

    private String idValue;
    private String modelValue;
    private String nameValue;
    private int newCarValue;
    private String registeredValue;
    private String yearValue;

    CarRegistration() {

        new JFrame();

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        setLayout(layout);

        JLabel carNumber = new JLabel("Car Registration: ");
        JLabel model = new JLabel("Model: ");
        JLabel name = new JLabel("Name: ");
        JLabel newCar = new JLabel("New Car: ");
        JLabel year = new JLabel("Year: ");
        carNumberField = new JTextField(15);
        modelField = new JTextField(15);
        nameField = new JTextField(15);
        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        registred = new JCheckBox("Registered");
        findCar = new JButton("Find Car");
        addCar = new JButton("Add Car");
        updateCar = new JButton("Update Car");
        removeCar = new JButton("Remove Car");
        clear = new JButton("Clear");
        String[] options = {"2010", "2011", "2012", "2013"};
        yearOptions = new JComboBox<>(options);

        addCar.addActionListener(this);
        updateCar.addActionListener(this);
        removeCar.addActionListener(this);
        clear.addActionListener(this);
        findCar.addActionListener(this);

        ButtonGroup grp = new ButtonGroup();
        grp.add(yes);
        grp.add(no);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(carNumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(carNumberField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(findCar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(model, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(modelField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(year, gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(yearOptions, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(newCar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(yes, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        this.add(no, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        this.add(registred, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(addCar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(updateCar, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        this.add(removeCar, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        this.add(clear, gbc);

        setSize(1000, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CarRegistration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        idValue = carNumberField.getText();
        modelValue = modelField.getText();
        nameValue = nameField.getText();
        yearValue = (String) yearOptions.getSelectedItem();
        registeredValue = registred.isSelected() ? "Y" : "N";
        newCarValue = yes.isSelected() ? 1 : 0;

        if (e.getSource().equals(addCar)) {
            try {
                Class.forName(driver);
                Connection connect = DriverManager.getConnection(dbUrl, "root", "");
                Statement s = connect.createStatement();

                int sql = s.executeUpdate("INSERT INTO cars(id,name,year,model,registered,newCar) VALUES('"
                        + idValue + "' , '" + nameValue + "' ,  '" + yearValue + "' , '" + modelValue + "' , '"
                        + registeredValue + "' , " + newCarValue + " )");

                if (sql < 1) {
                    System.out.println("insert failed");
                } else {
                    System.out.println("insert success");
                }

                s.close();
                connect.close();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else if (e.getSource().equals(updateCar)) {
            
            try {
                Class.forName(driver);
                Connection connect = DriverManager.getConnection(dbUrl, "root", "");
                Statement s = connect.createStatement();

                int sql = s.executeUpdate("UPDATE cars SET name = '"+nameValue+"', year = '"+yearValue+"', model = '"+modelValue+"', registered = '"+registeredValue+"', newCar = "+newCarValue+" WHERE id = '"+idValue+"' ");

                if (sql < 1) {
                    System.out.println("Update failed");
                } else {
                    System.out.println("Update success");
                }

                s.close();
                connect.close();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } else if (e.getSource().equals(removeCar)) {
            
            try {
                Class.forName(driver);
                Connection connect = DriverManager.getConnection(dbUrl, "root", "");
                Statement s = connect.createStatement();

                int sql = s.executeUpdate("DELETE  FROM cars WHERE id = '"+idValue+"' ");

                if (sql < 1) {
                    System.out.println("Delete failed");
                } else {
                    System.out.println("Delete success");
                }

                s.close();
                connect.close();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else if (e.getSource().equals(findCar)) {
            
            try {
                Class.forName(driver);
                Connection connect = DriverManager.getConnection(dbUrl, "root", "");
                Statement s = connect.createStatement();

                String sql = "SELECT model,registered  FROM cars WHERE id = '"+idValue+"' ";

                ResultSet rs = s.executeQuery(sql);
                
                if(rs.next()){
                  modelValue = rs.getString("model");
                  registeredValue = rs.getString("registered");
                  
                  modelField.setText(modelValue);
                  registred.setSelected("Y".equals(registeredValue));
                }else {
                    System.out.println("No car found with the given ID.");
                }

                rs.close();
                s.close();
                connect.close();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } else if (e.getSource().equals(clear)){
            System.exit(0);
        }
    }
}
