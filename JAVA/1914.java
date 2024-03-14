import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀
 * 1. 함수 형태: hanoi(크기, 1번장대, 2번장대, 3번장대)
 * 2. base Condition 크기가 0일 때 1번장대, 3번장대 출력 후, 종료
 * 3. 재귀식 hanoi (크기-1, 1번장대, 2번장대, 3번장대)
 *
 * 1. 하노이 탑은 n번째가 3번으로 가기 위해서는 먼저 n-1개의 탑이 2번으로 가야한다
 * 2. 이어서 n번째가 3번으로 가고, 2번에 있는 n-1개를 3번으로 옮기면 완성이 된다.
 * 3. 1~2번을 반복하는 재귀함수를 통해 정답을 출력한다
 * 4. 추가로 20을 넘어서는 순간부터는 위 재귀함수를 실행할 필요가 없다. 
 * 5. 그리고 BigInteger를 사용해야한다. 아니면 메모리 초과로 틀리게 된다
 * 6. 입력 최대값인 100을 2^100-1로 생각했을 때, long형 범위까지 벗어나게 된다 따라서 BigInteger로 출력해야한다.
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(logn)
 *
 */


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n <= 20){
            bw.write((int)Math.pow(2,n)-1+"\n");
            hanoi(n,1,2,3);
            bw.write(sb.toString());
        }else{
            BigInteger bigInteger = new BigInteger("2");
            bigInteger = bigInteger.pow(n);
            bigInteger = bigInteger.subtract(new BigInteger("1"));
            bw.write(bigInteger.toString());
        }


        br.close();
        bw.close();
    }

    private static void hanoi(int size, int a, int b, int c){
        if(size == 1){
            sb.append(a).append(" ").append(c).append("\n");
            return;
        }

        hanoi(size-1, a,c,b);
        hanoi(1, a,b,c);
        hanoi(size-1,b,a,c);

    }


}

