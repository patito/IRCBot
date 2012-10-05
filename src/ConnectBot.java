import java.io.*;
import java.util.Iterator;
import java.util.Vector;

import org.jibble.pircbot.*;

public class ConnectBot extends PircBot implements Runnable{
    
	private ConfigureBot confBot;
	
	public ConnectBot(ConfigureBot confBot) {
		this.confBot = confBot;
	}
	
	public void run() {
		try {
			this.connect();
		} catch (NickAlreadyInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//this.close();
		}
    }
	
	public synchronized void connect() throws IOException, NickAlreadyInUseException, IrcException {
		super.setVerbose(true);
		super.setLogin(confBot.getBotLogin());
		super.setName(confBot.getNickName());
		super.connect(confBot.getIRCServer());
		String sList[] = confBot.getChannel();
		for (int i = 0; i < sList.length; i++) {
			super.joinChannel(sList[i]);
		}
		//super.joinChannel(confBot.getChannel());
	}
	
    @Override
    public void onMessage(String channel, 
    					  String sender, 
    					  String login, 
    					  String hostname, 
    					  String message) {
    	System.out.println("Canal = " + channel  + 
    					   " Sender = " + sender + 
    					   " MSG = " + message);
    }
    protected void onPrivateMessage(String sender,
            String login,
            String hostname,
            String message){
    	System.out.println("Sender = " + sender  + 
				           " Login = " + login +
				           " HostName = " + hostname +
				           " MSG = " + message);
    }
	
	public synchronized void close() {
		super.disconnect();
	}
	
    public static void main(String[] args) throws Exception {
    	LoadBot bot = new LoadBot("/home/patito/libjava/bot.properties");
    	Vector<ConfigureBot> vBots = bot.loadAllBots();
    	
    	Iterator<ConfigureBot> it = vBots.iterator();
    	
    	while(it.hasNext()) {
    		ConfigureBot cBot = it.next();
    		Runnable runnable = new ConnectBot(cBot);
    		Thread thread = new Thread(runnable);
    		thread.start();
    	}
    }
}