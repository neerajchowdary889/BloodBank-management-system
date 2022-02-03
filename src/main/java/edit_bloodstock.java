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

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class edit_bloodstock extends JFrame {

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
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JButton btnNewButton;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JLabel label;
    private JLabel label_1;
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet3");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit_bloodstock frame = new edit_bloodstock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public edit_bloodstock() {
		
		final Cell r1;
		final Cell r2;
		final Cell r3;
		final Cell r4;
		final Cell r5;
		final Cell r6;
		final Cell r7;
		final Cell r8;
		
	
		r1 = sh.getRow(1).getCell(0);
		r2 = sh.getRow(1).getCell(1);
		r3 = sh.getRow(1).getCell(2);
		r4 = sh.getRow(1).getCell(3);
		r5 = sh.getRow(1).getCell(4);
		r6 = sh.getRow(1).getCell(5);
		r7 = sh.getRow(1).getCell(6);
		r8 = sh.getRow(1).getCell(7);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnNewButton_8 = new JButton("<<BACK");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bloodstock.main(null);
				} catch (EncryptedDocumentException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(btnNewButton_8);
		
		label = new JLabel("");
		contentPane.add(label);
		
		label_1 = new JLabel("");
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("        A+");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("EDIT ");
		btnNewButton_1.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				String q1 = textField.getText();
				while(true) {
					
					if(q1.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q1.equals("")){
				cell = r1;
				cell.setCellValue(q1);
			
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField.setText(null);
            	break;
			}
				}}});
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("EDIT ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q2 = textField_1.getText();
               while(true) {
					
					if(q2.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q2.equals("")){
				cell = r2;
				cell.setCellValue(q2);
						
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_1.setText(null);
            	break;
			}
               }}});
		
		JLabel lblNewLabel_2 = new JLabel("        B+");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("EDIT ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q3 = textField_2.getText();
                  while(true) {
					
					if(q3.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q3.equals("")){
				cell = r3;
				cell.setCellValue(q3);
						
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_2.setText(null);
            	break;
			}
                  }}	});
		
		JLabel lblNewLabel_1 = new JLabel("        O+");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("EDIT ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q4 = textField_3.getText();
                 while(true) {
					
					if(q4.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q4.equals("")){
				cell = r4;
				cell.setCellValue(q4);
						
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_3.setText(null);
            	break;
			}
                 }}});
		
		JLabel lblNewLabel_3 = new JLabel("       AB+");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("EDIT ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q5 = textField_4.getText();
                  while(true) {
					
					if(q5.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q5.equals("")){
				cell = r5;
				cell.setCellValue(q5);
						
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_4.setText(null);
            	break;
			}
                  }}});
		
		JLabel lblNewLabel_4 = new JLabel("        A-");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("EDIT ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q6 = textField_5.getText();
                   while(true) {
					
					if(q6.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q6.equals("")){
				cell = r6;
				cell.setCellValue(q6);
						
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_5.setText(null);
            	break;
			}
                   }}	});
		
		JLabel lblNewLabel_6 = new JLabel("        B-");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("EDIT ");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q7 = textField_6.getText();
                    while(true) {
					
					if(q7.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q7.equals("")){
				cell = r7;
				cell.setCellValue(q7);
						
				
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_6.setText(null);
            	break;
				
			}
}}});
		
		JLabel lblNewLabel_5 = new JLabel("        O-");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("EDIT ");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q8 = textField_7.getText();
                   while(true) {
					
					if(q8.equals("")) {
						JOptionPane.showMessageDialog(null, "            FILL THE DETAILS     ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					else if(!q8.equals("")){
				cell = r8;
				cell.setCellValue(q8);
						
				
				try {
					fos = new FileOutputStream("./Booook.xlsx");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
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
				JOptionPane.showMessageDialog(null,"            EDITED SUCCESSFULLY     ","",JOptionPane.INFORMATION_MESSAGE);
            	textField_7.setText(null);
            	break;
			}
                   }}});
		
		JLabel lblNewLabel_7 = new JLabel("       AB-");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		contentPane.add(btnNewButton_7);
	}

}