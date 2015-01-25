package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import Utils.ConnectionDialog;
import Utils.DataBaseConnector;
import Views.Logowanie;
import Views.Menu;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LogController {

    Logowanie view;
    Connection connection;
    Menu m = new Menu();
    
    public static void main(String args[]) {
        Logowanie log = new Logowanie();
        LogController cLog = new LogController(log);
    }

    public LogController(Logowanie view) {
        this.view = view;
        view.addZalogujListener(new AkcjaLoguj());
        view.setVisible(true);
        m.setLogView(view);
    }

    class AkcjaLoguj implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            final String login = view.getLogin();
            final String password = view.getPassword();
            ConnectionDialog.doInBackground("Trwa Sprawdzanie Uprawnie�", new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    DataBaseConnector conn = DataBaseConnector.getInstance();
                    conn.setUser(login, password);
                    connection = null;
                    try {
                        conn.getAccess();
                        System.out.println("Uzytkownik to " + conn.getPrivileges());
                        conn.Connect();
                        connection = conn.getConnection();
                    } catch (SQLException exc) {
                        System.out.print(exc);
                    }
                    return null;
                }
            });
            m.setLoginAsLabel(login);
            m.UstawMenu(DataBaseConnector.getInstance().getPrivileges());
            switch (DataBaseConnector.getInstance().getPrivileges()) {
                case 1:                    
                    m.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    m.setVisible(true);
                    //  m.lblStan.setText("Zalogowany");
                    //view.setVisible(false);
                    view.dispose();
                    
                    break;
                    
                case 2:
                    m.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    m.setVisible(true);
                  
                  //  m.lblStan.setText("Zalogowany");
                    //view.setVisible(false);
                    view.dispose();
                    break;

                default:
                    view.SetBlednyLogin();

            }
        }
    }

}
