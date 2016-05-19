/**
 * Created by Aditya on 5/10/2016.
 */
(function ()
{
    'use strict';

    angular
        .module('movieflix')
        .controller('ReviewController', ReviewController);

    ReviewController.$inject = ['reviewService','$routeParams'];
    function ReviewController(reviewService, $routeParams)
    {
        var reviewVm = this;
        reviewVm.review = {};
        reviewVm.getReviews = getReviews;

        function getReviews()
        {
            reviewService
                .getReviews($routeParams.id)
                .then(function (reviews)
                {
                    reviewVm.reviews = reviews;
                }, function (error)
                {
                });
        }

        function setReview()
        {
            reviewService
                .setReview(review)
                .then(function (response)
                {
                }, function (error)
                {
                });
        }
    }
})();