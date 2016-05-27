package shapes.view;

import javax.swing.JFrame;
import shapes.controller.ShapesController;

public class DrawingFrame extends JFrame
{
	private ShapesController baseController;
	private DrawPanel basePanel;

	public DrawingFrame(ShapesController shapesController)
	{
		this.baseController = baseController;
		basePanel = new DrawPanel(baseController);
		
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(1000,1000);
		this.setTitle("mehPanel");
		this.setVisible(true);
		
	}
}
