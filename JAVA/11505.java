import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 기존 구간합 세그먼트 트리와 비슷하면서 몇가지 변화를 주어야하는 문제다
 * 2. 곱셈이기 떄문에 0을 리턴할 경우 이후에 나오는 모든 곱이 0으로 나오는 문제가 발생한다
 * 3. 따라서 이점을 유의해서 수정을 해야한다
 * 4. 먼저 기본적으로 init과 multiply할때, 재귀로 호출되는 값들은 곱셈을 진행해주고, 모두 모듈러 연산을 해준다
 * 5. update의 반환값을 long으로 변경해주었따
 * 6. 범위를 벗어나면 tree[node]를 리턴한다
 * 7. 또한 구간합에서는 차이를 구했었는데, 여기서는 변경하려는 값을 인수로 그대로 받아 리프노드일 경우, 해당 노드에 인수 val를 넣어준다. 나머지는 그대로 진행한다 
 * 8. 곱셈에서는 한가지를 수정해주어야한다. 만약 범위를 벗어나는 경우 합산의 경우 0을 리턴했는데 여기서는 1을 리턴해주어야 한다
 * 9. 위 조건을 잘 마치면 쿼리에 대해 올바른 결과를 응답할 수 있다. 
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(logn)
 *
 */
class SegmentTree{
    long[] tree;
    int treeSize;

    public SegmentTree(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = (int)Math.pow(2, h+1);
        tree = new long[treeSize];
    }

    public long init(long[] arr, int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }
        return tree[node] = (init(arr, node*2, start, (start+end)/ 2)
                * init(arr, node*2+1, (start+end)/2 + 1, end)) % 1000000007;
    }

    public long update(int node, int start, int end, int idx, long val){
        if(idx < start || idx > end){
            return tree[node];
        }

        if(start == end){
            return tree[node] = val;
        }

        return tree[node] = (update(node*2, start, (start+end)/2, idx, val) * update(node*2+1, (start+end)/2+1, end, idx, val)) % 1000000007;
    }

    public long multiply(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 1;
        }
        if(left <= start  && end <= right){
            return tree[node];
        }

        return (multiply(node*2, start, (start+end)/2,left, right)
                * multiply(node*2+1, (start+end)/2+1, end, left, right)) % 1000000007;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        SegmentTree tree = new SegmentTree(n);
        long[] arr = new long[n+1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        tree.init(arr, 1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(cmd == 1){
                arr[a] = b;
                tree.update(1,1,n, a, b);
            }else{
                bw.write(tree.multiply(1,1,n,a,(int)b)+ "\n");
            }
        }


        br.close();
        bw.close();
    }
}

