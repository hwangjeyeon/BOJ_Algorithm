import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 그냥 구현문제다. 이중포문을 돌면서 현재 인원이 타겟이면 바로 증가, 아니면 맞췄는지 확인하고 맞췄으면 증가해준다
 * 2. 만약 틀린 경우 틀린 개수를 세어준다
 * 3. 그리고 현재 타겟에게 틀린 개수만큼 더해준다
 * 4. 이후 각 인원이 얻은 점수를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int ta = target[i];
            st = new StringTokenizer(br.readLine());
            int wrong = 0;
            for (int j = 1; j < n+1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(j == ta){
                    arr[j]++;
                }else if(num == ta){
                    arr[j]++;
                }else{
                    wrong++;
                }
            }
            arr[ta] += wrong;
        }

        for (int i = 1; i < n+1; i++) {
            bw.write(arr[i]+"\n");
        }

        br.close();
        bw.close();
    }

}
