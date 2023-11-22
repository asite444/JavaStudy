package studyjava;

import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {
		

		Worker work1=new Worker(31, 3); //나이, 직급
		Worker work2=new Worker(32, 2); //나이, 직급
		
		int result=comp.compare(work1, work2);
		
		//나이 기준
		if(result>0) System.out.println("work1이 work2보다 더 큽니다.");
		else if(result==0) System.out.println("work1과work2가 같습니다");
		else System.out.println("work1이 work2보다 작습니다.");
		
		result=comp2.compare(work1, work2);
		//직급 기준
		if(result>0) System.out.println("work1이 work2보다 더 큽니다.");
		else if(result==0) System.out.println("work1과work2가 같습니다");
		else System.out.println("work1이 work2보다 작습니다.");
	}

	//나이 기준
	public static Comparator<Worker> comp=new Comparator<Worker>() {
		
		@Override
		public int compare(Worker o1, Worker o2) {
			
			return o1.age-o2.age;
		}
	}; 
	//연차 기준
	public static Comparator<Worker> comp2=new Comparator<Worker>() {
		
		@Override
		public int compare(Worker o1, Worker o2) {
			
			return o1.workerNumber-o2.workerNumber;
		}
	};
}


class Worker {
	int age;
	int workerNumber;
	
	public Worker(int age,int workerNumber) {
		this.age=age;
		this.workerNumber=workerNumber;
	}
	
	
}