package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.xml.parsers.ParserConfigurationException;

public class ConsulterRapport {

	private JFrame frmConsultationDeRapports;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JTextArea txtrChoissisezrn;
	private JTextPane txtpnBienvenueSurLa;
	private JButton btnNewButton_1;
	private String[] args;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JTextPane textPane;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private Rapport rapportEnVisualisation;
	//private ListeDonnees Listing;
	private ArrayList<Rapport> listeRapports;
	private ArrayList<Offre> listeOffres;
	private ArrayList<Rapport> listVisu;
	private ArrayList<Utilisateur> utilisateurs;

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
					ConsulterRapport window = new ConsulterRapport(visDel);
					window.frmConsultationDeRapports.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsulterRapport(String[] argmts) {
		initialize(argmts);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arguments) {
		this.args=arguments;
		recupAllRapports(args[0]);
		recupAllOffres(args[0]);
		frmConsultationDeRapports = new JFrame();
		frmConsultationDeRapports.setTitle("Consultation de rapports");
		frmConsultationDeRapports.setBounds(100, 100, 510, 524);
		frmConsultationDeRapports.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultationDeRapports.getContentPane().setLayout(null);
		frmConsultationDeRapports.getContentPane().add(getPanel());
		frmConsultationDeRapports.getContentPane().add(getPanel_1());
		frmConsultationDeRapports.getContentPane().add(getPanel_2());
		frmConsultationDeRapports.getContentPane().add(getBtnNewButton_1());
		frmConsultationDeRapports.setVisible(true);
		getPanel_2().setVisible(false);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 494, 38);
			panel.setLayout(null);
			panel.add(getTxtpnBienvenueSurLa());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(0, 38, 494, 77);
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
			panel_1.add(getComboBox());
			panel_1.add(getTxtrChoissisezrn());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Premi\u00E8re \u00E9tape :");
			lblNewLabel.setBounds(10, 8, 128, 57);
		}
		return lblNewLabel;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			ActionCBB action;
			if(args[2].equals("Visiteur")){
				action=new ActionCBB(comboBox, "Date");
			}
			else{
				action=new ActionCBB(comboBox, "Visiteur");
			}
			action.recupRapport();
			comboBox.setBounds(143, 26, 104, 20);
		}
		return comboBox;
	}
	private JTextArea getTxtrChoissisezrn() {
		if (txtrChoissisezrn == null) {
			txtrChoissisezrn = new JTextArea();
			txtrChoissisezrn.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtrChoissisezrn.setEditable(false);
			txtrChoissisezrn.setRows(2);
			txtrChoissisezrn.setTabSize(2);
			txtrChoissisezrn.setForeground(SystemColor.menuText);
			txtrChoissisezrn.setBackground(SystemColor.menu);
			txtrChoissisezrn.setText("<--\tChoissisez la date du\r\n\t rapport \u00E0 consuler\t");
			txtrChoissisezrn.setBounds(257, 27, 177, 35);
		}
		return txtrChoissisezrn;
	}
	private JTextPane getTxtpnBienvenueSurLa() {
		if (txtpnBienvenueSurLa == null) {
			txtpnBienvenueSurLa = new JTextPane();
			txtpnBienvenueSurLa.setBounds(142, 0, 220, 38);
			txtpnBienvenueSurLa.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtpnBienvenueSurLa.setText("Bienvenue sur la page de consultation\r\n            des rapports de visite");
			txtpnBienvenueSurLa.setEditable(false);
			txtpnBienvenueSurLa.setBackground(SystemColor.menu);
		}
		return txtpnBienvenueSurLa;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Retour");
			btnNewButton_1.setBounds(10, 455, 89, 23);
			ActionButtons action= new ActionButtons(btnNewButton_1);
			action.retour();
		}
		return btnNewButton_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(0, 115, 494, 329);
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(getPanel_3(), GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(getLblNewLabel_6()))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(131)
								.addComponent(getBtnNewButton_2())
								.addGap(48)
								.addComponent(getBtnNewButton_3(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(35, Short.MAX_VALUE))
					.addComponent(getPanel_4(), GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(getPanel_3(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(11)
								.addComponent(getLblNewLabel_6())))
						.addGap(6)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(1)
								.addComponent(getBtnNewButton_2()))
							.addComponent(getBtnNewButton_3(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPanel_4(), GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
			);
			panel_2.setLayout(gl_panel_2);
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new GridLayout(0, 2, 0, 0));
			panel_3.add(getLblNewLabel_1());
			panel_3.add(getTextField());
			panel_3.add(getLblNewLabel_2());
			panel_3.add(getTextField_1());
			panel_3.add(getLblNewLabel_3());
			panel_3.add(getTextField_2());
			panel_3.add(getLblNewLabel_4());
			panel_3.add(getTextField_3());
			panel_3.add(getLblNewLabel_5());
			JScrollPane scroll=new JScrollPane(getTextPane());
			panel_3.add(scroll);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.add(getLblNewLabel_7());
			//panel_4.add(getPanel_5());
		}
		return panel_4;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Praticien");
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Numero");
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Date Rapport");
		}
		return lblNewLabel_3;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Motif");
		}
		return lblNewLabel_4;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Bilan");
		}
		return lblNewLabel_5;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
		}
		return textPane;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Pr\u00E9c\u00E9dent");
			ActionButtons action= new ActionButtons(btnNewButton_2);
			action.RapportPrec();
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Suivant");
			ActionButtons action= new ActionButtons(btnNewButton_3);
			action.RapportSuiv();
		}
		return btnNewButton_3;
	}
	private JButton getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JButton("D\u00E9tails");
			lblNewLabel_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] prat=textField.getText().split(" ");
					new ConsulterPrat(args, prat);
				}
			});
			lblNewLabel_6.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Offres :");
			lblNewLabel_7.setBounds(0, 0, 62, 32);
		}
		return lblNewLabel_7;
	}
	//__________________________________________________________________________________________//
