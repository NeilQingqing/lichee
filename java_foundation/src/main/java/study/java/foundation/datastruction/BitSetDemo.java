package study.java.foundation.datastruction;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {
		BitSet bitSet1 = new BitSet();
		BitSet bitSet2 = new BitSet(10);
		
		for(int i = 0; i< 5; i++){
			if(i % 2 == 0 ){
				bitSet1.set(i);
			}
			if(i % 3 == 0){
				bitSet2.set(i);
			}
		}
		System.out.println("bitSet1 = " + bitSet1);
		System.out.println("bitSet2 = " + bitSet2);
		
		
		bitSet1.get(2);
		bitSet1.get(1, 2);
		bitSet1.set(5);
		
		bitSet1.or(bitSet2);
		System.out.println("bitSet1.or(bitSet2) = " + bitSet1);
		bitSet1.and(bitSet2);
		System.out.println("bitSet1.and(bitSet2) = " + bitSet1);
		bitSet1.andNot(bitSet2);
		System.out.println("bitSet1.andNot(bitSet2) = " + bitSet1);
		
		bitSet1.flip(1);
		System.out.println("bitSet1.flip(1) = " + bitSet1);
		bitSet1.flip(1,2);
		System.out.println("bitSet1.flip(1,2) = " + bitSet1);
		
		bitSet1.cardinality();
		bitSet1.intersects(bitSet2);
		bitSet1.isEmpty();
		
		bitSet1.nextSetBit(0);
		bitSet1.previousClearBit(2);
		
		bitSet1.toByteArray();
		bitSet1.toLongArray();
		
	
		bitSet1.clear(2);
		bitSet1.clear(0, 1);
		bitSet1.clear();
		
	}
}
