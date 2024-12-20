import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 완탐으로 해결할 수 없기 떄문에 다른 방법을 모색해야한다
 * 2. 모든 개발자를 확인해야하기 때문에, 투포인터를 이용해서 범위를 좁혀나가면서 확인하는 방법을 선택했다
 * 3. 정렬을 하고 확인해야하는 줄 알았으나, 그럴 경우 반례가 발생해서 정렬은 하면 안도니다
 * 4. 그렇다면 다른 방법을 선택해야하는데 이번에는 주어진 식을 구한다음 그냥 ans와 비교해서 더 큰 값으로 갱신하는 방법이다.
 * 5. 이것까지는 정답인데 문제는 투포인터의 범위를 줄이는 기준을 정해야한다
 * 6. 선택한 기준을 각 포인터 위치의 값을 비교해서 오른쪽이 더 크면 왼쪽을 늘리고 반대는 오른쪽을 줄이는 것을 선택했다
 * 7. 완성한 ans를 출력하면 정답이 된다.
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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = n-1;
        int ans = 0;
        while(l <= r){
            ans = Math.max((r-l-1) * Math.min(arr[l], arr[r]), ans);
            if(arr[l] < arr[r]){
                l++;
            }else{
                r--;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
