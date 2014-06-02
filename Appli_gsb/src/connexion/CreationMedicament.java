package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.JComboBox;

public class CreationMedicament {

	private JFrame frmCrationdeMdicaments;
	private JPanel panel;
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
	private JPanel panel_16;
	private JLabel lblNewLabel;
	private JLabel lblDepotLegal;
	private JLabel lblFamille;
	private JLabel lblComposition;
	private JLabel lblEffets;
	private JLabel lblContreIndications;
	private JLabel lblPrixEchantillon;
	private JComboBox<String> textPane_2;
	private JTextPane textPane_1;
	private JTextPane textPane_3;
	private JTextPane textPane_4;
	private JFormattedTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnAnnuler;
	private JButton btnEnvoyer;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private String[] arguments;

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
					CreationMedicament window = new CreationMedicament(visDel);
					window.frmCrationdeMdicaments.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreationMedicament(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arg) {
		this.arguments=arg;
		frmCrationdeMdicaments = new JFrame();
		frmCrationdeMdicaments.setTitle("Cr\u00E9ation de m\u00E9dicaments");
		frmCrationdeMdicaments.setBounds(100, 100, 632, 497);
		frmCrationdeMdicaments.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrationdeMdicaments.getContentPane().setLayout(null);
		frmCrationdeMdicaments.getContentPane().add(getPanel());
		frmCrationdeMdicaments.getContentPane().add(getPanel_2());
		frmCrationdeMdicaments.getContentPane().add(getPanel_1());
		frmCrationdeMdicaments.setVisible(true);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 616, 29);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLblNewLabel_1());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(0, 414, 616, 44);
			panel_1.add(getBtnNewButton());
			panel_1.add(getBtnAnnuler());
			panel_1.add(getBtnEnvoyer());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel_2.setBounds(0, 40, 616, 375);
			panel_2.setLayout(new GridLayout(7, 2, 0, 0));
			panel_2.add(getPanel_3());
			panel_2.add(getPanel_4());
			panel_2.add(getPanel_5());
			panel_2.add(getPanel_6());
			panel_2.add(getPanel_7());
			panel_2.add(getPanel_16());
			panel_2.add(getPanel_15());
			panel_2.add(getPanel_8());
			panel_2.add(getPanel_10());
			panel_2.add(getPanel_9());
			panel_2.add(getPanel_14());
			panel_2.add(getPanel_13());
			panel_2.add(getPanel_12());
			panel_2.add(getPanel_11());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblNewLabel());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.add(getTextField_2());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.add(getLblDepotLegal());
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.add(getTextField_1());
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.add(getLblFamille());
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(null);
			panel_8.add(getTextPane_1());
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(null);
			panel_9.add(getTextField());
		}
		return panel_9;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.add(getLblPrixEchantillon());
		}
		return panel_10;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(null);
			panel_11.add(getTextPane_4());
		}
		return panel_11;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.add(getLblContreIndications());
		}
		return panel_12;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(null);
			panel_13.add(getTextPane_3());
		}
		return panel_13;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.add(getLblEffets());
		}
		return panel_14;
	}
	private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.add(getLblComposition());
		}
		return panel_15;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setLayout(null);
			panel_16.add(getTextPane_2());
		}
		return panel_16;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nom commercial :");
		}
		return lblNewLabel;
	}
	private JLabel getLblDepotLegal() {
		if (lblDepotLegal == null) {
			lblDepotLegal = new JLabel("Depot Legal :");
		}
		return lblDepotLegal;
	}
	private JLabel getLblFamille() {
		if (lblFamille == null) {
			lblFamille = new JLabel("Famille :");
		}
		return lblFamille;
	}
	private JLabel getLblComposition() {
		if (lblComposition == null) {
			lblComposition = new JLabel("Composition :");
		}
		return lblComposition;
	}
	private JLabel getLblEffets() {
		if (lblEffets == null) {
			lblEffets = new JLabel("Effets");
		}
		return lblEffets;
	}
	private JLabel getLblContreIndications() {
		if (lblContreIndications == null) {
			lblContreIndications = new JLabel("Contre Indications :");
		}
		return lblContreIndications;
	}
	private JLabel getLblPrixEchantillon() {
		if (lblPrixEchantillon == null) {
			lblPrixEchantillon = new JLabel("Prix Echantillon :");
		}
		return lblPrixEchantillon;
	}
	private JComboBox<String> getTextPane_2() {
		if (textPane_2 == null) {
			/*MaskFormatter masque = null;
			try {
				masque=new MaskFormatter("UUU");
			} catch (ParseException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}*/
			textPane_2 = new JComboBox<String>();
			textPane_2.addItem("Code Famille :");
			textPane_2.addItem("AA");
			textPane_2.addItem("AAA");
			textPane_2.addItem("AAC");
			textPane_2.addItem("AAH");
			textPane_2.addItem("ABA");
			textPane_2.addItem("ABC");
			textPane_2.addItem("ABP");
			textPane_2.addItem("AFC");
			textPane_2.addItem("AFM");
			textPane_2.addItem("AH");
			textPane_2.addItem("AIM");
			textPane_2.addItem("AIN");
			textPane_2.addItem("ALO");
			textPane_2.addItem("ANS");
			textPane_2.addItem("AO");
			textPane_2.addItem("AP");
			textPane_2.addItem("AUM");
			textPane_2.addItem("CRT");
			textPane_2.addItem("HYP");
			textPane_2.addItem("PSA");
			textPane_2.setBounds(21, 0, 85, 20);
		}
		return textPane_2;
	}
	private JTextPane getTextPane_1() {
		if (textPane_1 == null) {
			textPane_1 = new JTextPane();
			textPane_1.setBounds(21, 5, 227, 37);
		}
		return textPane_1;
	}
	private JTextPane getTextPane_3() {
		if (textPane_3 == null) {
			textPane_3 = new JTextPane();
			textPane_3.setBounds(22, 5, 227, 37);
		}
		return textPane_3;
	}
	private JTextPane getTextPane_4() {
		if (textPane_4 == null) {
			textPane_4 = new JTextPane();
			textPane_4.setBounds(21, 5, 228, 37);
		}
		return textPane_4;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JFormattedTextField(NumberFormat.getInstance());
			textField.setBounds(22, 0, 86, 20);
			textField.setColumns(10);
			
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(21, 0, 154, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Retour");
			ActionBout action=new ActionBout(btnNewButton);
			action.retour();
		}
		return btnNewButton;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			ActionBout action=new ActionBout(btnAnnuler);
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
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Remplissez tous les champs et envoyez apr\u00E8s v\u00E9rification");
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(20, 0, 157, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	//------------------------------------Action des Bouttons---------------------------------------//
	//----------------------------------------------------------------------------------------------//
	public class ActionBout{
		private JButton boutton;
		
		public ActionBout(JButton b){
			boutton=b;
		}
		
		public void retour(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmCrationdeMdicaments.dispose();
					new MenuPrincipal(arguments);
				}
			});
		}
		
		public void annuler(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textPane_1.setText("");
					textPane_2.setSelectedIndex(0);
					textPane_3.setText("");
					textPane_4.setText("");
					
				}
			});
		}
		
		public void envoyer(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*int j=0;
					String prix="";
					//Mise en forme du prix//
					String prixformat=textField.getText().replace(",", ".");
					prix=prixformat;
					String depotlegal=textField_1.getText();
					String nomCom=textField_2.getText();
					String composition=textPane_1.getText();
					String famille=textPane_2.getSelectedItem().toString();
					String effets=textPane_3.getText();
					String contreindic=textPane_4.getText();
					List<Object> donnees=new ArrayList<Object>();
					for(int i=0; i<7; i++){
						switch(i){
						case 0:
							donnees.add(depotlegal);
							break;
						case 1:
							donnees.add(nomCom);
							break;
						case 2:
							donnees.add(famille);
							break;
						case 3:
							donnees.add(composition);
							break;
						case 4:
							donnees.add(effets);
							break;
						case 5:
							donnees.add(contreindic);
							break;
						case 6:
							donnees.add(prix);
							break;
						default:
							break;
							
						}
					}
					//Vérification des données é envoyer//
					String[] resultat=VerifChamps(donnees);
					for(String val:resultat){
						System.out.println("Resultat Verif "+j+": "+val);
						if(val=="false"){
							j++;
						}

					}
					if(j==0){
						System.out.println("Tout est Ok!");
						manageBD connexion = null;
						try {
							connexion=new manageBD("gsb_ppe3");
						} catch (SQLException e1) {
							// TODO Bloc catch généré automatiquement
							e1.printStackTrace();
						}
						int insertion=connexion.insertMedicaments(donnees);
						connexion.deconnecte();
						if(insertion>0){
							JOptionPane.showMessageDialog(null, "Le médicament à bien été ajouté à la base","Information", JOptionPane.INFORMATION_MESSAGE);
							frmCrationdeMdicaments.dispose();
							new CreationMedicament(arguments);
						}
						else{
							System.out.println("Erreur d'insertion !");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Il manque "+j+" Champs à renseigner","Erreur", JOptionPane.ERROR_MESSAGE);
						System.out.println("Erreur dans "+j+" Champs !");
					}*/
				}
			});
		}
		
		/*private String[] VerifChamps(List<Object> donnees){
			String[] tab=new String[7];
			int j=0;
			for(Object champ:donnees){
				System.out.println("Données a verif "+j+": '"+champ.toString()+"'");
				switch(j){
				case 2:
						if(!champ.toString().equals("Code Famille :")){
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
		}*/
	}
}
