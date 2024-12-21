import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 투포인터로 해결한 문제다.
 * 2. 먼저 이중포문으로 두 지점을 구한다. 그리고 그 두 지점의 합을 첫번쨰 눈사람으로 정한다
 * 3. 이어서 l과 r을 이용해서 투 포인터를 생성한다
 * 4. l < r동안 투포인터 작업을 진행하는데, 만약 도중에 i나 j와 같다면 l이나 r을 각각 증감한다
 * 5. 아닐경우, 두지점의 합산을 두번째 눈사람으로 한다
 * 6. 그리고 그 차이를 ans와 비교하여 더 작은 값으로 갱신한다
 * 7. 이어서 첫번째 눈사람이 더 크면 l을 늘리고 아닐 경우 r을 줄여주며, 0일 경우 0을 출력하고 종료한다
 * 8. 모든 탐색을 마친 후에 완성한 ans를 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int snowman1 = arr[i] + arr[j];
                int l = 0;
                int r = n-1;

                while(l < r){
                    if(l == i || l == j){
                        l++;
                        continue;
                    }
                    if(r == j || r == i){
                        r--;
                        continue;
                    }
                    int snowman2 = arr[l] + arr[r];
                    ans = Math.min(ans, Math.abs(snowman2 - snowman1));

                    if(snowman1 > snowman2){
                        l++;
                    }else if(snowman1 < snowman2){
                        r--;
                    }else{
                        bw.write("0");
                        bw.close();
                        return;
                    }

                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
