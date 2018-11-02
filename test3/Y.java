package test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Y {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Top> list = new ArrayList<>();
		boolean[] b = new boolean[4];
		for(int i = 0; i < n; i++){
			int cost = in.nextInt();
			list.add(new Top());
			list.get(i).setCost(cost);
		}
		for(int i = 0; i < n; i++){
			int cB = in.nextInt();
			b[cB] = true;
			list.get(i).setColorBefore(cB);
		}
		for(int i = 0; i < n; i++){
			int cA = in.nextInt();
			b[cA] = true;
			list.get(i).setColorAfter(cA);
		}
		Collections.sort(list, Comparator.comparing(Top::getCost));
		int m = in.nextInt();
		for(int i = 0; i < m; i++){
			int color = in.nextInt();
			boolean check = false;
			if(b[color]){
				if(!list.isEmpty()){
					for(int j = 0; j < list.size(); j++){
						if(list.get(j).getColorBefore() == color || list.get(j).getColorAfter() == color){
							System.out.print(list.get(j).getCost() + " ");
							list.remove(j);
							check = true;
							break;
						}
					}
				} else {
					check = false;
				}
			}
			if(!check){
				System.out.print(-1 + " ");
			}
		}
	}
}

class Top{
	private int cost;
	private int colorBefore;
	private int colorAfter;
	
	public Top(){
		
	}
	
	public Top(int cost, int colorBefore, int colorAfter){
		this.cost = cost;
		this.colorAfter = colorAfter;
		this.colorBefore = colorBefore;
	}

	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getColorBefore() {
		return colorBefore;
	}

	public void setColorBefore(int colorBefore) {
		this.colorBefore = colorBefore;
	}

	public int getColorAfter() {
		return colorAfter;
	}

	public void setColorAfter(int colorAfter) {
		this.colorAfter = colorAfter;
	}
	
	
}
