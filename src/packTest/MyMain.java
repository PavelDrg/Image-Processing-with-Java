package packTest;

import java.util.List;
import java.util.Scanner;

import packWork.ColorImage;
import packWork.ConvertorGrayscale;
import packWork.GrayscaleImage;
import packWork.ProducerConsumer;

public class MyMain {
	
	//Bloc static de initializare
	static {
			System.out.println("Bloc static de initializare al clasei MyMain.");
	}

	public static void main(String[] args) throws InterruptedException {

//		 ColorImage img1 = new ColorImage();
//		 String img1_path = "./src/resources/ColorImages/parrots.bmp";
//		 ConvertorGrayscale convertor = new ConvertorGrayscale();
//		
//		 img1.citire(img1_path);
//		 img1.afisare();
//		
//		 GrayscaleImage gray1 = convertor.convertToGrayscale(img1);
//		 gray1.afisare();
//		
//		 // Testare metoda convertMultipleToGrayscale
//		 ColorImage img2 = new ColorImage();
//		 String img2_path = "./src/resources/ColorImages/snail.bmp";
//		
//		 ColorImage img3 = new ColorImage();
//		 String img3_path = "./src/resources/ColorImages/monkey.bmp";
//		
//		 img2.citire(img2_path);
//		 img3.citire(img3_path);
//		
//		 GrayscaleImage gray2 = convertor.convertToGrayscale(img2);
//		 GrayscaleImage gray3 = convertor.convertToGrayscale(img3);
//		
//		 List<GrayscaleImage> grayImagesList =
//		 convertor.convertMultipleToGrayscale(img2, img3);
//		
//		 // Afisaza imaginile grayscale din lista
//		 for (GrayscaleImage grayImage : grayImagesList) {
//		 grayImage.afisare();
//		 }

		 
		 
		long startTime = System.nanoTime(); // Obținem momentul de start al aplicației pentru a măsura durata totală de execuție.

		// String pathColor = "./src/resources/ColorImages";
		// String pathGray = "./src/resources/GrayscaleImages";

		System.out.println("Introduceti path-ul in care se afla imaginile color: ");
		Scanner sc = new Scanner(System.in);

		String pathColor = sc.next();

		System.out.println("Introduceti path-ul in care vreti sa se afle imaginile grayscale: ");
		String pathGray = sc.next();

		sc.close();

		ProducerConsumer pc = new ProducerConsumer(pathColor, pathGray); // Inițializează obiectul ProducerConsumer cu căile specificate de utilizator.

		System.out.println("Timpul dupa citire identificare informatii fisiere: " + (System.nanoTime() - startTime)); // Afisează timpul după citirea și identificarea informațiilor despre fișiere.

		// Inițializează și lansează un fir de execuție pentru producer.
		Thread producerThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// Inițializează și lansează un fir de execuție pentru consumer.
		Thread consumerThread = new Thread(new Runnable() { 
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Porneste firele de execuție pentru producer și consumer.
		producerThread.start();
		consumerThread.start();

		// Așteaptă până când firul producer și cel consumer își încheie execuția.
		producerThread.join();
		consumerThread.join();

		// Afisează timpul după procesarea tuturor imaginilor.
		System.out.println("Timp dupa procesarea tuturor imaginilor: " + (System.nanoTime() - startTime));
	}

}
