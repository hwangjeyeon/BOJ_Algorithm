import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 트리 문제인 줄 알았으나... 이진 트리의 개념을 활용하여, 재귀와 분할정복으로 푸는 문제였따
 * - 파라미터로는 int left, int right, int depth를 사용한다
 * - 종료조건은 depth가 입력받은 k와 크기가 같아질때이며, 다른 로직 없이 return;으로 종료한다
 * - left와 right는 주어진 입력값의 각 양 끝으로 주어지고, 함수 내에서는 계속 left+right를 2로 나눈 몫으로 중간값을 정해서 계속 쪼개간다.
 * - depth를 인덱스로하는 trees[]배열에 현재 ans[mid]를 넣어준다
 * - 재귀함수는 중간값을 기준으로 왼쪽과 오른쪽을 각각 탐색하는 perfectTree(left, newMid-1, depth+1); perfectTree(newMid+1, right, depth+1);를 사용한다
 * - 이렇게 완성한 trees[]배열을 StringBuilder에 append하고 "\n"도 append한다
 * - 완성한 StringBuilder를 출력한다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */





public class Main {
    static StringBuilder sb;
    static int[] ans;
    static int k;
    static String[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = (int)Math.pow(2,k)-1;
        ans = new int[size];
        trees = new String[size];
        for(int i=0; i<size; i++){
            ans[i] = Integer.parseInt(st.nextToken());
        }
        perfectTree(0, size-1, 0);
        sb = new StringBuilder();

        for(int i=0; i< size-1; i++){
            if(trees[i] != null){
                sb.append(trees[i]).append("\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void perfectTree(int left, int right, int depth){
        if(depth == k){
            return;
        }
        int newMid = (right+left)/2;
        if(trees[depth]==null){
            trees[depth] = ans[newMid] + " ";
        }else{
            trees[depth] += ans[newMid] + " ";
        }

        perfectTree(left, newMid-1, depth+1);
        perfectTree(newMid+1, right, depth+1);
    }


}
