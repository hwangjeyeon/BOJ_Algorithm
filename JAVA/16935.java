import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시간복잡도가 최대 10^7이기 떄문에 그냥 주어진 조건대로 구현하면 되는 문제다
 * 2. 인덱스 변화를 잘 관찰해서 n*m 시간복잡도 탐색 안에서 해결하도록 하면 된다
 * 3. 임시 배열을 하나 선언해서 옮겨진 값을 미리 복사해둔 뒤, 원본 배열에 덮어씌우는 것으로 구현했다
 * 4. 상하, 좌우반전은 인덱스 위치만 바꿔서 쉽게 해결했고, 회전은 n과 m변수는 유지하지만 그 내부 값만 변경한뒤 tmp의 인덱스 위치만 바꿔서 해결했다
 * 5. 5번 6번 연산은 무조건 짝수이기 때문에 n/2와 m/2만큼 씩만 조회하면 된다
 * 6. 어차피 복사배열이기 때문에 한번에 4등분한 구역에 변화한 값을 배치했다
 * 7. 이후 완성한 원본 배열을 모두 출력하면 정답이다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(r*n*m)
 * 공간복잡도: O(n*m)
 *
 */
public class Main {

    static int n;
    static int m;
    static int r;
    static int[][] arr;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            switch (num) {
                    case 1:
                        topDownReverse();
                    break;
                    case 2:
                        leftRightReverse();
                    break;
                    case 3:
                        rightRotate();
                    break;
                    case 4:
                        leftRotate();
                    break;
                    case 5:
                        fourDivideRight();
                        break;
                    case 6:
                        fourDivideLeft();
                        break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        
        br.close();
        bw.close();
    }

    private static void fourDivideLeft() {
        int[][] tmp = new int[n][m];
        int nf = n/2;
        int mf = m/2;
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < mf; j++) {
                tmp[i][j] = arr[i][mf+j];
                tmp[i][mf+j] = arr[nf+i][mf+j];
                tmp[nf+i][mf+j] = arr[nf+i][j];
                tmp[nf+i][j] = arr[i][j];
            }
        }

        arr = tmp;
    }

    private static void fourDivideRight() {
        int[][] tmp = new int[n][m];
        int nf = n/2;
        int mf = m/2;
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < mf; j++) {
                tmp[i][j] = arr[nf+i][j];
                tmp[i][mf+j] = arr[i][j];
                tmp[nf+i][mf+j] = arr[i][mf+j];
                tmp[nf+i][j] = arr[nf+i][mf+j];
            }
        }
        arr = tmp;
    }

    private static void leftRotate() {
        int a = n;
        n = m;
        m = a;
        int[][] tmp = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[n-j-1][i] = arr[i][j];
            }
        }

        arr = tmp;
    }

    private static void rightRotate() {
        int a = n;
        n = m;
        m = a;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][m-i-1] = arr[i][j];
            }
        }
        arr = tmp;
    }

    private static void leftRightReverse() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][m-i-1] = arr[j][i];
            }
        }
        arr = tmp;
    }

    private static void topDownReverse() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[n-i-1][j] = arr[i][j];
            }
        }
        arr = tmp;
    }
}
