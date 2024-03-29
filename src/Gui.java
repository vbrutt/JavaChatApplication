
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Gui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel dataPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JButton sendButton = new JButton("Send");
	private JPanel labelPanel = new JPanel();
	private JTextField inputText = new JTextField();

	private JTextField userMessage = new JTextField(inputText.getText().length());
	private JPanel messagePanel = new JPanel();

	public Gui() {
		createClientWindow();
		setPanels();
		setLayout(new BorderLayout());
		add(dataPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
	}

	private void createClientWindow() {
		JLabel userName = new JLabel("Enter username: ");
		String userInput = JOptionPane.showInputDialog(null, userName, "", JOptionPane.INFORMATION_MESSAGE);
		// TODO Fehlermeldung bei keiner Eingabe
		// TODO iport in eingabefeld nach user name
		int port = 0;
		Client client = new Client(userInput, port);

	}

	private void setPanels() {
		labelPanel.setLayout(new GridLayout(1, 1));
		labelPanel.setBorder(new EmptyBorder(0, 0, 0, 3));
		labelPanel.add(inputText);

		sendButton.addActionListener(x -> sendMessage());

		inputPanel.setLayout(new BorderLayout());
		inputPanel.setBorder(new EmptyBorder(0, 5, 4, 5));
		inputPanel.add(labelPanel, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.EAST);

		messagePanel.add(userMessage);

		dataPanel.setLayout(new GridLayout(1, 2));
		dataPanel.add(messagePanel);
		messagePanel.setVisible(false);

	}

	private void sendMessage() {

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame frame = new JFrame("Chat");
			frame.setSize(700, 800);
			Gui gui = new Gui();
			frame.add(gui);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.getRootPane().setDefaultButton(gui.sendButton);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}