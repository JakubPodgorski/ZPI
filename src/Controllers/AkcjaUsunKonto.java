/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Utils.DataBaseConnector;
import Views.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author Radosław
 */
public class AkcjaUsunKonto implements ActionListener {
    
    private Menu view;
    
    public AkcjaUsunKonto(Menu view) {
        this.view = view;
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            int decyzja = JOptionPane.showConfirmDialog(view, "Czy napewno chcesz usunąć konto?");
            if(decyzja == 0) {
                if(DataBaseConnector.getInstance().getPrivileges() != -1) {
                
                    usunKonto(view.getLogin());
                    JOptionPane.showMessageDialog(view, "Usunięto.");
                    view.Logowanie();
                    view.dispose();
                }
            }
            }
            
        
    
    private void usunKonto(String login){
			CallableStatement statement = null;
			try {
				statement = DataBaseConnector.getInstance().getConnection()
						.prepareCall("{?= call user_delete(?) }");

				statement.setString(2, login);
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
    

