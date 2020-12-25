/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;  
import java.text.NumberFormat;
import javax.swing.*;    
public class BMICalculator extends JFrame { 
    
     private Container c ;
     
    BMICalculator(){
        
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(400, 180, 500, 420);
        this.setResizable(false);
        this.setTitle("BMI Calculator");
    
    initComponent();
    }

   
     public void initComponent(){
     
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
   
    
    //Here is the font
    
    Font font = new Font ("Arial",Font.CENTER_BASELINE,30);
        
       JLabel BodyMassIndex = new JLabel("BODY MASS INDEX");
       BodyMassIndex.setForeground(Color.YELLOW);
       BodyMassIndex.setBackground(Color.GRAY);
       BodyMassIndex.setOpaque(true);
       BodyMassIndex.setBounds(100,15,300,30);
        BodyMassIndex.setFont(font);
        c.add(BodyMassIndex);
    
    
    //user input text field
    JLabel weight = new JLabel("Enter Weight :");
        weight.setBounds(50,70,85,30);
        c.add(weight);
       
    //user input weight
   JTextField txtKg = new JTextField();
       txtKg.setBounds(170,73, 195, 30);
       c.add(txtKg);
    
       JLabel height = new JLabel("Enter Foot & Inch :");
        height.setBounds(50,115,300,30);
        c.add(height);
 
    JButton b=new JButton("Enter");  
    b.setBounds(280,162,70,30);  
   
        String[] feet = {"1", "2", "3", "4", "5", "6", "7","8"};
        String[] inch = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    
        JComboBox cbFt=new JComboBox(feet); 
        cbFt.setBounds(170,118,50, 30);
        c.add(cbFt);
        
        JComboBox cbln=new JComboBox(inch); 
        cbln.setBounds(230,118,50, 30);
        c.add(cbln);
         
        //jlabel for BMI
        JLabel Bmi = new JLabel("BMI :");
        Bmi.setBounds(50,200,300,30);
        c.add(Bmi);
        
        //jlabel for Condition
         JLabel condition = new JLabel("Condition :");
        condition.setBounds(50,250,300,30);
        c.add(condition);
        
        //BMI Text Print
        JTextField bmitext = new JTextField();
       bmitext.setBounds(170,205,195, 30);
       bmitext.setEnabled(false);
       c.add(bmitext);
       
       //Condition Print
        JTextField conditiontext = new JTextField();
       conditiontext.setBounds(170,250,195, 30);
       conditiontext.setEnabled(false);
       c.add(conditiontext);
       
       //Clear button
       JButton clear = new JButton("Clear");
       clear.setBounds(170,293,85,30);
       c.add(clear);
       
        //Clear Button ActionListener

          clear.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent e){

         bmitext.setText("");
         conditiontext.setText(""); 
         
         bmitext.setEnabled(false);
        conditiontext.setEnabled(false);
    }
    });
        
       //Home button
        JButton home = new JButton("Home");
       home.setBounds(280,293,85,30);
       c.add(home);
       
        c.add(b);
        c.add(txtKg); 
    b.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
          //************************************   
    
           if (txtKg.getText().equals("")) {
            JOptionPane.showMessageDialog(c, "Weight should not be blank");
            txtKg.requestFocus();
        } else {
            try {
                double weight = Double.parseDouble(txtKg.getText());
                if (weight <= 0) {
                    JOptionPane.showMessageDialog(c, "Weight should be greater than Zero");
                    txtKg.setText("");
                    txtKg.requestFocus();
                }
                else {
                    Object ftitem = cbFt.getSelectedItem();
                    String ft = (String) ftitem;
                    int foot = Integer.parseInt(ft);

                    Object lnitem = cbln.getSelectedItem();
                    String ln = (String) ftitem;
                    int Inches = Integer.parseInt(ln);


                    //convert FT to inches
                    while (foot > 0) {
                        Inches += 12;
                        foot--;
                    }
                    double height = Inches * 2.54;

                    double bmi = weight / (height * height);
                    bmi = bmi * 10000;
                    bmitext.setText(String.valueOf(bmi));
   
                    String msg;
                    if (bmi < 18.5) 
                    {
                        msg = "You are underweight";
                        conditiontext.setText(msg);
                    } 
                    
                    else if (bmi >= 18.5 & bmi < 25) 
                    {
                     msg = "Congratulations!.You are normal.";
                      conditiontext.setText(msg);
                    }
                       
                    else if (bmi >= 25 && bmi < 30)
                    {
                    msg = "You are overweight";
                     conditiontext.setText(msg);
                    } 
                    else{
                     msg = "You are Obese";
                      conditiontext.setText(msg);
                    }
                       


                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(2);
                    String bmis = nf.format(bmi);


                  //  JOptionPane.showMessageDialog(c, "BMI=" + bmis + msg);
                    txtKg.setText("");
                    cbFt.setSelectedItem("1");
                    cbln.setSelectedItem("0");
                  
                    bmitext.setEnabled(true);
                    conditiontext.setEnabled(true);

                }
            }

            catch(NumberFormatException error){
                JOptionPane.showMessageDialog(c,"Enter proper weight");
                txtKg.setText("");
                txtKg.requestFocus();;
            }
        }
          
         //*************************************
        }  
    });  
     }
    public static void main(String[] args) {
        BMICalculator f=new BMICalculator();  
            f.setVisible(true);
}  
} 