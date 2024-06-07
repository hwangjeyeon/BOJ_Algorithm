import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 춥발위치랑 숫자가 같은 도착 위치를 이중 포문으로 찾아서 교환을해주는 문제이다.
 * 2. 사다리 줄을 긋는 다는 것을 두 수의 위치를 바꾼다고 생각하면 된다
 * 3. 선택 정렬과 버블 정렬을 합쳐서 풀었다. 관련해서 다시 한번 복습이 필요해보인다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = 0;
            for (int j = 1; j < n+1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            int index = 1;
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    if(j == arr[k]){
                        index = k;
                    }
                }
                while(arr[j] != j){
                    int tmp = arr[index-1];
                    arr[index-1] = arr[index];
                    arr[index] = tmp;
                    index--;
                    ans++;
                }
            }
            bw.write(ans+"\n");

        }

        br.close();
        bw.close();
    }



}

