package com.willgner.desafioEcommerce.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Search {
	private static final int MAX_DEPTH = 50;
    private HashSet<String> links;
    
    public Search() {
        links = new HashSet<>();  
    }

    public void getPageLinks(String URL, int depth) {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            try {
                
            	//Conecta ao site
                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("a[href]");

                //Busca somente as urls que contenha Smartphones e Celular
                for (Element page : linksOnPage) {
                	if(page.text().matches("^.*?(Celular|celular| smartphones | SMARTPHONES).*$"))
                	{
                		links.add(URL);
                		depth++;
                		getPageLinks(page.attr("abs:href"), depth);
                		Elements scriptElements = document.getElementsByTag("script");
                		for (Element element :scriptElements ){                
                	        for(DataNode node : element.dataNodes()) {
                	        	
                	        }
                		}
                	                
                	}
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }
}
