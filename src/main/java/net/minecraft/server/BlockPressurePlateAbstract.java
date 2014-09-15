package net.minecraft.server;
import java.util.Random;

public abstract class BlockPressurePlateAbstract extends Block {

   protected BlockPressurePlateAbstract(Material var1) {
      super(var1);
      this.a(CreativeModeTab.d);
      this.a(true);
   }

   public void a(IBlockAccess var1, Location var2) {
      this.d(var1.getData(var2));
   }

   protected void d(IBlockData var1) {
      boolean var2 = this.e(var1) > 0;
      float var3 = 0.0625F;
      if(var2) {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F, 0.9375F);
      } else {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
      }

   }

   public int a(World var1) {
      return 20;
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean b(IBlockAccess var1, Location var2) {
      return true;
   }

   public boolean canPlace(World var1, Location var2) {
      return this.m(var1, var2.b());
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!this.m(var1, var2.b())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private boolean m(World var1, Location var2) {
      return World.a((IBlockAccess)var1, var2) || var1.getData(var2).c() instanceof BlockFence;
   }

   public void a(World var1, Location var2, IBlockData var3, Random var4) {}

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!var1.isStatic) {
         int var5 = this.e(var3);
         if(var5 > 0) {
            this.a(var1, var2, var3, var5);
         }

      }
   }

   public void a(World var1, Location var2, IBlockData var3, Entity var4) {
      if(!var1.isStatic) {
         int var5 = this.e(var3);
         if(var5 == 0) {
            this.a(var1, var2, var3, var5);
         }

      }
   }

   protected void a(World var1, Location var2, IBlockData var3, int var4) {
      int var5 = this.e(var1, var2);
      boolean var6 = var4 > 0;
      boolean var7 = var5 > 0;
      if(var4 != var5) {
         var3 = this.a(var3, var5);
         var1.a(var2, var3, 2);
         this.d(var1, var2);
         var1.b(var2, var2);
      }

      if(!var7 && var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
      } else if(var7 && !var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(var7) {
         var1.a(var2, (Block)this, this.a(var1));
      }

   }

   protected AxisAlignedBB a(Location var1) {
      float var2 = 0.125F;
      return new AxisAlignedBB((double)((float)var1.n() + 0.125F), (double)var1.o(), (double)((float)var1.p() + 0.125F), (double)((float)(var1.n() + 1) - 0.125F), (double)var1.o() + 0.25D, (double)((float)(var1.p() + 1) - 0.125F));
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      if(this.e(var3) > 0) {
         this.d(var1, var2);
      }

      super.remove(var1, var2, var3);
   }

   protected void d(World var1, Location var2) {
      var1.c(var2, (Block)this);
      var1.c(var2.b(), (Block)this);
   }

   public int a(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      return this.e(var3);
   }

   public int b(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      return var4 == EnumFacing.UP?this.e(var3):0;
   }

   public boolean g() {
      return true;
   }

   public void h() {
      float var1 = 0.5F;
      float var2 = 0.125F;
      float var3 = 0.5F;
      this.a(0.0F, 0.375F, 0.0F, 1.0F, 0.625F, 1.0F);
   }

   public int i() {
      return 1;
   }

   protected abstract int e(World var1, Location var2);

   protected abstract int e(IBlockData var1);

   protected abstract IBlockData a(IBlockData var1, int var2);
}
