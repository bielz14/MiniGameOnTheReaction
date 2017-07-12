import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MiniGameOnTheReaction extends JFrame implements Runnable{

	static Test ts;
	static Random k = new Random();
	static Thread t, q;
	static Scanner scr;

	public static void main(String[] args) throws InterruptedException {
		ts = new Test("Реакция");
		ts.setVisible(true);
		ts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ts.setSize(250, 150);
		ts.setResizable(false);
		ts.setLocationRelativeTo(null);
		ts.play.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				t = new Thread(new MiniGameOnTheReaction());	
				if (e.getSource() == ts.play)
					t.start();
			}
		});	
	}

	int raz = 0;
	static int proverka = 0;

	public void run() {
		while (true) {
			int n = k.nextInt(90) + 10;
			ts.JT.setText("");
			ts.JT.setText(Integer.toString(n));
			try {
				t.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			String str = ts.JT2.getText();
			if (str.length() != 0)
				ts.JT2.setText("");
			if (str.length() == 2 && Integer.parseInt(str) == n)
				raz++;
			if ((str.length() == 2 && Integer.parseInt(str) != n) || str.length() != 2) {
				JOptionPane.showMessageDialog(null, "Игра окончена");
				proverka = 1;
				break;
			}

			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (n == 100)
				break;
		}
		ts.zx.setText("Количество успешных вводов: "+Integer.toString(raz));
		t.stop();
	}
}