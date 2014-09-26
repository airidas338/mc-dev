package net.minecraft.server;


public class ItemReed extends Item {

   private Block a;


   public ItemReed(Block var1) {
      this.a = var1;
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlockData var9 = var3.getData(var4);
      Block var10 = var9.c();
      if(var10 == Blocks.SNOW && ((Integer)var9.b(BlockSnow.a)).intValue() < 1) {
         var5 = EnumFacing.UP;
      } else if(!var10.f(var3, var4)) {
         var4 = var4.a(var5);
      }

      if(!var2.a(var4, var5, var1)) {
         return false;
      } else if(var1.count == 0) {
         return false;
      } else {
         if(var3.mayPlace(this.a, var4, false, var5, (Entity)null, var1)) {
            IBlockData var11 = this.a.getPlacedData(var3, var4, var5, var6, var7, var8, 0, var2);
            if(var3.setTypeAndData(var4, var11, 3)) {
               var11 = var3.getData(var4);
               if(var11.c() == this.a) {
                  ItemBlock.a(var3, var4, var1);
                  var11.c().a(var3, var4, var11, (EntityLiving)var2, var1);
               }

               var3.makeSound((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
               --var1.count;
               return true;
            }
         }

         return false;
      }
   }
}
