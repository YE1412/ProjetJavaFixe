package connexion;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLtraitement {
	private org.w3c.dom.Node result;	 
	private org.w3c.dom.Document document;				
	private DocumentBuilderFactory fabrique;
	private DocumentBuilder constructeur;
	private ByteArrayInputStream Bis1;
	private StringBuffer Buffer;
	
	public XMLtraitement(String donnee) throws ParserConfigurationException, UnsupportedEncodingException{
		result=null;
		// création d'une fabrique de documents
		fabrique = DocumentBuilderFactory.newInstance();								
		// création d'un constructeur de documents
		constructeur = fabrique.newDocumentBuilder();								
		// lecture du contenu d'un fichier XML avec DOM

		Buffer = new StringBuffer(donnee);

		Bis1 = new ByteArrayInputStream(Buffer.toString().getBytes("UTF-8"));

	}
	private org.w3c.dom.Node lecture(){ 
	try
	{			
		document = constructeur.parse(Bis1);

		org.w3c.dom.Element racine = document.getDocumentElement();		

		result=racine.getParentNode().getFirstChild(); 											

	}
	/*catch(ParserConfigurationException pce)
	{
		System.out.println("\n-> Utilities.java/ConvertStringToNode");
		System.out.println("Erreur de configuration du parseur DOM");
		System.out.println("lors de l'appel à fabrique.newDocumentBuilder();");
		pce.printStackTrace();
		System.exit(0);
	}*/
	catch(SAXException se)
	{
		System.out.println("\n-> Utilities.java/ConvertStringToNode");
		System.out.println("Erreur lors du parsing du document");
		System.out.println("lors de l'appel à construteur.parse(xml)");
		System.out.println("Les DTD sont elles presentent dans le repertoire ?");
		se.printStackTrace();
		System.exit(0);
	}
	catch(IOException ioe)
	{
		System.out.println("\n-> Utilities.java/ConvertStringToNode");
		System.out.println("Erreur d'entrée/sortie");
		System.out.println("lors de l'appel à construteur.parse(xml)");
		ioe.printStackTrace();			
		System.exit(0);
	}


		return result;
	}
	public Map<String, String> retourneChamps(){
	org.w3c.dom.Node param, value, struct, racine, member, root;
		param= lecture().getFirstChild();
		value=param.getFirstChild().getNextSibling();
		struct=value.getFirstChild().getNextSibling();
		member=struct.getFirstChild().getNextSibling();
		racine=member.getLastChild().getPreviousSibling();
		root=racine.getFirstChild().getNextSibling();
		/*System.out.println(param.getChildNodes().getLength());
		System.out.println(root.getChildNodes().getLength());*/
		//racine=struct.getFirstChild();
		 //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		   
			int index=0;
			org.w3c.dom.Node current=null;
			Map<String, String> hashMap = new HashMap<String, String>();
		 while(index<root.getChildNodes().getLength()-1)
		  {
			   if(index==0)
			   {
				   current=root.getFirstChild().getNextSibling();
			   }
			   else
			   {
				   current=current.getNextSibling();
			   }
			   if((index%2)==(0))
			   {
				   String key, val;
				   key=current.getFirstChild().getNextSibling().getTextContent();
				   try {
					key=new String(key.getBytes("iso-8859-1"), "utf8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Bloc catch généré automatiquement
					e1.printStackTrace();
				}
				   val=current.getLastChild().getPreviousSibling().getTextContent();
				   try {
					val=new String (val.getBytes("iso-8859-1"), "utf8");
				} catch (UnsupportedEncodingException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
				   /*System.out.println(key);
				   System.out.println(val);*/
				   hashMap.put(key, val);
			   }
			   index++;
		  }
		 return hashMap;
		 
	}
	
	public Map<String, Map<Integer, List<String>>> retourneDonnees() throws UnsupportedEncodingException
	{
		Map<String, Map<Integer, List<String>>> hashMap = new HashMap<String, Map<Integer, List<String>>>();
		Map<String, String> hash = new HashMap<String, String>();
		org.w3c.dom.Node param, value, structure, root2;
		param= lecture().getFirstChild();
		value=param.getFirstChild().getNextSibling();
		structure=value.getFirstChild().getNextSibling();
		NodeList currentList=structure.getChildNodes();
		org.w3c.dom.Node rep;
		//Analyse de la réponse//
		for(int i=0; i<structure.getChildNodes().getLength()-2; i++)
		{
			if((i%2)!=(0))
			{
				String key, texte;
				
				rep=currentList.item(i);
				key=rep.getFirstChild().getNextSibling().getTextContent();
				texte=rep.getLastChild().getPreviousSibling().getTextContent();
				//Traitement des caractere speciaux//
				key=new String(key.getBytes("iso-8859-1"), "utf8");
				texte=new String(texte.getBytes("iso-8859-1"), "utf8");
				
				hash.put(key, texte);
				/*System.out.println(key);
				System.out.println(texte);*/
			}
		}
		String valid=hash.get("success").replaceAll(" ", "");
		Map<Integer, List<String>> detail=new HashMap<Integer, List<String>>();
		if((Integer.valueOf(valid))==(1))
		{
			org.w3c.dom.Node val, tableau, donnee, root3 = null; 
			//Récupération de tous les praticiens//
			root2=currentList.item(5);
			val=root2.getLastChild().getPreviousSibling();
			tableau=val.getFirstChild().getNextSibling();
			donnee=tableau.getFirstChild().getNextSibling();
			NodeList listElem=donnee.getChildNodes();
			int indice=0;
			for(int i=0; i<listElem.getLength(); i++)
			{	
				if((i%2)!=(0))
				{
					root3=listElem.item(i);
					org.w3c.dom.Node struct=root3.getFirstChild().getNextSibling(), member=null;
					NodeList listDetailPra=struct.getChildNodes();
					List<String> liste=new ArrayList<String>();
					String det;
					if(listDetailPra.getLength()==1)
					{
						//System.out.println(listDetailPra.getLength());
						member=listDetailPra.item(0);
						det=member.getTextContent().replaceAll(" ", "");
						det=new String(det.getBytes("iso-8859-1"), "utf8");
						liste.add(det);
					}
					else
					{
						//System.out.println(listDetailPra.getLength());
						for(int j=0; j<listDetailPra.getLength(); j++)
						{
							if((j%2)!=(0))
							{
								member=listDetailPra.item(j);
								/*System.out.println(member.getFirstChild().getNextSibling().getTextContent());
								System.out.println(member.getLastChild().getPreviousSibling().getTextContent());*/
								String mefDon=member.getLastChild().getPreviousSibling().getTextContent().replaceAll("          ", "");
								liste.add(mefDon.replaceFirst(" ", ""));
							}
						}
					}
						detail.put(indice ,liste);
						indice++;
				}
			}
			hashMap.put("Donnees", detail);
			/*System.out.println(root2.getFirstChild().getNextSibling().getNodeName());
			System.out.println(root2.getLastChild().getPreviousSibling().getNodeName());*/
			
			
		}
		else
		{
			//Récupération de la cause du message//
			List<String> liste=new ArrayList<String>();
			org.w3c.dom.Node val; 
			root2=currentList.item(5);
			val=root2.getLastChild().getPreviousSibling();
			String msg=val.getFirstChild().getNextSibling().getTextContent();
			msg=new String(msg.getBytes("iso-8859-1"), "utf8");
			liste.add(msg);
			detail.put(0, liste);
			hashMap.put("Donnees", detail);
			//System.out.println(key+" "+texte);
		}
		/*System.out.println(param.getNodeName()+" "+param.getChildNodes().getLength());
		System.out.println(root1.getFirstChild().getNextSibling().getNodeName()+" "+root1.getChildNodes().getLength());*/
		return hashMap;
	}
}
