$(document).ready(function() {
		    $('#TablaAdmin').DataTable( {
		    	"searching": true,
		 		lengthMenu: [[5,10,50,-1], [5,10,50,"Todos"]],
		    })
 });
//Restricts input for the given textbox to the given inputFilter.
 function setInputFilter(textbox, inputFilter) {
   ["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function(event) {
     textbox.addEventListener(event, function() {
       if (inputFilter(this.value)) {
         this.oldValue = this.value;
         this.oldSelectionStart = this.selectionStart;
         this.oldSelectionEnd = this.selectionEnd;
       } else if (this.hasOwnProperty("oldValue")) {
         this.value = this.oldValue;
         this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
       } else {
         this.value = "";
       }
     });
   });
 }