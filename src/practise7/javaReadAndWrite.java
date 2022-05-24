package practise7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.*;


class file_writer extends Thread {

    private String output_file_name;

    file_writer(String output_file_name) {
        this.output_file_name = output_file_name;
    }

    @Override
    public void run() {

        File file = new File("str.txt");
        try {
            Scanner scanner = new Scanner(file);

            PrintWriter pw = new PrintWriter(output_file_name);

            while (scanner.hasNext()) {
                String data = scanner.next();
                int age = scanner.nextInt();

                if (age > 18) {
                    pw.println("Name : " + data + " & age : " + age);

                }


            }
            scanner.close();
            pw.flush();
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class file_reader extends Thread {
    private String output_file_name;

    file_reader(String output_file_name) {
        this.output_file_name = output_file_name;
    }

    @Override
    public void run() {

        try {
            File readFile = new File(output_file_name);
            Scanner readOutput = new Scanner(readFile);

            while (readOutput.hasNext()) {
                String data2 = readOutput.nextLine();
                System.out.println(data2);
            }

            readOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}

class Sync implements Runnable {

    @Override
    public void run() {
        try {

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
            String output_file_name = "output_file_" + sdf.format(date) + ".txt";

            file_writer fw = new file_writer(output_file_name);
            file_reader fr = new file_reader(output_file_name);


            ExecutorService executor = Executors.newSingleThreadExecutor();

            synchronized (executor) {
                executor.execute(fw);
                executor.execute(fr);
                executor.shutdown();
            }

        } catch (Exception exp) {
            exp.printStackTrace();

        }




    }
}

public class javaReadAndWrite {

    public static void main(String[] args) {
        Thread t = new Thread(new Sync());
        t.start();



    }
}

