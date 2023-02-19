package com.eenc.tipocambio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eenc.tipocambio.model.TipoCambio;
import com.eenc.tipocambio.service.ITipoCambioService;

@RestController
@RequestMapping("/api")
public class TipoCambioController {

	@Autowired
	private ITipoCambioService tipoCambioService;

	@GetMapping("/listar")
	public ResponseEntity<List<TipoCambio>> getAll(Model model) {
		List<TipoCambio> lista = null;
		try {
			lista = tipoCambioService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<TipoCambio>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<TipoCambio>>(lista, HttpStatus.OK);
	}

	
	
}
