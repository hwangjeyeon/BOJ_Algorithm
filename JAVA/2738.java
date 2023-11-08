import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 그냥 이중 for문으로 해결할 수 있는데, stream을 활용하도록 리팩토링해서 풀어보았다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];


        IntStream.range(0,n)
                .forEach(i -> {
                    StringTokenizer as = null;
                    try {
                        as = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    StringTokenizer finalAs = as;
                    IntStream.range(0,m)
                            .forEach(j -> arr[i][j] = Integer.parseInt(finalAs.nextToken()));
                });

        IntStream.range(0,n)
                .forEach(i -> {
                    StringTokenizer as = null;
                    try {
                        as = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    StringTokenizer finalAs = as;
                    IntStream.range(0,m)
                            .forEach(j -> arr[i][j] += Integer.parseInt(finalAs.nextToken()));
                });


        IntStream.range(0,n)
                .forEach(i -> {
                    IntStream.range(0,m)
                            .forEach(j -> {
                                try {
                                    bw.write(arr[i][j] + " ");
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                    try {
                        bw.write("\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });


        br.close();
        bw.close();
    }


}
