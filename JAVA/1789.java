import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 가장 작은 수인 1부터 해당 수를 차례대로 뺴주면 된다.
 * - 이때 해당 수를 뺀 값이 0보다 큰동안만 반복한다.
 * - 만약 작거나 같아지는 순간이 있으면 그 때의 수가 최대값이 된다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long s = Long.parseLong(br.readLine());
        long i = 0L;
        while(s-i >0){
            i++;
            s-=i;
        }
        bw.write(i+"");


        br.close();
        bw.close();
    }

}
