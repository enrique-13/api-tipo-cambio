package com.eenc.tipocambio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eenc.tipocambio.dao.ITipoCambioDao;
import com.eenc.tipocambio.model.TipoCambio;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService {

	@Autowired
	private ITipoCambioDao tipoCambioDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoCambio> findAll() {
		return (List<TipoCambio>) tipoCambioDao.findAll();
	}

	@Override
	public void save(TipoCambio tipoCambio) {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoCambio findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
