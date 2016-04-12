package ma.iam.omcr.service.interfaces;

import java.util.List;
import ma.iam.omcr.dto.CategorieDto;





public interface ICategorieService  {

	public List<CategorieDto> getListAllCategories();
        
        public List<CategorieDto> getListCategorieByPost(Long idtPost);
        
        public List<CategorieDto>  getSelectedCategories(Long idtPost);
        
        public  Integer addNewCategorie(String name ,String slug,String statut);
	
        public void supprimerCategorie(String name);
}
