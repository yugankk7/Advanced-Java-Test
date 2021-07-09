
import java.util.*;

class hm {
     

    static void adder(int n) {
        LinkedHashMap<Object,Object> hm = new LinkedHashMap<Object,Object>();   //storting key value pairs in a linkedhashmap 
        Scanner sc = new Scanner(System.in);                                    //will result in automatically removing the duplicates
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the key " + i);
            Object k = sc.next();
            System.out.println("Enter the value " + i);
            Object v = sc.next();
            hm.put(k,v);
        }
        sc.close();
        System.out.println("The unique elements are : ");
        for(Map.Entry m:hm.entrySet()){  
            System.out.println(m.getKey()+" : "+m.getValue());  
           }  
        
    }
}

class al {
    static <T> Collection unique(Collection<T> c) {
        Set<Object> set = new LinkedHashSet<Object>(c);     //Converting into linkedhashset which stores only unique values
        return set; 
    }
}


public class b {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Would you like to store your data as key - value pairs or only values?");
        System.out.println("1 : KEY - VALUE PAIR\n2 : ONLY VALUES");
        int ch = inp.nextInt();
        

        if (ch == 1) {
            System.out.println("How many values do you need to enter?");
            int n = inp.nextInt();
            hm.adder(n);
        }

        if (ch == 2) {
            System.out.println("How many values do you need to enter?");
            int n = inp.nextInt();
            ArrayList<Object> arr = new ArrayList<Object>();
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter the value " + i);
                arr.add(inp.next());
            }
            System.out.println("The unique elements are " + al.unique(arr));
        }
        inp.close();

        
    }
}

