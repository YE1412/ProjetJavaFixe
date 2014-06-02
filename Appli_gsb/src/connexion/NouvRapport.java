package connexion;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;

import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.xml.parsers.ParserConfigurationException;

public class NouvRapport {
	private JFrame frmNouveauRapport;
	private JLabel lblDateRapport;
	private JLabel lblNRapport;
	private JTextField txtnouv;
	private JLabel lblPraticien;
	private JComboBox<String> comboBox;
	private JLabel lblCoeff;
	private JTextField textField;
	private JLabel lblDate;
	private JLabel lblMotif;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private JTextField textField_1;
	private JLabel lblBilan;
	private JTextPane textPane;
	private JLabel lblOffres;
	private JSeparator separator;
	private JLabel lblProduit;
	private JComboBox<String> comboBox_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnEnvoyer;
	private JPanel panel;
	private JButton btnNewButton_2;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JPanel panel_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_3;
	private JPanel panel_2;
	private JYearChooser yearChooser_1;
	private JMonthChooser monthChooser_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_4;
	private JPanel panel_3;
	private JSpinner spinner;
	private String[] argV;
	private ListeDonnees listing;
	private ArrayList<Medicament> listeMedic;
	private ArrayList<Praticien> listePratic;
	/**
	 * Launch the a;pplication.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String[] visRes=new String[]{"p40", "Michel", "Responsable", "O", "SW"};
					//String[] visVis=new String[]{"a131", "Villechalane", "Visiteur"};
					String[] visDel=new String[]{"a17", "Andre","Délégué", "GY", "RA"};
					NouvRapport window = new NouvRapport(visDel);
					window.frmNouveauRapport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NouvRapport(String[] arg) {
		initialize(arg);
		frmNouveauRapport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arg) {
		this.argV=arg;
		//mat.setText(argV[0]);
		frmNouveauRapport = new JFrame();
		frmNouveauRapport.setTitle("Nouveau Rapport");
		frmNouveauRapport.setBounds(100, 100, 513, 496);
		frmNouveauRapport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauRapport.getContentPane().setLayout(null);
		frmNouveauRapport.getContentPane().add(getLblDateRapport());
		frmNouveauRapport.getContentPane().add(getPanel_1());
		frmNouveauRapport.getContentPane().add(getPanel_2());
		frmNouveauRapport.getContentPane().add(getLblNRapport());
		frmNouveauRapport.getContentPane().add(getTxtnouv());
		frmNouveauRapport.getContentPane().add(getLblPraticien());
		frmNouveauRapport.getContentPane().add(getComboBox());
		frmNouveauRapport.getContentPane().add(getLblCoeff());
		frmNouveauRapport.getContentPane().add(getTextField());
		frmNouveauRapport.getContentPane().add(getLblDate());
		frmNouveauRapport.getContentPane().add(getLblMotif());
		frmNouveauRapport.getContentPane().add(getComboBox_1());
		frmNouveauRapport.getContentPane().add(getTextField_1());
		frmNouveauRapport.getContentPane().add(getLblBilan());
		frmNouveauRapport.getContentPane().add(getTextPane());
		frmNouveauRapport.getContentPane().add(getLblOffres());
		frmNouveauRapport.getContentPane().add(getSeparator());
		frmNouveauRapport.getContentPane().add(getPanel_3());
		frmNouveauRapport.getContentPane().add(getBtnNewButton_1());
		frmNouveauRapport.getContentPane().add(getBtnEnvoyer());
		frmNouveauRapport.getContentPane().add(getComboBox());
		frmNouveauRapport.getContentPane().add(getBtnNewButton_2());
	}
	private JLabel getLblDateRapport() {
		if (lblDateRapport == null) {
			lblDateRapport = new JLabel("Date Rapport :");
			lblDateRapport.setBounds(44, 60, 103, 14);
		}
		return lblDateRapport;
	}
	private JLabel getLblNRapport() {
		if (lblNRapport == null) {
			lblNRapport = new JLabel("N. Rapport :");
			lblNRapport.setBounds(56, 21, 69, 14);
		}
		return lblNRapport;
	}
	private JTextField getTxtnouv() {
		if (txtnouv == null) {
			txtnouv = new JTextField();
			txtnouv.setBounds(135, 18, 86, 20);
			txtnouv.setEnabled(false);
			txtnouv.setText("(Nouv.)");
			txtnouv.setColumns(10);
		}
		return txtnouv;
	}
	private JLabel getLblPraticien() {
		if (lblPraticien == null) {
			lblPraticien = new JLabel("Praticien :");
			lblPraticien.setBounds(65, 112, 60, 14);
		}
		return lblPraticien;
	}
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	@SuppressWarnings({ "rawtypes" })
	private JComboBox getComboBox() { 
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			
			ActionCb actionremp = new ActionCb(comboBox, "coeff");
			actionremp.rempissage("praticiens", null);
			
			comboBox.setSize(50, 33);
			comboBox.setLocation(134, 103);
			//comboBox.setModel(new DefaultComboBoxModel());
			
			comboBox.setToolTipText("");
			comboBox.setBounds(135, 109, 160, 20);
			
		}
		return comboBox;
	}
	private JLabel getLblCoeff() {
		if (lblCoeff == null) {
			lblCoeff = new JLabel("Coeff :");
			lblCoeff.setBounds(305, 112, 41, 14);
		}
		return lblCoeff;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBackground(Color.BLACK);
			textField.setForeground(Color.BLACK);
			textField.setEnabled(false);
			textField.setBounds(346, 109, 69, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date :");
			lblDate.setBounds(84, 160, 41, 14);
		}
		return lblDate;
	}
	private JLabel getLblMotif() {
		if (lblMotif == null) {
			lblMotif = new JLabel("Motif :");
			lblMotif.setBounds(84, 204, 41, 14);
		}
		return lblMotif;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			@SuppressWarnings("unused")
			ActionCb action = new ActionCb(comboBox_1, "motif");
			comboBox_1.setBounds(135, 201, 124, 20);
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"P\u00E9riodicit\u00E9", "Actualisation", "Relance", "Sollicitation praticien", "Autre"}));
		}
		return comboBox_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(269, 201, 146, 20);
			textField_1.setEnabled(false);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblBilan() {
		if (lblBilan == null) {
			lblBilan = new JLabel("Bilan :");
			lblBilan.setBounds(84, 244, 41, 14);
		}
		return lblBilan;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(135, 244, 280, 79);
		}
		return textPane;
	}
	private JLabel getLblOffres() {
		if (lblOffres == null) {
			lblOffres = new JLabel("Offres");
			lblOffres.setBounds(10, 344, 46, 14);
		}
		return lblOffres;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 334, 635, 14);
		}
		return separator;
	}
	private JLabel getLblProduit() {
		if (lblProduit == null) {
			lblProduit = new JLabel("Produit :");
			lblProduit.setBounds(0, 0, 55, 23);
		}
		return lblProduit;
	}
	private JComboBox<String> getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox<String>();
			comboBox_2.setBounds(50, 0, 122, 23);
			ActionCb action = new ActionCb(comboBox_2, "offres");
			action.rempissage("medicaments", null);
		}
		return comboBox_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("+");
			btnNewButton.setBounds(247, 0, 44, 23);
			btnNewButton.setVisible(false);
			//Action(btnNewButton, 600, 400);
			ActionBouttons action=new ActionBouttons(btnNewButton);
			action.ajoutLigne(frmNouveauRapport, getPanel());
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Annuler");
			btnNewButton_1.setBounds(106, 419, 79, 23);
			ActionBouttons Action=new ActionBouttons(btnNewButton_1);
			Action.Annule(frmNouveauRapport);
		}
		return btnNewButton_1;
	}
	private JButton getBtnEnvoyer() {
		if (btnEnvoyer == null) {
			btnEnvoyer = new JButton("Envoyer");
			btnEnvoyer.setBounds(205, 419, 89, 23);
			ActionBouttons action= new ActionBouttons(btnEnvoyer);
			action.envoi(this);
		}
		return btnEnvoyer;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(110, 31, 305, 23);
			panel.setLayout(null);
			panel.add(getLblProduit());
			panel.add(getComboBox_2());
			panel.add(getSpinner());
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Retour");
			btnNewButton_2.setBounds(10, 419, 86, 23);
			ActionBouttons Action=new ActionBouttons(btnNewButton_2);
			Action.retour(frmNouveauRapport);
		}
		return btnNewButton_2;
	}
	
	
	private JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.getSpinner().setBounds(0, 0, 57, 20);
			yearChooser.setBounds(10, 11, 59, 20);
			yearChooser.setLayout(null);
		}
		return yearChooser;
	}
	private JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.getSpinner().setBounds(0, 0, 97, 20);
			monthChooser.setBounds(79, 11, 104, 20);
			monthChooser.setLayout(null);
		}
		return monthChooser;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(122, 46, 263, 52);
			panel_1.setLayout(null);
			panel_1.add(getYearChooser());
			panel_1.add(getMonthChooser());
			panel_1.add(getComboBox_3());
		
		}
		return panel_1;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getComboBox_3() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBox_3.setBounds(193, 11, 60, 20);
		}
		return comboBox_3;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(122, 137, 263, 56);
			panel_2.setLayout(null);
			panel_2.add(getYearChooser_1());
			panel_2.add(getMonthChooser_1());
			panel_2.add(getComboBox_4());
		}
		return panel_2;
	}
	private JYearChooser getYearChooser_1() {
		if (yearChooser_1 == null) {
			yearChooser_1 = new JYearChooser();
			yearChooser_1.setBounds(10, 21, 57, 20);
		}
		return yearChooser_1;
	}
	private JMonthChooser getMonthChooser_1() {
		if (monthChooser_1 == null) {
			monthChooser_1 = new JMonthChooser();
			monthChooser_1.setBounds(78, 21, 108, 20);
		}
		return monthChooser_1;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getComboBox_4() {
		if (comboBox_4 == null) {
			comboBox_4 = new JComboBox();
			comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBox_4.setBounds(196, 21, 57, 20);
		}
		return comboBox_4;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(10, 334, 635, 77);
			panel_3.setLayout(null);
			panel_3.add(getPanel());
		}
		return panel_3;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.setBounds(182, 1, 55, 20);
		}
		return spinner;
	}
	
//----------------------------------------------------------------------------------------------------------//	
//----------------------------------------------------------------------------------------------------------//		
//----------------------------------------------------------------------------------------------------------//	
	
	@SuppressWarnings("rawtypes")
	public boolean verifFrame(NouvRapport rapport){
		boolean result;
		//SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day=c.get(Calendar.DAY_OF_MONTH);
		/*System.out.println("Annee actuelle "+year);
		System.out.println("Moi actuelle "+month);
		System.out.println("Jour actuelle "+day);		
		System.out.println("Annee renseigné "+rapport.yearChooser.getYear());
		System.out.println("Moi renseigné "+monthChooser.getMonth());
		System.out.println("Jour renseigné "+Integer.parseInt(rapport.comboBox_3.getSelectedItem().toString()));
		*/
		JComboBox cbprat=rapport.comboBox;
		JComboBox cbmotif=rapport.comboBox_1;
	//Etape1//
		if(rapport.yearChooser.getYear() > year){
			result=false;
		}
		else if(rapport.yearChooser.getYear()==year){
			if(rapport.monthChooser.getMonth()==month){
				if( Integer.parseInt(rapport.comboBox_3.getSelectedItem().toString()) > day){
					System.out.println("Jour datetime "+Integer.parseInt(rapport.comboBox_3.getSelectedItem().toString()));
					result=false;
				}
				else{
					result=true;
				}
			}
			else if(rapport.monthChooser.getMonth()>month){
				result=false;
			}
			else{
				result=true;
			}
		}
		else{
			result=true;
		}
	//Etape2//
		if(result==true){
			if(rapport.yearChooser_1.getYear() > year){
				result=false;
			}
			else if(rapport.yearChooser_1.getYear()==year){
				if(rapport.monthChooser_1.getMonth()==month){
					if( Integer.parseInt(rapport.comboBox_4.getSelectedItem().toString()) > day){
						System.out.println("Jour datetime "+Integer.parseInt(rapport.comboBox_4.getSelectedItem().toString()));
						result=false;
					}
					else{
						result=true;
					}
				}
				else if(rapport.monthChooser_1.getMonth()>month){
					result=false;
				}
				else{
					result=true;
				}
			}
			else{
				result=true;
			}
		}
		//Etape3//
		if(result==true){
			if(cbprat.getSelectedItem().toString()=="Choisir Praticien :"){
				result=false;
			}
			else
			{
				result=true;
			}
		}
		//Etape4//
		if(result==true){
			if((cbmotif.getSelectedItem().toString()=="Autre")){
				if(rapport.textField_1.getText().isEmpty()){
					result=false;
				}
				else {
					result=true;
				}	
			}
			else{
				result=true;
			}
		}
		//Etape5//
		if(result==true){
			if(!rapport.textPane.getText().isEmpty()){
				result=true;
			}
			else
			{
				result=false;
			}
		}
		//Etape6//
		/*if(result==true){
			Container cont=rapport.frmNouveauRapport.getContentPane();
			JPanel panelparent=(JPanel) cont.getComponent(16);
			//panelparent.getComponentCount();
			ArrayList<JPanel> listpanel=new ArrayList<JPanel>(panelparent.getComponentCount());
			System.out.println("list des panel parents:"+panelparent.getComponentCount());
			for (int i=0; i<panelparent.getComponentCount(); i++){
				listpanel.add((JPanel) panelparent.getComponent(i));
			}
			//System.out.println("liste des composants :"+listpanel.get(0).toString());
			for(JPanel panel:listpanel){
				JComboBox cb= (JComboBox) panel.getComponent(1);
				if(cb.getSelectedItem().toString().equals("Medicaments :")){
					result=false;
				}
				else{
					result=true;
				}			
			}
			System.out.println("Liste panel :"+listpanel.size());
			System.out.println("Composants dans le panel :"+panel.getComponentCount());
		}*/
		return result;
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------Action des bouttons-------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	public class ActionBouttons{
		private JButton boutton;
		//private int i;
		
		public ActionBouttons(JButton bout){
			boutton=bout;
		}
		public void ajoutLigne(final JFrame fenetre, final JPanel panel){			
			boutton.addActionListener(new ActionListener(){

				@SuppressWarnings("rawtypes")
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Stub de la méthode généré automatiquement	
						
						//System.out.println("Panel :"+Ypanel+" frame :"+Heightframe);
						
						//Bouttons//
						JButton button=new JButton(getBtnNewButton().getText());
						int Ybutton=getBtnNewButton().getY();
						button.setBounds(247, Ybutton, 44, 23);
						button.setVisible(false);
						boutton.setVisible(false);
						//Spinner//
						JSpinner spinner=new JSpinner();
						int Yspinner=getSpinner().getY();
						spinner.setBounds(182, Yspinner, 55, 20);
						spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
						//Label//
						JLabel label =new JLabel(getLblProduit().getText());
						int Ylabel=getLblProduit().getY();
						label.setBounds(0, Ylabel, 55, 23);
						//Combobox//
						JComboBox<String> combobox=new JComboBox<String>();
						int Ycombobox=getComboBox_2().getY();
						combobox.setBounds(50, Ycombobox, 122, 23);
						//Panels//
						JPanel panelparent = getPanel_3();
						int Heightpanelparent=getPanel_3().getHeight();
						JPanel panelPrec = panel;					
						JPanel panelActuel=new JPanel();
						int Ypanel=panelPrec.getY()+40;
						
						panelActuel.setLayout(null);
						panelActuel.setBounds(110, Ypanel, 305, 23);
						panelActuel.add(label);
						panelActuel.add(combobox);
						panelActuel.add(spinner);
						panelActuel.add(button);						
						panelparent.add(panelActuel);
						panelparent.setBounds(10, 334, 635, Heightpanelparent+40);
						//Frame//
						JFrame frame = fenetre;
						int Heightframe=frame.getHeight()+40;
						frame.setBounds(100, 100, 513, Heightframe);
						
						//Différentes actions//
						ActionBouttons action=new ActionBouttons(button);
						action.ajoutLigne(frame, panelActuel);
	
						//Récupération des produits des combobox précédentes
						Container cont=fenetre.getContentPane();
						JPanel paneloffres=(JPanel) cont.getComponent(16);
						ArrayList<JPanel> listPanel=new ArrayList<JPanel>((paneloffres.getComponentCount())-1);
						for (int i=0; i<panelparent.getComponentCount()-1; i++){
							listPanel.add((JPanel) paneloffres.getComponent(i));
						}
						int i=0;
						String prodprec[];
						prodprec=new String[panelparent.getComponentCount()-1];
						for(JPanel Panel:listPanel){
							JComboBox CB;
							CB= (JComboBox) Panel.getComponent(1);
							prodprec[i]=CB.getSelectedItem().toString();
							i++;
						}
						
						//Remplissage de la Combobox
						ActionCb A_cb=new ActionCb(combobox, "offres");
						if(prodprec.length==0){
							A_cb.rempissage("medicaments", null);
						}
						else{
							A_cb.rempissage("medicaments", prodprec);
						}
						
						//Descente des boutton en dessous
						int YBtnEnvoi=getBtnEnvoyer().getY()+40;
						int YBtnAnnuler=getBtnNewButton_1().getY()+40;
						int YBtnRetour=getBtnNewButton_2().getY()+40;
						btnEnvoyer.setBounds(205, YBtnEnvoi, 89, 23);
						btnNewButton_1.setBounds(106, YBtnAnnuler, 79, 23);
						btnNewButton_2.setBounds(10, YBtnRetour, 86, 23);
				}
				
			});
		}
		
