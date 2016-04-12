// Array Remove - By John Resig (MIT Licensed)
/*Array.prototype.remove = function(from, to) {
  var rest = this.slice((to || from) + 1 || this.length);
  this.length = from < 0 ? this.length + from : from;
  return this.push.apply(this, rest);
};*/

var myApp = angular.module('app', [
    'ngCookies',
    'ngRoute',
    'ngSanitize',
    'datatables',
    'ajaxModule',
    'indexModule',
    'postModule',
    'categorieModule',
    'googleMapModuleDir',
    'googleMapModule',
    'demoapp',
    'leafletModule',
    'leaflet-directive'
]);

//configuration des appels Ajax
myApp.config(function($httpProvider, $routeProvider) {
    $httpProvider.defaults.transformRequest = function(data) {
        if (data === undefined) {
            return data;
        }
        return $.param(data);
    };
});

myApp.factory('$exceptionHandler', function($injector) {
    preventDefault = true;
    return function(exception, cause) {
        var rScope = $injector.get('$rootScope');
        if (rScope) {
            rScope.$broadcast('exception', exception, cause);
        }
    };
});