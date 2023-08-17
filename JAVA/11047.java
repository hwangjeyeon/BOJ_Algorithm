import java.io.*;
import java.util.StringTokenizer;



/**
 * 풀이 방법: 전형적인 그리디 알고리즘 문제
 * 접근 방법: 그리디 알고리즘을 활용하여 값이 큰 coin부터 비교하여 풀어나가기로 했다
 * 변수 선언:
 * int[] coin = 동전을 담은 배열
 * int count = 필요한 동전의 개수
 * int K = 필요로 하는 동전 가치의 합
 * 풀이 과정:
 * 1. coin배열에 동전의 가치를 넣는다
 * 2. coin배열의 끝부터 비교해나가며, count의 값은 증가시키고 k는 최대한 사용할 수 있는 현재의 동전가치만큼 빼주며 K가 음수가 되면 반복문을 탈출하고 값을 출력한다
 * 3. coin배열의 값이 K보다 크면 continue한다. 
 * 4. 불필요한 반복을 줄이기 위해 K/coin[i]만큼 동전을 최대로 사용할 수 있으므로 count에 해당 값을 넣어준다
 * 5. K/coin[i]와 coin[i]를 곱한 값 만큼 K를 빼준다
 * 6.위 탈출 조건을 만족하거나 배열을 모두 돌아서 벗어나면 count를 출력한다. 
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[K];


        for(int i=0; i<N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }



        int count=0;

        for(int i=N-1; i>=0; i--){
            if(K<=0){
                break;
            }
            if(K<coin[i]){
                continue;
            }
            count += K/coin[i];
            K-= coin[i]*(K/coin[i]);

        }


        bw.write(count+"");
        br.close();
        bw.close();


    }
}
