import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.event.*;


class Start{
	JFrame f;
	JPanel p1,p2;
	JTabbedPane tp;
	JComboBox cb1,cb2;
	ButtonGroup bg;
	JRadioButton rb1,rb2;
	JButton gen_stat;
	JLabel fullname, birthday, team, country, experience, status;
	JLabel l_fullname, l_birthday, l_team, l_country, l_experience, l_status;
	String[] teamsEast = {"--Select Team--","Celtics","Knicks","Bucks","--End--"};
	String[] teamsWest = {teamsEast[0],"Thunder","Nuggets","Timberwolves",teamsEast[teamsEast.length - 1]};
	String[][] playersEast = {
			{"Tatum, J","Holiday, J","Brown, J"},
			{"DiVincenzo, D","Toppin, J","Washington, J"},
			{"Golloway, J","Lillard, D","Beauchamp, M"}};
	String[][] playersWest = {
			{"Gilgeous-Alexander, S","Giddey, J","Dort, L"},
			{"Braun, C","Porter, M","Strawther, J"},
			{"Clark, J","Anderson, K","McDaniels, J"}};
	Start(){
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setResizable(true);
		f.setLayout(null);
		f.setVisible(true);
		
		tp = new JTabbedPane();
		tp.setBounds(1,-2,383,373);
		
		p1 = new JPanel();
		p1.setLayout(null);
		
		bg = new ButtonGroup();
		
		rb1 = new JRadioButton("West");
		rb1.setBounds(20,20,60,30);
		
		rb1.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				cb1.removeAllItems();
				if (rb1.isSelected()){
					addComponent(teamsEast,cb1);
				}
			}
		});
	
		rb2 = new JRadioButton("East");
		rb2.setBounds(80,20,60,30);
		
		rb2.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				cb1.removeAllItems();
				if (rb2.isSelected()){
					addComponent(teamsWest,cb1);
				}
			}
		});
		
		bg.add(rb1);
		bg.add(rb2);
		
		cb1 = new JComboBox();
		cb1.addItem("--None--");
		cb1.setBounds(20,50,120,20);
		
		cb1.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				cb2.removeAllItems();
				if ((rb1.isSelected() || rb2.isSelected()) && (cb1.getSelectedIndex() == 0 || cb1.getSelectedIndex() == 4)){
					cb2.addItem("--Nothing follows--");
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 1){
					addComponent(playersEast[0],cb2);
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 2){
					addComponent(playersEast[1],cb2);
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 3){
					addComponent(playersEast[2],cb2);
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 1){
					addComponent(playersWest[0],cb2);
				}  else if (rb2.isSelected() && cb1.getSelectedIndex() == 2){
					addComponent(playersWest[1],cb2);
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 3){
					addComponent(playersWest[2],cb2);
				}
			}
		});
		
		cb2 = new JComboBox();
		cb2.addItem("--None--");
		cb2.setBounds(20,100,120,20);
		
		gen_stat = new JButton("Generate Stat");
		gen_stat.setBounds(20,150,120,20);
		
		gen_stat.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (!rb1.isSelected() && !rb2.isSelected()){
					JOptionPane.showMessageDialog(f, "Must Select a team and a player!");
				} else if ((rb1.isSelected() || rb2.isSelected()) && cb2.getSelectedItem() == "--Nothing follows--"){
					JOptionPane.showMessageDialog(f, "Must Select a team");
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 1 && cb2.getSelectedIndex() == 0){
					fillInfo("Jayson Tatum","March 3, 1998","Celtics","USA","6 Years","Unwell");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 1 && cb2.getSelectedIndex() == 1){
					fillInfo("Jrue Holiday","June 12, 1990","Celtics","USA","14 Years","Has Diabetes");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 1 && cb2.getSelectedIndex() == 2){
					fillInfo("Jaylen Brown","October 24, 1996","Celtics","USA","7 Years","Alive");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 2 && cb2.getSelectedIndex() == 0){
					fillInfo("Donte DiVincenzo","January 31, 1997","Knicks","USA","5 Years","Has Ingrown toenail");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 2 && cb2.getSelectedIndex() == 1){
					fillInfo("Jacob Toppin","May 8, 2000","Knicks","USA","Rookie","Has constipation");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 2 && cb2.getSelectedIndex() == 2){
					fillInfo("Duane Washington","March 24, 2000","Knicks","Germany","2 Years","Can't sleep");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 3 && cb2.getSelectedIndex() == 0){
					fillInfo("Jaylin Galloway","No Birthday","No Team","No country","No exp","Presumably dead");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 3 && cb2.getSelectedIndex() == 1){
					fillInfo("Dimain Lillard","July 15, 1990","Bucks","USA","11 Years","Fine");	
				} else if (rb1.isSelected() && cb1.getSelectedIndex() == 3 && cb2.getSelectedIndex() == 2){
					fillInfo("Marlon Beauchamp","October 12, 2000","Bucks","USA","1 Year","Alive?");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 1 && cb2.getSelectedIndex() == 0){
					fillInfo("Shai Gilgeous-Alexander","June 12, 1998","Thunder","USA","5 Years","The name, why?");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 1 && cb2.getSelectedIndex() == 1){
					fillInfo("Josh Giddey","October 10, 2002","Thunder","Australia","2 Years","Giddey, mate!");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 1 && cb2.getSelectedIndex() == 2){
					fillInfo("Lugeuntz Dort","April 19, 1999","Thunder","Canada","4 Years","Alive");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 2 && cb2.getSelectedIndex() == 0){
					fillInfo("Christian Braun","April 17, 2001","Nuggets","USA","1 Year","White boy");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 2 && cb2.getSelectedIndex() == 1){
					fillInfo("Micheal Porter","June 29, 1998","Nuggets","USA","4 Year","You shall not pass, Porter");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 2 && cb2.getSelectedIndex() == 2){
					fillInfo("Julian Strawther","April 18, 2002","Nuggets","USA","Rookie","Has clubfoot");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 3 && cb2.getSelectedIndex() == 0){
					fillInfo("Jaylen Clark","October 13, 2001","Timberwolves","USA","Rookie","Alive");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 3 && cb2.getSelectedIndex() == 1){
					fillInfo("Kyle Anderson","September 20, 1993","Timberwolves","USA","9 Years","Dead or alive");	
				} else if (rb2.isSelected() && cb1.getSelectedIndex() == 3 && cb2.getSelectedIndex() == 2){
					fillInfo("Jaden McDaniels","September 29, 2000","Timberwolves","USA","3 Years","McDonalds'");	
				}
			}
		});
		
		fullname = new JLabel("Name:");
		fullname.setBounds(160,25,50,20);
		birthday = new JLabel("Birthday:");
		birthday.setBounds(160,50,50,20);
		team = new JLabel("Team:");
		team.setBounds(160,75,50,20);
		country = new JLabel("Country:");
		country.setBounds(160,100,50,20);
		experience = new JLabel("Exp:");
		experience.setBounds(160,125,50,20);
		status = new JLabel("Status:");
		status.setBounds(160,150,50,20);
		
		l_fullname = new JLabel();
		l_fullname.setBounds(220,25,250,20);
		l_birthday = new JLabel();
		l_birthday.setBounds(220,50,250,20);
		l_team = new JLabel();
		l_team.setBounds(220,75,250,20);
		l_country = new JLabel();
		l_country.setBounds(220,100,250,20);
		l_experience = new JLabel();
		l_experience.setBounds(220,125,250,20);
		l_status = new JLabel();
		l_status.setBounds(220,150,250,20);
		
		p1.add(rb1);
		p1.add(rb2);	
		p1.add(cb1);
		p1.add(cb2);
		p1.add(gen_stat);
		p1.add(fullname);
		p1.add(birthday);
		p1.add(team);
		p1.add(country);
		p1.add(experience);
		p1.add(status);
		p1.add(l_fullname);
		p1.add(l_birthday);
		p1.add(l_team);
		p1.add(l_country);
		p1.add(l_experience);
		p1.add(l_status);
		
		
		p2 = new JPanel();
		p2.setLayout(null);
		
		tp.add("Home",p1);
		tp.add("Others",p2);
		
		f.add(tp);
	}
	void addComponent(String[] items, JComboBox comp){
		for (String item: items){
			comp.addItem(item);
		}
	}
	void fillInfo(String f, String b, String t, String c, String e, String s){
		l_fullname.setText(f);
		l_birthday.setText(b);
		l_team.setText(t);
		l_country.setText(c);
		l_experience.setText(e);
		l_status.setText(s);
	}
}

public class Statsviewer{
	public static void main(String[] args){
		new Start();
	}
}
