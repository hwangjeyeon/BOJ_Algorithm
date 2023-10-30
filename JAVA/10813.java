import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - Collections의 Swap을 사용하기 위해 ArrayList를 사용하였다. 또한 foreach문으로도 출력해보았다.
 * - 자바의 다양한 라이브러리와 친해지기 위해 앞으로 좀 다양한 라이브러리를 사용해볼 계획이다.
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
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> basket = new ArrayList<Integer>();
        for(int i=0; i<n+1; i++){
            basket.add(i);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Collections.swap(basket,k,l);
        }

        for (int i: basket) {
            if(i != 0){
                bw.write(i + " ");
            }

        }

        br.close();
        bw.close();
    }

}
