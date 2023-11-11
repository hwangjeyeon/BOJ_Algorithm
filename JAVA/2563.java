import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * 힌트 참고함
 * - 처음에는 복잡하게 너비와 높이의 차를 구하는 방법으로 풀었지만, 이 방법은 예외가 너무 많아 효율적이지 못하다
 * - 도화지의 넓이가 주어졌고, 충분히 시간복잡도 안에서 해결할 수 있을 적은 입력값이 주어지기 때문에, x와 y좌표가 주어지면 그 좌표에 10을 더한 만큼까지 각각의 좌표를
 * 체크한다. 즉 10*10만큼 체크를 다 해보는 것이다. 이때 static 배열이기에 초기값이 0으로 설정되어있으므로, 따로 boolean 배열 생성할 필요 없이 0이면 1로 설정하고 count값을 증가시킨다
 * -> 이렇게 하면 중복되는 부분을 알아서 거를 수 있어서 예외 상황을 모두 해결할 수 있다
 * - 최종적으로 count를 출력한다
 * 
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */




public class Main {

//    static long[][] dp;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        paper = new int[101][101];
        int count = 0;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=x; j<x+10; j++){
                for(int k=y; k<y+10; k++){
                    if(paper[j][k] == 0){
                        paper[j][k] = 1;
                        count++;
                    }
                }
            }
        }

        bw.write(count + "");
        br.close();
        bw.close();
    }

}
