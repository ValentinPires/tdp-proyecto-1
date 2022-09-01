package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel Apellido;
	private JLabel Nombre;
	private JLabel Email;
	private JLabel GitHubURL;
	private JTextField LUtextField;
	private JTextField ApellidoTextField;
	private JTextField NombreTextField;
	private JTextField EmailTextField;
	private JTextField gitHubUrlTextField;
	private JPanel panel;
	private JLabel FotoLabel;
	private JLabel horaLabel;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(636, 277));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 324, 212);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel LU = new JLabel("LU");
		
		Apellido = new JLabel("Apellido");
		
		Nombre = new JLabel("Nombre");
		
		Email = new JLabel("E-mail");
		
		GitHubURL = new JLabel("GitHub URL");
		
		LUtextField = new JTextField();
		LUtextField.setColumns(10);
		LUtextField.setText(Integer.toString(studentData.getId()));
		
		ApellidoTextField = new JTextField();
		ApellidoTextField.setColumns(10);
		ApellidoTextField.setText(studentData.getLastName());
		
		NombreTextField = new JTextField();
		NombreTextField.setColumns(10);
		NombreTextField.setText(studentData.getFirstName());
		
		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setText(studentData.getMail());
		
		gitHubUrlTextField = new JTextField();
		gitHubUrlTextField.setColumns(10);
		gitHubUrlTextField.setText(studentData.getGithubURL());
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(GitHubURL)
						.addComponent(Apellido)
						.addComponent(Nombre)
						.addComponent(Email)
						.addComponent(LU))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
								.addComponent(NombreTextField)
								.addComponent(ApellidoTextField)))
						.addGroup(gl_tabInformation.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LUtextField, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
						.addComponent(EmailTextField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addComponent(gitHubUrlTextField))
					.addContainerGap(296, Short.MAX_VALUE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(LU)
						.addComponent(LUtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(Apellido)
						.addComponent(ApellidoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(Nombre)
						.addComponent(NombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(Email)
						.addComponent(EmailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(GitHubURL)
						.addComponent(gitHubUrlTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setBounds(605, 5, -258, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel FotoLabel_1 = new JLabel("");
		FotoLabel_1.setBounds(367, 11, 204, 206);
		contentPane.add(FotoLabel_1);
		FotoLabel_1.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/yo.jpg")));
		FotoLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Calendar calendario =Calendar.getInstance();
		horaLabel = new JLabel("Esta ventana fue generada el "+calendario.get(Calendar.DAY_OF_MONTH)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+calendario.get(Calendar.YEAR)+" a las "+calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND));
		horaLabel.setBounds(15, 221, 314, 16);
		contentPane.add(horaLabel);
		ImageIcon foto = new ImageIcon(studentData.getPathPhoto());
		//FotoLabel.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/yo.jpg")));
	}
}
