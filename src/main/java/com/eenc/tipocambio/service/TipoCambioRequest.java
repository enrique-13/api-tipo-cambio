package com.eenc.tipocambio.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCambioRequest {

	private Double monto;
	private Long monedaOrigen;
	private Long monedaDestino;

}
