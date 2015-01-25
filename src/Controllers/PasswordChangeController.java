/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Utils.ConnectionDialog;
import Utils.DataBaseConnector;
import Views.ZmianaHasla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Radosław
 */
public class PasswordChangeController {
    
    private ZmianaHasla view;
    private String login;
    private String aktHaslo;
    private String noweHaslo;
    private String powtNoweHaslo;
    private Connection connection;
    private Boolean czyHaslaSaTakieSame;
    
    public PasswordChangeController(ZmianaHasla view, String login) {
        this.view = view;
        this.login = login;
        view.addZapiszListener(new AkcjaZmianaHasla());
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }
    
    private void pobierzDane() {
        this.aktHaslo = view.getAktPassword();
        this.noweHaslo = view.getNowePassword();
        this.powtNoweHaslo = view.getPowtNowePassword();
        czyHaslaSaTakieSame = noweHaslo.equals(powtNoweHaslo);
    }
    
    class AkcjaZmianaHasla implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pobierzDane();
            ConnectionDialog.doInBackground("Autoryzacja", new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    DataBaseConnector conn = DataBaseConnector.getInstance();
                    conn.setUser(login, aktHaslo);
                    connection = null;
                    try {
                        conn.getAccess();
                        conn.Connect();
                        connection = conn.getConnection();
                    } catch (SQLException exc) {
                        System.out.print(exc);
                    }
                    return null;
                }
                
            });
            if(DataBaseConnector.getInstance().getPrivileges() != -1) {
                if(!czyHaslaSaTakieSame){
                    JOptionPane.showMessageDialog(view, "Podane nowe hasła są różne!");
                }else {
                    zmienHaslo(login, noweHaslo);
                    JOptionPane.showMessageDialog(view, "Zmieniono.");
                    view.dispose();
                }
            }
            else
                JOptionPane.showMessageDialog(view, "Aktualne hasło jest nieprawidłowe!");
        }
        
        private void zmienHaslo(String login, String haslo){
			CallableStatement statement = null;
			try {
				statement = DataBaseConnector.getInstance().getConnection()
						.prepareCall("{?= call user_zmien_haslo(?,?) }");

				statement.setString(2, login);
                                statement.setString(3, haslo);
                                statement.registerOutParameter(1, Types.INTEGER);
				statement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
					DataBaseConnector.getInstance().getConnection().commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    }
    
}
