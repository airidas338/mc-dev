package net.minecraft.server;

public class anj extends ItemBlock {

   public anj(Block var1) {
      super(var1);
      this.d(0);
      this.a(true);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.count == 0) {
         return false;
      } else if(!var2.a(var4, var5, var1)) {
         return false;
      } else {
         IBlockData var9 = var3.getData(var4);
         Block var10 = var9.c();
         if(var10 != this.a && var5 != EnumFacing.UP) {
            var4 = var4.a(var5);
            var9 = var3.getData(var4);
            var10 = var9.c();
         }

         if(var10 == this.a) {
            int var11 = ((Integer)var9.b(BlockSnow.a)).intValue();
            if(var11 <= 7) {
               IBlockData var12 = var9.a(BlockSnow.a, Integer.valueOf(var11 + 1));
               if(var3.b(this.a.a(var3, var4, var12)) && var3.setTypeAndData(var4, var12, 2)) {
                  var3.makeSound((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
                  --var1.count;
                  return true;
               }
            }
         }

         return super.interactWith(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public int a(int var1) {
      return var1;
   }
}
