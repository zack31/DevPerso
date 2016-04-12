package ma.iam.omcr.dao.impl;


import ma.iam.omcr.dao.interfaces.ICategorieDao;
import ma.iam.omcr.domain.Categorie;
import ma.iam.socle.service.GenericDaoHibernateImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CategorieDaoImpl extends GenericDaoHibernateImpl<Categorie, Long>
		implements ICategorieDao {

	@Autowired
	public CategorieDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory);
	}

     public Categorie getCategorieByName(String name){
         Criteria criteriaCategorie = getSession().createCriteria(Categorie.class);
         criteriaCategorie.add(Restrictions.eq("name", name).ignoreCase());
         return (Categorie) criteriaCategorie.uniqueResult();
        }

}
