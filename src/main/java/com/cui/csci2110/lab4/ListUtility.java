package com.cui.csci2110.lab4;


public class ListUtility{
	public static <T> List<T> findUnion(List<T> list1, List<T> list2){ // put no duplicated characters from list1 to list3 and then put no duplicated characters from list2 to list3
		List<T> list3 = new List<T>();
		T item = list1.first();
		while(item != null){
			if(!list3.contains(item))
				list3.addToEnd(item);
			item = list1.next();
		}
		item = list2.first();
		while(item != null){
			if(!list3.contains(item))
				list3.addToEnd(item);
			item = list2.next();
		}
		return list3;
	}
	public static <T> List<T> findIntersection(List<T> list1, List<T> list2){ //if any characters from list1 that are same as those from list2, and then adding them to list3, finally put no duplicated characters from list3 to list4
		List<T> list3 = new List<T>();
		List<T> list4 = new List<T>();
		T item = list2.first();
		while(item != null){
			if(list1.contains(item))
				list3.addToEnd(item);
			item = list2.next();
		}
		item = list3.first();
		while(item != null){
			if(!list4.contains(item))
				list4.addToEnd(item);
			item = list3.next();
		}
		return list4;
	}
	public static <T> List<T> interleave(List<T> list1, List<T> list2){ //  item1 and item2 are not null, put them in list3. if item1 is null and item2 is not, put item2 in list3, such like that
		List<T> list3 = new List<T>();
		T item1 = list1.first();
		T item2 = list2.first();
		while(item1 != null || item2 != null){
			if(item1 != null && item2 != null){
				list3.addToEnd(item1);
				list3.addToEnd(item2);
				item1 = list1.next();
				item2 = list2.next();
				
			}
			else if(item1 != null && item2 == null){
				list3.addToEnd(item1);
				item1 = list1.next();
			}
			else{
				list3.addToEnd(item2);
				item2 = list2.next();
			}
		}
		return list3;
	}
	public static <T> List<T> chopSkip(List<T> list1){ //initial a int num to 0, and num means the index of the first character in list1, then find the odd num and put the corresponding character to list3
		int num = 0;
		List<T> list3 = new List<T>();
		T item = list1.first();
		while(item != null){
			if(num % 2 == 0){
				item = list1.next();
				num++;
			}	
			else{
				list3.addToEnd(item);
				item = list1.next();
				num++;
			}
		}
		return list3;
	}
}

