import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 범위 떄문에 이분탐색을 해야한다
 * 2. 이 문제는 인덱스를 기준으로 이분탐색을 해야하며, 범위의 시작값과 끝 값에 대해서 이분탐색을 해야한다
 * 3. 따라서 오름차순 정렬을 미리 해둔뒤 이분탐색을 하며, 시작값 탐색과 끝값 탐색을 다르게 이분탐색한다
 * 4. left는 0, right n-1으로 초기화하며, 시작값에 대한 탐색은 범위 시작값보다 중간값 원소가 더 작은지 확인하고 작다면 left의 범위를 좁혀서 탐색을 이어간다.
 * 5. 만약 크거나 같다면 right의 범위를 좁힌다
 * 6. 반대는 arr[mid]의 값보다 now가 큰지 본다. 크다면 right를 mid-1로 범위를 좁히며, 작거나 같다면 mid+1로 좁힌다
 * 7. 이렇게 완성한 최적의 시작/끝 인덱스를 반환값을 받으며, 끝 - 시작값을 출력한다.
 * 8. 시작 인덱스 반환은 left, 끝 인덱스 반환은 right+1을 해준다. right+1을 하는 이유는 인덱스가 0부터 시작할 경우, 0~2일때 정답출력이 2가 되는 잘못된 출력이 발생하기 때문이다
 * 9. 이렇게 한다면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(2 * logn)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ansStart= indexBinarySearch(a, 1, n);
            int ansEnd = indexBinarySearch(b, 2, n);
            bw.write((ansEnd - ansStart) + "\n");
        }

        br.close();
        bw.close();
    }

    private static int indexBinarySearch(int now, int type, int n) {
        int left = 0;
        int right = n-1;
        if(type == 1){
            while(left <= right){
                int mid = (left + right) / 2;
                if(arr[mid] < now){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }

            return left;
        }
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > now){
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return right+1;
    }

}

