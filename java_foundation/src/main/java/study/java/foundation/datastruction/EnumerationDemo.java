package study.java.foundation.datastruction;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

	public static void main(String[] args) {
		//枚举数据类型
		Enumeration<?> days = null;
		
		Vector<String> dayNames = new Vector<String>();
		dayNames.add("Monday");
		dayNames.add("Tuesday");
		dayNames.add("Wednesday");
		dayNames.add("Thursday");
		dayNames.add("Friday");
		dayNames.add("Saturday");
		dayNames.add("Sunday");
		
		days = dayNames.elements();
		while(days.hasMoreElements()){
			System.out.println(days.nextElement());
		}
		
		//枚举类
		Day monday= Day.valueOf("Monday");
		Day.print(monday);
//		Day.valueOf(Reason.class, reason);
		Day[] enumDays = Day.values();
		int daySize = enumDays.length;
		System.out.println("Eunm day size : " + daySize);
		for(Day dayE : enumDays){
			System.out.println(dayE.toString());
		}
		
		
	}

	enum Day{
		Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;

		public static void print(Day day) {
			System.out.println("******" + day);
		}
	}
	
	enum Reason{
		Spring,Summer,Autumn,Winter
	}
}
