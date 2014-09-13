package net.minecraft.server;

public class dc extends z {

   public String c() {
      return "toggledownfall";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.downfall.usage";
   }

   public void a(ae var1, String[] var2) {
      this.d();
      a(var1, this, "commands.downfall.success", new Object[0]);
   }

   protected void d() {
      bqo var1 = MinecraftServer.M().c[0].P();
      var1.b(!var1.p());
   }
}
