package net.minecraft.server;

public class co extends z {

   public String c() {
      return "setidletimeout";
   }

   public int a() {
      return 3;
   }

   public String c(ae var1) {
      return "commands.setidletimeout.usage";
   }

   public void a(ae var1, String[] var2) throws dk, dp {
      if(var2.length != 1) {
         throw new dp("commands.setidletimeout.usage", new Object[0]);
      } else {
         int var3 = a(var2[0], 0);
         MinecraftServer.M().d(var3);
         a(var1, this, "commands.setidletimeout.success", new Object[]{Integer.valueOf(var3)});
      }
   }
}
