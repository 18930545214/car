package util;

import java.util.Scanner;

//持有一个Scanner类对象
public class InputUtil {
    //静态的,只有一份
    private static Scanner input = new Scanner(System.in);

    //不封装静态方法:键盘输入,要通过类名.静态属性.方法
    //InputUtil.input.nextInt()

    //封装方法之后:类名.静态方法名()   InputUtil.nextInt()
    public static int nextInt(){
        return input.nextInt();//键盘输入一个整数
    }

    //input.next()
    public static String next(){
        return input.next();
    }

    //input.nextDouble()
    public static double nextDouble(){
        return input.nextDouble();
    }

    //input.nextLong()
    public static long nextLong(){
        return input.nextLong();
    }
}
