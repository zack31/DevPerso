var leafletModule = angular.module('leafletModule', ["leaflet-directive"]);

leafletModule.controller('leafletController', function($scope) {
		
	angular.extend($scope, {
		osloCenter: {
            lat: 59.91,
            lng: 10.75,
            zoom: 4,
            focus: true,
            draggable: true
        },
        markers: {
            osloMarker: {
                lat: 59.91,
                lng: 10.75,
                message: "Test!",
                focus: true,
                draggable: true
            },
            rabatMarker: {
                lat: 33.91,
                lng: -6.75,
                message: "Test 2!",
                focus: true,
                draggable: true
            }
        },
        europeanPaths: {
            p1: {
                color: 'red',
                weight: 8,
                latlngs: [
                    { lat: 51.50, lng: -0.082 },
                    { lat: 48.83, lng: 2.37 },
                    { lat: 41.91, lng: 12.48 }
                ],
                message: "<h3>Route from London to Rome</h3>",
            },
            p2: {
                color: 'green',
                weight: 8,
                latlngs: [
                    { lat: 48.2083537, lng: 16.3725042 },
                    { lat: 48.8534, lng: 2.3485 }
                ],
                message: '<h3>Route from Vienna to Paris</h3>'                   
            }
        }, 
        defaults: {
            scrollWheelZoom: true
        }
    });
	 
	 $scope.$on("leafletDirectiveMarker.click", function (event, args) {
         //$scope.eventDetected = event.name;
         $scope.args = {
             layerName: args.layerName,
             model: args.model,
             modelName: args.modelName,
         };
     });
	 
	 $scope.$on("leafletDirectivePath.click", function (event, args) {
         $scope.argss = {
             layerName: args.layerName,
             model: args.model,
             modelName: args.modelName
         };
     });
	 
   
});
