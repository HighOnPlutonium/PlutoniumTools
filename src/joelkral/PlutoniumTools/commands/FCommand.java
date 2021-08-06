package joelkral.PlutoniumTools.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class FCommand extends Command 
{
    public FCommand() 
    {
        this.name = "fuck";
        this.aliases = new String[]{"f"};
        this.help = "fuck";
    }
    
    
    @Override
    protected void execute(CommandEvent event) 
    {
    	event.getChannel().sendMessage("fuck").queue();
    }
}