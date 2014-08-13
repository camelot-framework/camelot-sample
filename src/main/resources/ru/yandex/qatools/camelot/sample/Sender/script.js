angular.module('ru.yandex.qatools.camelot.sample.Sender', ['camelotUtil'])
    .controller('AppCtrl', ['$scope', '$http', 'subscribe', 'baseUrl', 'pluginId', function ($scope, $http, subscribe, baseUrl, pluginId) {
        'use strict';

        subscribe(pluginId, function (message) {
            console.log(pluginId + ' ' + message)
        });
    }]);