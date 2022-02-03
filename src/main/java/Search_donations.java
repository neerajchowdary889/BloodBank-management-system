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
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Search_donations extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static FileInputStream fis;
    private static FileOutputStream fos;
    private static Workbook wb;
    private static Sheet sh;
    private static Cell cell;
    private static Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_donations frame = new Search_donations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public Search_donations() throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("./Booook.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME:-");
		lblNewLabel.setBounds(17, 38, 106, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(159, 33, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Appointed Date and Time");
		lblNewLabel_1.setBounds(135, 92, 170, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DATE:-");
		lblNewLabel_2.setBounds(17, 140, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TIME:-");
		lblNewLabel_3.setBounds(17, 186, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               String r1 = textField.getText();
				
				
				int noOfRows=sh.getLastRowNum();
				
				
				for(int i=1;i<=noOfRows;i++) {
					
        			Cell q1 = sh.getRow(i).getCell(0);
        			String a1 = q1.toString(); 
        			if(a1.equals(r1)){
                   	 textField.setText(null);
                   	 Cell b1,b2;
                 		String c1,c2;
                 		
                 		b1 = sh.getRow(i).getCell(2);
                 		b2 = sh.getRow(i).getCell(3);
                 		c1 = b1.toString();
                		c2 = b2.toString();
                		System.out.println(b1);
                		JLabel lblNewLabel_4 = new JLabel(c1);
               		lblNewLabel_4.setBounds(135, 140, 154, 16);
               		contentPane.add(lblNewLabel_4);
               		
               		JLabel lblNewLabel_5 = new JLabel(c2);
               		lblNewLabel_5.setBounds(135, 186, 154, 16);
               		contentPane.add(lblNewLabel_5);
               		
               		setState(Viewprofile.ICONIFIED);
   					 setState(Viewprofile.NORMAL);
   				
                  	 break;
           			
   				}
        			else if(r1.equals("")) {
          				JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
          				break;
          			}
        			
	               }
				
				}
		});
		btnNewButton.setBounds(307, 237, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(6, 6, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}