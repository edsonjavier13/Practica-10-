public class TraceExceptions{
	public static void main (String[] args){
		try{
			metodo1();
		}catch(Exception excepcion){
			System.err.println(excepcion.getMessage() + "\n");
			StackTraceElement[] elementosRastreo = excepcion.getStackTrace();

			System.out.println("\nRastreo de pila proveniente de getStacTrace:");
			System.out.println("Clase\t\tArchivo\t\t\tLinea\tMetodo");

			for(int i = 0; i < elementosRastreo.length; i++){
				StackTraceElement elementoActual= elementosRastreo[i];
				//TraceExceptions elementoActual = (StackTraceElement) elementosRastreo[i];
				System.out.print(elementoActual.getClassName() + "\t");
				System.out.print(elementoActual.getFileName() + "\t");
				System.out.print(elementoActual.getLineNumber() + "\t");
				System.out.print(elementoActual.getMethodName() + "\n");
			}
		}
	}

	public static void metodo1() throws Exception{
		metodo2();
	}

	public static void metodo2() throws Exception{
		metodo3();
	} 

	public static void metodo3() throws Exception{
		throw new Exception("La excepcion se lanzo en metodo3");
	}
}
