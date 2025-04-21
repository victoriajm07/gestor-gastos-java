import java.util.Date;

/**
 * Clase que aplicará el Data Mapper
 */
public class Spend {

	private Integer idGastoSpend;
	
	private Integer montoSpend;
	
	private Date fechaSpend;
	
	// falta categoria
	
	private String tipoSpend;
	
	private Integer idUsuarioSpend;
	
	private User user;

	public Integer getIdGastoSpend() {
		return idGastoSpend;
	}

	public void setIdGastoSpend(Integer idGastoSpend) {
		this.idGastoSpend = idGastoSpend;
	}

	public Integer getMontoSpend() {
		return montoSpend;
	}

	public void setMontoSpend(Integer montoSpend) {
		this.montoSpend = montoSpend;
	}

	public Date getFechaSpend() {
		return fechaSpend;
	}

	public void setFechaSpend(Date fechaSpend) {
		this.fechaSpend = fechaSpend;
	}

	public String getTipoSpend() {
		return tipoSpend;
	}

	public void setTipoSpend(String tipoSpend) {
		this.tipoSpend = tipoSpend;
	}

	public Integer getIdUsuarioSpend() {
		return idUsuarioSpend;
	}

	public void setIdUsuarioSpend(Integer idUsuarioSpend) {
		this.idUsuarioSpend = idUsuarioSpend;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
