import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class WordSrch {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new FileReader("DATA32.txt"));
		final int[] DR = {-1,-1,-1,0,0,1,1,1};
		final int[] DC = {-1,0,1,-1,1,-1,0,1};
		String line=in.readLine();
		while(line!=null)
		{
			String[] arrSize=line.split(" ");
			int rows=Integer.parseInt(arrSize[0]);
			int cols=Integer.parseInt(arrSize[1]);
			char[][] Letters=new char[rows][cols];
			boolean[][] left=new boolean[rows][cols];
			for(int i=0; i<rows;i++)
			{
				String lineA=in.readLine();
				Letters[i]=lineA.toCharArray();
				for(int k=0;k<cols;k++)
					left[i][k]=true;
			}
			int numWurds=Integer.parseInt(in.readLine());
			String[] words=new String[numWurds];
			for(int i=0;i<numWurds;i++)
			{
				words[i]=in.readLine();
				words[i]=words[i].replaceAll("[^A-Z]", "");
			}
			for(int i=0;i<cols;i++)
				for(int j=0;j<rows;j++)
					for(int k=0;k<words.length;k++)
						if(Letters[j][i]==words[k].charAt(0))
							for(int a=0; a<DR.length;a++)
								if(search(j, i, 0, words[k], DR[a], DC[a], Letters, cols, rows))
									for(int q=0;q<words[k].length();q++)
										left[j+q*DR[a]][i+q*DC[a]]=false;
			for(int i=0; i<rows; i++)
				for(int j=0; j<cols;j++)
					if(left[i][j])
						System.out.print(Letters[i][j]);	  
			System.out.println();
			line=in.readLine();
		}in.close();
	}
	private static boolean search(int r, int c, int pos, String word, int dr, int dc, char[][] board, int cols, int rows)
	{
		if (pos == word.length()) return true;
		if (!check(r,c, rows, cols)) return false;
		if (board[r][c] == word.charAt(pos))
			return search(r+dr,c+dc,pos+1,word,dr,dc, board, cols, rows);
		return false;
	}
	private static boolean check(int r, int c, int rows, int cols)
	{
		return r>=0 && c>=0 && r<rows && c<cols;
	}
}
