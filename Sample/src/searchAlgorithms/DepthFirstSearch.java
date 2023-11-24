package searchAlgorithms;


import java.util.Stack;



//깊이 우선 탐색 알고리즘 (DFS)
public class DepthFirstSearch {
	// 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[9];

	static Stack<Integer> stack=new Stack<Integer>();
	static int graph[][]= {
			{}
			,{2,3,8}
			,{1,7}
			,{1,4,5}
			,{3,5}
			,{3,4}
			,{7}
			,{2,6,8}
			,{1,7}
	};

	
	
	public static void main(String[] args) {

		System.out.print("재귀적 방식:");
		System.out.print(1);
		dfsRecursion(1);

		for(int i=0;i<vistied.length;i++) vistied[i]=false;
		System.out.println();
		System.out.print("스택방식   :");
		dfsStack();

	}

	//재귀 함수 방식
	static void dfsRecursion(int nodeIndex) {
		// 방문 처리
		vistied[nodeIndex] = true;


		// 방문 노드 출력
		if(nodeIndex!=1)	 System.out.print(" -> "+nodeIndex );

		// 방문한 노드에 인접한 노드 찾기
		for (int node : graph[nodeIndex]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!vistied[node]) {
				dfsRecursion(node);
			}
		}
	}

	//스택 방식
	static void dfsStack() {
		int visitiedNode;
		// 시작 노드를 스택에 넣어줍니다.
		stack.push(1);
		// 시작 노드 방문처리
		vistied[1]=true;

		System.out.print(1);
		// 스택이 비어있지 않으면 계속 반복
		while(!stack.isEmpty()) {

			// 스택에서 하나를 꺼냅니다.
			visitiedNode=stack.pop();

			// 방문 노드 출력
			if(visitiedNode!=1)	System.out.print( " -> "+visitiedNode);

			// 꺼낸 노드와 인접한 노드 찾기
			for(int i:graph[visitiedNode]) {
				// 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리 
				if(!vistied[i]) {
					stack.push(i);
					vistied[i]=true;
				}

			}
		}
	}

}
