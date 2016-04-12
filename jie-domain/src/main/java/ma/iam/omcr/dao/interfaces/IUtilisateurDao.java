package ma.iam.omcr.dao.interfaces;


import ma.iam.omcr.domain.Utilisateur;
import ma.iam.socle.service.GenericDao;


public interface IUtilisateurDao extends GenericDao<Utilisateur, Long>{
 
	/**
	 * @param login login
	 * @return user
	 */
	public Utilisateur getUserByLogin(String login) ;
}
