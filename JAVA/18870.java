import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 값 / 좌표 압축에 대한 공부를 먼저 진행했다.
 * - 똑같은 배열을 만든 뒤, 오름차순 정렬 후에 중복된 요소를 제거한다면 그 값이나 좌표가 압축된 결과를 가질 수 있다
 * - 이와 같은 알고리즘은 수의 범위가 매우 큰 상황에서 값에 무관하게 좌표들 사이의 대소만 알면 될 때, 좌표 압축을 이용하여 수의 범위를 줄일 수 있다
 * - 즉 어떻게 보면 1차원 배열에서는 하나의 순위 리스트를 만든다고 생각하면 된다. 개수 범위가 아닌 개수 범위 안에 있는 수의 크기 범위가 넓은 경우에 수들의 대소만 구분해야한다고 하면, 이 방법을 사용하면 된다.
 * - 시간 복잡도를 신경 써줘야 한다.
 * - 자바에서 Arrays.sorted를 할 경우 이중 피벗 퀵 정렬을 사용하기에 평균 시간 복잡도는 O(nlogn)이지만 최악의 경우 O(n^2)으로 갈 수 있다
 * - 자바에서 Arrays.stream(sorted).sorted()를 사용할 경우 병합 정렬을 사용하기에 평균 시간 복잡도나 최악의 시간복잡도 모두 O(nlogn)이다.
 * - 따라서 stream을 사용하였다.
 * - 그 다음 처음은 이중 for문을 사용하여 arr1과 sorted 배열이 일치하는 경우 출력하도록 풀었으나, O(n^2)이 나와 시간 초과 문제가 발생하였다
 * - 따라서 선택한 두번째 방법은 Map을 사용하는 것이다. 이때 나는 stream에서 distinct를 사용했었다
 * - stream.distinct()는 시간 복잡도가 O(n)이 나오기에 전체 시간복잡도에 큰 영향은 주지 않았다
 * - 하지만 Map을 사용한다면 굳이 사용할 필요가 없기 때문에 distinct를 빼고 map을 사용하여 중복을 제거하였다
 * - 이때 원소 값을 key로 하고, value는 이미 오름차순 정렬이 되어 있고, 그 수보다 작은 수의 개수는 해당 수의 인덱스 값과 같으므로, key를 한번 넣을 때마다 일단 값을 넣고 값을 증가시켜주었다 (후위 연산자).
 * - + 연산에서 발생하는 시간 낭비를 해결해주기 위해 StringBuilder를 사용하였고, arr1를 순회하여, 해당 배열의 값과 map의 key를 매치시켜 해당 value를 StringBuilder에 추가한다
 * - 최종적으로 완성된 StringBuilder를 출력한다.
 * 
 * - 좋은 개념 공부를 할 수 있는 문제였다. 상위 문제에서 주로 2차원 배열로 나온다는데, 이후에 지금 배운 개념을 토대로 공부해서 풀 계획이다.
 * - 또한 시간 복잡도에 대해 공부를 더 할 수 있는 좋은 문제 였다. 정렬과 stream 사용 그리고 map사용과 StringBuilder까지 시간복잡도 고려를 다방면으로 해볼 수 있었던 좋은 문제
 * - 정렬 개념과 각 라이브러리 정렬 시간 복잡도에 대한 공부를 더 진행할 계획이다.
 * 
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] arr1 = new long[n];
        long[] sorted;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr1[i] = Long.parseLong(st.nextToken());
        }

        sorted = arr1.clone();
        sorted = Arrays.stream(sorted).sorted().toArray();
        Map<Long, Integer> ans = new HashMap<>();
        int count=0;
        for(long i : sorted){
            if(!ans.containsKey(i)){
                ans.put(i, count++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(long i : arr1){
            sb.append(ans.get(i)).append(" ");
        }

        bw.write(sb.toString());



        br.close();
        bw.close();
    }

}
