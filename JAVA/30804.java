import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 
 *
 * - 문제 해결:
 * 1. 앞뒤로 빼야하니까 투포인터를 이용하자.
 * 2. left와 ans를 0으로 초기화하자
 * 3. right를 포문의 변수로 두고 n만큼 순회한다
 * 4. map에 right 위치에 해당하는 값을 넣어준다
 * 5. 이어서 map의 크기가 2보다 큰동안 다음을 반복한다
 * 6. arr의 left 값을 map에 넣어주는데, 개수를 줄여서 넣어준다
 * 7. 만약 값이 0이되면 remove한다. 그리고 left를 증가시킨다
 * 8. 이어서 while문이 끝나면 ans에 right-left + 1을 비교하여 더 큰값을 넣어준다
 * 9. ans를 출력하면 정답이 된다.
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
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        int ans = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > 2){
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

