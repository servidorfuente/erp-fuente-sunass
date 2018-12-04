package erp.realcoresystems.pe.model.util.color;

public class Color {

	private int id;
	private String colorDescripcion;

	public Color() {
		
	}

	public Color(int id, String colorDescripcion) {
		this.id = id;
		this.colorDescripcion = colorDescripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColorDescripcion() {
		return colorDescripcion;
	}

	public void setColorDescripcion(String colorDescripcion) {
		this.colorDescripcion = colorDescripcion;
	}

	@Override
	public String toString() {
		return colorDescripcion;
	}

}
