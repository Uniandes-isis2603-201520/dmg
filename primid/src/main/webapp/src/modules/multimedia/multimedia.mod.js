//


(function(ng){

  // define el módulo "multimediaModule" con dependencia a ui.bootstrap
  var mod = ng.module("multimediaModule", ["ui.bootstrap"]);

  // define una constante usada por el servicio y el mock del servicio
  mod.constant("multimediaContext", "api/multimedia");

})(window.angular);