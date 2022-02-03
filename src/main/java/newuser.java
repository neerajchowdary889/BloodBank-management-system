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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class newuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Workbook wb;
	private static Sheet sh;
	private static Cell cell;
	private static Row row;
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("Sheet2");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newuser frame = new newuser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public newuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 29, 155, 56);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Date of Birth: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 127, 155, 56);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pincode:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 217, 155, 56);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Blood Group: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 310, 155, 56);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBackground(java.awt.Color.LIGHT_GRAY);
		textField.setForeground(java.awt.Color.BLACK);
		textField.setBounds(214, 33, 312, 56);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(java.awt.Color.LIGHT_GRAY);
		textField_1.setBounds(214, 129, 312, 56);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBackground(java.awt.Color.LIGHT_GRAY);
		textField_2.setBounds(214, 227, 217, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBackground(java.awt.Color.LIGHT_GRAY);
		textField_3.setBounds(214, 318, 217, 44);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("Next >>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
				String s2 = textField_1.getText();
				String s4 = textField_2.getText();
				String s5 = textField_3.getText();

				while (true) {
					if (s1.equals("") || s2.equals("") || s4.equals("") || s5.equals("")) {
						JOptionPane.showMessageDialog(null, "           FILL ALL Details      ", "ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					} else if (true) {
						int noOfRows = sh.getLastRowNum();
						row = sh.createRow(noOfRows + 1);
						cell = row.createCell(0);
						cell.setCellValue(s1);
						cell = row.createCell(1);
						cell.setCellValue(s2);
						cell = row.createCell(2);
						cell.setCellValue(s4);
						cell = row.createCell(3);
						cell.setCellValue(s5);
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

						try {
							username.main(null);
						} catch (EncryptedDocumentException e1) {
							
							e1.printStackTrace();
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						dispose();
						break;
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(530, 400, 97, 39);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<< Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login1.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("dd-mm-yyyy");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		lblNewLabel_5.setBounds(410, 186, 112, 30);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("./add-user-logo-icon-design-can-be-used-as-complement-to-128469951.jpg"));
		lblNewLabel_6.setBounds(0, 0, 627, 436);
		contentPane.add(lblNewLabel_6);
	}

}