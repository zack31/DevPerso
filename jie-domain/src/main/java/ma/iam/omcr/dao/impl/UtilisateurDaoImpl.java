package ma.iam.omcr.dao.impl;


import ma.iam.omcr.dao.interfaces.IUtilisateurDao;
import ma.iam.omcr.domain.Utilisateur;
import ma.iam.socle.service.GenericDaoHibernateImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class UtilisateurDaoImpl extends GenericDaoHibernateImpl<Utilisateur, Long> implements IUtilisateurDao{

	/**
	 * @param sessionFactory la session factory 
	 */
	@Autowired
	public UtilisateurDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	/**
	 * @param login login
	 * @return user
	 */
	public Utilisateur getUserByLogin(String login) {
		Criteria cr = this.getSession().createCriteria(Utilisateur.class);
		cr.add(Restrictions.eq("login", login).ignoreCase());
		return (Utilisateur) cr.uniqueResult();
	}
	
	
	
	
}
