public class ArrayDeque <T>{
	private T[] array = (T[])new Object[8];
	private int last = 5;
	private int first = 4;
	
	public int size(){
		return last-first-1;
	}
	public void addFirst(T item){
		if (first<0){
			first = array.length-1;
			last = array.length;
			T[] temp = (T[])new Object[array.length*3];
			for (int i=0;i<array.length;i++){
				temp[i+array.length] = array[i];
				last+=1;

			}
			array = temp;

		}
		array[first] = item;
		first-=1;
	}
	public void addLast(T item){
		if (last==array.length){
			first = array.length-1;
			last = array.length;
			T[] temp = (T[])new Object[array.length*3];
			for (int i=0;i<array.length;i++){
				temp[i+array.length] = array[i];
				last+=1;
			}
			array = temp;
		}
		array[last] = item;
		last+=1;
	}
	public void printDeque(){
		for(int i = first+1;i<last;i++){
			System.out.println(array[i]);
		}
		System.out.println("\n");
	}
	public ArrayDeque(){

	}

	public boolean isEmpty(){
		if ((last-first-1)==0){
			return true;
		}
		else{
			return false;
		}
	}

	
	public ArrayDeque(ArrayDeque other){
		first = 0;
		last = 1; 
		int s = other.size();
		T[] array = (T[])new Object[s+1];
		for (int i = 1; i < s; i++ ){
			array[i] = (T)other.get(i);
			last+=1;
			
		}
	}
	public T removeLast(){
		if ((last-first-1)>0){
			last-=1;
			if ((last-first-1)>10&&last-first-1<(int)array.length/6){
				first = last-first-1-1;
				last = last-first-1;
				T[] temp = (T[])new Object[(last-first-1)*3];
				for (int i=1;i<last;i++){
					temp[i+last-first-1] = array[first+i];
					last+=1;
				}
				array = temp;
			}
			return array[last-1];
		}
		
		else{
			return null;
		}


	}
	public T removeFirst(){
		if ((last-first-1)>0){
			first+=1;
			if ((last-first-1)>10&&(last-first-1)<(int)array.length/6){
				first = last-first-1-1;
				last = last-first-1;
				T[] temp = (T[])new Object[(last-first-1)*3];
				for (int i=1;i<last;i++){
					temp[i+last-first-1] = array[first+i];
					last+=1;
				}
				array = temp;
			}
			return array[first+1];
		}
		
		else{
			return null;
		}
	}
	public T get(int index){
		if (index>first && index<last){
			return array[index];
		}
		else{
			return null;
		}
	}

}