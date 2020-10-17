import java.util.*;    
    
public class Main6 {    
    
    public static void main(String[] args) {    
            
        String name;    
        Scanner input=new Scanner(System.in);    
    
        Object e=new Object();
        int N,index=-1;    
            
        name=input.next();    
        N=input.nextInt();    
            
        switch(name)    
        {    
            case "Integer":    
                        Integer[] iarr=new Integer [N];    
                        for(int i=0;i<N;i++) iarr[i]=input.nextInt();    
                        e=input.nextInt();    
                        index=binarySearch((Integer [])iarr,(Integer)e);    
                        break;    
            case "Double":    
                        Double[] darr=new Double [N];    
                        for(int i=0;i<N;i++) darr[i]=input.nextDouble();    
                        e=input.nextDouble();    
                        index=binarySearch((Double [])darr,(Double)e);    
                        break;    
            case "Character":    
                        Character[] carr=new Character [N];    
                        for(int i=0;i<N;i++) carr[i]=input.next(".").charAt(0);    
                        e=input.next(".").charAt(0);    
                        index=binarySearch((Character [])carr,(Character)e);    
                        break;    
            case "String":    
                        String[] sarr=new String [N];    
                        for(int i=0;i<N;i++) sarr[i]=input.next();    
                        e=input.next();    
                        index=binarySearch((String [])sarr,(String)e);    
                        break;    
        }    
        if(index==-1)    
        {    
            System.out.println("Not found.");    
            input.close();    
            return ;    
        }    
        if(!name.equals("Double")) System.out.println(e+" is found in the "+index+"'th place.");
        else System.out.printf("%.3f is found in the %d'th place.\n",e,index); 
        input.close();    
    }    
        
    public static <E extends Comparable<E>> int binarySearch(E[] list,E key)    
    {    
        int min=0,max=list.length-1,mid=(min+max)/2;    
        Arrays.sort(list);    
        while(min<=max)    
        {    
            mid=(min+max)/2;    
            if(key.compareTo(list[mid])==0) return mid;    
            if(key.compareTo(list[mid])<0) max=mid-1;    
            else if(key.compareTo(list[mid])>0) min=mid+1;    
        }    
        return -1;    
    }    
        
}