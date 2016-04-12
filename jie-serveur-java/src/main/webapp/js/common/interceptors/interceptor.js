// Intercepteur HTTP
myApp.factory('myHttpInterceptor', function ($q,$rootScope,$window) {
    return function (promise) {
        return promise.then(function (response) {
            if(response.headers()['content-type'] === "application/json; charset=utf-8"){
                    return $q.reject(response);
            }
            return response;
        }, function (response) {
            if(response.status === 401 || response.status === 403){
                // action si probleme de droit pour acceder à l'URL
                $q.reject(response);
                $rootScope.removeAllCookies();
                $window.location.href="index.html";
            }else {
                return  $q.reject(response);
            }
        });
    };
});
