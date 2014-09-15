package net.minecraft.server;

public class BlockSand extends avt {

   public static final bev a = bev.a("variant", bac.class);


   public BlockSand() {
      this.j(this.L.b().a(a, bac.a));
   }

   public int a(IBlockData var1) {
      return ((bac)var1.b(a)).a();
   }

   public MaterialMapColor g(IBlockData var1) {
      return ((bac)var1.b(a)).c();
   }

   public IBlockData a(int var1) {
      return this.P().a(a, bac.a(var1));
   }

   public int c(IBlockData var1) {
      return ((bac)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
