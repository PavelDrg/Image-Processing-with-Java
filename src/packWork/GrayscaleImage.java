package packWork;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GrayscaleImage extends Image {
	private BufferedImage imagineGrayscale;
	
	// Bloc de inițializare
			{
		        System.out.println("Bloc de initializare al clasei GrayscaleImage.");
		    }

	public GrayscaleImage(BufferedImage imagine, BufferedImage imagineGrayscale) { // constructor cu parametrii
		super(imagine);
		this.imagineGrayscale = imagineGrayscale;
	}

	public BufferedImage getImagineGrayscale() { // getter
		return imagineGrayscale;
	}

	public void setImagineGrayscale(BufferedImage imagineGrayscale) { // setter
		this.imagineGrayscale = imagineGrayscale;
	}

	@Override
	public void afisare() { // functia pentru afisarea imaginii grayscale

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(imagineGrayscale)));
		frame.pack();
		frame.setVisible(true);

	}
}
