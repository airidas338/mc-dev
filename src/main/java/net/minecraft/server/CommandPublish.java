package net.minecraft.server;

public class CommandPublish extends CommandAbstract {

   public String c() {
      return "publish";
   }

   public String c(ICommandSender var1) {
      return "commands.publish.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      String var3 = MinecraftServer.M().a(EnumGamemode.SURVIVAL, false);
      if(var3 != null) {
         a(var1, this, "commands.publish.started", new Object[]{var3});
      } else {
         a(var1, this, "commands.publish.failed", new Object[0]);
      }

   }
}
