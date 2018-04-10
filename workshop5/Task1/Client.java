/*
 * Workshop 4 - Task 1 Client
 * Course:JAC444 - Semester 4
 * Last Name: Chai
 * First Name: Wilson
 * ID: 030-918-114
 * Section: DD
 * This assignment represents my own work in accordance with Seneca Academic Policy.
 * Signed by Wilson Chai
 * Date: April 17, 2018
 */
import java.net.*;
import javax.swing.*;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Client extends JFrame implements Runnable {

    Socket socket;
    JTextArea ta;
    JButton send, logout;
    JTextField tf;

    Thread thread;

    DataInputStream din;
    DataOutputStream dout;

    String LoginName;

    Client(String login) throws UnknownHostException, IOException {
        super(login);
        LoginName = login;

        addWindowListener(new WindowAdapter() {

        	public void windowClosing(WindowEvent e) {
        		try {
					dout.writeUTF(LoginName + " LOGOUT");
					System.exit(1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}

        });

        ta = new JTextArea(18, 50);
        tf = new JTextField(50);

        tf.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if (tf.getText().length() > 0)
							dout.writeUTF(LoginName + " DATA " + tf.getText().toString());
						tf.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
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

        send = new JButton("Send");
        logout = new JButton("Logout");

        send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tf.getText().length() > 0)
						dout.writeUTF(LoginName + " DATA " + tf.getText().toString());
					tf.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

        });

        logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dout.writeUTF(LoginName + " LOGOUT");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

        });

        socket = new Socket("localhost", 5217);

        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());

        dout.writeUTF(LoginName);
        dout.writeUTF(LoginName + " " + "LOGIN");

        thread = new Thread(this);
        thread.start();
        setup();
    }

    private void setup() {
        setSize(600, 400);

        JPanel panel = new JPanel();

        panel.add(new JScrollPane(ta));
        panel.add(tf);
        panel.add(send);
        panel.add(logout);
        add(panel);

        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                ta.append("\n" + din.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
