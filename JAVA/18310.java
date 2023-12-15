import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 처음에는 평균값을 구한다음 평균과의 차를 생각해서 풀었으나 틀렸다
 * - 처음 문제를 이해했을 때부터, 양 끝은 절대로 설치할 위치가 될 수 없다는 것을 알게 되었고 중간 쯤에 설치되겠다고 생각하였다.
 * - 따라서 중간에 설치하는 것이 정답인데 홀수면 n/2하면 되나 짝수는 그 값이 더 작은 경우를 구해야하므로 n/2-1를 하면 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> house = new ArrayList<>();

        for(int i=0; i<n; i++){
            house.add(Long.parseLong(st.nextToken()));
        }

        house = house.stream().sorted().collect(Collectors.toList());

        if(n%2 == 0){
            bw.write(house.get(n/2-1) + "");
        }else{
            bw.write(house.get(n/2) + "");
        }


        br.close();
        bw.close();
    }

}
