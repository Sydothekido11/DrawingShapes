package shapes.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapeDrawingPanel extends JPanel
{
	private ArrayList<Rectangle> rectList;
	private ArrayList<Rectangle>squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	
	public ShapeDrawingPanel()
	{
		rectList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
	}
	public void addRect()
	{

		int xPos = (int)(Math.random()* getWidth());
		int yPos = (int)(Math.random()* getHeight());
		int width = (int)(Math.random()* 100);
		int height = (int)(Math.random()*100);
		
		rectList.add(new Rectangle(xPos, yPos, width, height));
		
		repaint();
		
	}

	public void addSquare()
	{
		int xPos = (int)(Math.random()* getWidth());
		int yPos = (int)(Math.random()* getHeight());
		int width = (int)(Math.random()* 100);
		int height = width;	
		
		squareList.add(new Rectangle(xPos, yPos, width, height));
		
		repaint();
		
	}

	public void addEllipse()
	{
		int xPos = (int)(Math.random()* getWidth());
		int yPos = (int)(Math.random()* getHeight());
		int width = (int)(Math.random() * 200);
		int height = (int)(Math.random() * 100);
		
		Ellipse2D currentElipse = new Ellipse2D.Double(xPos, yPos, width, height);
		ellipseList.add(currentElipse);
		repaint();
	}

	public void addCircle()
	{
		int xPos = (int)(Math.random()* getWidth());
		int yPos = (int)(Math.random()* getHeight());
		int width = (int)(Math.random() * 100);
		int height = width;
		
		Ellipse2D currentElipse = new Ellipse2D.Double(xPos, yPos, width, height);
		circleList.add(currentElipse);
		repaint();
		
	}
	
	public void addTriangle()
	{
		int[] xPoints = {(int)(Math.random() * getWidth()),(int)(Math.random() * getWidth()),(int)(Math.random() * getWidth())};
		int[] yPoints = {(int)(Math.random() * getHeight()), (int)(Math.random() * getHeight()),(int)(Math.random() * getHeight())};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		triangleList.add(triangle);
		
		repaint();
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 9) + 3;
		int [] xPoints = new int[numberOfSides];
		int [] yPoints = new int [numberOfSides];
		
		for(int side = 0; side < numberOfSides; side++)
		{
			xPoints[side] = (int)(Math.random() * getWidth());
			yPoints[side] = (int)(Math.random() * getHeight());
		}
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
		
		repaint();
	}
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);

		Graphics2D mainGraphics = (Graphics2D) currentGraphics;

		mainGraphics.setStroke(new BasicStroke(10));
		mainGraphics.setColor(Color.DARK_GRAY);


		for(Rectangle currentRect: rectList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(currentRect);
		}
		
		for(Rectangle currentSquare: squareList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(currentSquare);	
		}
		
		for(Polygon currentTriangle : triangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(currentTriangle);	
		}
		
		for(Polygon currentPolgon : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(currentPolgon);	
		}
		
		for(Ellipse2D currentCircle : circleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(currentCircle);	
		}
		for(Ellipse2D currentEllipse : ellipseList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(currentEllipse);	
		}
	}



}
