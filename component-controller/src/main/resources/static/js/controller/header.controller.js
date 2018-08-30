(function () {
    angular.module('app').controller('headerCtrl', headerCtrl);
    function headerCtrl($scope, $window) {
        $scope.reload = function () {
            $window.location.reload();
        }
    }
})();