import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.EncryptedDocumentException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("./admin.png"));
		lblNewLabel_1.setBounds(6, 86, 287, 287);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(153, 153, 51));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(318, 0, 160, 79);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<< LogOut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login1.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(633, 442, 122, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Search Profile");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewprofile.main(null);
				dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnNewButton_3.setForeground(new Color(70, 130, 180));
		btnNewButton_3.setBounds(444, 150, 230, 52);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Blood Stock");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setForeground(new Color(255, 0, 0));
		btnNewButton_4.setBackground(new Color(245, 255, 250));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_4.setBounds(444, 86, 230, 52);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("SEARCH DONATIONS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_donations.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(444, 217, 226, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH REQUESTS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_requests.main(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(444, 286, 230, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("ENTER RECIVED TIME");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pickup_time.main(null);
				dispose();
			}
		});
		btnNewButton_5.setBounds(444, 350, 226, 52);
		contentPane.add(btnNewButton_5);
	}

}