package dev.paie.web.profilRemuneration;

public class ProfilRemunerationResponseDto {

	private Integer id;
	private String code;

	public ProfilRemunerationResponseDto() {

	}

	public ProfilRemunerationResponseDto(Integer id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
