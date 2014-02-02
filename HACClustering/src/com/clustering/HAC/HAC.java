package com.clustering.HAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HAC {
	
	private final double [][]similartiyMatrix;
	private int itemCount=0;
	private final Proximity proximity;
	private Dendrom dendrom;
	
	private List<Cluster> cluster;
	private int row,column;
	private double distance;
	
	public HAC(int itemNumber, double matrix[][], Proximity proximity) {
		this.proximity=proximity;
		this.itemCount=itemNumber;
		this.similartiyMatrix=matrix;
		dendrom=new Dendrom(itemNumber);
	}
	
	private void createInitialCluster(){
		ArrayList<Cluster> initialCluster=new ArrayList<Cluster>();
		for(int i = 0; i<itemCount ;i++ ){
			Cluster cluster=new Cluster();
			cluster.addItem(i);
			initialCluster.add(cluster);
		}
		dendrom.addLevel(initialCluster,-1);
		this.cluster=initialCluster;
	}
	
	private void calculateMostSimilar() throws Exception{
		double sim=Double.MAX_VALUE;
		for(int curRow=0; curRow<cluster.size();curRow++){
			for(int curColumn=0;curColumn<cluster.size();curColumn++){
				if(curRow!=curColumn){
					double simValue = proximity.proximity(cluster.get(curRow), cluster.get(curColumn), similartiyMatrix);
					if(simValue<=sim){
						sim=simValue;
						row=curRow;
						column=curColumn;
						distance=sim;
					}
				}
			}
		}
	}
	
	private void mergeCluster() throws Exception{
		int min,max;
		if(row>column){
			min=column;
			max=row;
		}else if(row<column){
			min=row;
			max=column;
		}else{
			throw new Exception("row and column equal (row:)"+row+" (column:)"+column);
		}
		merge(cluster.get(min),cluster.get(max));
		cluster.remove(max);
		dendrom.addLevel(cluster,distance);
		
	}

	private void merge(Cluster cluster1, Cluster cluster2) {
		
		for(int i=0;i<cluster2.clusterSize();i++){
			Integer curItem=cluster2.getItem(i);
			cluster1.addItem(curItem);
		}
	}
	public Dendrom createCluster(){
		
		createInitialCluster();
		while(cluster.size()>1){
			try {
				calculateMostSimilar();
				mergeCluster();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return dendrom;
	}
	

}
