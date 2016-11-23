//var commentArray = [];
function clearStorage() {
    console.log("Clearing local storage."); 
    localStorage.clear();
   
}

function saveComment() {
	restoreArrayData();
	if(localStorage.getItem("csi500comments")!=null){
		var commentArray = JSON.parse(localStorage.getItem("csi500comments"));		
	}else{
		var commentArray = [];
	}
	
	var post = document.getElementById("textareaname").value;
    var postTime = Date();
    console.log("Saving array data to local storage.");
    
   
    var commentObj = new Object();
    commentObj.post = post ;
    commentObj.postTime = postTime ;
    commentArray.push(commentObj);
      
    localStorage.setItem("csi500comments", JSON.stringify(commentArray));
    location.reload();
}

function restoreArrayData() {
	 console.log("Restoring array data from local storage.");
	 console.log(localStorage.getItem("csi500comments"));
	    if(localStorage.getItem("csi500comments")!=null){
	    	var commentArray = JSON.parse(localStorage.getItem("csi500comments"));
	    for (var i=0; i<commentArray.length; i++){
	        var commentObject = commentArray[i];
	        console.log("Post: " + commentObject.post, "postTime: " + commentObject.postTime);
	    }
	    }
   
}




function showArrayData() {
	 console.log("Restoring array data from local storage.");
	   
	    var commentArray = JSON.parse(localStorage.getItem("csi500comments"));
	    for (var i=0; i< commentArray.length; i++){
	        var commentObject = commentArray[i];
	        console.log(i+"--"+"Name: " + commentObject.post);
	    }
	   
  
}

function DisplayData() {
    console.log("Displaying data from storage.");
    if(localStorage.getItem("csi500comments")!=null){
    var commentArray = JSON.parse(localStorage.getItem("csi500comments"));
    console.log("Lendht"+commentArray.length);
    for (var i = commentArray.length-1; i>=0; i--){
    	var commentObject = commentArray[i];
    	console.log("Displaying data - "+ commentObject.post);
    	
    	var trtag = document.createElement('tr');
    	var tdtag = document.createElement('td');
    
    	var time = document.createElement('p');
    	time.className = "text-black";
    	var text = document.createTextNode(commentObject.post);
    	time.appendChild(text);
    	tdtag.appendChild(time);
    	trtag.appendChild(tdtag);
    	
//    	console.log(tdtag);
    	var time = document.createElement('p');
    	time.className = "small hint-text";
    	var text = document.createTextNode(commentObject.postTime);
    	time.appendChild(text);
    	tdtag.appendChild(time);
    	trtag.appendChild(tdtag);
    	
    	var element = document.getElementById("pastcomments");
    	element.appendChild(trtag);
//        console.log("Name: " + commentObject.name, "Age: " + commentObject.age);
    }
    }else{
    	var element = document.getElementById("pastcomments");
    	element.innerHTML = "<tr><td>No comments.<td><tr>";
    }
   
}
