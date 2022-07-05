import java.util.Scanner;                                        // Para importar a Variavel Scanner
import java.util.Locale;                                         // Para importar o a LocalizaÃ§Ã£o dos EUA


public class Estrutura_Sequencial {

	public static void main(String[] args) {

		//! --------------------------------------------------Exercicio 01 ------------------------------------------------------------------------------

// ----- FaÃ§a um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses numeros com uma mensagem explicativa, conforme exemplos.
		
		
		Scanner sc = new Scanner(System.in);
		
		Double A1, B1, Resultado1;
		int A2, B2, Resultado2;
		int A3, B3, Resultado3;
		
		A1 = 10.0;
		B1 = 30.0;
		Resultado1 = A1 + B1;
		System.out.println("A Soma de A1 e B1 São: " + Resultado1);
		System.out.println( );

		
		A2 = -30;
		B2 = 10;
		Resultado2 = A2 + B2;
		System.out.println("A Soma de A2 e B2 São: " + Resultado2);
		System.out.println( );

		
		A3 = 0;
		B3 = 0;
		Resultado3 = A3 + B3;
		System.out.println("A Soma de A3 e B3 São: " + Resultado3);
		System.out.println("____________________________________________________________________________________");
		
		
		
		
		
		
		
//! ---------------------------------------------------Exercicio 02------------------------------------------------------------------------------------
	
/*
    Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro casas decimais conforme exemplos.
		        Fórmula da área: area = π . raio2
		        Considere o valor de π = 3.14159
*/	
		
		
		Locale.setDefault(Locale.ENGLISH);                       // Para Transformar as virgulas ( padrÃo BR para pontos padrÃo EUA)                      	
		double Ar1, Ar2, Ar3;
		double AreaC1, AreaC2, AreaC3;
		double Pi = 3.14159;
		
		Ar1 = 2.00;
		Ar2 = 100.64;
		Ar3 = 150.00;
		
		AreaC1 = Pi * (Ar1 * Ar1);
		AreaC2 = Pi * (Ar2 * Ar2);
		AreaC3 = Pi * (Ar3 * Ar3);
		
		System.out.println(AreaC1);
		System.out.println( );
		System.out.println(AreaC2);
		System.out.println( );
		System.out.println(AreaC3);
		System.out.println("____________________________________________________________________________________");
		
		
		
		
		
		
//------------------------------------------------------------------------------- Exercicio 03-----------------------------------------------------------
		
/*		
                 Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto
		         de A e B pelo produto de C e D segundo a fórmula: DIFERENÇA = (A * B - C * D)
*/	
		
		
		int G1, G2, G3, G4;
		int H1, H2, H3, H4;
		int Diferenca1;
		int Diferenca2;
		
		G1 = 5;
		G2 = 6;
		G3 = 7;
		G4 = 8;
		
		H1 = 5;
		H2 = 6;
		H3 = -7;
		H4 = 8;
		
		
		Diferenca1 = (G1 * G2) - (G3 * G4);
		Diferenca2 = (H1 * H2) - (H3 * H4);
		
		System.out.println(Diferenca1);
		System.out.println( );
		System.out.println(Diferenca2);
		System.out.println("____________________________________________________________________________________");
		
		
		
		
		
		
// ------------------------------------------------------- Exercicio 04
	
/*
           Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
           hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas decimais
*/	
		
		
	int Funcionario1, Funcionario2, Funcionario3;
	int Hora1, Hora2, Hora3;
	double Valor_Hora1, Valor_Hora2, Valor_Hora3;
	double Salario1, Salario2, Salario3;
	
	Funcionario1 = 25;
	Funcionario2 = 1;
	Funcionario3 = 6;
	
	Hora1 = 100;
	Hora2 = 200;
	Hora3 = 145;
	
	Valor_Hora1 = 5.50;
	Valor_Hora2 = 20.50;
	Valor_Hora3 = 15.55;
	
	Salario1 = Hora1 * Valor_Hora1;
	Salario2 = Hora2 * Valor_Hora2;
	Salario3 = Hora3 * Valor_Hora3;
	
	
	
	System.out.println("Funcionarios:");
	System.out.printf("Funcionario de Número: %d %n", Funcionario1);
	System.out.printf("Salario: %.2f %n", Salario1);
	System.out.println( );
	
	System.out.printf("Funcionario de Número: %d %n", Funcionario2);
	System.out.printf("Salario: %.2f %n", Salario2);
	System.out.println( );
	
	System.out.printf("Funcionario de Número: %d %n", Funcionario3);
	System.out.printf("Salario: %.2f %n", Salario3);
	System.out.println( );
	System.out.println("____________________________________________________________________________________");
	
	
	
	
	
	
	
	
	// ------------------------------------------------------- Exercicio 05
/*	
      Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
      código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago

*/
	//int Cdpeca1, Cdpeca2, Cdpeca3;
	int Npecas1, Npecas2, Npecas3;
	double Valor_peca1, Valor_peca2, Valor_peca3;
	
	//Cdpeca1 = 12;
	//Cdpeca2 = 13;
	//Cdpeca3 = 1;
	
	Npecas1 = 1;
	Npecas2 = 2;
	Npecas3 = 1;
	
	Valor_peca1 = 5.30;
	Valor_peca2 = 15.30;
	Valor_peca3 = 15.10;
	
	//int Cd2peca1, Cd2peca2, Cd2peca3;
	int N2pecas1, N2pecas2, N2pecas3;
	double Valor2_peca1, Valor2_peca2, Valor2_peca3;
	
	//Cd2peca1 = 19;
	//Cd2peca2 = 161;
	//Cd2peca3 = 2;
	
	N2pecas1 = 2;
	N2pecas2 = 4;
	N2pecas3 = 1;
	
	Valor2_peca1 = 5.10;
	Valor2_peca2 = 5.20;
	Valor2_peca3 = Valor_peca3;
	
	double Valor_Total1, Valor_Total2, Valor_Total3;
	
	Valor_Total1 = (Npecas1 * Valor_peca1 ) + (N2pecas1 * Valor2_peca1);
	Valor_Total2 = (Npecas2 * Valor_peca2 ) + (N2pecas2 * Valor2_peca2);
	Valor_Total3 = (Npecas3 * Valor_peca3 ) + (N2pecas3 * Valor2_peca3);
	
	System.out.printf("Valor a Ser pago R$: %.2f %n", Valor_Total1);
	System.out.printf("Valor a Ser pago R$: %.2f %n", Valor_Total2);
	System.out.printf("Valor a Ser pago R$: %.2f %n", Valor_Total3);
	System.out.println("____________________________________________________________________________________");
	

	
	
	
	// ------------------------------------------------------- Exercicio 06
	
/*	Fazer um programa que leia três valores com ponto flutuante de dupla precisão: A, B e C. Em seguida, calcule e
	mostre:
	a) a área do triângulo retângulo que tem A por base e C por altura.
	b) a área do círculo de raio C. (pi = 3.14159)
	c) a área do trapézio que tem A e B por bases e C por altura.
	d) a área do quadrado que tem lado B.
	e) a área do retângulo que tem lados A e B.
	
*/
	
	
double Triangulo1, Triangulo2, Circulo1, Circulo2, Trapezio1, Trapezio2, Quadrado1, Quadrado2, Retangulo1, Retangulo2;
double pi = 3.14159;
double A06_1, B06_1, C06_1;
double A06_2, B06_2, C06_2;

A06_1 = 3.0;
B06_1 = 4.0;
C06_1 = 5.2;

A06_2 = 12.7;
B06_2 = 10.4;
C06_2 = 15.2;

Triangulo1 = (A06_1 * C06_1) / 2;
Triangulo2 = (A06_2 * C06_2) / 2;

Circulo1 = pi * (C06_1 * C06_1);
Circulo2 = pi * (C06_2 * C06_2);

Trapezio1 =  ((A06_1 + B06_1) * C06_1) / 2;
Trapezio2 =  ((A06_2 + B06_2) * C06_2) / 2;

Quadrado1 = B06_1 * B06_1;
Quadrado2 = B06_2 * B06_2;

Retangulo1 = A06_1 * B06_1;
Retangulo2 = A06_2 * B06_2;

System.out.printf("Triangulo: %.3f %n", Triangulo1);
System.out.printf("Circulo: %.3f %n", Circulo1);
System.out.printf("Trapezio: %.3f %n", Trapezio1);
System.out.printf("Quadrado: %.3f %n", Quadrado1);
System.out.printf("Retangulo: %.3f %n", Retangulo1);
System.out.println( );


System.out.printf("Triangulo 2: %.3f %n", Triangulo2);
System.out.printf("Circulo 2: %.3f %n", Circulo2);
System.out.printf("Trapezio 2: %.3f %n", Trapezio2);
System.out.printf("Quadrado 2: %.3f %n", Quadrado2);
System.out.printf("Retangulo 2: %.3f %n", Retangulo2);

System.out.println("____________________________________________________________________________________");




		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
