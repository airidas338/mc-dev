package net.minecraft.server;
import java.util.Random;

public class BlockGlass extends BlockHalfTransparent {

   public BlockGlass(Material var1, boolean var2) {
      super(var1, var2);
      this.a(CreativeModeTab.b);
   }

   public int a(Random var1) {
      return 0;
   }

   public boolean d() {
      return false;
   }

   protected boolean G() {
      return true;
   }
}
