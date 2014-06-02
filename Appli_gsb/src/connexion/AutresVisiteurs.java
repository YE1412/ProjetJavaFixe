package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.xml.parsers.ParserConfigurationException;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;

public class AutresVisiteurs {

	private JFrame frmAutresVisiteurs;
	private String[] args; 
	private JPanel panel;
	private JLabel lblSlectionner;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblDpt;
	private JComboBox<String> comboBox;
	private JPanel panel_5;
	private JButton btnNewButton;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblVisiteur;
	private JComboBox<String> comboBox_1;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	//private JPanel panel_20;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblAdresse;
	private JLabel lblCodePostal;
	private JLabel lblNewLabel;
	private JLabel lblSecteur;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane textPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFormattedTextField formattedTextField;
	private JPanel panel_21;
	/*private JButton btnNewButton_1;
	private JButton btnNewButton_2;*/
	private ArrayList<Utilisateur> utilisateurs;
	private ListeDonnees listing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] visRes=new String[]{"p40", "Michel", "Responsable", "O", "SW"};
					//String[] visVis=new String[]{"a131", "Villechalane", "Visiteur"};
					//String[] visDel=new String[]{"a17", "Andre","Délégué", "GY", "RA"};
					AutresVisiteurs window = new AutresVisiteurs(visRes);
					window.frmAutresVisiteurs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutresVisiteurs(String[] arg) {
		initialize(arg);
		frmAutresVisiteurs.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arguments) {
		this.args=arguments;
		recupAllVisiteurs();
		//System.out.println(utilisateurs.size());
		frmAutresVisiteurs = new JFrame();
		frmAutresVisiteurs.setTitle("Autres Visiteurs");
		frmAutresVisiteurs.setBounds(100, 100, 784, 566);
		frmAutresVisiteurs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getPanel_2().setVisible(false);
		frmAutresVisiteurs.getContentPane().add(getPanel(), BorderLayout.NORTH);
		frmAutresVisiteurs.getContentPane().add(getPanel_1(), BorderLayout.WEST);
		frmAutresVisiteurs.getContentPane().add(getPanel_2(), BorderLayout.CENTER);
		frmAutresVisiteurs.getContentPane().add(getPanel_5(), BorderLayout.SOUTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblSlectionner());
		}
		return panel;
	}
	private JLabel getLblSlectionner() {
		if (lblSlectionner == null) {
			lblSlectionner = new JLabel("S\u00E9lectionner le d\u00E9partement de r\u00E9sidence du visiteur");
		}
		return lblSlectionner;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			panel_1.add(getPanel_3());
			panel_1.add(getPanel_4());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getPanel_6());
			panel_2.add(getPanel_7());
			//panel_2.add(getPanel_20());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblDpt());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_4.add(getComboBox());
		}
		return panel_4;
	}
	private JLabel getLblDpt() {
		if (lblDpt == null) {
			lblDpt = new JLabel("D\u00E9partement :");
		}
		return lblDpt;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			ActionCOMBO action=new ActionCOMBO(comboBox);
			action.remplissage("departements");
			action.recupVisiteurs();
		}
		return comboBox;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_5.add(getBtnNewButton());
		}
		return panel_5;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Retour");
			ActionBouttons action = new ActionBouttons(btnNewButton);
			action.retour();
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return btnNewButton;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBounds(0, 1, 582, 36);
			panel_6.setLayout(new GridLayout(1, 2, 0, 0));
			panel_6.add(getLblVisiteur());
			panel_6.add(getPanel_21());
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel_7.setBounds(0, 59, 582, 372);
			panel_7.setLayout(new GridLayout(6, 2, 0, 0));
			panel_7.add(getPanel_19());
			panel_7.add(getPanel_18());
			panel_7.add(getPanel_17());
			panel_7.add(getPanel_16());
			panel_7.add(getPanel_15());
			panel_7.add(getPanel_14());
			panel_7.add(getPanel_13());
			panel_7.add(getPanel_8());
			panel_7.add(getPanel_9());
			panel_7.add(getPanel_10());
			panel_7.add(getPanel_11());
			panel_7.add(getPanel_12());
		}
		return panel_7;
	}
	private JLabel getLblVisiteur() {
		if (lblVisiteur == null) {
			lblVisiteur = new JLabel("Visiteur :");
			lblVisiteur.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblVisiteur;
	}
	private JComboBox<String> getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox<String>();
		}
		return comboBox_1;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(null);
			panel_8.add(getFormattedTextField());
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(new BorderLayout(0, 0));
			panel_9.add(getLblNewLabel());
		}
		return panel_9;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setLayout(null);
			panel_10.add(getTextField_2());
		}
		return panel_10;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(new BorderLayout(0, 0));
			panel_11.add(getLblSecteur());
		}
		return panel_11;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(null);
			panel_12.add(getTextField_3());
		}
		return panel_12;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(new BorderLayout(0, 0));
			panel_13.add(getLblCodePostal());
		}
		return panel_13;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setLayout(null);
			panel_14.add(getTextPane());
		}
		return panel_14;
	}
	private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.setLayout(new BorderLayout(0, 0));
			panel_15.add(getLblAdresse());
		}
		return panel_15;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setLayout(null);
			panel_16.add(getTextField_1());
		}
		return panel_16;
	}
	private JPanel getPanel_17() {
		if (panel_17 == null) {
			panel_17 = new JPanel();
			panel_17.setLayout(new BorderLayout(0, 0));
			panel_17.add(getLblPrenom());
		}
		return panel_17;
	}
	private JPanel getPanel_18() {
		if (panel_18 == null) {
			panel_18 = new JPanel();
			panel_18.setLayout(null);
			panel_18.add(getTextField());
		}
		return panel_18;
	}
	private JPanel getPanel_19() {
		if (panel_19 == null) {
			panel_19 = new JPanel();
			panel_19.setLayout(new BorderLayout(0, 0));
			panel_19.add(getLblNom());
		}
		return panel_19;
	}
	/*private JPanel getPanel_20() {
		if (panel_20 == null) {
			panel_20 = new JPanel();
			panel_20.setBounds(0, 433, 582, 36);
			panel_20.add(getBtnNewButton_1());
			panel_20.add(getBtnNewButton_2());
		}
		return panel_20;
	}*/
	private JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom :");
			lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNom;
	}
	private JLabel getLblPrenom() {
		if (lblPrenom == null) {
			lblPrenom = new JLabel("Prenom :");
			lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPrenom;
	}
	private JLabel getLblAdresse() {
		if (lblAdresse == null) {
			lblAdresse = new JLabel("Adresse :");
			lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAdresse;
	}
	private JLabel getLblCodePostal() {
		if (lblCodePostal == null) {
			lblCodePostal = new JLabel("Code Postal :");
			lblCodePostal.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCodePostal;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ville :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JLabel getLblSecteur() {
		if (lblSecteur == null) {
			lblSecteur = new JLabel("Secteur :");
			lblSecteur.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblSecteur;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(10, 20, 98, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(10, 11, 100, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(10, 5, 167, 45);
		}
		return textPane;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(10, 11, 115, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(10, 11, 94, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JFormattedTextField getFormattedTextField() {
		if (formattedTextField == null) {
			formattedTextField = new JFormattedTextField();
			formattedTextField.setBounds(10, 11, 69, 20);
		}
		return formattedTextField;
	}
	private JPanel getPanel_21() {
		if (panel_21 == null) {
			panel_21 = new JPanel();
			panel_21.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_21.add(getComboBox_1());
		}
		return panel_21;
	}
	/*private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Pr\u00E9cedent");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Suivant");
		}
		return btnNewButton_2;
	}*/
	
	//______________________________________ACTION DES COMBOBOX_______________________________________//
	public class ActionCOMBO{
		private JComboBox<String> cb;
		
		public ActionCOMBO(JComboBox<String> combo){
			cb=combo;
		}
		
		public void remplissage(String type){
				ArrayList<String> comb=null;
				String str=null;
				List<String> keys = null, values=null;
				XMLtraitement treat=null;
				Map<String, Map<Integer, List<String>>> hash=null;
				int i=1;
				switch(type){
				case "departements":
					keys=new ArrayList<String>();
					values=new ArrayList<String>();
					keys.add("tag");
					values.add("recupDpt");
					str=ConnexionHTTP.post(keys, values);
					//------------------------TRAITEMENT DU FICHIER XML RETOUNE-----------------------//
		//-------------------------------------------------------------------------------------------------------------------//			
					str=str.substring(3);
					
					try {
						treat=new XMLtraitement(str);
					} catch (UnsupportedEncodingException
							| ParserConfigurationException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
	
					try {
						hash=treat.retourneDonnees();
					} catch (UnsupportedEncodingException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
			//---------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------//
					Map<Integer, List<String>> departements=hash.get("Donnees");
					comb=new ArrayList<String>();
					comb.add(0, "Choisir Département :");
					for(Integer key:departements.keySet())
					{
						ArrayList<String> Ddpt=(ArrayList<String>) departements.get(key);
						if(departements.size()>1)
						{	
							//System.out.println(praticiens.get(key));
							//System.out.println(Dpra.get(1));
							//System.out.println(key);
							comb.add(i, "("+Ddpt.get(0)+") "+Ddpt.get(1));
						}
						else
						{
							comb.add(i, Ddpt.get(0));
						}
						i++;
					}
					listing=new ListeDonnees(comb);
					for(int j=0; j<listing.getNbDonnees(); j++)
					{
						//System.out.println(listing.getDonnee(j));
						cb.addItem(listing.getDonnee(j));
					}
					cb.setBounds(135, 109, 160, 20);	
					break;
				case "visiteurs":
					int deb, fin;
					String num;
					deb=comboBox.getSelectedItem().toString().indexOf("(");
					fin=comboBox.getSelectedItem().toString().indexOf(")");
					num=comboBox.getSelectedItem().toString().substring(deb+1, fin);
					//System.out.println(num);
					comb=new ArrayList<String>();
					for(Utilisateur someone:utilisateurs)
					{
						String mefCP=String.valueOf(someone.getCP()).substring(0, 2);
						System.out.println(mefCP);
						if(mefCP.equals(num))
						{
							comb.add("("+someone.getMatricule()+") "+someone.getNom()+" "+someone.getPrenom());
						}
					}
					if(comb.size()>0)
					{
						comb.add(0, "Choisir le Visiteur :");
						listing=new ListeDonnees(comb);
						cb.removeAllItems();
						for(int j=0; j<listing.getNbDonnees(); j++)
						{
							//System.out.println(listing.getDonnee(j));
							cb.addItem(listing.getDonnee(j));
						}
						getPanel_7().setVisible(false);
						//getPanel_20().setVisible(false);
						getPanel_2().setVisible(true);
						frmAutresVisiteurs.setBounds(100, 100, 1200, 566);
					}
					else
					{
						//Cas où la le départements choisie est celui par défaut//
						getPanel_2().setVisible(false);
					}
					default:
					break;
				}
				
		}
		
		public void recupVisiteurs(){
			cb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(!arg0.getItem().equals("Choisir Département :")){
						ActionCOMBO action=new ActionCOMBO(getComboBox_1());						
						action.remplissage("visiteurs");
						action.recupInfosVisiteurs();
					}					
				}
			});
		}
		public void recupInfosVisiteurs(){
			cb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(arg0.getItem().equals("Choisir le Visiteur :")){
						getPanel_7().setVisible(false);
						//getPanel_20().setVisible(false);
					}
					else{
						int deb, fin;
						//System.out.println(arg0.getItem().toString());
						deb=arg0.getItem().toString().indexOf("(");
						fin=arg0.getItem().toString().indexOf(")");
						String vismat=arg0.getItem().toString().substring(deb+1, fin);
						Utilisateur selectUtil=null;
						//System.out.println(vismat);
						for(Utilisateur util:utilisateurs){
							if(util.getMatricule().equals(vismat))
							{
								selectUtil=util;
								break;
							}
						}
						getTextField().setText(selectUtil.getNom());
						
						getTextField_1().setText(selectUtil.getPrenom());
						
						getTextPane().setText(selectUtil.getAdresse());
						
						getFormattedTextField().setText(String.valueOf(selectUtil.getCP()));
						
						getTextField_2().setText(selectUtil.getVille());
						getTextField_3().setText(selectUtil.getLibelleSecteur());
						getPanel_7().setVisible(true);						
					}
				}
			});
		}
	}
	//________________________________________________________________________________________________//
	//_________________________________ACTION DES BOUTTONS______________________________________________//
	public class ActionBouttons{
		private JButton bout;
		
		public ActionBouttons(JButton boutton){
			bout=boutton;
		}
		
		public void retour(){
			bout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmAutresVisiteurs.dispose();
					new MenuPrincipal(args);
				}
			});
		}
	}
	//_________________________________________________________________________________________________//
	public void recupAllVisiteurs()
	{
		String str=null;
		List<String> keys = null, values=null;
		XMLtraitement treat=null;
		Map<String, Map<Integer, List<String>>> hash=null;
		
		keys=new ArrayList<String>();
		values=new ArrayList<String>();
		keys.add("tag");		
		values.add("recupVisiteurs");
		
		if(args[2]=="Responsable")
		{
			//CAS D'UN RESPONSABLE//
			keys.add("sec_code");
			values.add(args[3]);
			keys.add("lab_code");
			values.add(args[4]);
		}
		else
		{
			//CAS D'UN DELEGUE//
			keys.add("reg_code");
			values.add(args[4]);
		}
		str=ConnexionHTTP.post(keys, values);
		//------------------------TRAITEMENT DU FICHIER XML RETOUNE-----------------------//
//-------------------------------------------------------------------------------------------------------------------//
		str=str.substring(3);
		//System.out.println(str);
		
		
		try {
			treat=new XMLtraitement(str);
		} catch (UnsupportedEncodingException
				| ParserConfigurationException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}

		try {
			hash=treat.retourneDonnees();
		} catch (UnsupportedEncodingException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
//---------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------//
		//Remplissage de la combobox//
		Map<Integer, List<String>> Allutilisateurs=hash.get("Donnees");
		utilisateurs=new ArrayList<Utilisateur>();
		for(Integer key:Allutilisateurs.keySet())
		{
			if(Allutilisateurs.size()>1)
			{	
				ArrayList<String> DUtil=(ArrayList<String>) Allutilisateurs.get(key);
				Utilisateur util=new Utilisateur(DUtil.get(0), DUtil.get(1), DUtil.get(2), DUtil.get(3), Long.valueOf(DUtil.get(4)), DUtil.get(5), DUtil.get(6), DUtil.get(9), DUtil.get(7));
				utilisateurs.add(util);
				
				//System.out.println(DUtil.get(0)+" "+DUtil.get(1)+" "+DUtil.get(2)+" "+DUtil.get(3)+" "+DUtil.get(4)+" "+DUtil.get(5)+" "+DUtil.get(6)+" "+DUtil.get(7)+" "+DUtil.get(9));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erreur technique lors de la récupération des visiteurs", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
