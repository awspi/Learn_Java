package exp4;

public  class exp4_6_Student {
      String name;
      int s1,s2,s3;
    exp4_6_Student(String name,int s1,int s2,int s3){
        this.name = name;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    public String getName(){
        return name;
    }
    public int getTotal(){
        return s1+s2+s3;
    }
}
