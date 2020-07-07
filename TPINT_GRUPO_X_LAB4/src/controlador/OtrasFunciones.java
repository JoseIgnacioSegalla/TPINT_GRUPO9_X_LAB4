package controlador;


public class OtrasFunciones {

	
	
	public static String Advertencia(int Opcion) {
		
		switch(Opcion) {
		
		case 1:
			
			return "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
			+ "<script>"
			+ " $(document).ready(function(){"
			+ "swal('Error', 'Los campos Usuario y Clave no deben estar vacios' ,'error');"
			+ "})" 
			+ "</script>\r\n";
		
		case 2:
			
			return "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
			+ "<script>"
			+ " $(document).ready(function(){"
			+ "swal('Error', 'El usuario no esta registrado' ,'error');"
			+ "})" 
			+ "</script>\r\n";
		

		case 3:
			
			return "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
			+ "<script>"
			+ " $(document).ready(function(){"
			+ "swal('Genial', 'Guardado con exito' ,'success');"
			+ "})" 
			+ "</script>";
			
		case 4:
			
			return "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
					+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
					+ "<script>"
					+ " $(document).ready(function(){"
					+ "swal('Genial', 'Eliminado con exito' ,'success');"
					+ "})" 
					+ "</script>";
			
		case 5:
					
			return "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js\"></script>"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>"
			+ "<script>"
			+ " $(document).ready(function(){"
			+ "swal('Error', 'El Nombre de usuario ya existe' ,'error');"
			+ "})" 
			+ "</script>";
			
		default:
			
			return "";
		
		}
		
	
		
	}
	
	public static String Tablas(int Opcion,String NombreTabla) {
		
		switch(Opcion) {
		
		case 1:
			
			return "<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/bs4/dt-1.10.21/b-1.6.2/sp-1.1.1/sl-1.3.1/datatables.min.css\"/>\r\n" + 
					"<script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/bs4/dt-1.10.21/b-1.6.2/sp-1.1.1/sl-1.3.1/datatables.min.js\"></script>\r\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\r\n" + 
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n" + 
					"<script src=\"https://stackpath.bootstrapcd	n.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>	\r\n" + 
					"<script src=\"https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js\"></script>\r\n" + 
					"<script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\r\n" + 
					"<script> \r\n" + 
					"   $('"+ NombreTabla +"').DataTable({\r\n" + 
					"\r\n" + 
					"	   pagingType: 'full_numbers'\r\n" + 
					"   });\r\n" + 
					"</script>";
			
			
		default:
			
			return "";
		
		}
	}
	public static String DDL(int Opcion,String NombreDDL,int Pos) {
		
		switch(Opcion) {
		
		case 1:
			
		return "<script src=\"https://code.jquery.com/jquery-3.2.1.js\"></script>" +
		"<script type=\"text/javascript\">" +
		"$(document).ready(function(){" +
		"$('#" + NombreDDL + "> option[value=\" "+ Pos +" \"]').attr('selected', 'selected');" +
		"});" +
		"</script>";
			
		default:
			
			return "";
		}
	}
	
	
}
