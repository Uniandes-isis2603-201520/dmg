/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("usuarioModule");
    mod.service("usuarioService", ["$http", "usuarioContext", function ($http, context) {
            /**
             * Obtener la lista de viajeros.
             * Hace una peticion GET con $http a /viajero para obtener la lista
             * de viajeros
             * @returns {promise} promise para leer la respuesta del servidor}
             * Devuelve una lista de objetos de viajeros con sus atributos
             */
            this.fetchRecords = function () {
                return $http.get(context);
            };

            /**
             * Obtener un registro de Viajero.
             * Hace una peticion GET a /viajero/:id_viajero para obtener
             * los datos de un registro especifico de viajeros
             * @param {number} id del registro a obtener
             * @returns {promise} promise para leer la respuesta del servidor
             * Devuelve un objeto de viajeros con sus atributos
             */
            this.fetchRecord = function (id) {
                return $http.get(context + "/" + id);
            };

            /**
             * Guardar un registro de viajero.
             * Si currentRecord tiene la propiedad id, hace un PUT a /viajero/:id con los
             * nuevos datos de la instancia de viajero.
             * Si currentRecord no tiene la propiedad id, se hace un POST a /viajero
             * para crear el nuevo registro de reviews
             * @param {object} currentRecord instancia de viajero a guardar/actualizar
             * @returns {promise} promise para leer la respuesta del servidor
             * Devuelve un objeto de viajero con sus datos incluyendo el id
             */
            this.saveRecord = function (currentRecord) {
                if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
            };

            /**
             * Hace una peticion DELETE a /viajero/:id para eliminar un viajero
             * @param {number} id identificador de la instancia de viajero a eliminar
             * @returns {promise} promise para leer la respuesta del servidor
             * No devuelve datos.
             */
            this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };

             /**
             * Hace una petición PUT a /viajero/:id/itinerarios para reemplazar los
             * itinerarios asociados a un viajero
             * @param {number} viajeroId Identificador de la instancia de viajero
             * @param {array} itinerarios Colección de itinerarios nueva
             * @returns {promise} promise para leer la respuesta del servidor.
             * Devuelve el objeto de viajero con sus nuevos datos.
             */
            this.replaceItinerarios = function (viajeroId, itinerarios) {
                return $http.put(context + "/" + viajeroId + "/books", itinerarios);
            };

              /**
             * Hace una petición GET a /viajero/:id/itinerarios para obtener la colección
             * de itinerarios asociados a un viajero
             * @param {number} id Identificador de la instancia de viajero
             * @returns {promise} promise para leer la respuesta del servidor.
             * Retorna un array de objetos de itinerarios.
             */
            this.getItinerarios = function (id) {
                return $http.get(context + "/" + id + "/itinerarios");
            };

            /**
             * Hace una petición DELETE a /viajero/:id/itinerarios/:id para remover
             * un itinerario de un viajero
             * @param {number} viajeroId Identificador de la instancia de viajero
             * @param {number} itinerarioId Identificador de la instancia de itinerario
             * @returns {promise} promise para leer la respuesta del servidor
             * La respuesta no devuelve datos.
             */
            this.removeItinerario = function (viajeroId, itinerarioId) {
                return $http.delete(context + "/" + viajeroId + "/itinerarios/" + itinerarioId);
            };

        }]);
})(window.angular);