import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gui extends JPanel {
	private JPanel chatPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JButton sendButton = new JButton("Send");
	private JTextField inputArea = new JTextField(50);

	public Gui() {
		setPanels();
		setLayout(new BorderLayout());
		add(chatPanel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.PAGE_END);

	}

	private void setPanels() {
		JPanel input = new JPanel();

		input.setLayout(new BorderLayout());
		input.add(inputArea, BorderLayout.CENTER);
		input.add(sendButton, BorderLayout.LINE_END);

		inputPanel.add(input);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Chat");
		frame.setSize(900, 800);
		Gui gui = new Gui();
		frame.add(gui);
		frame.setVisible(true);
	}

}
