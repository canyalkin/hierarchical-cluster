package com.clustering.HAC;

import java.util.ArrayList;
import java.util.List;

public class Cluster implements Cloneable{
	
	private List<Integer> items;
	public Cluster() {
		items=new ArrayList<Integer>();
	}

	public void addItem(int i){
		boolean duplicate=false;
		for (int j = 0; j < items.size(); j++) {
			if(items.get(j)==i){
				duplicate=true;
				break;
			}
		}
		if(!duplicate)
			items.add(i);
	}
	
	public int clusterSize(){
		return items.size();
	}
	
	public Integer getItem(int index){
		return items.get(index);
	}

	
	@Override
	public String toString() {
		return "Cluster [items=" + items + "]";
	}
	
	@Override
	public Cluster clone() throws CloneNotSupportedException {
		Cluster c=new Cluster();
		for (int j = 0; j < items.size(); j++) {
			c.addItem(new Integer(items.get(j)));
		}
		return c;
	}
	
	
	
}
