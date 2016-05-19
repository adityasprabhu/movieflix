/**
 * Created by Aditya on 5/10/2016.
 */
(function()
{
    'use strict';
    angular
        .module('movieflix')
        .controller('MovieController', MovieController);

    MovieController.$inject = ['movieService', '$routeParams'];
    function MovieController(movieService, $routeParams)
    {
        var moviesVm = this;

        moviesVm.changeSort = changeSort;
        moviesVm.getMovies = getMovies;
        moviesVm.getTopRatedMovies = getTopRatedMovies;
        moviesVm.getById = getById;

        moviesVm.sorter =
        {
            by: 'year',
            reverse: false
        }

        function changeSort(prop)
        {
            moviesVm.sorter.by = prop;
            moviesVm.sorter.reverse = !moviesVm.sorter.reverse;
        }

        function getMovies()
        {
            movieService
                .getMovies()
                .then(function(movies)
                {
                    moviesVm.movies= movies;
                }, function(error)
                {
                });
        }


        function getTopRatedMovies()
        {
            movieService
                .getTopRatedMovies()
                .then(function (movies)
                {
                    moviesVm.movies = movies;
                }, function (error)
                {
                });
        }

        function getById()
        {
            movieService
                .getById($routeParams.id)
                .then(function (movie)
                {
                    moviesVm.movie = movie;
                }, function (error)
                {
                });
        }
    }
})();