package net.minecraft.server;

public class BiomeTheEnd extends BiomeBase {

   public BiomeTheEnd(int var1) {
      super(var1);
      this.at.clear();
      this.au.clear();
      this.av.clear();
      this.aw.clear();
      this.at.add(new BiomeMeta(EntityEnderman.class, 10, 4, 4));
      this.ak = aty.d.P();
      this.al = aty.d.P();
      this.as = new asw();
   }
}
