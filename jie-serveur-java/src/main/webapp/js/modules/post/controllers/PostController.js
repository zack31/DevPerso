var postModule = angular.module('postModule', []);


postModule.controller('PostController', function($scope,$location,$routeParams, categoriesService,postService,filterFilter) {

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
    
    postService.getListAllPosts(function(data){
        $scope.listPosts=data;
    },function(){
        console.error("Erreur de l'appel ws");
    });
   
    $scope.modifierPost = function(post) {
        $location.path("/editPost/" + post.idt);
    }; 
    
    $scope.suppPost = function(post) {
    	postService.supprimerPost(post.idt,function() {
            console.log("Suppression du post avec succes");
            $location.path("/3");
        }, function() {
            console.error("Erreur de l'appel ws");
        });
    };
        
    $scope.statuts = [
      {name:'Publie', shade:'publie'},
      {name:'Brouillon', shade:'Brouillon'}
    ];
        
    categoriesService.listAllCategories(function(data) {
        $scope.categories = data;
    }, function() {
        console.error("Erreur de l'appel ws");
    });
        
     // selected categories
     $scope.selection = [];
     
     // toggle selection for a given categorie by name
    $scope.toggleSelection = function toggleSelection(categorie) {
      var idx = $scope.selection.indexOf(categorie);
      // is currently selected
      if (idx > -1) {
        $scope.selection.splice(idx, 1);
      }
      // is newly selected
      else {
        $scope.selection.push(categorie);
      }     
    };
    
    $scope.addPost = function() {
        
        $scope.errorMessages = [];
        var content = $scope.content;
        var categoriesSelect = $scope.selection;
        var postTitle = $scope.title;
        var postStatut = $scope.postStatut;
        
        if (postTitle==null || postTitle=="")
            $scope.errorMessages.push("Veuillez saisir le titre d'article");

        if (categoriesSelect.length == 0)
            $scope.errorMessages.push("Veuillez selectionner au moins une categorie");
        
        if (content==null || content=="")
            $scope.errorMessages.push("Veuillez saisir le contenu d'article");
        
        if (postStatut==null || postStatut.name=="")
            $scope.errorMessages.push("Veuillez saisir le statut d'article");
        
        
        var listCatTds = "";
        for (i=0;i<categoriesSelect.length;i++){
            
            listCatTds+=categoriesSelect[i].idt+":";
        }

        if($scope.errorMessages==0){
            postService.addNewPost(postTitle,content,postStatut.name,listCatTds,function() {
      
                console.log("Ajout de post avec succes");
                $location.path('/posts/1');
            }, function() {
                console.error("Erreur de l'appel ws");
            });
        }    
    }
    
    //GET post BY id
   /* postService.getPostByIdt($scope.idtPost,function(data) {       
        $scope.post = data;
        if(data.postStatus=="Publie"){
             $scope.postStatut =  $scope.statuts[0] ;
        }else{
            $scope.postStatut =  $scope.statuts[1] ;
        }
           
        $('#editor').elrte('val',data.postContent);
    }, function() {
        console.error("Erreur de l'appel ws");
    });*/
    
    // selected categories
    $scope.selection = [];
    $scope.categories = [];
    
    /*categoriesService.selectedCategories($scope.idtPost,function(data) {
        $scope.categories = data;
    }, function() {
        console.error("Erreur de l'appel ws");
    });*/
    
    
    $scope.editPost = function() {
        var content = $('#editor').elrte('val');
        var categoriesSelect = $scope.selection;
        var postTitle = $scope.post.postTitle;
   
        var listCatTds = "";
        for (i=0;i<categoriesSelect.length;i++){
            
            listCatTds+=categoriesSelect[i].idt+":";
        }
        console.log($scope.selection);
        console.log(listCatTds);
        console.log($scope.idtPost);
   
        postService.editPost($scope.idtPost,postTitle,content, $scope.postStatut.name, listCatTds,function() {   
            console.log("Mise a jour de post avec succes");
            $location.path('/posts/4');
        }, function() {
            console.error("Erreur de l'appel ws");
        });
    }
        
    // helper method
    $scope.selectedCategories = function selectedCategories() {
      return filterFilter($scope.categories, { selected: true });
    };
    
    // watch fruits for changes
    $scope.$watch('categories|filter:{selected:true}', function (nv) {
      $scope.selection = nv.map(function (categorie) {
        return categorie;
      });
    }, true);
    
});

postModule.filter('categorieSelection', ['filterFilter', function (filterFilter) {
    return function categorieSelection(input, prop) {
      return filterFilter(input, { selected: true }).map(function (categorie) {
        return categorie[categorie];
      });
    };
  }]);