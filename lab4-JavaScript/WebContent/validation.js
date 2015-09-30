function validate() {
    
	//validate name
	var name = document.getElementById("name").value;
	var lettersAndNum = /^[A-Za-z0-9]+$/;  
    if(!document.getElementById("name").value.match(lettersAndNum))  
      {
	  if (name == null || name == '') {
       alert("Name must be filled out");
       return false;
	  }
	  else{
      alert("Please input alphabet and numberic characters only"); 
      return false;  
      }  
   }

   //validate gender    
  var dropDown = document.getElementById("gender");
        if (dropDown.value == "blank") {
            alert("Please select a gender");
            return false;
        }
		
	//validate address
		var address=document.getElementById("address").value;
		 if (address == null || address == '') {
			alert("Address must be filled out");
			return false;
		}
		
	//validate email 
		var email=document.getElementById("email").value;
		var emailString = /^([A-Za-z0-9]{3})+\@([A-Za-z0-9]{3})+\.([A-Za-z0-9]{3})$/;
		if (email == null || email == '') {
			alert("email must be filled out");
			return false;
		}
		if(!document.getElementById("email").value.match(emailString)){
			alert("Email must be of the form xxx@xxx.xxx");
			return false;
		}
		
	
		
	//validate phone	
		var phone1 = /^\(?([0-9]{3})\)?[-]?([0-9]{3})[-]?([0-9]{4})$/;
		var phone2 = /^[0-9]{10}$/;  
		if(!document.getElementById("phone").value.match(phone1)){
			if(document.getElementById("phone").value.match(phone2)){
			return true;
			}
		else{
			alert("Phone must be in the form of xxx-xxx-xxxx or xxxxxxxxxx");
			return false;
			}
		}
		
		
        return true;


}

