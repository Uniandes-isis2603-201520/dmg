(function (ng) {

    var mod = ng.module("mainApp", ["ui.router"]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/Viajero");
            $stateProvider

                    .state('Viajero', {
                        url: '/Viajero',
                        templateUrl: "resources/src/modules/User/Viajero.tpl.html"
                    })
                    .state('evento', {
                        url: '/evento',
                        templateUrl: "resources/src/modules/evento/evento.tpl.html"
                    })
                    .state('Itinerario1', {
                        url: '/Itinerario1',
                        templateUrl: "resources/src/modules/Itinerario/itinerario1.tpl.html"
                    })
                    .state('Itinerario2', {
                        url: '/Itinerario2',
                        templateUrl: "resources/src/modules/Itinerario/itinerario2.tpl.html"
                    })
                    .state('Multimedia', {
                        url: '/Multimedia',
                        templateUrl: "resources/src/modules/Multimedia/multimedia.tpl.html"
                    })
                    .state('Timeline', {
                        url: '/Timeline',
                        templateUrl: "resources/src/modules/Timeline/timeline.tpl.html"
                    });
        }]);
})(window.angular);