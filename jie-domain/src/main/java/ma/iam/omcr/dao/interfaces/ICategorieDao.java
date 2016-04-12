package ma.iam.omcr.dao.interfaces;


import ma.iam.omcr.domain.Categorie;
import ma.iam.socle.service.GenericDao;
 


public interface ICategorieDao extends GenericDao<Categorie, Long> {

	 public Categorie getCategorieByName(String name);
}
