package net.minecraft.server;

final class DispenserBehaviorEmptyBucket extends DispenserBehaviorItem {

   private final DispenserBehaviorItem b = new DispenserBehaviorItem();


   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      IBlockData var5 = var3.getData(var4);
      Block var6 = var5.c();
      Material var7 = var6.getMaterial();
      Item var8;
      if(Material.WATER.equals(var7) && var6 instanceof BlockFluids && ((Integer)var5.b(BlockFluids.b)).intValue() == 0) {
         var8 = Items.ax;
      } else {
         if(!Material.LAVA.equals(var7) || !(var6 instanceof BlockFluids) || ((Integer)var5.b(BlockFluids.b)).intValue() != 0) {
            return super.b(var1, var2);
         }

         var8 = Items.ay;
      }

      var3.setAir(var4);
      if(--var2.count == 0) {
         var2.setItem(var8);
         var2.count = 1;
      } else if(((TileEntityDispenser)var1.h()).a(new ItemStack(var8)) < 0) {
         this.b.a(var1, new ItemStack(var8));
      }

      return var2;
   }
}
