package app;

import database.CollegeDAO;
import database.CollegePredictorDAO;
import model.Student;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class Prac9 implements ActionListener {
    JFrame frame;
    JLabel label, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
    Container c;
    JTextField field, field1, field2, field3;
    Font font, font2, font3;
    JRadioButton radio, radio2, radio3, radio4, radio5;
    JButton x, b1;
    ButtonGroup exam, category;
    JComboBox cb, bc, ac;
    String[] allFields;
    Student student;

    CollegePredictorDAO collegePredictorDAO;
    CollegeDAO collegeDAO;

    public Prac9(CollegePredictorDAO collegePredictorDAO, CollegeDAO collegeDAO) {
        this.collegePredictorDAO = collegePredictorDAO;
        this.collegeDAO = collegeDAO;
    }

    public void nextPage() {

        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(0, 1000);
        frame.setTitle("College Predictor");
        c = frame.getContentPane();
        c.setLayout(null);

        label = new JLabel("NAME : ");
        label.setBounds(100, 50, 200, 30);
        field = new JTextField();
        field.setBounds(300, 50, 200, 30);
        field.setFont(new Font("Arial", Font.PLAIN, 20));
        font = new Font("Arial", Font.BOLD, 30);
        font2 = new Font("Arial", Font.PLAIN, 20);
        label.setFont(font);
        c.add(label);
        c.add(field);

        label1 = new JLabel("EMAIL : ");
        label1.setBounds(100, 100, 200, 30);
        field1 = new JTextField();
        field1.setBounds(300, 100, 300, 30);
        field1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setFont(font);
        c.add(label1);
        c.add(field1);
        // public void actionPerformed(ActionEvent event)
        label2 = new JLabel("MOBILE NO.: ");
        label2.setBounds(100, 150, 300, 30);
        field2 = new JTextField();
        field2.setBounds(300, 150, 200, 30);
        field2.setFont(new Font("Arial", Font.PLAIN, 20));
        label2.setFont(font);
        c.add(label2);
        c.add(field2);

        label3 = new JLabel("EXAM NAME: ");
        label3.setBounds(100, 200, 300, 30);
        label3.setFont(font);
        c.add(label3);

        radio = new JRadioButton("JEE MAINS");
        radio.setBounds(100, 250, 300, 30);
        radio.setFont(font2);

        radio2 = new JRadioButton("JEE ADVANCE");
        radio2.setBounds(100, 300, 400, 30);
        radio2.setFont(font2);
        exam = new ButtonGroup();
        exam.add(radio);
        exam.add(radio2);
        c.add(radio);
        c.add(radio2);

        label4 = new JLabel("CATEGORY: ");
        label4.setBounds(100, 350, 300, 30);
        label4.setFont(font);
        c.add(label4);

        radio3 = new JRadioButton("GENERAL");
        radio3.setBounds(100, 400, 300, 30);
        radio3.setFont(font2);

        radio4 = new JRadioButton("OBC");
        radio4.setBounds(100, 450, 300, 30);
        radio4.setFont(font2);

        radio5 = new JRadioButton("SC/ST");
        radio5.setBounds(100, 500, 300, 30);
        radio5.setFont(font2);

        category = new ButtonGroup();
        category.add(radio3);
        category.add(radio4);
        category.add(radio5);
        c.add(radio3);
        c.add(radio4);
        c.add(radio5);

        label5 = new JLabel("EXAM RANK: ");
        label5.setBounds(100, 550, 300, 30);
        field3 = new JTextField();
        field3.setBounds(300, 550, 200, 30);
        field3.setFont(font2);
        label5.setFont(font);
        c.add(label5);
        c.add(field3);

        label6 = new JLabel("CHOOSE FIELD: ");
        label6.setBounds(900, 350, 300, 30);
        //java.util.List<String> fields = collegeDAO.getFields();
       // String a[] = fields.toArray(new String[fields.size()]);
        String a[] = {"Chemical Engineering","Civil Engineering","Computer Science and Engineering","Electrical Engineering","Electronics and Communication Engineering","Mechanical Engineering","Bio Technology","Artificial intelligence","Biotechnology and Biochemical Engineering","Electrical and Electronics Engineering","Mining Engineering","Aerospace Engineering"};
        allFields = a;
        cb = new JComboBox(a);
        cb.setBounds(900, 400, 300, 30);
        label6.setFont(font);
        c.add(label6);
        c.add(cb);
        c.revalidate();

        b1 = new JButton("PREDICT COLLEGE-->");
        b1.setBounds(800, 700, 300, 30);
        b1.setFont(font2);
        c.add(b1);
        b1.addActionListener(this);

        x = new JButton("<--PREVIOUS");
        x.setBounds(300, 700, 300, 30);
        x.setFont(font2);
        c.add(x);
        x.addActionListener(this);

        label7 = new JLabel("");
        label7.setBounds(100, 700, 800, 100);
        label7.setFont(new Font("Arial", Font.BOLD, 25));
        label7.setForeground(Color.RED);
        c.add(label7);

        label8 = new JLabel("SELECT STATE:");
        label8.setBounds(900, 150, 400, 30);
        label8.setFont(font);
        c.add(label8);
        java.util.List<String> states = collegeDAO.getStates();
        String m[] = states.toArray(new String[states.size()]);
        bc = new JComboBox(m);
        bc.setBounds(900, 200, 300, 30);
        c.add(bc);
        c.revalidate();

        label9 = new JLabel("SELECT RANGE OF FEES:");
        label9.setBounds(900, 250, 400, 30);
        label9.setFont(font);
        c.add(label9);
        String n[] = {"ANY FEES", "upto 5 lacs", "upto 10 lacs"};
        ac = new JComboBox(n);
        ac.setBounds(900, 300, 300, 30);
        c.add(ac);
        c.revalidate();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("PREDICT COLLEGE-->")) {
            boolean check = false;
            boolean pack = false;
            int fieldIndex = cb.getSelectedIndex();
            String stateName = bc.getSelectedItem().toString();
            String[] fees = {"ANY FEES", "500000", "1000000"};
            int fieldName = ac.getSelectedIndex();
            int rank = parseInt(field3.getText());
            String name = field.getText();
            String email = field1.getText();
            String phone = field2.getText();
            // Store in database


            if (radio2.isSelected()) {
                pack = true;
                if (radio3.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, radio2.getText(), radio3.getText());
                } else if (radio4.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, radio2.getText(), radio4.getText());
                } else {
                    check = true;
                    student = new Student(name, phone, email, rank, radio2.getText(), radio5.getText());
                }
            } else if (radio.isSelected()) {
                pack = true;
                if (radio3.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, radio.getText(), radio3.getText());
                } else if (radio4.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, radio.getText(), radio4.getText());
                } else {
                    check = true;
                    student = new Student(name, phone, email, rank, radio.getText(), radio5.getText());
                }
            }
            collegePredictorDAO.create(student);

            collegePredictorDAO.search(name);
            if (new Validator().check(name, email, phone, rank) & check & pack) {
                frame.dispose();
                if (radio2.isSelected()) {
                    if (radio3.isSelected())
                        new Page3(allFields, fieldIndex, stateName, fees[fieldName], rank, "General", this.collegePredictorDAO,this.collegeDAO);
                    else if (radio4.isSelected())
                        new Page3(allFields, fieldIndex, stateName, fees[fieldName], rank, "OBC", this.collegePredictorDAO,this.collegeDAO);
                    else
                        new Page3(allFields, fieldIndex, stateName, fees[fieldName], rank, "SC/ST", this.collegePredictorDAO,this.collegeDAO);
                } else if (radio.isSelected()) {
                    if (radio3.isSelected())
                        new Page3m(allFields, fieldIndex, stateName, fees[fieldName], rank, "General", this.collegePredictorDAO,this.collegeDAO);
                    else if (radio4.isSelected())
                        new Page3m(allFields, fieldIndex, stateName, fees[fieldName], rank, "OBC", this.collegePredictorDAO,this.collegeDAO);
                    else
                        new Page3m(allFields, fieldIndex, stateName, fees[fieldName], rank, "SC/ST", this.collegePredictorDAO,this.collegeDAO);
                }
            } else {
                label7.setText("INCORRECT  EMAIL , NAME , MOBILE NUMBER OR RANK");
            }
        } else if (ae.getActionCommand().equals("<--PREVIOUS")) {
            frame.dispose();
            Page1 page1 = new Page1(this.collegePredictorDAO, this.collegeDAO);
            page1.runApplication();
        }

    }
}