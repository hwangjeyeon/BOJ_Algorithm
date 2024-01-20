import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 무엇을 이분탐색할지만 정하면 되는 문제였다...
 * - 조금만 더 고민을 해볼 걸 그랬다. 무엇을 이분탐색할지 고민했다면 힌트를 보지않고 풀지 않았을까 하는 아쉬움이 있다
 * - 두 지점 사이의 거리를 이분탐색하면 되는 문제이다.
 * - 리스트의 맨 처음을 이전 지점의 좌표로 하고, 1번째 인덱스부터 순회한다. 이때 count는 첫번째 지점에 무조건 설치한다고 가정하기 때문에 1로 초기화한다
 * - 현재 인덱스와 이전 지점의 좌표 사이의 거리가 mid보다 작으면 continue 한다.
 * - 왜냐하면 현재 지점에는 공유기를 설치하지 않을 것이기 때문이다
 * - 즉 현재의 mid는 설치한 공유기 사이의 최소한의 거리를 말한다
 * - 만약 mid보다 크거나 같으면 이전 지점의 좌표를 현재 리스트 인덱스의 값으로 하고 count++를 증가시킨다
 * - 이제 count가 c보다 작으면 right=mid-1로 범위를 축하고 반대면 left=mid+1로 범위를 확대한 뒤 ans=mid를 넣는다
 * - 이렇게 완성한 ans를 출력하면 정답이 된다.
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
        int c = Integer.parseInt(st.nextToken());
        List<Integer> house = new ArrayList<>();
        int left = -1;
        int right = 1000000001;
        for(int i=0; i<n; i++){
            house.add(Integer.parseInt(br.readLine()));
        }

        house = house.stream().sorted().collect(Collectors.toList());
        long ans = 0;
        while(left <= right){
            int mid = (left+right) / 2;
            int count = 1;
            int tmpPos = house.get(0);
            for(int i=1; i<n; i++){
                if(house.get(i) - tmpPos < mid){
                    continue;
                }

                count++;
                tmpPos = house.get(i);
            }
            if(count < c){
                right = mid -1;
            }else{
                left = mid + 1;
                ans = mid;
            }

        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }

}
