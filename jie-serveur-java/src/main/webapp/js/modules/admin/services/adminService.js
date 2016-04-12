adminModule.factory('adminService', function(ajaxService) {
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
    
    service.addNewCategorie = function(name,slug,statut,callback,callbackError){
        ajaxService.post("services/categories/addNewCategorie", {
            name:name,
            slug:slug,
            statut:statut},
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
    
    service.supprimerCategorie = function(name,callback,callbackError){
        ajaxService.delete("services/categories/supprimerCategorie", {
        	name:name},
        callback,callbackError);
    };
    
    return service;
});