import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 정렬 후 그리디하게 뽑는 문제다
 * 2. 일단 각 배열의 값을 내림차순 정렬해준다
 * 3. 이어서 n이 짝수인경우와 홀수인 경우를 구분하여, 짝수인 경우로 통일 시켜주면 된다
 * 4. 홀수인경우 2x1 타일의 최댓값을 하나 뽑아서 정답에 더해준다
 * 5. 이제 짝수로 동일하게 되었으니, 그리디한 시뮬레이션을 시작한다
 * 6. 한쪽이 인덱스 범위를 벗어났으나 시뮬레이션이 끝나지 않았다면 반대쪽 값으로 채워주고 종료한다
 * 7. 아닌경우 둘중 2x1타일을 두개 더한값과 2x2 타일 한개를 더한 값중 더 큰 선택해서 더해주고, n의 값은 2씩 감소한다
 * 8. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n/2)
 * 공간복잡도: O(a or b)
 *
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Integer[] first = new Integer[a];
        Integer[] second = new Integer[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(first, Collections.reverseOrder());
        Arrays.sort(second, Collections.reverseOrder());
        int ans = 0;
        int one = 0;
        int two = 0;
        if(n % 2 == 1){
            ans += first[one];
            one++;
            n--;
        }
        while(n > 0){
            if(one+1 >= a){
                while(n > 0){
                    ans += second[two];
                    two++;
                    n-=2;
                }
                break;
            }

            if(two >= b){
                while(n > 0){
                    ans += first[one] + first[one+1];
                    one+=2;
                    n-=2;
                }
                break;
            }

            if(first[one] + first[one+1] <= second[two]){
                ans += second[two];
                two++;
            }else{
                ans+= first[one] + first[one+1];
                one+=2;
            }
            n-=2;
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

