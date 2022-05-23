package practise2;

import java.util.Scanner;

public class javaEOF {

    public static void main(String[] args) {

        try {
            Scanner input_file = new Scanner(System.in);


            String reader = "";
            int i = 0;

            while ((input_file.hasNext())) {
                reader = input_file.nextLine();
                i++;

                System.out.println(i + " " + reader);
                if (reader.contains(".")) {
                    break;
                }

            }
            input_file.close();
            if (i == 0) {
                System.out.println("No Data Found !!!");
            }

        } catch (Exception io) {
            io.printStackTrace();
        }
    }
}
