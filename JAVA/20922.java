import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 투포인터를 이용하는 문제다.
 * 2. 또한 이전에 풀었던 회전초밥 문제와 게으른 백곰 문제와 유사하다. 최대 숫자까지 각 인덱스를 숫자의 개수로 판단하는 배열을 하나 만든다
 * 3. 계수정렬처럼 카운팅해서 개수 상태를 저장한다
 * 4. 이제 처음부터 arr 배열을 순회하면서 count++를 해준다. 그리고 num[arr[i]]위치의 개수값도 증가시킨다
 * 5. 이어서 만약 num[arr[i]]가 k보다 크다면 그동안 순회해서 start에 있는 개수를 줄이고 count도 줄인다
 * 6. 또한 start역시 ++해준다. 만약 start와 i가 같으면 탈출한다
 * 7. 이후에 count와 max값중 최댓값을 max에 넣어준다. 
 * 8. 모든 순회가 끝나면 max를 출력한다.
 *
 * 해결방법:
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int[] num = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            count++;
            num[arr[i]]++;
            while(num[arr[i]] > k){
                num[arr[start]]--;
                count--;
                start++;
                if(start == i){
                    break;
                }
            }
            max = Math.max(max, count);
        }
        bw.write(max+"");




        br.close();
        bw.close();
    }

}

