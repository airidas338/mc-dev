package net.minecraft.server;
import java.util.Random;

public class BlockGravel extends BlockFalling {

   public Item a(IBlockData var1, Random var2, int var3) {
      if(var3 > 3) {
         var3 = 3;
      }

      return var2.nextInt(10 - var3 * 3) == 0?Items.ak:Item.getItemOf((Block)this);
   }
}
