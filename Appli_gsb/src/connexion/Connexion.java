package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPasswordField;
import javax.xml.parsers.ParserConfigurationException;

public class Connexion {

	private JFrame frmIdentification;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox<String> comboBox;
	private JTextField textFieldNom;
	private JLabel lblNewLabel_2;
	private Button button;
	private Button button_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frmIdentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
		frmIdentification.setVisible(true);
	}
	public JFrame getJFrame(){
		return frmIdentification;		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdentification = new JFrame();
		frmIdentification.setTitle("Identification");
		frmIdentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdentification.setBounds(100, 100, 465, 317);
		frmIdentification.getContentPane().setLayout(null);
		frmIdentification.getContentPane().add(getLblNewLabel());
		frmIdentification.getContentPane().add(getLblNewLabel_1());
		frmIdentification.getContentPane().add(getComboBox());
		frmIdentification.getContentPane().add(getTextFieldNom());
		frmIdentification.getContentPane().add(getLblNewLabel_2());
		getButton().setBounds(288, 209, 70, 22);
		getButton_1().setBounds(55, 209, 70, 22);
		frmIdentification.getContentPane().add(getButton());
		frmIdentification.getContentPane().add(getButton_1());
		frmIdentification.getContentPane().add(getPasswordField());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nom :");
			lblNewLabel.setBounds(77, 50, 57, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Mot de Passe :");
			lblNewLabel_1.setBounds(55, 97, 79, 14);
		}
		return lblNewLabel_1;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.addItem("-AL- Alsace Lorraine");
			comboBox.addItem("-AQ- Aquitaine");
			comboBox.addItem("-AU- Auvergne");
			comboBox.addItem("-BG- Bretagne");
			comboBox.addItem("-BN- Basse Normandie");
			comboBox.addItem("-BO- Bourgogne");
			comboBox.addItem("-CA- Champagne Ardennes");
			comboBox.addItem("-CE- Centre");
			comboBox.addItem("-FC- Franche Comt\u00E9");
			comboBox.addItem("-HN- Haute Normandie");
			comboBox.addItem("-IF- Ile de France");
			comboBox.addItem("-LG- Langedoc");
			comboBox.addItem("-LI- Limousin");
			comboBox.addItem("-MP- Midi Pyr\u00E9n\u00E9e");
			comboBox.addItem("-NP- Nord Pas de Calais");
			comboBox.addItem("-PA- Provence Alpes Cote d'Azur");
			comboBox.addItem("-PC- Poitou Charente");
			comboBox.addItem("-PI- Picardie");
			comboBox.addItem("-PL- Pays de Loire");
			comboBox.addItem("-RA- Rhone Alpes");
			comboBox.addItem("-RO- Roussillon");
			comboBox.addItem("-VD- Vend\u00E9e");
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"-AL- Alsace Lorraine", "-AQ- Aquitaine", "-AU- Auvergne", "-BG- Bretagne", "-BN- Basse Normandie", "-BO- Bourgogne", "-CA- Champagne Ardennes", "-CE- Centre", "-FC- Franche Comt\u00E9", "-HN- Haute Normandie", "-IF- Ile de France", "-LG- Langedoc", "-LI- Limousin", "-MP- Midi Pyr\u00E9n\u00E9e", "-NP- Nord Pas de Calais", "-PA- Provence Alpes Cote d'Azur", "-PC- Poitou Charente", "-PI- Picardie", "-PL- Pays de Loire", "-RA- Rhone Alpes", "-RO- Roussillon", "-VD- Vend\u00E9e"}));
			comboBox.setToolTipText("");
			comboBox.setBounds(141, 139, 144, 22);
		}
		return comboBox;
	}
	private JTextField getTextFieldNom() {
		if (textFieldNom == null) {
			textFieldNom = new JTextField();
			textFieldNom.setBounds(141, 47, 86, 20);
			textFieldNom.setColumns(10);
		}
		return textFieldNom;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Region :");
			lblNewLabel_2.setBounds(66, 139, 65, 14);
		}
		return lblNewLabel_2;
	}
	private Button getButton() {
		if (button == null) {
			button = new Button("Valider");
			ActionDesBoutton action=new ActionDesBoutton(button);
			action.envoyer();
			button.setBounds(249, 209, 109, 22);
		}
		return button;
	}
	private Button getButton_1() {
		if (button_1 == null) {
			button_1 = new Button("Annuler");
			ActionDesBoutton action = new ActionDesBoutton(button_1);
			action.annuler();
			button_1.setBounds(10, 209, 115, 22);
		}
		return button_1;
	}
	public void actionEnvoi(Map<String, String> result){
		String args[];
		String nom, matricule, labcode, seccode, role, regcode;
		String[] mefReg;
			matricule=result.get("matricule").replaceAll(" ", "");
			nom=result.get("name").replaceAll(" ", "");
			labcode=result.get("lab_code").replaceAll(" ", "");
			seccode=result.get("sec_code").replaceAll(" ", "");
			role=result.get("role").replaceAll(" ", "");
			mefReg=getComboBox().getSelectedItem().toString().split("-");
			regcode=mefReg[1];
		switch(role)
		{
			case "Visiteur":
				args=new String[3];
				args[0]=matricule;
				args[1]=nom;
				args[2]="Visiteur";
				frmIdentification.dispose();
				new MenuPrincipalV(args);
				break;
			case "Délégué":
				
				args=new String[5];
				args[0]=matricule;
				args[1]=nom;
				args[2]="Délégué";
				args[3]=labcode;
				args[4]=regcode;
				frmIdentification.dispose();
				new MenuPrincipal(args);	
				break;
			case "Responsable":
				
				args=new String[5];
				args[0]=matricule;
				args[1]=nom;
				args[2]="Responsable";
				args[3]=seccode;
				args[4]=labcode;
				frmIdentification.dispose();
				new MenuPrincipal(args);	
				break;
			default:
				break;
		}		
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(141, 94, 86, 20);
		}
		return passwordField;
	}

	//________________________ACTION BOUTTONS______________________________________//
	public class ActionDesBoutton{
		private Button boutton;
		
		public ActionDesBoutton(Button bout){
			this.boutton=bout;
		}
		
		public void envoyer(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String res=null;
					String[] MefRegNom=comboBox.getSelectedItem().toString().split("-");
					String regCode=MefRegNom[1];
					List<String> keys = new ArrayList<String>();
					keys.add("tag");
					keys.add("nom");
					keys.add("password");
					keys.add("reg");
					List<String> values = new ArrayList<String>();
					values.add("login");
					values.add(textFieldNom.getText());
					values.add(String.valueOf(passwordField.getPassword()));
					values.add(regCode);
					res=ConnexionHTTP.post(keys, values);
					//Mise en forme de la réponse XML//
					res=res.substring(3);
					
					//System.out.println(res.charAt(3));
					System.out.println(res);
					XMLtraitement traitement = null;
					try {
						traitement = new XMLtraitement(res);
					} catch (UnsupportedEncodingException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					} catch (ParserConfigurationException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
					Map<String, String> resultat=traitement.retourneChamps();
					String valid=resultat.get("success");
					String mefValid=valid.replaceAll(" ", "");
					if((Integer.valueOf(mefValid))==(0))
					{
						JOptionPane.showMessageDialog(null, "Matricule, Nom ou Region incorrecte !", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						String nom, prenom;
						nom=resultat.get("name").replaceAll(" ", "");
						prenom=resultat.get("prenom").replaceAll(" ", "");
						JOptionPane.showMessageDialog(null, "Authentification réussie !\n Bienvenue sur l'application gsb Mr/Mme "+nom+" "+prenom, "Information", JOptionPane.INFORMATION_MESSAGE);
						actionEnvoi(resultat);
						frmIdentification.dispose();
					}
					//System.out.println(valid);
				}
			});
		}
		public void annuler(){
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textFieldNom.setText("");
					passwordField.setText("");
				}
			});
		}
	}
	//_____________________________________________________________________________//
}
