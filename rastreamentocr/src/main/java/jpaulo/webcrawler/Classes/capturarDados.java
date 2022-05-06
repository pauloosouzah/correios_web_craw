package jpaulo.webcrawler.Classes;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import jpaulo.webcrawler.rastreamentocr.RastreamentocrApplication;

public class capturarDados {
	
	public static void rastrearObjeto(String codRast) throws IOException{
		
    	/** LINK DA RASTREAMENTO */
        String url = "https://www.linkcorreios.com.br/" + codRast;
        /** CONECTANDO AO LINK COM COMPONENTE JSOUP */
        Document doc = Jsoup.connect(url).get();
        /** BUSCANDO ELEMENTO PELA CLASSE */
        Element cardResumo = doc.getElementsByClass("linha_status m-0").first();
        String statusRastreio = cardResumo.getElementsByTag("li").get(0).text();
        String dataRastreio = cardResumo.getElementsByTag("li").get(1).text();
        String localRastreio = cardResumo.getElementsByTag("li").get(2).text();
        System.out.println("\n---------------- OBJETO: " + codRast + " ----------------");
        System.out.println(statusRastreio);
        System.out.println(dataRastreio);
        System.out.println(localRastreio);
        System.out.println("-------------------------------------------------------\n");
        RastreamentocrApplication.main(null);
				
	}
	
	public static void buscarCEP(int codCEP) throws IOException{
		
    	/** LINK DA RASTREAMENTO */
        String url = "https://www.linkcorreios.com.br/ceps/buscar-cep?cep_consulta=" + codCEP;
        /** CONECTANDO AO LINK COM COMPONENTE JSOUP */
        Document doc = Jsoup.connect(url).get();
        /** BUSCANDO ELEMENTO PELA CLASSE */
        Element cardResumo = doc.getElementsByClass("singlepost").first();
        String dadosEndereco = cardResumo.getElementsByTag("div").get(0).text();
        System.out.println("\n---------------- CEP: " + codCEP + " ----------------");
        System.out.println(dadosEndereco);
        System.out.println("-------------------------------------------------------\n");
        RastreamentocrApplication.main(null);
				
	}
	
	public static void calcularPrazo(int cepOrigem, int cepDestino) throws IOException{
		
    	/** LINK DA RASTREAMENTO */
        String url = "https://www.linkcorreios.com.br/ceps/calculo-prazo-entrega-correios?cep_origem=" + cepOrigem + "&cep_destino=" + cepDestino;
        /** CONECTANDO AO LINK COM COMPONENTE JSOUP */
        Document doc = Jsoup.connect(url).get();
        /** BUSCANDO ELEMENTO PELA CLASSE */
        Element cardResumo = doc.getElementsByClass("linha_status").first();
        String prazoPac = cardResumo.getElementsByTag("li").get(0).text();
        String prazoSedex = cardResumo.getElementsByTag("li").get(1).text();
        System.out.println("\n---------------- " + cepOrigem + " >> " + cepDestino +  " ----------------");
        System.out.println(prazoPac);
        System.out.println(prazoSedex);
        System.out.println("------------------------------------------------------\n");
        RastreamentocrApplication.main(null);
				
	}

}
