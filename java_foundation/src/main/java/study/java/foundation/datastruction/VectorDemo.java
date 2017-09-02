package study.java.foundation.datastruction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		Vector vector = new Vector();
		Vector vectorInit = new Vector(100);
		Vector vectorInitAndIncre = new Vector(100,10);
		
		HashMap map = new HashMap();
		map.put("ll", "12");
		
		vectorInit.addElement("x");
		vectorInit.setElementAt("d",0);
		vectorInit.add(map);
		
//		vectorInitAndIncre.set(0, "23");
		
		vector.add(vectorInitAndIncre);
		vector.addElement(vectorInit);
		
//		vector.toArray(null);
//		vector.lastElement();
//		vector.contains(vectorInit);
//		vector.elements();
//		vector.removeIf(null);
//		vector.remove(map);
//		vector.indexOf(map);
//		vector.sort(c);
//		vector.spliterator();
		
		Iterator it =vector.iterator();
		System.out.println(vector.get(0).toString());
	}
}
