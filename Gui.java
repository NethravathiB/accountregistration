
package gui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Finalproject {
    static int currentuser=0;
    static User[] userarray =new User[100];
    public static void main(String[] args) {
        JFrame f = new JFrame(); 
        f.setSize(200, 300);
        JTextField nametextfield=new JTextField();
        JTextField usernametextfield=new JTextField();
        JTextField passwordtextfield=new JTextField();
        JTextField emailtextfield=new JTextField();
        
        JLabel namelabel=new JLabel("Name :");
         JLabel usernamelabel=new JLabel("UserName :");
        JLabel passwordlabel=new JLabel("Password :");
        JLabel emaillabel=new JLabel("Email :");
       
        
        JButton signup =new JButton();
        signup.setText("sign up");
        JButton login =new JButton();
        login.setText("Log in");
        f.setLayout(new GridLayout(5,1));
      
        f.setVisible(true);
        f.add(namelabel);
        f.add(nametextfield);
        
        f.add(usernamelabel);
        f.add(usernametextfield);
        
        f.add(passwordlabel);
        f.add(passwordtextfield);
        
         f.add(emaillabel);
        f.add(emailtextfield);
        
        f.add(login);
        f.add(signup);
        
       login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<userarray.length;i++){
                    if(userarray[i]!=null && userarray[i].getUsername().equals(usernametextfield.getText())){
                    if(userarray[i].getPassword().equals(passwordtextfield.getText())){
                        if(userarray[i].getEmail().equals(emailtextfield.getText())){
                        System.out.println("Logged in");
                    nametextfield.setVisible(false);
                    usernametextfield.setVisible(false);
                    passwordtextfield.setVisible(false); 
                    emailtextfield.setVisible(false); 
                    
                    namelabel.setText("Welcome " +userarray[i].getName());
                    usernamelabel.setVisible(false);
                    passwordlabel.setVisible(false);
                    emaillabel.setVisible(false);
                    
                    break;
                        }
                    }
                    }
                }
            }
       });
            
        
        signup.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                User usertoadd=new User(nametextfield.getText(),usernametextfield.getText(),passwordtextfield.getText(),emailtextfield.getText());
                boolean userexists=false;
                
                for(int i=0;i<userarray.length;i++)
                {
                    if(userarray[i]!=null && userarray[i].getUsername().equals(usertoadd.getUsername()))
                        userexists=true;
                }
                if(userexists==false){
                    try {
                        userarray[currentuser]=usertoadd;
                        
                        
                        System.out.println("Added new user with name " +usertoadd.getName());
                        
                        Mail.sendmail(usertoadd.getEmail());
                    } catch (Exception ex) {
                        Logger.getLogger(Finalproject.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                    
                    
               
                
                }
        });
    }
    
}


