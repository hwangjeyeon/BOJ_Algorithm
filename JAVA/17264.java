import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 알아낸 사람의 이름을 key로 하고 정보를 value로해서 map에 넣는다
 * 2. map에서 탐색한 결과가 null이거나 L이면 l만큼 빼고 W면 w만큼 더한다
 * 3. 탐색 도중 0보다 작아지는 경우가 있으면 0으로 초기화, g보다 크거나 같아지만 break한다
 * 4. 완성한 ans가 g보다 크거나 같은 경우와 아닌 경우에 따라 맞춰서 출력하면 정답이다.
 *
 *
 * 문제 해결:
 * 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String result = st.nextToken();
            map.put(name, result);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if(map.get(name) == null){
                ans -= l;
            }else if(map.get(name).equals("L")){
                ans -= l;
            }else if(map.get(name).equals("W")){
                ans += w;
            }

            if(ans < 0){
                ans = 0;
            }

            if(ans >= g){
                break;
            }
        }


        if(ans >= g){
            bw.write("I AM NOT IRONMAN!!");
        }else{
            bw.write("I AM IRONMAN!!");
        }

        br.close();
        bw.close();
    }


}
