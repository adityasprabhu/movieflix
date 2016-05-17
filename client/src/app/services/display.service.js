/**
 * Created by Aditya on 5/10/2016.
 */
(function() {
    'use strict';

    angular
        .module('movieflix')
        .service('displayService',displayService );

    function displayService()
    {
        var display = this;
        display.values = {};
        init();
        display.getValues = getValues;
        function init()
        {

        }

        function getValues()
        {
            return display.values;
        }
    }
})();