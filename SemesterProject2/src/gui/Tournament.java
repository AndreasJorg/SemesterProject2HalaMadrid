package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tournament extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TournamentNameText;
	private JTextField StartdatoText;
	private JTextField SlutdatoText;
	private JTextField AntalDeltagerTextFelt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tournament frame = new Tournament();
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
	public Tournament() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel OpretTournamentLabel = new JLabel("Opret Tournering");
		OpretTournamentLabel.setBounds(26, 29, 106, 14);
		contentPane.add(OpretTournamentLabel);
		
		TournamentNameText = new JTextField();
		TournamentNameText.setBounds(46, 54, 86, 20);
		contentPane.add(TournamentNameText);
		TournamentNameText.setColumns(10);
		
		JLabel StartDatoText = new JLabel("Startdato");
		StartDatoText.setBounds(26, 85, 56, 14);
		contentPane.add(StartDatoText);
		
		StartdatoText = new JTextField();
		StartdatoText.setBounds(46, 106, 86, 20);
		contentPane.add(StartdatoText);
		StartdatoText.setColumns(10);
		
		JLabel SlutDatoLabel = new JLabel("Slutdato");
		SlutDatoLabel.setBounds(149, 85, 63, 14);
		contentPane.add(SlutDatoLabel);
		
		SlutdatoText = new JTextField();
		SlutdatoText.setBounds(159, 106, 86, 20);
		contentPane.add(SlutdatoText);
		SlutdatoText.setColumns(10);
		
		JLabel AntalDeltagerLabel = new JLabel("Antal Deltager ");
		AntalDeltagerLabel.setBounds(26, 151, 72, 14);
		contentPane.add(AntalDeltagerLabel);
		
		AntalDeltagerTextFelt = new JTextField();
		AntalDeltagerTextFelt.setBounds(46, 172, 86, 20);
		contentPane.add(AntalDeltagerTextFelt);
		AntalDeltagerTextFelt.setColumns(10);
		
		JButton OpretBTN = new JButton("Opret");
		OpretBTN.setBounds(211, 227, 89, 23);
		contentPane.add(OpretBTN);
		
		JButton CancelBTN = new JButton("Cancel");
		CancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		CancelBTN.setBounds(314, 227, 89, 23);
		contentPane.add(CancelBTN);

	}
}
