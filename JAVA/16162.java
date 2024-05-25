import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. count 변수를 하나 두고 (a+d*count)와 arr[i]가 같은지 비교한다
 * 2. 같다면 count++를 해주고 순회를 진행한다
 * 3. 최종 count의 개수가 count단 고음을 만족시키는 수이므로 출력하면 정답이 된다.
 *
 * 해결방법:
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
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == (a+ d*count)){
                count++;
            }
        }
        bw.write(count+"");

        
        br.close();
        bw.close();
    }



}

