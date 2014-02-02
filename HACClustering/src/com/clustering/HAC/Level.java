package com.clustering.HAC;

import java.util.List;

public class Level {

	private List<Cluster> clusters;
	private double distance;
	public Level(List<Cluster> levels, double distance) {
		super();
		this.clusters = levels;
		this.setDistance(distance);
	}
	
	public List<Cluster> getLevel(){
		return clusters;
	}

	public double getDistance() {
		return distance;
	}

	private void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("distance:"+distance+"\n");
		for (int i = 0; i < clusters.size(); i++) {
			stringBuffer.append(clusters.get(i)+"-");
		}
		return stringBuffer.toString();
	}
	
	
	
}
