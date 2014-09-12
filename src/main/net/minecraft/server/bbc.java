package net.minecraft.server;

public class bbc extends Block {

   public static final bev a = bev.a("variant", bbd.class);
   public static final int b = bbd.a.a();
   public static final int M = bbd.b.a();
   public static final int N = bbd.c.a();
   public static final int O = bbd.d.a();


   public bbc() {
      super(Material.e);
      this.j(this.L.b().a(a, bbd.a));
      this.a(akf.b);
   }

   public int a(IBlock var1) {
      return ((bbd)var1.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, bbd.a(var1));
   }

   public int c(IBlock var1) {
      return ((bbd)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
