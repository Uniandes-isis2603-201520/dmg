(function (ng) {

    var mod = ng.module("mainApp", ["ui.router"]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/evento");
            $stateProvider

                    .state('Viajero', {
                        url: '/User',
                        templateUrl: "resources/src/modules/User/Viajero.tpl.html"
                    })
                    .state('evento', {
                        url: '/evento',
                        templateUrl: "resources/src/modules/evento/evento.tpl.html"
                    });
        }]);
})(window.angular);