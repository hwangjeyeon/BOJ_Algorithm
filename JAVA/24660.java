import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 분할정복의 개념과 감을 다시한번 확인할 수 있게 해준 문제
 * - 4개로 분할하기까지는 생각했으나, 선뜻 구현이 되지 않았다.
 * - 기존 색종이 만들기 분할정복 알고리즘에서 정렬 기능만 추가하면 되는 쉬운 문제였으나, 아직 알고리즘 개념에 대해 미숙해서 힌트를 참고하였다
 * - 재귀에 대한 개념도 더 공부해야겠다는 생각이 든다. 이것도 현재 계획중...
 * - 재귀의 종료 조건은 크기가 1이 되는 순간 즉 2보다 작아지는 순간에 그 배열의 값을 전달해주면된다
 * - 그때의 값을 리스트에 넣어주고 4등분한 좌표들이 전부 리스트에 들어오면 오름차순 정렬해서 두번째로 큰 값인 1번 인덱스의 값을 리턴하면 된다
 * - 이렇게 하면 각 사분면에서의 두번째 값들간의 정렬이 최종적으로 진행되고, 다시한번 이중에서 두번째로 큰 값을 리턴한 뒤, 이 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
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
            return arr[x][y];
        }

        int newSize = n/2;
        List<Integer> tmp = new ArrayList<>();

        tmp.add(partition(newSize, x, y));
        tmp.add(partition(newSize, x+newSize, y));
        tmp.add(partition(newSize, x, y + newSize));
        tmp.add(partition(newSize, x + newSize, y + newSize));

        tmp = tmp.stream().sorted().collect(Collectors.toList());


        
        return tmp.get(1);
    }


}
