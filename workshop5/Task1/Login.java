/*
 * Workshop 4 - Task 1 Login
 * Course:JAC444 - Semester 4
 * Last Name: Chai
 * First Name: Wilson
 * ID: 030-918-114
 * Section: DD
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signed by Wilson Chai
 * Date: April 17, 2018
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;

public class Login {

    public static void main(String[] args) {
        final JFrame login = new JFrame("Login");
        JPanel panel = new JPanel();
        final JTextField loginName = new JTextField(20);
        JButton enter = new JButton("Login");

        panel.add(loginName);
        panel.add(enter);
        panel.setSize(300,300);
        login.add(panel);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Client client = new Client(loginName.getText());
					login.setVisible(false);
					login.dispose();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

        });

        loginName.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						Client client = new Client(loginName.getText());
						login.setVisible(false);
						login.dispose();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e1) {
			}
			@Override
			public void keyTyped(KeyEvent e2) {
			}

        });

    }
}
