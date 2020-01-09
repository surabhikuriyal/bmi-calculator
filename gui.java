import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gui extends JFrame implements ActionListener
{
 JLabel l1,l2,l3;
 JButton b1,exitB;
 JTextField t1,t2,t3,t4;
 private ExitButtonHandler ebHandler;
 
 gui()
 {
  l1=new JLabel("Enter weight(in kilograms):");
  l2=new JLabel("Enter height(in metres):");
  l3=new JLabel("BMI :");
  b1=new JButton("        Calculate BMI(Body Mass Index)        ");
  exitB = new JButton("Exit");
  ebHandler = new ExitButtonHandler();
  exitB.addActionListener(ebHandler);
  t1=new JTextField(10);
  t2=new JTextField(10);
  t3=new JTextField(15);
  t4=new JTextField(20);
  
  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(b1);
  add(l3);
  add(t3);
  add(t4);
  add(exitB);

  b1.addActionListener(this);
  setSize(300,200);
  setLayout(new FlowLayout());
  setTitle("BMI CALCULATOR");

 }

 public void actionPerformed(ActionEvent ae)
 {
  float a,b;
  double c;
  if(ae.getSource()==b1)
  {
   a=Float.parseFloat(t1.getText());
   b=Float.parseFloat(t2.getText());
   c=a/Math.pow(b,2);
   t3.setText(String.valueOf(c));
   if(c<18.5)
   t4.setText("Underweight!!!");
   else if(c>=18.5 && c<=24.9)
   t4.setText("Normal weight!!!");
   else if(c>=25 && c<=29.9)
   t4.setText("Overweight!!!");
   else if(c>=30 && c<=35)
   t4.setText("Obesity!!!");
   else
   t4.setText("Severe Obesity!");
  }
 }

private class ExitButtonHandler implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
       {
           System.exit(0);
       }
   }

 public static void main(String args[])
 {
  gui a=new gui();
  a.setVisible(true);
  a.setLocation(200,200);
 }
}