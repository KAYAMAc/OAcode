/*
题目描述:
将输入的字符串转换为id的组合,若字符之前出现过,则在出现过的id基础上加100,若当前字符第一次出现,则该字符的id为00x,第一个数字为001,第二个数字为002
输入：第一行整数n,后面n行每行一列字符,字符间以空格隔开
输出：一共n行,每行包括一列id,id以空格隔开
例子：
2
a b c d e f g
001 002 003 004 005 006 007
a a b b c d e f b
001 101 002 102 003 004 005 006 202
*/
package Solutions;

import java.util.Scanner;
import java.util.ArrayList;
public class solution_polished {
	
		private static int existed_contains(String[] full_list, String s) {
			int list_length=full_list.length;
			for (int p=list_length-1;p>=0;p--) {
				if(full_list[p].equalsIgnoreCase(s)) {
					return p;
				}
			}
			return -1;
		}
		
		private static String[] get_id(String [] new_codes) {
			ArrayList<String> existed=new ArrayList<String>();
		    ArrayList<String> ids=new ArrayList<String>();
		    int new_id=1;
		    for(String code:new_codes){
		    	int index=existed_contains(existed.toArray(new String[0]),code);
	    		String [] idss=ids.toArray(new String[0]);
		    	if(index>=0) {
		    		if(Integer.parseInt(idss[index])>=900) {
		    			ids.add(String.format("%03d", new_id));
	    	    		existed.add(code);
		    			new_id++;
		    		}
		    		else {
		    			ids.add(String.format("%03d", Integer.parseInt(idss[index])+100));
		    			existed.add(code);
		    		}
		    	}
		    	else if(index<0) {
		    		ids.add(String.format("%03d", new_id));
		    		existed.add(code);
		    		new_id++;
		    	}
		    }
		    return ids.toArray(new String[0]);
		}
		
		public static void main(String[] args){
			Scanner input=new Scanner(System.in);
	        String number=input.nextLine();
	        int input_number=Integer.parseInt(number);
	        for(int x=0;x<input_number;x++) {
	    	    String input_codes=input.nextLine();
	    	    if(input_codes=="") {
	    	    	System.out.println("コードを入力してください。");
	    	    	input_number++;
	    	    	continue;
	    	    }
	    	    String[] ans=get_id(input_codes.split(" "));
	    	    for(int ind=0;ind<ans.length;ind++) {
	    	    	if(ind!=ans.length-1) {
	        	    	System.out.print(ans[ind]+" ");
	    	    	}
	    	    	else System.out.print(ans[ind]);
	    	    }
		    	System.out.println("");
	        }
	        input.close();
		}
}

