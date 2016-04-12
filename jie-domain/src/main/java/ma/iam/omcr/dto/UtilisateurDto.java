
package ma.iam.omcr.dto;

import java.io.Serializable;



public class UtilisateurDto implements Serializable {

    
    private static final long serialVersionUID = 1L;

    private Long idt;

    private String login;

    private String password;

    private String nom;

    private String prenom;

    private String email;

    private String profil;

    public Long getIdt() {
        return idt;
    }

    public void setIdt(Long idt) {
        this.idt = idt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

}
