import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 너무 쉬운 문제라 생략
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int check = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            int item = Integer.parseInt(st.nextToken());
            int item_count = Integer.parseInt(st.nextToken());
            check += item*item_count;
            if(i < count-1){
                st = new StringTokenizer(br.readLine());
            }

        }

        if(check == total){
            bw.write("Yes");
        }else{
            bw.write("No");
        }

        br.close();
        bw.close();
    }

}
