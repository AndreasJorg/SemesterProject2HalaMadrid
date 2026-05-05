
package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
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
	public StartMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nørresundby TennisKlub");
		lblNewLabel.setBounds(5, 5, 163, 13);
		contentPane.add(lblNewLabel);
		
		JButton TennisBookBaneBTN = new JButton("Tennis");
		TennisBookBaneBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaneBooking booking = new BaneBooking();
				booking.setLocationRelativeTo(null);
				booking.setVisible(true); 
			
				StartMenu.this.dispose(); 
			}
				
		});
		TennisBookBaneBTN.setBounds(126, 71, 84, 21);
		contentPane.add(TennisBookBaneBTN);
		

		
		JLabel JLabelTextFelt = new JLabel("Book bane");
		JLabelTextFelt.setBounds(185, 36, 65, 26);
		contentPane.add(JLabelTextFelt);
		

		


	}
	}
