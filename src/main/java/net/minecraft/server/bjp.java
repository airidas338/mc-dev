package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bjp extends bkb {

   public bjp() {}

   public bjp(int var1, Random var2, bjb var3, ej var4) {
      super(var1);
      this.m = var4;
      this.l = var3;
   }

   protected bjp(Random var1, int var2, int var3) {
      super(0);
      this.m = en.a.a(var1);
      switch(bjo.a[this.m.ordinal()]) {
      case 1:
      case 2:
         this.l = new bjb(var2, 64, var3, var2 + 19 - 1, 73, var3 + 19 - 1);
         break;
      default:
         this.l = new bjb(var2, 64, var3, var2 + 19 - 1, 73, var3 + 19 - 1);
      }

   }

   public void a(bms var1, List var2, Random var3) {
      this.a((bkf)var1, var2, var3, 8, 3, false);
      this.b((bkf)var1, var2, var3, 3, 8, false);
      this.c((bkf)var1, var2, var3, 3, 8, false);
   }

   public static bjp a(List var0, Random var1, int var2, int var3, int var4, ej var5, int var6) {
      bjb var7 = bjb.a(var2, var3, var4, -8, -3, 0, 19, 10, 19, var5);
      return a(var7) && bms.a(var0, var7) == null?new bjp(var6, var1, var7, var5):null;
   }

   public boolean a(World var1, Random var2, bjb var3) {
      this.a(var1, var3, 7, 3, 0, 11, 4, 18, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 0, 3, 7, 18, 4, 11, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 8, 5, 0, 10, 7, 18, Blocks.a.P(), Blocks.a.P(), false);
      this.a(var1, var3, 0, 5, 8, 18, 7, 10, Blocks.a.P(), Blocks.a.P(), false);
      this.a(var1, var3, 7, 5, 0, 7, 5, 7, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 7, 5, 11, 7, 5, 18, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 11, 5, 0, 11, 5, 7, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 11, 5, 11, 11, 5, 18, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 0, 5, 7, 7, 5, 7, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 11, 5, 7, 18, 5, 7, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 0, 5, 11, 7, 5, 11, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 11, 5, 11, 18, 5, 11, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 7, 2, 0, 11, 2, 5, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 7, 2, 13, 11, 2, 18, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 7, 0, 0, 11, 1, 3, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 7, 0, 15, 11, 1, 18, Blocks.by.P(), Blocks.by.P(), false);

      int var4;
      int var5;
      for(var4 = 7; var4 <= 11; ++var4) {
         for(var5 = 0; var5 <= 2; ++var5) {
            this.b(var1, Blocks.by.P(), var4, -1, var5, var3);
            this.b(var1, Blocks.by.P(), var4, -1, 18 - var5, var3);
         }
      }

      this.a(var1, var3, 0, 2, 7, 5, 2, 11, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 13, 2, 7, 18, 2, 11, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 0, 0, 7, 3, 1, 11, Blocks.by.P(), Blocks.by.P(), false);
      this.a(var1, var3, 15, 0, 7, 18, 1, 11, Blocks.by.P(), Blocks.by.P(), false);

      for(var4 = 0; var4 <= 2; ++var4) {
         for(var5 = 7; var5 <= 11; ++var5) {
            this.b(var1, Blocks.by.P(), var4, -1, var5, var3);
            this.b(var1, Blocks.by.P(), 18 - var4, -1, var5, var3);
         }
      }

      return true;
   }
}
