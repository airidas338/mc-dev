package net.minecraft.server;
import com.google.common.base.Function;

public class ItemMultiTexture extends ItemBlock {

   protected final Block b;
   protected final Function c;


   public ItemMultiTexture(Block var1, Block var2, Function var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d(0);
      this.a(true);
   }

   public ItemMultiTexture(Block var1, Block var2, String[] var3) {
      this(var1, var2, (Function)(new ams(var3)));
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      return super.a() + "." + (String)this.c.apply(var1);
   }
}
