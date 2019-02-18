
var App = angular.module("App", ['ngRoute']);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/',{
        templateUrl: '/app/html/partial/ucesnici.html'
    }).when('/ucesnici/edit/:id',{
        templateUrl: '/app/html/partial/edit-ucesnik.html'
    }).when('/takmicenja/mec',{
        templateUrl: '/app/html/partial/mec.html'
    }).otherwise({
        redirectTo: '/'
    });
}]);

App.controller("ucesniciCtrl", function($scope, $http, $location){

    var baseUrlUcesnici = "/api/ucesnici";
    var baseUrlTakmicenja = "/api/takmicenja";

    $scope.pageNum = 0;
    $scope.totalPages = 1;

    $scope.takmicenja = [];
    $scope.ucesnici = [];

    $scope.noviUcesnik = {};
    $scope.noviUcesnik.naziv = "";
    $scope.noviUcesnik.mesto = "";
    $scope.noviUcesnik.kontakt = "";
    $scope.noviUcesnik.takmicenjeId = "";


    $scope.trazeniUcesnik = {};
    $scope.trazeniUcesnik.naziv = "";
    $scope.trazeniUcesnik.takmicenjeId = "";
    
    var goToMec = function(){
    	 $location.path('takmicenja/mec');
    }
    
    var getUcesnici = function(){

        var config = {
        	params: {}
        };

        config.params.pageNum = $scope.pageNum;

        if($scope.trazeniUcesnik.naziv !== ""){
            config.params.naziv = $scope.trazeniUcesnik.naziv;
        }

        if($scope.trazeniUcesnik.takmicenjeId != ""){
            config.params.takmicenjeId = $scope.trazeniUcesnik.takmicenjeId;
        }



        $http.get(baseUrlUcesnici, config)
            .then(
            	function success(res){
            		$scope.ucesnici = res.data;
            		$scope.totalPages = res.headers('totalPages');
            	},
            	function error(res){
            		alert("Neuspešno dobavljanje takmicenja!");
            	}
            );
    };

    var getTakmicenja = function(){

        $http.get(baseUrlTakmicenja)
            .then(
            	function success(res){
            		$scope.takmicenja = res.data;
            	},
            	function error(){
            		alert("Neuspešno dobavljanje takmicenja!");
            	}
            );

    };

    getTakmicenja();
    getUcesnici();

    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getFestivali();
        }
    };

    $scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getFestivali();
        }
    };

    $scope.dodaj = function(){
        $http.post(baseUrlUcesnici, $scope.noviUcesnik)
            .then(
            	function success(res){
	                alert("Uspešno dodat ucesnik u bazu.");
	                getUcesnici();
				$scope.noviUcesnik = {};
    			$scope.noviUcesnik.naziv = "";
    			$scope.noviUcesnik.mesto = "";
    			$scope.noviUcesnik.kontakt = "";
    			$scope.noviUcesnik.takmicenjeId = "";	
            	},
            	function error(res){
            		alert("Neuspešno dodavanje ucesnika!");
            	}
            );
    };

    $scope.trazi = function () {
        $scope.pageNum = 0;
        getUcesnici();
    }

    $scope.goToEdit = function(id){
        $location.path('ucesnici/edit/' + id);
    }
    
    $scope.obrisi = function(id){
        $http.delete(baseUrlUcesnici + "/" + id).then(
            function success(data){
                getUcesnici();
            },
            function error(data){
                alert("Neuspešno brisanje ucesnika!");
                console.log(data);
            }
        );

    }
    

});


App.controller("editUcesnikCtrl", function($scope, $http, $routeParams, $location){

    var baseUrlUcesnici = "/api/ucesnici";
    
    $scope.stariUcesnik = {};
    $scope.stariUcesnik.naziv = "";
    $scope.stariUcesnik.mesto = "";
    $scope.stariUcesnik.kontakt = "";
    $scope.stariUcesnik.brojSusreta = "";
    $scope.stariUcesnik.brojBodova = "";
    $scope.stariUcesnik.takmicenjeNaziv = "";

    var getStariUcesnik = function(){

        $http.get(baseUrlUcesnici + "/" + $routeParams.id)
            .then(
            	function success(data){
            		$scope.stariUcesnik = data.data;
            		console.log($scope.stariUcesnik);
            	},
            	function errror(){
            		alert("Neuspešno dobavljanje ucesnika!")
            	}
            );

    }
    
    getStariUcesnik();
    
    $scope.edit = function(){
        $http.put(baseUrlUcesnici + "/edit/" + $routeParams.id, $scope.stariUcesnik)
            .then(
            	function success(){
            		alert("Uspešno izmenjen ucesnik!");
            		$location.path("/ucesnici");
            	},
            	function error(){
            		alert("Neuspešno izmenjen ucesnik!")
            	}
            );
    }
});












