package net.minecraft.server;
import java.util.List;

public class CommandMe extends CommandAbstract {

   public String getCommand() {
      return "me";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.me.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length <= 0) {
         throw new ExceptionUsage("commands.me.usage", new Object[0]);
      } else {
         IChatBaseComponent var3 = b(var1, var2, 0, !(var1 instanceof EntityHuman));
         MinecraftServer.M().an().a((IChatBaseComponent)(new ChatMessage("chat.type.emote", new Object[]{var1.getScoreboardDisplayName(), var3})));
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return a(var2, MinecraftServer.M().I());
   }
}
