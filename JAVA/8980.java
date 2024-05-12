

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 각 정보를 담을 하나의 클래스를 만들어준다
 * 2. 해당 클래스에는 보내는 마을, 받는 마을, 택배의 개수 정보를 가지고 있다
 * 3. 클래스 타입으로 배열을 하나 만들어서 정보를 담아준다
 * 4. 이후 그리디하게 풀기 위해서 받는 마을을 기준으로 오름차순 정렬을 하고, 만약 같은 경우 보내는 마을을 기준으로 오름차순 정렬을 해준다
 *
 *
 * - 문제 해결:
 * 1. 처음에는 보내는 마을 기준으로 오름차순 정렬을 했으나 반례가 존재하였다.
 * 2. 순서도 정리하기 쉽지 않고, 먼거리로 이동하는 경우 다 담지를 못하는 문제가 발생한다
 * 3. 따라서 위와 같은 정렬을 선택하였다
 * 4. 단순 정렬만으로는 문제를 풀기에 부족하다. 해당 문제는 키 포인트는 각 마을의 최대 용량을 설정해주고 경로별로 보낼 수 있는 최대 한도를 구하는 것이다
 * 5. 정리된 항목들을 순회하면서 보내고 받는 경로의 보낼 수 있는 최대 한도를 구한다
 * 6. 만약 현재 항목의 택배의 개수보다 최대 한도가 크거나 같다면, 해당 항목의 보내는 지점부터 받는 지점까지의 택배의 개수를 빼준다
 * 7. 이후 ans에 현재 택배의 개수를 더해준다
 * 8. 만약 최대 한도보다 현재 항목의 택배의 개수가 더 크다면 해당 경로의 각 마을의 최대 택배의 개수를 현재 최대 한도로 빼준다
 * 9. 이후 최대 한도를 ans에 더해준다
 * 10. 완성된 ans를 출력한다
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */
class Lists{

    int start;
    int end;
    int count;

    public Lists(int start, int end, int count){
        this.start = start;
        this.end = end;
        this.count = count;
    }

}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        Lists[] list = new Lists[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            list[i] = new Lists(start, end, count);
        }
        Arrays.sort(list, (o1, o2) -> {
            if(o1.end == o2.end){
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int[] arr = new int[n+1];
        for (int i = 1; i < n; i++) {
            arr[i] =  c;
        }



        int ans = 0;

        for (int i = 0; i < m; i++) {
            Lists li = list[i];

            int max = Integer.MAX_VALUE;

            for (int j = li.start; j < li.end; j++) {
                max = Math.min(max, arr[j]);
            }

            if(max >= li.count){
                for (int j = li.start; j < li.end; j++) {
                    arr[j] -= li.count;
                }
                ans += li.count;
            }else{
                for (int j = li.start; j < li.end; j++) {
                    arr[j] -= max;
                }
                ans += max;
            }
        }
        bw.write(ans +"");


        br.close();
        bw.close();
    }
}

