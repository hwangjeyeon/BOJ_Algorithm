import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 그냥 입력 값에 따른 if문 분류만 해주면 되는 쉬운 문제
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int ans = 1;
        while(st.hasMoreTokens()){
            if(count < 2){
                ans = 1;
                ans -= Integer.parseInt(st.nextToken());
                bw.write(ans + " ");
                count++;
            }else if(count > 4){
                ans = 8;
                ans -= Integer.parseInt(st.nextToken());
                bw.write(ans + "");
            }else{
                ans = 2;
                ans -= Integer.parseInt(st.nextToken());
                bw.write(ans + " ");
                count++;
            }

        }



        br.close();
        bw.close();
    }

}
