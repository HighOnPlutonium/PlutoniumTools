package joelkral.PlutoniumTools.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class EchoCommand extends Command 
{
    public EchoCommand() 
    {
        this.name = "echo";
        this.aliases = new String[]{"e"};
        this.help = "echo";
        this.arguments = "<guild name> <channel name> <message>";
        this.guildOnly = false;
    }
    
    
    @Override
    protected void execute(CommandEvent event) 
    {

    	String[] args = event.getArgs().split(" ");
    	event.getJDA().getGuildsByName(args[0].replace("_", " "), true).get(0).getTextChannelsByName(args[1].replace("_", " "), true).get(0).sendMessage(args[2].replace("_", " ")).queue();
    }
}