import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 
 * 해결방법:
 * 1. 아이디어 자체는 간단하다. 그리디하게 풀면 되는데 가장 빨리 등교하는 사람에서 가장 빨리 하교하는 사람을 빼주면 된다.
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int start = 0;
        int end = 100001;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(s > start){
                start = s;
            }

            if(e < end){
                end = e;
            }
        }

        int ans = start - end;

        if(ans < 0){
            bw.write("0");
        }else{
            bw.write(ans+"");
        }


        br.close();
        bw.close();
    }
}

