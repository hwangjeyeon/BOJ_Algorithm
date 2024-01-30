import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음은 그냥 구현으로 풀었고 이어서 투포인터 알고리즘을 활용하여 풀었다
 * - 투포인터 알고리즘만 설명하면 먼저 두 배열을 오름차순으로 정렬한다
 * - 각각의 포인터를 변수로 선언하고 범위내에서 반복을 진행한다
 * - 두 배열의 포인터 위치를 비교하는데, 작은 쪽의 값을 정답배열에 넣어주고 해당 포인터를 증가시킨다
 * - 이후 두 배열의 크기가 맞지 않을 경우를 대비해서 남은 배열의 값들을 넣어주는 과정을 한다
 * - 이렇게 완성한 정답 배열을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[n];
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[n+m];
        int pointerA = 0;
        int pointerB = 0;

        // 투포인터 알고리즘을 활용하여 푼 문제
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int nowPos = 0;
        while(pointerA < n && pointerB < m){

            if(arrA[pointerA] < arrB[pointerB]){
                ans[nowPos] = arrA[pointerA];
                pointerA++;
            }else{
                ans[nowPos] = arrB[pointerB];
                pointerB++;
            }
            nowPos = pointerA + pointerB;
        }

        while (pointerA < n){
            ans[nowPos] = arrA[pointerA];
            pointerA++;
            nowPos = pointerA + pointerB;
        }

        while (pointerB < m){
            ans[nowPos] = arrB[pointerB];
            pointerB++;
            nowPos = pointerA + pointerB;
        }

        for (int i = 0; i < n + m; i++) {
            bw.write(ans[i]+" ");
        }

        // 투포인터 개념 없이 단순 구현으로 푼 방법
        /*

        for (int i = 0; i < n; i++) {
            ans[i] = arrA[pointerA];
            pointerA++;
        }

        for (int i = n; i < n+m; i++) {
            ans[i] = arrB[pointerB];
            pointerB++;
        }

        Arrays.sort(ans);


        for (int i = 0; i < n + m; i++) {
            bw.write(ans[i] + " ");
        }*/

        br.close();
        bw.close();
    }
}
