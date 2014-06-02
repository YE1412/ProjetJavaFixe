package connexion;

import java.util.ArrayList;

public class ListeDonnees {
	private ArrayList<String> listedonnee;
	
	public ListeDonnees(ArrayList<String> liste){
		listedonnee=liste;
	}
	
	public void add(String donnee){
		if(!donnee.equals("")){
			listedonnee.add(donnee);
		}
	}
	
	public int getNbDonnees(){
		int result=listedonnee.size();
		return result;
	}
	
	public String getDonnee(int index){
		String donnee="";
		donnee=listedonnee.get(index);
		return donnee;
	}
	
	public int getIndexOf(String rapp){
		int result=0;
		result=listedonnee.indexOf(rapp);
		return result;
	}
	
	public void removeDonnee(String donn){
		listedonnee.remove(donn);
	}
}
