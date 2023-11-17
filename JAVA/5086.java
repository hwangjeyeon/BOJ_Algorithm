import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * b % a == 0이면 약수, a % b == 0이면 배수다
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {

//    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a + b == 0){
                break;
            }

            if(b % a == 0){
                bw.write("factor\n");
            }else if(a%b == 0){
                bw.write("multiple\n");
            }else{
                bw.write("neither\n");
            }



        }


        br.close();
        bw.close();
    }

}
