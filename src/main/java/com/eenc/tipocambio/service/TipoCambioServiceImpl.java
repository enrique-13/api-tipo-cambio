package com.eenc.tipocambio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eenc.tipocambio.dao.ITipoCambioDao;
import com.eenc.tipocambio.model.TipoCambio;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService {

	@Autowired
	private ITipoCambioDao tipoCambioDao;

	@Override
	public TipoCambioResponse calcularMonto(TipoCambioRequest request) {

		TipoCambioResponse cambioResponse = new TipoCambioResponse();

		TipoCambio monedaOrigen = tipoCambioDao.findByTipo(request.getTipoMonedaOrigen());
		TipoCambio monedaDestino = tipoCambioDao.findByTipo(request.getTipoMonedaDestino());
		double valorOrigen = monedaOrigen.getCambio();
		double precioDestino = monedaDestino.getCambio();
		double cantidadMonyOrigen = request.getCantidadMonedaOrigen();

		Double resumenOrrigen = (cantidadMonyOrigen / valorOrigen) * precioDestino;

		resumenOrrigen = (double) Math.round(resumenOrrigen * 100d) / 100;

		cambioResponse.setCantidadMonedaOrigen(cantidadMonyOrigen);
		cambioResponse.setTipoMonedaOrigen(monedaOrigen.getMoneda());
		cambioResponse.setTipoMonedaDestino(monedaDestino.getMoneda());
		cambioResponse.setMontoCambio(resumenOrrigen);
		cambioResponse.setTipoCambio(valorOrigen);

		return cambioResponse;
	}

}
