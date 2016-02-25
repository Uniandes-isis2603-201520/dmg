(function (ng) {

  // es parte del módulo "personModule"
  var mod = ng.module("mapaModule");

  // crea el controlador con dependencias a $scope y a personService
  mod.controller("mapaCtrl", ["$scope", "mapaService", function ($scope, svc) {

            //alertas o metodos para desplegar mensajes
            $scope.alerts = [];
            $scope.currentRecord = {};
            $scope.records = [];

            $scope.today = function () {
                $scope.value = new Date();
            };

            $scope.clear = function () {
                $scope.value = null;
            };

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };


            function showMessage(msg, type) {
                var types = ["info", "danger", "warning", "success"];
                if (types.some(function (rc) {
                    return type === rc;
                })) {
                    $scope.alerts.push({type: type, msg: msg});
                }
            }

            this.showError = function (msg) {
                showMessage(msg, "danger");
            };

            this.showSuccess = function (msg) {
                showMessage(msg, "success");
            };

            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }


            //metodos para invocar los servicios
            this.readOnly = false;
            this.editMode = false;

            this.changeTab = function (tab) {
                $scope.tab = tab;
            };

            this.createRecord = function () {
                $scope.$broadcast("pre-create", $scope.currentRecord);
                this.editMode = true;
                $scope.currentRecord = {};
                $scope.$broadcast("post-create", $scope.currentRecord);
            };

            this.editRecord = function (record) {
                $scope.$broadcast("pre-edit", $scope.currentRecord);
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    $scope.$broadcast("post-edit", $scope.currentRecord);
                    return response;
                }, responseError);
            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                    return response;
                }, responseError);
            };

            this.saveRecord = function () {
                    return svc.saveRecord($scope.currentRecord).then(function () {
                        self.fetchRecords();
                    }, responseError);
            };

            this.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.fetchRecords();
                }, responseError);
            };

            this.fetchRecords();

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


  }]);

})(window.angular);


