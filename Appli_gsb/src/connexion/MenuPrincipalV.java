package connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalV {

	private JFrame frmMenuPrincipal;
	private JButton btnNewRap;
	private JButton button;
	private JButton button_1;
	private JLabel lblNewLabel;
	private JLabel lblConsulterRapport;
	private JLabel lblMdicements;
	private JButton btnNewButton;
	private JButton button_2;
	private JLabel lblConsulterRapport_1;
	private JLabel lblNewLabel_1;
	private String[] args;
	private JButton button_3;
	private JLabel lblCrationDePraticien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalV window = new MenuPrincipalV(null);
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipalV(String[] argumentsVis) {
		initialize(argumentsVis);
		frmMenuPrincipal.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] arg) {
		this.args=arg;
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal Visiteur");
		frmMenuPrincipal.setBounds(100, 100, 450, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		frmMenuPrincipal.getContentPane().add(getBtnNewRap());
		frmMenuPrincipal.getContentPane().add(getButton());
		frmMenuPrincipal.getContentPane().add(getButton_1());
		frmMenuPrincipal.getContentPane().add(getLblNewLabel());
		frmMenuPrincipal.getContentPane().add(getLblConsulterRapport());
		frmMenuPrincipal.getContentPane().add(getLblMdicements());
		frmMenuPrincipal.getContentPane().add(getBtnNewButton());
		frmMenuPrincipal.getContentPane().add(getButton_2());
		frmMenuPrincipal.getContentPane().add(getLblConsulterRapport_1());
		frmMenuPrincipal.getContentPane().add(getLblNewLabel_1());
		frmMenuPrincipal.getContentPane().add(getButton_3());
		frmMenuPrincipal.getContentPane().add(getLblCrationDePraticien());
	}
	private JButton getBtnNewRap() {
		if (btnNewRap == null) {
			btnNewRap = new JButton("");
			btnNewRap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmMenuPrincipal.dispose();
					new NouvRapport(args);					
				}
			});
			btnNewRap.setBounds(62, 55, 33, 28);
		}
		return btnNewRap;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmMenuPrincipal.dispose();
					new ConsulterPrat(args);
				}
			});
			button.setBounds(62, 153, 33, 28);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmMenuPrincipal.dispose();
					new ConsultMedicament(args);
				}
			});
			button_1.setBounds(62, 204, 33, 28);
		}
		return button_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nouveau Rapport");
			lblNewLabel.setBounds(105, 55, 107, 28);
		}
		return lblNewLabel;
	}
	private JLabel getLblConsulterRapport() {
		if (lblConsulterRapport == null) {
			lblConsulterRapport = new JLabel("Consulter Praticien");
			lblConsulterRapport.setBounds(105, 153, 115, 28);
		}
		return lblConsulterRapport;
	}
	private JLabel getLblMdicements() {
		if (lblMdicements == null) {
			lblMdicements = new JLabel("M\u00E9dicaments");
			lblMdicements.setBounds(105, 204, 107, 28);
		}
		return lblMdicements;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Se deconnecter");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmMenuPrincipal.dispose();
					new Connexion();
				}
			});
			btnNewButton.setBounds(296, 227, 128, 23);
		}
		return btnNewButton;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmMenuPrincipal.dispose();
					new ConsulterRapport(args);
				}
			});
			button_2.setBounds(62, 105, 33, 28);
		}
		return button_2;
	}
	private JLabel getLblConsulterRapport_1() {
		if (lblConsulterRapport_1 == null) {
			lblConsulterRapport_1 = new JLabel("Consulter Rapport");
			lblConsulterRapport_1.setBounds(105, 105, 107, 28);
		}
		return lblConsulterRapport_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Choisissez parmi l'une des options suivantes :");
			lblNewLabel_1.setBounds(62, 11, 283, 14);
		}
		return lblNewLabel_1;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("");
			button_3.setBounds(222, 55, 33, 28);
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmMenuPrincipal.dispose();
					new CreationPraticien(args);
				}
			});
		}
		return button_3;
	}
	private JLabel getLblCrationDePraticien() {
		if (lblCrationDePraticien == null) {
			lblCrationDePraticien = new JLabel("Cr\u00E9ation de Praticien");
			lblCrationDePraticien.setBounds(265, 55, 141, 28);
		}
		return lblCrationDePraticien;
	}
}
