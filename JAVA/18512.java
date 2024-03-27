import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 시뮬레이션을 돌려보면 되는 문제이다.
 * 2. 이 문제는 카카오에서 나온 두 큐 문제랑 비슷하다
 * 3. 한쪽이 더 크면 그쪽에다가 주어진 조건만큼 더해준다
 * 4. 같아지면 값을 출력하고 break해서 탈출한다
 * 5. 만약 어느 한 지점이 n^2만큼 순회했을 때, 결과가 나오지 않는다면 그것은 나올 수 없다는 의미이다.
 * 6. 두 큐 문제에서도 비슷하게 해서 4n을 종료조건으로 삼았고, 여기서는 n^2을 종료조건으로 삼았다
 * 7. 입력의 최대가 100이니까 1만을 넘기는 순간이 나올 경우 -1을 출력하고 break로 탈출한다.
 *
 *
 *
 * 시간복잡도: O(p1*p1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        while(true){
            if(p1<p2){
                p1 += x;
            }else if(p1 > p2){
                p2 += y;
            }else{
                bw.write(p1+"");
                break;
            }

            if(p1 > 10000 || p2 > 10000){
                bw.write("-1");
                break;
            }
        }
        br.close();
        bw.close();
    }

}

