/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

  // es parte del módulo "multimediaModule"
  var mod = ng.module("multimediaModule");

  // crea el controlador con dependencias a $scope y a personService
  mod.controller("multimediaCtrl", ["$scope", "multimediaService", function ($scope, svc) {

    // TODO: define los atributos en el scope
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

    //Alertas
    this.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
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

    //Variables para el controlador
    this.readOnly = false;
    this.editMode = false;

    this.changeTab = function (tab) {
        $scope.tab = tab;
    };



    // define funciones que son invocadas desde la pantalla
    // y que usan funciones definidas en el servicio


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


  }]);

})(window.angular);