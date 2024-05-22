

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 각 수업별로 오름차순 정렬을 진행
 * 2. 참여 인원 - 수강정원이 0보다 작으면, 해당 수업 배열의 필요 마일리지 1설정
 * 3. 0보다 크거나 같으면  그 차이만큼의 인덱스의 값을 필요 마일리지로 설정
 * 4. 필요 마일리지 배열을 오름차순 정렬해서 전체 마일리지에서 빼가면서 ans를 센다
 * 5. 만약 전체 마일리지 - 필요 마일리지면 종료하고 ans를 출력한다
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(n*p)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            List<Integer> lists = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) {
                lists.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(lists);
            if(p-l < 0){
                count[i] = 1;
            }else{
                count[i] = lists.get(p-l);
            }

        }
        Arrays.sort(count);
        for (int i = 0; i < n; i++) {
            if(m - count[i] >= 0){
                m-= count[i];
                ans++;
            }
        }
        bw.write(ans+"");

        

        br.close();
        bw.close();
    }
}

