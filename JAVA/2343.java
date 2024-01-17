import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 블루레이의 길이의 합을 기준으로 매개변수탐색을 진행한다
 * - min은 블루레이의 시간중 가장 큰 값으로 하고, max는 블루레이의 시간을 모두 더한 값으로 한다
 * - 매개변수 탐색을 진행하는데, 지금까지 더한 강의의 길이에다가 이번에 더해질 강의의 길이가 mid보다 크면 지금까지 더한 강의길이 변수를 0으로 초기화하고, count 값을 증가시킨다
 * - count값과 mid값을 기준으로 탐색을 진행하는데, count가 m보다 작으면 max = mid-1로 범위를 줄이고 ans에 mid를 넣는다
 * - 반대는 min = max+1을 진행하며 이렇게 완성된 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(logn)
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
        List<Integer> videos = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        long max = 1;
        long min = 1;
        for(int i=0; i<n; i++){
            videos.add(Integer.parseInt(st.nextToken()));
            min = Math.max(min, videos.get(i));
            max += videos.get(i);
        }


        long ans = 0;
        while(min <= max){
            long mid = (min + max) / 2;
            long lectures = 0;
            long count = 0;
            for(int i=0; i<n; i++){
                if(lectures + videos.get(i) > mid){
                    count++;
                    lectures = 0;
                }
                lectures += videos.get(i);
            }


            if(count < m){
                max = mid-1;
                ans = mid;
            }else{
                min = mid+1;
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }

}
