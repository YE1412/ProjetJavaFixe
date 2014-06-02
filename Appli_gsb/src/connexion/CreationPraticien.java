package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;

public class CreationPraticien {

	private JFrame frmNouveauPraticien;
	private JPanel panel;
	private JLabel lblInsertionDunNouveau;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JLabel lblNomDuPraticien;
	private JLabel lblPrenomDuPraticien;
	private JLabel lblNewLabel;
	private JLabel lblVilleDeResidence;
	private JLabel lblCodePostal;
	private JLabel lblCoefficientNotorit;
	private JLabel lblCodeType;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<String> comboBox;
	private JTextPane textPane;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JPanel panel_16;
	private JButton btnRetour;
	private JButton btnAnnuler;
	private JButton btnEnvoyer;
	private String[] arg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String[] visRes=new String[]{"p40", "Michel", "Responsable", "O", "SW"};
					//String[] visVis=new String[]{"a131", "Villechalane", "Visiteur"};
					String[] visDel=new String[]{"a17", "Andre","Délégué", "GY", "RA"};
					CreationPraticien window = new CreationPraticien(visDel);
					window.frmNouveauPraticien.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreationPraticien(String[] args) {
		initialize(args);
		frmNouveauPraticien.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arguments) {
		this.arg=arguments;
		frmNouveauPraticien = new JFrame();
		frmNouveauPraticien.setTitle("Nouveau Praticien");
		frmNouveauPraticien.setBounds(100, 100, 674, 458);
		frmNouveauPraticien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauPraticien.getContentPane().setLayout(null);
		frmNouveauPraticien.getContentPane().add(getPanel());
		frmNouveauPraticien.getContentPane().add(getPanel_1());
		frmNouveauPraticien.getContentPane().add(getPanel_16());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 657, 24);
			panel.add(getLblInsertionDunNouveau());
		}
		return panel;
	}
	private JLabel getLblInsertionDunNouveau() {
		if (lblInsertionDunNouveau == null) {
			lblInsertionDunNouveau = new JLabel("Insertion d'un nouveau praticien dans la base");
		}
		return lblInsertionDunNouveau;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(Color.BLACK, 1, true));
			panel_1.setBounds(0, 31, 657, 334);
			panel_1.setLayout(new GridLayout(7, 2, 0, 0));
			panel_1.add(getPanel_2());
			panel_1.add(getPanel_3());
			panel_1.add(getPanel_4());
			panel_1.add(getPanel_5());
			panel_1.add(getPanel_6());
			panel_1.add(getPanel_7());
			panel_1.add(getPanel_8());
			panel_1.add(getPanel_9());
			panel_1.add(getPanel_10());
			panel_1.add(getPanel_11());
			panel_1.add(getPanel_12());
			panel_1.add(getPanel_13());
			panel_1.add(getPanel_14());
			panel_1.add(getPanel_15());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getLblNomDuPraticien(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.add(getTextField());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getLblPrenomDuPraticien());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.add(getTextField_1());
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new BorderLayout(0, 0));
			panel_6.add(getLblNewLabel());
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setLayout(null);
			panel_7.add(getTextPane());
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(new BorderLayout(0, 0));
			panel_8.add(getLblVilleDeResidence());
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(null);
			panel_9.add(getTextField_2());
		}
		return panel_9;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setLayout(new BorderLayout(0, 0));
			panel_10.add(getLblCodePostal());
		}
		return panel_10;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(null);
			panel_11.add(getFormattedTextField());
		}
		return panel_11;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(new BorderLayout(0, 0));
			panel_12.add(getLblCoefficientNotorit());
		}
		return panel_12;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(null);
			panel_13.add(getFormattedTextField_1());
		}
		return panel_13;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setLayout(new BorderLayout(0, 0));
			panel_14.add(getLblCodeType());
		}
		return panel_14;
	}
	private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.setLayout(null);
			panel_15.add(getComboBox());
		}
		return panel_15;
	}
	private JLabel getLblNomDuPraticien() {
		if (lblNomDuPraticien == null) {
			lblNomDuPraticien = new JLabel("Nom du praticien :");
			lblNomDuPraticien.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNomDuPraticien;
	}
	private JLabel getLblPrenomDuPraticien() {
		if (lblPrenomDuPraticien == null) {
			lblPrenomDuPraticien = new JLabel("Prenom du praticien :");
			lblPrenomDuPraticien.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPrenomDuPraticien;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Adresse du praticien :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JLabel getLblVilleDeResidence() {
		if (lblVilleDeResidence == null) {
			lblVilleDeResidence = new JLabel("Ville :");
			lblVilleDeResidence.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblVilleDeResidence;
	}
	private JLabel getLblCodePostal() {
		if (lblCodePostal == null) {
			lblCodePostal = new JLabel("Code Postal :");
			lblCodePostal.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCodePostal;
	}
	private JLabel getLblCoefficientNotorit() {
		if (lblCoefficientNotorit == null) {
			lblCoefficientNotorit = new JLabel("Coefficient Notori\u00E9t\u00E9 :");
			lblCoefficientNotorit.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCoefficientNotorit;
	}
	private JLabel getLblCodeType() {
		if (lblCodeType == null) {
			lblCodeType = new JLabel("Code Type :");
			lblCodeType.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCodeType;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(0, 11, 145, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(0, 11, 145, 20);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(0, 11, 145, 20);
		}
		return textField_2;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.addItem("Code Type :");
			comboBox.addItem("MH");
			comboBox.addItem("MV");
			comboBox.addItem("PH");
			comboBox.addItem("PO");
			comboBox.addItem("PS");
			comboBox.setBounds(0, 11, 109, 20);
		}
		return comboBox;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(0, 11, 159, 36);
		}
		return textPane;
	}
	private JFormattedTextField getFormattedTextField() {
		if (formattedTextField == null) {
			MaskFormatter masque = null;
			try {
				masque=new MaskFormatter("#####");
			} catch (ParseException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
			 
			formattedTextField = new JFormattedTextField();
			formattedTextField.setBounds(0, 11, 60, 20);
			masque.install(formattedTextField);
			
		}
		return formattedTextField;
	}
	private JFormattedTextField getFormattedTextField_1() {
		if (formattedTextField_1 == null) {
			MaskFormatter masque = null;
			try {
				masque=new MaskFormatter("####.##");
			} catch (ParseException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
			formattedTextField_1 = new JFormattedTextField();
			formattedTextField_1.setBounds(0, 11, 60, 20);
			masque.install(formattedTextField_1);
		}
		return formattedTextField_1;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setBounds(0, 369, 657, 50);
			panel_16.add(getBtnRetour());
			panel_16.add(getBtnAnnuler());
			panel_16.add(getBtnEnvoyer());
		}
		return panel_16;
	}
	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			ActionBout Action=new ActionBout(btnRetour);
			Action.retour();
		}
		return btnRetour;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			ActionBout action = new ActionBout(btnAnnuler);
			action.annuler();
		}
		return btnAnnuler;
	}
	private JButton getBtnEnvoyer() {
		if (btnEnvoyer == null) {
			btnEnvoyer = new JButton("Envoyer");
			ActionBout action=new ActionBout(btnEnvoyer);
			action.envoyer();
		}
		return btnEnvoyer;
	}
	//_______________________________________ACTION DES BOUTTONS________________________________________________//
	public class ActionBout{
		private JButton boutton;
		
		public ActionBout(JButton bout){
			this.boutton=bout;
		}
		
		public void retour(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmNouveauPraticien.dispose();
					switch(arg[2])
					{
						case "Visiteur":
							new MenuPrincipalV(arg);
							break;
						default:
							new MenuPrincipal(arg);
							break;
					}
				}
			});
		}
		
		public void annuler(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nom, prenom, adresse, ville, cp, coeff;
					nom="";	
					prenom="";
					adresse="";
					ville="";
					cp="";
					coeff="";
					
					getTextField().setText(nom);
					getTextField_1().setText(prenom);
					getTextPane().setText(adresse);
					getTextField_2().setText(ville);
					getFormattedTextField().setText(cp);
					getFormattedTextField_1().setText(coeff);
					getComboBox().setSelectedIndex(0);
				}
			});
		}
		
		public void envoyer(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("CP :'"+getFormattedTextField().getText()+"' COEFF :'"+getFormattedTextField_1().getText()+"'");		}
					//Récupération des Champs//
					String nom, prenom, adresse, ville, cp, coeff, type;
					nom=getTextField().getText();
					prenom=getTextField_1().getText();
					adresse=getTextPane().getText();
					ville=getTextField_2().getText();
					cp=getFormattedTextField().getText();
					coeff=getFormattedTextField_1().getText().replaceAll("\\+", "");
					type=getComboBox().getSelectedItem().toString();
					List<Object> champs=new ArrayList<Object>();
					for(int i=0; i<7; i++){
						switch(i){
						case 0:
							champs.add(nom);
							break;
						case 1:
							champs.add(prenom);
							break;
						case 2:
							champs.add(adresse);
							break;
						case 3:
							champs.add(cp);
							break;
						case 4:
							champs.add(ville);
							break;
						case 5:
							champs.add(coeff);
							break;
						case 6:
							champs.add(type);
							break;
						default:
							break;
							
						}
					}
					//Vérification des données é envoyer//
					int j=0;
					String[] resultat=VerifChamps(champs);
					for(String val:resultat){
						System.out.println("Resultat Verif "+j+": "+val);
						if(val=="false"){
							j++;
						}
					}
					if(j==0){
						//INSERTION DU NOUVEAU PRATICIEN//
						String res=null;
						List<String> keys = new ArrayList<String>();
						keys.add("tag");
						keys.add("PRA_NOM");
						keys.add("PRA_PRENOM");
						keys.add("PRA_ADRESSE");
						keys.add("PRA_CP");
						keys.add("PRA_VILLE");
						keys.add("PRA_COEFF");
						keys.add("PRA_TYPE");
						List<String> values = new ArrayList<String>();
						values.add("insertPraticien");
						values.add(champs.get(0).toString());
						values.add(champs.get(1).toString());
						values.add(champs.get(2).toString());
						values.add(champs.get(3).toString());
						values.add(champs.get(4).toString());
						values.add(champs.get(5).toString());
						values.add(champs.get(6).toString());
						res=ConnexionHTTP.post(keys, values);
						//Mise en forme de la réponse XML//
						res=res.substring(3);
						XMLtraitement treat=null;
						Map<String, Map<Integer, List<String>>> hash=null;
						//System.out.println(res.charAt(3));
						try {
							treat=new XMLtraitement(res);
						} catch (UnsupportedEncodingException
								| ParserConfigurationException f) {
							// TODO Bloc catch généré automatiquement
							f.printStackTrace();
						}
						
						try {
							hash=treat.retourneDonnees();
						} catch (UnsupportedEncodingException f) {
							// TODO Bloc catch généré automatiquement
							JOptionPane.showMessageDialog(null, "Erreur technique lors du traitement des données du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
							f.printStackTrace();
						}
						Map<Integer, List<String>> result=hash.get("Donnees");
						/*System.out.println(hash.size());
						System.out.println(resultat.size());*/
						List<String> verrif=result.get(0);
						System.out.println(verrif.get(0));
						if(verrif.get(0).equals("Erreur lors de l'insertion du praticien !"))
						{
							JOptionPane.showMessageDialog(null, "Erreur technique lors de l'insertion du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Succès de l'insertion du praticien "+nom+" "+prenom+" dans la base !","Information", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Il manque "+j+" Champs à renseigner","Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
		}
		
		private String[] VerifChamps(List<Object> donnees){
			String[] tab=new String[7];
			int j=0;
			for(Object champ:donnees){
				System.out.println("Données a verif "+j+": '"+champ.toString()+"'");
				switch(j){
				case 3: //Cas du JFormattedTextField CP qui est nom null à l'initialisation
						if(!champ.toString().equals("     ")){
							tab[j]="true";
						}
						else{
							tab[j]="false";
						}
					break;
				case 5: //Cas du JFormattedTextField COEFF qui est nom null à l'initialisation
					if(!champ.toString().equals("    .  ")){
						tab[j]="true";
					}
					else{
						tab[j]="false";
					}
					break;
				case 6:
					if(!champ.toString().equals("Code Type :")){
						tab[j]="true";
					}
					else{
						tab[j]="false";
					}
					break;
					default:
						if(!champ.toString().equals("")){
							tab[j]="true";
						}
						else{
							tab[j]="false";
						}
				}
				j++;
			}
			return tab;
		}
	}
	
	
}
