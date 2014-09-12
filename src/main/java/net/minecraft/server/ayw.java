package net.minecraft.server;

public class ayw extends Block {

   public static final bev a = bev.a("variant", ayx.class);


   public ayw() {
      super(Material.d);
      this.j(this.L.b().a(a, ayx.a));
      this.a(akf.b);
   }

   public int a(IBlock var1) {
      return ((ayx)var1.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, ayx.a(var1));
   }

   public int c(IBlock var1) {
      return ((ayx)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
