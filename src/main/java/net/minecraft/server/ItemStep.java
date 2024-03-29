package net.minecraft.server;

public class ItemStep extends ItemBlock {

   private final BlockStepAbstract b;
   private final BlockStepAbstract c;


   public ItemStep(Block var1, BlockStepAbstract var2, BlockStepAbstract var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      return this.b.b(var1.getData());
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.count == 0) {
         return false;
      } else if(!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         Object var9 = this.b.a(var1);
         IBlockData var10 = var3.getData(var4);
         if(var10.c() == this.b) {
            bex var11 = this.b.l();
            Comparable var12 = var10.b(var11);
            awr var13 = (awr)var10.b(BlockStepAbstract.a);
            if((var5 == EnumFacing.UP && var13 == awr.b || var5 == EnumFacing.DOWN && var13 == awr.a) && var12 == var9) {
               IBlockData var14 = this.c.P().a(var11, var12);
               if(var3.b(this.c.a(var3, var4, var14)) && var3.setTypeAndData(var4, var14, 3)) {
                  var3.makeSound((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
                  --var1.count;
               }

               return true;
            }
         }

         return this.a(var1, var3, var4.a(var5), var9)?true:super.interactWith(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   private boolean a(ItemStack var1, World var2, Location var3, Object var4) {
      IBlockData var5 = var2.getData(var3);
      if(var5.c() == this.b) {
         Comparable var6 = var5.b(this.b.l());
         if(var6 == var4) {
            IBlockData var7 = this.c.P().a(this.b.l(), var6);
            if(var2.b(this.c.a(var2, var3, var7)) && var2.setTypeAndData(var3, var7, 3)) {
               var2.makeSound((double)((float)var3.n() + 0.5F), (double)((float)var3.o() + 0.5F), (double)((float)var3.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
               --var1.count;
            }

            return true;
         }
      }

      return false;
   }
}
