import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 쿼드트리와 색종이 만들기 문제와 비슷한 문제다
 * - 이전처럼 주어진 범위를 주어서 해당 범위 내에 다른 숫자가 있는지만 체크해주면된다
 * - 위 조건은 종료조건으로 이 조건에 해당하면 현재 위치의 숫자가 무엇인지 파악해서 그에 맞는 변수의 값을 증가시켜준다
 * - 이전 문제와 다르게 이 문제는 3등분을 해줘야 한다. 따라서 newSize는 n/3이다
 * - 그리고 재귀도 9개씩 해야한다.
 * - 이렇게 해서 모든 재귀 함수를 돌고난 다음 그만큼 증가한 변수의 값을 주어진대로 출력한다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {
    static int[][] arr;
    static int minus;
    static int zero;
    static int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(n, 0,0);

        bw.write(minus + "\n" + zero + "\n" + plus);

        br.close();
        bw.close();
    }

    public static void partition(int n, int x, int y){
        if(isSame(n,x,y)){

            if(arr[y][x] == -1){
                minus++;
            }else if(arr[y][x] == 0){
                zero++;
            }else if(arr[y][x] == 1){
                plus++;
            }
            return;
        }

        int newSize = n/3;
        partition(newSize, x, y);
        partition(newSize, x+newSize, y);
        partition(newSize, x+newSize+newSize, y);
        partition(newSize, x, y+newSize);
        partition(newSize, x+newSize, y+newSize);
        partition(newSize, x+newSize+newSize, y+newSize);
        partition(newSize, x, y+newSize+newSize);
        partition(newSize, x+newSize, y+newSize+newSize);
        partition(newSize, x+newSize+newSize, y+newSize+newSize);

    }

    private static boolean isSame(int n, int x, int y) {
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
