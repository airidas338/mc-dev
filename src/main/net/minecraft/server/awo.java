package net.minecraft.server;
import java.util.Random;

public class awo extends avt {

   public alq a(IBlock var1, Random var2, int var3) {
      if(var3 > 3) {
         var3 = 3;
      }

      return var2.nextInt(10 - var3 * 3) == 0?Items.ak:alq.a((Block)this);
   }
}
