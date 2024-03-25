import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 4중포문인가 고민했는데 시간복잡도를 보면 1초 내에 가능해서 4중포문을 돌렸다
 *
 * - 문제 해결:
 * 1. 한가지 알아야할 점은 증가하는 형태여야 한다는 것이다. 따라서 i뒤에 따라오는 j,k,l은 i만큼만 순회해야한다
 * 2. j는 2부터 시작하나 k는 j보다 커야하고 l도 그 이전 두값보다 커야한다. 따라서 k는 j, l은 k부터 시작하면 된다.
 *
 * 시간복잡도: O(n^4)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= i; j++) {
                for (int k = j; k <= i; k++) {
                    for (int l = k; l <= i; l++) {
                        if(Math.pow(i,3) == (Math.pow(j,3)+Math.pow(k,3)+Math.pow(l,3))){
                            bw.write("Cube = " + i + ", ");
                            bw.write("Triple = (" + j + "," + k + "," + l + ")\n");
                        }
                    }
                }
            }
        }

        br.close();
        bw.close();
    }

}

