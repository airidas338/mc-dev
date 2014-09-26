package net.minecraft.server;
import java.util.Random;

public class BlockCocoa extends BlockDirectional implements atz {

   public static final bew a = bew.a("age", 0, 2);


   public BlockCocoa() {
      super(Material.PLANT);
      this.j(this.L.b().a(N, EnumFacing.NORTH).a(a, Integer.valueOf(0)));
      this.a(true);
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      } else if(var1.random.nextInt(5) == 0) {
         int var5 = ((Integer)var3.b(a)).intValue();
         if(var5 < 2) {
            var1.setTypeAndData(var2, var3.a(a, Integer.valueOf(var5 + 1)), 2);
         }
      }

   }

   public boolean e(World var1, Location var2, IBlockData var3) {
      var2 = var2.a((EnumFacing)var3.b(N));
      IBlockData var4 = var1.getData(var2);
      return var4.c() == Blocks.LOG && var4.b(BlockWood.a) == ayx.d;
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      this.updateShape(var1, var2);
      return super.a(var1, var2, var3);
   }

   public void updateShape(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      EnumFacing var4 = (EnumFacing)var3.b(N);
      int var5 = ((Integer)var3.b(a)).intValue();
      int var6 = 4 + var5 * 2;
      int var7 = 5 + var5 * 2;
      float var8 = (float)var6 / 2.0F;
      switch(aum.a[var4.ordinal()]) {
      case 1:
         this.a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, (15.0F - (float)var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
         break;
      case 2:
         this.a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float)var6) / 16.0F);
         break;
      case 3:
         this.a(0.0625F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float)var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
         break;
      case 4:
         this.a((15.0F - (float)var6) / 16.0F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);
      }

   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      EnumFacing var6 = EnumFacing.a((double)var4.y);
      var1.setTypeAndData(var2, var3.a(N, var6), 2);
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      if(!var3.k().c()) {
         var3 = EnumFacing.NORTH;
      }

      return this.P().a(N, var3.d()).a(a, Integer.valueOf(0));
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   private void f(World var1, Location var2, IBlockData var3) {
      var1.setTypeAndData(var2, Blocks.AIR.P(), 3);
      this.b(var1, var2, var3, 0);
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      int var6 = ((Integer)var3.b(a)).intValue();
      byte var7 = 1;
      if(var6 >= 2) {
         var7 = 3;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         a(var1, var2, new ItemStack(Items.aW, 1, akv.m.b()));
      }

   }

   public int j(World var1, Location var2) {
      return akv.m.b();
   }

   public boolean a(World var1, Location var2, IBlockData var3, boolean var4) {
      return ((Integer)var3.b(a)).intValue() < 2;
   }

   public boolean a(World var1, Random var2, Location var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, Location var3, IBlockData var4) {
      var1.setTypeAndData(var3, var4.a(a, Integer.valueOf(((Integer)var4.b(a)).intValue() + 1)), 2);
   }

   public IBlockData a(int var1) {
      return this.P().a(N, EnumFacing.b(var1)).a(a, Integer.valueOf((var1 & 15) >> 2));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(N)).b();
      var3 |= ((Integer)var1.b(a)).intValue() << 2;
      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{N, a});
   }

}
