package net.minecraft.server;
import java.util.Random;

public class axr extends atg {

   protected axr() {
      super(bof.e);
   }

   public bcm a(World var1, int var2) {
      return new bdg();
   }

   public alq a(bec var1, Random var2, int var3) {
      return null;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, dt var2, bec var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      int var6 = 15 + var1.s.nextInt(15) + var1.s.nextInt(15);
      this.b(var1, var2, var6);
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }
}
