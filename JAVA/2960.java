import java.io.*;
import java.util.StringTokenizer;

/**
 * 풀이 방법: 에라토스테네스의 체 공부 목적으로 푼 문제입니다.
 * - 2부터 N까지의 모든 정수를 받고 2부터 그 해당하는 모든 배수를 지워나가는 알고리즘입니다
 * 1. 2부터 N까지의 모든 정수를 받고 배열에 넣는다
 * 2. 2부터 차례대로 지정된 범위내에 해당하는 배수를 모두 0으로 바꾼다
 * 3. 이렇게 반복해나갈 때 만약 해당 배열의 값이 0이라면 continue해준다
 * 4. count값을 증가시켜 나가면서 K랑 값이 같아지면 해당 값을 ans에 넣고 이중 for문을 break한다.
 * 5. ans를 출력한다
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();

        int[] arr = new int[N+1];
        int count = 0;
        for(int i=2; i<N+1; i++){
            arr[i] = i;
        }
        int ans = 0;
        for(int i=2; i<N+1; i++){
            if(arr[i] == 0)
                continue;

            for(int j=i; j<=N; j+=i){
              if(arr[j] == 0)
                  continue;
              count++;
              if(count == K){
                ans = arr[j];
                    break;
              }
              arr[j] = 0;
            }

            if(count == K)
                break;
        }

        bw.write(ans+"");
        bw.close();

    }
}
