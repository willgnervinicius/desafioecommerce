package com.willgner.desafioEcommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.willgner.desafioEcommerce.model.Search;
@Controller
public class ProductsController {
	
    @RequestMapping("/products/list")
	public String list()
	{
    	Search search = new Search();
    	search.getPageLinks("https://www.magazineluiza.com.br/", 0);
    	return "List";
	}
}
