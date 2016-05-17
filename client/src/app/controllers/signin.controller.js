/**
 * Created by Aditya on 5/10/2016.
 */
(function()
{
    'use strict';

    angular.module('movieflix')
        .controller('SignInController', SignInController);

    SignInController.$inject = ['userService', 'displayService','Notification', '$location'];
    function SignInController(userService, displayService, Notification, $location)
    {
        var signInVm = this;
        init();
        signInVm.signIn = signIn;
        signInVm.setValues =  setValues;
        function init()
        {
            displayService.values.SignIn =true;
            displayService.values.SignUp =true;
        }
        function signIn()
        {
            userService.checkUser(signInVm.email, signInVm.password)
                .then(function (user)
                {
                    signInVm.setValues();
                    signInVm.userData = user;
                    $location.path('/movies');
                    Notification.success("Login Success!");
                }, function (error)
                {
                    $location.path('/signin');
                    Notification.error("No match. Try Again.");
                });
        }
        function setValues()
        {
            displayService.values.SignIn =false;
            displayService.values.SignUp =false;
            displayService.values.Movies =true;
            displayService.values.TopMovies = true;
            displayService.values.Search = true;
        }
    }
})();