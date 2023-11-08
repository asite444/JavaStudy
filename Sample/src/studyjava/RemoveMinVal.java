package studyjava;
import java.util.Arrays;

public class RemoveMinVal {

	public static void main(String[] args) {
		int[] numbers= {1,3,-84,0,9,-20};
		Solution solution =new Solution();
		
	   System.out.println(Arrays.toString(solution.solution(numbers)));
	}

}
class Solution {
    public int[] solution(int[] arr) {
    	int[] answer;
    	if(arr.length==1) {
    		answer= new int[1];
    		answer[0]=-1;
    	}else {answer= new int[arr.length-1];}
    	
    	int min=arr[0];
        int j=0;
        
        for(int i=0;i<arr.length;i++) {
        	min=min>=arr[i]?arr[i]:min;
        }
        for(int i=0;i<arr.length;i++) {
        	
        if(arr[i]!=min) {answer[j]=arr[i];j++;}
        
       
        }
        
        
    
        
        return answer;
    }
}