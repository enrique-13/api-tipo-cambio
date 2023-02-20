import { Component } from '@angular/core';
import { TipoCambio } from './cambio/tipoCambio';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  title = 'tipo-cambio-app';

  tiposCambio: TipoCambio[] = [
    {id:1, moneda:'Dólar Estadounidense', tipo:'USD', cambio:'1.00'},
    {id:2, moneda:'Sol Peruano', tipo:'PEN', cambio:'3.82'},
    {id:3, moneda:'Bolívar Venezolano', tipo:'VES', cambio:'24.36'},
    {id:4, moneda:'Peso Argentino', tipo:'ARS', cambio:'192.62'},
    {id:5, moneda:'Peso Chileno', tipo:'CLP', cambio:'793.15'},
    {id:6, moneda:'Peso Colombiano', tipo:'COP', cambio:'4883.09'},
    {id:7, moneda:'Peso Mexicano', tipo:'MXN', cambio:'18.37'},
    {id:8, moneda:'Peso Uruguayo', tipo:'UYU', cambio:'39.01'},
    {id:9, moneda:'Real Brasileño', tipo:'BRL', cambio:'5.17'},
    {id:10, moneda:'Yen Japonés', tipo:'JPY', cambio:'134.12'}
  ];
}
