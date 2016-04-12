indexModule.factory('categoriesService', function(ajaxService) {
 
	var service = {};
    
    service.listAllCategories = function(callback,callbackError){
        ajaxService.get("services/categories/listAllCategories", { }, callback,callbackError);
    };
    
    service.selectedCategories = function(idtPost,callback,callbackError){
        ajaxService.get("services/categories/selectedCategories", {idtPost:idtPost }, callback,callbackError);
    };
    
    return service;
});