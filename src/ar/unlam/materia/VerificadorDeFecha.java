package ar.unlam.materia;

import java.time.LocalDate;

public class VerificadorDeFecha { 
	 public static boolean fechaEnRango(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaVerificar) {
		 //Esto te permite verificar si la fecha a verificar si es antes o despues de las fechas de inicio o fin
		 //		fecha a verificar  <    fecha de inicio		   fecha A verificar > fecha fin
	        return !(fechaVerificar.isBefore(fechaInicio) || fechaVerificar.isAfter(fechaFin));
	    }
}
