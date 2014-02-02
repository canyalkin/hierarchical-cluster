package com.clustering.HAC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dendrom {
	
	private final int initialClusterNumber;
	private HashMap<Double, Level> clusterWrtDistance=new HashMap<Double, Level>();
	private List<Level> levels=new ArrayList<Level>();
	
	public Dendrom(int itemNumber) {
		initialClusterNumber=itemNumber;
	}
	
	public void addLevel(List<Cluster> clusters,double distance){
		List<Cluster> newLevelClusters=new ArrayList<Cluster>();
		for (Cluster cluster : clusters) {
			try {
				newLevelClusters.add(cluster.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		Level level=new Level(newLevelClusters, distance);
		levels.add(level);
		clusterWrtDistance.put(distance, level);
	}
	
	public List<Cluster> getClusterAccordingToClusterNumber(int clusterNumber){
		if(clusterNumber<1 || clusterNumber>initialClusterNumber){
			return null;
		}else{
			return levels.get(initialClusterNumber-clusterNumber).getLevel();
		}
	}
	
	
	@Override
	public String toString() {
		StringBuffer stringBuffer=new StringBuffer();
		for(Level curLevel:levels){
			stringBuffer.append(curLevel+"\n");
		}
		return stringBuffer.toString();
	}
	
	

}
