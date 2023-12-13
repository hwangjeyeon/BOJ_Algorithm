import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 주파수와 목표 주파수와의 차이를 비교하는 방법으로 해결하였다.
 * - distance에 목표주파수와 현재 주파수의 차를 넣는다
 * - 리스트에 추가되는 즐겨찾기 버튼들의 위치를 파악하고 목표주파수와의 거리가 distance보다 작은지 파악한다
 * - 만약 작으면 해당 거리 차이를 distance에 넣고, 현재 주파수 위치인 newPosition에 추가된 즐겨찾기 버튼의 위치를 넣는다
 * - 순회를 마치고 newPosition과 nowFrequency가 같지 않으면, 즐겨찾기 버튼을 이용한 것이므로 클릭횟수를 1 증가시킨다.
 * - 이렇게 모든 리스트 값들이 입력으로 들어올때까지 판단하고 최종적으로 남은 거리 만큼을 버튼 클릭 횟수에 더해준다
 * - 이렇게 구한 버튼 클릭 횟수를 정답으로 출력한다.
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
        int nowFrequency = Integer.parseInt(st.nextToken());
        int targetFrequency = Integer.parseInt(st.nextToken());
        List<Integer> buttons = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int distance = Math.abs(targetFrequency - nowFrequency);
        int clickCounts = 0;
        int newPostition = nowFrequency;
        for(int i=0; i<n; i++){
            buttons.add(Integer.parseInt(br.readLine()));
            if(distance > Math.abs(targetFrequency - buttons.get(i))){
                distance = Math.abs(targetFrequency - buttons.get(i));
                newPostition = buttons.get(i);
            }
        }

        if(newPostition != nowFrequency){
            nowFrequency = newPostition;
            clickCounts++;
        }
        clickCounts += Math.abs(targetFrequency - nowFrequency);


        bw.write(clickCounts+"");


        br.close();
        bw.close();
    }

}
