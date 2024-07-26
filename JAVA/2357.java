import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 기존 세그먼트 트리를 활용하는 문제다
 * 2. 이 문제도 이전 합과 곱과는 다르게 변형해야한다. 최소 트리와 최대 트리를 하나씩 만들어둔다
 * 3. 각각에 대해 따로 초기화와 검색을 할 수 있도록 메소드를 만든다. 
 * 4. Math.min과 Math.max를 사용하여 트리를 구성하며, find에서 범위를 벗어나는경우 Integer.MAX_VALUE나 Integer.MIN_VALUE를 리턴해준다
 * 
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(logn)
 *
 */
class SegmentTree{
    int[] minTree, maxTree;
    int treeSize;

    public SegmentTree(int arrSize){
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = (int)Math.pow(2, h+1);
        minTree = new int[treeSize];
        maxTree = new int[treeSize];
    }

    public int minTreeInit(int[] arr, int node, int start, int end){
        if(start == end){
            return minTree[node] = arr[start];
        }

        return minTree[node] = Math.min(minTreeInit(arr, node * 2, start, (start + end) / 2),
                minTreeInit(arr, node * 2 + 1, (start + end) / 2 + 1, end));
    }

    public int maxTreeInit(int[] arr, int node, int start, int end){
        if(start == end){
            return maxTree[node] = arr[start];
        }

        return maxTree[node] = Math.max(maxTreeInit(arr, node*2, start, (start+end)/2),
                maxTreeInit(arr, node*2+1, (start+end)/2+1, end));
    }

    public int minFind(int node, int start, int end, int left, int right){
        if(right < start || left > end){
            return Integer.MAX_VALUE;
        }

        if(left <= start && right >= end){
            return minTree[node];
        }

        return Math.min(minFind(node*2, start, (start+end)/2, left, right),
                minFind(node*2+1, (start+end)/2+1, end, left, right));
    }

    public int maxFind(int node, int start, int end, int left, int right){
        if(right < start || left > end){
            return Integer.MIN_VALUE;
        }
        if(left <= start && right >= end){
            return maxTree[node];
        }
        return Math.max(maxFind(node*2, start, (start+end)/2, left, right),
                maxFind(node*2+1, (start+end)/2 + 1, end, left, right));
    }


}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segmentTree = new SegmentTree(n);
        segmentTree.minTreeInit(arr, 1,1,n);
        segmentTree.maxTreeInit(arr, 1, 1,n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(segmentTree.minFind(1,1,n,a,b) + " " + segmentTree.maxFind(1,1,n, a,b) + "\n");
        }


        br.close();
        bw.close();
    }
}

