package net.minecraft.server;

public class BlockHalfTransparent extends Block {

   private boolean a;


   protected BlockHalfTransparent(Material var1, boolean var2) {
      super(var1);
      this.a = var2;
   }

   public boolean c() {
      return false;
   }
}
