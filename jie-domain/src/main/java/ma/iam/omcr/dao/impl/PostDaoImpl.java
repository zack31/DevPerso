package ma.iam.omcr.dao.impl;


import ma.iam.omcr.dao.interfaces.IPostDao;
import ma.iam.omcr.domain.Post;
import ma.iam.socle.service.GenericDaoHibernateImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends GenericDaoHibernateImpl<Post, Long> implements IPostDao {

	@Autowired
	public PostDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory);
	}
        
        
    public Post getPostByTitle(String title,String status){
            
        Criteria criteriaPost = getSession().createCriteria(Post.class);
        criteriaPost.add(Restrictions.eq("postTitle", title).ignoreCase());
        criteriaPost.add(Restrictions.eq("postStatus", status).ignoreCase());

	    return (Post) criteriaPost.uniqueResult();

    }
}
