package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Logowanie extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
        private JButton btnZaloguj;
        private JLabel lblNiepoprawneHaslo;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logowanie frame = new Logowanie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Logowanie() {
		setTitle("Okno logowania");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProszOPodanie = new JLabel("Prosz\u0119 o podanie swoich danych dost\u0119powych:");
		lblProszOPodanie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProszOPodanie.setBounds(58, 25, 259, 14);
		contentPane.add(lblProszOPodanie);
		
		loginField = new JTextField();
		loginField.setBounds(140, 50, 86, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 81, 86, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("U\u017Cytkownik:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(35, 53, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHaso.setBounds(45, 84, 90, 14);
		contentPane.add(lblHaso);
		
		btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.setBounds(58, 136, 110, 23);
		contentPane.add(btnZaloguj);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				dispose();
				
			}
		});
		btnAnuluj.setBounds(191, 136, 110, 23);
		contentPane.add(btnAnuluj);
		
		lblNiepoprawneHaslo = new JLabel("");
		lblNiepoprawneHaslo.setBounds(255, 69, 46, 14);
		contentPane.add(lblNiepoprawneHaslo);
	}
        
    public String getLogin(){
    	return loginField.getText();
    }
    
    public String getPassword() {
        String password = "";
        char[] pass = passwordField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    public void SetBlednyLogin(){
    	JOptionPane.showMessageDialog(rootPane, "Podane dane logowania są nieprawidłowe!");
        lblNiepoprawneHaslo.setVisible(true);
    }
    
    public void addZalogujListener(ActionListener l){
    	btnZaloguj.addActionListener(l);
    }
    
    public void clearLoggingData() {
        loginField.setText(null);
        passwordField.setText(null);
    }
}
