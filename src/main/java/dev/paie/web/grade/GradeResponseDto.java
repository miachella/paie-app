package dev.paie.web.grade;

public class GradeResponseDto {

	private Integer id;
	private String code;

	public GradeResponseDto() {

	}

	public GradeResponseDto(Integer id, String code) {
		this.setId(id);
		this.setCode(code);
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
