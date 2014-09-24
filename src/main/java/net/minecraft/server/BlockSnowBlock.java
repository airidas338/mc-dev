package net.minecraft.server;
import java.util.Random;

public class BlockSnowBlock extends Block {

   protected BlockSnowBlock() {
      super(Material.SNOW_BLOCK);
      this.a(true);
      this.a(CreativeModeTab.b);
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.aD;
   }

   public int a(Random var1) {
      return 4;
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(var1.b(EnumSkyBlock.BLOCK, var2) > 11) {
         this.b(var1, var2, var1.getData(var2), 0);
         var1.setAir(var2);
      }

   }
}
