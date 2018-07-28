package _01.setter.injection.model;

public class Department {
	private String deptName;
	private String location;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Department [deptname=" + deptName + ", location=" + location + "]";
	}
	
}
