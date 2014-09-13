package net.minecraft.server;

public class cq extends z {

   public boolean a(ae var1) {
      return MinecraftServer.M().S() || super.a(var1);
   }

   public String c() {
      return "seed";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.seed.usage";
   }

   public void a(ae var1, String[] var2) {
      Object var3 = var1 instanceof ahd?((ahd)var1).o:MinecraftServer.M().a(0);
      var1.a(new hz("commands.seed.success", new Object[]{Long.valueOf(((aqu)var3).J())}));
   }
}
