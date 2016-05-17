/**
 * Created by Aditya on 5/10/2016.
 */
(function ()
{
    'use strict';

    angular.module('movieflix')
        .service('userService', userService);

    userService.$inject = ['$http', '$q'];
    function userService($http, $q)
    {
        var userVM = this;
        userVM.createUser = createUser;
        userVM.checkUser = checkUser;

        function createUser(user)
        {
            return $http.post('http://localhost:8080/movieflix/users/', user)
                .then(function (response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('Invalid: ' + response.statusText);
                });
        }

        function checkUser(email, password)
        {
            return $http.get('http://localhost:8080/movieflix/users/'+ email + '/'+password)
                .then(function (response) {
                    return response.data;
                }, function(response) {
                    return $q.reject('Invalid: ' + response.statusText);
                });
        }
    }
})();