import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 티셔츠 사이즈 종류 수 만큼 반복해서 사이즈별 필요한 묶음수를 구한다
 * 2. 묶음을 나눴을 때 나머지 발생하면 하나 추가한다
 * 3. 팬의 묶음은 n/p, 주문할 개수는 n%p 출력하면 정답이된다
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        int t= Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 6; i++) {
            count += arr[i] / t;
            if(arr[i]%t>0){
                count++;
            }
        }

        bw.write(count + "\n");
        bw.write(n / p + " " + n % p);

        br.close();
        bw.close();
    }

}

