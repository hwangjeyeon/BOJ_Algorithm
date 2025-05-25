import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. set으로 중복 제거하고, 게임 유형에 따라서 count를 초기화해가며 ans를 증가시키면된다
 * 2. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        Set<String> set = new HashSet<>();
        int count = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            switch (type){
                case "Y":
                    if(!set.contains(name)){
                        count++;
                    }
                    if(count == 2){
                        ans++;
                        count = 1;
                    }
                    break;
                case "F":
                    if(!set.contains(name)){
                        count++;
                    }
                    if(count == 3){
                        ans++;
                        count = 1;
                    }
                    break;
                case "O":
                    if(!set.contains(name)){
                        count++;
                    }
                    if(count == 4){
                        ans++;
                        count = 1;
                    }
                    break;
            }
            set.add(name);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
