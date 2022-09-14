app.controller("product-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.cates = [];
	//khoi dau
	$scope.initialize = function() {
		//load product
		$http.get("/rest/products").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})


		});
		//phân trang 
$scope.pager = {
		
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
			get count(){
			return Math.ceil(1.0*$scope.items.length/this.size);
		},
		first(){
			this.page=0;
		},
		previos(){
			this.page--;
			if(this.page<0){
				this.first();
				
			}
		},	
		next(){
			this.page++;
			if(this.page >= this.count){
				this.first();
			};
		},
			last(){
			this.page = this.count -1;
		}
	}
		//load categories
		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;




		});
	}




	//edit
	$scope.edit = function(item) {

		$scope.form = angular.copy(item);
		$('#pills-home-tab').tab('show');
	}
	// upload hinh

	$scope.imageChanged = function(files) {

		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		})
	}


	// xóa form
	$scope.reset = function() {
		$scope.form = {
			createDate: new Date(),
			image: 'cloud-upload.jpg',//hình măc định của img
			available: true,
		};
	}
	// thêm 
	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/products`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			$scope.initialize();
			$scope.imageChanged();
			alert("them moi san pham thanh cong");
		}).catch(error => {
			alert("loi them moi san pham ");
			console.log("Error", error);
		});
	}
	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/products/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("cap nhat san pham thanh cong!");
		})
			.catch(error => {
				alert("loi cap nhat san pham!");
				console.log("Error", error);
			})
	}



	//xoa san pham 
	$scope.delete = function(item) {

		$http.delete(`/rest/products/${item.id}`).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index, 1); // splice xóa phần tử trong mảng tại vị trí index và xóa 1 cái
			alert("cập nhật sản phẩm thành công ");
		})
			.catch(error => {
				alert("xoa loi");
				console.log("Error", error)
			})
	}
	
		

	$scope.initialize();
	$scope.reset();
})