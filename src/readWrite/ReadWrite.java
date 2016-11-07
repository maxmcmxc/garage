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
			// Cr�ation des objets
			fis = new FileInputStream(new File(fileName));

			// D�marrage du chrono
			long time = System.currentTimeMillis();

			// Cr�ation d'un nouveau flux de fichier
			fis = new FileInputStream(new File("test.txt"));

			// On r�cup�re le canal
			fc = fis.getChannel();

			// On en d�duit la taille
			int size = (int) fc.size();

			// On cr�e un buffer correspondant � la taille du fichier
			ByteBuffer bBuff = ByteBuffer.allocate(size);

			// D�marrage du chrono
			time = System.currentTimeMillis();
			// D�marrage de la lecture
			while (fc.read(bBuff) != -1) {
				// On pr�pare � la lecture avec l'appel � flip
				bBuff.flip();
			}
			;
			// Affichage du temps d'ex�cution
			System.out.println("Temps d'ex�cution avec un nouveau buffer : " + (System.currentTimeMillis() - time));

			// Puisque nous avons utilis� un buffer de byte afin de r�cup�rer
			// les donn�es
			// Nous pouvons utiliser un tableau de byte
			// La m�thode array retourne un tableau de byte

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