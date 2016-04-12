
postModule.factory('postService', function(ajaxService) {
    var service = {};
        
    
    service.getListAllPosts = function(callback,callbackError){
        ajaxService.get("services/posts/listAllPosts", {}, callback,callbackError);
    };
    
    service.getPostByIdt = function(idt,callback,callbackError){
        ajaxService.get("services/posts/getPostById", {idt:idt}, callback,callbackError);
    };
    
    service.addNewPost = function(title,content,statut,listCategorie,callback,callbackError){
        ajaxService.post("services/posts/addNewPost", {
            title:title,
            content:content, 
            statut:statut, 
            listCategorie:listCategorie},
        callback,callbackError);
    };
    
    service.editPost = function(idt,title,content,statut, listCategorie,callback,callbackError){
        ajaxService.put("services/posts/editPost", {
            idt:idt,
            title:title,
            content:content, 
            statut:statut, 
            listCategorie:listCategorie},
        callback,callbackError);
    };
    
    service.supprimerPost = function(idt,callback,callbackError){
        ajaxService.delete("services/posts/supprimerPost", {
        	idt:idt},
        callback,callbackError);
    };
    
    return service;
});