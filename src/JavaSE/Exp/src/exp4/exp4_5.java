package exp4;

public class exp4_5 {
    public static void main(String[] args) {

        exp4_5_Employee[] employees=new exp4_5_Employee[10];
        for (int i=0;i<employees.length;i++){
            if(i%2==0){
                employees[i]=new exp4_5_YearWorker();
            }else {
                employees[i]=new exp4_5_MonthWorker();
            }
        }
        exp4_5_Company company=new exp4_5_Company(employees);
        System.out.println("薪水总额:"+company.salariesPay());
    }

}
