package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.List;

public class BlockHopper extends atg {

   public static final beu a = beu.a("facing", (Predicate)(new awy()));
   public static final bet b = bet.a("enabled");


   public BlockHopper() {
      super(Material.ORE);
      this.j(this.L.b().a(a, EnumFacing.DOWN).a(b, Boolean.valueOf(true)));
      this.a(CreativeModeTab.d);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(IBlockAccess var1, Location var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      EnumFacing var9 = var3.d();
      if(var9 == EnumFacing.UP) {
         var9 = EnumFacing.DOWN;
      }

      return this.P().a(a, var9).a(b, Boolean.valueOf(true));
   }

   public TileEntity a(World var1, int var2) {
      return new bde();
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.s()) {
         TileEntity var6 = var1.s(var2);
         if(var6 instanceof bde) {
            ((bde)var6).a(var5.q());
         }
      }

   }

   public void c(World var1, Location var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   public boolean a(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.isStatic) {
         return true;
      } else {
         TileEntity var9 = var1.s(var2);
         if(var9 instanceof bde) {
            var4.a((IInventory)((bde)var9));
         }

         return true;
      }
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private void e(World var1, Location var2, IBlockData var3) {
      boolean var4 = !var1.z(var2);
      if(var4 != ((Boolean)var3.b(b)).booleanValue()) {
         var1.a(var2, var3.a(b, Boolean.valueOf(var4)), 4);
      }

   }

   public void b(World var1, Location var2, IBlockData var3) {
      TileEntity var4 = var1.s(var2);
      if(var4 instanceof bde) {
         vs.a(var1, var2, (bde)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public int b() {
      return 3;
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public static EnumFacing b(int var0) {
      return EnumFacing.a(var0 & 7);
   }

   public static boolean f(int var0) {
      return (var0 & 8) != 8;
   }

   public boolean N() {
      return true;
   }

   public int l(World var1, Location var2) {
      return aib.a(var1.s(var2));
   }

   public IBlockData a(int var1) {
      return this.P().a(a, b(var1)).a(b, Boolean.valueOf(f(var1)));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(a)).a();
      if(!((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

}
