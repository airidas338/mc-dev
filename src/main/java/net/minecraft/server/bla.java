package net.minecraft.server;
import java.util.Random;

public class bla extends blb {

   public bla() {}

   public bla(EnumFacing var1, bjb var2) {
      super(var1, var2);
   }

   public boolean a(World var1, Random var2, bjb var3) {
      this.a(var1, var3, 2, -1, 2, 11, -1, 11, b, b, false);
      this.a(var1, var3, 0, -1, 0, 1, -1, 11, a, a, false);
      this.a(var1, var3, 12, -1, 0, 13, -1, 11, a, a, false);
      this.a(var1, var3, 2, -1, 0, 11, -1, 1, a, a, false);
      this.a(var1, var3, 2, -1, 12, 11, -1, 13, a, a, false);
      this.a(var1, var3, 0, 0, 0, 0, 0, 13, b, b, false);
      this.a(var1, var3, 13, 0, 0, 13, 0, 13, b, b, false);
      this.a(var1, var3, 1, 0, 0, 12, 0, 0, b, b, false);
      this.a(var1, var3, 1, 0, 13, 12, 0, 13, b, b, false);

      for(int var4 = 2; var4 <= 11; var4 += 3) {
         this.a(var1, e, 0, 0, var4, var3);
         this.a(var1, e, 13, 0, var4, var3);
         this.a(var1, e, var4, 0, 0, var3);
      }

      this.a(var1, var3, 2, 0, 3, 4, 0, 9, b, b, false);
      this.a(var1, var3, 9, 0, 3, 11, 0, 9, b, b, false);
      this.a(var1, var3, 4, 0, 9, 9, 0, 11, b, b, false);
      this.a(var1, b, 5, 0, 8, var3);
      this.a(var1, b, 8, 0, 8, var3);
      this.a(var1, b, 10, 0, 10, var3);
      this.a(var1, b, 3, 0, 10, var3);
      this.a(var1, var3, 3, 0, 3, 3, 0, 7, c, c, false);
      this.a(var1, var3, 10, 0, 3, 10, 0, 7, c, c, false);
      this.a(var1, var3, 6, 0, 10, 7, 0, 10, c, c, false);
      byte var7 = 3;

      for(int var5 = 0; var5 < 2; ++var5) {
         for(int var6 = 2; var6 <= 8; var6 += 3) {
            this.a(var1, var3, var7, 0, var6, var7, 2, var6, b, b, false);
         }

         var7 = 10;
      }

      this.a(var1, var3, 5, 0, 10, 5, 2, 10, b, b, false);
      this.a(var1, var3, 8, 0, 10, 8, 2, 10, b, b, false);
      this.a(var1, var3, 6, -1, 7, 7, -1, 8, c, c, false);
      this.a(var1, var3, 6, -1, 3, 7, -1, 4, f, f, false);
      this.a(var1, var3, 6, 1, 6);
      return true;
   }
}
