package net.minecraft.server;
import java.util.Random;

public class BiomeIcePlains extends BiomeBase {

   private boolean aD;
   private bhx aE = new bhx();
   private bhw aF = new bhw(4);


   public BiomeIcePlains(int var1, boolean var2) {
      super(var1);
      this.aD = var2;
      if(var2) {
         this.ak = Blocks.SNOW_BLOCK.P();
      }

      this.au.clear();
   }

   public void a(World var1, Random var2, Location var3) {
      if(this.aD) {
         int var4;
         int var5;
         int var6;
         for(var4 = 0; var4 < 3; ++var4) {
            var5 = var2.nextInt(16) + 8;
            var6 = var2.nextInt(16) + 8;
            this.aE.generate(var1, var2, var1.m(var3.a(var5, 0, var6)));
         }

         for(var4 = 0; var4 < 2; ++var4) {
            var5 = var2.nextInt(16) + 8;
            var6 = var2.nextInt(16) + 8;
            this.aF.generate(var1, var2, var1.m(var3.a(var5, 0, var6)));
         }
      }

      super.a(var1, var2, var3);
   }

   public WorldGenTreeAbstract a(Random var1) {
      return new bio(false);
   }

   protected BiomeBase d(int var1) {
      BiomeBase var2 = (new BiomeIcePlains(var1, true)).a(13828095, true).a(this.ah + " Spikes").c().a(0.0F, 0.5F).a(new BiomeTemperature(this.an + 0.1F, this.ao + 0.1F));
      var2.an = this.an + 0.3F;
      var2.ao = this.ao + 0.4F;
      return var2;
   }
}
