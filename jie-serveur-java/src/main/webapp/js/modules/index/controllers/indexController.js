var indexModule = angular.module('indexModule', []);

indexModule.controller('indexController', function($scope,categoriesService) {
    
	$scope.$on('exception', function(e, cause) {
        console.log('error catched ==> ');
        console.log(' cause ');
        console.log(cause);
        console.log(' event ');
        console.log(e.toString());
    });
    
    console.log("init controller");
   
    categoriesService.listAllCategories(function(data){
        console.log(data);    
    },function(){
        console.error("Erreur de l'appel ws");
    });
    
    /* categoriesService.getPostByTitle("ACCUEIL","publish",function(data){
        console.log(data);
    },function(){
        console.error("Erreur de l'appel ws");
    });*/
    
});