var demoapp = angular.module('demoapp',['openlayers-directive']);

demoapp.controller('freeMapController', [ '$scope', function($scope) {
	
	angular.extend($scope, {
        maroc: {
        	lat: 33.594976707771536,
            lon: -6.323191175558381,
            zoom: 5
        },
        santiago: {
            lat: 42.880596200000010000,
            lon: -8.544641200000001000,
            label: {
                message: 'Santiago de Compostela',
                show: true,
                showOnMouseOver: true
            }
        },
        marker: {
        	coords: [[[-58.38,-34.60],[15.52,38.23],[33.59,-7.32]]]
        },
        defaults: {
            interactions: {
              mouseWheelZoom: true
            },
            controls: {
                zoom: false,
                rotate: false,
                attribution: false
            }
        }
    });	
}]);
