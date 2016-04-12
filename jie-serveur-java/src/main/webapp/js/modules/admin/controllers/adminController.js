var adminModule = angular.module('adminModule', []);

adminModule.controller('adminController', function($scope, $location,$routeParams,adminService) {
   
    $scope.$on('exception', function(e, cause) {
        console.log('error catched ==> ');
        console.log(' cause ');
        console.log(cause);
        console.log(' event ');
        console.log(e.toString());
    });
    
    $scope.messages = [];
    
    $scope.resetMessages = function() {
        $scope.messages = [];
    };
    
    if($routeParams.idt==1){
         $scope.messages.push("Ajout de post avec succes");
    }
    
    if($routeParams.idt==2){
        $scope.messages.push("Ajout de categorie avec succes");
    }
    
    if($routeParams.idt==3){
        $scope.messages.push("Suppression du post avec succes");
    }
    
    if($routeParams.idt==4){
        $scope.messages.push("Edition du post avec succes");
    }
    
	adminService.getListAllPosts(function(data){
        $scope.listPosts=data;
    },function(){
        console.error("Erreur de l'appel ws");
    });
    
    
    $scope.modifierPost = function(post) {
        $location.path("/admin/editPost/" + post.idt);
    };
    
    $scope.supprimerPost = function(post) {
    	adminService.supprimerPost(post.idt,function() {
            console.log("Suppression du post avec succes");
            $location.path("/3");
        }, function() {
            console.error("Erreur de l'appel ws");
        });
    };
    
});