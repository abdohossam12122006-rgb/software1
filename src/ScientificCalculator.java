import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[14];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JButton sinButton, cosButton, tanButton, logButton, sqrtButton, powButton;

    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 18);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public ScientificCalculator() {
        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 25, 340, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        sqrtButton = new JButton("√");
        powButton = new JButton("x^y");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = sinButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = tanButton;
        functionButtons[11] = logButton;
        functionButtons[12] = sqrtButton;
        functionButtons[13] = powButton;

        for (int i = 0; i < 14; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        panel = new JPanel();
        panel.setBounds(20, 100, 340, 380);
        panel.setLayout(new GridLayout(6, 4, 10, 10));
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(addButton);
        frame.add(panel);
        frame.add(textField);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            if(!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat("."));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == powButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        try {
            if (e.getSource() == sqrtButton) {
                double temp = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sqrt(temp)));
            }
            if (e.getSource() == sinButton) {
                double temp = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.sin(Math.toRadians(temp))));
            }
            if (e.getSource() == cosButton) {
                double temp = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.cos(Math.toRadians(temp))));
            }
            if (e.getSource() == tanButton) {
                double temp = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.tan(Math.toRadians(temp))));
            }
            if (e.getSource() == logButton) {
                double temp = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(Math.log10(temp)));
            }
        } catch (NumberFormatException ex) {
            System.out.println("pls enter your input");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if(num2 != 0) result = num1 / num2;
                    else { textField.setText("Error"); return; }
                    break;
                case '^': result = Math.pow(num1, num2); break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}