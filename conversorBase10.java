package ort.thp.ejercicios;

import java.util.Scanner;

public class conversorBase10 {

	public static void main(String[] args) {

		//Instancio input
		Scanner input = new Scanner(System.in);
		
		//Pido un numero
		System.out.println("Ingrese el numero");		
		String num = input.nextLine();

		//Pido la base
		System.out.println("Ingrese la base");		
		int base = input.nextInt();

		input.nextLine();
		
		convertirYMostrarResultado(num, base);
		
		System.out.println("Correr test con ejercicios del TP digite 0 y enter: ");		
		int test = input.nextInt();
		
        System.out.println(test);
        if(test == 0) {
			convertirYMostrarResultado("12,3", 4);
			convertirYMostrarResultado("B9,01", 16);
			convertirYMostrarResultado("371,4", 8);
			convertirYMostrarResultado("10100,001", 2);
			convertirYMostrarResultado("6,125", 7);
			convertirYMostrarResultado("1111,11", 2);
			convertirYMostrarResultado("D,0C", 16);
			convertirYMostrarResultado("44,2", 8);
			convertirYMostrarResultado("64,1", 9);
        }

        input.close();

		
	}
	
	private static void convertirYMostrarResultado(String num, int base) {

		//Espliteo por la coma
		String[] split = num.split(",");
		
		//Defino acumuladores generales
		int l=-1;

		//Defino acumulador principal
        float acumulate = 0; 

		//Defino acumulador acumulador de la demostracion
        String demostracion = ""; 
        String concatenador = " + ";
        
        //Agarro los numeros antes de la coma y los recorro
		for (int i = 0; i < split[0].length(); ++i) {
			//Defino la potencia, el numero total menos -i para empezar de mayor a menor
            int potencia = split[0].length() - 1 - i;
			//Parseo por si es una letra de base 16
            String parsedNumber = conversorNumberBase16(split[0].substring(i,i+1));
			//Paso a int el string con el numero
            int numAcumulado = Integer.parseInt(parsedNumber);          
			//Cierro el concatenador de "+" si llegue al final y si no hay numeros despues de la coma
            if(split[0].length() == (i+1) && split.length < 2) {
            	concatenador = "";
            }            
			//Acumulo la primera parte de la demostracion
            demostracion += numAcumulado + " . " + base + " (" + potencia + ")" + concatenador;
			//Acumulo la suma de la primera parte
            acumulate += numAcumulado * (float) Math.pow(base,potencia);
		}

        //Si existen agarro los numeros despues de la coma y los recorro
        if (split.length > 1) {
        	for (int i = 0; i < split[1].length(); ++i) {
    			//Asigno una potencia negativa y le voy sacando 1 cada vez que paso (-1, -2, etc)
                int potencia = l;
    			//Parseo por si es una letra de base 16
                String parsedNumber = conversorNumberBase16(split[1].substring(i,i+1));                
    			//Paso a int el string con el numero
                int numAcumulado = Integer.parseInt(parsedNumber);
                
    			//Cierro el concatenador de "+" si llegue al final
                if(split[1].length() == (i+1)) {
                	concatenador = "";
                }
                
    			//Acumulo la segunda parte de la demostracion
                demostracion += numAcumulado + " . " + base + " (" + potencia + ")" + concatenador;
    			//Acumulo la suma de la segunda parte
                acumulate += numAcumulado * (float) Math.pow(base,potencia);
                //Resto en -1 la potencia
                l--;
    		}
        }
        

        System.out.println("Demostracion: " + demostracion);
        System.out.println("Resultado: " + acumulate);
		
	}
	
	private static String conversorNumberBase16(String currentNum) {
		String result = "";
		switch(currentNum) {
		  case "A":
			  result = "10";
		    break;
		  case "B":
			  result = "11";
		    break;
		  case "C":
			  result = "12";
		    break;			  
		  case "D":
			  result = "13";
		    break;					  
		  case "E":
			  result = "14";
		    break;					  
		  case "F":
			  result = "15";
		    break;					  
		  default:
			  result = currentNum;
		}
		
		return result;
	}

}
