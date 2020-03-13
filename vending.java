import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    private JPanel panel1;
    private JButton payButton;
    private JTextField textField1;
    private JButton a050Button;
    private JButton a020Button;
    private JButton a010Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton kawaButton;
    private JButton herbataButton;
    private JButton redbullButton;
    private JButton monsterButton;
    private JButton blackButton;
    private JButton liptonButton;
    private JButton pepsiButton;
    private JButton colaButton;
    private JTextField wmTextField;
    private JTextField textField2;
    private JTextField textFieldDZ;
    private JTextField textFieldBal;
    private JCheckBox duzyCheckBox;
    private JButton resetButton;
    private JButton paykButton;
    private JList list1;
    private JTextField koszykTextField;
    private JTextArea textArea1;
    private double balance;

    {
        balance = 0;
    }

    private double doZaplaty;

    {
        doZaplaty = 0;
    }

    private double reszta;

    {
        reszta = 0;
    }

    private int nrz;

    {
        nrz = 0;
    }

    private String items = "";

    private test() {
        payButton.addActionListener(e -> {

            if (doZaplaty == 0) {
                JOptionPane.showMessageDialog(null, "Pusty koszyk");
            } else if (doZaplaty > balance) {
                JOptionPane.showMessageDialog(null, "Za mało pieniędzy");
            } else {
                reszta = balance - doZaplaty;
                reszta = Math.round(reszta * 100d) / 100d;
                JOptionPane.showMessageDialog(null, "Zapłacono\nReszta: " + reszta);
                nrz++;
                items += "Gotówka: " + doZaplaty + " |" + nrz + "| ";
                balance = 0;
                doZaplaty = 0;
                textField1.setText("0");
                textField2.setText("0");
                duzyCheckBox.setSelected(false);
                textArea1.setText(null);
                try {
                    save();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        paykButton.addActionListener(e -> {
            if (doZaplaty == 0) {
                JOptionPane.showMessageDialog(null, "Pusty koszyk");
            } else {
                int a = JOptionPane.showConfirmDialog(null, "Zbliż kartę", "Message", JOptionPane.OK_CANCEL_OPTION);
                if (a == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null, "Pobrano: " + doZaplaty);
                    nrz++;
                    items += "Karta: " + doZaplaty + " |" + nrz + "| ";
                    balance = 0;
                    doZaplaty = 0;
                    textField1.setText("0");
                    textField2.setText("0");
                    duzyCheckBox.setSelected(false);
                    textArea1.setText(null);
                    try {
                        save();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Anulowano");
                    balance = 0;
                    doZaplaty = 0;
                    textField1.setText("0");
                    textField2.setText("0");
                    duzyCheckBox.setSelected(false);
                    textArea1.setText(null);
                    items += " ANULOWANO ";
                    try {
                        save();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        a5Button.addActionListener(e -> {
            balance += 5;
            balance = Math.round(balance * 100d) / 100d;
            textField1.setText(String.valueOf(balance));
        });
        a2Button.addActionListener(e -> {
            balance += 2;
            balance = Math.round(balance * 100d) / 100d;
            textField1.setText(String.valueOf(balance));
        });
        a1Button.addActionListener(e -> {
            balance += 1;
            balance = Math.round(balance * 100d) / 100d;
            textField1.setText(String.valueOf(balance));
        });
        a050Button.addActionListener(e -> {
            balance += 0.50;
            balance = Math.round(balance * 100d) / 100d;
            textField1.setText(String.valueOf(balance));
        });
        a020Button.addActionListener(e -> {
            balance += 0.20;
            balance = Math.round(balance * 100d) / 100d;
            textField1.setText(String.valueOf(balance));
        });
        a010Button.addActionListener(e -> {
            balance += 0.10;
            balance = Math.round(balance * 100d) / 100d;
            textField1.setText(String.valueOf(balance));
        });

        //PRODUKTY -#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#

        colaButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 2;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "ColaD, ";
                textArea1.append("ColaD\n");
            } else {
                doZaplaty += 2;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Cola, ";
                textArea1.append("Cola\n");
            }
        });
        pepsiButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 2;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "PepsiD, ";
                textArea1.append("PepsiD\n");
            } else {
                doZaplaty += 2;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Pepsi, ";
                textArea1.append("Pepsi\n");
            }
        });
        liptonButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 2.2;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "LiptonD, ";
                textArea1.append("LiptonD\n");
            } else {
                doZaplaty += 2.2;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Lipton, ";
                textArea1.append("Lipton\n");
            }
        });
        blackButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 2.5;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "BlackD, ";
                textArea1.append("BlackD\n");
            } else {
                doZaplaty += 2.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Black, ";
                textArea1.append("Black\n");
            }
        });
        monsterButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 3;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "MonsterD, ";
                textArea1.append("MonsterD\n");
            } else {
                doZaplaty += 3;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Monster, ";
                textArea1.append("Monster\n");
            }
        });
        redbullButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 5;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "RedbullD, ";
                textArea1.append("RedbullD\n");
            } else {
                doZaplaty += 5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Redbull, ";
                textArea1.append("Redbull\n");
            }
        });
        kawaButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 2.2;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "KawaD, ";
                textArea1.append("KawaD\n");
            } else {
                doZaplaty += 2.2;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Kawa, ";
                textArea1.append("Kawa\n");
            }
        });
        herbataButton.addActionListener(e -> {
            boolean isSelected = duzyCheckBox.isSelected();
            if (isSelected) {
                doZaplaty += 1.8;
                doZaplaty += 0.5;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "HerbataD, ";
                textArea1.append("HerbataD\n");
            } else {
                doZaplaty += 1.8;
                doZaplaty = Math.round(doZaplaty * 100d) / 100d;
                textField2.setText(String.valueOf(doZaplaty));
                items += "Herbata, ";
                textArea1.append("Herbata\n");
            }
        });
        resetButton.addActionListener(e -> {
            balance = 0;
            doZaplaty = 0;
            textField1.setText("0");
            textField2.setText("0");
            duzyCheckBox.setSelected(false);
            textArea1.setText(null);
            items += " ANULOWANO ";
            try {
                save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //MOUSE WHEEL -#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#

        a5Button.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                balance += 5;
                balance = Math.round(balance * 100d) / 100d;
                textField1.setText(String.valueOf(balance));
            } else {
                if (balance >= 5) {
                    balance -= 5;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                } else {
                    balance = 0;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                }
            }
        });
        a2Button.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                balance += 2;
                balance = Math.round(balance * 100d) / 100d;
                textField1.setText(String.valueOf(balance));
            } else {
                if (balance >= 2) {
                    balance -= 2;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                } else {
                    balance = 0;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                }
            }
        });
        a1Button.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                balance += 1;
                balance = Math.round(balance * 100d) / 100d;
                textField1.setText(String.valueOf(balance));
            } else {
                if (balance >= 1) {
                    balance -= 1;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                } else {
                    balance = 0;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                }
            }
        });
        a050Button.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                balance += 0.5;
                balance = Math.round(balance * 100d) / 100d;
                textField1.setText(String.valueOf(balance));
            } else {
                if (balance >= 0.5) {
                    balance -= 0.5;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                } else {
                    balance = 0;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                }
            }
        });
        a020Button.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                balance += 0.2;
                balance = Math.round(balance * 100d) / 100d;
                textField1.setText(String.valueOf(balance));
            } else {
                if (balance >= 0.2) {
                    balance -= 0.2;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                } else {
                    balance = 0;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                }
            }
        });
        a010Button.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) {
                balance += 0.1;
                balance = Math.round(balance * 100d) / 100d;
                textField1.setText(String.valueOf(balance));
            } else {
                if (balance >= 0.1) {
                    balance -= 0.1;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                } else {
                    balance = 0;
                    balance = Math.round(balance * 100d) / 100d;
                    textField1.setText(String.valueOf(balance));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new test().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void save()
            throws IOException {
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("test.txt", true));
        writer.write("Kupione:");
        writer.newLine();
        writer.append(items);
        writer.newLine();
        writer.close();
    }
}
