import java.net.*;
import java.io.*;
import java.util.Scanner;
class ThreadBySubclass extends Thread
{
		DataInputStream		in = null;
		DataOutputStream	out = null;
		Socket	ThreadName;
		static int [] site = new int[100];
		static int count = 0;
		
		
	ThreadBySubclass(Socket sc)
	{
		ThreadName = sc;
	}
	public void run()
	{
		int userNumber = 0;
		boolean endOfGame = false;
		userNumber = ++count;
		System.out.println("User " + userNumber + " is connect");
		try
		{	
			in = new DataInputStream(ThreadName.getInputStream());
			out = new DataOutputStream(ThreadName.getOutputStream());
			
			out.writeInt(userNumber);//send user's turn number
			
			if((userNumber%2) == 1)
			{
				while(true)
				{
					site[userNumber] = new Integer(in.readInt());
					if(site[userNumber] > 10000)
					{
						site[userNumber] -= 10000;
						endOfGame = true;
					}
					System.out.println("Client" + userNumber + " : " + site[userNumber]);
					while(site[userNumber + 1] == 0)
					{
						try{sleep(100);}catch(Exception e){}
					}
					out.writeInt(site[userNumber + 1]);
					site[userNumber + 1] = 0;
					if(endOfGame) break; 
				}
			}
			else if((userNumber%2) == 0)
			{
				while(true)
				{
					while(site[userNumber - 1] == 0)
					{
						try{sleep(100);}catch(Exception e){}
					}
					out.writeInt(site[userNumber - 1]);
					site[userNumber - 1] = 0;
					if(endOfGame) break;
					site[userNumber] = new Integer(in.readInt());
					if(site[userNumber] > 10000)
					{
						site[userNumber] -= 10000;
						endOfGame = true;
					}
					System.out.println("Client" + userNumber + " : " + site[userNumber]);
				}
			}
			in.close();
			out.close();
			ThreadName.close();
		}
		catch(IOException e)
		{
			System.out.println("error : " + e);
		}
	}
}
public class GameServer
{
	public static void main(String args[])
	{
		int port = 6666;
		System.out.println("Waiting for request ...");
		try
		{
			ServerSocket srverSocket = new ServerSocket(port);
			while (true)
			{
				//when 2 player login, thread start
				Socket scPlayer1 = srverSocket.accept();
				Socket scPlayer2 = srverSocket.accept();
				ThreadBySubclass newThreadPlayer1 = new ThreadBySubclass(scPlayer1);
				ThreadBySubclass newThreadPlayer2 = new ThreadBySubclass(scPlayer2);
				newThreadPlayer1.start();
				try
				{
					newThreadPlayer1.sleep(50);
				}catch(Exception e){}
				newThreadPlayer2.start();
			}
		}
		catch(Exception e)
		{
			System.out.println("error: " + e.getMessage());
		}
	}
}