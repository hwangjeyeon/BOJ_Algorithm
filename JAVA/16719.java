import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음에는 단어를 사전순으로 뽑아서 기존 문자열과 같은 위치로 더해서 출력하는 문제인줄 알았다.
 * - 하지만 두번째, 세번째 예제는 그것을 의도하는 것이 아니었고 힌트를 찾아본 결과 원하는 결과는 다음과 같았다.
 * - 단어를 하나씩 다 뽑아 출력하려는 문자열에 붙였을 때 나오는 모든 문자열 중에서 사전 순으로 가장 빠른 문자열을 출력하는 거였다..
 * - 그렇기에 방법을 다르게 했어야 했다.
 * - 생각한 방법은 방문 배열을 하나 만들어서 이미 방문한 배열은 참고하지 못하게 하고, 양 끝을 기준으로 하는 재귀함수를 돌려서 푸는 방법이었다
 * - left가 right보다 커지면 함수는 종료한다
 * - 기준은 left이다.
 * - 문자열을 순회하면서 기준인 pivot의 위치의 문자열보다 사전순으로 더 앞선 문자열을 찾는다. 만약 있으면 pivot을 해당 위치 인덱스로 변경한다
 * - 이때 방문하지 않은 인덱스만을 변경하도록 조건에 추가하여야 한다
 * - 순회가 완료되면 해당 인덱스를 방문처리하고 방문 완료된 배열은 모두 StringBuilder에 append한다. 마지막에 "\n"도 append한다.
 * - 재귀는 left자리와 right자리를 이용한다. 왼쪽부터 오른쪽으로 확인하는 경우, 오른쪽부터 왼쪽으로 확인하는 경우에 모든 문자열 경우의 수를 순회하게 된다
 * - left는 pivot+1, right는 pivot-1로 재귀함수를 진행한다
 * - 완성된 결과를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        visited = new boolean[input.length()];
        zoac(input,0, input.length()-1);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
    private static void zoac(String input, int left, int right){
        if(left > right){
            return;
        }
        int pivot = left;

        for (int i = left; i <= right; i++) {
            if(!visited[i] && input.charAt(pivot) > input.charAt(i)){
                pivot = i;
            }
        }
        visited[pivot] = true;

        for (int i = 0; i < input.length(); i++) {
           if(visited[i]){
               sb.append(input.charAt(i));
           }
        }
        sb.append("\n");
        zoac(input, pivot+1, right);
        zoac(input, left, pivot-1);
    }


}

