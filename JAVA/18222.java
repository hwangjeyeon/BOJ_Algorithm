import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음에 생각한 방법은 2배씩 증가하면서 문자열을 붙이는 방식을 생각했다
 * -> 입력값을 생각했을 때, 시간초과 문제가 발생한다...
 * -> 그리고 한번 10^18을 단순히 문자열 붙이는 것만 해봤는데, out of memory가 뜬다. 그냥 이 방법은 시도를 하면 안된다
 * - 두번째에서는 규칙을 발견하였다. 잘 보면 2의 제곱 수만큼 증가하는 것과 거기서 나오는 규칙을 잘 써보면 되지 않을까 생각했으나, 결국 힌트를 참고하였다
 * - 어떤 수가 있으면 그 수를 각 2의 제곱 단위만큼 빼서 1이 나올때까지 쪼개는 분할 정복의 방식을 활용하면 된다.
 * - 최대 입력 수 10^18을 고려했을 때, 0부터 61 인덱스 정도까지만 있으면 되므로 크기 62의 2의 제곱수를 담을 배열을 생성한다.
 * - 재귀를 도는데 1은 0을 리턴하고, 0부터 순회해서 입력 받은 수가 위 2의 제곱수가 담긴 배열의 수보다 작거나 같아질때까지 순회한다.
 * - 규칙을 생각했을 때, 그 위치에 있는 수의 반대가 정답이다는 규칙이 있다
 * -> 즉 0이 있으면 1이 정답이고 1이 있으면 정답이다
 * - 재귀를 생각하면 13번째에 있는 수는 13-8인 5에 있고 또한 5-4인 1에 위치한 수가 될 것이다.
 * - 위 두가지를 생각했을때, return 1-thueMos(pos-sizes[i-1])를 해주면 된다.
 * - 이렇게 리턴한 값을 출력하면 정답이 된다
 *
 *
 * - 분할정복 문제를 풀면서 든 고민은 재귀가 정말 약하다는 점이다
 * - 따라서 원래 계획은 다음에 이분탐색 개념을 공부하려 했으나, 먼저 재귀를 깊게 학습한 다음 공부하려고 한다.
 * - 재귀 초급부터 중급까지 쉽게 풀 수 있을 정도로 탄탄하게 공부한 다음 이분탐색 개념 공부로 넘어갈 것이다.
 * 둘다 62라는 상수 시간이므로.
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static long[] sizes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sizes = new long[62];
        long k = Long.parseLong(br.readLine());
        sizes[0] = 1;
        for(int i=1; i<62; i++){
            sizes[i] = sizes[i-1] * 2;
        }
        bw.write(thueMos(k)+"");

        br.close();
        bw.close();
    }

    static long thueMos(long pos){
        if(pos == 1){
            return 0;
        }

        for(int i=0; i<62; i++){
            if(pos <= sizes[i]){
                return 1 - thueMos(pos - sizes[i-1]);
            }
        }
        return 0;
    }



}
