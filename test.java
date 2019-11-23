class test{
	int x;
	public String intToRoman(int num) {
		x=num;
        StringBuilder sb = new StringBuilder();
		
		if(1<=num%10 && num%10<=3){
			for(int i=0; i<num%10; i++) sb.insert(0, "I");
		}
        else if(num%10==4) sb.insert(0, "IV");
        else if(5<=num && num<=8){
			sb.insert(0, "V");
			for(int i=5; i<num%10; i++){
				sb.insert(1, "I");
			}
		}
        else if(num%10==9) sb.insert(0, "IX"); 
		num-=num%10;
		
        if(10<=num%100 && num%100<=30){
			for(int i=0; i<num%100; i+=10) sb.insert(0, "X");
		}
        else if(num==40) sb.insert(0,"XL");
        else if(50<=num && num<=80){
			sb.insert(0, "L");
			for(int i=50; i<num%100; i+=10){
				sb.insert(1, "X");
			}
		}
        else if(num==90) sb.insert(0,"XC");
		num-=num%100;
		
        if(100<=num%1000 && num%1000<=300){
			for(int i=0; i<num%1000; i+=100) sb.insert(0, "C");
		}
        else if(num==400) sb.insert(0,CD);
        else if(500<=num && num<=800){
			sb.insert(0, "D");
			for(int i=500; i<num%1000; i+=100){
				sb.insert(1, "C");
			}
		}
        else if(num==900) sb.insert(0,CM);
		num-=num%1000;
		
        if(1000<=num && num<=3000){
			for(int i=0; i<num%10000; i+=1000) sb.insert(0, "M");
		}
		
		return sb.toString();
    }

}