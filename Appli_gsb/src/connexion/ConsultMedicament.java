package connexion;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.xml.parsers.ParserConfigurationException;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;

public class ConsultMedicament {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private SpringLayout sl_panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JComboBox<String> comboBox;
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
	private JTextField textField;
	private JTextPane textField_1;
	private JTextField textField_5;
	/*private JPanel panel_15;
	private JPanel panel_16;*/
	/*private JButton btnNewButton;
	private JButton btnNewButton_1;*/
	private String[] args;
	private ArrayList<Medicament> listeMedicaments;
	private Medicament medicamentEnVisu;

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
					ConsultMedicament window = new ConsultMedicament(visDel);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultMedicament(String[] arguments) {
		initialize(arguments);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arg) {
		this.args=arg;
		recupererLesMedicaments();
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getPanel_1());
		getPanel_2().setVisible(false);
		frame.getContentPane().add(getPanel_2());	
		JButton btnNewButton_2 = new JButton("Retour");
		ActionBouttons action=new ActionBouttons(btnNewButton_2);
		action.retour();
		btnNewButton_2.setBounds(0, 543, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		frame.setVisible(true);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 589, 41);
			sl_panel = new SpringLayout();
			panel.setLayout(sl_panel);
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("LISTE DES MEDICAMENTS");
			sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, getPanel());
			sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 231, SpringLayout.WEST, getPanel());
		}
		return lblNewLabel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(0, 40, 589, 82);
			panel_1.setLayout(null);
			panel_1.add(getComboBox());
			panel_1.add(getLblNewLabel_1());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("-S\u00E9lectionnez un m\u00E9dicament pour afficher les d\u00E9tails de celui-ci :");
			lblNewLabel_1.setBounds(139, 11, 403, 14);
			sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, getPanel());
		}
		return lblNewLabel_1;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			ActionCBB action = new ActionCBB(comboBox);
			action.remplir();
			action.AfficherDetails();
			comboBox.setBounds(246, 36, 132, 20);
		}
		return comboBox;
	}
	private JPanel getPanel_2() {
		if (panel_2== null) {
			panel_2 = new JPanel();
			panel_2.setBounds(0, 122, 589, 374);
			panel_2.setLayout(new GridLayout(0, 2, 0, 5));
			panel_2.add(getPanel_3());
			panel_2.add(getPanel_4());
			panel_2.add(getPanel_5());
			panel_2.add(getPanel_6());
			panel_2.add(getPanel_7());
			panel_2.add(getPanel_8());
			panel_2.add(getPanel_9());
			panel_2.add(getPanel_11());
			panel_2.add(getPanel_14());
			panel_2.add(getPanel_13());
			panel_2.add(getPanel_12());
			panel_2.add(getPanel_10());
			/*panel_2.add(getPanel_15());
			panel_2.add(getPanel_16());*/
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Depot Legal :");
			lblNewLabel_2.setBounds(130, 11, 91, 23);
			panel_3.add(lblNewLabel_2);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(0, 11, 86, 23);
			panel_4.add(textField);
			textField.setColumns(10);
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Famille :");
			lblNewLabel_3.setBounds(151, 0, 66, 23);
			panel_5.add(lblNewLabel_3);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			
			textField_1 = new JTextPane();		
			textField_1.setBounds(0, 0, 199, 23);
			JScrollPane scroll=new JScrollPane(textField_1);
			scroll.setBounds(0, 0, 213, 49);
			panel_6.add(scroll);
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Composition :");
			lblNewLabel_4.setBounds(125, 0, 92, 23);
			panel_7.add(lblNewLabel_4);
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(null);
					
			JTextPane textPane = new JTextPane();
			JScrollPane scroll=new JScrollPane(textPane);
			scroll.setBounds(0, 0, 213, 49);
			panel_8.add(scroll);
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Effets :");
			lblNewLabel_5.setBounds(154, 0, 63, 23);
			panel_9.add(lblNewLabel_5);
		}
		return panel_9;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setLayout(null);
			textField_5 = new JFormattedTextField(NumberFormat.getInstance());
			textField_5.setBounds(0, 11, 86, 23);
			panel_10.add(textField_5);
			textField_5.setColumns(10);
		}
		return panel_10;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(null);		
			JTextPane textPane = new JTextPane();			
			JScrollPane scroll=new JScrollPane(textPane);
			scroll.setBounds(0, 0, 213, 49);
			panel_11.add(scroll);
		}
		return panel_11;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(null);
			
			JLabel lblNewLabel_7 = new JLabel("Prix Echantillon :");
			lblNewLabel_7.setBounds(112, 11, 105, 23);
			panel_12.add(lblNewLabel_7);
		}
		return panel_12;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(null);
			JTextPane textPane = new JTextPane();
			JScrollPane scroll=new JScrollPane(textPane);
			scroll.setBounds(0, 0, 212, 49);
			panel_13.add(scroll);
		}
		return panel_13;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Contre Indic. :");
			lblNewLabel_6.setBounds(120, 0, 97, 23);
			panel_14.add(lblNewLabel_6);
		}
		return panel_14;
	}
	/*private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.setLayout(null);
			panel_15.add(getBtnNewButton());
		}
		return panel_15;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setLayout(null);
			panel_16.add(getBtnNewButton_1());
		}
		return panel_16;
	}*/
	/*private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Pr\u00E9c\u00E9dent");
			btnNewButton.setBounds(138, 11, 109, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Suivant");
			btnNewButton_1.setBounds(47, 11, 105, 23);
		}
		return btnNewButton_1;
	}*/
