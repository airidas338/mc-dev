package net.minecraft.server;

public class BlockCloth extends Block {

   public static final bev a = bev.a("color", akv.class);


   public BlockCloth(Material var1) {
      super(var1);
      this.j(this.L.b().a(a, akv.a));
      this.a(CreativeModeTab.b);
   }

   public int getDropData(IBlockData var1) {
      return ((akv)var1.b(a)).a();
   }

   public MaterialMapColor g(IBlockData var1) {
      return ((akv)var1.b(a)).e();
   }

   public IBlockData a(int var1) {
      return this.P().a(a, akv.b(var1));
   }

   public int c(IBlockData var1) {
      return ((akv)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
