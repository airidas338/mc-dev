package net.minecraft.server;

public class BlockBannerWall extends BlockBannerAbstract {

   public BlockBannerWall() {
      this.j(this.L.b().a(a, EnumFacing.NORTH));
   }

   public void updateShape(IBlockAccess var1, Location var2) {
      EnumFacing var3 = (EnumFacing)var1.getData(var2).b(a);
      float var4 = 0.0F;
      float var5 = 0.78125F;
      float var6 = 0.0F;
      float var7 = 1.0F;
      float var8 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      switch(atc.a[var3.ordinal()]) {
      case 1:
      default:
         this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
         break;
      case 2:
         this.a(var6, var4, 0.0F, var7, var5, var8);
         break;
      case 3:
         this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
         break;
      case 4:
         this.a(0.0F, var4, var6, var8, var5, var7);
      }

   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      EnumFacing var5 = (EnumFacing)var3.b(a);
      if(!var1.getData(var2.a(var5.d())).c().getMaterial().isBuildable()) {
         this.b(var1, var2, var3, 0);
         var1.setAir(var2);
      }

      super.doPhysics(var1, var2, var3, var4);
   }

   public IBlockData a(int var1) {
      EnumFacing var2 = EnumFacing.a(var1);
      if(var2.k() == el.b) {
         var2 = EnumFacing.NORTH;
      }

      return this.P().a(a, var2);
   }

   public int c(IBlockData var1) {
      return ((EnumFacing)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }
}
