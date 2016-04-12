package ma.iam.omcr.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDT")
	private Long idt;

	@Column(name = "LOGIN", length = 50, unique = true)
	private String login;
        
    @Column(name = "PASSWORD", length = 100, unique = true)
	private String password;

	@Column(name = "LASTNAME", length = 50)
	private String nom;

	@Column(name = "FIRSTNAME", length = 50)
	private String prenom;

	@Column(name = "MAIL", length = 50)
	private String mail;

	
	@ManyToMany(targetEntity=Profil.class, fetch = FetchType.EAGER)
	@JoinTable(name="PROFIL_USER",joinColumns=@JoinColumn(name="IDT_USER"),inverseJoinColumns=@JoinColumn(name="IDT_PROFIL"))  	
	private List<Profil> listProfils;



	/**
	 * @return the idt
	 */
	public Long getIdt() {
		return idt;
	}



	/**
	 * @param idt the idt to set
	 */
	public void setIdt(Long idt) {
		this.idt = idt;
	}



	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}



	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}



	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}



	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



	/**
	 * @return the listProfils
	 */
	public List<Profil> getListProfils() {
		return listProfils;
	}



	/**
	 * @param listProfils the listProfils to set
	 */
	public void setListProfils(List<Profil> listProfils) {
		this.listProfils = listProfils;
	}

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
	
	
	
}
