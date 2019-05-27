package de.application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Gui extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel dataPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JButton sendButton = new JButton("Send");
	private JPanel labelPanel = new JPanel();
	private JTextField inputText = new JTextField();

	private String message;

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
	}

	private void sendMessage() {
		// TODO: isBlank()
//		if (!(inputText.getText().isBlank())) {
//			message = inputText.getText();
//		}
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("You just pressed the enter ");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}