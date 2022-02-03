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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Change_password extends JFrame {
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_password frame = new Change_password();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Change_password() {
		final Cell r1;
		final Cell r2;
		r1 = sh.getRow(1).getCell(0);
		r2 = sh.getRow(1).getCell(1);
		
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username\r\n");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setBounds(101, 78, 157, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(314, 78, 157, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Current Password");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(101, 141, 157, 22);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(314, 141, 157, 22);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(101, 203, 157, 22);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(314, 203, 157, 22);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Chanage Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String s1 = textField.getText();
    			String s2 = textField_1.getText();
    			String s4 = textField_2.getText();
    			int noOfRows=sh.getLastRowNum();
        		for(int i=1;i<=noOfRows;i++) {
        			Cell a1 = sh.getRow(i).getCell(0);
        			Cell a2 = sh.getRow(i).getCell(1);
        			
        			String b1 = a1.toString();
        			String b2 = a2.toString();
        			
        			
        			
        		 if(!b1.equals(s1) || !b2.equals(s2)) {
	                	continue;}
	              else if(b1.equals(s1) && b2.equals(s2)){
	            	
                	 }

        			row = sh.createRow(i);
        			cell = row.createCell(0);
        			cell.setCellValue(s1);	
        			cell = row.createCell(1);
        			cell.setCellValue(s4);
        			
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
        		
    			JOptionPane.showMessageDialog(null,"          PASSWORD CHANGED SUCCESSFULLY LOGIN AGAIN       ","CHANGE PASSWORD", JOptionPane.INFORMATION_MESSAGE);
    			textField.setText(null);
    			textField_1.setText(null);
    			textField_2.setText(null);
    			Login1.main(null);
    			dispose();
    			
        		}}
		});
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 17));
		btnNewButton.setBounds(180, 290, 180, 29);
		contentPane.add(btnNewButton);
	}
}