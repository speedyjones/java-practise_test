package practise1;

import java.util.HashMap;
import java.util.Map;

class Abc{
    static Abc obj = new Abc();
    private Abc(){}

    public static Abc getInstance(){
        return obj;
    }


//        public int findSum(int n){
//
//        return n*(n+1)/2;
//    }

//    public int findSum(int n){
//        int sum = 0;
//        int x = 1;
//        while(x<=n) {
//            sum = sum + n;
//            x++;
//        }
//        return sum;
//    }

    public static String findDuplicate(String n){

        Map<String, Integer> dupWords = new HashMap<>();
        String[] spiltString = n.split(" ");

        for(String str : spiltString){
            Integer i = dupWords.get(str);
            if(i == null)
            {
                dupWords.put(str,1);
            }
            else
            {
                dupWords.put(str,i+1);
            }


        }
        System.out.println("The word  "+dupWords);

        return n;


    }

}


public class Time_complexity {

    public static void main(String[] args) {

//        practise1.Time_complexity tc = new practise1.Time_complexity();
            Abc obj1 = Abc.getInstance();


         double mills = System.currentTimeMillis();

        obj1.findDuplicate("Tennis is very popular sports , it is famous sports in worldwide");
        System.out.printf("Time Taken :"+(System.currentTimeMillis() - mills));

    }
}
