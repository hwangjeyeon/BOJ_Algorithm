import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 밑과 지수가 int형의 최대 범위까지 가능하다. 따라서 long형으로 타입을 지정해야한다
 * 2. 재귀함수 파라미터로는 입력값 3개를 넘겨주었다.
 * 3. 처음에는 그냥 거듭제곱하는 재귀함수로 풀었으나 메모리 초과 문제가 발생하였다
 * 4. 왜 그런가 확인해보니 2^31-1 ^ 2^31-1을 계산하다고 생각해보면 된다. 이 값은 long형의 범위를 벗어난다.
 * 5. 이 문제는 재귀함수를 기본으로 하며, 추가로 수학적인 지식과 분할 정복 방식으로 해결하여야 한다
 * 6. 지수 법칙과 모듈러 공식에 대해서 알아야 하는데 먼저 제곱을 가지는 두 수 a^n * a^m은 a^nm이 될 수 있고, 반대가 될 수도 있다
 * 7. 이것을 절반씩 분할해주고 1이 지수가 1이 될때를 베이스로 하여 그때 a에 c를 모듈러 연산한 값을 return하면된다
 * 8. 7번 결과를 tmp에 담고 연산을 진행한다
 * 9. 먼저 홀수 인 경우와 아닌 경우를 생각해야 한다 홀수인 경우는 예를 들어 11인 경우는 2로 나누면 5가된다. 나머지 1이 애매하게 남는데 이것은 a^n * a^n *a로 처리하면된다
 * 10. 짝수일 떄는 그냥 a^n * a^n을 해주면된다
 * 11. 이때 return하는 값은 홀수일 때는 tmp*tmp*a%c와 짝수일 떄는 tmp*tmp%c를 하면 된다
 * 12. 11번처럼 풀면 이번에는 문제를 아예 틀려버린다. 왜냐하면 오버플로우가 발생하기 때문이다
 * 13. 짝수인 경우는 상관없으나 홀수인 경우는 tmp*tmp는 앞서 조심하자고 말했던 int형 최대범위를 int형 최대 범위로 곱하는 불상사가 발생한다
 * 14. 따라서 모듈러 공식중 하나인 (a*b)%c = (a%c*b%c)%c를 활용한다.
 * 15. ((tmp%tmp)%c*(a%c))%c로 바꾸면 문제가 해결된다.
 *
 *
 * 시간복잡도: O(log b)
 * 공간복잡도: O(log b)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long ans = multiple(a,b,c);
        bw.write(ans+"");
        br.close();
        bw.close();
    }

    static long multiple(long a, long b, long c){
        if(b == 1){
            return a % c;
        }
        long tmp = multiple(a, b/2,c);

        if(b % 2 == 1){
            return ((tmp * tmp)%c * (a%c)) % c;
        }

        return tmp * tmp % c;
    }

}

