import java.util.ArrayList;

public class main{
    public static void main(String[]args){
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        ArrayList<Integer> y = new ArrayList<Integer>();
        y.add(9);
        y.add(9);
        y.add(9);
        y.add(9);
        y.add(9);
        System.out.println(BigInts(x, y));
    }
    
    public static ArrayList<Integer> Sieve(int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 2;
        for(int i = 2; i <= n; i++){
            list.add(i);
        }
       
        for(int x = start; x < list.size(); x++){
            for(int i = start; i < list.size(); i++){
               int ind = list.indexOf(x*i);
               if(ind > -1) list.remove(ind);
            }  
        }
        return list;
    }
    
    
    public static String Goldbach(int input){
        ArrayList<Integer> pnums = Sieve(100);
        int pnum1 = input;
        int pnum2 = 0;
        boolean found = false;
        while(found == false){
            pnum1--;
            if(pnums.contains(pnum1) && pnums.contains(input-pnum1)){
                pnum2 = input-pnum1;
                found = true;
            }
        }
        return pnum1 + " + " + pnum2 + " = " + input;
    }
    
    public static ArrayList<Integer> BigInts(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> output = new ArrayList<Integer>();
        ArrayList<Integer> big;
        ArrayList<Integer> small;
        boolean over10 = false;
        
        if(a.size() > b.size()){
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        
        for(int i = 1; i <= big.size(); i++){
            if(i <= small.size()){
                int sum = small.get(small.size()-i) + big.get(big.size()-i);
            
                if(over10)
                    sum++;
                if(sum > 9)
                    over10 = true;
                else
                    over10 = false;
                
                output.add(0, sum%10);
            }else{
                if(over10){
                    big.set(big.size()-i, big.get(big.size()-i)+1);
                    over10 = false;
                }
                if(big.get(big.size()-i)+1 > 9)
                    over10 = true;
                output.add(0, big.get(big.size()-i)%10);
            }
        }
        
        if(over10){
                output.add(0, 1);
        }
        
        return output;
    }
}