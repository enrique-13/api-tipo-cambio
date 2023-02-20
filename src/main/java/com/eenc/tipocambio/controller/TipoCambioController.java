package com.eenc.tipocambio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eenc.tipocambio.dao.ITipoCambioDao;
import com.eenc.tipocambio.model.TipoCambio;

@RestController
@RequestMapping("/api")
public class TipoCambioController {

	@Autowired
	private ITipoCambioDao tipoCambioDao;

//	@Autowired
//	private ITipoCambioService tipoCambioService;

	@GetMapping("/listar")
	public ResponseEntity<List<TipoCambio>> listarTipoCambio(Model model) {
		List<TipoCambio> lista = null;
		try {
			lista = (List<TipoCambio>) tipoCambioDao.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<TipoCambio>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<TipoCambio>>(lista, HttpStatus.OK);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<TipoCambio> listarIdTipoCambio(@PathVariable(value = "id") Long id) {
		Optional<TipoCambio> tipoCambioData = tipoCambioDao.findById(id);
		if (tipoCambioData.isPresent()) {
			return new ResponseEntity<>(tipoCambioData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<TipoCambio> crearTipoCambio(@RequestBody TipoCambio tipoCambio) {
		try {
			TipoCambio addTipoCambio = tipoCambioDao.save(tipoCambio);
			return new ResponseEntity<>(addTipoCambio, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<TipoCambio> actualizarTipoCambio(@PathVariable(value = "id") Long id, @RequestBody TipoCambio tipoCambio) {
		Optional<TipoCambio> tipoCambioData = tipoCambioDao.findById(id);
		if (tipoCambioData.isPresent()) {
			TipoCambio tCambio = tipoCambioData.get();
			tCambio.setMoneda(tipoCambio.getMoneda());
			tCambio.setTipo(tipoCambio.getTipo());
			tCambio.setCambio(tipoCambio.getCambio());
			return new ResponseEntity<>(tipoCambioDao.save(tCambio), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	  @DeleteMapping("/eliminar/{id}")
	  public ResponseEntity<HttpStatus> eliminarTipoCambio(@PathVariable("id") long id) {
	    try {
	    	tipoCambioDao.deleteById(id);
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
