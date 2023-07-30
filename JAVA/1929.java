import java.io.*;
import java.util.StringTokenizer;

/**
 * 풀이 방법: 정수론의 소수판정 방법 중 에라토스테네스의 체를 이용하여 풀이했습니다.
 * - 2960번을 풀면서 에라토스테네서의 체를 이해하였고, 그 방식을 활용하여 약간의 변형을 통해 해당 문제를 해결하였습니다.
 * 1. 2960번처럼 2부터 N까지의 수를 모두 받아 arr 배열에 넣습니다
 * 2. 배수에 해당하는 수는 모두 0으로 바꾸고, 이번에는 2960번과는 다르게 2나 3같이 어떤 배수의 시작이 되는 수는 지우지 않고 continue합니다
 * 3. 똑같이 배열의 값이 0인경우는 continue해줍니다
 * 4. 시작 범위 M부터 N까지 값을 순회하는데 이번에도 배열의 값이 0인 경우는 continue하고 아닌 경우에만 값을 출력합니다 -> 소수만 남게됩니다
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M, N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N  = Integer.parseInt(st.nextToken());
        br.close();

        int[] arr = new int[N+1];
        for(int i=2; i<N+1; i++){
            arr[i] = i;
        }

        for(int i=2; i<N+1; i++){
            if(arr[i] == 0)
                continue;

            for(int j=i; j<N+1; j+=i){
                if(arr[j] == 0 || i == j)
                    continue;
                arr[j] = 0;
            }

        }

        for(int i = M; i<N+1; i++) {
            if (arr[i] == 0)
                continue;
            bw.write(arr[i] + "\n");
        }
        bw.close();
    }
}
