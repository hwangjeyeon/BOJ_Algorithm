import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 분기와 반복문으로 간단히 해결가능한 문제
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0){
                break;
            }
            if(a > b){
                bw.write("Yes\n");
            }else{
                bw.write("No\n");
            }

        }

        br.close();
        bw.close();
    }

}

