package net.minecraft.server;
import java.util.Random;

public class blo extends bln {

   private boolean e;


   public blo() {}

   public blo(Random var1, int var2, int var3) {
      super(var1, var2, 64, var3, 7, 5, 9);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      var1.a("Witch", this.e);
   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      this.e = var1.n("Witch");
   }

   public boolean a(World var1, Random var2, bjb var3) {
      if(!this.a(var1, var3, 0)) {
         return false;
      } else {
         this.a(var1, var3, 1, 1, 1, 5, 1, 7, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 1, 4, 2, 5, 4, 7, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 2, 1, 0, 4, 1, 0, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 2, 2, 2, 3, 3, 2, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 1, 2, 3, 1, 3, 6, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 5, 2, 3, 5, 3, 6, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 2, 2, 7, 4, 3, 7, Blocks.f.a(ayx.b.a()), Blocks.f.a(ayx.b.a()), false);
         this.a(var1, var3, 1, 0, 2, 1, 3, 2, Blocks.r.P(), Blocks.r.P(), false);
         this.a(var1, var3, 5, 0, 2, 5, 3, 2, Blocks.r.P(), Blocks.r.P(), false);
         this.a(var1, var3, 1, 0, 7, 1, 3, 7, Blocks.r.P(), Blocks.r.P(), false);
         this.a(var1, var3, 5, 0, 7, 5, 3, 7, Blocks.r.P(), Blocks.r.P(), false);
         this.a(var1, Blocks.aO.P(), 2, 3, 2, var3);
         this.a(var1, Blocks.aO.P(), 3, 3, 7, var3);
         this.a(var1, Blocks.a.P(), 1, 3, 4, var3);
         this.a(var1, Blocks.a.P(), 5, 3, 4, var3);
         this.a(var1, Blocks.a.P(), 5, 3, 5, var3);
         this.a(var1, Blocks.ca.P().a(BlockFlowerPot.b, awf.r), 1, 3, 5, var3);
         this.a(var1, Blocks.ai.P(), 3, 2, 6, var3);
         this.a(var1, Blocks.bE.P(), 4, 2, 6, var3);
         this.a(var1, Blocks.aO.P(), 1, 2, 1, var3);
         this.a(var1, Blocks.aO.P(), 5, 2, 1, var3);
         int var4 = this.a(Blocks.ad, 3);
         int var5 = this.a(Blocks.ad, 1);
         int var6 = this.a(Blocks.ad, 0);
         int var7 = this.a(Blocks.ad, 2);
         this.a(var1, var3, 0, 4, 1, 6, 4, 1, Blocks.bU.a(var4), Blocks.bU.a(var4), false);
         this.a(var1, var3, 0, 4, 2, 0, 4, 7, Blocks.bU.a(var6), Blocks.bU.a(var6), false);
         this.a(var1, var3, 6, 4, 2, 6, 4, 7, Blocks.bU.a(var5), Blocks.bU.a(var5), false);
         this.a(var1, var3, 0, 4, 8, 6, 4, 8, Blocks.bU.a(var7), Blocks.bU.a(var7), false);

         int var8;
         int var9;
         for(var8 = 2; var8 <= 7; var8 += 5) {
            for(var9 = 1; var9 <= 5; var9 += 4) {
               this.b(var1, Blocks.r.P(), var9, -1, var8, var3);
            }
         }

         if(!this.e) {
            var8 = this.a(2, 5);
            var9 = this.d(2);
            int var10 = this.b(2, 5);
            if(var3.b((fd)(new Location(var8, var9, var10)))) {
               this.e = true;
               EntityWitch var11 = new EntityWitch(var1);
               var11.b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
               var11.a(var1.E(new Location(var8, var9, var10)), (xq)null);
               var1.d((Entity)var11);
            }
         }

         return true;
      }
   }
}
