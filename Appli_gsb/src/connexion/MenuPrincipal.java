package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frmMenuPrincipal;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	//private JButton button_2;
	private JButton button_3;
	private JLabel lblNewLabel;
	private JLabel lblConsulterRapport;
	private JLabel lblConsulterPraticiens;
	//private JLabel lblMdicamants;
	private JLabel lblAutresVisiteurs;
	private JButton btnNewButton_1;
	private String[] argV;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String[] visRes=new String[]{"p40", "Michel", "Responsable", "O", "SW"};
					
					String[] visDel=new String[]{"a17", "Andre","Délégué", "GY", "RA"};
					MenuPrincipal window = new MenuPrincipal(visDel);
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MenuPrincipal(String[] argumentsVis) {
		initialize(argumentsVis);	
		frmMenuPrincipal.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arg) {
		this.argV=arg;
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal Responsable/D\u00E9l\u00E9gu\u00E9");
		frmMenuPrincipal.setBounds(100, 100, 502, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		frmMenuPrincipal.getContentPane().add(getBtnNewButton());
		frmMenuPrincipal.getContentPane().add(getButton());
		frmMenuPrincipal.getContentPane().add(getButton_1());
		//frmMenuPrincipal.getContentPane().add(getButton_2());
		frmMenuPrincipal.getContentPane().add(getButton_3());
		frmMenuPrincipal.getContentPane().add(getLblNewLabel());
		frmMenuPrincipal.getContentPane().add(getLblConsulterRapport());
		frmMenuPrincipal.getContentPane().add(getLblConsulterPraticiens());
		//frmMenuPrincipal.getContentPane().add(getLblMdicamants());
		frmMenuPrincipal.getContentPane().add(getLblAutresVisiteurs());
		frmMenuPrincipal.getContentPane().add(getBtnNewButton_1());
		
		/*JButton button_4 = new JButton("");
		ActionB action = new ActionB(button_4);
		action.envoi(6);
		button_4.setBounds(257, 32, 34, 31);
		frmMenuPrincipal.getContentPane().add(button_4);*/
		
		JButton button_5 = new JButton("");
		ActionB action=new ActionB(button_5);
		action.envoi(7);
		button_5.setBounds(256, 74, 34, 31);
		frmMenuPrincipal.getContentPane().add(button_5);
		
		/*JLabel lblCreationMdicaments = new JLabel("Cr\u00E9ation m\u00E9dicaments");
		lblCreationMdicaments.setBounds(301, 32, 132, 31);
		frmMenuPrincipal.getContentPane().add(lblCreationMdicaments);*/
		
		JLabel lblCrationPraticiens = new JLabel("Cr\u00E9ation praticiens");
		lblCrationPraticiens.setBounds(300, 74, 132, 31);
		frmMenuPrincipal.getContentPane().add(lblCrationPraticiens);
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			ActionB action = new ActionB(btnNewButton);
			action.envoi(1);
			btnNewButton.setBounds(79, 143, 34, 31);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			ActionB action=new ActionB(button);
			action.envoi(2);
			button.setBounds(79, 59, 34, 31);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			ActionB act = new ActionB(button_1);
			act.envoi(3);
			button_1.setBounds(79, 101, 34, 31);
		}
		return button_1;
	}
	/*private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			ActionB action=new ActionB(button_2);
			action.envoi(4);
			button_2.setBounds(257, 158, 34, 31);
		}
		return button_2;
	}*/
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("");
			ActionB action= new ActionB(button_3);
			action.envoi(5);
			button_3.setBounds(256, 116, 34, 31);
		}
		return button_3;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nouveau Rapport");
			lblNewLabel.setBounds(123, 143, 99, 31);
		}
		return lblNewLabel;
	}
	private JLabel getLblConsulterRapport() {
		if (lblConsulterRapport == null) {
			lblConsulterRapport = new JLabel("Consulter Rapport");
			lblConsulterRapport.setBounds(123, 59, 123, 31);
		}
		return lblConsulterRapport;
	}
	private JLabel getLblConsulterPraticiens() {
		if (lblConsulterPraticiens == null) {
			lblConsulterPraticiens = new JLabel("Consulter Praticiens");
			lblConsulterPraticiens.setBounds(123, 101, 123, 31);
		}
		return lblConsulterPraticiens;
	}
	/*private JLabel getLblMdicamants() {
		if (lblMdicamants == null) {
			lblMdicamants = new JLabel("M\u00E9dicaments");
			lblMdicamants.setBounds(301, 158, 99, 31);
		}
		return lblMdicamants;
	}*/
	private JLabel getLblAutresVisiteurs() {
		if (lblAutresVisiteurs == null) {
			lblAutresVisiteurs = new JLabel("Autres Visiteurs");
			lblAutresVisiteurs.setBounds(300, 116, 99, 31);
		}
		return lblAutresVisiteurs;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Se d\u00E9connecter");
			ActionB action=new ActionB(btnNewButton_1);
			action.envoi(8);
			btnNewButton_1.setBounds(344, 228, 132, 23);
		}
		return btnNewButton_1;
	}
	
//________________________________________ACTION DES BOUTTONS_____________________________________________________//
	//____________________________________________________________________________________________________//
public class ActionB{
	private JButton bout;
	
	public ActionB(JButton b){
		this.bout=b;
	}
	
	public void envoi(final int dir){
		bout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(dir){
				case 1:
					new NouvRapport(argV);
					frmMenuPrincipal.dispose();
					break;
				case 2:
					frmMenuPrincipal.dispose();
					new ConsulterRapport(argV);
					break;
				case 3:
					frmMenuPrincipal.dispose();
					new ConsulterPrat(argV);
					break;
				case 4:
					frmMenuPrincipal.dispose();
					new ConsultMedicament(argV);
					break;
				case 5:
					frmMenuPrincipal.dispose();
					new AutresVisiteurs(argV);
					break;
				case 6:
					frmMenuPrincipal.dispose();
					new CreationMedicament(argV);
					break;
				case 7:
					frmMenuPrincipal.dispose();
					new CreationPraticien(argV);
					break;
				case 8:
					frmMenuPrincipal.dispose();
					new Connexion();
					break;
				}
			}
		});
		
	}
}
}
