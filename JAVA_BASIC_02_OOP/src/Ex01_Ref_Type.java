import kr.or.kosa.Person;


//연습용으로  TEST  
class Test{  //default class Test
	int i;   //default int i
	int j;
	void print() {  //default void print()
		System.out.println(i);
	}
}


public class Ex01_Ref_Type {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.personPrint();
		
		Person person1 = new Person(); //사람 1명
		person1.name = "김유신";
		person1.age = 100;
		person1.power = true;
		person1.personPrint();
		
		//결과
		System.out.println(person);  //주소값출력 (참조값) 참조타입  kr.or.kosa.Person@6e8dacdf
		System.out.println(person1); //kr.or.kosa.Person@7a79be86
		
		//참조타입의 할당은 주소값 할당
		Person person2 = person1;
		
		if(person2 == person1) {
			System.out.println("같은 집에 살고 있어요 ^^");
		}
		
		

	}

}
