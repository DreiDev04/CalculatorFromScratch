
package gui_calc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI_Calc extends JFrame implements ActionListener{
    
    
    private JTextField textField;
    private JTextField operatorField;
    private JButton[] numButtons = new JButton[10];
    private JButton[] funcButtons = new JButton[12];
    private Font myFont = new Font("Comic Sans", Font.PLAIN, 32);
    
    private JButton addButton,subButton, mulButton, divButton;
    private JButton equButton, sqrtButton, modButton, negButton, clrButton, remButton, decButton, zeroButton;
    private JPanel panel;
    
    private Double num1, num2;
    private double result;
    private char operator;

    
    public GUI_Calc(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(420, 500));
        frame.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(40, 25, 340, 60);
        textField.setHorizontalAlignment(JTextField.TRAILING);
        textField.setMargin(new Insets(10, 10, 10, 10));
	textField.setFont(myFont);
        textField.setEditable(false);
        
        operatorField = new JTextField();
        operatorField.setBounds(40, 50, 35, 35);
        operatorField.setHorizontalAlignment(JTextField.CENTER);
	operatorField.setFont(new Font("Comic Sans", Font.PLAIN, 32));
        operatorField.setEditable(false);
        operatorField.setBorder(BorderFactory.createEmptyBorder());
        
        equButton = new JButton("=");
        sqrtButton = new JButton("√");
        modButton = new JButton("%");
        negButton = new JButton("+/-");
        clrButton = new JButton("Clear");
        remButton = new JButton("Remove");
        decButton = new JButton(".");
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        zeroButton = new JButton("00");
        
        funcButtons[0] = negButton;
        funcButtons[1] = modButton;
        funcButtons[2] = sqrtButton;
        funcButtons[3] = divButton;
        funcButtons[4] = mulButton;
        funcButtons[5] = subButton;
        funcButtons[6] = addButton;
        funcButtons[7] = equButton;
        funcButtons[8] = decButton; 
        funcButtons[9] = zeroButton;
        
        clrButton.setBounds(40, 410, 150, 50);
        clrButton.setFocusPainted(false);
        clrButton.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        clrButton.setForeground(Color.WHITE);
        clrButton.setBackground(new Color(0x000000));
        clrButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        clrButton.addActionListener(this);
        
        remButton.setBounds(230, 410, 150, 50);
        remButton.setFocusPainted(false);
        remButton.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        remButton.setForeground(Color.WHITE);
        remButton.setBackground(new Color(0x000000));
        remButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        remButton.addActionListener(this);
        
        for (int i = 0; i <= 9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont); 
            funcButtons[i].setFocusPainted(false);
            funcButtons[i].setForeground(Color.WHITE);
            funcButtons[i].setBackground(new Color(0x000000));
            funcButtons[i].setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }
        
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusPainted(false);
            numButtons[i].setFont(myFont);
            numButtons[i].setForeground(Color.WHITE);
            numButtons[i].setBackground(new Color(0x000000));
            numButtons[i].setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }
        
        
        
        panel = new JPanel();
        panel.setBounds(40, 100, 340, 300);
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.setBackground(new Color(0x3E432E));
        
        panel.add(negButton);
        panel.add(modButton);
        panel.add(sqrtButton);
        panel.add(divButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[0]);
        panel.add(zeroButton);
        panel.add(decButton);
        panel.add(equButton);
        
        
        frame.getContentPane().setBackground(new Color(0x3E432E));
        frame.add(panel);
        frame.add(clrButton);
        frame.add(remButton);
        
        frame.add(textField);
        frame.add(operatorField);
        frame.setTitle("GUI Calculator");
        frame.setVisible(true);
        frame.setResizable(false);
        
    }
    public static void main(String[] args) {
        new GUI_Calc();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            for (int i = 0; i < 10; i++) {
                if (ae.getSource() == numButtons[i] ) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if (ae.getSource() == addButton) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '+';
                operatorField.setText("+");
            }
            if (ae.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '-';
                operatorField.setText("-");
            }
            if (ae.getSource() == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '*';
                operatorField.setText("*");
            }
            if (ae.getSource() == divButton) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '/';
                operatorField.setText("÷");
            }
            if (ae.getSource() == modButton) {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '%';    
                operatorField.setText("%");
            }

            if (ae.getSource() == zeroButton) {
                textField.setText(textField.getText().concat("00"));
            }

            if (ae.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));

            }
            if (ae.getSource() == equButton) {
                num2 = Double.parseDouble(textField.getText());
                switch(operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '%':
                        result = num1 % num2;
                        break;
                }
                num1 = result;
                textField.setText(String.valueOf(result));
            }
            if (ae.getSource() == negButton) {
                textField.setText(String.valueOf("-").concat(textField.getText()));
            }
            if (ae.getSource() == clrButton) {
                textField.setText(null);
                num1 = 0.0;
                num2 = 0.0;
                result = 0;
                operator = ' ';
                operatorField.setText(" ");
            }
            if (ae.getSource() == remButton) {
                textField.setText(textField.getText().substring(0, textField.getText().length()-1));
            }
            if (ae.getSource() == sqrtButton) {
                result = Math.sqrt(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }
            
        } catch (Exception e) {
            textField.setText("Error: " + e.getMessage().toLowerCase());
        } 
        
        
    }
    
}
