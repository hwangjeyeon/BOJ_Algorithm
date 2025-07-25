import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("NFC West       W   L  T\n");

        bw.write("-----------------------\n");

        bw.write("Seattle        13  3  0\n");

        bw.write("San Francisco  12  4  0\n");

        bw.write("Arizona        10  6  0\n");

        bw.write("St. Louis      7   9  0\n");

        bw.write("\n");

        bw.write("NFC North      W   L  T\n");

        bw.write("-----------------------\n");

        bw.write("Green Bay      8   7  1\n");

        bw.write("Chicago        8   8  0\n");

        bw.write("Detroit        7   9  0\n");

        bw.write("Minnesota      5  10  1\n");


        br.close();

        bw.close();

    }

}

