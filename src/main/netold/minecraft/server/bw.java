package net.minecraft.server;

public class bw extends z {

   public String c() {
      return "list";
   }

   public int a() {
      return 0;
   }

   public String c(ae var1) {
      return "commands.players.usage";
   }

   public void a(ae var1, String[] var2) {
      int var3 = MinecraftServer.M().G();
      var1.a(new hz("commands.players.list", new Object[]{Integer.valueOf(var3), Integer.valueOf(MinecraftServer.M().H())}));
      var1.a(new hy(MinecraftServer.M().an().f()));
      var1.a(ag.e, var3);
   }
}
