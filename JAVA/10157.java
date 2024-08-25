import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 예외 처리를 몇가지 하는 브루트포스 문제다
 * 2. 먼저 k가 c*r보다 큰 경우는 무조건 0이다.
 * 3. 이어서 아닌 경우 count가 k보다 큰동안 주어진 네개의 방향대로 탐색을 시작한다
 * 4. 정답이 될 x,y 좌표도 가지고 있으며, 탐색 한도의 기준이 될 row, column의 각 pivot도 c,r로 초기화한다
 * 5. column은 0 row는 1로 초기화하며, count도 0으로 초기화한다
 * 6. column증가 -> row 증가 -> column 감소 -> row 감소 순으로 탐색을 진행한다
 * 7. 각 탐색마다 count 값을 증가시켜주며, column 값과 row 값도 변화시켜준다
 * 8. 각 탐색마다 만약 count가 k가 되면 반복문을 탈출한다
 * 9. 매 탐색의 끝에 rowPivot과 columnPivot을 -2씩 감소시켜준다
 * 10. -2씩 감소시키는 이유는 사각형의 가로 세로의 각 한줄씩 양 옆 모서리를 탐색했기 때문이다
 * 11. 이후 row와 column을 출력하는데 만약 column이 0이라면 탐색을 안했다는 것이므로 첫번째 위치인 1,1 출력을 위해 column을 1로 초기화하여 출력한다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(c*r)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        if(c*r < k){
            bw.write("0");
        }else{
            int count = 0;
            int row = 1;
            int column = 0;
            int rowPivot = c;
            int columnPivot = r;
            while(count < k){

                for (int i = 0; i < columnPivot; i++) {
                    count++;
                    column++;
                    if(count == k){
                        break;
                    }
                }


                if(count == k){
                    break;
                }

                for (int i = 0; i < rowPivot-1; i++) {
                    count++;
                    row++;
                    if(count == k){
                        break;
                    }
                }


                if(count == k){
                    break;
                }


                for (int i = columnPivot-2; i >= 0; i--) {
                    count++;
                    column--;
                    if(count == k){
                        break;
                    }
                }


                if(count == k){
                    break;
                }

                for (int i = rowPivot-3; i >= 0; i--) {
                    count++;
                    row--;
                    if(count == k){
                        break;
                    }
                }
                columnPivot-=2;
                rowPivot-=2;
            }

            if(column == 0){
                column = 1;
            }

            bw.write(row + " " + column);
        }
        br.close();
        bw.close();
    }
}

