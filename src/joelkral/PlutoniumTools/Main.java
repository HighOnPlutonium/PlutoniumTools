package joelkral.PlutoniumTools;

import joelkral.PlutoniumTools.commands.EchoCommand;
import joelkral.PlutoniumTools.commands.FCommand;
import joelkral.PlutoniumTools.events.*;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.*;
import java.awt.Color;
import java.io.IOException;

import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;

public class Main
{
    
    public static void main(@Nullable String[] args) throws IOException, LoginException, IllegalArgumentException, RateLimitedException
    {
        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder client = new CommandClientBuilder();

        client.setOwnerId("593384218046758933");
        client.setPrefix(">>");
        
        client.setActivity(Activity.watching("you sleep"));
        client.setStatus(OnlineStatus.IDLE);

        client.addCommands(
                new AboutCommand(Color.BLUE, "HighOnPlutoniums Bot",
                        new String[]{"Nothing here yet, sorry"},
                        new Permission[]{Permission.ADMINISTRATOR}),
                
                new FCommand(),
                new EchoCommand(),
                
                new ShutdownCommand());
        
        String token = Token.token;
		JDABuilder.createDefault(token)
                .addEventListeners(waiter, client.build(), new MABMessageEvent())
                .build();
        if ( args.length != 0 )
        {
        	System.out.println(args[0]);
        }
    }
}