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

public class Login1 extends JFrame {
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
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login1() throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("Sheet1");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(36, 74, 73, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(36, 128, 73, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					newuser.main(null);
				} catch (EncryptedDocumentException e1) {

					e1.printStackTrace();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setBounds(63, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Serif", Font.PLAIN, 13));
		textField.setBounds(159, 71, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		String t1 = textField.getText();

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(Color.WHITE);
		passwordField.setFont(new Font("Serif", Font.PLAIN, 13));
		passwordField.setBounds(159, 140, 176, 20);
		contentPane.add(passwordField);
		String t2 = passwordField.getText();

		JButton btnNewButton_1 = new JButton("Login");		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();
				String t2 = passwordField.getText();
				int noOfRows = sh.getLastRowNum();
				
				
				int j = 1;
				
				for (int i = 1; i <= noOfRows; i++) {
					j = i;
					Cell r1 = sh.getRow(i).getCell(0);
					Cell r2 = sh.getRow(i).getCell(1);
					String a1 = r1.toString();
					String a2 = r2.toString();
					if (a1.equals(t1) && a2.equals(t2)) {
						textField.setText(null);
						passwordField.setText(null);
						Mainframe.main(null);
						dispose();
						break;
					} 
					else if (!a1.equals(t1) || !a2.equals(t2)) {
						continue;
					}
					
					else if (t1.equals("") || t2.equals("")) {
						JOptionPane.showMessageDialog(null, "           INVALID LOGIN    ", "ERROR",JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
						break;
						}
				
				}
				Cell c1 = sh.getRow(j).getCell(0);
				Cell c2 = sh.getRow(j).getCell(1);
				String b1 = c1.toString();
				String b2 = c2.toString();
				if (t1.equals("ADMIN") && t2.equals("ADMIN")) {
					Admin.main(null);
					dispose();
			
				}
				
				else if (!b1.equals(t1) && !b2.equals(t2)) {
					JOptionPane.showMessageDialog(null, "            INVALID LOGIN    ", "ERROR",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
					
				}
				 
			}
		});
		btnNewButton_1.setBounds(246, 191, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(191, 0, 66, 49);
		contentPane.add(lblNewLabel_2);

	
	}
}