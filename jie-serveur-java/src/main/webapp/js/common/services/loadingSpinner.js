ajaxModule.factory('loadingSpinner', function($rootScope) {
    var currentLoadings = 0;
    var show = function() {
        currentLoadings +=1;
    $rootScope.$emit('loadingSpinner:show');
  };
  var hide = function() {
    currentLoadings -=1;
    if(currentLoadings==0)
        $rootScope.$emit('loadingSpinner:hide');
  };
  return function(state) {
    if(state==="hide") hide();
    if(state==="show") show();
  };
})
.directive('loadingSpinner', function() {
    var directive = { restrict: 'C', replace: true };
    
    directive.template='<div id="loading-overlay" class="{{loadingClass}}">'+
                            '<img id="loading-image" src="img/loading.gif" />'+
                        '</div>';
    directive.controller = function($scope, $rootScope) {
        $scope.loadingClass = "hide-loading";
    $rootScope.$on('loadingSpinner:show', function(_) {
      $scope.loadingClass = "";
    });
    $rootScope.$on('loadingSpinner:hide', function(_) {
      $scope.loadingClass = "hide-loading";
    });
  };
   directive.controller.$inject = ['$scope','$rootScope']; 
return directive;
})
;