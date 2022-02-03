import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Donate_Blood extends JFrame {

	private JPanel contentPane;
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	
	private final JList list = new JList();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donate_Blood frame = new Donate_Blood();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Donate_Blood() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(228, 164, 139, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 195, 139, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 76, 139, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 114, 139, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Enter Date (dd-mm-yyyy)");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblNewLabel.setBounds(196, 30, 228, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Book Slot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String t3 = textField_2.getText();
				String t4 = textField_3.getText();
				String t1 = textField.getText();
				String t2 = textField_1.getText();

				
				int noOfRows=sh.getLastRowNum();
				int j = 1;
				for(int i=1;i<=noOfRows;i++) {
					j = i;
        			Cell r1 = sh.getRow(i).getCell(0);
        			Cell r2 = sh.getRow(i).getCell(1);
        			
        			String a1 = r1.toString();
        			String a2 = r2.toString();
        			
        			if(a1.equals(t3)&& a2.equals(t4)){   
      	              
	                 	
      	              
             			row = sh.createRow(i);
             			cell = row.createCell(0);
             			cell.setCellValue(t3);
             			cell = row.createCell(1);
             			cell.setCellValue(t4);
             			cell = row.createCell(2);
             			cell.setCellValue(t1);	
             			cell = row.createCell(3);
             			cell.setCellValue(t2);
             			cell = row.createCell(4);
             			
    						
    				
    				try {
    					fos = new FileOutputStream("./Booook.xlsx");
    				} catch (FileNotFoundException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    					try {
    						wb.write(fos);
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					try {
    						fos.flush();
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					try {
    						fos.close();
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					slotbook.main(null);
    					dispose();

    				 break;
    			}
        			else if(t1.equals("") || t2.equals("") || t3.equals("") || t4.equals("")){
        				textField.setText(null);
                        textField_1.setText(null);
                        textField_2.setText(null);
                        textField_3.setText(null);
                        
  	            	  JOptionPane.showMessageDialog(null,"          INVALID DETAILS      ","ERROR",JOptionPane.ERROR_MESSAGE);
  	              break;
  	        	}
        			
        			 
	              
        			 
				}
				Cell c1 = sh.getRow(j).getCell(0);
    			Cell c2 = sh.getRow(j).getCell(1);
    			String b1 = c1.toString();
    			String b2 = c2.toString();
				if(!b1.equals(t3) && !b2.equals(t4)) {
    				textField.setText(null);
                    textField_1.setText(null);
                    textField_2.setText(null);
                    textField_3.setText(null);
                    
	            	  JOptionPane.showMessageDialog(null,"          INVALID DETAILS      ","ERROR",JOptionPane.ERROR_MESSAGE);
	            
                	}}});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBounds(228, 248, 174, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<< Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER A DATE:-");
		lblNewLabel_1.setBounds(33, 169, 145, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER A TIME:-");
		lblNewLabel_2.setBounds(33, 200, 152, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("USERNAME:-");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(33, 80, 89, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD:-");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 121, 111, 16);
		contentPane.add(lblNewLabel_4);
		
	}
}