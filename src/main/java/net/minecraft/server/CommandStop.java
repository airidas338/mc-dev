package net.minecraft.server;

public class CommandStop extends CommandAbstract {

   public String getCommand() {
      return "stop";
   }

   public String c(ICommandListener var1) {
      return "commands.stop.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(MinecraftServer.M().c != null) {
         a(var1, this, "commands.stop.start", new Object[0]);
      }

      MinecraftServer.M().u();
   }
}
