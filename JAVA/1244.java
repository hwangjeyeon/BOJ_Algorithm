import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력으로 들어오는 스위치 상태는 배열로 관리한다
 * 2. 이후 들어오는 m만큼의 입력동안 남자와 여자로 구분해서 작업을 진행한다
 * 3. a가 1인경우 남자다. 담당 메소드를 실행한다
 * 4. 메소드에서는 넘어온 b를 시작으로 그 배수만큼 증가하는 포문 탐색을 하며, 반전을 시켜준다
 * 5. a가 2인경우 여자다. 담당 메소드를 실행한다
 * 6. 메소드에서는 넘어온 b의 위치의 값을 먼저 반전시킨다.
 * 7. 그 다음 while문을 반복하는데 먼저 초기 left와 right 변수를 선언한다
 * 8. 이후 left와 right가 인덱스 범위를 벗어나지 않고 둘이 같다면 반복한다
 * 9. left와 right의 위치의 값을 반전시킨다. 그리고 left는 감소 right는 증가시켜서 탐색을 진행시킨다.
 * 10. 최종 완성된 배열의 값을 출력하면 정답이 된다. 단 이때, 한줄에 20개의 출력만 하라고 했으므로 i % 20이 0일경우 \n출력을 통해 줄바꿈을 해준다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n * m)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1){
                man(n, b);
            }else{
                woman(n, b);
            }
        }

        for (int i = 1; i < n+1; i++) {
            bw.write(arr[i] + " ");
            if(i % 20 == 0){
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }

    private static void woman(int n, int b) {
        arr[b] = arr[b] == 1 ? 0 : 1;
        int left = b-1;
        int right = b+1;
        while(left > 0 && right < n+1 && arr[left] == arr[right]){
            arr[left] = arr[left] == 1 ? 0 : 1;
            arr[right] = arr[right] == 1 ? 0 : 1;
            left--;
            right++;
        }

    }

    private static void man(int n, int b) {
        for (int i = b; i < n+1; i+=b) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
    }

}

