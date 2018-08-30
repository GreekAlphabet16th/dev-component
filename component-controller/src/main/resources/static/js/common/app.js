/**
 * 路由配置
 * */
(function () {
    angular.module('app',['ui.router', 'ui.bootstrap']).config(routeConfig).run(run);
    routeConfig.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];
    function routeConfig($stateProvider, $urlRouterProvider, $locationProvider) {
        $urlRouterProvider.otherwise('/');
        $stateProvider.state('index', {
            url: '/',
            views: {
                "header": {
                    templateUrl: 'common/header'
                },
                "container": {

                }
            }
        });
        $locationProvider.html5Mode(true);
    }
    run.$inject = ['$state'];
    function run($state) {
        $state.go('index');
    }
})();
