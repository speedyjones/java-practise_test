package practise8;

import java.util.Scanner;

public class javaStringProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next().trim();
        String B=sc.next();

        int lengthA = A.length();
        int lengthB = B.length();


        System.out.println(lengthA+lengthB);

        if(A.compareTo(B)>0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        String match = A.substring(0,1).toUpperCase()+A.substring(1)
                +" "+B.substring(0,1).toUpperCase()+B.substring(1);
        System.out.println(match);
    }
}
