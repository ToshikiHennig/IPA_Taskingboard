$(document).ready(function () {
	console.log('wurde ausgeführt');
    addElements();
    $(function () {
        $("#openTasks, #closedTasks").sortable({
            connectWith: ".taskfield",
            cursor: "move",
            change: function (event, ui){
            
            },
            update: function(event, ui){
            	 if (this === ui.item.parent()[0]) {          		 
            		if($(ui.item).children("div").attr("taskparent") == ui.item.parent().attr("id")){
            			 console.log($(ui.item).children("div").attr("id")); 
            			 console.log(ui.item.parent().attr("id")); 
            			 $.notify("ACHTUNG: Die Reihenfolge wird nach Neuladen der Seite wieder zurück gesetzt", "warn");
            		 }else{	
            			 $.post( "/updateTask", {id: $(ui.item).children("div").attr("id")}, function(result, status){
            			    }).done(function() {
            			    	 (ui.item).children("div").attr("taskparent", ui.item.parent().attr("id"));
            		      	     $.notify("Task wurde aktualisiert", "success");		
            			    }).fail(function() {
            			    	$.notify("Oops, da ist was schief gelaufen", "error");
            			    	$("#errorBox").css("display", "block");
            			    	 $( "#openTasks, #closedTasks" ).sortable("disable");
            			    });
            		 }
            		 
            	    }
            	
            }
        }).disableSelection();
    });


});

function reloadPage(){
	location.reload();
}

function addElements() {
	$.getJSON("/getalltasks", function(result){
		console.log(result);
		for (i in result) {
		    if(result[i].done == false){
		    	console.log(result[i].done);
		    	$("#openTasks").append('<div class="task"><div taskparent="openTasks" id="'+result[i].id +'"></div><div class="task-title">' 
		    			+ result[i].title + '</div><div class="description">' 
		    			+ result[i].description + '</div></div>');
		    }else{
		    	$('#closedTasks').append('<div class="task"><div taskparent="closedTasks" id="'+result[i].id +'"></div><div class="task-title">' + result[i].title + '</div><div class="description">' + result[i].description + '</div></div>');
		    }
		}
    });  
}