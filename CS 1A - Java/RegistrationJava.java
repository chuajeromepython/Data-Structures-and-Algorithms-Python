import java.awt.*;
import java.awt.event.*;

class RegistrationForm{
	Frame frame, popup;
	Button register, clear;
	TextField user, password, confirm;
	Label l1, l2, l3, pop_label;
	Label flag_user, flag_pass, flag_confirm;
	RegistrationForm(){
		frame = new Frame("Registration Form");
		frame.setSize(300,350);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				frame.dispose();
			}
		});
		l1 = new Label("Username");
		l2 = new Label("Password");
		l3 = new Label("Confirm Password");
		flag_user = new Label();
		flag_pass = new Label();
		flag_confirm = new Label();
		flag_user.setBounds(50,90,200,25);
		flag_pass.setBounds(50,150,200,25);
		flag_confirm.setBounds(50,210,200,25);
		register = new Button("Register");
		clear = new Button("Clear");
		user = new TextField();
		password = new TextField();
		confirm = new TextField();
		l1.setBounds(50,50,100,25);
		user.setBounds(50,70,200,25);
		l2.setBounds(50,110,200,25);
		password.setBounds(50,130,200,25);
		l3.setBounds(50,170,200,25);
		confirm.setBounds(50,190,200,25);
		register.setBounds(50,250,200,25);
		clear.setBounds(50,280,200,25);
		user.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e){
				if (user.getText().isEmpty()){
					flag_user.setText("This field shouldn't be left empty");
					flag_user.setFont(new Font("Arial",Font.PLAIN,10));
					flag_user.setForeground(Color.red);
				} else if (user.getText().length() <= 8){
					flag_user.setText("Username too short");
					flag_user.setFont(new Font("Arial",Font.PLAIN,10));
					flag_user.setForeground(Color.red);
				} else if (user.getText().length() >= 15){
					flag_user.setText("Username too long");
					flag_user.setFont(new Font("Arial",Font.PLAIN,10));
					flag_user.setForeground(Color.red);
				} else if (user.getText().length() >= 9 || user.getText().length() < 14){
					flag_user.setText("Valid Username");
					flag_user.setFont(new Font("Arial",Font.PLAIN,10));
					flag_user.setForeground(Color.green);
				}
			}
		});
		password.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e){
				if (password.getText().isEmpty()){
					flag_pass.setText("This field shouldn't be left empty");
					flag_pass.setFont(new Font("Arial",Font.PLAIN,10));
					flag_pass.setForeground(Color.red);
				} else if (password.getText().length() <= 8){
					flag_pass.setText("Password too short");
					flag_pass.setFont(new Font("Arial",Font.PLAIN,10));
					flag_pass.setForeground(Color.red);
				} else if (password.getText().length() > 15){
					flag_pass.setText("Password too long");
					flag_pass.setFont(new Font("Arial",Font.PLAIN,10));
					flag_pass.setForeground(Color.red);
				} else {
					flag_pass.setText("Valid Password");
					flag_pass.setFont(new Font("Arial",Font.PLAIN,10));
					flag_pass.setForeground(Color.green);
				}
			}
		});
		confirm.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e){
				if (!confirm.getText().equals(password.getText())){
					flag_confirm.setText("Password doesn't match");
					flag_confirm.setFont(new Font("Arial",Font.PLAIN,10));
					flag_confirm.setForeground(Color.red);
				} else {
					flag_confirm.setText("Password matched");
					flag_confirm.setFont(new Font("Arial",Font.PLAIN,10));
					flag_confirm.setForeground(Color.green);
				}
			}
		});
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				popup = new Frame("Notice");
				popup.addWindowListener(new WindowAdapter(){
					@Override
					public void windowClosing(WindowEvent e){
						popup.dispose();
					}
				});
				pop_label = new Label();
				popup.setSize(180,180);
				popup.setLayout(null);
				popup.setLocationRelativeTo(null);
				if (user.getText().isEmpty()){
					popup.setVisible(true);
					pop_label.setText("Field " + "Username" + " is empty");
					pop_label.setBounds(20,50,200,90);
					popup.add(pop_label);
				} else if (password.getText().isEmpty()){
					popup.setVisible(true);
					pop_label.setText("Field " + "Password" + " is empty");
					pop_label.setBounds(20,50,200,90);
					popup.add(pop_label);
				} else if (confirm.getText().isEmpty()){
					popup.setVisible(true);
					pop_label.setText("Need to confirm password");
					pop_label.setBounds(20,50,200,90);
					popup.add(pop_label);
				} else if (user.getText().isEmpty() && password.getText().isEmpty() && confirm.getText().isEmpty()){
					popup.setVisible(true);
					pop_label.setText("All fields must be filled");
					pop_label.setBounds(20,50,200,90);
					popup.add(pop_label);
				} else {
					if (flag_user.getText().equals("Username too short") || flag_user.getText().equals("Username too long")){
						popup.setVisible(true);
						pop_label.setText("Invalid Username");
						pop_label.setBounds(40,50,200,90);
						popup.add(pop_label);
					} else if (flag_pass.getText().equals("Password too short") || flag_pass.getText().equals("Password too long")){
						popup.setVisible(true);
						pop_label.setText("Invalid Password");
						pop_label.setBounds(40,50,200,90);
						popup.add(pop_label);
					} else if (flag_confirm.getText().equals("Password doesn't match")){
						popup.setVisible(true);
						pop_label.setText("Incorrect Password");
						pop_label.setBounds(40,50,200,90);
						popup.add(pop_label);
					} else {
						popup.setVisible(true);
						pop_label.setText("Success!");
						pop_label.setBounds(65,50,200,90);
						popup.add(pop_label);
					}
				}
			}
		});
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				user.setText(" ");
				password.setText(" ");
				confirm.setText(" ");
				flag_user.setText(" ");
				flag_pass.setText(" ");
				flag_confirm.setText(" ");
			}
		});
		frame.add(user);
		frame.add(password);
		frame.add(confirm);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(register);
		frame.add(clear);
		frame.add(flag_user);
		frame.add(flag_pass);
		frame.add(flag_confirm);
	}
}
public class RegistrationJava {
	public static void main(String[] args) {
		new RegistrationForm();
	}
}
