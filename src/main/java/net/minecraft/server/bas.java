package net.minecraft.server;

public class bas extends bbj {

   public static final bev a = bev.a("color", akv.class);


   public bas() {
      super(Material.s, false);
      this.j(this.L.b().a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(a, akv.a));
      this.a(akf.c);
   }

   public int a(IBlock var1) {
      return ((akv)var1.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, akv.b(var1));
   }

   public int c(IBlock var1) {
      return ((akv)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{b, M, O, N, a});
   }

   public void c(World var1, Location var2, IBlock var3) {
      if(!var1.D) {
         atm.d(var1, var2);
      }

   }

   public void b(World var1, Location var2, IBlock var3) {
      if(!var1.D) {
         atm.d(var1, var2);
      }

   }

}
