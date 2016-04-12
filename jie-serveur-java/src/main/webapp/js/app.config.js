myApp.config(function($httpProvider, $routeProvider) {
   
//************************************************Post Controller	
	$routeProvider.when('/', {
         templateUrl: 'js/modules/post/views/posts.tpl.html',
        controller: 'PostController'
    });
       
    $routeProvider.when('/posts/:idt', {
        templateUrl: 'js/modules/post/views/posts.tpl.html',
        controller: 'PostController'
    });
        
    $routeProvider.when('/addPost', {
        templateUrl: 'js/modules/post/views/addPost.tpl.html',
        controller: 'PostController'
    });
    
    $routeProvider.when('/editPost/:idt', {
        templateUrl: 'js/modules/post/views/editPost.tpl.html',
        controller: 'PostController'
    });  
//******************************************************************    
    
    $routeProvider.when('/googleMap', {
        templateUrl: 'js/modules/googleMap/views/googleMap.tpl.html',
        controller: 'googleMapController'
    });  
    
    
    $routeProvider.when('/freemap', {
        templateUrl: 'js/modules/FreeTestMap/views/freemap.tpl.html',
        controller: 'freeMapController'
    });
    
    $routeProvider.when('/leaflet', {
        templateUrl: 'js/modules/leaflet/views/leaflet.tpl.html',
        controller: 'leafletController'
    });
    
//*********************************************Categorie Controller    
    $routeProvider.when('/addCategorie', {
        templateUrl: 'js/modules/categorie/views/addCategorie.tpl.html',
        controller: 'CategorieController'
    });

    $routeProvider.when('/admin/supprimerCategorie/:idt', {
        templateUrl: 'js/modules/categorie/views/addCategorie.tpl.html',
        controller: 'CategorieController'
    });    
//******************************************************************        
    
    
    $routeProvider.otherwise({redirectTo: '/'}); // remplacer par error404
    //$httpProvider.responseInterceptors.push('myHttpInterceptor');
});