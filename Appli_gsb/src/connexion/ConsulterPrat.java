package connexion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.xml.parsers.ParserConfigurationException;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;

public class ConsulterPrat {

	private JFrame frmPraticiens;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private String[] argV;
	/*private JButton btnNewButton_1;
	private JButton btnNewButton_2;*/
	private JPanel panel_4;
	private JPanel panel_5;
	//private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnNewButton_3;
	private ListeDonnees listing;
	private ArrayList<Praticien> listePrat;

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
					ConsulterPrat window = new ConsulterPrat(visDel);
					window.frmPraticiens.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsulterPrat(String[] arguments) {
		initialize(arguments);
		frmPraticiens.setVisible(true);
	}
	
	public ConsulterPrat(String[] arguments, String[] prat) {
		initialize(arguments, prat);
		frmPraticiens.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arg) {
		this.argV=arg;
		frmPraticiens = new JFrame();
		frmPraticiens.setTitle("Praticiens");
		/*if(argV[2].equals("Visiteur"))
		{
			frmPraticiens.setBounds(100, 100, 573, 225);
			getPanel_7().setBounds(0, 155, 557, 24);
		}
		else{*/
			frmPraticiens.getContentPane().add(getLblNewLabel_2());
			frmPraticiens.getContentPane().add(getBtnNewButton());
			frmPraticiens.setBounds(100, 100, 573, 274);
			getPanel_7().setBounds(0, 200, 557, 24);
		//}
		//Cache le panel du detail et des bouttons de navigation à l'initialisation//
		getPanel_3().setVisible(false);
		//getPanel_6().setVisible(false);
		
		//getPanel_7().setVisible(true);
		//Actions de la combobox//
		JComboBox<String> cb=getComboBox();
		ActionComboBox Action = new ActionComboBox(cb);
		Action.remplissage();
		Action.afficheDetails();
		//---------------------//
		frmPraticiens.getContentPane().add(getPanel_2());
		frmPraticiens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPraticiens.getContentPane().setLayout(null);
		frmPraticiens.getContentPane().add(getPanel());
		frmPraticiens.getContentPane().add(getPanel_1());
		frmPraticiens.getContentPane().add(getPanel_3());
		//frmPraticiens.getContentPane().add(getPanel_6());
		
		JButton bout= (JButton) getPanel_7().getComponent(0);
		ActionBoutton action = new ActionBoutton(bout);
		action.retour();
		frmPraticiens.getContentPane().add(getPanel_7());

	}
	private void initialize(String[] arg, String[] praticien) {
		this.argV=arg;
		frmPraticiens = new JFrame();
		frmPraticiens.setTitle("Praticiens");
			
		frmPraticiens.setBounds(100, 100, 573, 225);
		//Cache le panel du detail et des bouttons de navigation à l'initialisation//
		getPanel_3().setVisible(false);
		//getPanel_6().setVisible(false);
		//JComboBox combo=(JComboBox) getPanel_5().getComponent(1);
		//Actions de la combobox//
		JComboBox<String> combo=getComboBox();
		ActionComboBox Action = new ActionComboBox(combo);
		Action.remplissage();
		Action.afficheDetailsSeul();
		combo.setSelectedItem(praticien[0]+" "+praticien[1]);
		//----------------------//
		frmPraticiens.getContentPane().add(getPanel_2());
		frmPraticiens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPraticiens.getContentPane().setLayout(null);
		frmPraticiens.getContentPane().add(getPanel());
		frmPraticiens.getContentPane().add(getPanel_1());
		frmPraticiens.getContentPane().add(getPanel_3());
		//frmPraticiens.getContentPane().add(getPanel_6());
		
		getPanel_7().setBounds(0, 362, 557, 24);
		JButton bout= (JButton) getPanel_7().getComponent(0);
		ActionBoutton action = new ActionBoutton(bout);
		action.quitter();
		//getPanel_7().setVisible(true);
		frmPraticiens.getContentPane().add(getPanel_7());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("LISTE DES PRATICIENS");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			//comboBox.set
		}
		return comboBox;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 557, 24);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("-S\u00E9lectionnez un praticien dans la liste d\u00E9roulante ci-dessous.");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("- Ou cr\u00E9ez un nouveau praticien en appuyant sur le boutton");
			lblNewLabel_2.setBounds(0, 143, 353, 45);
		}
		return lblNewLabel_2;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(0, 25, 557, 24);
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblNewLabel_1());
		}
		return panel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cr\u00E9ez");
			ActionBoutton action= new ActionBoutton(btnNewButton);
			action.creezPraticien();
			btnNewButton.setBounds(363, 155, 71, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Praticiens :");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(0, 49, 557, 95);
			panel_2.setLayout(new GridLayout(1, 2, 0, 0));
			panel_2.add(getPanel_5());
			panel_2.add(getPanel_4());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel_3.setBounds(0, 145, 557, 176);
			panel_3.setLayout(new GridLayout(8, 2, 0, 0));
			panel_3.add(getLblNewLabel_4());
			panel_3.add(getLblNewLabel_5());
			panel_3.add(getLblNewLabel_6());
			panel_3.add(getLabel());
			panel_3.add(getLabel_1());
			panel_3.add(getLabel_2());
			panel_3.add(getLblNewLabel_7());
			panel_3.add(getLblNewLabel_8());
			panel_3.add(getLabel_4());
			panel_3.add(getLblNewLabel_9());
			panel_3.add(getLabel_6());
			panel_3.add(getLabel_5());
			panel_3.add(getLabel_8());
			panel_3.add(getLabel_7());
			panel_3.add(getLabel_3());
			panel_3.add(getLabel_9());
			panel_3.setVisible(false);

		}
		return panel_3;
	}
	
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("New label");
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("New label");
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("New label");
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("New label");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("New label");
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("New label");
		}
		return lblNewLabel_9;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("New label");
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("New label");
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("New label");
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("New label");
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("New label");
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("New label");
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("New label");
		}
		return label_6;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("New label");
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("New label");
		}
		return label_8;
	}
	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("New label");
		}
		return label_9;
	}
	/*private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Suivant");
			//btnNewButton_1.setBounds(10, 332, 89, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Précédent");
			//btnNewButton_2.setBounds(109, 332, 89, 23);
		}
		return btnNewButton_2;
	}*/
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getLblNewLabel_3());
			panel_5.add(getComboBox(), BorderLayout.EAST);
		}
		return panel_5;
	}
	/*private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBounds(0, 322, 557, 37);
			panel_6.add(getBtnNewButton_2());
			panel_6.add(getBtnNewButton_1());
		}
		return panel_6;
	}*/
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBounds(0, 362, 557, 27);
			panel_7.setLayout(new BorderLayout(0, 0));
			panel_7.add(getBtnNewButton_3(), BorderLayout.WEST);
		}
		return panel_7;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Retour");
			/*ActionBoutton action= new ActionBoutton(btnNewButton_3);
			action.retour();*/
			
		}
		return btnNewButton_3;
	}
	//________________________________________ACTION DES COMBOBOXS_____________________________________//
	public class ActionComboBox{
		private JComboBox<String> cb;
		
		public ActionComboBox(JComboBox<String> combobox){
			cb=combobox;
		}
		public void remplissage(){
			ArrayList<String> comb=null;
			String str=null;
			List<String> keys = null, values=null;
			XMLtraitement treat=null;
			Map<String, Map<Integer, List<String>>> hash=null;
			int i=1;
			keys=new ArrayList<String>();
			values=new ArrayList<String>();
			keys.add("tag");
			values.add("recupPraticiens");
			
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
			Map<Integer, List<String>> praticiens=hash.get("Donnees");
			comb=new ArrayList<String>();
			comb.add(0, "Choisir Praticien :");
			listePrat=new ArrayList<Praticien>();
			for(Integer key:praticiens.keySet())
			{
				ArrayList<String> Dpra=(ArrayList<String>) praticiens.get(key);
				if(praticiens.size()>1)
				{	
					//System.out.println(praticiens.get(key));
					//System.out.println(Dpra.get(1));
					//System.out.println(key);
					//cb[i]=Dpra.get(1)+" "+Dpra.get(2);
					Praticien prat=new Praticien(Long.valueOf(Dpra.get(0)), Dpra.get(1), Dpra.get(2), Dpra.get(3), Long.valueOf(Dpra.get(4)), Dpra.get(5), Double.valueOf(Dpra.get(6)), Dpra.get(7));
					listePrat.add(prat);
					comb.add(i, Dpra.get(1)+" "+Dpra.get(2));
				}
				else
				{
					comb.add(i, Dpra.get(0));
				}
				i++;
			}
			listing=new ListeDonnees(comb);
			for(int j=0; j<listing.getNbDonnees(); j++)
			{
				//System.out.println(listing.getDonnee(j));
				comboBox.addItem(listing.getDonnee(j));
			}
			comboBox.setBounds(135, 109, 160, 20);
		}
		//_____________________________________________AFFICHAGE DES DETAILS___________________________________//
		
		//__________________________________________________________________________________________________//
		public void afficheDetails(){
			cb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getItem().toString().equals("Choisir Praticien :")){
						getPanel_3().setVisible(false);
						//getPanel_6().setVisible(false);
						if(argV[2].equals("Visiteur"))
						{
							frmPraticiens.setBounds(100, 100, 573, 225);
							//Recalibrage du panel du boutton retour
							getPanel_7().setBounds(0, 155, 557, 24);
						}
						else{
							frmPraticiens.setBounds(100, 100, 573, 274);
							//Recalibrage du panel du boutton retour
							getPanel_7().setBounds(0, 200, 557, 24);
						}
					}
					else
					{
						String[] prat=e.getItem().toString().split(" ");
						Praticien pratSelect=null;
						for(Praticien praticien:listePrat)
						{
							if((praticien.getNom().equals(prat[0]) && (praticien.getPrenom().equals(prat[1]))))
							{
								pratSelect=praticien;
								break;
							}
						}
						if(pratSelect!=null)
						{
							String[] entetes = {"Numéro", "Nom", "Prénom", "Adresse", "CP", "VILLE", "Coeff. Notoriété", "Type"};
					       getLblNewLabel_4().setText(entetes[0]);
					       getLblNewLabel_6().setText(entetes[1]);
					       getLabel_1().setText(entetes[2]);
					       getLblNewLabel_7().setText(entetes[3]);
					       getLabel_4().setText(entetes[4]);
					       getLabel_6().setText(entetes[5]);
					       getLabel_8().setText(entetes[6]);
					       getLabel_3().setText(entetes[7]);
					      //Affichage du détail des praticiens
					       getLblNewLabel_5().setText(String.valueOf(pratSelect.getNum()));
					       getLabel().setText(pratSelect.getNom());
					       getLabel_2().setText(pratSelect.getPrenom());
					       getLblNewLabel_8().setText(pratSelect.getAdresse());
					       getLblNewLabel_9().setText(String.valueOf(pratSelect.getCp()));
					       getLabel_5().setText(pratSelect.getVille());
					       getLabel_7().setText(String.valueOf(pratSelect.getcoeff()));
					       getLabel_9().setText(pratSelect.getType());
					      
					       frmPraticiens.setBounds(100, 100, 573, 530);
				    	   getPanel_3().setBounds(0, 210, 557, 176);
				    	 //Recalibrage du panel des bouttons de navigations entre les praticiens
				    	   //getPanel_6().setBounds(0, 400, 557, 37);
				    	 //Recalibrage du panel du boutton retour
				    	   getPanel_7().setBounds(0, 450, 557, 24);
				    	  // getPanel_6().setVisible(true);
					       getPanel_3().setVisible(true);
						}						 
					}
				}
			});
		}
		
		public void afficheDetailsSeul(){
			cb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getItem().toString().equals("Choisir Praticien :")){
						getPanel_3().setVisible(false);
						//getPanel_6().setVisible(false);
							frmPraticiens.setBounds(100, 100, 573, 225);
							//Recalibrage du panel du boutton retour
							getPanel_7().setBounds(0, 155, 557, 24);
					}
					else
					{
						String[] prat=e.getItem().toString().split(" ");
						Praticien pratSelect=null;	
						for(Praticien praticien:listePrat)
						{
							if((praticien.getNom().equals(prat[0]) && (praticien.getPrenom().equals(prat[1]))))
							{
								pratSelect=praticien;
								break;
							}
						}
						if(pratSelect!=null)
						{
							String[] entetes = {"Numéro", "Nom", "Prénom", "Adresse", "CP", "VILLE", "Coeff. Notoriété", "Type"};
						       getLblNewLabel_4().setText(entetes[0]);
						       getLblNewLabel_6().setText(entetes[1]);
						       getLabel_1().setText(entetes[2]);
						       getLblNewLabel_7().setText(entetes[3]);
						       getLabel_4().setText(entetes[4]);
						       getLabel_6().setText(entetes[5]);
						       getLabel_8().setText(entetes[6]);
						       getLabel_3().setText(entetes[7]);
						      //Affichage du détail des praticiens
						       getLblNewLabel_5().setText(String.valueOf(pratSelect.getNum()));
						       getLabel().setText(pratSelect.getNom());
						       getLabel_2().setText(pratSelect.getPrenom());
						       getLblNewLabel_8().setText(pratSelect.getAdresse());
						       getLblNewLabel_9().setText(String.valueOf(pratSelect.getCp()));
						       getLabel_5().setText(pratSelect.getVille());
						       getLabel_7().setText(String.valueOf(pratSelect.getcoeff()));
						       getLabel_9().setText(pratSelect.getType());
						      
						       frmPraticiens.setBounds(100, 100, 573, 530);
					    	   getPanel_3().setBounds(0, 210, 557, 176);
					    	 //Recalibrage du panel des bouttons de navigations entre les praticiens
					    	   //getPanel_6().setBounds(0, 400, 557, 37);
					    	 //Recalibrage du panel du boutton retour
					    	   getPanel_7().setBounds(0, 450, 557, 24);
					    	  // getPanel_6().setVisible(true);
						       getPanel_3().setVisible(true);
						}
						/*String[] prat=e.getItem().toString().split(" ");
						try {
							manageBD conn=new manageBD("gsb_ppe3");
							String[] detailPrat=conn.recupDetailsPraticien(prat);
							conn.deconnecte();
							System.out.println("nom :"+detailPrat[1].toString()+" prenom :"+detailPrat[2].toString()+"Adresse: "+detailPrat[3].toString()+" CP: "+detailPrat[4].toString()+" VILLE: "+detailPrat[5].toString()+ " Coeff. Notoriété: "+detailPrat[6].toString()+" Type: "+detailPrat[7].toString()); 
					       String[] entetes = {"Numéro", "Nom", "Prénom", "Adresse", "CP", "VILLE", "Coeff. Notoriété", "Type"};
					       getLblNewLabel_4().setText(entetes[0]);
					       getLblNewLabel_6().setText(entetes[1]);
					       getLabel_1().setText(entetes[2]);
					       getLblNewLabel_7().setText(entetes[3]);
					       
					       getLabel_4().setText(entetes[4]);
					       getLabel_6().setText(entetes[5]);
					       getLabel_8().setText(entetes[6]);
					       getLabel_3().setText(entetes[7]);
					       
					       getLblNewLabel_5().setText(detailPrat[0]);
					       getLabel().setText(detailPrat[1]);
					       getLabel_2().setText(detailPrat[2]);
					       getLblNewLabel_8().setText(detailPrat[3]);
					       getLblNewLabel_9().setText(detailPrat[4]);
					       getLabel_5().setText(detailPrat[5]);
					       getLabel_7().setText(detailPrat[6]);
					       getLabel_9().setText(detailPrat[7]);
					    	   frmPraticiens.setBounds(100, 100, 573, 431);
					    	   //getBtnNewButton_1().setBounds(10, 332, 89, 23);
					    	  // getBtnNewButton_2().setBounds(109, 332, 89, 23);
					    	   getPanel_3().setBounds(0, 145, 557, 176);
					    	 //Recalibrage du panel des bouttons de navigations entre les praticiens
					    	  // getPanel_6().setBounds(0, 322, 557, 37);
					    	 //Recalibrage du panel du boutton retour
					    	   getPanel_7().setBounds(0, 362, 557, 24);
					      // getPanel_6().setVisible(true);
					       getPanel_3().setVisible(true);
						} catch (SQLException e1) {
							// TODO Bloc catch généré automatiquement
							e1.printStackTrace();
						}*/
						 
					}
				}
			});
		}
	}

	//______________________________________________________________________________________________________//
	//_______________________________________ACTION DES BOUTTONS______________________________________________//
	public class ActionBoutton{
		private JButton boutton;
		
		public ActionBoutton(JButton bout){
			this.boutton=bout;
		}
		
		public void creezPraticien(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmPraticiens.dispose();
					new CreationPraticien(argV);
				}
			});
		}
		
		public void retour(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmPraticiens.dispose();
					if(argV[2].equals("Visiteur")){
						new MenuPrincipalV(argV);
					}
					else{
						new MenuPrincipal(argV);
					}
				}
			});
		}
		
		public void quitter(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmPraticiens.dispose();
				}
			});
		}
	}
	//___________________________________________________________________________________________________//
	//___________________________________________________________________________________________________//
}
