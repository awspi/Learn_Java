package JavaSE.exp.src.exp7;


    interface mouth{
        void sing();
    }
    abstract class human{
        public String DNA="hello";
        String name;
        human(String name){
            this.name=name;
        }
        public abstract void work();
        abstract void sleep();
    }
     class peo implements mouth{
        public void sing() {
            System.out.println("哈哈");
        }
    }
    class sb extends human implements mouth{
        sb(String name){
            super(name);
            super.DNA="NMSL";
        }
        public void work(){
            System.out.println("996");
        }
        void sleep(){
            System.out.println("10hrs");
        }
        public void sing(){
            System.out.println("听我说👂谢谢你");
        }



    public static void main(String[] args) {
    mouth m =new peo();
    m.sing();
    human h=new sb("ss");
    System.out.println(h.DNA);
    h.sleep();
    h.work();

    }
}
