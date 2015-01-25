package Utils;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ConnectionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpis = new JLabel();

	/**
	 * Create the dialog.
	 */
	public ConnectionDialog() {
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 306, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(10, 5));
		{
			contentPanel.add(lblOpis);
		}
		{
			JProgressBar progressBar = new JProgressBar();
			progressBar.setIndeterminate(true);
			contentPanel.add(progressBar, BorderLayout.SOUTH);
		}
		{
			JLabel labelIcon = new JLabel("");
			labelIcon.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
			contentPanel.add(labelIcon, BorderLayout.WEST);
		}
	}

	public void setLabelText(String text) {
		lblOpis.setText(text);
	}

	public static void doInBackground(String message,
			final Callable<Void> callable) {
		final ConnectionDialog d = new ConnectionDialog();
		d.setLabelText(message);
		d.pack();
		d.setModal(true);
		d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		SwingWorker<Object, Object> t = new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				try{
				callable.call();
				}
				catch
				( Exception ex ){
					ex.printStackTrace();
				}
				return null;
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				super.done();
				d.setVisible(false);
				d.dispose();
			}
		};
		t.execute();
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}
}
