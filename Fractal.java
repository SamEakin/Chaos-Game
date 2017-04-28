/** Fractal.java
 * 	Chaos Game Fractal Visualization
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.concurrent.ThreadLocalRandom;

public class Fractal extends JFrame {
	public Fractal() {
		int size = 800;
		setTitle("Chaos Game Fractals");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setVisible(true);
	}

	public static int rollDice() {
		return ThreadLocalRandom.current().nextInt(1, 5 + 1);
	}

	public void paint(Graphics g) {
		int fractals = 3;
		for (int i=0; i < fractals; i++) {
			// draw random triangle
			Triangle randomTri = new Triangle();

			// draw random tracer point and define number of iterations to run
			Point tracer = new Point();
			int iterations = 20000;

			redraw(g, randomTri, tracer, iterations);
		}
	}


	public void redraw(Graphics g, Triangle tri, Point tracer, int iterations) {
		for (int i=0; i < iterations; i++) {
			g.drawLine(tracer.x, tracer.y, tracer.x, tracer.y);
			int roll = rollDice();
			if (roll==1 || roll==2)
				setPoint(tracer, tri.a);
			else if (roll==3 || roll==4)
				setPoint(tracer, tri.b);
			else if (roll==5 || roll==6)
				setPoint(tracer, tri.c);
		}
	}

	private void setPoint(Point start, Point target) {
		start.move(target);
	}

	public static void main(String[] args) {
		Fractal screen = new Fractal();
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = ThreadLocalRandom.current().nextInt(0, 799 + 1);
		y = ThreadLocalRandom.current().nextInt(0, 799 + 1);
	}

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
}

class Triangle {
	Point a;
	Point b;
	Point c;

	Triangle() {
		this.a = new Point();
		this.b = new Point();
		this.c = new Point();
	}
}


