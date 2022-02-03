import java.util.Scanner;
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
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class username extends JFrame {
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

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("Sheet1");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					username frame = new username();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public username() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(35, 68, 152, 55);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(197, 68, 258, 55);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(35, 194, 129, 37);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(197, 181, 258, 55);
		contentPane.add(passwordField);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q1 = textField.getText();
				String q2 = passwordField.getText();
				int noOfRows = sh.getLastRowNum();
				boolean k =true;
				for(int j =1; j<=noOfRows;j++) {
					Cell c1 = sh.getRow(j).getCell(0);
					String b1 = c1.toString();
					
				if (b1.equals(q1)) {
					textField.setText(null);
					passwordField.setText(null);
					JOptionPane.showMessageDialog(null, "            Username already exsits        ", "ERROR",JOptionPane.ERROR_MESSAGE);
					k = false;
					break;
					 
					
				}
				}
			while(k) {
				for (int i = 1; i <= noOfRows; i++) {
					
					Cell r1 = sh.getRow(i).getCell(0);
					String a1 = r1.toString();
					if (q1.equals("") || q2.equals("")) {
						textField.setText(null);
						passwordField.setText(null);
						JOptionPane.showMessageDialog(null, "           Fill all Details       ", "ERROR",JOptionPane.ERROR_MESSAGE);
						k=false;
						break;
						}
						
					 
					else if (!a1.equals(q1)) {

						int noOfRows1 = sh.getLastRowNum();
						row = sh.createRow(noOfRows1 + 1);
						cell = row.createCell(0);
						cell.setCellValue(q1);
						cell = row.createCell(1);
						cell.setCellValue(q2);

						// System.out.println(cell.getStringCellValue());
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
						Login1.main(null);
						dispose();
						JOptionPane.showMessageDialog(null, "Your profile has been saved", "",JOptionPane.INFORMATION_MESSAGE);
						k=false;
						break;
					}					
					}
				}			
			}});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBounds(163, 261, 170, 37);
		contentPane.add(btnNewButton_1);
	}
}