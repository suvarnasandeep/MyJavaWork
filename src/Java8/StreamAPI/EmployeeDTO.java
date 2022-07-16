package StreamAPI;

public class EmployeeDTO {
    private String empName;
    private String dept;

    public EmployeeDTO(String name, String dept) {
        this.empName = name;
        this.dept = dept;

    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
