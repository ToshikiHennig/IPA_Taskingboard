var remoteUser = null;

$(document).ready(function () {
	$.getJSON("/getalluser", function(result){
		for (i in result) {
		    $('#assignee').append($('<option>', { 
		        value: result[i].username + "",
		        text : result[i].username + ""
		    }));
		}
    });

});

$(function() { 
    $('#newTaskForm').on('submit', function(e) { 
        e.preventDefault(); 
        console.log($('#assignee option:selected').text());
        $.post( "/newTask", { assignee: $('#assignee option:selected').text(), title : $('#title').val(), description : $('#description').val()}, function(result, status){
	    }).done(function() {
	    	$('#title').val('');
      	     $('#description').val('');
      	     $.notify("Task wurde erstellt", "success");		
	    }).fail(function() {
	    	$.notify("Da ist was schief gelaufen", "error");
	    });;
    });
});