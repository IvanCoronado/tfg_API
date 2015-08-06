package es.icm.dto.out;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
		"nombre", "fecha_nacimiento", "edad"
})
public class PersonaDTO {
	// Para info sobre las anotaciones JACKSON

	@JsonProperty("fecha_nacimiento")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Calendar fechaNacimiento;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("edad")
	private int edad;

	public PersonaDTO(Calendar fechaNacimiento, String nombre, int edad) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
