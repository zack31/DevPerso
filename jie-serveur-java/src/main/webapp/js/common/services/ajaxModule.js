var ajaxModule = angular.module('ajaxModule', []);

ajaxModule.factory('ajaxService', function($http, loadingSpinner) {
    
    var currentLoadings = {};
    var defaultTransform = function(data) {
        if (data === undefined) {
            return data;
        }
        return $.param(data);
    };
    var jsonTransform = function(data) {
        return JSON.stringify(data);
    };
    var service = {
        maxParamSize:0,        
        call: function(method,serviceURI, params, headerContentType, callBackFunction) {
            var httpConf = {
                url: serviceURI,
                method: method,
                headers: {'Content-Type': headerContentType},
                transformRequest: headerContentType === 'application/json' ? jsonTransform : defaultTransform
            };
            
            if(httpConf.method==="GET"){
                httpConf.params = params;
            }
            if(httpConf.method==="POST"){
                httpConf.data = params;
            }
			if(httpConf.method==="PUT"){
                httpConf.data = params;
            }
			if(httpConf.method==="DELTE"){
                httpConf.data = params;
            }
            var promise = $http(httpConf);
            if (callBackFunction !== undefined) {
                promise.then(callBackFunction);
            } else {
                return promise;
            }
        },
        spinCallHeaderContentType: function(method,url, params, successCall, headerContentType, errorCall, endCall) {
            loadingSpinner("show");
            var successCallBack = successCall || function() {
            };
            var errorCallBack = errorCall || function() {
            };
            var endCallBack = endCall || function() {
                loadingSpinner("hide");
                currentLoadings[url] = false;
            };
            currentLoadings[url] = true;
            service.call(method,url, params, headerContentType)
                    .success(function() {
                        successCallBack.apply(this, arguments);
                        endCallBack();
                    }).error(function() {
                errorCallBack.apply(this, arguments);
                endCallBack();
            });
        },
        spinCall: function(method,url, params, successCall, errorCall, endCall) {
            // limit the param size 
           /* if(service.maxParamSize>0){
                for(var key in params){
                    params[key]=(params[key]!=null)?params[key].toString().substr(0,service.maxParamSize):params[key];
                }
            }*/
            service.spinCallHeaderContentType(method,url, params, successCall, "application/x-www-form-urlencoded", errorCall, endCall);
        },
        get:function(url,params, successCall, errorCall, endCall){
            this.spinCall('GET',url,params, successCall, errorCall, endCall);
        },
        post:function(url,params, successCall, errorCall, endCall){
            this.spinCall('POST',url,params, successCall, errorCall, endCall);
        },
		post:function(url,params, successCall, errorCall, endCall){
            this.spinCall('PUT',url,params, successCall, errorCall, endCall);
        },
		post:function(url,params, successCall, errorCall, endCall){
            this.spinCall('DELETE',url,params, successCall, errorCall, endCall);
        },
        isLoading: function(url) {
            return currentLoadings[url] || false;
        }
    };
    return service;

});