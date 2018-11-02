package test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class C {
    static boolean road[] = new boolean [1005];
    static Vector<Integer> pos = null;
    static ArrayList<Vector<Integer>> a = null;
    static int n, k, m;
    static void DFS(int i){
        boolean flag[] = new boolean [1005];
        Arrays.fill(flag, true);
        flag[i] = false;
        Stack<Integer> st = new Stack<Integer>();
        st.push(i);
        while(!st.empty()){
            int u = st.peek();
            st.pop();
            for(int k = 0; k < a.get(u).size(); k++){
                    int v = a.get(u).get(k);
                    if(flag[v]){
                        flag[v] = false;
                        st.push(v);
                    }
            }
        }
        for(int j = 1; j <= n; j++){
            if(flag[j]) road[j] = false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Arrays.fill(road, true);
        pos = new  Vector<>();
        a = new ArrayList<Vector<Integer>>();
        
        int t, t1, t2;
        k = in.nextInt();
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i<=n+2; i++) a.add( new Vector<Integer>());
        for(int i = 1; i <= k; i++){
            t = in.nextInt();
            pos.add(t);
        }
        for(int i = 1; i <= m; i++){
            t1 = in.nextInt();
            t2 = in.nextInt();
            a.get(t1).add(t2);
        }
        for(int i = 0; i < k; i++){
            DFS(pos.get(i));
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(road[i]) count++;
        }
        System.out.println(count);
    }
}
