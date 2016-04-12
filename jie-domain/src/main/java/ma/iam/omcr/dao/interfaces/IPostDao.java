package ma.iam.omcr.dao.interfaces;


import ma.iam.omcr.domain.Post;
import ma.iam.socle.service.GenericDao;

 

public interface IPostDao extends GenericDao<Post, Long> {

	public Post getPostByTitle(String title,String status);
}
