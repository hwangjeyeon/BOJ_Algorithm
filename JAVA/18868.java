import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 하나를 잡고 그 값의 이후값들과만 비교하면 되는 문제이다
 * 2. 입력값이 매우 작기 때문에 4중포문으로 해결하였다.
 * 3. i는 0~m까지, j는 i+1~m까지 순회한다. k는 0~n까지, l은 k+1~n까지 순회한다
 * 4. 각각을 순회하면서 arr[i][k]와 arr[i][l]을 비교한 것과 arr[j][k]과 arr[j][l]을 비교한 것이 둘다 같은지 비교한다
 * 5. 같으면 isOk를 true로 한다.
 * 6. 만약 다른 경우가 있는 경우 isOk를 false로 하고 break로 탈출한다
 * 7. 그리고 isOk를 체크해서 만약 false이면 break로 다시 탈출한다
 * 8. 행성 비교마다 isOk를 체크해서 true면 count를 증가시킨다
 * 9. 완성한 count를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(n^2*m^2)
 * 공간복잡도: O(mn)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                boolean isOk = false;
                for (int k = 0; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if(arr[i][k] < arr[i][l] && arr[j][k] < arr[j][l]){
                            isOk = true;
                        }else if(arr[i][k] == arr[i][l] && arr[j][k] == arr[j][l]){
                            isOk = true;
                        }else if(arr[i][k] > arr[i][l] && arr[j][k] > arr[j][l]){
                            isOk = true;
                        }else{
                            isOk = false;
                            break;
                        }
                    }
                    if(!isOk){
                        break;
                    }
                }
                if(isOk){
                    count++;
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

}

