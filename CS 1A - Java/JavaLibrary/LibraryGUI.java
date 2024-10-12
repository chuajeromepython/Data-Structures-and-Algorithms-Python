package Library;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.Map;

class LibraryGUI {
	int count_f, count_uf, count_total;
	JFrame f;
	JPanel main, finished, unfinished, allbooks;
	JTabbedPane tp;
	JLabel main_add, counter1, counter2, total, lcnt1, lcnt2, ltot;
	JTextField main_tf_title, main_tf_author, main_tf_isFinished;
	JButton addme;
	DefaultTableModel model1, model2, model3;
	JTable table1, table2, table3;
	JScrollPane sp1, sp2, sp3;
	
	
	LibraryGUI(){
		count_f = 0;
		count_uf = 0;
		count_total = count_f + count_uf;
		f = new JFrame("My Library");
		f.setSize(500,300);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		tp = new JTabbedPane();
		tp.setBounds(5,5,473,252);
		
		main = new JPanel();
		main.setLayout(null);
		main_add = new JLabel("Add A Book");
		main_add.setBounds(155,20,200,20);
		main_add.setFont(new Font("Times New Roman",Font.PLAIN,30));
		
		main_tf_title = new JTextField("Title e.g., Emma");
		main_tf_title.setBounds(100,50,250,25);
		main_tf_title.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if (main_tf_title.getText().equals("Title e.g., Emma")){
					main_tf_title.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {}
		});
		
		main_tf_author = new JTextField("Author e.g., Jane Austen");
		main_tf_author.setBounds(100,90,250,25);
		main_tf_author.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if (main_tf_author.getText().equals("Author e.g., Jane Austen")){
					main_tf_author.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {}
		});
		
		main_tf_isFinished = new JTextField("Currently at page? (Leave blank if finished)");
		main_tf_isFinished.setBounds(100,130,250,25);
		main_tf_isFinished.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent e){
				if (main_tf_isFinished.getText().equals("Currently at page? (Leave blank if finished)")){
					main_tf_isFinished.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {}
		});
		
		addme = new JButton("Add me");
		addme.setBounds(100,170,250,25);
		
		addme.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				boolean isFinished;
				if (main_tf_isFinished.getText().isEmpty()){
					Finished f = new Finished(main_tf_title.getText(),main_tf_author.getText());
					isFinished = true;
					f.addToLibrary();
					for (Map.Entry<String, String> entry: f.finished.entrySet()){
						model1.addRow(new Object[]{entry.getKey(),entry.getValue()});
					}
					count_f += 1;
				} else {
					Unfinished uf = new Unfinished(main_tf_title.getText(),Integer.parseInt(main_tf_isFinished.getText()));
					isFinished = false;
					uf.addToLibrary();
					for (Map.Entry<String, Integer> entry: uf.unfinished.entrySet()){
						model2.addRow(new Object[]{entry.getKey(),entry.getValue()});
					}
					count_uf += 1;
				}
				if (isFinished){
					model3.addRow(new Object[]{main_tf_title.getText(), main_tf_author.getText(), "Finished"});
					counter1.setText(String.valueOf(count_f));
				} else {
					model3.addRow(new Object[]{main_tf_title.getText(), main_tf_author.getText(), "At page " + main_tf_isFinished.getText()});
					counter2.setText(String.valueOf(count_uf));
				}
				total.setText(String.valueOf(count_f + count_uf));
				
			}
		});
			
		
		main.add(main_add);
		main.add(main_tf_title);
		main.add(main_tf_author);
		main.add(main_tf_isFinished);
		main.add(addme);
		
		
		finished = new JPanel();
		finished.setLayout(null);
		model1 = new DefaultTableModel();
		table1 = new JTable(model1);
		sp1 = new JScrollPane(table1);
		sp1.setBounds(5,0,460,222);
		model1.addColumn("Title");
		model1.addColumn("Author");
		finished.add(sp1);
		
		unfinished = new JPanel();
		unfinished.setLayout(null);
		model2 = new DefaultTableModel();
		table2 = new JTable(model2);
		sp2 = new JScrollPane(table2);
		sp2.setBounds(5,0,460,222);
		model2.addColumn("Title");
		model2.addColumn("Page");
		unfinished.add(sp2);
		
		allbooks = new JPanel();	
		allbooks.setLayout(null);
		model3 = new DefaultTableModel();
		table3 = new JTable(model3);
		sp3 = new JScrollPane(table3);
		sp3.setBounds(0,0,300,222);
		model3.addColumn("Title");
		model3.addColumn("Author");
		model3.addColumn("Page");
		
		lcnt1 = new JLabel("Finished");
		lcnt1.setBounds(320,20,100,20);
		lcnt2 = new JLabel("Unfinished");
		lcnt2.setBounds(320,50,100,20);
		ltot = new JLabel("Total");
		ltot.setBounds(320,80,100,20);
			
		
		counter1 = new JLabel("0");
		counter1.setBounds(400,20,100,20);
		
		counter2 = new JLabel("0");
		counter2.setBounds(400,50,100,20);
		
		total = new JLabel("0");
		total.setBounds(400,80,100,20);
		
		
		
		allbooks.add(sp3);
		allbooks.add(counter1);
		allbooks.add(counter2);
		allbooks.add(total);
		allbooks.add(lcnt1);
		allbooks.add(lcnt2);
		allbooks.add(ltot);
		
		
		
		
		
		tp.add("Main", main);
		tp.add("Finished", finished);
		tp.add("Unfinished", unfinished);
		tp.add("All Books", allbooks);
		
		
		
		
		f.add(tp);
		f.setVisible(true);
	}
}
