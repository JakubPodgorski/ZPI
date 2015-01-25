package Utils;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

public class DataBaseConnector {
	private static DataBaseConnector SingletonInstance = null;

	private static final String dbUsername = "test";
	private static final String dbPassword = "test";
	private enum Privileges {
		admin(1, dbUsername, dbPassword), worker(2, dbUsername, dbPassword), forbidden(-1, "", "");

		Privileges(int accessLevel, String login, String password) {
			this.accessLevel = accessLevel;
			this.login = login;
			this.password = password;
		}

		public int accessLevel;
		public String login;
		public String password;

	}

	private static Privileges privs = Privileges.forbidden;
	private static String username;
	private static String password;
	private static Connection connection = null;
	private static String db_host = "localhost";
	private static String port = "1521";
	private static String dbaLogin = "test";
	private static String dbaPassword = "test";
	private static int idPrac = -1;
	private static int idUser = -1;
	private static int idMag = -1;
	public static int getIdPrac() {
		return idPrac;
	}

	public static int getIdUser(){
		return idUser;
	}
	
	public static int getIdMag(){
		return idMag;
	}
	
	protected DataBaseConnector() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	};

	public static DataBaseConnector getInstance() {
		if (SingletonInstance == null)
			return new DataBaseConnector();
		return SingletonInstance;
	}

	public void setUser(String login, String password) {
		DataBaseConnector.username = login;
		DataBaseConnector.password = password;
		DataBaseConnector.privs = Privileges.forbidden;
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		connection = null;
	}

	public Privileges getAccess() throws SQLException {
		Connection checkAccess = null;
		CallableStatement statement = null;
		try {
			checkAccess = DriverManager.getConnection("jdbc:oracle:thin:@"
					+ db_host + ":" + port + ":XE", Privileges.admin.login,
					Privileges.admin.password);
			statement = checkAccess
					.prepareCall("{?= call user_zaloguj(?,?)}");
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setString(2, username);
			statement.setString(3, password);
			statement.execute();
			Integer privs = ((OracleCallableStatement) statement).getInt(1);
			//System.out.print(privs);
			if (privs.equals(1)) {
				DataBaseConnector.privs = Privileges.admin;
				dbaLogin = DataBaseConnector.privs.login;
				dbaPassword = DataBaseConnector.privs.password;
				//System.out.print("czyli jednak dzia�a");
			}
                        if (privs.equals(2)) {
				DataBaseConnector.privs = Privileges.worker;
				dbaLogin = DataBaseConnector.privs.login;
				dbaPassword = DataBaseConnector.privs.password;
				//System.out.print("czyli jednak dzia�a");
			}
			Logger.getGlobal().info(username);
//			if(DataBaseConnector.privs == Privileges.worker)
//				{
//				statement = checkAccess.prepareCall("{ ? = call utils.get_id_prac(?)}");
//				statement.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
//				statement.setString(2, username);
//				statement.execute();
//				idPrac = statement.getInt(1);				
//				}		
		}  finally {
			if (checkAccess != null)
				checkAccess.close();
			if (statement != null)
				statement.close();
		}
		return DataBaseConnector.privs;
	}

	public void Connect() throws SQLException {
		if (privs == Privileges.forbidden)
			throw new SQLException("Podany uzytkownik nie istnieje!");
		try {
			if (connection != null)
				connection.close();
			connection = DriverManager.getConnection("jdbc:oracle:thin:@"
					+ db_host + ":" + port + ":XE", dbaLogin, dbaPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return;
	}

	public int getPrivileges() {
		return privs.accessLevel;
	}

	public static Connection getConnection() {
		try {
			if (!connection.isValid(0)) {
				ConnectionDialog.doInBackground(
						"Utracono po��czenie, trwa ponowne ��czenie",
						new Callable<Void>() {

							@Override
							public Void call() throws Exception {
								try {
									Logger.getGlobal().info("Utracono Po��czenie");
									while (!DataBaseConnector.connection
											.isValid(1)) {
										try {

											DataBaseConnector.getInstance()
													.Connect();
										} catch (SQLException ev) {
											ev.printStackTrace();
										}
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								return null;
							}
						});
			}
		} catch (SQLException ex) {
		}

		return connection;
	}

	public int getUserId(){
		return idUser;
	}
	
	public void disconnect() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUsername(){
		return DataBaseConnector.username;
	}
	
	public static void setPrivileges(String a){
		if(a=="administrator")
			privs=Privileges.admin;
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

	
}
