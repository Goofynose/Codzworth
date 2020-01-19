package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 17/03/2018
 * @description Export Jpanel as image
 **********************************************************/

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Export {
	
	/**********************************************************
	 * Export Jpanel as image
	 **********************************************************/
	public static void exportToImage(JPanel panel, String path) {
		int w = panel.getWidth();
		int h = panel.getHeight();
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D graph = img.createGraphics();
		panel.paint(graph);
		
		try {
			ImageIO.write(img, "jpg", new File(path + ".jpg"));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
