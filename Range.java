import java.util.*;

public class Range implements Comparable<Range>{
	private int startIndex,endIndex;
	private int index=0;
	private Integer[] arrOfNumbers1=new Integer[3];
	Range(){
	}
	Range(int startIndex,int endIndex){
		this.startIndex=startIndex;
		this.endIndex=endIndex;
	}
	public int getStartIndex(){
		return this.startIndex;
	}
	public int getEndIndex(){
		return this.endIndex;
	}
	public void setStartIndex(int startIndex){
		this.startIndex=startIndex;
	}
	public void setEndIndex(int endIndex){
		this.endIndex=endIndex;
	}
	public boolean add(int number){
		if(index<3){
			arrOfNumbers1[index]=number;
			index++;
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int compareTo(Range c1){
		if(this.getStartIndex()>c1.getStartIndex())
            return 1;
        else if(this.getStartIndex()<c1.getStartIndex())
            return -1;
        else
            return 0;
    }
    public Integer[] getNumbers(){
    	Integer[] newArr=new Integer[index];
    	for(int i=0;i<index;i++){
    		newArr[i]=arrOfNumbers1[i];
    	}
    	return newArr;
    }
	@Override
    public boolean equals(Object obj){
    	System.out.println("Called!");
    	if(obj==this){
    		return true;
    	}
    	System.out.println("obj.getClass() is:"+obj.getClass());
   		System.out.println("this.getClass() is:"+this.getClass());
   		if(obj==null || obj.getClass()!=this.getClass()){
   			return false;
   		}
   		int objStartIndex=((Range)obj).getStartIndex();
   		if(this.startIndex==objStartIndex)
   			return true;
   		else
   			return false;
   	}
    @Override
    public int hashCode(){
    	System.out.println("called innnnn!");
        return this.startIndex;//if the name is same,then the hashcodes will be same!
    	//this method would be called at the time of bucket allocation.
    }
}