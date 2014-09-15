package net.minecraft.server;
import java.util.Random;

public class bis extends WorldGenerator {

   public boolean generate(World var1, Random var2, Location var3) {
      for(; var3.o() < 128; var3 = var3.a()) {
         if(var1.isEmpty(var3)) {
            EnumFacing[] var4 = en.a.a();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               EnumFacing var7 = var4[var6];
               if(Blocks.VINE.canPlace(var1, var3, var7)) {
                  IBlockData var8 = Blocks.VINE.P().a(BlockVine.b, Boolean.valueOf(var7 == EnumFacing.NORTH)).a(BlockVine.M, Boolean.valueOf(var7 == EnumFacing.EAST)).a(BlockVine.N, Boolean.valueOf(var7 == EnumFacing.SOUTH)).a(BlockVine.O, Boolean.valueOf(var7 == EnumFacing.WEST));
                  var1.a(var3, var8, 2);
                  break;
               }
            }
         } else {
            var3 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         }
      }

      return true;
   }
}
