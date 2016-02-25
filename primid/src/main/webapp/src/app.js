(function (ng) {

    var mod = ng.module("mainApp", ["ui.router"]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/vista1");
            $stateProvider

                    .state('vista1', {
                        url: '/vista1',
                        views:{ "idViajero":{templateUrl:"src/modules/Viajero/Viajero.tpl.html"}, "idEvento":{templateUrl:"src/modules/evento/evento.tpl.html"}, "idItinerario":{templateUrl:"src/modules/Itinerario/itinerario.tpl.html"}, "idMultimedia":{templateUrl:"src/modules/Multimedia/multimedia.tpl.html"}, "idTimeLine":{templateUrl:"src/modules/Timeline/timeline.tpl.html"}, "idMapa":{templateUrl:"src/modules/Mapa/mapa.tpl.html"}
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
                    .state('Multimedia', {
                        url: '/Multimedia',
                        templateUrl: "src/modules/Multimedia/multimedia.tpl.html"
                    })
                    .state('Timeline', {
                        url: '/Timeline',
                        templateUrl: "src/modules/Timeline/timeline2.tpl.html"
                    });
        }]);

    var myCenter=new google.maps.LatLng(51.508742,-0.120850);

    function initialize()
    {
    var mapProp = {
      center: myCenter,
      zoom:5,
      mapTypeId: google.maps.MapTypeId.ROADMAP
      };

    var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

    var marker = new google.maps.Marker({
     position: myCenter,
     title:'Click to zoom'
     });

    marker.setMap(map);

    // Zoom to 9 when clicking on marker
    google.maps.event.addListener(marker,'click',function() {
     map.setZoom(9);
     map.setCenter(marker.getPosition());
     });
    }
    google.maps.event.addDomListener(window, 'load', initialize);

})(window.angular);