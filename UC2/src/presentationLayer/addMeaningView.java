package presentationLayer;


import java.sql.SQLException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.sale_bll;
import transfer_obj.words;
import transfer_obj.meaning;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class addMeaningView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static sale_bll salebll = new sale_bll();
	private JPanel contentPane;
	
	private JTable table_1;
	private static ArrayList<meaning> location = new ArrayList<meaning>();
	meaning m ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
					addMeaningView frame = new addMeaningView();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public addMeaningView() throws SQLException{
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		salebll = new sale_bll();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 79, 261, 162);
		contentPane.add(scrollPane);
		
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton calculateButton = new JButton("import");
		JFrame frame = new JFrame("table");
		
		frame.getContentPane().setLayout(null);
	
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		
		String []col  = new String [2];
	     ArrayList<words> sa = salebll.getarray();
	     String [] title = new String[2];
	     title[0] = "WORD";
	     title[1] = "MEANING";
	    model.setColumnIdentifiers(title);
		for (int i=0;i<sa.size();i++) {
			col[0] = sa.get(i).getName();
			col[1] = sa.get(i).getId();
			model.addRow(col);
		}
	    
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String name = model.getValueAt(table_1.getSelectedRow(),0).toString();			
			String mean = model.getValueAt(table_1.getSelectedRow(),1).toString();
	
			model.setValueAt(name,table_1.getSelectedRow(), 0);
			model.setValueAt(mean,table_1.getSelectedRow(), 1);
		
			m = new meaning();
			m.setWord(name);
			m.setMeanings(mean);
			location.add(m);
			
		
			try {
				salebll.Main("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			
		}
		
		);
	    
	
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(331, 196, 85, 21);
		btnNewButton.setBackground(new Color(0, 102, 153));
		contentPane.add(btnNewButton);
		
	}
	public ArrayList<meaning> getlocation(){
		System.out.println("this is in view class");
		System.out.println(location.get(0).getWord());
		System.out.println(location.get(0).getMeanings());
		   
	      return location;

	    }
	
}