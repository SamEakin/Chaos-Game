/** Main.java
 * 	Chaos Game Fractal Visualization
 */

import java.awt.Graphics;
import javax.swing.JFrame;

public class Main extends JFrame {
	public Main() {
		setTitle("Fractal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}

	public void paint(Graphics g) {
		Point a = new Point(250,250);
		Point b = new Point(400,100);
		Point c = new Point(400,400);
		g.drawLine(a.x, a.x, b.x, b.y);
		g.drawLine(c.x, c.x, b.x, b.y);
		g.drawLine(a.x, a.x, c.x, c.y);
	}

	private void setPoint() {

	}

	public static void main(String[] args) {
		Main screen = new Main();
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
