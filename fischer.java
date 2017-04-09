import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class fischer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader ok=new BufferedReader(new FileReader("DATA40.txt"));
		String line=ok.readLine();
		String[] k=line.split("");
		int R1, R2, K, Q, B1, B2;
		int emptn=0;
		boolean firstR=true;
		boolean firstB=true;
		for(int x=0; x<k.length; x++)
			if(k[x]=="_"){
				emptn++;
				System.out.print(k[x]);
			}
		int[] empty=new int[emptn];
		int arrpos=0;
		for(int x=0; x<k.length; x++){
			switch(k[x]){
			case "_":
				empty[arrpos]=x;
				arrpos++;
				break;
			case "B":
				if(firstB){
					B1=x;
					firstB=false;
				}
				else B2=x;
				break;
			case "Q":
				Q=x;
				break;
			case "K":
				K=x;
				break;
			case "R":
				if(firstR){
					R1=x;
					firstR=false;
				}
				else R2=x;
				break;
			}


		}
		for(int x=0;x<k.length;x++){
			System.out.println(k[x]+" "+empty[x]);
		}
		ok.close();
	}

}
