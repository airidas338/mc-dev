package net.minecraft.server;

public class akt extends Item {

   private Block a;


   public akt(Block var1) {
      this.a = var1;
      this.a(CreativeModeTab.d);
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var5 != EnumFacing.UP) {
         return false;
      } else {
         IBlockData var9 = var3.getData(var4);
         Block var10 = var9.c();
         if(!var10.f(var3, var4)) {
            var4 = var4.a(var5);
         }

         if(!var2.a(var4, var5, var1)) {
            return false;
         } else if(!this.a.canPlace(var3, var4)) {
            return false;
         } else {
            a(var3, var4, EnumFacing.a((double)var2.y), this.a);
            --var1.b;
            return true;
         }
      }
   }

   public static void a(World var0, Location var1, EnumFacing var2, Block var3) {
      Location var4 = var1.a(var2.e());
      Location var5 = var1.a(var2.f());
      int var6 = (var0.getData(var5).c().t()?1:0) + (var0.getData(var5.a()).c().t()?1:0);
      int var7 = (var0.getData(var4).c().t()?1:0) + (var0.getData(var4.a()).c().t()?1:0);
      boolean var8 = var0.getData(var5).c() == var3 || var0.getData(var5.a()).c() == var3;
      boolean var9 = var0.getData(var4).c() == var3 || var0.getData(var4.a()).c() == var3;
      boolean var10 = false;
      if(var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      Location var11 = var1.a();
      IBlockData var12 = var3.P().a(BlockDoor.a, var2).a(BlockDoor.M, var10?avh.b:avh.a);
      var0.a(var1, var12.a(BlockDoor.O, avg.b), 2);
      var0.a(var11, var12.a(BlockDoor.O, avg.a), 2);
      var0.c(var1, var3);
      var0.c(var11, var3);
   }
}
