import java.net.*;
import java.io.*;
import java.util.Scanner;
class UserClient
{
	private String[][] board;
	private static int boardSize = 15;
	public void createNewBoard()
	{
		board = new String[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++)
		{
			for(int j = 0; j < boardSize; j++)
			{
				board[i][j] = "┼";
			}
		}
	}
	public void printBoard()
	{
		for(int j = -1; j < boardSize; j++)
			{
				if(j == -1) System.out.print("site");
				else if(j >= 0 && j < 10) System.out.print(" " + j);
				else System.out.print(j);
			}
			System.out.print("\n\n");
			for(int i = 0; i < boardSize; i++)
			{
				if(i < 10) System.out.print(" " + i + "   ");
				else System.out.print(i + "   ");
				for(int j = 0; j < boardSize; j++)
				{
					System.out.print(board[i][j]);
				}
				System.out.print("\n");
			}
	}
	public int printBoard(int siteX, int siteY, boolean fristturn, boolean keyIn)//0 = keep going, 1 = win, 2 = key again
	{
		while((siteX >= boardSize) || (siteY >= boardSize)) 
		{
			return 2;
		}
		while((keyIn == true) && (board[siteY][siteX] != "┼"))
		{
			return 2;
		}
		if(fristturn == true) board[siteY][siteX] = "●";
		else board[siteY][siteX] = "○";
		
		if(keyIn == false)
		{
			for(int j = -1; j < boardSize; j++)
			{
				if(j == -1) System.out.print("site");
				else if(j >= 0 && j < 10) System.out.print(" " + j);
				else System.out.print(j);
			}
			System.out.print("\n\n");
			for(int i = 0; i < boardSize; i++)
			{
				if(i < 10) System.out.print(" " + i + "   ");
				else System.out.print(i + "   ");
				for(int j = 0; j < boardSize; j++)
				{
					System.out.print(board[i][j]);
				}
				System.out.print("\n");
			}
		}
		if(siteX < (boardSize-4))//type 1	
			if((board[siteY][siteX] == board[siteY][siteX+1]) && (board[siteY][siteX] == board[siteY][siteX+2]) 
			&& (board[siteY][siteX] == board[siteY][siteX+3]) && (board[siteY][siteX] == board[siteY][siteX+4])) 
				return 1;
		if(0 < siteX && siteX < (boardSize-3))	
			if((board[siteY][siteX] == board[siteY][siteX-1]) && (board[siteY][siteX] == board[siteY][siteX+1]) 
			&& (board[siteY][siteX] == board[siteY][siteX+2]) && (board[siteY][siteX] == board[siteY][siteX+3]))
				return 1;
		if(1 < siteX && siteX < (boardSize-2))	
			if((board[siteY][siteX] == board[siteY][siteX-2]) && (board[siteY][siteX] == board[siteY][siteX-1]) 
			&& (board[siteY][siteX] == board[siteY][siteX+1]) && (board[siteY][siteX] == board[siteY][siteX+2]))
				return 1;
		if(2 < siteX && siteX < (boardSize-1))	
			if((board[siteY][siteX] == board[siteY][siteX-3]) && (board[siteY][siteX] == board[siteY][siteX-2]) 
			&& (board[siteY][siteX] == board[siteY][siteX-1]) && (board[siteY][siteX] == board[siteY][siteX+1]))
				return 1;
		if(3 < siteX && siteX < boardSize)		
			if((board[siteY][siteX] == board[siteY][siteX-4]) && (board[siteY][siteX] == board[siteY][siteX-3]) 
			&& (board[siteY][siteX] == board[siteY][siteX-2]) && (board[siteY][siteX] == board[siteY][siteX-1]))
				return 1;
		if(siteY < (boardSize-4))//type 2		
			if((board[siteY][siteX] == board[siteY+1][siteX]) && (board[siteY][siteX] == board[siteY+2][siteX]) 
			&& (board[siteY][siteX] == board[siteY+3][siteX]) && (board[siteY][siteX] == board[siteY+4][siteX])) 
				return 1;
		if(0 < siteY && siteY < (boardSize-3))	
			if((board[siteY][siteX] == board[siteY-1][siteX]) && (board[siteY][siteX] == board[siteY+1][siteX]) 
			&& (board[siteY][siteX] == board[siteY+2][siteX]) && (board[siteY][siteX] == board[siteY+3][siteX])) 
				return 1;
		if(1 < siteY && siteY < (boardSize-2))	
			if((board[siteY][siteX] == board[siteY-2][siteX]) && (board[siteY][siteX] == board[siteY-1][siteX]) 
			&& (board[siteY][siteX] == board[siteY+1][siteX]) && (board[siteY][siteX] == board[siteY+2][siteX])) 
				return 1;
		if(2 < siteY && siteY < (boardSize-1))	
			if((board[siteY][siteX] == board[siteY-3][siteX]) && (board[siteY][siteX] == board[siteY-2][siteX]) 
			&& (board[siteY][siteX] == board[siteY-1][siteX]) && (board[siteY][siteX] == board[siteY+1][siteX])) 
				return 1;
		if(3 < siteY && siteY < boardSize)		
			if((board[siteY][siteX] == board[siteY-4][siteX]) && (board[siteY][siteX] == board[siteY-3][siteX]) 
			&& (board[siteY][siteX] == board[siteY-2][siteX]) && (board[siteY][siteX] == board[siteY-1][siteX])) 
				return 1;
		if((siteX < (boardSize-4)) && (siteY < (boardSize-4)))//type 3
			if((board[siteY][siteX] == board[siteY+1][siteX+1]) && (board[siteY][siteX] == board[siteY+2][siteX+2])
			&& (board[siteY][siteX] == board[siteY+3][siteX+3]) && (board[siteY][siteX] == board[siteY+4][siteX+4]))
				return 1;
		if((0 < siteX && siteX < (boardSize-3)) && (0 < siteY && siteY < (boardSize-3)))
			if((board[siteY][siteX] == board[siteY+1][siteX+1]) && (board[siteY][siteX] == board[siteY+2][siteX+2])
			&& (board[siteY][siteX] == board[siteY+3][siteX+3]) && (board[siteY][siteX] == board[siteY-1][siteX-1]))
				return 1;
		if((1 < siteX && siteX < (boardSize-2)) && (1 < siteY && siteY < (boardSize-2)))
			if((board[siteY][siteX] == board[siteY+1][siteX+1]) && (board[siteY][siteX] == board[siteY+2][siteX+2])
			&& (board[siteY][siteX] == board[siteY-1][siteX-1]) && (board[siteY][siteX] == board[siteY-2][siteX-2]))
				return 1;
		if((2 < siteX && siteX < (boardSize-1)) && (2 < siteY && siteY < (boardSize-1)))
			if((board[siteY][siteX] == board[siteY+1][siteX+1]) && (board[siteY][siteX] == board[siteY-1][siteX-1])
			&& (board[siteY][siteX] == board[siteY-2][siteX-2]) && (board[siteY][siteX] == board[siteY-3][siteX-3]))
				return 1;
		if((3 < siteX && siteX < boardSize) && (3 < siteY && siteY < boardSize))
			if((board[siteY][siteX] == board[siteY-1][siteX-1]) && (board[siteY][siteX] == board[siteY-2][siteX-2])
			&& (board[siteY][siteX] == board[siteY-3][siteX-3]) && (board[siteY][siteX] == board[siteY-4][siteX-4]))
				return 1;
		if((3 < siteX && siteX < boardSize) && (siteY < (boardSize-4)))//type 4
			if((board[siteY][siteX] == board[siteY+1][siteX-1]) && (board[siteY][siteX] == board[siteY+2][siteX-2])
			&& (board[siteY][siteX] == board[siteY+3][siteX-3]) && (board[siteY][siteX] == board[siteY+4][siteX-4]))
				return 1;
		if((2 < siteX && siteX < (boardSize-1)) && (0 < siteY && siteY < (boardSize-3)))
			if((board[siteY][siteX] == board[siteY+1][siteX-1]) && (board[siteY][siteX] == board[siteY+2][siteX-2])
			&& (board[siteY][siteX] == board[siteY+3][siteX-3]) && (board[siteY][siteX] == board[siteY-1][siteX+1]))
				return 1;
		if((1 < siteX && siteX < (boardSize-2)) && (1 < siteY && siteY < (boardSize-2)))
			if((board[siteY][siteX] == board[siteY+1][siteX-1]) && (board[siteY][siteX] == board[siteY+2][siteX-2])
			&& (board[siteY][siteX] == board[siteY-1][siteX+1]) && (board[siteY][siteX] == board[siteY-2][siteX+2]))
				return 1;
		if((0 < siteX && siteX < (boardSize-3)) && (2 < siteY && siteY < (boardSize-1)))
			if((board[siteY][siteX] == board[siteY+1][siteX-1]) && (board[siteY][siteX] == board[siteY-1][siteX+1])
			&& (board[siteY][siteX] == board[siteY-2][siteX+2]) && (board[siteY][siteX] == board[siteY-3][siteX+3]))
				return 1;
		if((siteX < (boardSize-4)) && (3 < siteY && siteY < boardSize))
			if((board[siteY][siteX] == board[siteY-1][siteX+1]) && (board[siteY][siteX] == board[siteY-2][siteX+2])
			&& (board[siteY][siteX] == board[siteY-3][siteX+3]) && (board[siteY][siteX] == board[siteY-4][siteX+4]))
				return 1;
		return 0 ;
	}
	public static void main(String args[])
	{
		Socket			client = null;
		DataInputStream 	in = null;
		DataOutputStream 	out = null;
		String 			userName = null;
		int				port = 6666;
		int 			myUserNumber;
		int 			siteX, siteY, siteXY;
		if(args.length == 0)
		{
		    System.out.println("Usage: java UserClient server_ip");
		}
		else
		{
			try
			{
				//send a request
				client = new Socket(args[0], port);
				in = new DataInputStream(client.getInputStream());
				out = new DataOutputStream(client.getOutputStream());
				//print board
				UserClient gb = new UserClient();
				gb.createNewBoard();
				//get user's turn number and show it to user
				myUserNumber = in.readInt();
				System.out.println("Hello , your user number is : " + myUserNumber);
				if((myUserNumber%2) == 1)
					System.out.println("Your emeny's user number is : " + (myUserNumber + 1));
				else
					System.out.println("Your emeny's user number is : " + (myUserNumber - 1));

				gb.printBoard();//show board
				
				if((myUserNumber%2) == 1)
				{
					while(true)
					{
						Scanner scannerSite = new Scanner (System.in);
						System.out.print("Please key in a site like x(x < " + boardSize + ") y(y < " + boardSize + ") at empty site: ");
						siteX = scannerSite.nextInt();
						siteY = scannerSite.nextInt();
						while(gb.printBoard(siteX, siteY, true, true) == 2)
						{
							System.out.print("Please key in a site like x(x < " + boardSize + ") y(y < " + boardSize + ") at empty site: ");
							siteX = scannerSite.nextInt();
							siteY = scannerSite.nextInt();
						}
						if(gb.printBoard(siteX, siteY, true, false) == 1)//print panal
						{
							System.out.println("Your win!");
							out.writeInt(siteX * (boardSize-1) + siteY + 1 + ((boardSize-1) * (boardSize-1)));
							break;
						}
						out.writeInt(siteX * (boardSize-1) + siteY + 1);//send massage
						System.out.println("Waiting...");
						siteXY = new Integer(in.readInt());//get massage
						siteXY--;
						System.out.println("Enemy's site(x,y) : (" + (siteXY / (boardSize-1)) + "," +  (siteXY % (boardSize-1)) + ")!");
						if(gb.printBoard((siteXY / (boardSize-1)), (siteXY % (boardSize-1)), false, false) == 1)
						{
							System.out.println("Your lose!");
							break;
						}
					}
				}
				else if((myUserNumber%2) == 0)
				{
					while(true)
					{
						System.out.println("Waiting...");
						siteXY = new Integer(in.readInt());
						siteXY--;
						System.out.println("Enemy's site(x,y) : (" + (siteXY / (boardSize-1)) + "," +  (siteXY % (boardSize-1)) + ")!");
						if(gb.printBoard((siteXY / (boardSize-1)), (siteXY % (boardSize-1)), true, false) == 1)
						{
							System.out.println("Your lose!");
							break;
						}
						Scanner scannerSite = new Scanner (System.in);
						System.out.print("Please key in a site like x(x < " + boardSize + ") y(y < " + boardSize + ") at empty site: ");
						siteX = scannerSite.nextInt();
						siteY = scannerSite.nextInt();
						while(gb.printBoard(siteX, siteY, true, true) == 2)
						{
							System.out.print("Please key in a site like x(x < " + boardSize + ") y(y < " + boardSize + ") at empty site: ");
							siteX = scannerSite.nextInt();
							siteY = scannerSite.nextInt();
						}
						if(gb.printBoard(siteX, siteY, false, false) == 1)//print panal
						{
							System.out.println("Your win!");
							out.writeInt(siteX * (boardSize-1) + siteY + 1 + ((boardSize-1)*(boardSize-1)));
							break;
						}
						out.writeInt(siteX * (boardSize-1) + siteY + 1);//send massage
					}
				}
				out.close();
				in.close();
				client.close();
			}
			catch(UnknownHostException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}