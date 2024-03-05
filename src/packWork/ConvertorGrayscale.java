package packWork;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ConvertorGrayscale implements ConvertorInterface {
	
	public ConvertorGrayscale() { //constructor deafult
		super();
	}
	
	@Override
	public GrayscaleImage convertToGrayscale(ColorImage coloredImage) { //functia de convertire la grayscale - primesteca parametru imagine color, returneaza img grayscale
		int width = coloredImage.getImagine().getWidth();
        int height = coloredImage.getImagine().getHeight();
        
        BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = coloredImage.getImagine().getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                
                int grayValue = (r + g + b) / 3; // Average method formula
                int grayRgb = (grayValue << 16) | (grayValue << 8) | grayValue;
                
                grayscaleImage.setRGB(x, y, grayRgb);
            }
        }
        
        GrayscaleImage gray = new GrayscaleImage(coloredImage.getImagine(), grayscaleImage);
        return gray;
	}

	@Override
	public List<GrayscaleImage> convertMultipleToGrayscale(ColorImage... coloredImages) { //functia de convertire cu parametrii variabili - primeste un nr variaibl de colored image si intoarce o lista de grayscale images
		List<GrayscaleImage> grayImages = new ArrayList<GrayscaleImage>();
		for(ColorImage coloredImage : coloredImages){
			int width = coloredImage.getImagine().getWidth();
	        int height = coloredImage.getImagine().getHeight();
	        
	        BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
	        
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	                int rgb = coloredImage.getImagine().getRGB(x, y);
	                int r = (rgb >> 16) & 0xFF;
	                int g = (rgb >> 8) & 0xFF;
	                int b = rgb & 0xFF;
	                
	                int grayValue = (r + g + b) / 3; // Average method formula
	                int grayRgb = (grayValue << 16) | (grayValue << 8) | grayValue;
	                
	                grayscaleImage.setRGB(x, y, grayRgb);
	            }
	        }
	        
	        GrayscaleImage gray = new GrayscaleImage(coloredImage.getImagine(), grayscaleImage);
	        grayImages.add(gray);
		}
		
		return grayImages;
	}

}
