package net.minecraft.server;
import java.util.Random;

public class BlockMycel extends Block {

   public static final bet a = bet.a("snowy");


   protected BlockMycel() {
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
            var1.a(var2, Blocks.DIRT.P().a(BlockDirt.a, avd.a));
         } else {
            if(var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  Location var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  IBlockData var7 = var1.getData(var6);
                  Block var8 = var1.getData(var6.a()).c();
                  if(var7.c() == Blocks.DIRT && var7.b(BlockDirt.a) == avd.a && var1.l(var6.a()) >= 4 && var8.n() <= 2) {
                     var1.a(var6, this.P());
                  }
               }
            }

         }
      }
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.a(Blocks.DIRT.P().a(BlockDirt.a, avd.a), var2, var3);
   }

   public int c(IBlockData var1) {
      return 0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
