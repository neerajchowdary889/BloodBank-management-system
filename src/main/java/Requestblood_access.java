import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class Requestblood_access extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requestblood_access frame = new Requestblood_access();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Requestblood_access() throws EncryptedDocumentException, IOException {
		
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME ");
		lblNewLabel.setBounds(31, 59, 121, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(31, 101, 121, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(242, 54, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(242, 96, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("REQUIRED BLOOD GROUP");
		lblNewLabel_2.setBounds(31, 170, 178, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(242, 165, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("REQUEST BLOOD");
		lblNewLabel_3.setBounds(165, 6, 121, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("NEXT>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();
				String t2 = textField_1.getText();
				String t3 = textField_2.getText();
			
				int noOfRows=sh.getLastRowNum();
				int j = 1;
				for(int i=1;i<=noOfRows;i++) {
					j=i;
        			Cell r1 = sh.getRow(i).getCell(0);
        			Cell r2 = sh.getRow(i).getCell(1);
        			Cell r3 = sh.getRow(i).getCell(2);
        			Cell r4 = sh.getRow(i).getCell(3);
        			
        			String a1 = r1.toString();
        			String a2 = r2.toString();
        			String a3 = r3.toString();
        			String a4 = r4.toString();
        			if(a1.equals(t1)&& a2.equals(t2)){   
      	              
	                 	
      	              
             			row = sh.createRow(i);
             			cell = row.createCell(0);
             			cell.setCellValue(t1);
             			cell = row.createCell(1);
             			cell.setCellValue(t2);
             			cell = row.createCell(2);
             			cell.setCellValue(a3);
             			cell = row.createCell(3);
             			cell.setCellValue(a4);
             			cell = row.createCell(4);
             			cell.setCellValue(t3);
             			
             			try {
    						fos = new FileOutputStream("./Booook.xlsx");
    					} catch (FileNotFoundException e1) {
    						
    						e1.printStackTrace();
    					}
             			try {
    						wb.write(fos);
    					} catch (IOException e1) {
    						
    						e1.printStackTrace();
    					}
             			try {
    						fos.flush();
    					} catch (IOException e1) {
    						
    						e1.printStackTrace();
    					}
             			try {
    						fos.close();
    					} catch (IOException e1) {
    					
    						e1.printStackTrace();
    					}
             			Request_Blood.main(null);
             			dispose();
             			break;
    	              }
        			else if(!a1.equals(t1) || !a2.equals(t2)) {
        				continue;
	                	}
        			 else if(t1.equals("") || t2.equals("") || t3.equals("")) {
        				 textField.setText(null);
        				 textField_1.setText(null);
        				 textField_2.setText(null);
        				 JOptionPane.showMessageDialog(null, "          INVALID DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
  						break;
        			 }
	         
        			
        			 
          			
         			
			}
				Cell c1 = sh.getRow(j).getCell(0);
    			Cell c2 = sh.getRow(j).getCell(1);
    			String b1 = c1.toString();
    			String b2 = c2.toString();
    			if(!b1.equals(t1) && !b2.equals(t2)) {
    				textField.setText(null);
   				 textField_1.setText(null);
   				 textField_2.setText(null);
   				 JOptionPane.showMessageDialog(null, "          INVALID DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						
                	}
    			
		}});
		btnNewButton.setBounds(337, 228, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mainframe.main(null);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(6, 1, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}