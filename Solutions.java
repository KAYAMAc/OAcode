package Solutions;
import java.util.Scanner;
import java.util.ArrayList;

public class Solutions {
	
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
    	    	System.out.println("¥³©`¥É¤òÈëÁ¦¤·¤Æ¤¯¤À¤µ¤¤¡£");
    	    	input_number++;
    	    	continue;
    	    }
    	    String[] ans=get_id(input_codes.split(" "));
    	    /*
    	    String[] new_codes=input_codes.split(" ");
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
    		String [] idss=ids.toArray(new String[0]);
    		*/
    	    for(int ind=0;ind<ans.length;ind++) {
    	    	if(ind!=ans.length-1) {
        	    	System.out.print(ans[ind]+" ");
    	    	}
    	    	else System.out.print(ans[ind]);
    	    }
	    	System.out.println("");
    	    /*
    	    for(String id:ids) {
    	    	System.out.print(id+" ");
    	    }
	    	*/
        }
        input.close();
	}
}