//----------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------Action des comboBoxes-----------------------------------------------------//
//----------------------------------------------------------------------------------------------------------------------//
	public class ActionCBB{
		private JComboBox<String> combo;
		
		public ActionCBB(JComboBox<String> combobox){
			combo=combobox;
		}
		
		public void remplir(){
			combo.addItem("Choisir médicament :");
			for(Medicament medicament:listeMedicaments)
			{
				combo.addItem(medicament.getDepotLegal());
			}
		}
		
		public void AfficherDetails(){
			combo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					String medSelect=e.getItem().toString();
					if(!medSelect.equals("Choisir médicament :"))
					{
						for(Medicament med:listeMedicaments)
						{
							if(med.getDepotLegal().equals(medSelect))
							{
								medicamentEnVisu=med;
								break;
							}
						}
						JScrollPane Scroll;
						JScrollPane Scroll2;
						JScrollPane Scroll3;
						JScrollPane Scroll4;
						JTextField depotL= (JTextField) getPanel_4().getComponent(0);
						Scroll = (JScrollPane) getPanel_6().getComponent(0);
						Scroll2= (JScrollPane) getPanel_8().getComponent(0);
						Scroll3= (JScrollPane) getPanel_11().getComponent(0);
						Scroll4= (JScrollPane) getPanel_13().getComponent(0);
						JTextField prixEch= (JTextField) getPanel_10().getComponent(0);
						//System.out.println("nb :"+scroll.getComponentCount());
						JViewport Viewfamille=(JViewport) Scroll.getViewport();
						JViewport Viewcomp=(JViewport) Scroll2.getViewport();
						JViewport Vieweffets=(JViewport) Scroll3.getViewport();
						JViewport ViewcontreInd=(JViewport) Scroll4.getViewport();
						JTextPane famille=(JTextPane) Viewfamille.getView();
						JTextPane comp=(JTextPane) Viewcomp.getView();
						JTextPane effets=(JTextPane) Vieweffets.getView();
						JTextPane contreInd=(JTextPane) ViewcontreInd.getView();
						
						depotL.setText(medicamentEnVisu.getDepotLegal());	
						famille.setText(medicamentEnVisu.getFamLibelle());
						comp.setText(medicamentEnVisu.getComp());
						effets.setText(medicamentEnVisu.getEffet());		
						contreInd.setText(medicamentEnVisu.getContreInd());								
						prixEch.setText(medicamentEnVisu.getPrx());
						
						getPanel_2().setVisible(true);
					}
					else
					{
						getPanel_2().setVisible(false);
					}
				}
			});
		}
	}
//----------------------------------------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------------------------------------//
	public class ActionBouttons{
		private JButton boutton;
		
		public ActionBouttons(JButton bout){
			boutton=bout;
		}
		
		public void retour(){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
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
	
	public void recupererLesMedicaments()
	{
		
			String str=null;
			List<String> keys = null, values=null;
			XMLtraitement treat=null;
			Map<String, Map<Integer, List<String>>> hash=null;
			
			keys=new ArrayList<String>();
			values=new ArrayList<String>();
			keys.add("tag");		
			values.add("recupMedicaments");
			
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
			Map<Integer, List<String>> Allmedicaments=hash.get("Donnees");
			listeMedicaments=new ArrayList<Medicament>();
			for(Integer key:Allmedicaments.keySet())
			{
				if(Allmedicaments.size()>1)
				{	
					ArrayList<String> DMedic=(ArrayList<String>) Allmedicaments.get(key);
					Medicament medic=new Medicament(DMedic.get(0), DMedic.get(1), DMedic.get(2), DMedic.get(3), DMedic.get(4), DMedic.get(5), DMedic.get(6), DMedic.get(7));
					listeMedicaments.add(medic);
					
					System.out.println(DMedic.get(0)+" "+DMedic.get(1)+" "+DMedic.get(2)+" "+DMedic.get(3)+" "+DMedic.get(4)+" "+DMedic.get(5)+" "+DMedic.get(6));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erreur technique lors de la récupération des visiteurs", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	
}
