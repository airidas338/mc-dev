package net.minecraft.server;
import java.util.List;
import java.util.Random;

public abstract class BlockStepAbstract extends Block {

   public static final bev a = bev.a("half", awr.class);


   public BlockStepAbstract(Material var1) {
      super(var1);
      if(this.j()) {
         this.r = true;
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

      this.e(255);
   }

   protected boolean G() {
      return false;
   }

   public void updateShape(IBlockAccess var1, Location var2) {
      if(this.j()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         IBlockData var3 = var1.getData(var2);
         if(var3.c() == this) {
            if(var3.b(a) == awr.a) {
               this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
         }

      }
   }

   public void h() {
      if(this.j()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.updateShape(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public boolean c() {
      return this.j();
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = super.getPlacedData(var1, var2, var3, var4, var5, var6, var7, var8).a(a, awr.b);
      return this.j()?var9:(var3 != EnumFacing.DOWN && (var3 == EnumFacing.UP || (double)var5 <= 0.5D)?var9:var9.a(a, awr.a));
   }

   public int a(Random var1) {
      return this.j()?2:1;
   }

   public boolean d() {
      return this.j();
   }

   public abstract String b(int var1);

   public int j(World var1, Location var2) {
      return super.j(var1, var2) & 7;
   }

   public abstract boolean j();

   public abstract bex l();

   public abstract Object a(ItemStack var1);

}
