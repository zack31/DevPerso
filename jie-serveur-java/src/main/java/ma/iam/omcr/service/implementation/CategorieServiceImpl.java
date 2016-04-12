package ma.iam.omcr.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import ma.iam.omcr.dao.interfaces.ICategorieDao;
import ma.iam.omcr.dao.interfaces.IPostDao;
import ma.iam.omcr.domain.Categorie;
import ma.iam.omcr.domain.Post;
import ma.iam.omcr.dto.CategorieDto;
import ma.iam.omcr.service.interfaces.ICategorieService;
import ma.iam.omcr.util.Constante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Path("services/categories")
@Produces("application/json")
public class CategorieServiceImpl implements ICategorieService {

    @Autowired
    ICategorieDao categorieDaoImpl;
    
    @Autowired
    IPostDao postDaoImpl;
    
    private final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @GET
    @Path("/listAllCategories")
    public List<CategorieDto> getListAllCategories() {
        
    	List<Categorie> listCategorie = categorieDaoImpl.findAll();
        return convertToCategorieDto(listCategorie);
       
    }

    
    @GET
    @Path("/selectedCategories")
    public List<CategorieDto>  getSelectedCategories(@QueryParam ("idtPost")Long idtPost){
        
        List<CategorieDto> listAllCategorie = convertToCategorieDto(categorieDaoImpl.findAll());
        
        Post post = postDaoImpl.get(idtPost);
        List<Categorie> selectedCategories = post.getListCategorie();

        
        for(CategorieDto categorieDto:listAllCategorie){
            
            for(Categorie selectedCat:selectedCategories){
                
                if(categorieDto.getIdt()==selectedCat.getIdt()){
                   categorieDto.setSelected(true);
                }
            }
        }
        
        return listAllCategorie;
    }
    
    
    @GET
    @Path("/listCategoriesByPost ")
    public List<CategorieDto> getListCategorieByPost(@QueryParam ("idtPost")Long idtPost){
        
        Post post = postDaoImpl.get(idtPost);
        List<Categorie> listCategorie = post.getListCategorie();
        return convertToCategorieDto(listCategorie);
    }
   
    public List<CategorieDto> convertToCategorieDto(List<Categorie> listCategorie) {

        List<CategorieDto> listCategorieDto = new ArrayList<CategorieDto>();
        for (Categorie categorie : listCategorie) {
            CategorieDto categorieDto = new CategorieDto();

            BeanUtils.copyProperties(categorie, categorieDto);

            listCategorieDto.add(categorieDto);

        }
        return listCategorieDto;
    }
     
    
    @POST
    @Path("/addNewCategorie")
    public  Integer addNewCategorie(@FormParam("name") String name ,@FormParam("slug") String slug,
                        @FormParam("statut") String statut){

        Categorie categorie = categorieDaoImpl.getCategorieByName(name);
        if(categorie==null){
            categorie = new Categorie();
            categorie.setName(name);
            categorie.setSlug(slug);
            categorie.setStatut(statut);
            categorieDaoImpl.save(categorie);
            
            return Constante.OBJECT_NON_EXIST;
        } 

       return Constante.OBJECT_EXIST;
        
    }
    
    @DELETE
    @Path("/supprimerCategorie")
    public  void supprimerCategorie(@FormParam("name") String name){

    	Categorie categorie = categorieDaoImpl.getCategorieByName(name);
    	categorieDaoImpl.delete(categorie);           
    }
}
