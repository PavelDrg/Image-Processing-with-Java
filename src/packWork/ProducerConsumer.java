package packWork;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class ProducerConsumer {
	private LinkedList<ColorImage> buffer = new LinkedList<>();
	private int capacity = 3;
	private ConvertorGrayscale convertor = new ConvertorGrayscale();
	private File ColorImageFolder;
	private File GrayscaleImageFolder;
	
	public ProducerConsumer(String colorImageFolderPath, String grayscaleImageFolderPath) { //constructor cu parametrii - path-urile folderelor
		super();
		ColorImageFolder = new File(colorImageFolderPath);
		GrayscaleImageFolder = new File(grayscaleImageFolderPath);
	}
	
	
	public void produce() throws InterruptedException { //functia producer
		int value = 0;
		while(true) {
			synchronized(this) { //in blocul acesta poate sa intre un singur thread pe rand
				while(buffer.size() == capacity) { //producerul asteapta cat timp buffer-ul e plin
					wait();
				}
				try{
				ColorImage img = new ColorImage();
				img.citire(ColorImageFolder.listFiles()[value].getPath()); //citeste imaginea din fisier
				System.out.println("Producer produced the image - " + value);
				buffer.add(img); //adauga imaginea in buffer
				value++;
				if(value >= ColorImageFolder.listFiles().length) //daca am terminat de citit imaginile din fisier se intrerupe
					break;
				notify(); //anunta consumerul ca poate sa consume
				} catch (ArrayIndexOutOfBoundsException e) {
	                // Handle the case when value is out of bounds
	                System.out.println("Producer: Nu sunt poze in folderul de citire");
	                break;
	            }
				Thread.sleep(1000); //evidentiem etapelecomunicarii
			}
		}
		
	}
	
	public void consume() throws InterruptedException { //functia consumer
		int value = 0;
		while(true) {
			synchronized(this) {
				while(buffer.size() == 0) { //asteapta cat timp buffer-ul este gol
					wait();
				}
				ColorImage img = buffer.removeFirst(); //ia prima imagine din buffer
				GrayscaleImage gray = convertor.convertToGrayscale(img); //transforma imaginea in grayscale
				File newFile = new File(GrayscaleImageFolder.getPath() + "\\" + value + ".bmp"); //creeaza noul fisier
				try {
					   ImageIO.write(gray.getImagineGrayscale(), "bmp", newFile); //scrie imaginea in noul fisier
					} catch(IOException e) {
					 System.out.println("Write error for " + GrayscaleImageFolder.getPath() + ": " + e.getMessage()); //exceptie
					}
				
				System.out.println("Consumer consumed");
				value++;
				if(value >= ColorImageFolder.listFiles().length)  //daca am terminat de citit imaginile din fisier se intrerupe
					break;
				notify(); // notifica producerul
				Thread.sleep(1000);
			}
			
		}
	}
		
}
