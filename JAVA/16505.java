import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전 n-1번의 그림이 3번 반복되는 예제이다
 * - 따라서 해당 방법을 현재 위치, 오른쪽, 아래쪽에 똑같이 생성되도록 재귀함수를 실행시킨다
 * - 세부적인 로직에 대해 알고 싶지만 도저히 재귀함수에 대한 감이 오지 않는다...
 * - 트리 학습 후 다시 와서 재귀에 대해 이해될 때까지 깊게 공부해야겠다
 * - 재귀는 기존에 풀었던 문제를 다시 풀어볼 예정이다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, n)+1;
        stars = new char[size][size];
        for(int i=0; i<size; i++){
            Arrays.fill(stars[i], ' ');
        }
        star(0, n,0,0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size-1; i++){
            for(int j=0; j<size-i; j++){
                sb.append(stars[i][j]);
            }
            if(i!=size-1){
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    static void star(int newSize, int size, int x, int y){
        if(newSize == size){
            stars[y][x] = '*';
            return;
        }
        int newer = (int) Math.pow(2, newSize);
        star(newSize+1, size, x,y);
        star(newSize+1, size, x+newer,y);
        star(newSize+1, size, x,y+newer);
    }


}
