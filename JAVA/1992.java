import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 색종이 만들기 문제와 비슷한 문제이다.
 * - 재귀로 순환하는데 종료 조건은 현재 주어진 영역을 모두 순회했을 때, 다른 숫자가 없는 경우이다.
 * - 문자열이 들어가기때문에 StringBuilder를 사용해서 편리하게 해준다.
 * - 종료조건을 판별하는 메소드에서 주의할 점은 범위를 현재 주어진 범위 내에서 해야한다 즉 i=y; i<y+n, j=x; j<x+n; 이렇게 해야지 모든 경우가 안 나오게되었다
 * -> 이 부분만 때문에 다 만들어놓고 힌트를 참고하게되었다..
 * - 그외에는 재귀 시작과 끝에 각각 "(", ")"를 추가하도록 하면 된다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        partition(n, 0,0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void partition(int n, int x, int y){
        if(isAllSame(n, x, y)){
            sb.append(arr[y][x]);
            return;
        }

        int newSize = n/2;
        List<Integer> tmp = new ArrayList<>();
        sb.append("(");
        partition(newSize, x, y);
        partition(newSize, x+newSize,y);
        partition(newSize, x,y+newSize);
        partition(newSize, x+newSize,y+newSize);
        sb.append(")");

    }

    public static boolean isAllSame(int n, int x, int y){
        int tmp = arr[y][x];
        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                if(arr[i][j] != tmp){
                    return false;
                }
            }
        }
        return true;
    }


}
