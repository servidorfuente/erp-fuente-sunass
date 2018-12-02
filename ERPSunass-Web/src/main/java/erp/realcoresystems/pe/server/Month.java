package erp.realcoresystems.pe.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Month {

	private Integer id;

	private String description;
	private List<Month> meses = new ArrayList<Month>();

	public Month() {

	}

	// ---- Getters And Setters ---

	public List<Month> getMeses() {
		return meses;
	}

	public void setMeses(List<Month> meses) {
		this.meses = meses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {

		return description;
	}

	public void fillMeses() {
		meses.clear();
		for (int i = 1; i <= 12; i++) {
			Month mes = new Month();
			mes.setId(i);

			switch (i) {
			case 1:
				mes.setDescription("Enero");
				meses.add(0, mes);
				break;
			case 2:
				mes.setDescription("Febrero");
				meses.add(1, mes);
				break;
			case 3:
				mes.setDescription("Marzo");
				meses.add(2, mes);
				break;
			case 4:
				mes.setDescription("Aril");
				meses.add(3, mes);
				break;
			case 5:
				mes.setDescription("Mayo");
				meses.add(4, mes);
				break;
			case 6:
				mes.setDescription("Junio");
				meses.add(5, mes);
				break;
			case 7:
				mes.setDescription("Julio");
				meses.add(6, mes);
				break;
			case 8:
				mes.setDescription("Agosto");
				meses.add(7, mes);
				break;
			case 9:
				mes.setDescription("Septiembre");
				meses.add(8, mes);
				break;
			case 10:
				mes.setDescription("Octubre");
				meses.add(9, mes);
				break;
			case 11:
				mes.setDescription("Noviembre");
				meses.add(10, mes);
				break;
			case 12:
				mes.setDescription("Diciembre");
				meses.add(11, mes);
				break;
			default:
				break;
			}

		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
