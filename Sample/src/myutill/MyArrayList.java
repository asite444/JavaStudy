package myutill;

//클래스 명<GenericType>:임의의 타입
//E ElementType
public class MyArrayList<E> {

	E [] data=null;

	public int size() {

		return data==null? 0:data.length;
	}

	@SuppressWarnings("unchecked")
	public void add(E newValue) {

		//현재 개수보다 1개 더 추가해야 함(임시배열),내부객체이므로 사라짐
		E[] imsi =(E[])new Object[this.size()+1];

		//원본배열->imsi에 복사 
		for(int i=0;i<size();i++) {
			imsi[i]=data[i];
		}

		//임시배열의 마지막에 newValue 값 추가
		imsi[size()]=newValue;
		data=imsi;

	}

	public E get(int index) {
		return data[index];
	}

	@SuppressWarnings("unchecked")
	public void remove(int index) {
		E[] imsi =(E[])new Object[this.size()-1];
		if(size()==1) {
			data=null;
		}
		else {
			for(int i=0;i<imsi.length;i++) {
				if(i<index)
					imsi[i]=data[i];
				else
					imsi[i]=data[i+1];
			}
		
			data=imsi;
		}


	}
	public boolean contains(E ob) {


		return false;
	}
}
