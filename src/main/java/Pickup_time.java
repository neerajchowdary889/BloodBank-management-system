import java.awt.BorderLayout;
import java.awt.EventQueue;

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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pickup_time extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
					Pickup_time frame = new Pickup_time();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Pickup_time() throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER RECEIVED TIME");
		lblNewLabel.setBounds(138, 6, 228, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:-");
		lblNewLabel_1.setBounds(19, 62, 95, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(152, 57, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DATE &TIME:-");
		lblNewLabel_2.setBounds(19, 137, 95, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 132, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();
				String t2 = textField_1.getText();
				int noOfRows=sh.getLastRowNum();
				int j =1;
				for(int i=1;i<=noOfRows;i++) {
					j=i;
        			Cell r1 = sh.getRow(i).getCell(0);
        			Cell r2 = sh.getRow(i).getCell(1);
        			Cell r3 = sh.getRow(i).getCell(2);
        			Cell r4 = sh.getRow(i).getCell(3);
        			Cell r5 = sh.getRow(i).getCell(4);
        			String a1 = r1.toString();
        			String a2 = r2.toString();
        			String a3 = r3.toString();
        			String a4 = r4.toString();
        			String a5 = r5.toString();
        			
        			if(a1.equals(t1)){   
      	              
	                 	
      	              
             			row = sh.createRow(i);
             			cell = row.createCell(0);
             			cell.setCellValue(t1);
             			cell = row.createCell(1);
             			cell.setCellValue(a2);
             			cell = row.createCell(2);
             			cell.setCellValue(a3);
             			cell = row.createCell(3);
             			cell.setCellValue(a4);
             			cell = row.createCell(4);
             			cell.setCellValue(a5);
             			cell = row.createCell(5);
             			cell.setCellValue(t2);
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
             			JOptionPane.showMessageDialog(null,"            ENTERED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
             			textField.setText(null);
       				   textField_1.setText(null);
             			break;
    	              }
        			
        			 else if(t1.equals("") || t2.equals("") ) {
        				 textField.setText(null);
        				 textField_1.setText(null);
        				
        				 JOptionPane.showMessageDialog(null, "           INVALID DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
  						break;
        			 }
	          
				
			}
				Cell c1 = sh.getRow(j).getCell(0);
				String b1 = c1.toString();
				if(!b1.equals(t1)) {
   				 JOptionPane.showMessageDialog(null, "           INVALID DETAILS      ", "ERROR",JOptionPane.ERROR_MESSAGE);
				
               	}
			}});
		btnNewButton.setBounds(327, 237, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(-3, 1, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("EX:-13JAN 12:30");
		lblNewLabel_3.setBounds(152, 170, 159, 16);
		contentPane.add(lblNewLabel_3);
	}
}