const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope,$http){
	$scope.cart ={
		
		items:[],
		//them san pham  vao gio hang
		add(id){
			var item = this.items.find(item =>item.id ==id);
			if(item){
				item.qty++;
				this.saveToLocalStorage();
			}
			else{
				$http.get(`/rest/products/${id}`).then(resp =>{
					resp.data.qty =1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},
		
		// lưu giỏ hàng vào loca storage
		saveToLocalStorage(){
			var json =JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart",json);
		},
		
		// tính tổng số lượng các mặt hàng trong giỏ
		get count(){
			return this.items
			.map(item => item.qty)
			.reduce((total,qty) => total += qty,0);
		},
		
		// tổng thành tiền các mặt hàng trong giỏ
		get amount(){
			return this.items
			.map(item => item.qty* item.price)
			.reduce((total,qty) => total += qty,0);
		},
		
		//xoa san pham khoi gio hang
		remove(id){
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index,1);
			this.saveToLocalStorage();
			
		},
		//xoa sach cac mat hang trong gio
		clear(){
			this.items=[]
			this.saveToLocalStorage();
		},
		// đọc giỏ hàng từ local storage 
		loadFromLocalStorage(){
			
			var json =localStorage.getItem("cart");
			this.items =json ? JSON.parse(json):[];
			
		}
	}
	$scope.cart.loadFromLocalStorage();
   $scope.order = {
       createDate:new Date(),
       address:"",
       account:{username:$("#username").text()},
       get orderDetails(){
           return $scope.cart.items.map(item=>{
               return{
                   product:{id:item.id},
                   price:item.price,
                   quantity:item.qty
               }
           })
       },
       purchase(){
           var order = angular.copy(this);
           //Thực hiện đặt hàng
           $http.post("/rest/orders",order).then(resp=>{
               alert("Đặt hàng thành công!");
               $scope.cart.clear();
               location.href = "/order/detail/"+resp.data.id;
           }).catch(err=>{
               alert("Đặt hàng lỗi!")
               console.log(err);
           })
       }
   };
})
	
