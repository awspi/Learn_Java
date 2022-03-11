package JavaSE.part2.Other;
//包装类实际上就行将我们的基本数据类型，封装成一个类（运用了封装的思想）

//byte -> Byte
//boolean -> Boolean
//short -> Short
//char -> Character
//int -> Integer
//long -> Long
//float -> Float
//double -> Double
public class Wrapper {
    public static void main(String[] args) {
//        操作的就是Integer对象而不是一个int基本类型了
        Integer i = 1;   //包装类型可以直接接收对应类型的数据，并变为一个对象！
        System.out.println(i + i);    //包装类型可以直接被当做一个基本类型进行操作！

        //自动装箱
        Integer ii = 1;    //其实这里只是简写了而已 =Integer.valueOf(1);调用valueOf来生成一个Integer对象！

        Integer iii = Integer.valueOf(1);
        int aa = iii;    //简写,编译后实际的代码int aa = iii.intValue();

        Integer i1 = 28914;
        Integer i2 = 28914;
        System.out.println(i1 == i2);   //实际上判断是两个对象是否为同一个对象（内存地址是否相同）
        System.out.println(i1.equals(i2));   //这个才是真正的值判断！

        //IntegerCache带来的影响
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println(i3 == i4);

        Integer i5 = 28914;
        Integer i6 = 28914;

        //自动拆箱
        System.out.println(i5+1 == i6+1);//对象变为Int类型 i5.intValue()

        //封装了一些工具方法
        System.out.println(i1.compareTo(i2));
    }




    /*
    public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)   //注意，Java为了优化，有一个缓存机制，如果是在-128~127之间的数，会直接使用已经缓存好的对象，而不是再去创建新的！（面试常考）
       return IntegerCache.cache[i + (-IntegerCache.low)];
  	return new Integer(i);   //返回一个新创建好的对象
}
    * */
}
