package net.minecraft.server;
import java.util.List;

public class CommandSay extends CommandAbstract {

   public String getCommand() {
      return "say";
   }

   public int a() {
      return 1;
   }

   public String c(ICommandListener var1) {
      return "commands.say.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length > 0 && var2[0].length() > 0) {
         IChatBaseComponent var3 = b(var1, var2, 0, true);
         MinecraftServer.M().an().a((IChatBaseComponent)(new ChatMessage("chat.type.announcement", new Object[]{var1.getScoreboardDisplayName(), var3})));
      } else {
         throw new ExceptionUsage("commands.say.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length >= 1?a(var2, MinecraftServer.M().I()):null;
   }
}
