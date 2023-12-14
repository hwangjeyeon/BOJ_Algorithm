import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 문제 이해 과정에서 힌트를 얻었다.
 * - 일단 오름차순 정렬까지는 생각해낼 수 있었다.
 * - 하지만 이후 배치에 있어서 문제 이해도 제대로 되지 않았고, 문제 해결 구현 방법에 대한 방향도 찾을 수 없었다
 * - 해결 실마리는 집중국의 개수와 센서의 개수가 같을 때에서 찾으면 된다.
 * - 둘의 개수가 같으면 센서 위치마다 집중국을 설치하면 되기 때문에, 수신 가능 영역의 길이의 합은 0이 된다
 * - 하지만 집중국의 개수 K가 센서의 개수 N보다 적으면 최소 1개 이상의 집중국이 다른 센서까지 커버를 해야한다
 * - 이 해결 실마리를 유추해냈다면 그 다음부터는 쉽게 풀린다
 * - 다음과 같이 해결하면 된다. 각 센서 사이의 거리를 모두 구한다
 * - 그 다음 집중국의 개수를 파악한다. N-K가 1이상이면, 센서 사이의 거리 중 가장 큰값부터 차례대로 제거하면 된다
 * - 그곳만 다른 센서를 커버하지 않도록 집중국을 설치하고, 나머지는 두개 이상의 센서를 커버하도록 하면 그 수신 가능 영역의 길이의 합이 최소가 되기 때문이다
 * - 따라서 센서 사이의 거리를 구한 뒤, 내림차순 정렬하고 K-1부터 센서 사이의 거리들이 담긴 리스트의 크기만큼 ans 변수에 담아서 출력하면 정답이 된다
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
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> sensorPosition = new ArrayList<>();
        for(int i=0; i<n; i++){
            sensorPosition.add(Integer.parseInt(st.nextToken()));
        }

        sensorPosition = sensorPosition.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> distance = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            distance.add(sensorPosition.get(i+1) - sensorPosition.get(i));
        }
        distance = distance.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int ans = 0;
        for(int i=k-1; i<distance.size(); i++){
            ans += distance.get(i);
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }

}