//___________________________________ACTION DES COMBOBOXs_____________________________________________//
	//__________________________________________________________________________________________//
	public class ActionCBB {
		private JComboBox<String> combo;
		
		public ActionCBB(JComboBox<String> comb, String type){
			this.combo=comb;
			switch(type){
			case "Date":
				int i=0;
				comb.addItem("Choisir une Date :");
				for(Rapport rapp:listeRapports)
				{
					if(i>0)
					{
						if(!rapp.getDate().equals(listeRapports.get(i-1).getDate()))
						{
							comb.addItem(rapp.getDate());
							//System.out.println(rapp.getDate());
						}
					}
					i++;
				}
				break;
			case "Visiteur":
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
				combo.addItem("Choisir un visiteur :");
				int j=0;
				for(Utilisateur util:utilisateurs)
				{
					if(j!=0)
					{
						if(!util.getMatricule().equals(utilisateurs.get(j-1)))
						{
							combo.addItem("("+util.getMatricule()+") "+util.getNom()+" "+util.getPrenom());
						}
					}
					j++;
				}
				/*visiteur=conn.recupVisRapportDel(args[3]);
				conn.deconnecte();
				System.out.println("Nb de visiteurs distinct :"+visiteur.size());
				combo.addItem("Visiteurs:");
				if(visiteur.size()>0){
					for(String vis:visiteur){
						String visit[]=vis.split(";");
						vis=visit[1]+" "+visit[2];
						combo.addItem(vis);
					}
				}*/
				break;
			case "Visiteur:Délégué":
				/*visiteur=conn.recupVisRapportResp(args[3], args[4]);
				conn.deconnecte();
				System.out.println("Nb de visiteurs distinct :"+visiteur.size());
				combo.addItem("Visiteurs:");
				if(visiteur.size()>0){
					for(String vis:visiteur){
						String visit[]=vis.split(";");
						vis=visit[1]+" "+visit[2];
						combo.addItem(vis);
					}
				}*/
				break;
				default:
					break;
			}
			
		}
		
		public void recupRapport(){
			combo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) 
				{
					listVisu=new ArrayList<Rapport>();
					String date=arg0.getItem().toString();
					switch(args[2]){
						case "Visiteur":
							
							for(Rapport rap:listeRapports)
							{
								if(date.equals(rap.getDate()))
								{
									listVisu.add(rap);
								}
							}
							if(listVisu.size()!=0)
							{
								
								rapportEnVisualisation=listVisu.get(0);
								if(listVisu.size()==1){
										//------------------------Affichage du Panel des détails des rapports---------------------//
										//-1 signifie qu'on affiche le panel avec 1 seul rapport donc les boutton suivant et précédent seront désactivés
										afficheDetailsRapp(rapportEnVisualisation, -1);
								}
								else
								{
										//------------------------Affichage du Panel des détails des rapports---------------------//
										//O siginifie qu'on affiche le panel avec en prenant en compte plus d'un rapport
										//donc le boutton suivant seras activé
										afficheDetailsRapp(rapportEnVisualisation, 0);
								}
							}
							else{
								JLabel label=new JLabel("Ce visiteur n'a aucuns rapports de visites");
								getPanel_2().setVisible(false);
								JPanel panelParent=(JPanel) getPanel_2().getParent();
								panelParent.add(label, panelParent.getComponentCount()-2);
							}
							break;
						default:
							if(!arg0.getItem().toString().equals("Choisir un visiteur :"))
							{
								int deb, fin;
								String mat_vis_select;
								deb=arg0.getItem().toString().indexOf("(");
								fin=arg0.getItem().toString().indexOf(")");
								mat_vis_select=arg0.getItem().toString().substring(deb+1, fin);
								System.out.println(arg0.getItem().toString());
								recupAllRapports(mat_vis_select);
								recupAllOffres(mat_vis_select);
								listVisu=listeRapports;
								if(listVisu.size()!=0)
								{
									
									rapportEnVisualisation=listVisu.get(0);
									if(listVisu.size()==1){
											//------------------------Affichage du Panel des détails des rapports---------------------//
											//-1 signifie qu'on affiche le panel avec 1 seul rapport donc les boutton suivant et précédent seront désactivés
											afficheDetailsRapp(rapportEnVisualisation, -1);
									}
									else
									{
											//------------------------Affichage du Panel des détails des rapports---------------------//
											//O siginifie qu'on affiche le panel avec en prenant en compte plus d'un rapport
											//donc le boutton suivant seras activé
											afficheDetailsRapp(rapportEnVisualisation, 0);
									}
								}
								else
								{
									JLabel label=new JLabel("Ce visiteur n'a aucuns rapports de visites");
									label.setBounds(10, 8, 200, 57);
									//getPanel_2().setVisible(false);
									label.setVisible(true);
									JPanel panelParent=(JPanel) frmConsultationDeRapports.getContentPane();
									panelParent.add(label, panelParent.getComponentCount()-2);
									System.out.println(panelParent.getComponent(2).toString());
									//panelParent.repaint();
								}
							}
							else
							{
								getPanel_2().setVisible(false);
							}
							break;
					}
				
							
				}
		
			});
		}
	}
	//____________________________________________________________________________________________________//
