package ma.iam.omcr.dto;


public class CategorieDto {

	private Long idt;
	private String name;
        private String statut;
        private String slug;
        private Long group; 
        private boolean selected = false;


	public Long getIdt() {
		return idt;
	}
	public void setIdt(Long idt) {
		this.idt = idt;
	}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatut() {
            return statut;
        }

        public void setStatut(String statut) {
            this.statut = statut;
        }
        
        
        
        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Long getGroup() {
            return group;
        }

        public void setGroup(Long group) {
            this.group = group;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
        
       
	
}
