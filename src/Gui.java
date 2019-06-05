
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	protected JTextField inputText = new JTextField();

	private JTextField userMessage = new JTextField(inputText.getText().length());
	private JPanel messagePanel = new JPanel();

	public Gui() {
		setPanels();
		setLayout(new BorderLayout());
		add(dataPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
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

	protected void sendMessage() {
		if (!(inputText.getText().isEmpty())) {
			userMessage.setText(inputText.getText());
			Border border = BorderFactory.createLineBorder(Color.BLUE);
			userMessage.setBorder(border);
			messagePanel.setVisible(true);
			inputText.setText("");
			add(dataPanel, BorderLayout.CENTER);
		}
	}

	// public static void main(String[] args) {
	// try {
	// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	// JFrame frame = new JFrame("Chat");
	// frame.setSize(700, 800);
	// Gui gui = new Gui();
	// frame.add(gui);
	// frame.setLocationRelativeTo(null);
	// frame.setVisible(true);
	// frame.getRootPane().setDefaultButton(gui.sendButton);
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// } catch (ClassNotFoundException | InstantiationException |
	// IllegalAccessException
	// | UnsupportedLookAndFeelException e) {
	// e.printStackTrace();
	// }
	// }

}