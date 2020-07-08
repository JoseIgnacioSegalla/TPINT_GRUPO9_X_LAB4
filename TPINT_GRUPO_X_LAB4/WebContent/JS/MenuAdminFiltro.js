$(document).ready(function() {
		    $('#TableMenuAdmin').DataTable( {
		    	
		    	 "columnDefs": [
		 		    { "orderable": false, "targets": [5,6,7],visible:true}
		 		  ],
		    		
		 		 "searching": true,
		 		lengthMenu: [[5,10,50,-1], [5,10,50,"Todos"]],

		        initComplete: function () {
		        	
		       // EL NUMERO INDICA LA COLUMNA
		       // 	this.api().columns([0, 1, 2, 3, 4]).every( function () {
		    	   this.api().columns([0, 1, 2]).every( function () {
		                var column = this;
		                var select = $('<select><option value=""></option></select>')
		                    .appendTo( $(column.header()).empty() )
		                    .on( 'change', function () {
		                        var val = $.fn.dataTable.util.escapeRegex(
		                            $(this).val()
		                        );
		 
		                        column
		                            .search( val ? '^'+val+'$' : '', true, false )
		                            .draw();
		                    } );
		 
		                column.data().unique().sort().each( function ( d, j ) {
		                    select.append( '<option value="'+d+'">'+d+'</option>' )
		                } );
		            } );
		    	   this.api().columns([3,4]).every(function() {
		    	        var that = this;
		    	        var input = $('<input type="text" placeholder="Search" />')
		    	          .appendTo($(this.header()).empty())

		    	          .on('keyup change', function() {
		    	            if (that.search() !== this.value) {
		    	              that
		    	                .search(this.value)
		    	                .draw();
		    	            }
		    	          });
		    	      });
		        }
		    } );
		} );