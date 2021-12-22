package ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import business_logic.Arithmetic;

import java.awt.event.*;

public class TestArithmetic extends JFrame implements ActionListener {

    // Components
    JLabel lblFirst, lblSecond;
    JTextField txtFirst, txtSecond;
    JRadioButton rdoAdd, rdoSub, rdoMul, rdoDiv;
    JButton btnCalc, btnClose;
    Arithmetic arithmetic;
    ButtonGroup bg;

    // Constructor
    public TestArithmetic() {

        setTitle("Arithmetic");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblFirst = new JLabel("Enter first no : ");
        lblFirst.setBounds(10, 10, 150, 25);

        txtFirst = new JTextField();
        txtFirst.setBounds(120, 10, 150, 25);

        lblSecond = new JLabel("Enter second no : ");
        lblSecond.setBounds(10, 40, 150, 25);

        txtSecond = new JTextField();
        txtSecond.setBounds(120, 40, 150, 25);

        rdoAdd = new JRadioButton("Add");
        rdoAdd.setBounds(10, 70, 80, 25);

        rdoSub = new JRadioButton("Sub");
        rdoSub.setBounds(100, 70, 80, 25);

        rdoMul = new JRadioButton("Mul");
        rdoMul.setBounds(10, 100, 80, 25);

        rdoDiv = new JRadioButton("Div");
        rdoDiv.setBounds(100, 100, 80, 25);

        btnCalc = new JButton("Calculate");
        btnCalc.setBounds(10, 130, 100, 25);

        btnClose = new JButton("Close");
        btnClose.setBounds(130, 130, 100, 25);

        bg = new ButtonGroup();
        bg.add(rdoAdd);
        bg.add(rdoSub);
        bg.add(rdoMul);
        bg.add(rdoDiv);

        add(lblFirst);
        add(txtFirst);
        add(lblSecond);
        add(txtSecond);
        add(rdoAdd);
        add(rdoSub);
        add(rdoMul);
        add(rdoDiv);
        add(btnCalc);
        add(btnClose);

        btnCalc.addActionListener(this);
        btnClose.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestArithmetic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCalc) {

            if (txtFirst.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter first no");
                txtFirst.requestFocus();
                return;
            } else if (txtSecond.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter second no");
                txtSecond.requestFocus();
                return;
            } else if (!rdoAdd.isSelected() && !rdoSub.isSelected() &&
                    !rdoMul.isSelected() && !rdoDiv.isSelected()) {

                JOptionPane.showMessageDialog(null, "Please select an option");
                return;
            } 
            else {
                int first = Integer.parseInt(txtFirst.getText());
                int second = Integer.parseInt(txtSecond.getText());
                arithmetic = new Arithmetic(first, second);
                if (rdoAdd.isSelected()) {
                    JOptionPane.showMessageDialog(null, arithmetic.add());
                } else if (rdoSub.isSelected()) {
                    JOptionPane.showMessageDialog(null, arithmetic.sub());
                } else if (rdoMul.isSelected()) {
                    JOptionPane.showMessageDialog(null, arithmetic.mul());
                } else if (rdoDiv.isSelected()) {
                    JOptionPane.showMessageDialog(null, arithmetic.div());
                }
            }
        } else if (e.getSource() == btnClose) {

            dispose();
        }
    }

}
