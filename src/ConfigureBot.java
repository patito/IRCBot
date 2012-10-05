import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigureBot {
    
	private	String nickName;
	private	String channel;
	private String IRCServer;
	private String botFile;
	private String botLogin;
	private String numBots;
		
	public ConfigureBot(int who, String botFile) throws FileNotFoundException, IOException {
		setBotLogin(FileUtil.getProperty("bot" + who + ".login"));
		setIRCServer(FileUtil.getProperty("bot" + who + ".server"));
		setChannel(FileUtil.getProperty("bot" + who + ".channel"));
		setNickName(FileUtil.getProperty("bot" + who + ".nick"));
	}
	
	public ConfigureBot(){}
	
	public String getNickName() {
			return nickName;
	}		
	public void setNickName(String nickName) {
			this.nickName = nickName;
	}		
	public String[] getChannel() {
			String sList[] = channel.split(",", -1);
			return sList;
	}		
	public void setChannel(String channel) {
			this.channel = channel;
	}		
	public String getIRCServer() {
			return IRCServer;
	}		
	public void setIRCServer(String IRCServer) {
			this.IRCServer = IRCServer;
	}		
	public String getBotFile() {
			return botFile;
	}		
	public void setBotFile(String botFile) {
			this.botFile = botFile;
	}		
	public String getBotLogin() {
			return botLogin;
	}		
	public void setBotLogin(String botLogin) {

			this.botLogin = botLogin;
	}	
	public void setNumBots(String numBots) {
		this.numBots = numBots;
	}
	public String getNumBots(){
		return this.numBots;
	}
}