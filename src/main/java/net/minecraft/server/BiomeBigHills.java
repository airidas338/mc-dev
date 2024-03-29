package net.minecraft.server;
import java.util.Random;

public class BiomeBigHills extends BiomeBase {

   private WorldGenerator aD;
   private bio aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;


   protected BiomeBigHills(int var1, boolean var2) {
      super(var1);
      this.aD = new bif(Blocks.MONSTER_EGGS.P().a(BlockMonsterEggs.a, axu.a), 9);
      this.aE = new bio(false);
      this.aF = 0;
      this.aG = 1;
      this.aH = 2;
      this.aI = this.aF;
      if(var2) {
         this.as.A = 3;
         this.aI = this.aG;
      }

   }

   public WorldGenTreeAbstract a(Random var1) {
      return (WorldGenTreeAbstract)(var1.nextInt(3) > 0?this.aE:super.a(var1));
   }

   public void a(World var1, Random var2, Location var3) {
      super.a(var1, var2, var3);
      int var4 = 3 + var2.nextInt(6);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var2.nextInt(16);
         var7 = var2.nextInt(28) + 4;
         int var8 = var2.nextInt(16);
         Location var9 = var3.a(var6, var7, var8);
         if(var1.getData(var9).c() == Blocks.STONE) {
            var1.setTypeAndData(var9, Blocks.EMERALD_ORE.P(), 2);
         }
      }

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16);
         var6 = var2.nextInt(64);
         var7 = var2.nextInt(16);
         this.aD.generate(var1, var2, var3.a(var5, var6, var7));
      }

   }

   public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
      this.ak = Blocks.GRASS.P();
      this.al = Blocks.DIRT.P();
      if((var6 < -1.0D || var6 > 2.0D) && this.aI == this.aH) {
         this.ak = Blocks.GRAVEL.P();
         this.al = Blocks.GRAVEL.P();
      } else if(var6 > 1.0D && this.aI != this.aG) {
         this.ak = Blocks.STONE.P();
         this.al = Blocks.STONE.P();
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   private BiomeBigHills b(BiomeBase var1) {
      this.aI = this.aH;
      this.a(var1.ai, true);
      this.a(var1.ah + " M");
      this.a(new BiomeTemperature(var1.an, var1.ao));
      this.a(var1.ap, var1.aq);
      return this;
   }

   protected BiomeBase d(int var1) {
      return (new BiomeBigHills(var1, false)).b(this);
   }
}
