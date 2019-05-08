package chat;
import java.io.Serializable;

public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;
	String nombre;
	String mensaje;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Mensaje(String nombre, String mensaje) {
		super();
		this.nombre = nombre;
		this.mensaje = mensaje;
	}
	@Override
    public String toString() {
        return "Mensaje [nombre=" + nombre + ", mensaje=" + mensaje
                + "]";
    }

	public Mensaje() {}
}
