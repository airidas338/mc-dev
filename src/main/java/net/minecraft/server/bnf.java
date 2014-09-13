package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bnf extends bnn {

   public bnf() {}

   public bnf(bnk var1, int var2, Random var3, bjb var4, ej var5) {
      super(var1, var2);
      this.m = var5;
      this.l = var4;
   }

   public static bnf a(bnk var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
      bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 9, 7, 11, var6);
      return a(var8) && bms.a(var1, var8) == null?new bnf(var0, var7, var2, var8, var6):null;
   }

   public boolean a(World var1, Random var2, bjb var3) {
      if(this.h < 0) {
         this.h = this.b(var1, var3);
         if(this.h < 0) {
            return true;
         }

         this.l.a(0, this.h - this.l.e + 7 - 1, 0);
      }

      this.a(var1, var3, 1, 1, 1, 7, 4, 4, Blocks.a.P(), Blocks.a.P(), false);
      this.a(var1, var3, 2, 1, 6, 8, 4, 10, Blocks.a.P(), Blocks.a.P(), false);
      this.a(var1, var3, 2, 0, 6, 8, 0, 10, Blocks.d.P(), Blocks.d.P(), false);
      this.a(var1, Blocks.e.P(), 6, 0, 6, var3);
      this.a(var1, var3, 2, 1, 6, 2, 1, 10, Blocks.aO.P(), Blocks.aO.P(), false);
      this.a(var1, var3, 8, 1, 6, 8, 1, 10, Blocks.aO.P(), Blocks.aO.P(), false);
      this.a(var1, var3, 3, 1, 10, 7, 1, 10, Blocks.aO.P(), Blocks.aO.P(), false);
      this.a(var1, var3, 1, 0, 1, 7, 0, 4, Blocks.f.P(), Blocks.f.P(), false);
      this.a(var1, var3, 0, 0, 0, 0, 3, 5, Blocks.e.P(), Blocks.e.P(), false);
      this.a(var1, var3, 8, 0, 0, 8, 3, 5, Blocks.e.P(), Blocks.e.P(), false);
      this.a(var1, var3, 1, 0, 0, 7, 1, 0, Blocks.e.P(), Blocks.e.P(), false);
      this.a(var1, var3, 1, 0, 5, 7, 1, 5, Blocks.e.P(), Blocks.e.P(), false);
      this.a(var1, var3, 1, 2, 0, 7, 3, 0, Blocks.f.P(), Blocks.f.P(), false);
      this.a(var1, var3, 1, 2, 5, 7, 3, 5, Blocks.f.P(), Blocks.f.P(), false);
      this.a(var1, var3, 0, 4, 1, 8, 4, 1, Blocks.f.P(), Blocks.f.P(), false);
      this.a(var1, var3, 0, 4, 4, 8, 4, 4, Blocks.f.P(), Blocks.f.P(), false);
      this.a(var1, var3, 0, 5, 2, 8, 5, 3, Blocks.f.P(), Blocks.f.P(), false);
      this.a(var1, Blocks.f.P(), 0, 4, 2, var3);
      this.a(var1, Blocks.f.P(), 0, 4, 3, var3);
      this.a(var1, Blocks.f.P(), 8, 4, 2, var3);
      this.a(var1, Blocks.f.P(), 8, 4, 3, var3);
      int var4 = this.a(Blocks.ad, 3);
      int var5 = this.a(Blocks.ad, 2);

      int var6;
      int var7;
      for(var6 = -1; var6 <= 2; ++var6) {
         for(var7 = 0; var7 <= 8; ++var7) {
            this.a(var1, Blocks.ad.a(var4), var7, 4 + var6, var6, var3);
            this.a(var1, Blocks.ad.a(var5), var7, 4 + var6, 5 - var6, var3);
         }
      }

      this.a(var1, Blocks.r.P(), 0, 2, 1, var3);
      this.a(var1, Blocks.r.P(), 0, 2, 4, var3);
      this.a(var1, Blocks.r.P(), 8, 2, 1, var3);
      this.a(var1, Blocks.r.P(), 8, 2, 4, var3);
      this.a(var1, Blocks.bj.P(), 0, 2, 2, var3);
      this.a(var1, Blocks.bj.P(), 0, 2, 3, var3);
      this.a(var1, Blocks.bj.P(), 8, 2, 2, var3);
      this.a(var1, Blocks.bj.P(), 8, 2, 3, var3);
      this.a(var1, Blocks.bj.P(), 2, 2, 5, var3);
      this.a(var1, Blocks.bj.P(), 3, 2, 5, var3);
      this.a(var1, Blocks.bj.P(), 5, 2, 0, var3);
      this.a(var1, Blocks.bj.P(), 6, 2, 5, var3);
      this.a(var1, Blocks.aO.P(), 2, 1, 3, var3);
      this.a(var1, Blocks.aB.P(), 2, 2, 3, var3);
      this.a(var1, Blocks.f.P(), 1, 1, 4, var3);
      this.a(var1, Blocks.ad.a(this.a(Blocks.ad, 3)), 2, 1, 4, var3);
      this.a(var1, Blocks.ad.a(this.a(Blocks.ad, 1)), 1, 1, 3, var3);
      this.a(var1, var3, 5, 0, 1, 7, 0, 3, Blocks.T.P(), Blocks.T.P(), false);
      this.a(var1, Blocks.T.P(), 6, 1, 1, var3);
      this.a(var1, Blocks.T.P(), 6, 1, 2, var3);
      this.a(var1, Blocks.a.P(), 2, 1, 0, var3);
      this.a(var1, Blocks.a.P(), 2, 2, 0, var3);
      this.a(var1, Blocks.aa.P().a(BlockTorch.a, this.m), 2, 3, 1, var3);
      this.a(var1, var3, var2, 2, 1, 0, ej.b(this.a(Blocks.ao, 1)));
      if(this.a(var1, 2, 0, -1, var3).c().r() == Material.AIR && this.a(var1, 2, -1, -1, var3).c().r() != Material.AIR) {
         this.a(var1, Blocks.aw.a(this.a(Blocks.aw, 3)), 2, 0, -1, var3);
      }

      this.a(var1, Blocks.a.P(), 6, 1, 5, var3);
      this.a(var1, Blocks.a.P(), 6, 2, 5, var3);
      this.a(var1, Blocks.aa.P().a(BlockTorch.a, this.m.d()), 6, 3, 4, var3);
      this.a(var1, var3, var2, 6, 1, 5, ej.b(this.a(Blocks.ao, 1)));

      for(var6 = 0; var6 < 5; ++var6) {
         for(var7 = 0; var7 < 9; ++var7) {
            this.b(var1, var7, 7, var6, var3);
            this.b(var1, Blocks.e.P(), var7, -1, var6, var3);
         }
      }

      this.a(var1, var3, 4, 1, 2, 2);
      return true;
   }

   protected int c(int var1, int var2) {
      return var1 == 0?4:super.c(var1, var2);
   }
}
