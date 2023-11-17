import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - count 변수 증가를 통해 1부터 p까지 순회하여 약수를 발견한다
 * - p % i == 0을 발견하면 count값을 1 증가시키고 그 i를 ans에 넣는다
 * - q랑 count가 값이 같은경우 break로 반복문을 탈출하고 출력한다
 * - 만약 q보다 count가 작은 경우 ans를 0으로 초기화하여 출력한다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */




public class Main {

//    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int count = 0;
        int ans = 0;
        for(int i=1; i<=p; i++){
            if(p % i == 0){
                count++;
                ans = i;
            }

            if(count == q){
                break;
            }
        }
        if(count < q){
            ans = 0;
        }
        bw.write(ans + "");


        br.close();
        bw.close();
    }

}
