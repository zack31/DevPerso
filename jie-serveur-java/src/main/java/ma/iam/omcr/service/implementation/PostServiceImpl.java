package ma.iam.omcr.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import ma.iam.omcr.dao.interfaces.ICategorieDao;
import ma.iam.omcr.dao.interfaces.IPostDao;
import ma.iam.omcr.domain.Categorie;
import ma.iam.omcr.domain.Post;
import ma.iam.omcr.dto.PostDto;
import ma.iam.omcr.service.interfaces.IPostService;
import ma.iam.omcr.util.Deserialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Path("services/posts")
@Produces("application/json")
public class PostServiceImpl implements IPostService {

    @Autowired
    IPostDao postDaoImpl;
    
    @Autowired
    ICategorieDao categorieDaoImpl;
    
    private final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @GET
    @Path("/listAllPosts")
    public List<PostDto> getListAllPosts() {
        
    	List<Post> listPosts = postDaoImpl.findAll();
        return convertToAllListPostDto(listPosts);
    }
    
    @GET
    @Path("/getPostByTitle")
    public PostDto getPostByTitle(@QueryParam ("title")String title,@QueryParam ("status")String status){
        
        Post post = postDaoImpl.getPostByTitle(title,status);
        
        return convertToPostDto(post);
    }
    
    
    @GET
    @Path("/getPostsByCategorie")
    public List<PostDto> getPostsByCategorie(@QueryParam ("categorieName")String categorieName){
        
        Categorie categorie = categorieDaoImpl.getCategorieByName(categorieName);
        
        if(categorie!=null){
            return convertToListPostDto(categorie.getListPosts());
        }
        
        return null;
        
        
    }
    
    @GET
    @Path("/getPostById")
    public PostDto getPostByIdt(@QueryParam ("idt")Long idt){
        
        Post post = postDaoImpl.get(idt);
        
        return convertToPostDto(post);
    }
    
    @POST
    @Path("/addNewPost")
    public  void addPostInCategorie(@FormParam("title") String title ,@FormParam("content") String content,
                        @FormParam("statut") String statut, @FormParam("listCategorie") String listCatDto)throws IOException{
        


        List<Long> listCategoriesIds = Deserialize.getListIds(listCatDto);

        List<Categorie> listCategorie = new ArrayList<Categorie>();
        for(Long idtCat:listCategoriesIds){

             Categorie categorie = categorieDaoImpl.get(idtCat);
             listCategorie.add(categorie);

        }

        Post post = new Post();
        post.setPostTitle(title);
        post.setPostContent(content);
        post.setPostStatus(statut);
        post.setListCategorie(listCategorie);
        postDaoImpl.save(post);
        
    }
    
    @PUT
    @Path("/editPost")
    public  void editPost(@FormParam("idt") Long idt ,@FormParam("title") String title ,@FormParam("content") String content,
                        @FormParam("statut") String statut, @FormParam("listCategorie") String listCatDto)throws IOException{
        
        List<Long> listCategoriesIds = Deserialize.getListIds(listCatDto);

        List<Categorie> listCategorie = new ArrayList<Categorie>();
        
         for(Long idtCat:listCategoriesIds){
             Categorie categorie = categorieDaoImpl.get(idtCat);
             listCategorie.add(categorie);
         }

        Post post = postDaoImpl.get(idt);
        if(post!=null){
            post.setPostTitle(title);
            post.setPostContent(content);
            post.setPostStatus(statut);
            post.setListCategorie(listCategorie);
            postDaoImpl.update(post);
        }     
    }
    
    @DELETE
    @Path("/supprimerPost")
    public  void supprimerPost(@FormParam("idt") Long idt)throws IOException{
    	Post post = postDaoImpl.get(idt);
    	postDaoImpl.delete(post);   
    }
    
    public List<PostDto> convertToListPostDto(List<Post> listPosts) {

        List<PostDto> listPostDto = new ArrayList<PostDto>();
        if(listPosts!=null){
            for (Post post : listPosts) {
	            if("Publie".equals(post.getPostStatus())){
	                listPostDto.add(convertToPostDto(post));
	            }
            }
        }        
        return listPostDto;
    }
    
    public List<PostDto> convertToAllListPostDto(List<Post> listPosts) {

        List<PostDto> listPostDto = new ArrayList<PostDto>();
        for (Post post : listPosts) {
           
            String categories =""; 
            PostDto postDto= new PostDto();
            postDto = convertToPostDto(post);
            
            List<Categorie> listCategorie = post.getListCategorie();
            
            if(listCategorie!=null){
                for(Categorie categorie:listCategorie){
                    if(categorie!=null)
                    categories =categories+categorie.getName()+",";
                }
                postDto.setCategories(categories);
            }
            postDto.setCategories(categories);
            listPostDto.add(postDto);
        }
        return listPostDto;
    }
    
     public PostDto convertToPostDto(Post post) {

  
            PostDto postDto = new PostDto();
            
          /*  if(post!=null){
                post.setIdt(post.getIdt());
                post.setPostTitle(post.getPostTitle());
                post.setPostContent(post.getPostContent());
                post.setPostStatus(post.ge);
            }*/
            if(post!=null){
                 BeanUtils.copyProperties(post, postDto);
                 return postDto;
            }else {
                
                return null;
            }

           
    }
    
}
