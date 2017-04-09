import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class OprhanBlack {
	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("DATA21.txt"));
		String line1=in.readLine();
		String line2=in.readLine();
		while(line1!=null){
			String currentLine="";
			String hello="", hello2="", hello3="";
			boolean flip=false;
			int y=0;
			for(int i=0; i<line1.length();i++){
				char temp1=line1.charAt(i);
				char temp2=line2.charAt(i);
				if((temp1=='A'&&temp2=='T')||(temp1=='T'&&temp2=='A')){
					currentLine+=1;
				} else currentLine+=0;
			}
			for(int i=0;i<9;i++){
				hello=currentLine.substring(i, (i+8));
				hello2=currentLine.substring(i+8, (i+16));
				hello3=currentLine.substring(i+16, i+24);
				char x=(char) (Integer.parseInt(hello, 2));
				char z=(char) (Integer.parseInt(hello2, 2));
				char zx=(char) (Integer.parseInt(hello3, 2));
				y=i;
				if((x>=65&&x<=90)&&((z>=65&&z<=90)||z==32)&&((zx>=65&&zx<=90)||zx==32)){
					break;
				}
			}
			for(int k=y;k<currentLine.length()-7;k+=8){
				char x=(char)(Integer.parseInt(currentLine.substring(k, k+8), 2));
				if(x>=65&&x<=90||x==32)
					System.out.print(x);
				else {
					flip=true;
					break;
				}
			}
			if (flip)
			{
				currentLine=flipping(currentLine);
				for(int i=0;i<9;i++){
					hello=currentLine.substring(i, (i+8));
					hello2=currentLine.substring(i+8, (i+16));
					hello3=currentLine.substring(i+16, i+24);
					char x=(char) (Integer.parseInt(hello, 2));
					char z=(char) (Integer.parseInt(hello2, 2));
					char zx=(char) (Integer.parseInt(hello3, 2));
					y=i;
					if((x>=65&&x<=90)&&((z>=65&&z<=90)||z==32)&&((zx>=65&&zx<=90)||zx==32)){
						break;//{		
					}
				}

				for(int k=y;k<currentLine.length()-7;k+=8){
					char x=(char)(Integer.parseInt(currentLine.substring(k, k+8), 2));
					if(x>=65&&x<=90||x==32)
						System.out.print(x);
				}
			}
			System.out.println();
			line1=in.readLine();
			line2=in.readLine();
		}in.close();
	}
	public static String flipping(String line){
		char[] ok=line.toCharArray();
		String hey="";
		for(int i=0;i<line.length();i++){
			if(ok[i]=='1')
				ok[i]='0';
			else if(ok[i]=='0')
				ok[i]='1';
			hey+=ok[i];
		}
		return hey;
	}
}
