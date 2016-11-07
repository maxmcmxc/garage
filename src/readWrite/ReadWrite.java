package readWrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import vehicule.Vehicule;

public class ReadWrite {

	public static void readFile(String fileName) {

		FileInputStream fis;
		BufferedInputStream bis;
		FileChannel fc;
		try {
			// Création des objets
			fis = new FileInputStream(new File(fileName));

			// Démarrage du chrono
			long time = System.currentTimeMillis();

			// Création d'un nouveau flux de fichier
			fis = new FileInputStream(new File("test.txt"));

			// On récupère le canal
			fc = fis.getChannel();

			// On en déduit la taille
			int size = (int) fc.size();

			// On crée un buffer correspondant à la taille du fichier
			ByteBuffer bBuff = ByteBuffer.allocate(size);

			// Démarrage du chrono
			time = System.currentTimeMillis();
			// Démarrage de la lecture
			while (fc.read(bBuff) != -1) {
				// On prépare à la lecture avec l'appel à flip
				bBuff.flip();
			}
			;
			// Affichage du temps d'exécution
			System.out.println("Temps d'exécution avec un nouveau buffer : " + (System.currentTimeMillis() - time));

			// Puisque nous avons utilisé un buffer de byte afin de récupérer
			// les données
			// Nous pouvons utiliser un tableau de byte
			// La méthode array retourne un tableau de byte

			byte[] tabByte = bBuff.array();
			String result = "";

			for (byte bit : tabByte) {
				result += String.valueOf((char) bit);
			}

			System.out.println(result);
			fc.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeObjects(String fileName, List<Vehicule> listV){
//		String fileName, Vehicule v
	    ObjectOutputStream oos;

	    try {

	      oos = new ObjectOutputStream(
	              new BufferedOutputStream(
	                new FileOutputStream(
	                  new File(fileName))));
	      
	      for(Vehicule v: listV){
	    	  oos.writeObject(v);
	      }
	      
	      //Ne pas oublier de fermer le flux !
	      oos.close();
	      } catch (Exception e) {
	          e.printStackTrace();
	        }
	}
	    
	public static List<Vehicule> readObjects(String fileName){
		
		ObjectInputStream ois = null;
		List<Vehicule> result= new ArrayList<Vehicule>();

		try {
		
	    ois = new ObjectInputStream(
	             new BufferedInputStream(
	               new FileInputStream(
	                 new File(fileName))));
	    
	    
//	    		result += "Affichage du Garage :\n*************************\n";
	          while(true)  
	        	  result.add((Vehicule) ois.readObject());
	          
		      }
		      catch (FileNotFoundException | EOFException f){
		    	  return result;
		}  catch (IOException | ClassNotFoundException e){
	        	e.printStackTrace();
	        	return result;
	        } finally{
	        	try {
					ois.close();
				} catch (IOException | NullPointerException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
	        	}
		
	}
}