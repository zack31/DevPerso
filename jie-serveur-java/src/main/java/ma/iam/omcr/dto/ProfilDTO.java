package ma.iam.omcr.dto;

import java.io.Serializable;


public class ProfilDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private long idt;
	
	private String libelle;

	
	public long getIdt() {
		return idt;
	}

	public void setIdt(long id) {
		this.idt = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String name) {
		this.libelle = name;
	}

}
