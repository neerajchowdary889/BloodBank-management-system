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

public class Search_requests extends JFrame {

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
					Search_requests frame = new Search_requests();
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
	public Search_requests() throws EncryptedDocumentException, IOException {
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
		lblNewLabel.setBounds(19, 41, 141, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REQUESTED BLOOD GROUP");
		lblNewLabel_1.setBounds(136, 96, 241, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BLOOD GROUP:-");
		lblNewLabel_2.setBounds(19, 142, 117, 16);
		contentPane.add(lblNewLabel_2);
		
		
		
		textField = new JTextField();
		textField.setBounds(136, 36, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("<<Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(6, 0, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String r1 = textField.getText();
					
					
					int noOfRows=sh.getLastRowNum();
					
					for(int i=1;i<=noOfRows;i++) {
						
	        			Cell q1 = sh.getRow(i).getCell(0);
	        			String a1 = q1.toString(); 
	        			if(a1.equals(r1)){
	              			Cell b1 = sh.getRow(i).getCell(4);
	              			String c1 = b1.toString();
		              		JLabel lblNewLabel_3 = new JLabel(c1);
		            		lblNewLabel_3.setBounds(224, 142, 125, 16);
		            		contentPane.add(lblNewLabel_3);
		            		setState(Viewprofile.ICONIFIED);
							 setState(Viewprofile.NORMAL);
		            		break;
	              			}
	        			else if(!a1.equals(r1)) {
              				continue;
              			}
	        			
	        			else if(r1.equals("")) {
              				JOptionPane.showMessageDialog(null,"           Enter ALL Details      ","ERROR",JOptionPane.ERROR_MESSAGE);
              				break;
              			}
              			
              			
				
			}
					
					
			}});
		btnNewButton_1.setBounds(327, 243, 117, 29);
		contentPane.add(btnNewButton_1);
}

}