//Super serious cool bot guy v1.0;
package com.REEBot;
//JDA Imports
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
//Error imports + File imports
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
//Date
import java.time.LocalDate;
public class App extends ListenerAdapter {
	boolean inDraw = false;
	//This hold all current commands
	static ArrayList<String> commands = new ArrayList<String>();
	//Data
	static int goodboypoints = 0;
	static int fuckyous = 0;
	static int time;
	//The properties class stores values
	Properties points = new Properties();
	//This is the main commands
    public static void main( String[] args ) throws Exception{
    	//This is what sets up a bot
        JDA jdabot = new JDABuilder(AccountType.BOT).setToken(Ref.token).build();
        jdabot.addEventListener(new App());
    }
    @Override
    //This acts like KeyEvent and ActionEvent stuff
    public void onMessageReceived(MessageReceivedEvent e){
    	//This checks messages
    	Message objMsg = e.getMessage();
    	//This checks the channel
    	MessageChannel objMsgCh = e.getChannel();
    	//This checks the user
    	User objUser = e.getAuthor();
    	//These are the commands [last updt. 3/4/19]
    	commands.add("!'nam - PTSD"); //0
    	commands.add("!points - Tells you how many points this lil qt has accrued"); //1
    	commands.add("good bot - Makes sure bot knows he's liked (+1 Good Bot points)"); //2
    	commands.add("bad bot - Makes sure bot knows he's hated (-1 Good Bot points)"); //3
    	commands.add("!huntinghorn - Summons God"); //4
    	commands.add("!thor - Actually Thor tho"); //5
    	commands.add("!wosh - wosh"); //6
    	commands.add("!remind - Not actually implemented as of the latest vers."); //7
    	commands.add("!africa - Fun lesson on electricity!"); //8
    	commands.add("!github - Links you to the github my creator made for me :)"); //9
    	commands.add("!8b - Works like an 8Ball"); //10
    	//Need to be implemented**
    	if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "'nam")) {
    		objMsgCh.sendMessage(objUser.getAsMention() + " https://www.youtube.com/watch?v=s9odzlxOpP0").queue();
    	}
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "commands")) {
    		//Please use a for-loop somehow. This is literally garbage code.
    		objMsgCh.sendMessage(objUser.getAsMention() + " \n```Current commands include:\n" + commands.get(0)+ "\n" + commands.get(1) + "\n" + commands.get(2) + "\n" + commands.get(3) + "\n" + commands.get(4) + "\n" + commands.get(5) + "\n" + commands.get(6) + "\n" + 
    				commands.get(7) + "\n" + commands.get(8) + "\n" + commands.get(9) + "\n" + commands.get(10) + "```").queue();
    	}
    	else if (objMsg.getContentRaw().equalsIgnoreCase("GOOD BOY") || objMsg.getContentRaw().equalsIgnoreCase("GOOD BOT")) {
    		int randMsg = (int)(Math.random()*4)+1;
    		//This loads the file content
    		try {
				points.load(new FileReader("myfile.properties"));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		//This sets the int to whatever the value was
    		goodboypoints = Integer.parseInt(points.getProperty("Points"));
    		//Adds because this is a good bot
    		goodboypoints += 1;
    		//This stores the points
    		try {
    		points.setProperty("Points", Integer.toString(goodboypoints));
    		points.store(new FileWriter("myfile.properties"), "");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		if (randMsg == 1) 
    		objMsgCh.sendMessage(objUser.getAsMention() + " Thank you for the points uwu").queue();
    		else if (randMsg == 2) 
    		objMsgCh.sendMessage(objUser.getAsMention() + " Good human").queue();
    		else if (randMsg == 3) 
    		objMsgCh.sendMessage(objUser.getAsMention() + " It's nothing really").queue();
    		else if (randMsg == 4) 
    		objMsgCh.sendMessage("OwO what's this?! " + objUser.getAsMention() + "-oniichan gave me points!").queue();
    		objMsgCh.sendMessage("Current Good Bot Points: " + points.getProperty("Points")).queue();
    	}
    	//This works the same as above, but subtracts
    	else if (objMsg.getContentRaw().equalsIgnoreCase("BAD BOY") || objMsg.getContentRaw().equalsIgnoreCase("BAD BOT")) {
    		try {
				points.load(new FileReader("myfile.properties"));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		goodboypoints = Integer.parseInt(points.getProperty("Points"));
    		goodboypoints -= 1;
    		 points.setProperty("Points", Integer.toString(goodboypoints));
    		 try {
  				points.store(new FileWriter("myfile.properties"), "");
  			} catch (IOException e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
  			}
    		objMsgCh.sendMessage(objUser.getAsMention() + " Aww, I'm sorry you feel that way you degenerate fuck").queue(); 
    		objMsgCh.sendMessage("Current Good Bot Points: " + points.getProperty("Points")).queue();
    	}
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"points")) {
    		try {
				points.load(new FileReader("myfile.properties"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		objMsgCh.sendMessage("Current Good Bot Points: " + points.getProperty("Points")).queue();
    	}
    	//Spawn the power of Jack Black and the soul of HH mains everywhere
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "huntinghorn")) {
    		objMsgCh.sendMessage(objUser.getAsMention() + "https://www.youtube.com/watch?v=mRSpaLObDL4").queue();
    	}
    	//This mans is insane. "I normally use a rock", goddamn.
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "thor")) {
    		objMsgCh.sendMessage(objUser.getAsMention() + "https://youtu.be/kFEka86Lrrc?t=68").queue();
    	}
    	//wosh
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "wosh")) {
    		objMsgCh.sendMessage("https://cdn.discordapp.com/attachments/389870022958383106/548735391268732938/vgj89ykzdmo11.jpeg").queue();
    	}
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "remind")) {
    		objMsgCh.sendMessage("* Not implemented Yet *").queue();
    	}
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "africa")) {
    		objMsgCh.sendMessage("https://cdn.discordapp.com/attachments/418492743547879427/550808671202967568/aaaa.webm").queue();
    	}
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "github")) {
    		objMsgCh.sendMessage("https://github.com/UnitedPuggs/REE-bot").queue();
    	}
    	else if (objMsg.getContentRaw().toLowerCase().contains(Ref.prefix + "8b")) {
    		int randMsg = (int)(Math.random()*5)+1;
    		if (!objUser.isBot()) {
    			if (randMsg == 1)
    			objMsgCh.sendMessage(":8ball: **|**  Yes!").queue();
    			else if (randMsg == 2)
    			objMsgCh.sendMessage(":8ball: **|** No!").queue();
    			else if (randMsg == 3) 
    			objMsgCh.sendMessage(":8ball: **|** Maybe UwO").queue();
    			else if (randMsg == 4)
    			objMsgCh.sendMessage(":8ball: **|** Definitely not (´・ω・`)").queue();
    			else if (randMsg == 5)
    			objMsgCh.sendMessage(":8ball: **|** For sure ;)").queue();
    		}
    	}
    	//This doesn't quite work yet
    	else if (objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix + "draw")) {
    		inDraw = true;
    		while (inDraw == true) {
    		if (objMsg.getContentRaw().toLowerCase().contains("t")) 
    		objMsgCh.sendMessage("https://cdn.discordapp.com/attachments/435282663524532225/552367728397123594/t.jpg").queue();
    		else if (objMsg.getContentRaw().toLowerCase().contains("e"))
    		objMsgCh.sendMessage("https://cdn.discordapp.com/attachments/435282663524532225/552367741776953354/e.jpg").queue();
    		else if (objMsg.getContentRaw().toLowerCase().contains("s"))
    		objMsgCh.sendMessage("https://cdn.discordapp.com/attachments/435282663524532225/552367750086131712/s.jpg").queue();
    		}
    	}
    }	
}
