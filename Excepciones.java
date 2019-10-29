public class Excepciones{
	public static void main(String[] args){
		try{
			lanzarExcepcion();
		}catch(Exception excepcion){
			System.err.println("La excepcion se manejo en main");
		}
		noLanzaExcepcion();
	}

	public static void lanzarExcepcion() throws Exception{
		try{
			System.out.println("El metodo lanzarExcepcion");
			throw new Exception();
		}catch(Exception excepcion){
			System.err.println("La excepcion se manejo en el metodo lanzarExcepcion");
			throw excepcion;
			// cualquier código en esta región no llega a ejecutarse
		}finally{
			System.err.println("Finalmente se ejecuto en lanzarExcepcion");
		}

		// cualquier código en esta región no llega a ejecutarse
	}

	// demostrar finally cuando no ocurre excepcion
	public static void noLanzaExcepcion(){
		try{
			System.out.println("El metodo noLanzaExcepcion");
		}catch(Exception excepcion){
			System.err.println(excepcion);
		}finally{
			System.err.println("Finalmente se ejecuto en noLanzaExcepcion");
		}
		System.out.println("Fin del metodo noLanzaExcepcion");
	}
}