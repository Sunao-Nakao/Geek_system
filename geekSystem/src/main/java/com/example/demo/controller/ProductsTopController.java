package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.ProductsTopForm;


/**トップコントローラー**/
@Controller
public class ProductsTopController {
	
	@GetMapping(UrlConst.PRODUCTS_TOP)
	public String view(Model model) {
		model.addAttribute("productsTopForm", new ProductsTopForm());
	return "products-top";
	}
//	@GetMapping(UrlConst.PRODUCTS_TOP)
//	public String view(Model model, ProductsTopForm form) {
//		
//		model.addAttribute(KEY_PRODUCT_KINDS,Products.valese());
//		
//		return "products-top";
//	}

}