import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class mainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel main, leftPanel, selPane, butPane, centerPanel, recPane, listPane, rightPanel, intScroll;
	Toolkit t;
	JScrollPane scroll;
	private int extMarginH, extMarginV, height, width, lIntMarginV, lIntMarginH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainWindow() {

		height = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
		width = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();

		Dimension d = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();

		setMargin();

		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(d);

		main = new JPanel();
		main.setLayout(new GridLayout(1, 3, 16, 16));
		setContentPane(main);

		// LEFT PANE ADDITION START *****
		leftPanel = new JPanel();
		setLeftInternalMargin();
		leftPanel.setLayout(new GridLayout(3, 1, lIntMarginH, 24));
		main.add(leftPanel);

		selPane = new JPanel();
		selPane.setLayout(new GridLayout(6, 1, 16, 16));
		for (int i = 0; i < 6; i++)
			selPane.add(new JButton("Button " + (i + 1)));
		leftPanel.add(selPane);

		recPane = new JPanel(new GridLayout(2, 1, 16, 16));

		JButton recBut = new JButton("Record");
		recPane.add(recBut);

		JTextField name = new JTextField();
		name.setToolTipText("Enter file name here...");
		recPane.add(name);
		leftPanel.add(recPane);

		listPane = new JPanel(new GridLayout(1, 1, 16, 16));

		JTextField list = new JTextField();
		listPane.add(list);
		leftPanel.add(listPane);
		// LEFT PANE ADDITION ENDS ****

		// CENTER PANE ADDTION START *****

		centerPanel = new JPanel(new GridLayout(4, 1, 8, 24));

		JButton swapBut = new JButton("Swap");
		centerPanel.add(swapBut);		

		JButton addBut = new JButton("Add");
		centerPanel.add(addBut);
		
		JButton remBut = new JButton("Remove");
		centerPanel.add(remBut);
		main.add(centerPanel);
		// CENTER PANEL ADDITION ENDS *****
		

		// RIGHT PANEL ADDITIONS STARTS *****
		/*scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setWheelScrollingEnabled(true);
		main.add(scroll);*/
		
		intScroll = new JPanel(new GridLayout(10, 1, 4, 8));
		main.add(intScroll);

		for (int i = 0; i < 10; i++) {
			intScroll.add(new JButton("Sound " + (i + 1)));
		}
		// RIGHT PANEL ADDITIONS ENDS *****
	}

	private void setLeftInternalMargin() {

		lIntMarginV = (int) (leftPanel.getHeight() * 0.1 / 5);
		lIntMarginH = (int) (leftPanel.getWidth() * 0.1 / 2);

	}

	private void setMargin() {

		extMarginH = (int) (width * 0.1 / 4);
		extMarginV = (int) (height * 0.1 / 2);

	}
}
