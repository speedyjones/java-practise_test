package practise3;

import java.util.Scanner;

public class javaStaticTest {
    static int B = 0;
    static int H = 0;
    static boolean flag = false;

    static{
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();


        if(B<=0 || H<=0){
            System.out.print("java.lang.Exception: Breadth and height must be positive");

        }
        else {
            flag = true;

        }
        sc.close();
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }


}
