package net.minecraft.server;


public class ItemHoe extends Item {

   protected EnumToolMaterial a;


   public ItemHoe(EnumToolMaterial var1) {
      this.a = var1;
      this.maxStackSize = 1;
      this.d(var1.a());
      this.a(CreativeModeTab.i);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         IBlockData var9 = var3.getData(var4);
         Block var10 = var9.c();
         if(var5 != EnumFacing.DOWN && var3.getData(var4.a()).c().getMaterial() == Material.AIR) {
            if(var10 == Blocks.GRASS) {
               return this.a(var1, var2, var3, var4, Blocks.SOIL.P());
            }

            if(var10 == Blocks.DIRT) {
               switch(alp.a[((avd)var9.b(BlockDirt.a)).ordinal()]) {
               case 1:
                  return this.a(var1, var2, var3, var4, Blocks.SOIL.P());
               case 2:
                  return this.a(var1, var2, var3, var4, Blocks.DIRT.P().a(BlockDirt.a, avd.a));
               }
            }
         }

         return false;
      }
   }

   protected boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, IBlockData var5) {
      var3.makeSound((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), var5.c().H.c(), (var5.c().H.d() + 1.0F) / 2.0F, var5.c().H.e() * 0.8F);
      if(var3.isStatic) {
         return true;
      } else {
         var3.a(var4, var5);
         var1.damage(1, (EntityLiving)var2);
         return true;
      }
   }

   public String g() {
      return this.a.toString();
   }
}
