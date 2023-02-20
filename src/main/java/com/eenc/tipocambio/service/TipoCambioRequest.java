package com.eenc.tipocambio.service;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCambioRequest {
	
	@JsonProperty("monto")
	private Double cantidadMonedaOrigen;
	
	@JsonProperty("monedaOrigen")
	private String tipoMonedaOrigen;
	
	@JsonProperty("monedaDestino")
	private String tipoMonedaDestino;

}
