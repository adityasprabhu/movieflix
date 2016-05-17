/**
 * Created by Aditya on 5/10/2016.
 */
(function()
{
    'use strict';

    angular.module('movieflix')
        .controller('SignUpController', SignUpController);

    SignUpController.$inject = ['userService','$location', 'Notification'];
    function SignUpController(userService, $location, Notification)
    {
        var signUpVm = this;
        signUpVm.user = {};
        signUpVm.signUp = signUp;

        function signUp()
        {
            userService.createUser(signUpVm.user)
                .then(function (response)
                {
                    signUpVm.userData = response;
                    $location.path('/signin');
                    Notification.success("Registration successful! Continue to Login");
                }, function (error) {
                    $location.path('/signup');
                    Notification.error("Error. Please try again");
                });
        };
    }
})();