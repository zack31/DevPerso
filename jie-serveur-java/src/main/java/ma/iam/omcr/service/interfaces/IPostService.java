package ma.iam.omcr.service.interfaces;

import java.io.IOException;
import java.util.List;
import ma.iam.omcr.dto.PostDto;

public interface IPostService  {

	public List<PostDto> getListAllPosts();
        
        public PostDto getPostByTitle(String title,String status);
        
        public List<PostDto> getPostsByCategorie(String categorieName);
        
        public  void addPostInCategorie(String title ,String content,String statut, String listCatDto)throws IOException;
        
        public  void editPost(Long idt ,String title ,String content,String statut,String listCatDto)throws IOException;
        
        public void supprimerPost(Long idt)throws IOException;

        public PostDto getPostByIdt(Long idt);
}
