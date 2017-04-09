/* Problem 1 of ECOOCS competition round1 
A day on Mars is just a little bit longer than a day on Earth.
One day on Mars lasts 24 hours 37 minutes and 22.663 seconds in Earth time. 
To make sure they can get the most out of the daylight hours on Mars, when NASA plans a Mars Rover mission, they put all of their employees on “Martian Time”. 
Martian time uses a 24-hour clock divided into minutes and seconds just like Earth time.
But every Martian hour, minute and second has to be just a little bit longer than its Earth counterpart.
It just so happens that at 12:00 AM on January 1st, 2015 (aka Day 1) on Earth it will also be exactly 12:00 AM of Day 1 in Martian time at the place where the next Mars rover will touch down. 
So NASA has issued its employees Martian digital watches, synchronized so that Day 1 at midnight matches Day 1 at midnight on Earth. 
These watches report the day, hour and minute of the current time (they keep track of seconds as well, but don’t report that number on the face of the watch). 

DATA11.txt (DATA12.txt for the second try) will contain 10 test cases.
Each test case will consist of three integers D, H, and M representing the Day, Hour and Minute of an exact time on Earth, where Day 1 is January 1st, 2015 (1 = D = 1000, 0 = H = 23 and 0 = M = 59).
Your job is to output the current time on Mars as it would be shown on the Martian digital watch described above.
Each time should be on a single line and formatted exactly as shown in the sample output below

Sample Input
346 12 28 
393 06 40 
390 19 50 
984 02 25 
674 21 29 
435 13 07 
15 04 12 
539 00 50 
40 01 20 
69 03 11 

Sample Output 
Day 337, 18:40 
Day 383, 08:28 
Day 380, 23:07 
Day 959, 05:28 
Day 657, 20:17 
Day 424, 13:15 
Day 14, 19:35 
Day 525, 10:08 
Day 39, 01:37 
Day 67, 09:48 
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class martianTime {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new FileReader("DATA10.txt"));
		String line;
		while((line=in.readLine())!=null){
			String[] ok=line.split(" ");
			double eSec=0;
			double eD=Integer.parseInt(ok[0]);
			double eH=Integer.parseInt(ok[1]);
			double eM=Integer.parseInt(ok[2]);
			eSec+=eD*86400+eH*3600+eM*60;


			double mH=88642.663/24;
			double mM=mH/60;
			int mDo=0, mHo=0, mMo=0;
			eSec = eSec - 86400;
			/*  mDo = (int)(eSec / 88642.663);
             		eSec -= (mDo * 88642.663);
          		mHo = (int)(eSec / 3693.444);
        	        eSec -= (mHo * 3693.444);
         		mMo = (eSec / 61.57); */
			mDo= (int) (eSec/88642.663);
			eSec=eSec-(mDo*88642.663);
			mHo= (int) (eSec/mH);
			eSec=eSec-(mHo*mH);
			mMo= (int) (eSec/mM);
			if(mHo<10&&mMo<10)
				System.out.println("Day "+(mDo+1)+", 0"+mHo+":0"+mMo);
			else if(mHo<10)
		    		System.out.println("Day "+(mDo+1)+", 0"+mHo+":"+mMo);
			else if(mMo<10)
				System.out.println("Day "+(mDo+1)+", "+mHo+":0"+mMo);
			else System.out.println("Day "+(mDo+1)+", "+mHo+":"+mMo);
		}
		in.close();
	}

}
