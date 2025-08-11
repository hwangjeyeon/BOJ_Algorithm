import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 배열 두개써서 비교후 정답을 넣어주고 이후 출력하면 정답이 된다
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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 300){
                ans[i] = 1;
            }else if(arr[i] >= 275){
                ans[i] = 2;
            }else if(arr[i] >= 250){
                ans[i] = 3;
            }else{
                ans[i] = 4;
            }
        }
        
        for(int i=0; i<n; i++){
            bw.write(ans[i] + " ");
        }
        
        br.close();
        bw.close();

    }

}

