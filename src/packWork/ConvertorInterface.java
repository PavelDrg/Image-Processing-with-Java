package packWork;

import java.util.List;

public interface ConvertorInterface {
	GrayscaleImage convertToGrayscale(ColorImage coloredImage);

	List<GrayscaleImage> convertMultipleToGrayscale(ColorImage... coloredImages);
}
