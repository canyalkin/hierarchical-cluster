package com.clustering.HAC;

public class GroupAverage implements Proximity {

	@Override
	public double proximity(Cluster c1, Cluster c2, double[][] simMatrix)
			throws Exception {
		double value=0.0;
		for(int i=0;i<c1.clusterSize();i++){
			for(int j=0;j<c2.clusterSize();j++){
				if(c1.getItem(i)!=c2.getItem(j)){
					double curValue=simMatrix[c1.getItem(i)][c2.getItem(j)];
					value+=curValue;
				}else{
					throw new Exception("proximity exception clusters has same index:"+c1+"--"+c2);
				}
			}
		}
		value=(1/(c1.clusterSize()*c2.clusterSize()))*value;
		if(Double.isNaN(value)){
			//System.out.println("Nan value");
			value=Double.MAX_VALUE;
		}
		return value;
	}

}
