import java.util.Date;


public class testtime {
	
		public static void main(String[]Args){
			int x;
			long elapsedtime;
			
			Date starttime,endtime;
			starttime = new Date();
			for (int j=1;j<=1000;j++){
				
				for (int i=1;i<=10000000;i++){
					for (int h=1;h<=10000000;h++)
					x=3*h*i;
				}
			}
			endtime = new Date();
			elapsedtime = endtime.getTime()-starttime.getTime();
			System.out.print(elapsedtime);
		}
	}

