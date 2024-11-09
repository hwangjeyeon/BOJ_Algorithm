import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 백트래킹으로 풀면 코드 간결하게 풀 수 있긴 한데 10중 포문으로 풀어보고 싶어서 10중 포문으로 풀었다
 * 2. 3번째 포문부터는 이전 두개의 포문의 인덱스랑 같은지 비교하고 모두 같으면 continue한다.
 * 3. Stack을 이용해서 간편화 하려고 했는데 넣고 빼는 과정의 시간이 추가되어 오히려 더 오래걸린다. 따라서 사용하지 않고 if문으로 처리하였다
 * 4. 최종 포문에서 count 변수를 통해 개수를 세어주고 5개 이상 정답이면 정답 변수의 값을 늘린다
 * 5. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(5^10)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(i == j && j == k){
                        continue;
                    }
                    for (int l = 0; l < 5; l++) {
                        if(j == k && k == l){
                            continue;
                        }
                        for (int m = 0; m < 5; m++) {
                            if(k == l && l == m){
                                continue;
                            }
                            for (int n = 0; n < 5; n++) {
                                if(l == m && m == n){
                                    continue;
                                }
                                for (int o = 0; o < 5; o++) {
                                    if(m == n && n == o){
                                        continue;
                                    }
                                    for (int p = 0; p < 5; p++) {
                                        if(n == o && o == p){
                                            continue;
                                        }
                                        for (int q = 0; q < 5; q++) {
                                            if(o == p && p == q){
                                                continue;
                                            }
                                            for (int r = 0; r < 5; r++) {
                                                if(p == q && q == r){
                                                    continue;
                                                }
                                                int count = 0;

                                                if(i+1 == arr[0]){
                                                    count++;
                                                }
                                                if(j+1 == arr[1]){
                                                    count++;
                                                }
                                                if(k+1 == arr[2]){
                                                    count++;
                                                }
                                                if(l+1 == arr[3]){
                                                    count++;
                                                }
                                                if(m+1 == arr[4]){
                                                    count++;
                                                }
                                                if(n+1 == arr[5]){
                                                    count++;
                                                }
                                                if(o+1 == arr[6]){
                                                    count++;
                                                }
                                                if(p+1 == arr[7]){
                                                    count++;
                                                }
                                                if(q+1 == arr[8]){
                                                    count++;
                                                }
                                                if(r+1 == arr[9]){
                                                    count++;
                                                }

                                                if(count >= 5){
                                                    ans++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

