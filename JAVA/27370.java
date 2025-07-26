import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

/**
 * 풀이 과정:
 * 1. 일단 두 지점을 받아서 더 작은 쪽을 p1에 고정시키 위해 p1가 더 크다면 스왑해준다
 * 2. 이후 평균값을 두고, 각 지점이 평균보다 작으면 a에 아니면 b에 합산한다
 * 3. 그리고 평균지점과 같은 지점에 대해서 개수를 세어준다
 * 4. 이제 평균 지점 위치를 어디데 둘지 결정해야 한다
 * 5. a가 작다면 a에 b가 작다면 b에 그 거리의 차를 구해서 더해준다
 * 6. 완성된 결과를 합산하고 집을 다시 왔다갔다해야하니 2를 곱해준다
 * 7. 그리고 두 지점의 이동거리의 차이를 구한다 절댓값으로 두 지점의 차를 구한뒤, 왕복거리를 위해 2를 곱한뒤 출력해나가면 정답이 된다
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
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if(p1 > p2){
                int tmp = p1;
                p1 = p2;
                p2 = tmp;
            }
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int avg = (p1 + p2) / 2;
            long a = 0;
            long b = 0;
            int count = 0;
            for (Integer i : list) {
                if(i < avg){
                    a += (i - p1);
                }else if(i > avg){
                    b += (p2 - i);
                }else{
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                if(a < b){
                    a += (avg - p1);
                }else{
                    b += (p2 - avg);
                }
            }
            bw.write((2*(a+b)) + " " + (2*Math.abs(a-b)) + "\n");
        }

        br.close();
        bw.close();
    }
}
