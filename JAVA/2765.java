import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진대로 문제를 풀면 되는 문제다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double r = Double.parseDouble(st.nextToken());
            int rpm = Integer.parseInt(st.nextToken());
            double time = Double.parseDouble(st.nextToken()) / 3600;



            if (rpm == 0) {
                break;
            }
            double distance = ((((r * 3.1415927) * rpm) / 12) / 5280);
            double mph = (distance/time);

            bw.write("Trip #" + count++ + ": " + String.format("%.2f",distance ) + " " + String.format("%.2f", mph) +"\n");

        }

        br.close();
        bw.close();
    }
}

