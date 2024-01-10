import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 이전에 만들었던 이분 탐색 클래스를 활용하여 문제를 풀었다.
 * - 두개의 리스트를 만들어서 각각 저장하고, 첫번째 리스트는 오름차순 정렬해준다.
 * - 이분 탐색 클래스에 첫번째 리스트를 넣어서 초기화해주고, 찾으려는 값을 반복문을 통해 두번째 리스트의 있는 값들을 넣어준다
 * - 이렇게 이분탐색 메소드를 이용해 정답을 리턴받아 StringBuilder에 저장해주고 테스트케이스 종료전에 출력해준다.
 * 
 * 
 * 시간복잡도: O(n*T)
 * 공간복잡도: O(n)
 *
 */

class BinarySearch{
    private int left;
    private int right;
    private final List<Integer> values;

    public BinarySearch(int size, List<Integer> list) {
        this.left = 0;
        this.right = size-1;
        this.values = list;
    }

    public int BinarySearchRecursive(int left, int right, int findValue){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(values.get(mid) < findValue){
            return BinarySearchRecursive(mid+1, right, findValue);
        }else if(values.get(mid) > findValue){
            return BinarySearchRecursive( left, mid-1, findValue);
        }else{
            return values.get(mid);
        }
    }


}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<T; i++){
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            List<Integer> listN = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                listN.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(listN);

            int m = Integer.parseInt(br.readLine());
            List<Integer> listM = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                listM.add(Integer.parseInt(st.nextToken()));
            }

            BinarySearch binarySearch = new BinarySearch(listN.size(),listN);
            for(int j=0; j<m; j++){
                if(binarySearch.BinarySearchRecursive(0, listN.size()-1,listM.get(j)) == -1){
                    sb.append(0).append("\n");
                }else{
                    sb.append(1).append("\n");
                }
            }

            bw.write(sb.toString());
        }


        br.close();
        bw.close();
    }

}
