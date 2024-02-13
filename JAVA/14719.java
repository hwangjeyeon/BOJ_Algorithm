import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 간단한 구현 + 시뮬레이션 문제이다
 * - 빗물이 고이는 원리만 문제 예제를 통해서 이해하면 된다
 * - 높이마다 만약 어떤 지점이 빈 공간이라면 자신의 왼쪽과 오른쪽으로 얼마만큼의 공간이 있든지 자기와 같거나 높은 높이의 블록이 있으면 된다.
 * - 이 원리를 이용하였을 때, 주어진 입력값이 2*2 좌표가 아니라 각 가로 줄별로 높이를 주었으므로, 1부터 h까지의 높이를 한줄 씩 비교해서 빈 공간과 위 원리를 이용한 칸수를 구하면 된다
 * - 최대 입력값도 500이므로 이중 순회를 했을 때 시간제한 1초를 넘기지 않는다
 * - 이제 모든 높이를 시뮬레이션 해보자
 * - 높이마다 start와 end포인트를 -1로 초기화한다
 * - 각 높이에서 현재 가로 좌표의 높이가 확인하고 있는 높이보다 크거나 같으면 start가 -1일 경우 start에 해당 좌표를 넣어준다
 * - end는 start가 -1가 아닐 때 좌표를 넣어주고 end-start-1 값을 count에 넣어준다. 이때 조건 검사는 end가 start보다 먼저해주는데, start 값 갱신 후 똑같은 위치에서 end에 갱신하는 불상사를 막기 위해서이다
 * - 이어서 end와 start가 모두 -1이 아니면 다시 현재 좌표를 start로 바꿔준다. 이렇게 하면 예제 2번을 통과할 수 있다.
 * - 이런식으로 완성한 count를 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */



public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = -1;
        int end = -1;
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(arr[j] >= i+1){
                    if(start != -1){
                        end = j;
                        count += (end - start) -1;
                    }

                    if(start == -1){
                        start = j;
                    }

                    if(end != -1){
                        start = j;
                    }
                }
            }
            start = -1;
            end = -1;
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }


}

