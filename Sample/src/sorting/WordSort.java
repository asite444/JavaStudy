package sorting;

/*
알파벳 소문자로 이루어진 N개의 단어가 들어오면 
아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
단, 중복된 단어는 하나만 남기고 제거해야 한다.

입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터
N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
주어지는 문자열의 길이는 50을 넘지 않는다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class WordSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb=new StringBuilder();
		Word[] arr=new Word[Integer.parseInt(br.readLine())];

		for(int i=0;i<arr.length;i++) arr[i]=new Word(br.readLine());	

		Arrays.sort(arr,wordComp);
		for(int i=0;i<arr.length;i++)
		{   if(i<arr.length-1 && !arr[i].word.equals(arr[i+1].word)) sb.append(arr[i].word).append("\n");
		}
		sb.append(arr[arr.length-1].word);
		System.out.println(sb);

	}

	public static Comparator<Word> wordComp =new Comparator<Word>() {

		@Override
		public int compare(Word o1, Word o2) {

			int result;
			int i=0;
			//길이가 동일한 경우


			if(o1.word.length()==o2.word.length()) {
				while(true) {
					if(i<o1.word.length()-1) {
						if(o1.word.charAt(i)!=o2.word.charAt(i)) {
							break;
						}
					} 
					else break;
					i++;
				}

				result= o1.word.charAt(i)-o2.word.charAt(i);
			} else result=o1.word.length()-o2.word.length();

			return result;
		}
	};
}

class Word{
	String word;
	public Word(String word) {
		this.word=word;
	}

}