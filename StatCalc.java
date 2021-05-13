package exercises;

public class StatCalc {
	private int count;
	private double sum;
	private double squareSum;
	private double maxNum = Double.NEGATIVE_INFINITY;
	private double minNum = Double.POSITIVE_INFINITY;
	
	 public void enter(double num) {
	        count++;
	        sum += num;
	        squareSum += num*num;
	        if(num > maxNum) {
	        	maxNum = num;
	        }
	        if(num < minNum) {
	        	minNum = num;
	        }
	    }

	    // Return number of items
	    public int getCount() {
	        return count;
	    }

	    
	    // Return sum of items
	    public double getSum() {
	        return sum;
	    }

	    // Return mean of items
	    public double getMean() {
	        return sum / count;  
	    }

	    //Return standarddeviation of items
	    public double getStandardDeviation() {  
	        double mean = getMean();
	        return Math.sqrt( squareSum/count - mean*mean );
	    }
	    // Return max num of items
	    public double getmaxNum() {
	    	return maxNum;
	    }
	 // Return min num of items
	    public double getminNum() {
	    	return minNum;
	    }
}
