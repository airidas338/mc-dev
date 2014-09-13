package net.minecraft.server;
import java.util.Random;

public abstract class WorldGenTreeAbstract extends WorldGenerator {

   public WorldGenTreeAbstract(boolean var1) {
      super(var1);
   }

   protected boolean a(Block var1) {
      return var1.r() == Material.AIR || var1.r() == Material.LEAVES || var1 == Blocks.c || var1 == Blocks.d || var1 == Blocks.r || var1 == Blocks.s || var1 == Blocks.g || var1 == Blocks.bn;
   }

   public void a(World var1, Random var2, Location var3) {}

   protected void a(World var1, Location var2) {
      if(var1.getData(var2).c() != Blocks.d) {
         this.a(var1, var2, Blocks.d.P());
      }

   }
}
