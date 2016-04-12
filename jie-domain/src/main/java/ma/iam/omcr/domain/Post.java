package ma.iam.omcr.domain;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "posts")
public class Post {

	private Long idt;
	private String postTitle;
    private String postContent;
    private String postStatus;
    private List<Categorie> ListCategorie;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDT")
	public Long getIdt() {
		return idt;
	}
	public void setIdt(Long idt) {
		this.idt = idt;
	}
        
       

        @Column(name = "POST_CONTENT")
        public String getPostContent() {
            return postContent;
        }

        public void setPostContent(String postContent) {
            this.postContent = postContent;
        }

        @Column(name = "POST_TITLE")
        public String getPostTitle() {
            return postTitle;
        }

        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        
       @Column(name = "POST_STATUS")
        public String getPostStatus() {
            return postStatus;
        }

        public void setPostStatus(String postStatus) {
            this.postStatus = postStatus;
        }

        @ManyToMany(targetEntity=Categorie.class, fetch = FetchType.LAZY)
        @JoinTable(name="posts_cateogies",joinColumns=@JoinColumn(name="IDT_POST"),inverseJoinColumns=@JoinColumn(name="IDT_CATEGORIE"))  	
        public List<Categorie> getListCategorie() {
            return ListCategorie;
        }

        public void setListCategorie(List<Categorie> ListCategorie) {
            this.ListCategorie = ListCategorie;
        }

        
}
