var myArrayObject = [];
function save() {
         
    var myName = document.getElementById("name");
    var age = document.getElementById("age");
   
    try {
        localStorage.setItem("name", myName.value);
        localStorage.setItem("age", age.value);
        myName.value = "";
        age.value = "";
    } 
    catch (e) {
        if (e == QUOTA_EXCEEDED_ERR) {
            console.log("Error: Local Storage limit exceeds.");
        }
        else {
            console.log("Error: Saving to local storage.");
        }
    } 
}

function get() {
    console.log("Getting your data from local storage.");
    var myName = document.getElementById("name");
    var age = document.getElementById("age");
    myName.value = localStorage.getItem("name");
    age.value = localStorage.getItem("age");
   
}

function remove() {
    console.log("Removing data from local storage.");
    localStorage.removeItem("name");
    localStorage.removeItem("age");
   
}

function clearStorage() {
    console.log("Clearing local storage."); 
    localStorage.clear();
   
}

function saveComplexData() {
    console.log("Saving complex data to local storage.");
    var myName = document.getElementById("name");
    var age = document.getElementById("age");
    var commentObject = new Object();
    commentObject.name = myName.value;
    commentObject.age = age.value;
    localStorage.setItem("person", JSON.stringify(commentObject));
   
}

function restoreComplexData() {
    console.log("Restoring complex data from local storage.");
    var myName = document.getElementById("name");
    var age = document.getElementById("age");
    var commentObject = JSON.parse(localStorage.getItem("person"));
    myName.value = commentObject.name;
    age.value = commentObject.age;
}

function saveArrayData() {
    console.log("Saving array data to local storage.");
    var myArrayObject = [];
   
    var personObject1 = new Object();
    personObject1.name = "Array1";
    personObject1.age = 23;
    myArrayObject.push(personObject1);
   
    var personObject2 = new Object();
    personObject2.name = "Array2";
    personObject2.age = 24;
    myArrayObject.push(personObject2);
   
    var personObject3 = new Object();
    personObject3.name = "Array3";
    personObject3.age = 25;
    myArrayObject.push(personObject3);
   
    localStorage.setItem("persons", JSON.stringify(myArrayObject));
   
}

function appendToStorage(name, data){
    var old = localStorage.getItem(name);
    if(old === null) old = "";
    localStorage.setItem(name, old + data);
}



function saveArr() {
	restoreArrayData();
	if(localStorage.getItem("csi518comments")!=null){
		var myArrayObject = JSON.parse(localStorage.getItem("csi518comments"));		
	}else{
		var myArrayObject = [];
	}
	
	var post = document.getElementById("textareaname").value;
    var postTime = new Date();
    console.log("Saving array data to local storage.");
    
   
    var personObject1 = new Object();
    personObject1.post = post ;
    personObject1.postTime = postTime ;
    myArrayObject.push(personObject1);
      
    localStorage.setItem("csi518comments", JSON.stringify(myArrayObject));
    location.reload();
}

function restoreArrayData() {
	 console.log("Restoring array data from local storage.");
	 console.log(localStorage.getItem("csi518comments"));
	    if(localStorage.getItem("csi518comments")!=null){
	    	var myArrayObject = JSON.parse(localStorage.getItem("csi518comments"));
	    for (var i=0; i<myArrayObject.length; i++){
	        var commentObject = myArrayObject[i];
	        console.log("Post: " + commentObject.post, "postTime: " + commentObject.postTime);
	    }
	    }
   
}




function showArrayData() {
	 console.log("Restoring array data from local storage.");
	   
	    var myArrayObject = JSON.parse(localStorage.getItem("persons"));
	    for (var i=0; i<myArrayObject.length; i++){
	        var commentObject = myArrayObject[i];
	        console.log("Name: " + commentObject.name, "Age: " + commentObject.age);
	    }
	   
  
}

function DisplayData() {
    console.log("Restoring array data from local storage.");
    if(localStorage.getItem("csi518comments")!=null){
    var myArrayObject = JSON.parse(localStorage.getItem("csi518comments"));
    for (var i=0; i<myArrayObject.length; i++){
    	
    	var commentObject = myArrayObject[i];
    	
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
    	
//    	var para = document.createElement("p");
//    	var node = document.createTextNode(commentObject.name);
//    	para.appendChild(node);
    	var element = document.getElementById("pastcomments");
    	element.appendChild(trtag);
//        console.log("Name: " + commentObject.name, "Age: " + commentObject.age);
    }
    }
   
}




function load() {
   
    console.log("Page load finished");
    if (typeof(Storage) == "undefined" ) {
            alert("Your browser does not support HTML5 localStorage. Try upgrading.");
    } 
    else {
        console.log("Both localStorage and sessionStorage support is there.");
    }
}