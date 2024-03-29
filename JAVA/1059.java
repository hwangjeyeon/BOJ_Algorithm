import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 *
 *
 * 문제 해결:
 * 1. 입력받은 문자열을 오름차순으로 정렬하였다
 * 2. 이어서 시작지점과 끝 지점을 두고 그 구간 내에서 해당하는 원소들을 탐색하도록 설정하는 과정을 거쳐야한다
 * 3. 시작 지점과 끝 지점은 start는 0 end는 1001로 설정해두었다
 * 4. 이어서 배열을 순회하는데 n을 기준으로 가장 가까운 지점이 되도록 start와 end를 설정한다
 * 5. 만약 현재 배열의 값이 n보다 작다면 start가 현재 배열보다 작으면 start에 현재 배열을 넣어준다
 * 6. 반대도 비슷하다 현재 배열의 값이 n보다 크면 end가 현재 배열보다 클 경우 end에 현재 배열을 넣어준다
 * 7. 만약 같다면 현재 배열의 위치에 n이 있는 것이므로 문제의 조건을 위배해서 그대로 start와 end, n을 -1로 처리한 뒤 break로 순회 종료하면 된다.
 * 8. 이제 주어진 start와 end를 활용하여 순회하여 count를 한다
 * 9. start+1부터 n까지 순회하면서 n부터 end-1까지 순회하는동안 i와 j가 같지 않은경우 count를 증가시켜준다
 * 10. 완성한 count를 출력하면 정답이 된다.
 * 
 *
 * 시간복잡도: O((n-start) * (end - n))
 * 공간복잡도: O(l)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = 1001;
        for (int i = 0; i < l; i++) {
            if(arr[i] < n){
                if(arr[i] > start){
                    start = arr[i];
                }
            }else if(arr[i] > n){
                if(arr[i] < end){
                    end = arr[i];
                }
            }else{
                start = -1;
                end = -1;
                n = -1;
               break;
            }
        }


        for (int i = start+1; i <= n; i++) {
            for (int j = n; j <= end - 1; j++) {
                if(i!=j){
                    count++;
                }
            }
        }
        bw.write(count+"");

        br.close();
        bw.close();
    }

}
