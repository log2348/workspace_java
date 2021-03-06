package my_maple_story;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	private JLabel backgroundImg;
	private Player player;
	//private Monster monster;

	public MyFrame() {
		initObject();
		initSetting();
		initListener();

		setVisible(true);
	}

	private void initObject() {
		backgroundImg = new JLabel(new ImageIcon("images/maple_background.png"));
		setContentPane(backgroundImg);

		player = new Player();
		//monster = new Monster();

		add(player);
		// add(monster);
	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null);
		setResizable(false);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initListener() {

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("keyPressed");

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// System.out.println("keyReleased");

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;

				}
			}
		});
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
