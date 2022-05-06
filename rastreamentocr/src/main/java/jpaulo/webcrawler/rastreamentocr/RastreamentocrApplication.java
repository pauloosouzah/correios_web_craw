package jpaulo.webcrawler.rastreamentocr;

import java.io.IOException;
import jpaulo.webcrawler.Classes.Passing;
import jpaulo.webcrawler.Classes.capturarDados;

public class RastreamentocrApplication {

	public static void main(String[] args) throws IOException {
	//1
	System.out.println("1 - RASTREAR OBJETO");
	System.out.println("2 - VERFICAR ENDEREÇO COM O CEP");
	System.out.println("3 - CONSULTAR PRAZO DE ENVIO");
	System.out.print("Escolha a opção desejada: ");
	Passing.cod = Passing.entrada.nextInt();	
		
	switch(Passing.cod){
	case 1:
		System.out.print("Digite o seu código de rastreio: ");
		Passing.codRastreio = Passing.entrada.next();
		capturarDados.rastrearObjeto(Passing.codRastreio);
		break;
	case 2:
		System.out.print("Digite o seu código de rastreio: ");
		Passing.codCEP = Passing.entrada.nextInt();
		capturarDados.buscarCEP(Passing.codCEP);
		break;
	case 3:
		System.out.print("Digite o CEP de origem: ");
		Passing.cepOrigem = Passing.entrada.nextInt();
		System.out.print("Digite o CEP de destino: ");
		Passing.cepDestino = Passing.entrada.nextInt();
		capturarDados.calcularPrazo(Passing.cepOrigem,Passing.cepDestino);
		break;
	}
		
	}

}
