import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * 중간고사 종료 후 이차원 배열을 활용한 DP공부할 예정, 그 이전까지는 점화식 추리하는 문제거나 Math.max or Math.min 문제 복습겸 풀 예정
 * - BigInteger라는 것을 접하게 해준 문제..
 * - 메모리 초과 떄문에 테스트 케이스 안에서 반복적으로 배열을 초기화하고 업데이트 하는 것은 할 수가 없었다.
 * - 그렇다면 밖에서 미리 피보나치 수열을 미리 초기화하는 방법을 써야하는데 long 형을 무시해버리는 오버플로우 값이 저장되어버린다
 * - long형이 안 된다면 대체 뭘 어떻게 해야하나... 싶어서 결국 힌트를 봤는데 math 라이브러리의 BigInteger라는 범위가 무한인 것을 사용해야만 한다고 한다
 * - 이런 것이 있는지 처음 알았고 범위가 무한대라는 점에서 정말 매력적인 것 같다.
 * - BigInteger의 작동방식은 다음과 같다
 * -> 숫자들을 문자열로 받고 그 연산을 문자열끼리의 연산으로 해서 저장한다. 즉 귀찮게 구현해야할 것을 하나의 BigInteger 클래스에 저장해둔 것이다.
 * - long형의 범위를 벗어나는 경우의 문제를 해결할 수 있다는 점에서 하나의 또다른 무기를 얻은 기분이다.
 * -  하지만 이것은 일반적인 연산과 다르기 때문에 기존 연산 방식보다 더 시간이 걸린다는 점에서 그 단점과 장점을 잘 파악해서 상황에 맞게 적용하면 더 합리적이고 효율적인 알고리즘 풀이가 될 것 같다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    //static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        BigInteger[] fib = new BigInteger[10001];
        fib[1] = BigInteger.valueOf(1);
        fib[2] = BigInteger.valueOf(1);
        fib[3] = BigInteger.valueOf(2);
        for(int j=4; j<10001; j++){
            fib[j] = fib[j-1].add(fib[j-2]);
        }

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

                //System.out.println(fib[P]);
                bw.write("Case #"+(i+1)+": "+ fib[P].remainder(BigInteger.valueOf(Q)) +"\n");



        }

        br.close();
        bw.close();

    }

}
