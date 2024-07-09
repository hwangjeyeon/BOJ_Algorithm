import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 회전초밥 관리 선택지: Node 클래스 만들어서 관리, 큐 활용, 배열 활용
 * 2. 쿠폰  -> boolean chk 활용해서 벨트에 있는지 확인. 없으면 count = 1; 있으면 0으로 초기화
 * 3. 가짓수는 입력만 받고 무시
 * 4. 연속해서 먹는 접시의 개수 -> 슬라이딩 윈도우 활용
 * 5. 1번 방식으로 배열을 선택했다. 클래스나 큐를 활용하면 조회가 쉽지 않을 것 같아, k만큼을 뒤에다가 더 붙이는 형식으로 배열을 만들었다
 *
 * 해결방법:
 * 1. 풀이과정 3번에서 가짓수를 무시했는데, 이걸 활용하여 슬라이딩 윈도우 하는 문제였다
 * 2. 가짓수 + 1 만큼의 배열을 만들어서 먹은 횟수를 저장하는 배열을 만들어두자
 * 3. max는 최댓값으로 출력할 정답이다. 쿠폰을 무조건 먹는다고 가정하고 1로 지정하자
 * 4. eat배열의 쿠폰 위치에 1을 더해주고, 일단 윈도우 크기만큼을 구해주자
 * 5. 0부터 k전까지 만약 해당 초밥 넘버의 eat 배열의 위치가 0이면 가짓수를 의미하는 max를 증가시키고 해당 위치의 eat 값도 증가시킨다
 * 6. 이어서 윈도우를 이동할 것이다 start는 다시 0이고, end는 k다
 * 7. 임시 값을 저장해둘 count에는 max를 저장하고 end부터 배열 크기만큼 순회한다
 * 8. 일단 start의 eat 값은 무조건 감소한다. 하지만 삭제된 초밥은 무조건 가짓수에서 빼지 않는다. 만약 해당 슬라이딩 윈도우에 같은 번호가 있다면 빼지 않는다
 * 9. 따라서 eat의 해당 위치가 0일때만 count--한다
 * 10. 이제 추가된 것을 처리하는데 해당 위치의 eat가 0일 경우 max++한다
 * 11. 그다음 eat의 해당 위치의 값을 증가시키고 max값과 비교해서 count와 max중 더 큰 값을 max에 넣는다
 * 12. 그다음 start++로 슬라이딩 윈도우의 앞 위치를 증가시킨다
 * 13. 완성된 max를 출력하면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(n/k)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(i < k-1){
                arr[n+i] = arr[i];
            }
        }
        int[] eat = new int[d+1];
        int max = 1;
        int count;
        eat[c]++;

        int start = 0;
        for (int i = start; i < k; i++) {
            if(eat[arr[i]] == 0){
                max++;
            }
            eat[arr[i]]++;
        }

        start = 0;
        int end = k;
        count = max;
        for (int i = end; i < arr.length; i++) {
            eat[arr[start]]--;
            if(eat[arr[start]] == 0){
                count--;
            }
            if(eat[arr[i]] == 0){
                count++;
            }
            eat[arr[i]]++;
            max = Math.max(max, count);
            start++;
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }

}

