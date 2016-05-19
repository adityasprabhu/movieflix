/**
 * Created by Aditya on 5/10/2016.
 */
(function()
{
    'use strict';

    angular.module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q', 'CONFIG'];
    function movieService($http, $q, CONFIG)
    {
        var mService = this;

        mService.getMovies = getMovies;
        mService.getTopRatedMovies = getTopRatedMovies;
        mService.getById = getById;

        function getMovies()
        {
            return $http.get(CONFIG.API_HOST +'/movies/type/movie')
                .then(successFunction, errorFunction);
        }

        function getTopRatedMovies()
        {
            return $http.get(CONFIG.API_HOST + '/movies/topMovies')
                .then(successFunction, errorFunction);
        }

        function getById(id)
        {
            return $http.get(CONFIG.API_HOST + '/movies/' + id)
                .then(successFunction, errorFunction);
        }

        function successFunction(response)
        {
            return response.data;
        }

        function errorFunction(response)
        {
            return $q.reject('Invalid: ' + response.statusText);
        }
    }
})();