//______________________________________________________________________________________________________________//
//____________________________________________AFFICHE DETAILS RAPPORT___________________________________________//
	//___________________________________________________________________________________________________//
	public void afficheDetailsRapp(Rapport rapport, int i){
		//Suppression des données de l'ancien panel des offres si elles existent + ajout du label Offres
		if(getPanel_4().getComponentCount()>1){
			//System.out.println("Nb composants :"+getPanel_4().getComponentCount());
			getPanel_4().removeAll();
			getPanel_4().add(getLblNewLabel_7());
		}
		//Gestion de l'apparence des bouttons lors de la navigation
		//entre les rapports du meme jour
		if(i==0){
			getBtnNewButton_2().setEnabled(false);
			getBtnNewButton_3().setEnabled(true);
		}
		else if(i==(listVisu.size()-1)){
			getBtnNewButton_2().setEnabled(true);
			getBtnNewButton_3().setEnabled(false);
		}
		else if(i==-1){
			getBtnNewButton_2().setEnabled(false);
			getBtnNewButton_3().setEnabled(false);
		}
		else{
			getBtnNewButton_2().setEnabled(true);
			getBtnNewButton_3().setEnabled(true);
		}
		getTextField().setText(rapport.getPraNom()+" "+rapport.getPraPrenom());
		getTextField_1().setText(String.valueOf(rapport.getRapnum()));
		getTextField_2().setText(rapport.getDate());
		getTextField_3().setText(rapport.getMotif());
		getTextPane().setText(rapport.getBilan());
		getPanel_2().setVisible(true);
		
		ArrayList<Offre> list=new ArrayList<Offre>();
		long rapNum=rapport.getRapnum();
		//System.out.println("Rapnum :"+rapNum);
		//String matricule=args[0];
		for(Offre off:listeOffres)
		{
			if(rapNum==off.getNumrap())
			{
				list.add(off);
			}
		}
		if(list.size()>0)
		{
			int ypanel=22;
			int ybutton=492;
			int heightframe=568;
			int heighpanel=366;
			JPanel panel = null;
			JLabel label= null;
			JTextField produit= null;
			JSpinner qte= null;
			for(int j=0; j<list.size(); j++){
				//Vérif. des données des offres//
				//System.out.println("Produit "+(j+1)+" :\nVisMat: "+Offres[j][0]+" RapNum: "+Offres[j][1]+" Medicament DL: "+Offres[j][2]+" Qte: "+Offres[j][3]);
				panel=new JPanel();
				
				label=new JLabel("Produit :");
				produit=new JTextField();
				produit.setText(list.get(j).getDepot());
				//System.out.println("Med :"+produit.getText());
				produit.setEditable(false);
				produit.setColumns(10);
				qte=new JSpinner();
				qte.setValue(list.get(j).getQte());
				//System.out.println("Spin: "+Offres[j][3]);
				panel.add(label);
				panel.add(produit);
				panel.add(qte);
				getPanel_4().add(panel);
				panel.setBounds(0, ypanel, 494, 29);
				panel_2.setBounds(0, 115, 494, heighpanel);				
				getBtnNewButton_1().setBounds(10, ybutton, 89, 23);
				frmConsultationDeRapports.setBounds(100, 100, 510, heightframe);
				ypanel+=40;
				ybutton+=40;
				heightframe+=40;
				heighpanel+=40;
			}
			panel_4.setVisible(true);
		}
		else
		{
			panel_4.setVisible(false);
		}
	}
	//_______________________________________________________________________________________________________________//
