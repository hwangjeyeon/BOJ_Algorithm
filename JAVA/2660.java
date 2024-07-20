import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 문제에서 원하는 친구의 점수를 내는 방식은 플로이드 와샬 알고리즘과 유사하다. 따라서 해당 방식을 선택하였다.
 *
 * 해결방법:
 * 2. 하지만 이 문제는 기존 플로이드와샬을 응용하여야 하는 문제다.
 * 3. 두 지점 사이에 거쳐갈 수 있는 통행로들을 더한 값이 바로 그 지점으로 가는 것보다 작다면 그 지점을 더한 값으로 초기화 해준다
 * 4. 2번 이동하면 2점, 3번 이동하면 3점이니 이 방식을 이용하여 누적해나간다면 해당 지점의 친구 점수를 구할 수 있다
 * 5. 이때 최대 점수가 그 지점의 친구 점수가 된다
 * 6. 처음값은 최대로 될 수 있는 값 + 1인 51로 지정한다
 * 7. 이후 지점별로 최대치를 찾아서 배열로 관리하고 최솟값을 갱신해나간다. 최솟값 역시 51이 초기값이다
 * 8. 이후 별도의 리스트를 만들어서 최솟값과 같은 값들을 저장하고, 그 최솟값과 리스트 사이즈, 그리고 리스트의 값들을 for-each로 출력하면 정답이 된다.
 * 
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {


    static int[][] arr;
    static int[] score;
    static int min = 51;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i == j){
                   continue;
                }
                arr[i][j] = 51;
            }
        }
        score = new int[n+1];
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b== -1){
                break;
            }
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        floydWarshall(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if(score[i] == min){
                list.add(i);
            }
        }

        bw.write(min + " " + list.size() + "\n");
        for (Integer i : list) {
            bw.write(i + " ");
        }


        br.close();
        bw.close();
    }

    private static void floydWarshall(int n) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int tmp = 0;
            for (int j = 1; j < n + 1; j++) {
                if(arr[i][j] != 51){
                    tmp = Math.max(tmp, arr[i][j]);
                }
            }
            score[i] = tmp;
            min = Math.min(min,score[i]);
        }

    }

}

