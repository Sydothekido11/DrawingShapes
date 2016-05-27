package shapes.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import shapes.controller.ShapesController;

public class DrawPanel extends JPanel
{
	private ShapesController baseController;
	private ShapeDrawingPanel shapePanel;
	private GraphingPanel graphPanel;
	private JButton graphButton;
	private JButton rectangleButton;
	private JButton squareButton;
	private JButton triangleButton;
	private JButton polygonButton;
	private JButton circleButton;
	private JButton ellipseButton;
	private SpringLayout baseLayout;

	private ArrayList<Rectangle> rectList;


	public DrawPanel(ShapesController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();

		shapePanel = new ShapeDrawingPanel();
		graphPanel = new GraphingPanel();

		squareButton = new JButton("add a square");
		rectangleButton = new JButton("add a rectangle");
		graphButton = new JButton("make a graph");
		triangleButton = new JButton("Add a triangle");
		polygonButton = new JButton("Add a Polygon");
		circleButton = new JButton("Add a circle");
		ellipseButton = new JButton("add an elipse");

		rectList = new ArrayList<Rectangle>();

		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setBackground(Color.PINK);
		this.add(shapePanel);
		this.add(graphPanel);
		this.add(squareButton);
		this.add(rectangleButton);
		this.add(triangleButton);
		this.add(polygonButton);
		this.add(circleButton);
		this.add(ellipseButton);
		this.add(graphButton);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, graphPanel, 700, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, graphPanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, graphPanel, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, graphPanel, -400, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -100, SpringLayout.EAST, polygonButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, circleButton, -890, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -400, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, polygonButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, squareButton, 0, SpringLayout.NORTH, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, squareButton, 6, SpringLayout.EAST, triangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, triangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonButton, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, triangleButton, 0, SpringLayout.NORTH, polygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 158, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 6, SpringLayout.SOUTH, squareButton);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 129, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, rectangleButton, -116, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 93, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, circleButton, -100, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rectangleButton, -9, SpringLayout.NORTH, circleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, ellipseButton, -6, SpringLayout.NORTH, squareButton);
		baseLayout.putConstraint(SpringLayout.EAST, ellipseButton, -65, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		graphButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{
				
			}
		});
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{
				shapePanel.addRect();

			}
		});

		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addSquare();
			}
		});

		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addTriangle();
			}
		});

		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addPolygon();
			}
		});

		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addCircle();
			}
		});

		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent onClick)
			{

				shapePanel.addEllipse();
			}
		});

		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{

			}

			public void mouseDragged(MouseEvent dragged)
			{
				int xPos = dragged.getX();
				int yPos = dragged.getY();

				int width = (int) (Math.random() * 100);
				int height = (int) (Math.random() * 100);

				rectList.add(new Rectangle(xPos, yPos, width, height));
				repaint();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);

		Graphics2D mainGraphics = (Graphics2D) currentGraphics;

		mainGraphics.setStroke(new BasicStroke(10));
		mainGraphics.setColor(Color.DARK_GRAY);

		mainGraphics.drawRect(100, 300, 200, 100);

		for (Rectangle current : rectList)
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.fill(current);
		}

	}

}
