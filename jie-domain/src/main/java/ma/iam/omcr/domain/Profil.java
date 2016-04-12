package ma.iam.omcr.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFIL")
public class Profil{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDT")
	private Long idt;
	
	@Column(name = "LIBELLE", length =50,unique=true)
	private String libelle;

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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}		

	



}
