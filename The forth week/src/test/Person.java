package test;

@Entity ("People")

public class Person {
	@ID
	@Column(nullable=false)
	private Integer getId(){
		Integer id = null;
		return id;
	}
	public void setId(Integer id) {
	}
	public String getName() {
		return getName();
	}
	public void setName(String name) {
	}
}
