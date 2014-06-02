package connexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.List;

import javax.swing.JOptionPane;

public class ConnexionHTTP {
	private static URL myURL;
	private static URLConnection myURLConnection;
	private static String adresse="http://webdev.cluster1.easy-hebergement.net/java_api/index.php";
	
	public ConnexionHTTP() {
		// TODO Stub du constructeur g�n�r� automatiquement
		try {
		    myURL = new URL(adresse);
		    myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		} 
		catch (MalformedURLException e) { 
		    // new URL() failed
		    // ...
		} 
		catch (IOException e) {   
		    // openConnection() failed
		    // ...
		}
		
	}
	
	public static String post(List<String> keys, List<String> values){
		String result = "";
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		try {
		//encodage des param�tres de la requ�te
		String data="";
		for(int i=0; i<keys.size();i++){
		if (i!=0)
		{
			data += "&";
		}
			data +=URLEncoder.encode(keys.get(i), "UTF-8")+"="+URLEncoder.encode(values.get(i), "UTF-8");
		}
		System.out.println("donn�es envoy� par POST :"+data);
		//cr�ation de la connection
		myURL = new URL(adresse);
		myURLConnection = myURL.openConnection();
		myURLConnection.setDoOutput(true);


		//envoi de la requ�te
		writer = new OutputStreamWriter(myURLConnection.getOutputStream());
		writer.write(data);
		writer.flush();




		//lecture de la r�ponse
		reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
		String ligne;
		while ((ligne = reader.readLine()) != null) {
			result+=ligne;
		}
		}catch (Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Probl�mes li�s � l'h�te distant !", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}finally{
		try{writer.close();}catch(Exception e){}
		try{reader.close();}catch(Exception e){}
		}
		return result;
	}

}
