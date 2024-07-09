import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. n개의 얼음 양동이 -> 배열로 관리
 * 2. 얼음양동이는 xi 좌표와 gi 얼음의 개수를 가진다 -> 클래스로 관리
 * 3. 자리 잡았을 때 좌우로 k만큼 떨어진 곳 양동이 가져올 수 있음 -> 현재 위치에서 +k, -k 했을 때 얼음양동이 xi 좌표 조사해서 포함하고 더하기
 * 4. 최적의 자리를 잡아서 얼음의 합이 최대가 되도록 하는 것이 목표 -> 자리를 옮겨가며, 얼음의 합이 최대가 되는 구간을 찾고 출력하기
 * 5. 모든 얼음 양동이의 위치는 다르다 -> 위치가 중복되는 경우는 없다.
 * 6. 주어진 범위를 봤을 때, 2*k가 x좌표의 범위를 벗어날 수 있다. 이럴 때는 모든 얼음을 담으면 된다.
 * 7. 그 외의 경우부터는 이제 자리를 옮겨가면서 최댓값을 확인해야한다.
 * 8. 시간복잡도를 위해 슬라이딩 윈도우를 활용하여 해결할 것이다.
 * 9. 먼저 배열을 x좌표 기준으로 오름차순 정렬한다
 * 10. 오차없이 0부터 시작해서 얼음을 담을 수 있는 최대 범위는 2*k의 범위이다. 따라서 0부터 2*k까지의 범위를 먼저 담아둔다.
 * 11. 그 다음부터는 이제 0지점을 체크해서 만약 그 좌표에 얼음이 있다면 빼준다. 그리고 2*k+1의 위치에도 똑같이 체크해서 있으면 더해준다
 * 12. 이 방식을 2*k가 1000000보다 작을 때까지 반복해서 최댓값을 찾는다.
 * 13. 조금 더 최적화하는 방법을 생각해보자. bucket을 기준으로 탐색해서 얼음 값을 더해줘야 하니까, 시작 지점을 찾기 위해 bucket의 처음값을 찾는다.
 * 14. 그리고 그 지점과 0좌표까지의 차이를 구하고, 그만큼 2*k+1에 더해서 종료지점으로 선택한다
 * 15. 이제 bucket을 순회하는데 x좌표가 2*k+1에 차이를 더한 값보다 크다면 break하고 아니면 계속 더해준다.
 * 16. 시간초과가 발생해서 누적합 방식을 한번 생각해보았다. List로 관리해준다.
 *
 * 17. 위 방법은 틀렸다. 다른 방법을 생각해주자
 *
 *
 * 해결방법:
 * 1. 클래스로 만들지 말고 1000001만큼의 크기를 갖는 배열을 하나 선언하자. 각 인덱스는 좌표를 의미한다
 * 2. 이어서 x좌표를 인덱스로 잡고 그 위치에 ice를 넣어주자
 * 3. i-k가 0보다 크면 그 좌표의 얼음값을 sum에서 빼준다. 만약 그 위치에 없으면 어차피 0이되기 때문이다
 * 4. 이어서 그 위치의 ice를 sum에 더해주고 최댓값을 비교한다.
 * 5. 이러한 슬라이딩 윈도우 방식으로 해결하면 쉽게 해결된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) * 2 + 1;
        int[] buckets = new int[1000001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            buckets[x] = ice;
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < 1000001; i++) {
            if(i - k >= 0){
                sum -= buckets[i-k];
            }
            sum += buckets[i];
            max = Math.max(max, sum);
        }

        bw.write(max+"");

        br.close();
        bw.close();
    }

}

