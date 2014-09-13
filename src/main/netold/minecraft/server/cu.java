package net.minecraft.server;

public class cu extends z {

   public String c() {
      return "stop";
   }

   public String c(ae var1) {
      return "commands.stop.usage";
   }

   public void a(ae var1, String[] var2) {
      if(MinecraftServer.M().c != null) {
         a(var1, this, "commands.stop.start", new Object[0]);
      }

      MinecraftServer.M().u();
   }
}
