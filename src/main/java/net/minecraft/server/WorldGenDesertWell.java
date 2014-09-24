package net.minecraft.server;
import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.Random;

public class WorldGenDesertWell extends WorldGenerator {

   private static final beq a = beq.a((Block)Blocks.SAND).a(BlockSand.a, Predicates.equalTo(bac.a));
   private final IBlockData b;
   private final IBlockData c;
   private final IBlockData d;


   public WorldGenDesertWell() {
      this.b = Blocks.STEP1.P().a(BlockStep1Abstract.M, bbg.b).a(BlockStepAbstract.a, awr.b);
      this.c = Blocks.SANDSTONE.P();
      this.d = Blocks.WATER.P();
   }

   public boolean generate(World var1, Random var2, Location var3) {
      while(var1.isEmpty(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if(!a.a(var1.getData(var3))) {
         return false;
      } else {
         int var4;
         int var5;
         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if(var1.isEmpty(var3.a(var4, -1, var5)) && var1.isEmpty(var3.a(var4, -2, var5))) {
                  return false;
               }
            }
         }

         for(var4 = -1; var4 <= 0; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               for(int var6 = -2; var6 <= 2; ++var6) {
                  var1.setTypeAndData(var3.a(var5, var4, var6), this.c, 2);
               }
            }
         }

         var1.setTypeAndData(var3, this.d, 2);
         Iterator var7 = en.a.iterator();

         while(var7.hasNext()) {
            EnumFacing var8 = (EnumFacing)var7.next();
            var1.setTypeAndData(var3.a(var8), this.d, 2);
         }

         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if(var4 == -2 || var4 == 2 || var5 == -2 || var5 == 2) {
                  var1.setTypeAndData(var3.a(var4, 1, var5), this.c, 2);
               }
            }
         }

         var1.setTypeAndData(var3.a(2, 1, 0), this.b, 2);
         var1.setTypeAndData(var3.a(-2, 1, 0), this.b, 2);
         var1.setTypeAndData(var3.a(0, 1, 2), this.b, 2);
         var1.setTypeAndData(var3.a(0, 1, -2), this.b, 2);

         for(var4 = -1; var4 <= 1; ++var4) {
            for(var5 = -1; var5 <= 1; ++var5) {
               if(var4 == 0 && var5 == 0) {
                  var1.setTypeAndData(var3.a(var4, 4, var5), this.c, 2);
               } else {
                  var1.setTypeAndData(var3.a(var4, 4, var5), this.b, 2);
               }
            }
         }

         for(var4 = 1; var4 <= 3; ++var4) {
            var1.setTypeAndData(var3.a(-1, var4, -1), this.c, 2);
            var1.setTypeAndData(var3.a(-1, var4, 1), this.c, 2);
            var1.setTypeAndData(var3.a(1, var4, -1), this.c, 2);
            var1.setTypeAndData(var3.a(1, var4, 1), this.c, 2);
         }

         return true;
      }
   }

}
