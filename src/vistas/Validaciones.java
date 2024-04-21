package vistas;

import java.util.Scanner;

public class Validaciones {
	
	public  String validarString() {
		Scanner scanner = new Scanner(System.in);
		String string;
		while (true) {
			string=scanner.nextLine();
			if(string.equals("")) {
				System.out.print("Error, el texto no debe estar vacio. Ingrese nuevamente: ");
			}
			else {break;}
		}
		return string;
	}
	public  double validarDouble() {
		Scanner scanner = new Scanner(System.in);
		double num;
		while(true) {
			if(scanner.hasNextDouble()) {
				num=scanner.nextDouble();
				if(num<=0) {
					System.out.println("Error numero no valido. Ingrese nuevamente: ");
					scanner.nextLine();
				}
				else {break;}
				
			}
			else {	
			 System.out.println("Error numuero no valido. Ingrese nuevamente: ");
			 scanner.nextLine();
			}

		}
		return num;
	}
	public  int validarInt() {
		Scanner scanner = new Scanner(System.in);
		int num;
		while(true) {
			if(scanner.hasNextInt()) {
				num=scanner.nextInt();
				if(num<=0) {
					System.out.println("Error numero no valido. Ingrese nuevamente: ");
					scanner.nextLine();
				}
				else {break;}
				
			}
			else {	
			 System.out.println("Error numuero no valido. Ingrese nuevamente: ");
			 scanner.nextLine();
}
		}
		return num;
	}
	public  char validarChar() {
		Scanner scanner = new Scanner(System.in);
		char c;
		while(true) {
			String string=scanner.nextLine();
			if(string.length()==1) {
				c=string.charAt(0);
				break;
			}
			else {
				System.out.println("Error, ingrese una letra: ");
			}
		}
		return c;
	}
}
