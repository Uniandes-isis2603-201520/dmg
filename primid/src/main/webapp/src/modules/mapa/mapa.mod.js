(function(ng){

  // define el módulo "personModule" con dependencia a ui.bootstrap
  var mod = ng.module("mapaModule", ["ui.bootstrap"]);

  // define una constante usada por el servicio y el mock del servicio
  mod.constant("mapaContext", "api/mapas");

})(window.angular);