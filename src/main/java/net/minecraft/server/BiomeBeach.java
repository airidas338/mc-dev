package net.minecraft.server;

public class BiomeBeach extends BiomeBase {

   public BiomeBeach(int var1) {
      super(var1);
      this.au.clear();
      this.ak = Blocks.SAND.P();
      this.al = Blocks.SAND.P();
      this.as.A = -999;
      this.as.D = 0;
      this.as.F = 0;
      this.as.G = 0;
   }
}
