import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * Arrays.copyOfRange, Arrays.stream()을 사용해본 문제, 해당 Arrays 라이브러리와 stream에 대한 공부를 앞으로 더 할 예정
 * stream으로 불필요한 for문을 줄일 수 있어서 앞으로 적극 활용해야겠다
 * 시간복잡도: O(n^2)
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

        int[] basket = new int[n+1];
        for(int i=1; i<=n; i++){
            basket[i] = i;
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] tmp = Arrays.copyOfRange(basket, k, l+1);


            for(int j=0; j<l-k+1; j++){
                basket[k+j] = tmp[l-k-j];
            }

        }

        Arrays.stream(basket)
                .filter(e -> e != 0)
                .forEach(e -> {
            try {
                bw.write(e + " ");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        br.close();
        bw.close();
    }

}
