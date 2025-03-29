import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 각 거리간의 최대 공약수를 구하면 되는 문제이다
 * - 처음에는 각 거리간이 아니라, 거리마다의 최대 공약수를 고르도록 구현하였다
 * - 하지만 이 방법에서는 원하는 답을 찾을 수 없었고, 힌트를 참고해서 각 거리간의 최대 공약수를 구하면 된다는 해답을 찾게 되었다.
 * - 특히 최대 공약수 0은 모든 수의 배수이므로 유클리드 호제법에 따라 이것을 활용한다면, 각 거리간의 최대 공약수를 찾을 수 있게 된다
 * - 최종 정답 출력을 위해 가장 멀리있는 가로수의 위치와 가장 가까이 있는 가로수의 위치를 뺀다음 최대 공약수로 나눠주고 그 몫을 가로수의 개수 + 1로 빼준다
 * - 이렇게 나온 최종 정답을 출력한다.
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
        List<Long> streetTrees = new ArrayList<>();
        for(int i=0; i<n; i++){
            streetTrees.add(Long.parseLong(br.readLine()));
        }

        long gcd = getGcd(streetTrees, n);

        bw.write((streetTrees.get(n-1) - streetTrees.get(0)) / gcd - streetTrees.size() + 1 +"");





        br.close();
        bw.close();
    }

    private static long getGcd(List<Long> streetTrees, int n) {
        List<Long> betweenDistances = new ArrayList<>();

        long min = streetTrees.get(1) - streetTrees.get(0);
        betweenDistances.add(min);
        for(int i = 1; i< n -1; i++){
            long distance = streetTrees.get(i + 1) - streetTrees.get(i);
            betweenDistances.add(distance);
            if(min > distance){
                min = distance;
            }
        }
        long gcd = 0;
        for(int i = 0; i< n -1; i++){
            long a = betweenDistances.get(i);
            long b = gcd;
            while(b!=0){
                long r = a % b;
                a = b;
                b = r;
            }
            gcd = a;
        }
        return gcd;
    }

}
