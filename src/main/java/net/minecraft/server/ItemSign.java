package net.minecraft.server;

public class ItemSign extends Item {

   public ItemSign() {
      this.maxStackSize = 16;
      this.a(CreativeModeTab.c);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var5 == EnumFacing.DOWN) {
         return false;
      } else if(!var3.getData(var4).c().getMaterial().isBuildable()) {
         return false;
      } else {
         var4 = var4.a(var5);
         if(!var2.a(var4, var5, var1)) {
            return false;
         } else if(!Blocks.SIGN_POST.canPlace(var3, var4)) {
            return false;
         } else if(var3.isStatic) {
            return true;
         } else {
            if(var5 == EnumFacing.UP) {
               int var9 = MathHelper.floor((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.setTypeAndData(var4, Blocks.SIGN_POST.P().a(BlockStandingSign.a, Integer.valueOf(var9)), 3);
            } else {
               var3.setTypeAndData(var4, Blocks.WALL_SIGN.P().a(BlockWallSign.a, var5), 3);
            }

            --var1.count;
            TileEntity var10 = var3.getTileEntity(var4);
            if(var10 instanceof TileEntitySign && !ItemBlock.a(var3, var4, var1)) {
               var2.a((TileEntitySign)var10);
            }

            return true;
         }
      }
   }
}
