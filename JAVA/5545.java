

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 열량이 높은 것을 선택하도록 내림차순 정렬을 해준다. 열량이 높은 것을 먼저 선택해서 더 효율적으로 사도록 한다
 * 2. 이후 칼로리와 가격 값에는 도우의 값이 들어간다. ans도 이때 지정해주는데, 별도로 지정해주어야하는데 토핑을 모두 선택하지 않는 경우도 존재하기 떄문이다
 * 3. 이어서 ans랑 토핑 하나의 1원당 칼로리를 비교해서 더 작거나 같으면 값을 더해준다. 
 * 4. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aPrice = Integer.parseInt(st.nextToken());
        int bPrice = Integer.parseInt(st.nextToken());
        int aCal = Integer.parseInt(br.readLine());
        Integer[] bcals = new Integer[n];
        for (int i = 0; i < n; i++) {
            bcals[i] = Integer.parseInt(br.readLine());
        }

        int allCal = aCal;
        int allPrice = aPrice;
        int ans = allCal / allPrice;
        Arrays.sort(bcals, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if(ans <= (allCal+bcals[i])/(allPrice+bPrice)){
                allPrice += bPrice;
                allCal += bcals[i];
                ans = allCal / allPrice;
            }
        }
        bw.write(ans + "");


        br.close();
        bw.close();
    }
}

