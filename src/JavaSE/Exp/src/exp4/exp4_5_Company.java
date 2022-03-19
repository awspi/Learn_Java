package exp4;

public class exp4_5_Company {
    public exp4_5_Employee[] employees;
    private double salaries;
    exp4_5_Company(exp4_5_Employee[] employees){
        this.employees=employees;
    }
    public double salariesPay(){
        salaries=0;
        for (exp4_5_Employee employee:employees){
            salaries+=employee.earnings();
        }
        return salaries;
    }
}
