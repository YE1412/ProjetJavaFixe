package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
//Classe permettant de tester les connections à la base et mettre à jour les données de la base
public class manageBD {
	private Connection conn;
	
	//Constructeur
	public manageBD(String BD) throws SQLException
	{
		Connection connecte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K.");
			
		    String url = "jdbc:mysql://localhost/"+BD;
		    String user = "root";
		    String passwd = "";
		    
		    connecte = DriverManager.getConnection(url, user, passwd);
		     System.out.println("Connexion effective !");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.conn=connecte;
	}
//Methode permettant d'executer une requete simple	
	public String[] requeteSelectSimple(String req)
	{
		String[] ligne = null;
		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(req);
			//result.next();
			ResultSetMetaData resMeta=result.getMetaData();
			//System.out.println("colonne :"+resMeta.getColumnCount());
			if(result.next()){
				ligne=new String[resMeta.getColumnCount()];
				for(int i=0; i<resMeta.getColumnCount(); i++)
				{
					//System.out.println("ELMT "+(i+1)+":"+result.getObject(i+1).toString());
					if(result.getObject(i+1)!=null){
						ligne[i]=result.getObject(i+1).toString();
					}
					else{
						ligne[i]="NULL";
					}
				}				
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ligne;
		
	}
//Requête permettant d'exectuter une requête multiple
	public String[][] requeteSelectMultiple(String req, String table)
	{
		String[][] Resultat=null;
		try {
			Statement state = conn.createStatement();
			ResultSet res = state.executeQuery("SELECT COUNT(*) AS nb FROM "+table);
			res.next();
		      int nblignes=res.getInt("nb");
		      res.close();
			ResultSet result = state.executeQuery(req);
			ResultSetMetaData resMeta=result.getMetaData();
			Resultat=new String[nblignes][resMeta.getColumnCount()];
			int j=0;
				do
				{
					result.next();
					for(int i=0; i<resMeta.getColumnCount(); i++)
					{
						Resultat[j][i]=result.getObject(i+1).toString();
					}
					
					j++;
					
				}
				while(!result.isLast());
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Resultat;
		
	}
	
	public List<Object> requeteSelectMultipleVis(String req)
	{
		List<Object> Resultat=null;
		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(req);
			ResultSetMetaData resMeta=result.getMetaData();
			//Resultat=new String[nblignes][resMeta.getColumnCount()];
			if(result.next()){
				Resultat=new ArrayList<Object>();
				String visit;		
				while(!result.isLast())
				{
					visit="";
					for(int i=0; i<resMeta.getColumnCount(); i++)
					{
						visit+=";"+result.getObject(i+1).toString();
						//System.out.println("Visiteur :"+visit);
					}
					result.next();
					Resultat.add(visit);
				}
				//Cas où il n'y a qu'un seul resultat
				if(result.isLast()){
					visit="";
					for(int i=0; i<resMeta.getColumnCount(); i++)
					{
						visit+=";"+result.getObject(i+1).toString();
						//System.out.println("Visiteur :"+visit);
					}
					Resultat.add(visit);
				}
			}
			result.close();
			state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Resultat;
		
	}
	
	public void deconnecte()
	{
		try {
			this.conn.close();
			System.out.println("Connexion Terminée !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getNb(String table)
	{
		int nombre=0;
		try {
			Statement state = conn.createStatement();
			ResultSet res = state.executeQuery("SELECT COUNT(*) AS nb FROM "+table);
			res.next();
		    nombre=res.getInt("nb");
		    res.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
	}
	
	public int insertRapport(String[] args){
		int res=0;
		int numRap=Integer.parseInt(args[1]);
		int numPrat=Integer.parseInt(args[2]);		
		try {
			Statement state = conn.createStatement();
			PreparedStatement resultat = conn.prepareStatement("INSERT into rapport_visite VALUES(?, ?, ?, ?, ?, ?)");
			resultat.setString(1, args[0]);
			resultat.setInt(2, numRap);
			resultat.setInt(3, numPrat);
			resultat.setString(4, args[3]);
			resultat.setString(5, args[4]);
			resultat.setString(6, args[5]);
			res=resultat.executeUpdate();
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int insertMedicaments(List<Object> args){
		int res=0;		
		try {
			Statement state = conn.createStatement();
			PreparedStatement resultat = conn.prepareStatement("INSERT into medicament VALUES(?, ?, ?, ?, ?, ?, ?)");
			resultat.setString(1, args.get(0).toString());
			resultat.setString(2, args.get(1).toString());
			resultat.setString(3, args.get(2).toString());
			resultat.setString(4, args.get(3).toString());
			resultat.setString(5, args.get(4).toString());
			resultat.setString(6, args.get(5).toString());
			resultat.setString(7, args.get(6).toString());
			res=resultat.executeUpdate();
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int insertPraticien(List<Object> args){
		int res=0;		
		try {
			Statement state = conn.createStatement();
			PreparedStatement resultat = conn.prepareStatement("INSERT into praticien(PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_CODE) VALUES(?, ?, ?, ?, ?, ?, ?)");
			resultat.setString(1, args.get(0).toString());
			resultat.setString(2, args.get(1).toString());
			resultat.setString(3, args.get(2).toString());
			resultat.setString(4, args.get(3).toString());
			resultat.setString(5, args.get(4).toString());
			resultat.setString(6, args.get(5).toString());
			resultat.setString(7, args.get(6).toString());
			res=resultat.executeUpdate();
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public int insertOffres(String Vismat, String RapNum, String[][] prod){
		int res=0;
		try {
			Statement state = conn.createStatement();
			PreparedStatement resultat = conn.prepareStatement("INSERT into offrir VALUES(?, ?, ?, ?)");
			for(int i=0; i<prod.length; i++){
				int qte=Integer.parseInt(prod[i][1]);
				String produit=prod[i][0];
				resultat.setString(1, Vismat);
				resultat.setString(2, RapNum);
				resultat.setString(3, produit);
				resultat.setInt(4, qte);
				res+=resultat.executeUpdate();
			}
			
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public String[] recupDetailsPraticien(String[] prat){
		String[] res=null;
		try {
			Statement state = conn.createStatement();
			PreparedStatement resultat = conn.prepareStatement("SELECT PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, type_praticien.TYP_LIBELLE "+
																"FROM praticien INNER JOIN type_praticien ON type_praticien.TYP_CODE=praticien.TYP_CODE "+
																"AND PRA_NOM=? AND PRA_PRENOM=?");
				resultat.setString(1, prat[0]);
				resultat.setString(2, prat[1]);
				ResultSet result = resultat.executeQuery();
				ResultSetMetaData resMeta=result.getMetaData();
				
				res=new String[resMeta.getColumnCount()];
				result.next();
				for(int i=1; i<=resMeta.getColumnCount(); i++){
					res[i-1]=result.getObject(i).toString();
				}
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<String> recupDatesRapport(String Vismat){
		ArrayList<String> res=null;
		try {
			Statement state = conn.createStatement();		
			PreparedStatement resultat = conn.prepareStatement("SELECT DISTINCT RAP_DATE FROM rapport_visite where VIS_MATRICULE=? ORDER BY RAP_DATE ASC");
				resultat.setString(1, Vismat);
				ResultSet result = resultat.executeQuery();
				res=new ArrayList<String>();
				do{
					result.next();
					//Mise en forme de la date
					String[] date=result.getObject(1).toString().split("-");
					res.add(date[2]+"/"+date[1]+"/"+date[0]);			
				}
				while(!result.isLast());
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<String> recupVisRapportResp(String labo, String secCode){
		ArrayList<String> res=null;
		//System.out.println("labo :"+labo+" SecCode :"+secCode);
		try {
			Statement state = conn.createStatement();
			//Récupération du nb de lignes dans le jeu de résultat//
			ResultSet resu = state.executeQuery("SELECT COUNT(*) AS nb FROM visiteur WHERE VIS_MATRICULE IN ( "+
												"SELECT VIS_MATRICULE FROM travailler, region "+
												"WHERE region.REG_CODE = travailler.REG_CODE "+
												"AND (TRA_ROLE =  'Visiteur' || TRA_ROLE =  'Délégué') "+
												"AND region.SEC_CODE =  '"+secCode+"'"+
												"AND LAB_CODE =  '"+labo+"' )");
			resu.next();
		    int nblignes=resu.getInt("nb");
		    resu.close();
			PreparedStatement resultat = conn.prepareStatement("SELECT DISTINCT visiteur.VIS_MATRICULE, visiteur.VIS_NOM, VIS_PRENOM "+
			"FROM visiteur WHERE VIS_MATRICULE IN ( "+
			"SELECT VIS_MATRICULE FROM travailler, region "+
			"WHERE region.REG_CODE = travailler.REG_CODE "+
			"AND (TRA_ROLE =  'Visiteur' || TRA_ROLE =  'Délégué') "+
			"AND region.SEC_CODE =  ? "+
			"AND LAB_CODE =  ? )");
				resultat.setString(1, secCode);
				resultat.setString(2, labo);
				ResultSet result = resultat.executeQuery();
				res=new ArrayList<String>();
			if(nblignes > 0){
				if(!result.isAfterLast()){
					do{
						result.next();
						//Mise en forme du rapport
						res.add(result.getObject(1).toString()+";"+result.getObject(2).toString()+";"+result.getObject(3).toString());			
					}
					while(!result.isLast());
				}
			}
				result.close();
			state.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<String> recupVisRapportDel(String regCode){
		ArrayList<String> res=null;
		//System.out.println("REGCODE :"+regCode);
		try {
			Statement state = conn.createStatement();
			ResultSet resu = state.executeQuery("SELECT COUNT(*) AS nb FROM visiteur WHERE VIS_MATRICULE IN "+
																"( SELECT VIS_MATRICULE FROM travailler " +
																"WHERE (TRA_ROLE =  'Visiteur' || TRA_ROLE =  'Délégué')" +
																"AND REG_CODE =  '"+regCode+"' )");
			resu.next();
			int nblignes=resu.getInt("nb");
			resu.close();
			PreparedStatement resultat = conn.prepareStatement("SELECT DISTINCT visiteur.VIS_MATRICULE, visiteur.VIS_NOM, VIS_PRENOM "+
																"FROM visiteur WHERE VIS_MATRICULE IN "+
																"( SELECT VIS_MATRICULE FROM travailler " +
																"WHERE (TRA_ROLE =  'Visiteur' || TRA_ROLE =  'Délégué')" +
																"AND REG_CODE =  ? )");
				resultat.setString(1, regCode);
				ResultSet result = resultat.executeQuery();
				res=new ArrayList<String>();
			if(nblignes > 0){
				if(!result.isAfterLast()){
					do{
						result.next();
						//Mise en forme du visiteur
						res.add(result.getObject(1).toString()+";"+result.getObject(2).toString()+";"+result.getObject(3).toString());			
						
					}
					while(!result.isLast());
				}			
				state.close();
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList<String> recupRapportParDate(String Date, String VisMat){
		ArrayList<String> res = new ArrayList<String>();
		int colonnes=0;
		//Mise en forme de la date//
		String DateFormat[]=Date.split("/");
		if(DateFormat.length > 2){
			Date=DateFormat[2]+"-"+DateFormat[1]+"-"+DateFormat[0];
			try {
				Statement state = conn.createStatement();	
				ResultSet result;
				PreparedStatement resultat = conn.prepareStatement("SELECT * FROM rapport_visite " +
																	"INNER JOIN praticien ON " +
																	"praticien.PRA_NUM=rapport_visite.PRA_NUM "+
																	"AND RAP_DATE = ? "+
																	"AND VIS_MATRICULE= ?");
					resultat.setString(1, Date);
					resultat.setString(2, VisMat);
					
					result = resultat.executeQuery();
					ResultSetMetaData resMeta=result.getMetaData();
					
					colonnes=resMeta.getColumnCount();

					do{
						String rapport="";
						result.next();
						
						for(int i=1; i<=colonnes; i++){
							rapport+=";"+result.getObject(i).toString();
						}	
						res.add(rapport);
					}
					while(!result.isLast());
				state.close();
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return res;
	}
	
	public ArrayList<String> recupRapportParVis(String Vis){
		ArrayList<String> res = new ArrayList<String>();
		int colonnes=0;
		//Mise en forme visiteur//
		String visiteur[]=Vis.split(" ");
		if(visiteur.length > 1){
			String visnom, visprenom;
			visnom=visiteur[0];
			visprenom=visiteur[1];
			System.out.println("nom :"+visnom+" prenom :"+visprenom);
			try {
				Statement state = conn.createStatement();	
				ResultSet result;
				PreparedStatement resultat = conn.prepareStatement("SELECT * FROM rapport_visite INNER JOIN praticien ON praticien.PRA_NUM = rapport_visite.PRA_NUM AND VIS_MATRICULE in "+
																	"(SELECT VIS_MATRICULE FROM visiteur WHERE VIS_NOM = ? " +
																	"AND VIS_PRENOM=? )");
					resultat.setString(1, visnom);
					resultat.setString(2, visprenom);
					
					result = resultat.executeQuery();
					ResultSetMetaData resMeta=result.getMetaData();
					
					colonnes=resMeta.getColumnCount();
					if(result.next()){
						String rapport;
						while(!result.isLast()){
							rapport="";					
							for(int i=1; i<=colonnes; i++){
								rapport+=";"+result.getObject(i).toString();
							}	
							res.add(rapport);
							result.next();
						}
						if(result.isLast()){
							rapport="";					
							for(int i=1; i<=colonnes; i++){
								rapport+=";"+result.getObject(i).toString();
							}	
							res.add(rapport);
							result.next();
						}
					}
				state.close();
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return res;
	}
	
	public Object[][] recupOffres(int RapNum, String VisMat){
		Object[][] res = null;
		int lignes=0;
		int colonnes=0;
			try {
				Statement state = conn.createStatement();	
				ResultSet result = state.executeQuery("SELECT COUNT(*) AS nb FROM offrir WHERE RAP_NUM="+RapNum+" AND VIS_MATRICULE='"+VisMat+"'");
				result.next();
			     lignes=result.getInt("nb");
			     result.close();
			     if(lignes>0){
			    	 PreparedStatement resultat = conn.prepareStatement("SELECT * FROM offrir WHERE RAP_NUM=? AND VIS_MATRICULE=?");
						resultat.setInt(1, RapNum);
						resultat.setString(2, VisMat);
						
						result = resultat.executeQuery();
						ResultSetMetaData resMeta=result.getMetaData();
						
						colonnes=resMeta.getColumnCount();
						System.out.println("Lignes (fonction) :"+lignes);
						
						res=new Object[lignes][colonnes];
						int j=0;
						do{
							result.next();
							
							for(int i=1; i<=colonnes; i++){
								res[j][i-1]= result.getObject(i);
							}	
							j++;
						}
						while(!result.isLast());
			     }
			     state.close();
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getMessage();
			}
			
		return res;
	}
}