		public void envoi(final NouvRapport rapp){
			boutton.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent arg0) {
					boolean $verif=verifFrame(rapp);
					if($verif){
						//----------------------------récuprération du rapport---------------------------------------//
							String arguments[];
							arguments=new String[5];
							for(int i=0; i<arguments.length; i++){
								switch(i){
								case 0:
									//Récupération du matricule du visuteur
									String vismat=argV[0];
									arguments[i]=vismat;
									System.out.println("Visiteur matricule :"+vismat);
									break;
								case 1:
									//Récupération du numero du praticien
									int pratnom=rapp.comboBox.getSelectedIndex();
									Praticien prat=listePratic.get(pratnom);
									arguments[i]=String.valueOf(prat.getNum());
									System.out.println("numero praticien :"+prat.getNum());
									break;
								case 2:
									//Mise en forme de la date
									String date=String.valueOf(rapp.yearChooser.getYear())+"-"+String.valueOf(rapp.monthChooser.getMonth()+1)+"-"+rapp.comboBox_3.getSelectedItem().toString();
									arguments[i]=date;
									System.out.println("Date :"+date);
									break;
								case 3:
									//Récupération du bilan du rapport
									String bilan=rapp.textPane.getText();
									arguments[i]=bilan;
									System.out.println("Bilan :"+bilan);
									break;
								case 4:
									//Récupération du motif
									String motif=rapp.comboBox_1.getSelectedItem().toString();
									if(motif.equals("Autre")){
										motif+=" :"+rapp.textField_1.getText();
									}
									arguments[i]=motif;
									System.out.println("Motif :"+motif);
									break;
								}
								
							}
							//-------------------------------------------------------------------------------------------------//
							//--------------------------------------Récupération des offres------------------------------------//
							//-------------------------------------------------------------------------------------------------//
							String[][] offres;
							Container cont=rapp.frmNouveauRapport.getContentPane();
							//Récupération du JPanel où se trouve tous les éléments des offres//
							JPanel panelparent=(JPanel) cont.getComponent(16);
							ArrayList<JPanel> listpanel=new ArrayList<JPanel>(panelparent.getComponentCount());
				
							for (int i=0; i<panelparent.getComponentCount(); i++){
								listpanel.add((JPanel) panelparent.getComponent(i));
							}
							
							int i=0;
							offres=new String[panelparent.getComponentCount()][2];
							for(JPanel panel:listpanel){ //--> Récupération des médicaments offerts avec la quantité de ceux-ci
								@SuppressWarnings("rawtypes")
								JComboBox cb = (JComboBox) panel.getComponent(1);
								JSpinner qte = (JSpinner) panel.getComponent(2);
								offres[i][0]=cb.getSelectedItem().toString(); // Insertion des offres et de la qte dans un tableau 2D
								offres[i][1]=String.valueOf(qte.getValue());
								i++;
							}
							//Vérification des éléments de la table offres//
							for(int j=0; j<offres.length; j++){
								System.out.println("Produit "+(int)(j+1)+": "+offres[j][0]+" qte :"+offres[j][1]);
							}
							//Insertion du rapport//
							String res=null;
							List<String> keys = new ArrayList<String>();
							keys.add("tag");
							keys.add("matricule_vis");
							keys.add("numero_praticien");
							keys.add("rapport_date");
							keys.add("rapport_bilan");
							keys.add("rapport_motif");
							List<String> values = new ArrayList<String>();
							values.add("insertRapport");
							values.add(arguments[0]);
							values.add(arguments[1]);
							values.add(arguments[2]);
							values.add(arguments[3]);
							values.add(arguments[4]);
							res=ConnexionHTTP.post(keys, values);
							//Mise en forme de la réponse XML//
							res=res.substring(3);
							XMLtraitement treat=null;
							Map<String, Map<Integer, List<String>>> hash=null;
							//System.out.println(res.charAt(3));
							try {
								treat=new XMLtraitement(res);
							} catch (UnsupportedEncodingException
									| ParserConfigurationException e) {
								// TODO Bloc catch généré automatiquement
								e.printStackTrace();
							}
							
							try {
								hash=treat.retourneDonnees();
							} catch (UnsupportedEncodingException e) {
								// TODO Bloc catch généré automatiquement
								JOptionPane.showMessageDialog(null, "Erreur technique lors du traitement des données du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
								e.printStackTrace();
							}
							Map<Integer, List<String>> resultat=hash.get("Donnees");
							/*System.out.println(hash.size());
							System.out.println(resultat.size());*/
							List<String> verrif=resultat.get(0);
							System.out.println(verrif.get(0));
							if(verrif.get(0).equals("Erreur lors de l'insertion du rapport !"))
							{
								JOptionPane.showMessageDialog(null, "Erreur technique lors de l'insertion du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
							else
							//INSERTION DES OFFRES S'ILS EXISTENT
							{
								if(listpanel.size()>1)
								{
									keys=new ArrayList<String>();
									values=new ArrayList<String>();
									keys.add("tag");
									keys.add("num_Rapport");
									keys.add("vis_matricule");
									values.add("insertOffres");
									values.add(verrif.get(0));
									values.add(argV[0]);
									for(int j=0; j<listpanel.size(); j++)
									{
										//Gestion de la clé de l'offre
										String key="Offre"+(j+1);
										keys.add(key);
										//Mise en fome du detail de l'offre
										JPanel panel=(JPanel) listpanel.get(j);
										JComboBox<String> comb=(JComboBox<String>) panel.getComponent(1);
										JSpinner spinn=(JSpinner) panel.getComponent(2);
										String depot=comb.getSelectedItem().toString();
										String qte=spinn.getValue().toString();
										String value=depot+"_"+qte;
										values.add(value);
										
									}
									res=ConnexionHTTP.post(keys, values);
									res=res.substring(3);
									try {
										treat=new XMLtraitement(res);
									} catch (UnsupportedEncodingException
											| ParserConfigurationException e) {
										// TODO Bloc catch généré automatiquement
										e.printStackTrace();
									}
									
									try {
										hash=treat.retourneDonnees();
									} catch (UnsupportedEncodingException e) {
										// TODO Bloc catch généré automatiquement
										JOptionPane.showMessageDialog(null, "Erreur technique lors du traitement des données du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
										e.printStackTrace();
									}
									
									resultat=hash.get("Donnees");
									/*System.out.println(hash.size());
									System.out.println(resultat.size());*/
									verrif=resultat.get(0);
									System.out.println(verrif.get(0));
									if(verrif.get(0).equals("Erreur lors de l'insertion des offres !"))
									{
										JOptionPane.showMessageDialog(null, "Erreur technique lors de l'insertion du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Rapport incluant "+verrif.get(0)+" offre(s) inséré avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
										frmNouveauRapport.dispose();	
										NouvRapport fen=new NouvRapport(argV);
										fen.frmNouveauRapport.setVisible(true);
									}
								}
								else if((listpanel.size()==1) && (getComboBox_2().getSelectedIndex()!=0))
								{
									keys=new ArrayList<String>();
									values=new ArrayList<String>();
									keys.add("tag");
									keys.add("num_Rapport");
									keys.add("vis_matricule");
									keys.add("Offre1");
									values.add("insertOffres");
									values.add(verrif.get(0));
									values.add(argV[0]);
									//Mise en forme du detail de l'offre
									JPanel panel=(JPanel) listpanel.get(0);
									JComboBox<String> comb=new JComboBox<String>();
									comb=(JComboBox<String>) panel.getComponent(1);
									JSpinner spinn=(JSpinner) panel.getComponent(2);
									String depot=comb.getSelectedItem().toString();
									String qte=spinn.getValue().toString();
									String value=depot+"_"+qte;
									values.add(value);						
									
									res=ConnexionHTTP.post(keys, values);
									res=res.substring(3);
									try {
										treat=new XMLtraitement(res);
									} catch (UnsupportedEncodingException
											| ParserConfigurationException e) {
										// TODO Bloc catch généré automatiquement
										e.printStackTrace();
									}
									
									try {
										hash=treat.retourneDonnees();
									} catch (UnsupportedEncodingException e) {
										// TODO Bloc catch généré automatiquement
										JOptionPane.showMessageDialog(null, "Erreur technique lors du traitement des données du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
										e.printStackTrace();
									}
									
									resultat=hash.get("Donnees");
									/*System.out.println(hash.size());
									System.out.println(resultat.size());*/
									verrif=resultat.get(0);
									System.out.println(verrif.get(0));
									if(verrif.get(0).equals("Erreur lors de l'insertion des offres !"))
									{
										JOptionPane.showMessageDialog(null, "Erreur technique lors de l'insertion du rapport", "Information", JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Rapport incluant "+verrif.get(0)+" offre(s) inséré avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
										frmNouveauRapport.dispose();	
										NouvRapport fen=new NouvRapport(argV);
										fen.frmNouveauRapport.setVisible(true);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Rapport inséré sans offres", "Information", JOptionPane.INFORMATION_MESSAGE);
									frmNouveauRapport.dispose();	
									NouvRapport fen=new NouvRapport(argV);
									fen.frmNouveauRapport.setVisible(true);
								}
							}
					}
					
					
					else{
						JOptionPane.showMessageDialog(null, "Saisissez tous les champs avant d'envoyer le rapport \n Et vérifiez surtout que les date renseignées sont antérieures au jour de la création du rapport !", "Erreur :", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
		}
		public void retour(final JFrame frame){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					if(argV[2].equals("Visiteur")){
						new MenuPrincipalV(argV);
					}
					else{
						new MenuPrincipal(argV);
					}
				}
			});
		}
		public void Annule(final JFrame frame){
			boutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					NouvRapport rapport=new NouvRapport(argV);
					rapport.frmNouveauRapport.setVisible(true);
				}
			});
		}
	}
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	//-----------------------------------------------------------Action des comboBox--------------------------------------------------------//
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	public class ActionCb{
		private JComboBox<String> combobox;
		//Construcuteur de la classe//
		public ActionCb(JComboBox<String> combo, String type){
			combobox=combo;
			switch(type){
			case "coeff":
				combobox.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent arg0) {
						if(combobox.getSelectedIndex()!=0)
						{
							int index=combobox.getSelectedIndex();
							//String pra=(String) combobox.getSelectedItem();
							Praticien pratic=listePratic.get(index-1);
							getTextField().setText(String.valueOf(pratic.getcoeff()));
						}
						else
						{
							getTextField().setText("");
						}
					}
				});
				break;
			case "motif":
				combobox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(arg0.getItem().toString()=="Autre"){
							textField_1.setEnabled(true);
						}
						else
						{
							textField_1.setText("");	
							textField_1.setEnabled(false);
						}
					}
				});
				break;
			case "offres":
				combobox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						//System.out.println(combobox.getParent());
						JPanel pan=null;
						JButton butt=null;
						if(combobox.getParent()!=null)
						{
							pan=(JPanel) combobox.getParent();
							//System.out.println(pan.getComponentCount());
							butt=(JButton) pan.getComponent(3);
							if(arg0.getItem().toString()=="Medicaments :")
							{
								butt.setVisible(false);
							}
							else
							{
								butt.setVisible(true);
							}
						}
						else
						{
							pan=getPanel();
							//System.out.println(pan.getComponentCount());
							butt=getBtnNewButton();
							if(arg0.getItem().toString()=="Choisir Medicament :"){
								butt.setVisible(false);
							}
							else
							{
								butt.setVisible(true);
							}
						}
					}
				});
				break;
			case "null":
				break;
				default:
					break;
			}
		}
		//Fonction permettant de remplir toutes les Combobox de la page//
		public void rempissage(String type, String[] medprec){
			ArrayList<String> cb=null;
			String str=null;
			List<String> keys = null, values=null;
			XMLtraitement treat=null;
			Map<String, Map<Integer, List<String>>> hash=null;
			int i=1;
			switch(type)
			{
				//Cas où on remplit la Combobox de Praticiens
				case "praticiens":
					
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
					cb=new ArrayList<String>();
					cb.add(0, "Choisir Praticien :");
					listePratic=new ArrayList<Praticien>();
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
							listePratic.add(prat);
							cb.add(i, Dpra.get(1)+" "+Dpra.get(2));
						}
						else
						{
							cb.add(i, Dpra.get(0));
						}
						i++;
					}
					listing=new ListeDonnees(cb);
					for(int j=0; j<listing.getNbDonnees(); j++)
					{
						//System.out.println(listing.getDonnee(j));
						combobox.addItem(listing.getDonnee(j));
					}
					combobox.setBounds(135, 109, 160, 20);
					break;
				case "medicaments":
					keys=new ArrayList<String>();
					values=new ArrayList<String>();
					keys.add("tag");
					values.add("recupMedicaments");
					
					str=ConnexionHTTP.post(keys, values);
					//------------------------TRAITEMENT DU FICHIER XML RETOURNE-----------------------//
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
					Map<Integer, List<String>> medicaments=hash.get("Donnees");
					cb=new ArrayList<String>();
					cb.add(0, "Choisir Medicament :");
					listeMedic=new ArrayList<Medicament>();
					for(Integer key:medicaments.keySet())
					{
						ArrayList<String> Dmed=(ArrayList<String>) medicaments.get(key);
						if(medicaments.size()>1)
						{	
							//System.out.println(praticiens.get(key));
							//System.out.println(Dpra.get(1));
							//System.out.println(key);
							//cb[i]=Dpra.get(1)+" "+Dpra.get(2);
							Medicament medic=new Medicament(Dmed.get(0), Dmed.get(1), Dmed.get(2), Dmed.get(3), Dmed.get(4), Dmed.get(5), Dmed.get(6), Dmed.get(7));
							listeMedic.add(medic);
							cb.add(i, Dmed.get(0));
						}
						else
						{
							cb.add(i, Dmed.get(0));
						}
						i++;
					}
					listing=new ListeDonnees(cb);
					//comboBox.setBounds(135, 109, 160, 20);
					if(medprec!=null)
					{
						//Mise en forme de la clause de la sélection des medicaments//
						for(String depotsel:medprec)
						{
							listing.removeDonnee(depotsel);
						}
					}
					for(int j=0; j<listing.getNbDonnees(); j++)
					{
						//System.out.println(listing.getDonnee(j));
						combobox.addItem(listing.getDonnee(j));
					}		
					break;
				default:
					break;
			}
			
		}
	}
}
		
