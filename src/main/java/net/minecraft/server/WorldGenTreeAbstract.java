package net.minecraft.server;
import java.util.Random;

public abstract class WorldGenTreeAbstract extends WorldGenerator {

   public WorldGenTreeAbstract(boolean var1) {
      super(var1);
   }

   protected boolean a(Block var1) {
      return var1.getMaterial() == Material.AIR || var1.getMaterial() == Material.LEAVES || var1 == Blocks.GRASS || var1 == Blocks.DIRT || var1 == Blocks.LOG || var1 == Blocks.LOG2 || var1 == Blocks.SAPLING || var1 == Blocks.VINE;
   }

   public void a(World var1, Random var2, Location var3) {}

   protected void a(World var1, Location var2) {
      if(var1.getData(var2).c() != Blocks.DIRT) {
         this.a(var1, var2, Blocks.DIRT.P());
      }

   }
}
