/**
 * Created by Aditya on 5/10/2016.
 */
(function() {
    'use strict';

    angular.module('movieflix')
        .controller('DisplayController', DisplayController);

    DisplayController.$inject = ['displayService'];
    function DisplayController(displayService)
    {
        var dp = this;
        init();
        function init()
        {
            dp.values =displayService.getValues()
        }
    }
})();