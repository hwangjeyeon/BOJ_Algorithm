import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 재귀
 * 1. 함수식 quadTree(field, size, x,y)
 * 2. base Condition 특정 조건을 만족하는 경우
 * -> 주어진 범위 내에서 배열을 순회했을 때, 모두 같은 경우
 * 3. 재귀식 4개로 분할정복해서 푼다 -> 참고로 아래 순서 지켜야 함...
 * - quadTree(field, size/2, x,y)
 * - quadTree(field, size/2, x+size/2,y)
 * - quadTree(field, size/2, x,y+size/2)
 * - quadTree(field, size/2, x+size/2,y+size/2)
 * - 또한 추가로 각 분할정복을 통과하기전에 "("을 추가한다.
 * - 마지막 분할 정복을 통과하면 ")"울 추가한다.
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(logn)
 *
 *
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(input[j]);
            }
        }

        quadTree(field, n, 0,0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void quadTree(int[][] field, int size, int x, int y) {
        if(isSame(field, size, x,y)){
            sb.append(field[y][x]);
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        quadTree(field, newSize, x,y);
        quadTree(field, newSize, x+newSize,y);
        quadTree(field, newSize, x,y+newSize);
        quadTree(field, newSize, x+newSize,y+newSize);
        sb.append(")");
    }

    private static boolean isSame(int[][] field, int size, int x, int y) {
        int now = field[y][x];
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x + size; j++) {
                if(now != field[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


}
