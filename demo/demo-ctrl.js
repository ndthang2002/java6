let host ="https://poly-java-6-13436-default-rtdb.firebaseio.com";
const app =angular.module("app",[]);
app.controller("ctrl", function($scope,$http){
$scope.form={}
$scope.items={}
$scope.reset = function(){
$scope.form ={gender:true, country:'VN'};
$scope.key =null;

}
$scope.load_all = function(){
    var url = `${host}/students.json`;
    $http.get(url).then(resp=>{
        $scope.items =resp.data;
        console.log("Success",resp)
    }).catch(error =>{
        console.log("Error",error)
        alert("loi roi");
    });
}
$scope.edit= function(key){
    var url= `${host}/students/${key}.json`;
    $http.get(url).then(resp =>{
        $scope.form = resp.data;
        $scope.key = key;
        console.log("Success",resp)
        console.log(key)
        console.log(resp.data)
    }).catch(error=>{
        console.log("Error",error)
    });
}

$scope.update =function(){
    var item = angular.copy($scope.form);
    var url = `${host}/students/${$scope.key}.json`;
    $http.put(url,item).then(resp=>{
        $scope.items[$scope.key] = resp.data;
    console.log("Sucess",resp)
    console.log($scope.items[$scope.key],"hhi")
    console.log(item)
    }).catch(error=>
        console.log("error",error)
    );
}
$scope.create = function(){
    var item = angular.copy($scope.form);
    var url = `${host}/students.json`;
    $http.post(url,item).then(resp =>{
       $scope.key= resp.data.name;
       $scope.items[$scope.key] =item;
       $scope.reset();
       alert("them thanh cong");
    }).catch(error =>{
        console.log("Error",error)
    });
    }
$scope.delete = function(key){
 var url = `${host}/students/${key}.json`;
 $http.delete(url).then(resp =>{
    delete $scope.items[key];
    $scope.reset();
    console.log("Success",resp)
 }).catch(error =>{
   console.log("Error",error)
 });
}

$scope.load_all();
$scope.reset();
})
