/**
 * Created by Aditya on 5/10/2016.
 */
(function()
{
    'use strict';

    angular.module('movieflix')
        .service('reviewService', reviewService);

    reviewService.$inject = ['$http', '$q', 'CONFIG'];
    function reviewService($http, $q, CONFIG)
    {
        var review = this;

        review.getReviews = getReviews;
        review.setReview = setReview;

        function getReviews(id)
        {
            return $http.get(CONFIG.API_HOST+ '/review/findById/' + id)
                .then(successFunction, errorFunction);
        }

        function setReview(review)
        {
            return $http.post(CONFIG.API_HOST+ '/review/', review)
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