package net.minecraft.server;
import java.util.Iterator;
import java.util.Random;

public class bhg extends WorldGenerator {

   private final Block a;
   private final int b;


   public bhg(Block var1, int var2) {
      super(false);
      this.a = var1;
      this.b = var2;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      while(true) {
         if(var3.o() > 3) {
            label47: {
               if(!var1.d(var3.b())) {
                  Block var4 = var1.getData(var3.b()).c();
                  if(var4 == Blocks.c || var4 == Blocks.d || var4 == Blocks.b) {
                     break label47;
                  }
               }

               var3 = var3.b();
               continue;
            }
         }

         if(var3.o() <= 3) {
            return false;
         }

         int var12 = this.b;

         for(int var5 = 0; var12 >= 0 && var5 < 3; ++var5) {
            int var6 = var12 + var2.nextInt(2);
            int var7 = var12 + var2.nextInt(2);
            int var8 = var12 + var2.nextInt(2);
            float var9 = (float)(var6 + var7 + var8) * 0.333F + 0.5F;
            Iterator var10 = Location.a(var3.a(-var6, -var7, -var8), var3.a(var6, var7, var8)).iterator();

            while(var10.hasNext()) {
               Location var11 = (Location)var10.next();
               if(var11.i(var3) <= (double)(var9 * var9)) {
                  var1.a(var11, this.a.P(), 4);
               }
            }

            var3 = var3.a(-(var12 + 1) + var2.nextInt(2 + var12 * 2), 0 - var2.nextInt(2), -(var12 + 1) + var2.nextInt(2 + var12 * 2));
         }

         return true;
      }
   }
}
