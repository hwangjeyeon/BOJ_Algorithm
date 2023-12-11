import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 나는 그냥 경우의 수를 일일이 다 쳐서 푸는 방식으로 했는데, 거스름돈을 배열로 놓고 반복문으로 코드를 줄이는 방법도 괜찮은 방법이라고 생각한다 
 * -> 해당 방법으로 풀어보는 것도 이후 그리디 문제에서 고려해보기
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
        n = Math.abs(n-1000);
        int count = 0;
        count += n/500;
        n %= 500;
        count += n/100;
        n %= 100;
        count += n/50;
        n %= 50;
        count += n/10;
        n %= 10;
        count += n/5;
        n %= 5;
        count += n/1;
        n %= 1;

        bw.write(count + "");

        br.close();
        bw.close();
    }

}
