// Servicio para el Modulo de archivos multimedia

(function (ng) {

    var mod = ng.module("personModule");

    mod.service("personService", ["$http", "personContext", function ($http, context) {
            /**
             * Obtener la lista de archivos multimedia.
             * Hace una petición GET con $http a /multimedia para obtener la lista
             * @returns {promise} promise para leer la respuesta del servidor}
             * Devuelve una lista de objetos de multimedia con sus atributos
             */
            this.fetchRecords = function () {
                return $http.get(context);
            };

            /**
             * Obtener un registro de multimedia.
             * Hace una petición GET a /multimedia/:id para obtener
             * los datos de un registro específico de multimedia
             * @param {number} id del registro a obtener
             * @returns {promise} promise para leer la respuesta del servidor
             * Devuelve un objeto de multimedia con sus atributos
             */
            this.fetchRecord = function (id) {
                return $http.get(context + "/" + id);
            };

            /**
             * Guardar un registro de multimedia.
             * Si currentRecord tiene la propiedad id, hace un PUT a /multimedia/:id con los
             * nuevos datos de la instancia de persons.
             * Si currentRecord no tiene la propiedad id, se hace un POST a /multimedia
             * para crear el nuevo registro de multimedia
             * @param {object} currentRecord instancia de multimedia a guardar/actualizar
             * @returns {promise} promise para leer la respuesta del servidor
             * Devuelve un objeto de multimedia con sus datos incluyendo el id
             */
            this.saveRecord = function (currentRecord) {
                if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
            };

            /**
             * Hace una petición DELETE a /multimedia/:id para eliminar un archivo multimedia
             * @param {number} id identificador de la instancia de archivo multimedia a eliminar
             * @returns {promise} promise para leer la respuesta del servidor
             * No devuelve datos.
             */
            this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };
        }]);
})(window.angular);


