
  var id = makeid();
  
  function login() {
	  var token = httpGet("http://localhost:8080/loginSMS/auxiliar?tlfn=").concat($('#tlfn').val());
	 
	  if(null == token) {
		  $('#error').show();
	  }else {
		  window.location.replace("http://localhost:8080/loginSMS/views/waiting.jsp");
	  }
//	  $('#enlace').attr("href", "http://localhost:8080/loginSMS/confirmation?id=".concat(id));

//	  var confirmed = httpGet("http://localhost:8080/loginSMS/fullLogin?id="
//			  .concat(id).concat("&tlfn=").concat($('#tlfn').val()));
//	  if(confirmed) {
//		  window.location.replace("http://localhost:8080/loginSMS/views/index.jsp?id=".concat(id));
//	  }else {
//		  alert("TIMEOUT");
//	  }
  }
  
  function httpGet(theUrl)
  {
      var xmlHttp = new XMLHttpRequest();
      xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
      xmlHttp.send( null );
      console.log(xmlHttp);
      return xmlHttp.responseText;
  }
  
  function makeid()
  {
      var text = "";
      var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

      for( var i=0; i < 5; i++ )
          text += possible.charAt(Math.floor(Math.random() * possible.length));

      return text;
  }
  
  function update() {
	    $.ajax({
	    	type : 'GET',
	        url : 'http://localhost:8080/loginSMS/isConfirmed?id='.concat(id),
	        success : function(data){
	        	console.log(data);
	            if(data) {
	            	alert("Se ha confirmado el login");
	            	window.location.replace("http://localhost:8080/loginSMS/views/index.jsp?id=".concat(id));
	            }
	            else {
	            	console.log("Esperando...");
	            	setTimeout(update, 5000); 
	            }
	        },
	        error : function(err) {
	        	console.log("ERROR:" + err);
	        }
	    });
	}; 
  
