package net.minecraft.server;

public class CommandSetIdleTimeout extends CommandAbstract {

   public String c() {
      return "setidletimeout";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandSender var1) {
      return "commands.setidletimeout.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      if(var2.length != 1) {
         throw new ExceptionUsage("commands.setidletimeout.usage", new Object[0]);
      } else {
         int var3 = a(var2[0], 0);
         MinecraftServer.M().d(var3);
         a(var1, this, "commands.setidletimeout.success", new Object[]{Integer.valueOf(var3)});
      }
   }
}
