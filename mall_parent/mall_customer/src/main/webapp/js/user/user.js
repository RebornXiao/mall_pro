$(function(){
	
	$("#loginBtn").on("click",function(){
		var data={
			userAccount:$("#loginEmail").val().trim(),
			password:$("#loginPassword").val().trim()
		};
		var param={
			url:"http://127.0.0.1:8083/mall_customer/user/login",
			data:JSON.stringify(data),
			dataType:'json',
            type:'POST', //GET
            contentType : 'application/json;charset=UTF-8', 
			success:function(data){
				if(data.status==1){
					$("#myModal88").remove();
					alert("恭喜你登录成功！");
				}
			},
			error:function(error){
				
			}
				
		};
		$.ajax(param);
	});
	
	$("#registerBtn").on("click",function(){
		var data={
				userAccount: $("#rEmail").val().trim(),
				accountType:1,
				password:$("#rPassword").val().trim(),
				userName:$("#rUserName").val().trim()
		};
		var param={
				url:"http://127.0.0.1:8083/mall_customer/user/register",
				dataType:'json',
		        type:'POST', //GET
		        contentType : 'application/json;charset=UTF-8', 
				data:JSON.stringify(data),
				success:function(data){
					console.log(data);
				},
				error:function(error){
					
				}
		};
		$.ajax(param);
	});
});