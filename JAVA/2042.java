import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 세그먼트 트리를 학습하며 풀어본 문제다. 이후 다시 복습하며, 혼자 구현하고 풀어볼 계획이다.
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(logn)
 *
 */
class SegmentTree{
    long[] tree;
    int treeSize;

    public SegmentTree(int arrSize){
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = (int) Math.pow(2, h+1);
        tree = new long[treeSize];
    }

    public long init(long[] arr, int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }
        return tree[node] = init(arr, node*2, start,(start + end) / 2 )
                + init(arr, node*2 + 1, (start + end)/2+1, end);
    }

    public void update(int node, int start, int end, int idx, long diff){
        if(idx < start || end < idx){
            return;
        }

        tree[node] += diff;
        if(start != end){
            update(node*2, start, (start + end) / 2, idx, diff);
            update(node*2+1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    public long sum(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }

        if(left <= start && end <= right){
            return tree[node];
        }

        return sum(node*2, start, (start + end) / 2, left, right)
                + sum(node*2+1, (start + end) / 2 + 1, end, left, right);
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
        long[] arr = new long[n+1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        SegmentTree seg = new SegmentTree(n);
        seg.init(arr,1,1,n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                seg.update(1, 1, n,b, c-arr[b]);
                arr[b] = c;
            }else{
                long sum = seg.sum(1, 1, n, b, (int)c);
                bw.write(sum + "\n");
            }
        }

        br.close();
        bw.close();
    }
}

