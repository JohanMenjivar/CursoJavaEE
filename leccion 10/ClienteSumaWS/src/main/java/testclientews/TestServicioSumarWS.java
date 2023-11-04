
package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestServicioSumarWS {
    public static void main(String[] args) {
        ServicioSumarWS serviciosumar= new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando servicio sumar ws");
        System.out.println(serviciosumar.sumar(6, 3));
        System.out.println("Fin Servicio sumar");
    }
}
