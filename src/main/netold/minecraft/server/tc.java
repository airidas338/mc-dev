package net.minecraft.server;

public class tc implements ae {

   private static final tc a = new tc();
   private StringBuffer b = new StringBuffer();


   public static tc h() {
      return a;
   }

   public void i() {
      this.b.setLength(0);
   }

   public String j() {
      return this.b.toString();
   }

   public String d_() {
      return "Rcon";
   }

   public ho e_() {
      return new hy(this.d_());
   }

   public void a(ho var1) {
      this.b.append(var1.c());
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public dt c() {
      return new dt(0, 0, 0);
   }

   public brw d() {
      return new brw(0.0D, 0.0D, 0.0D);
   }

   public aqu e() {
      return MinecraftServer.M().e();
   }

   public wv f() {
      return null;
   }

   public boolean t_() {
      return true;
   }

   public void a(ag var1, int var2) {}

}
