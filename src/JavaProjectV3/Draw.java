package JavaProjectV3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Draw extends JPanel {
	// Pointer positions X and Y
	private int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
	private int userchoice;
	// graphic primitives must be stored in memory in a ArrayList
	private ArrayList<ArrayList<Point>> points = new ArrayList<ArrayList<Point>>();
	// pointer color
	private Color pointerColor = Color.black;

	public Draw() {
		super();
		this.setOpaque(true);
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(1000, 900));
		setBackground(Color.white);

		for (int i = 0; i < 5; i++)
			points.add(new ArrayList<Point>());

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				switch (userchoice) {
				case 1:
					points.get(0).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 2:
					points.get(1).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 3:
					points.get(2).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 4:
					points.get(3).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 5:
					points.get(4).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 6:
					for (int i = 0; i < 5; i++) {
						points.get(i).clear();
					}
					break;
				}

			}

			public void mouseReleased(MouseEvent e) {

				switch (userchoice) {
				case 1:
					points.get(0).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 2:
					points.get(1).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 3:
					points.get(2).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 4:
					points.get(3).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				case 5:
					points.get(4).add(new Point(e.getX(), e.getY(), pointerColor));
					break;
				}
				repaint();
			}
		});
	}

	public void dumpThatArray() {
		System.out.println(points);
	}

	public void setUserChoice(int userChoice) {
		this.userchoice = userChoice;
	}

	// set the color
	public void setPointerColor(Color c) {
		this.pointerColor = c;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);

		for (int i = 0; i < this.points.size(); i++) {
			for (int j = 0; j < this.points.get(i).size(); j += 2) {
				int x1, x2, y1, y2;
				x1 = this.points.get(i).get(j).getX();
				Color pointerColour = this.points.get(i).get(j).getColor();
				x2 = this.points.get(i).get(j + 1).getX();
				y1 = this.points.get(i).get(j).getY();
				y2 = this.points.get(i).get(j + 1).getY();

				switch (i) {
				case 0:
					g.setColor(pointerColour);
					g.drawLine(x1, y1, x2, y2);
					break;
				case 1:
					g.setColor(pointerColour);
					if (x1 > x2) {
						int tmp = x2;
						x2 = x1;
						x1 = tmp;
					}
					if (y1 > y2) {
						int tmp = y2;
						y2 = y1;
						y1 = tmp;
					}
					g.drawRect(x1, y1, x2 - x1, y2 - y1);
					break;
				case 2:
					g.setColor(pointerColour);
					if (x1 > x2) {
						int tmp = x2;
						x2 = x1;
						x1 = tmp;
					}
					if (y1 > y2) {
						int tmp = y2;
						y2 = y1;
						y1 = tmp;
					}
					g.fillRect(x1, y1, x2 - x1, y2 - y1);
					break;
				case 3:
					g.setColor(pointerColour);
					if (x1 > x2) {
						int tmp = x2;
						x2 = x1;
						x1 = tmp;
					}
					if (y1 > y2) {
						int tmp = y2;
						y2 = y1;
						y1 = tmp;
					}
					g.drawOval(x1, y1, x2 - x1, y2 - y1);
					break;
				case 4:
					g.setColor(pointerColour);
					if (x1 > x2) {
						int tmp = x2;
						x2 = x1;
						x1 = tmp;
					}
					if (y1 > y2) {
						int tmp = y2;
						y2 = y1;
						y1 = tmp;
					}
					g.fillOval(x1, y1, x2 - x1, y2 - y1);
					break;
				}
			}
		}
	}
}
