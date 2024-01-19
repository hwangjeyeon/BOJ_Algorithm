import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 매개변수 탐색으로 푸는 문제이다.
 * - 각 구간의 최대값과 최소값이 중간값보다 큰 경우 count를 증가시켜준다.
 * - 그리고 구간별 최대값과 최소값을 다시 초기화 해주고, 순회하는 i를 감소시킨다
 * - 이 아래부분 부터는 힌트를 참고했다.. 이 부분은 아직도 완전히 이해되지 않아서 다시 풀때, 고민을 다시 해봐야할 것 같다
 * - 감소시키는 목적은 하나의 구간은 하나 이상의 연속된 수로 이루어져 있어야 하며, 그 구간은 수 한개로만 이루어질 수도 있기 때문이다.
 * - 그리고 count보다 작거나 같으면 max를 mid로 감소시킨다. mid-1을 하면 예제와 맞지 않게 된다
 * - 이어서 ans에는 max를 넣는다 
 * - 큰 경우는 min을 mid+1로 증가시킨다. 
 * - 최종 완성된 ans를 출력한다.
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
        List<Integer> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
            max = Math.max(max, numbers.get(i));
        }
        int ans = 0;
        while(min < max){
            int mid = (min + max) / 2;
            int tmpMax = 0;
            int tmpMin = 10001;
            int count = 1;

            for(int i=0; i<n; i++){
                tmpMin = Math.min(tmpMin, numbers.get(i));
                tmpMax = Math.max(tmpMax, numbers.get(i));
                if(tmpMax - tmpMin > mid){
                    count++;
                    tmpMin = 10001;
                    tmpMax = 0;
                    i--;
                }
            }
            if(count <= m){
                max = mid;
                ans = max;
            }else{
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }

}
