package net.minecraft.server;

public class azi extends atr {

   public static final bev a = bev.a("variant", azj.class);
   public static final int b = azj.a.a();
   public static final int M = azj.b.a();
   public static final int N = azj.c.a();


   public azi() {
      super(bof.e);
      this.j(this.L.b().a(a, azj.a));
      this.a(akf.b);
   }

   public int a(bec var1) {
      return ((azj)var1.b(a)).a();
   }

   public int c(bec var1) {
      return ((azj)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

   public bec a(int var1) {
      return this.P().a(a, azj.a(var1));
   }

}
