package ar.unlam.materia;

import java.time.LocalDate;

public class VerificadorDeFecha { 
	 public static boolean fechaEnRango(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaVerificar) {
	        return !(fechaVerificar.isBefore(fechaInicio) || fechaVerificar.isAfter(fechaFin));
	    }
}
