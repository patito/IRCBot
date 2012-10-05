import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class LoadBot extends ConfigureBot {
	private String fileBot;

	private Vector<ConfigureBot> vBots = new Vector<ConfigureBot>();
	
	public LoadBot(String fileBot){
		super();
		this.setFileBot(fileBot);
	}
	
	public Vector<ConfigureBot> loadAllBots() throws FileNotFoundException, IOException{
		//Properties static
		int nBots = Integer.parseInt(FileUtil.getProperty("numero.bots"));
		for (int i = 1; i <= nBots; i++) {
			ConfigureBot bot = new ConfigureBot(i, this.fileBot);
			this.vBots.add(bot);
		}

		return this.vBots;
	}
	
	public String getFileBot() {
		return fileBot;
	}		
	public void setFileBot(String fileBot) {
		this.fileBot = fileBot;
	}	

}
