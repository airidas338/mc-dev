package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class aor implements aoo {

   public boolean a(ain var1, World var2) {
      ArrayList var3 = Lists.newArrayList();

      for(int var4 = 0; var4 < var1.n_(); ++var4) {
         ItemStack var5 = var1.a(var4);
         if(var5 != null) {
            var3.add(var5);
            if(var3.size() > 1) {
               ItemStack var6 = (ItemStack)var3.get(0);
               if(var5.b() != var6.b() || var6.b != 1 || var5.b != 1 || !var6.b().m()) {
                  return false;
               }
            }
         }
      }

      return var3.size() == 2;
   }

   public ItemStack a(ain var1) {
      ArrayList var2 = Lists.newArrayList();

      ItemStack var4;
      for(int var3 = 0; var3 < var1.n_(); ++var3) {
         var4 = var1.a(var3);
         if(var4 != null) {
            var2.add(var4);
            if(var2.size() > 1) {
               ItemStack var5 = (ItemStack)var2.get(0);
               if(var4.b() != var5.b() || var5.b != 1 || var4.b != 1 || !var5.b().m()) {
                  return null;
               }
            }
         }
      }

      if(var2.size() == 2) {
         ItemStack var10 = (ItemStack)var2.get(0);
         var4 = (ItemStack)var2.get(1);
         if(var10.b() == var4.b() && var10.b == 1 && var4.b == 1 && var10.b().m()) {
            Item var11 = var10.b();
            int var6 = var11.l() - var10.h();
            int var7 = var11.l() - var4.h();
            int var8 = var6 + var7 + var11.l() * 5 / 100;
            int var9 = var11.l() - var8;
            if(var9 < 0) {
               var9 = 0;
            }

            return new ItemStack(var10.b(), 1, var9);
         }
      }

      return null;
   }

   public int a() {
      return 4;
   }

   public ItemStack b() {
      return null;
   }

   public ItemStack[] b(ain var1) {
      ItemStack[] var2 = new ItemStack[var1.n_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.a(var3);
         if(var4 != null && var4.b().r()) {
            var2[var3] = new ItemStack(var4.b().q());
         }
      }

      return var2;
   }
}
