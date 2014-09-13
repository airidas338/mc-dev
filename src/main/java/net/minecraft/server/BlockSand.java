package net.minecraft.server;

public class BlockSand extends avt {

   public static final bev a = bev.a("variant", bac.class);


   public BlockSand() {
      this.j(this.L.b().a(a, bac.a));
   }

   public int a(IBlock var1) {
      return ((bac)var1.b(a)).a();
   }

   public MaterialMapColor g(IBlock var1) {
      return ((bac)var1.b(a)).c();
   }

   public IBlock a(int var1) {
      return this.P().a(a, bac.a(var1));
   }

   public int c(IBlock var1) {
      return ((bac)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
