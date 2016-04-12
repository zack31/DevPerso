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


@Entity
@Table(name = "categorie")
public class Categorie {

	private Long idt;
	private String name;
        private String slug;
        private String statut;
        private List<Post> listPosts;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDT")
	public Long getIdt() {
		return idt;
	}
	public void setIdt(Long idt) {
		this.idt = idt;
	}

        @Column(name = "NAME")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        @Column(name = "SLUG")
        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
        
        @Column(name = "STATUT")
        public String getStatut() {
            return statut;
        }

        public void setStatut(String statut) {
            this.statut = statut;
        }

       

        @ManyToMany(targetEntity=Post.class, fetch = FetchType.LAZY)
        @JoinTable(name="posts_cateogies",joinColumns=@JoinColumn(name="IDT_CATEGORIE"),inverseJoinColumns=@JoinColumn(name="IDT_POST"))  	
        public List<Post> getListPosts() {
            return listPosts;
        }

        public void setListPosts(List<Post> listPosts) {
            this.listPosts = listPosts;
        }
      	
}
