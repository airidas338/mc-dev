package net.minecraft.server;
import java.util.Random;

public class asb extends arm {

   private bhp aD;
   private bio aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;


   protected asb(int var1, boolean var2) {
      super(var1);
      this.aD = new bif(aty.be.P().a(axs.a, axu.a), 9);
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

   public bhc a(Random var1) {
      return (bhc)(var1.nextInt(3) > 0?this.aE:super.a(var1));
   }

   public void a(aqu var1, Random var2, dt var3) {
      super.a(var1, var2, var3);
      int var4 = 3 + var2.nextInt(6);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var2.nextInt(16);
         var7 = var2.nextInt(28) + 4;
         int var8 = var2.nextInt(16);
         dt var9 = var3.a(var6, var7, var8);
         if(var1.p(var9).c() == aty.b) {
            var1.a(var9, aty.bP.P(), 2);
         }
      }

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16);
         var6 = var2.nextInt(64);
         var7 = var2.nextInt(16);
         this.aD.b(var1, var2, var3.a(var5, var6, var7));
      }

   }

   public void a(aqu var1, Random var2, bgk var3, int var4, int var5, double var6) {
      this.ak = aty.c.P();
      this.al = aty.d.P();
      if((var6 < -1.0D || var6 > 2.0D) && this.aI == this.aH) {
         this.ak = aty.n.P();
         this.al = aty.n.P();
      } else if(var6 > 1.0D && this.aI != this.aG) {
         this.ak = aty.b.P();
         this.al = aty.b.P();
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   private asb b(arm var1) {
      this.aI = this.aH;
      this.a(var1.ai, true);
      this.a(var1.ah + " M");
      this.a(new aro(var1.an, var1.ao));
      this.a(var1.ap, var1.aq);
      return this;
   }

   protected arm d(int var1) {
      return (new asb(var1, false)).b(this);
   }
}
