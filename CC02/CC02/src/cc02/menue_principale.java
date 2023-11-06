package cc02;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class menue_principale {

	 JFrame frame;
	 JTextField txtcode;
	 JTextField txtnom;
	 JTextField txtprix;
	 JTextField txtdate;
	JTextField txtrechercher;
	 JTable txtTable;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menue_principale window = new menue_principale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *  connect with database
	 */
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() {
		try{ 
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basededonnees","root","");  
			   }catch(Exception e){
			    System.out.println(e);
			   } }
	
	/**
	 * crée la table medicament
	 */
	
	private void table() {
		try{  
			   connect();
			   String[] entet = {"Code","Nom","Prix","Date","Quantité"};
			   String[] ligne = new String[5];
			   
			   DefaultTableModel model = new DefaultTableModel(null, entet);
			   String sql  = "select * from medicament" ;
			   Statement st=con.createStatement();
			   rs=st.executeQuery(sql);
			   
			   while(rs.next())  
			   {	ligne[0]= rs.getString("Code");
			   		ligne[1]= rs.getString("Nom");
			   		ligne[2]= rs.getString("Prix");
			   		ligne[3]= rs.getString("Date");
			   		ligne[4]= rs.getString("Quantité");
			   		model.addRow(ligne);
			   }
			   		txtTable.setModel(model);
			   		con.close();
		}catch(Exception e3){
			    e3.printStackTrace();
			   } 
	}
	
	
	
	
	public menue_principale() {
		initialize();
		
		connect();
		table();
	}

	/**
	 * Initializer les composants de frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(menue_principale.class.getResource("/image/Coupe_d'Hygie.svg.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 708, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 672, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E9dicament");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 6, 626, 27);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(147, 66, 533, 146);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 11, 86, 23);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_2.setBounds(27, 78, 86, 23);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prix");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_3.setBounds(27, 112, 86, 23);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Code");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(27, 44, 86, 23);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_4.setBounds(220, 44, 86, 23);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Quantit\u00E9");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_5.setBounds(220, 78, 86, 23);
		panel_2.add(lblNewLabel_1_5);
		
		txtcode = new JTextField();
		txtcode.setBounds(74, 45, 127, 20);
		panel_2.add(txtcode);
		txtcode.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(74, 80, 127, 20);
		panel_2.add(txtnom);
		
		txtprix = new JTextField();
		txtprix.setColumns(10);
		txtprix.setBounds(74, 114, 127, 20);
		panel_2.add(txtprix);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(285, 46, 127, 20);
		panel_2.add(txtdate);
		
		JSpinner txtquantité = new JSpinner();
		txtquantité.setBounds(285, 80, 127, 20);
		panel_2.add(txtquantité);
		
		/**
		 * ajouter event pour le bouton ajouter
		 */
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  //*****************************************************************
					   connect();
					   pst = con.prepareStatement("insert into medicament(Code, Nom, Prix , Date, Quantité) values (?,?,?,?,?)");
					   pst.setString(1,txtcode.getText());
					   pst.setString(2,txtnom.getText());
					   pst.setString(3,txtprix.getText());
					   pst.setString(4,txtdate.getText());
					   pst.setString(5,txtquantité.getValue().toString());
					   pst.executeUpdate();
					   con.close();
					   JOptionPane.showMessageDialog(null, txtnom.getText()+" est Ajouté");
					   table();
					   
				}catch(Exception e2){
					    e2.printStackTrace();
					   } 
				
			}
			           //***********************************************************************
		});
		btnAjouter.setForeground(new Color(0, 128, 255));
		btnAjouter.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAjouter.setBounds(413, 113, 99, 23);
		panel_2.add(btnAjouter);
		
		JLabel lblNewLabel_1_6 = new JLabel("Liste m\u00E9dicament");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_6.setBounds(157, 223, 127, 23);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		/**
		 * ajouter keyadapter pour faciliter notre recharche
		 */
		txtrechercher = new JTextField();
		txtrechercher.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//*******************************************************************************
				DefaultTableModel table = (DefaultTableModel)txtTable.getModel();
				String  search = txtrechercher.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
				txtTable.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
				//******************************************************************************
			}
		});
		txtrechercher.setColumns(10);
		txtrechercher.setBounds(294, 225, 246, 20);
		frame.getContentPane().add(txtrechercher);
		
		JButton btnRecherecher = new JButton("Recherecher");
		btnRecherecher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecherecher.setForeground(new Color(0, 128, 255));
		btnRecherecher.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRecherecher.setBounds(564, 223, 99, 23);
		frame.getContentPane().add(btnRecherecher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 253, 394, 122);
		frame.getContentPane().add(scrollPane);
		
		txtTable = new JTable();
		txtTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int i=txtTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) txtTable.getModel();
				txtcode.setText(model.getValueAt(i, 0).toString());
				txtnom.setText(model.getValueAt(i, 1).toString());
				txtprix.setText(model.getValueAt(i, 2).toString());
				txtdate.setText(model.getValueAt(i, 3).toString());
				txtquantité.setToolTipText(model.getValueAt(i, 4).toString());
			}
		});
		scrollPane.setViewportView(txtTable);
		/**
		 *  ajouter event pour le bouton modifier
		 */
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//************************************************************************
				try{
					   connect();
					   pst = con.prepareStatement("UPDATE medicament SET Nom=?, Prix=?, Date=?, Quantité=? WHERE Code=?");
					   
					   pst.setString(5,txtcode.getText());
					   pst.setString(1,txtnom.getText());
					   pst.setString(2,txtprix.getText());
					   pst.setString(3,txtdate.getText());
					   pst.setString(4,txtquantité.getValue().toString());
					   pst.executeUpdate();
					   con.close();
					   JOptionPane.showMessageDialog(null, txtnom.getText()+" est modifié");
					   table(); 
				}catch(Exception e2){
					    e2.printStackTrace();
					   } 
				//************************************************************************
			}
		});
		btnModifier.setForeground(new Color(0, 128, 255));
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnModifier.setBounds(564, 352, 99, 23);
		frame.getContentPane().add(btnModifier);
		/**
		 *  ajouter event pour le bouton supprimer
		 */
		JButton btnSuprimer = new JButton("Supprimer");
		btnSuprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//****************************************************************************
				try{  
					   connect();
					   pst = con.prepareStatement("DELETE FROM medicament WHERE Code=?");
					   pst.setString(1,txtcode.getText());
					 
					   pst.executeUpdate();
					   con.close();
					   JOptionPane.showMessageDialog(null, txtnom.getText()+" est suppriméé");
					   table();
				}catch(Exception e2){
					    e2.printStackTrace();
					   } 
				
				//******************************************************************************
			}
		});
			
		btnSuprimer.setForeground(new Color(0, 128, 255));
		btnSuprimer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSuprimer.setBounds(564, 318, 99, 23);
		frame.getContentPane().add(btnSuprimer);
		/**
		 *  ajouter event pour le bouton nouveau
		 */
		JButton btnAjouter_1_1 = new JButton("Nouveau");
		btnAjouter_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//********************************************************************************
				try{  
					txtcode.setText("");
					txtnom.setText("");
					txtprix.setText("");
					txtdate.setText("");
					txtquantité.setToolTipText("");  
				}catch(Exception e2){
					    e2.printStackTrace();
					   } 
			}
				//*********************************************************************************
		});
		btnAjouter_1_1.setForeground(new Color(0, 128, 255));
		btnAjouter_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAjouter_1_1.setBounds(10, 66, 127, 44);
		frame.getContentPane().add(btnAjouter_1_1);
		/**
		 *  ajouter event pour le bouton quitter
		 */
		
		JButton btnAjouter_1_2 = new JButton("Quitter");
		btnAjouter_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//*************************************************************************
				frame = new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "Vouler-vous vraiment quitter?","quitter" ,JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION )
						{
					System.exit(0);
				}
				//*************************************************************************
			}
		});
		btnAjouter_1_2.setForeground(new Color(0, 128, 255));
		btnAjouter_1_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAjouter_1_2.setBounds(10, 109, 127, 44);
		frame.getContentPane().add(btnAjouter_1_2);
		/**
		 *  ajouter un image
		 */
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(menue_principale.class.getResource("/image/Untitled(1).png")));
		lblNewLabel_2.setBounds(10, 223, 127, 300);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnAjouter_1_2_1 = new JButton("About");
		btnAjouter_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Bennceur Djihane-02");
			}
		});
		btnAjouter_1_2_1.setForeground(new Color(0, 128, 255));
		btnAjouter_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAjouter_1_2_1.setBounds(10, 152, 127, 44);
		frame.getContentPane().add(btnAjouter_1_2_1);
	}
}
