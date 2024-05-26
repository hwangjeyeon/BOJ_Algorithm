import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 햄버거를 먹을 수 있는 사람의 최대 수는 자신의 왼쪽방향으로 k번째 수부터 먹는 경우다. 만약 사람이거나 햄버거를 먹은 경우 그 이전을 살펴보고, 만약 왼쪽에 없다면 오른쪽은 반대로 1번째부터 k번째까지 확인한다
 * 2. 입력값을 봤을 때, 이런식으로 탐색을 해도 그리디하게 탐색할 수 있으므로, 시간초과가 발생하지 않는다.
 * 3. 확인하게 되면 count++를 해주고 break로 탈출하고 만약 왼쪽 방향에서 발견할 경우 isFind를 true로 바꿔서 오른쪽 탐색을 하지 않도록 한다
 * 4. 입력 문자열을 split을 배열로 담아 만약 햄버거를 먹었으면 E으로 바꾸고 P일때만 탐색을 진행하도록 한다.
 * 5. 순회 후, 완성한 count를 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 * 시간복잡도: O(n*k)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split("");
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isFind = false;
            if(input[i].equals("P")){
                for (int j = k; j > 0; j--) {
                    if(i-j >= 0 && input[i-j].equals("H")){
                        input[i-j] = "E";
                        count++;
                        isFind = true;
                        break;
                    }
                }
                if(!isFind){
                    for (int j = 1; j <= k; j++) {
                        if(i+j < n && input[i+j].equals("H")){
                            input[i+j] = "E";
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }



}

