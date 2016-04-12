package ma.iam.omcr.dto;



public class PostDto {

		private Long idt;
		private String postTitle;
	        private String postContent;
	        private String postStatus;
	        private String categories;
	        
	
		public Long getIdt() {
			return idt;
		}
		public void setIdt(Long idt) {
			this.idt = idt;
		}
        
        public String getPostTitle() {
            return postTitle;
        }

        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        public String getPostContent() {
            return postContent;
        }

        public void setPostContent(String postContent) {
            this.postContent = postContent;
        }

        
        public String getPostStatus() {
            return postStatus;
        }

        public void setPostStatus(String postStatus) {
            this.postStatus = postStatus;
        }

        public String getCategories() {
            return categories;
        }

        public void setCategories(String categories) {
            this.categories = categories;
        }

        
        
}
