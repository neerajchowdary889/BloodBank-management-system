import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Label;

public class Viewprofile extends JFrame {
	
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	private JPanel contentPane1;
	private JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewprofile frame = new Viewprofile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Viewprofile() throws EncryptedDocumentException, IOException {
		
		

		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet2");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 334);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(39, 41, 118, 21);
		contentPane1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 41, 166, 27);
		contentPane1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(39, 98, 118, 21);
		contentPane1.add(lblNewLabel_1);
		
	
		
		JLabel lblNewLabel_3 = new JLabel("DOB");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(39, 153, 118, 21);
		contentPane1.add(lblNewLabel_3);
		
	
		
		JLabel lblNewLabel_5 = new JLabel("Pincode");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_5.setBounds(39, 209, 118, 21);
		contentPane1.add(lblNewLabel_5);
		
	
		
		JLabel lblNewLabel_7 = new JLabel("Blood Group");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_7.setBounds(39, 263, 118, 21);
		contentPane1.add(lblNewLabel_7);
		
		
		
		JButton btnNewButton = new JButton("<< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(0, 0, 89, 23);
		contentPane1.add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r1 = textField.getText();
				
				
				int noOfRows=sh.getLastRowNum();
				
				for(int i=1;i<=noOfRows;i++) {
					
        			Cell q1 = sh.getRow(i).getCell(0);
        			
        			String a1 = q1.toString();
        			
        			if(a1.equals(r1)){
                   	 textField.setText(null);
                   	 Cell b1,b2,b3,b4;
                		String c1,c2,c3,c4;
                		
                		b1 = sh.getRow(i).getCell(0);
                		b2 = sh.getRow(i).getCell(1);
                		b3 = sh.getRow(i).getCell(2);
                		b4 = sh.getRow(i).getCell(3);
                	
                		c1 = b1.toString();
                		c2 = b2.toString();
                		c3 = b3.toString();
                		c4 = b4.toString();
                   	
                		JLabel lblNewLabel_2 = new JLabel(c1);
               		lblNewLabel_2.setBounds(188, 99, 155, 27);
               		contentPane1.add(lblNewLabel_2);
                   
               		JLabel lblNewLabel_4 = new JLabel(c2);
               		lblNewLabel_4.setBounds(188, 153, 166, 27);
               		contentPane1.add(lblNewLabel_4);
               		
               		JLabel lblNewLabel_6 = new JLabel(c3);
               		lblNewLabel_6.setBounds(188, 209, 166, 21);
               		contentPane1.add(lblNewLabel_6);
               		
               		JLabel lblNewLabel_8 = new JLabel(c4);
               		lblNewLabel_8.setBounds(188, 258, 155, 26);
               		contentPane1.add(lblNewLabel_8);
                   	
                   	 setState(Viewprofile.ICONIFIED);
   					 setState(Viewprofile.NORMAL);
   					
                   	 break;
           			
   				}
        			else if(!a1.equals(r1)) {
        				continue;
        				
        			}
        			else {
       				 JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
       				 
          				break;
	                	}     
			}
				
		}});
	
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(371, 272, 89, 23);
		contentPane1.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel(" ");
		lblNewLabel_11.setBounds(188, 210, 158, 27);
		contentPane1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(" ");
		lblNewLabel_12.setBounds(188, 263, 156, 27);
		contentPane1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_9_1 = new JLabel(" ");
		lblNewLabel_9_1.setBounds(188, 156, 177, 21);
		contentPane1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_11_1 = new JLabel(" ");
		lblNewLabel_11_1.setBounds(188, 98, 158, 27);
		contentPane1.add(lblNewLabel_11_1);
	}
}