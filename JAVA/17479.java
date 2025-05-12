import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Map안에 Map보다는 서로를 연결할 수 있는 map을 두개 사용하자
 * 2. 분기를 잘 주고 문제를 잘 해석해서 풀면 해결할 수 있다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    static final String OKAY = "Okay";
    static final String NO = "No";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> menu = new HashMap<>();

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map.put(name, Integer.parseInt(st.nextToken()));
            menu.put(name,"normal");
        }


        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map.put(name, Integer.parseInt(st.nextToken()));
            menu.put(name, "special");
        }

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map.put(name, 0);
            menu.put(name, "service");
        }

        int n = Integer.parseInt(br.readLine());
        long normalSum = 0;
        long specialSum = 0;
        int order = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String menuName = menu.get(s);
            if(menuName.equals("normal")) {
                normalSum += map.get(s);
            }else if(menuName.equals("special")) {
                specialSum += map.get(s);
            }else{
                order++;
            }

        }
        if((normalSum < 20_000 && specialSum > 0) || ((normalSum + specialSum) < 50_000 && order > 0) || order > 1){
            bw.write(NO);
        }else{
            bw.write(OKAY);
        }

        br.close();
        bw.close();
    }
}
