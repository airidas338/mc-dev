package net.minecraft.server;

public class ce extends CommandAbstract {

   public String c() {
      return "publish";
   }

   public String c(ae var1) {
      return "commands.publish.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      String var3 = MinecraftServer.M().a(EnumGamemode.b, false);
      if(var3 != null) {
         a(var1, this, "commands.publish.started", new Object[]{var3});
      } else {
         a(var1, this, "commands.publish.failed", new Object[0]);
      }

   }
}
