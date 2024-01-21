import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 이분탐색 및 매개변수탐색으로 풀었다
 * - 주의사항은 맨 처음인 0번째 좌표와 고속도로의 최대 길이를 추가해줘야한다.
 * - 휴게소가 설치된 첫번째와 처음 사이의 거리와 마지막으로 설치된 휴게소와 고속도로의 끝까지의 길이도 고려해야하기 때문이다
 * - 최소값은 1, 최댓값은 max로 해서 휴게소의 위치를 기준으로 이분탐색한다
 * - 이후 평범한 매개변수탐색을 진행하면 되는데... count를 증가시킬 로직만 구현하면 된다
 * - 구현한 로직은 현재 위치와 이전 위치의 차이 (restAreaPost.get(i)-restAreaPost.get(i-1) - 1)에 mid로 나눠준 몫을 count에 더해주면 된다
 * - 이것은 두 지점 사이의 차이 사이에 설치할 수 있는 휴게소의 개수를 의미한다
 * - mid만큼씩 두 지점 사이에 휴게소를 설치한다고 했을 때, 몇개를 배치할 수 있을까를 생각해서 푸는 문제였다.
 * - 구현 로직은 힌트를 참고했다... 쉽지 않은 문제였다
 *
 * 시간복잡도: O(logn)
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
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> restAreaPost = new ArrayList<>();

        int min = 1;
        int max = l;
        restAreaPost.add(0);
        for(int i=0; i<n; i++){
            restAreaPost.add(Integer.parseInt(st.nextToken()));
        }
        restAreaPost.add(l);
        restAreaPost = restAreaPost.stream()
                .sorted()
                .collect(Collectors.toList());


        while(min <= max){
            int mid = (min + max) / 2;
            int count = 0;
            for(int i=1; i<restAreaPost.size(); i++){
                count += (restAreaPost.get(i)-restAreaPost.get(i-1) - 1) / mid;
            }
            if(count > m){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

}
