package net.minecraft.server;

public class anp extends ann {

   public anp(Block var1) {
      super(var1, false);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      MovingObjectPosition var4 = this.a(var2, var3, true);
      if(var4 == null) {
         return var1;
      } else {
         if(var4.a == brv.b) {
            Location var5 = var4.a();
            if(!var2.a(var3, var5)) {
               return var1;
            }

            if(!var3.a(var5.a(var4.b), var4.b, var1)) {
               return var1;
            }

            Location var6 = var5.a();
            IBlockData var7 = var2.getData(var5);
            if(var7.c().getMaterial() == Material.WATER && ((Integer)var7.b(BlockFluids.b)).intValue() == 0 && var2.isEmpty(var6)) {
               var2.a(var6, Blocks.WATER_LILY.P());
               if(!var3.abilities.canInstantlyBuild) {
                  --var1.count;
               }

               var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
            }
         }

         return var1;
      }
   }
}
