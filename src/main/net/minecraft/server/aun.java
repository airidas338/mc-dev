package net.minecraft.server;

public class aun extends Block {

   public static final bev a = bev.a("color", akv.class);


   public aun(Material var1) {
      super(var1);
      this.j(this.L.b().a(a, akv.a));
      this.a(akf.b);
   }

   public int a(IBlock var1) {
      return ((akv)var1.b(a)).a();
   }

   public boh g(IBlock var1) {
      return ((akv)var1.b(a)).e();
   }

   public IBlock a(int var1) {
      return this.P().a(a, akv.b(var1));
   }

   public int c(IBlock var1) {
      return ((akv)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}