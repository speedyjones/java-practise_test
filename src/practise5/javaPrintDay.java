package practise5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class javaPrintDay {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String firstMultipleInput[] = bufferedReader.readLine().replaceAll("\"\\\\s+$\", \"\"", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);
        System.out.println(res);
//        bufferedWriter.write(res);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();

    }
}

class Result {
    public static String findDay(int month, int day, int year) {

            String output = "";
        try {
            String months = String.format("%02d", month);
            String days = String.format("%02d", day);
            String input_date = months + days + year;

            SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
//        String  longdate = sdf.format(input_date);
            Date date = sdf.parse(input_date);

            Format format = new SimpleDateFormat("EEEE");

             output= format.format(date);


        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return output.toUpperCase();
    }
}

