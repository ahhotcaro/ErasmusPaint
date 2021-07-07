package JavaProjectV3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class Window extends JFrame {
	private JRadioButton bouton1 = new JRadioButton("1. Line");
	private JRadioButton bouton2 = new JRadioButton("2. Outlined Rectangle");
	private JRadioButton bouton3 = new JRadioButton("3. Filled Rectangle");
	private JRadioButton bouton4 = new JRadioButton("4. Outlined Oval");
	private JRadioButton bouton5 = new JRadioButton("5. Filled Oval");
	private JRadioButton eraser = new JRadioButton("6. Erase all");
	private JRadioButton red = new JRadioButton("7. Red");
	private JRadioButton green = new JRadioButton("8. Green");
	private JRadioButton blue = new JRadioButton("9. Blue");
	private JRadioButton dumpArray = new JRadioButton("Dump array");
	// color listener
	private CouleurListener cListener = new CouleurListener();
	// pointer color
	private Color pointerColor = Color.black;
	private JPanel panel = new JPanel();
	private Draw draw;

	public Window() {

		draw = new Draw();
		this.setLayout(new FlowLayout());
		this.setTitle("Menu");
		this.setSize(1000, 1000);
		// quit the program when we click on the red cross
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// the frame is not resizable
		this.setResizable(true);
		// we cannot avoid our issues anymore
		this.setAlwaysOnTop(false);
		// group the radio buttons
		ButtonGroup groupForm = new ButtonGroup();
		groupForm.add(bouton1);
		groupForm.add(bouton2);
		groupForm.add(bouton3);
		groupForm.add(bouton4);
		groupForm.add(bouton5);
		groupForm.add(eraser);
		groupForm.add(dumpArray);
		ButtonGroup groupColor = new ButtonGroup();
		groupColor.add(red);
		groupColor.add(green);
		groupColor.add(blue);

		// intern classes obey buttons
		bouton1.addActionListener(new Bouton1Listener());
		bouton2.addActionListener(new Bouton2Listener());
		bouton3.addActionListener(new Bouton3Listener());
		bouton4.addActionListener(new Bouton4Listener());
		bouton5.addActionListener(new Bouton5Listener());
		eraser.addActionListener(new Bouton6Listener());
		red.addActionListener(cListener);
		green.addActionListener(cListener);
		blue.addActionListener(cListener);
		dumpArray.addActionListener(new Bouton10Listener());

		this.setVisible(true);

		panel.setLayout(new FlowLayout());

		panel.add(bouton1);
		panel.add(bouton2);
		panel.add(bouton3);
		panel.add(bouton4);
		panel.add(bouton5);
		panel.add(eraser);
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(dumpArray);

		this.add(panel, BorderLayout.NORTH);
		this.add(draw, BorderLayout.SOUTH);

	}

	// this class listens to our first button
	class Bouton1Listener implements ActionListener {

		// redefinition of the actionPerformed() methods
		public void actionPerformed(ActionEvent e) {
			draw.setUserChoice(1);
		}
	}

	class Bouton2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			draw.setUserChoice(2);
		}
	}

	class Bouton3Listener implements ActionListener {
		public void actionPerformed(ActionEvent f) {
			draw.setUserChoice(3);
		}
	}

	class Bouton4Listener implements ActionListener {
		public void actionPerformed(ActionEvent g) {
			draw.setUserChoice(4);
		}
	}

	class Bouton5Listener implements ActionListener {
		public void actionPerformed(ActionEvent h) {
			draw.setUserChoice(5);
		}
	}

	class Bouton6Listener implements ActionListener {
		public void actionPerformed(ActionEvent i) {
			draw.setUserChoice(6);
		}
	}

	class Bouton10Listener implements ActionListener {
		public void actionPerformed(ActionEvent j) {
			draw.dumpThatArray();
		}
	}

	// listener for the color change
	class CouleurListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == green)
				draw.setPointerColor(Color.green);
			else if (e.getSource() == blue)
				draw.setPointerColor(Color.blue);
			else
				draw.setPointerColor(Color.red);
		}
	}
}
