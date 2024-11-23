package calculator;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {
    TextField tf1, tf2, tfResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClear;

    public SimpleCalculator() {
        // Frame settings
        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(null); // Using no layout manager

        // Input fields
        tf1 = new TextField();
        tf2 = new TextField();
        tfResult = new TextField();
        tfResult.setEditable(false);

        // Set bounds for input fields and labels
        Label lbl1 = new Label("First Number:");
        lbl1.setBounds(30, 50, 100, 20);
        tf1.setBounds(150, 50, 200, 20);

        Label lbl2 = new Label("Second Number:");
        lbl2.setBounds(30, 90, 100, 20);
        tf2.setBounds(150, 90, 200, 20);

        Label lblResult = new Label("Result:");
        lblResult.setBounds(30, 130, 100, 20);
        tfResult.setBounds(150, 130, 200, 20);

        // Buttons
        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMul = new Button("*");
        btnDiv = new Button("/");
        btnClear = new Button("Clear");

        // Set bounds for buttons
        btnAdd.setBounds(50, 180, 50, 30);
        btnSub.setBounds(110, 180, 50, 30);
        btnMul.setBounds(170, 180, 50, 30);
        btnDiv.setBounds(230, 180, 50, 30);
        btnClear.setBounds(290, 180, 60, 30);

        // Add components to frame
        add(lbl1);
        add(tf1);
        add(lbl2);
        add(tf2);
        add(lblResult);
        add(tfResult);
        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);
        add(btnClear);

        // Add action listeners
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        btnClear.addActionListener(this);

        // Close the frame on clicking the close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(tf1.getText());
            double num2 = Double.parseDouble(tf2.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = num1 + num2;
            } else if (e.getSource() == btnSub) {
                result = num1 - num2;
            } else if (e.getSource() == btnMul) {
                result = num1 * num2;
            } else if (e.getSource() == btnDiv) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    tfResult.setText("Error: Divide by 0");
                    return;
                }
            } else if (e.getSource() == btnClear) {
                tf1.setText("");
                tf2.setText("");
                tfResult.setText("");
                return;
            }

            tfResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            tfResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
