package interviewQuestions;

import java.util.HashMap;

public class Nagarro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "I love my country";
		
		//I=2
		
		HashMap<Object, Integer> na = new HashMap<Object,Integer>();
		for(int i=0; i<a.length(); i++) {
			if(!na.containsKey(a.charAt(i))) {
				int count =0;
				for(int j=i; j<a.length(); j++) {
					if(a.charAt(j)==a.charAt(i)) {
						count++;
					}
				}
				
				na.put(a.charAt(i), count);
			}
		}
		na.entrySet().stream().filter(i->i.getValue()>1).forEach(i->System.out.println(i.getKey()));	
		}
		
		

	}

