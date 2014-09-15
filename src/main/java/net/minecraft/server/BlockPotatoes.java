package net.minecraft.server;

public class BlockPotatoes extends BlockCrops {

   protected Item j() {
      return Items.bS;
   }

   protected Item l() {
      return Items.bS;
   }

   public void a(World var1, Location var2, IBlockData var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(!var1.isStatic) {
         if(((Integer)var3.b(a)).intValue() >= 7 && var1.random.nextInt(50) == 0) {
            a(var1, var2, new ItemStack(Items.bU));
         }

      }
   }
}
