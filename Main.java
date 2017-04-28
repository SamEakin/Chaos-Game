/** Main.java
 * 	Chaos Game Fractal Visualization
 */

import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JFrame {
	public Main() {
		setTitle("Fractal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}

	public static int rollDice() {
		return ThreadLocalRandom.current().nextInt(1, 5 + 1);
	}

	public void paint(Graphics g) {
		Point a = new Point(250, 250);
		Point b = new Point(400, 100);
		Point c = new Point(400, 400);
		g.drawLine(a.x, a.x, b.x, b.y);
		g.drawLine(c.x, c.x, b.x, b.y);
		g.drawLine(a.x, a.x, c.x, c.y);

		Point tracer = new Point(10, 10);
		
		/* TODO: 
		 * first just do a static fractal generation of a large number of pixels drawn.
		 * 1. create 3 target points (a,b,c)
		 * 2. create random point
		 * 3. for 2000 iterations
		 *       roll random number
		 *       if ( 1|2 - a, 3|4 - b, 5|6 - c)
		 *           move half the distance in the direction towards the according point
		 *           draw new point
		 */
		for (int i=0; i < 1000; i++) {
			g.drawLine(tracer.x, tracer.y, tracer.x, tracer.y);
			int roll = rollDice();
			if (roll==1 || roll==2) {
				setPoint(tracer, a);
			}
			else if (roll==3 || roll==4) {
				setPoint(tracer, b);
			}
			else if (roll==5 || roll==6) {
				setPoint(tracer, c);
			}
		}
	}

	private void setPoint(Point start, Point target) {
		start.move(target);
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

	public void move(Point target) {
		int midX = (this.x + target.x) / 2;
		int midY = (this.y + target.y) / 2;
		this.x = midX;
		this.y = midY;
	}

	public void randomize() {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		x = ThreadLocalRandom.current().nextInt(0, 499 + 1);
		y = ThreadLocalRandom.current().nextInt(0, 499 + 1);
	}

}
