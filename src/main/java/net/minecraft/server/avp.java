package net.minecraft.server;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class avp extends atg {

   protected avp(bof var1) {
      super(var1);
      this.a(1.0F);
   }

   public bcm a(World var1, int var2) {
      return new bdn();
   }

   public void a(ard var1, dt var2) {
      float var3 = 0.0625F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public void a(World var1, dt var2, bec var3, brt var4, List var5, Entity var6) {}

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, dt var2, bec var3, Entity var4) throws IOException {
      if(var4.m == null && var4.l == null && !var1.D) {
         var4.c(1);
      }

   }

   public boh g(bec var1) {
      return boh.J;
   }
}
