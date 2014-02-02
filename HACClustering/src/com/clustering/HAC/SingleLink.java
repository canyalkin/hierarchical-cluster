package com.clustering.HAC;


public class SingleLink implements Proximity {

	@Override
	public double proximity(Cluster c1, Cluster c2, double[][] simMatrix) throws Exception {
		double value=Double.MAX_VALUE;
		for(int i=0;i<c1.clusterSize();i++){
			for(int j=0;j<c2.clusterSize();j++){
				if(c1.getItem(i)!=c2.getItem(j)){
					double curValue=simMatrix[c1.getItem(i)][c2.getItem(j)];
					if(curValue<value){
						value=curValue;
					}
				}else{
					throw new Exception("proximity exception clusters has same index:"+c1+"--"+c2);
				}
			}
		}
		return value;
	}

}
