package mainPackage.ApplicationLayer;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class ImagePanel extends JComponent{

	private Image image;
	public ImagePanel(Image image) {
		this.image = image;
	}
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}
