(function (ng) {

    var mod = ng.module("mainApp", [

        "ui.router"



    ]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterPr
            ovider.otherwise("/vista1");
            $stateProvider

                    .state('vista1', {
                        url: '/vista1',
                        
                        views:{ "idViajero":{templateUrl:"src/modules/Viajero/Viajero.tpl.html"},
                            "idEvento":{templateUrl:"src/modules/evento/evento.tpl.html"},
                            "idItinerario":{templateUrl:"src/modules/Itinerario/itinerario.tpl.html"},
                            "idMultimedia":{templateUrl:"src/modules/multimedia/multimedia.tpl.html"},
                            "idTimeLine":{templateUrl:"src/modules/Timeline/timeline.tpl.html"},
                            "idMapa":{templateUrl:"src/modules/Mapa/mapa.tpl.html"}
                    }})
                    .state('Viajero', {
                        url: '/Viajero',
                        templateUrl: "src/modules/User/Viajero.tpl.html"
                    })
                    .state('evento', {
                        url: '/evento',
                        templateUrl: "src/modules/evento/evento.tpl.html"
                    })
                    .state('Itinerario1', {
                        url: '/Itinerario1',
                        templateUrl: "src/modules/Itinerario/itinerario1.tpl.html"
                    })
                    .state('Itinerario2', {
                        url: '/Itinerario2',
                        templateUrl: "src/modules/Itinerario/itinerario2.tpl.html"
                    })
                    .state('multimedia', {
                        url: '/multimedia',
                        templateUrl: "src/modules/Multimedia/multimedia.tpl.html"
                    })
                    .state('Timeline', {
                        url: '/Timeline',
                        templateUrl: "src/modules/Timeline/timelinev2.tpl.html"
                    });
        }]);
})(window.angular);
