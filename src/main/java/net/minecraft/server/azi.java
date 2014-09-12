package net.minecraft.server;

public class azi extends Block {

   public static final bev a = bev.a("variant", azj.class);
   public static final int b = azj.a.a();
   public static final int M = azj.b.a();
   public static final int N = azj.c.a();


   public azi() {
      super(Material.e);
      this.j(this.L.b().a(a, azj.a));
      this.a(akf.b);
   }

   public int a(IBlock var1) {
      return ((azj)var1.b(a)).a();
   }

   public int c(IBlock var1) {
      return ((azj)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

   public IBlock a(int var1) {
      return this.P().a(a, azj.a(var1));
   }

}
