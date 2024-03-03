import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] name = st.nextToken().split("_");
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < name.length; j++) {
                if(name[j].equals(s)){
                    ans += count;
                    break;
                }
            }
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}