//_____________________________________________________________________________________________________________________________//
//_____________________________________________ACTION DES BOUTTONS_____________________________________________________________//
	//________________________________________________________________________________________________________________//
	public class ActionButtons{
		private JButton boutton;
		
		public ActionButtons(JButton Bout){
			boutton=Bout;
		}
		
		public void RapportSuiv(){
			boutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int index=listVisu.indexOf(rapportEnVisualisation);
						rapportEnVisualisation=listVisu.get(index+1);
						afficheDetailsRapp(rapportEnVisualisation, index+1);

					}
				});
		}
		
		public void RapportPrec(){
			boutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int index=listVisu.indexOf(rapportEnVisualisation);
						rapportEnVisualisation=listVisu.get(index-1);
						afficheDetailsRapp(rapportEnVisualisation, index-1);
					}
				});
		}
		
		public void retour(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmConsultationDeRapports.setVisible(false);
					if(args.length==3){
						new MenuPrincipalV(args);
					}
					else{
						new MenuPrincipal(args);
					}
				}
			});
		}
	}
	public void recupAllOffres(String vis_mat)
	{
		String str=null;
		List<String> keys = null, values=null;
		XMLtraitement treat=null;
		Map<String, Map<Integer, List<String>>> hash=null;
		
		keys=new ArrayList<String>();
		values=new ArrayList<String>();
		keys.add("tag");		
		values.add("recupOffres");	
		keys.add("vis_mat");		
		values.add(vis_mat);
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
		Map<Integer, List<String>> AllOffres=hash.get("Donnees");
		listeOffres=new ArrayList<Offre>();
		for(Integer key:AllOffres.keySet())
		{
			if(AllOffres.size()>1)
			{	
				ArrayList<String> DOff=(ArrayList<String>) AllOffres.get(key);
				Offre offre=new Offre(DOff.get(0), Long.valueOf(DOff.get(1)), DOff.get(2), Integer.valueOf(DOff.get(3)));
				listeOffres.add(offre);
				
				System.out.println(DOff.get(0)+" "+DOff.get(1)+" "+DOff.get(2)+" "+DOff.get(3));
			}
			/*else
			{
				JOptionPane.showMessageDialog(null, "Erreur technique lors de la récupération des rapports", "Erreur", JOptionPane.ERROR_MESSAGE);
			}*/
		}
	}
	public void recupAllRapports(String vis_mat)
	{
		String str=null;
		List<String> keys = null, values=null;
		XMLtraitement treat=null;
		Map<String, Map<Integer, List<String>>> hash=null;
		
		keys=new ArrayList<String>();
		values=new ArrayList<String>();
		keys.add("tag");		
		values.add("recupRapports");	
		keys.add("vis_mat");		
		values.add(vis_mat);
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
		Map<Integer, List<String>> AllRapports=hash.get("Donnees");
		listeRapports=new ArrayList<Rapport>();
		for(Integer key:AllRapports.keySet())
		{
			if(AllRapports.size()>1)
			{	
				ArrayList<String> DRapp=(ArrayList<String>) AllRapports.get(key);
				Rapport rapport=new Rapport(DRapp.get(0), Long.valueOf(DRapp.get(1)), Long.valueOf(DRapp.get(2)), DRapp.get(3), DRapp.get(4), DRapp.get(5), DRapp.get(6), DRapp.get(7));
				listeRapports.add(rapport);
				
				System.out.println(DRapp.get(0)+" "+DRapp.get(1)+" "+DRapp.get(2)+" "+DRapp.get(3)+" "+DRapp.get(4)+" "+DRapp.get(5)+" "+DRapp.get(6)+" "+DRapp.get(7));
			}
			/*else
			{
				JOptionPane.showMessageDialog(null, "Erreur technique lors de la récupération des rapports", "Erreur", JOptionPane.ERROR_MESSAGE);
			}*/
		}
	}
}
