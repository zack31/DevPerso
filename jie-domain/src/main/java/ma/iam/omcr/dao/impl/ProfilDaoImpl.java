package ma.iam.omcr.dao.impl;

import ma.iam.omcr.dao.interfaces.IProfilDao;
import ma.iam.omcr.domain.Profil;
import ma.iam.socle.service.GenericDaoHibernateImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
 
@Repository
public class ProfilDaoImpl extends GenericDaoHibernateImpl<Profil, Long> implements IProfilDao{

	@Autowired
	public ProfilDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory);
               
	}

//	/** récupère les profils d'un utilisateur
//	 * @param name libellé
//	 * @return profil
//	 */
//	public Profil findByName(String name) {
//		Criteria cr = this.getSession().createCriteria(Profil.class);
//		cr.add(Restrictions.eq("libelle",name).ignoreCase());
//		//Profils ra = (Profils) this.getHibernateTemplate().find("from Profils as p where lower(p.libelle) = lower(?)", name).get(0);
//		return (Profil) cr.uniqueResult();
//	}
}
