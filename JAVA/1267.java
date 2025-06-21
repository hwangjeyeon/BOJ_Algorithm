import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 주어진 조건에 맞는 수식을 세워서 더 큰 값을 출력하거나 같을 때 조건에 맞춰 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            a += arr[i]/30*10;
            a += arr[i] - arr[i]/30*30 >= 0 ? 10 : 0;

            b += arr[i]/60*15;
            b += arr[i] - arr[i]/60 * 60 >= 0 ? 15 : 0;
        }

        if(a > b){
            bw.write("M " +  b);
        }else if(a < b){
            bw.write("Y " + a);
        }else{
            bw.write("Y M " + a);
        }

        
        br.close();
        bw.close();
    }

}
