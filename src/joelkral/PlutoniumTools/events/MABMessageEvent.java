package joelkral.PlutoniumTools.events;

import joelkral.PlutoniumTools.enums.MessageTypeEnum;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MABMessageEvent extends ListenerAdapter
{
	public void reactMessage(GuildMessageReceivedEvent event, MessageTypeEnum type) 
	{
		if (!event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) 
		{
		    switch (type) 
		    {
		    case  HELLO:
			    event.getChannel().sendMessage("Hi").queue();
			    break;
		    case BYE:
			    event.getChannel().sendMessage("Bye").queue();
			    break;
		    case GOOD_NIGHT:
			    event.getChannel().sendMessage("Good night").queue();
			    break;
		    }
		}
	}
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) 
	{
		String messageSent = event.getMessage().getContentRaw();
		
		switch (messageSent) 
		{
		case "I want to make a bot":
		    event.getChannel().sendMessage("no").queue();
			break;
		case "sus":
			event.getChannel().sendMessage("amogus").queue();
			break;
		case "hello":
			reactMessage(event, MessageTypeEnum.HELLO);
			break;
		case "hi":
			reactMessage(event, MessageTypeEnum.HELLO);
			break;
		case "bye":
			reactMessage(event, MessageTypeEnum.BYE);
			break;
		case "byee":
			reactMessage(event, MessageTypeEnum.BYE);
			break;
		case "good night":
			reactMessage(event, MessageTypeEnum.GOOD_NIGHT);
			break;
		case "gn":
			reactMessage(event, MessageTypeEnum.GOOD_NIGHT);
			break;
		}
	}
}
