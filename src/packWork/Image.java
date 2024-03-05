package packWork;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public abstract class Image implements ImageInterface {
	private BufferedImage imagine;
	
	@Override
	public void afisare() { // functia de afisare imagine pe ecran (folosita in
							// partea initiala de testare)

		JFrame frame = new JFrame(); // cream un nou JFrame pt a afisa imaginea pe ecran
		frame.getContentPane().setLayout(new FlowLayout()); // alegem layout-ul frame-ului continutul
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void citire(String numeFisier) { // functia de citire
		try {
			imagine = ImageIO.read(new File(numeFisier));
		} catch (IOException e) {
			System.out.println("cannot read file");
		}
	}

	public Image() { // constructorul default
		super();
	}

	public Image(BufferedImage imagine) { // constructor cu parametrii
		super();
		this.imagine = imagine;
	}

	public BufferedImage getImagine() {
		return imagine;
	}

	public void setImagine(BufferedImage imagine) {
		this.imagine = imagine;
	}

}
