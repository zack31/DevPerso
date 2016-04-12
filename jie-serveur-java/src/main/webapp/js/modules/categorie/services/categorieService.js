categorieModule.factory('categorieService', function(ajaxService) {

	var service = {};
    
    service.addNewCategorie = function(name,slug,statut,callback,callbackError){
        ajaxService.put("services/categories/addNewCategorie", {
            name:name,
            slug:slug,
            statut:statut},
        callback,callbackError);
    };
 
    service.supprimerCategorie = function(name,callback,callbackError){
        ajaxService.delete("services/categories/supprimerCategorie", {
        	name:name},
        callback,callbackError);
    };
    
    return service;
});