import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 이전 24660문제와 비슷한 문제이다
 * - 이전에 오름차순 정렬했던 것을 내림차순만 해주면 된다.
 * - 4등분해서 분할탐색을 하고, 크기가 1 이하로 내려가면 해당 위치의 배열 값을 반환한다.
 * - 이렇게 반환된 배열들의 값을 내림차순 정렬한 뒤, 두번째로 큰 값인 1번째 인덱스의 값을 리턴한다
 * - 최종적으로 나온 값을 출력한다.
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = partition(n, 0,0);
        bw.write(ans+"");


        br.close();
        bw.close();
    }

    public static int partition(int n, int x, int y){
        if(n < 2){
            return arr[y][x];
        }

        int newSize = n/2;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(partition(newSize, x,y));
        tmp.add(partition(newSize, x+newSize,y));
        tmp.add(partition(newSize, x,y+newSize));
        tmp.add(partition(newSize, x+newSize,y+newSize));

        tmp = tmp.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return tmp.get(1);
    }



}
