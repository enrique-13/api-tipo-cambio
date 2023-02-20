package com.eenc.tipocambio.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCambioResponse {

	private Double monto;
	private Double montoCambio;
	private String monedaOrigen;
	private String monedaDestino;
	private String tipoCambio;

}
