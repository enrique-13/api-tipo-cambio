package com.eenc.tipocambio.service;

import java.util.List;

import com.eenc.tipocambio.model.TipoCambio;

public interface ITipoCambioService {

	public List<TipoCambio> findAll();

	public void save(TipoCambio tipoCambio);

	public TipoCambio findOne(Long id);

	public void delete(Long id);

}
