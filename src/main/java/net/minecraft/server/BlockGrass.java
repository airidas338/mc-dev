package net.minecraft.server;
import java.util.Random;

public class BlockGrass extends Block implements atz {

   public static final bet a = bet.a("snowy");


   protected BlockGrass() {
      super(Material.GRASS);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
      this.a(true);
      this.a(CreativeModeTab.b);
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      Block var4 = var2.getData(var3.a()).c();
      return var1.a(a, Boolean.valueOf(var4 == Blocks.SNOW_BLOCK || var4 == Blocks.SNOW));
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!var1.isStatic) {
         if(var1.l(var2.a()) < 4 && var1.getData(var2.a()).c().n() > 2) {
            var1.a(var2, Blocks.DIRT.P());
         } else {
            if(var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  Location var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  Block var7 = var1.getData(var6.a()).c();
                  IBlockData var8 = var1.getData(var6);
                  if(var8.c() == Blocks.DIRT && var8.b(BlockDirt.a) == avd.a && var1.l(var6.a()) >= 4 && var7.n() <= 2) {
                     var1.a(var6, Blocks.GRASS.P());
                  }
               }
            }

         }
      }
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.a(Blocks.DIRT.P().a(BlockDirt.a, avd.a), var2, var3);
   }

   public boolean a(World var1, Location var2, IBlockData var3, boolean var4) {
      return true;
   }

   public boolean a(World var1, Random var2, Location var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, Location var3, IBlockData var4) {
      Location var5 = var3.a();
      int var6 = 0;

      while(var6 < 128) {
         Location var7 = var5;
         int var8 = 0;

         while(true) {
            if(var8 < var6 / 16) {
               var7 = var7.a(var2.nextInt(3) - 1, (var2.nextInt(3) - 1) * var2.nextInt(3) / 2, var2.nextInt(3) - 1);
               if(var1.getData(var7.b()).c() == Blocks.GRASS && !var1.getData(var7).c().t()) {
                  ++var8;
                  continue;
               }
            } else if(var1.getData(var7).c().J == Material.AIR) {
               if(var2.nextInt(8) == 0) {
                  EnumFlowerType var11 = var1.getBiome(var7).a(var2, var7);
                  BlockFlowers var9 = var11.a().a();
                  IBlockData var10 = var9.P().a(var9.l(), var11);
                  if(var9.f(var1, var7, var10)) {
                     var1.a(var7, var10, 3);
                  }
               } else {
                  IBlockData var12 = Blocks.LONG_GRASS.P().a(BlockLongGrass.a, EnumFoliage.b);
                  if(Blocks.LONG_GRASS.f(var1, var7, var12)) {
                     var1.a(var7, var12, 3);
                  }
               }
            }

            ++var6;
            break;
         }
      }

   }

   public int c(IBlockData var1) {
      return 0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
