/**
 * Created by Aditya on 5/10/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix', ['ngRoute','ngMessages', 'ui-notification'])
        .config(uimoduleConfiguraition);

    function uimoduleConfiguraition($routeProvider) {

        $routeProvider

            .when('/signup', {
                templateUrl: 'app/views/signup.tmpl.html',
                controller: 'SignUpController',
                controllerAs: 'signUpVm'
            })

            .when('/signin', {
                templateUrl: 'app/views/signin.tmpl.html',
                controller: 'SignInController',
                controllerAs: 'signInVm'
            })

            .when('/movies', {
                templateUrl: 'app/views/movies.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })

            .when('/movies/:id', {
                templateUrl: 'app/views/movie.detail.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })

            .when('/topMovies', {
                templateUrl: 'app/views/topmovies.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })

            .when('/IMDBRating', {
                templateUrl: 'app/views/movies.tmpl.html',
                controller: 'MovieController',
                controllerAs: 'moviesVm'
            })

            .when('/setReview', {
                templateUrl: 'app/views/create.reviews.tmpl.html',
                controller: 'ReviewController',
                controllerAs: 'reviewVm'
            })

            .when('/reviews/:id', {
                templateUrl: 'app/views/reviews.tmpl.html',
                controller: 'ReviewController',
                controllerAs: 'reviewVm'
            })

            .otherwise({
                redirectTo: '/signin'
            });
    }
})();