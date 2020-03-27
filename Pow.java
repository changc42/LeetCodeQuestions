import java.util.*;

class Pow {
  public double myPow(double x, int n) {
      Map<Double, Double> map = new HashMap<>();
      return pow(x,n,map);
  }
  double pow(double x, int n, Map<Double, Double> map){
      double key = hashCode(x,n);
      if(map.containsKey(key)) return map.get(key);
      if(n==1) return x;
      
      
      for(Map.Entry<Double,Double> e: map.entrySet()){
          System.out.println("hi");
          System.out.println(e.getKey());
          System.out.println(e.getValue());
      }
      
      if(n%2==0){
          double ret = pow(x, n/2,map)*pow(x,n/2,map);
          map.put(key, ret);
          return ret;
      }
      else{
          double ret=pow(x,(n-1)/2,map)*pow(x,(n-1)/2,map)*x;
          map.put(key, ret);
          return ret;
      }
      
  }
  
  double hashCode(double x, int n){
      return x+n*100;
  }
  
  public static void main(String args[]){
    Pow foo = new Pow();
    System.out.println(foo.myPow(2.0,14));
  }
  
}