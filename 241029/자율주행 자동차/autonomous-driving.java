import java.io.*;
import java.util.*;

class Car{

    int y;
    int x;
    int d;
    
    public Car(int y, int x, int d){
        this.y = y;
        this.x = x;
        this.d = d;
    }

}


public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        visited[startY][startX] = true;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }

        
        Car car = new Car(startY, startX, d);
        while(true){
            boolean isFind = false;
            
            for(int i=0; i<4; i++){
                
                if(rotateChk(car)){
                    isFind = true;
                    ans++;
                    break;
                }
            }
            if(isFind){
                continue;
            }

            boolean isOk = false;
            // 후진 로직
            if(rearChk(car)){
                isOk = true;
            }

            //종료 로직
            if(!isOk){
                break;
            }

        }

        System.out.print(ans);
    }

    // 좌회전 했을 때의 방향에 해당하는 위치
    private static boolean rotateChk(Car car){
        int y;
        int x;
        int d;
        if(car.d == 0){
            y = car.y;
            x = car.x-1;
            d = 3;
        }else if(car.d == 1){
            y = car.y-1;
            x = car.x;
            d = 0;
        }else if(car.d == 2){
            y = car.y;
            x = car.x+1;
            d = 1;
        }else{
            y = car.y+1;
            x = car.x;
            d = 2;
        }
        car.d = d;
        if(!visited[y][x] && arr[y][x] != 1){
            car.y = y;
            car.x = x;
            
            visited[y][x] = true;
            return true;
        }

        return false;
    }

    private static boolean rearChk(Car car){
        int y;
        int x;
        if(car.d == 0){
            y = car.y+1;
            x = car.x;
        } else if(car.d == 1){
            y = car.y;
            x = car.x-1;
        }else if(car.d == 2){
            y = car.y;
            x = car.x+1;
        }else{
            y = car.y-1;
            x = car.x;
        }

        if(arr[y][x] != 1){
            car.y = y;
            car.x = x;

            return true;
        }
        return false;
    }

}