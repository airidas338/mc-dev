package net.minecraft.server;

public class ServerCommand {

   public final String command;
   public final ICommandListener source;


   public ServerCommand(String var1, ICommandListener var2) {
      this.command = var1;
      this.source = var2;
   }
}
