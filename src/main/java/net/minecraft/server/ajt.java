package net.minecraft.server;

public class ajt extends Item {

   public ajt() {
      this.a(CreativeModeTab.c);
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var3.isStatic) {
         return true;
      } else if(var5 != EnumFacing.UP) {
         return false;
      } else {
         IBlockData var9 = var3.getData(var4);
         Block var10 = var9.c();
         boolean var11 = var10.f(var3, var4);
         if(!var11) {
            var4 = var4.a();
         }

         int var12 = MathHelper.floor((double)(var2.y * 4.0F / 360.0F) + 0.5D) & 3;
         EnumFacing var13 = EnumFacing.b(var12);
         Location var14 = var4.a(var13);
         boolean var15 = var10.f(var3, var14);
         boolean var16 = var3.isEmpty(var4) || var11;
         boolean var17 = var3.isEmpty(var14) || var15;
         if(var2.a(var4, var5, var1) && var2.a(var14, var5, var1)) {
            if(var16 && var17 && World.a((IBlockAccess)var3, var4.b()) && World.a((IBlockAccess)var3, var14.b())) {
               int var18 = var13.b();
               IBlockData var19 = Blocks.BED.P().a(BlockBed.b, Boolean.valueOf(false)).a(BlockBed.N, var13).a(BlockBed.a, atq.b);
               if(var3.setTypeAndData(var4, var19, 3)) {
                  IBlockData var20 = var19.a(BlockBed.a, atq.a);
                  var3.setTypeAndData(var14, var20, 3);
               }

               --var1.b;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }
}
