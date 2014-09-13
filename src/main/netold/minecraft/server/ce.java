package net.minecraft.server;

public class ce extends z {

   public String c() {
      return "publish";
   }

   public String c(ae var1) {
      return "commands.publish.usage";
   }

   public void a(ae var1, String[] var2) {
      String var3 = MinecraftServer.M().a(arc.b, false);
      if(var3 != null) {
         a(var1, this, "commands.publish.started", new Object[]{var3});
      } else {
         a(var1, this, "commands.publish.failed", new Object[0]);
      }

   }
}
