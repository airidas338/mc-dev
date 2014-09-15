package net.minecraft.server;
import java.util.Random;

public class WorldGenGrass extends WorldGenerator {

   private final IBlockData a;


   public WorldGenGrass(EnumFoliage var1) {
      this.a = Blocks.LONG_GRASS.P().a(BlockLongGrass.a, var1);
   }

   public boolean generate(World var1, Random var2, Location var3) {
      Block var4;
      while(((var4 = var1.getData(var3).c()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.o() > 0) {
         var3 = var3.b();
      }

      for(int var5 = 0; var5 < 128; ++var5) {
         Location var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var6) && Blocks.LONG_GRASS.f(var1, var6, this.a)) {
            var1.a(var6, this.a, 2);
         }
      }

      return true;
   }
}
