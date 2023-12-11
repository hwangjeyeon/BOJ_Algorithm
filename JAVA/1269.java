import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - map과 String배열을 이용하여 문제를 해결하였다.
 * - 각 map의 사이즈를 ans에 넣어주고, 만약 String배열에 있는 원소의 값과 같은 map의 키 값이 있으면 ans를 감소시킨다
 * - 이렇게 완성된 ans를 출력한다.
 * - Set을 사용하는 방법도 있는데, 이후 다시 공부할때 활용해서 다시 풀어볼 계획이다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        String[] A = new String[a];
        String[] B = new String[b];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++){
            A[i] = st.nextToken();
            mapA.put(A[i],1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++){
            B[i] = st.nextToken();
            mapB.put(B[i], 1);
        }
        long ans = mapA.size();
        for(int i=0; i<B.length; i++){
            if(mapA.containsKey(B[i])){
                ans--;
            }
        }
        ans += mapB.size();
        for(int i=0; i<A.length; i++){
            if(mapB.containsKey(A[i])){
                ans--;
            }
        }

        bw.write(ans + "");
        br.close();
        bw.close();
    }

}
