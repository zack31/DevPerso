var categorieModule = angular.module('categorieModule', []);


categorieModule.controller('CategorieController', function($scope,$location,categoriesService,categorieService ) {


    $scope.$on('exception', function(e, cause) {
        console.log('error catched ==> ');
        console.log(' cause ');
        console.log(cause);
        console.log(' event ');
        console.log(e.toString());
    });
    
    
    $scope.resetMessages = function() {
        $scope.errorMessages = [];
    };
         
    categoriesService.listAllCategories(function(data) {
        
        $scope.categories = data;
    }, function() {
        console.error("Erreur de l'appel ws");
    });
    
    
    
    $scope.supprimerCategorie = function(categorie) {
    	
        categorieService.supprimerCategorie(categorie.name,function() {
            console.log("Suppression de categorie avec succes");
            $location.path('/supprimerCategorie/'+categorie.idt);
        }, function() {
            console.error("Erreur de l'appel ws suppCategorie ");
        });
    }; 
    
    $scope.addCategorie = function(){
    	
    	$scope.errorMessages = [];
    	var postCategorieName = $scope.categorieName;
    	var postCategorieSlug = $scope.categorieSlug;
    	var postCategorieStatut = $scope.categorieStatut;
    	
    	if (postCategorieName == null || postCategorieName == "")
            $scope.errorMessages.push("Veuillez saisir un titre de categorie");
    	
        if($scope.errorMessages==0){
            categorieService.addNewCategorie(postCategorieName,postCategorieSlug,postCategorieStatut,function() {
      
                console.log("Ajout de categorie avec succes");
                $location.path('/posts/2');//va vers cette URL
            }, function() {
                console.error("Erreur de l'appel ws");
            });
        } 
    }     
});