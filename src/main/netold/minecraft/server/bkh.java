package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class bkh extends bmv {

   private Set c = Sets.newHashSet();
   private boolean d;


   public bkh() {}

   public bkh(aqu var1, Random var2, int var3, int var4) {
      super(var3, var4);
      this.b(var1, var2, var3, var4);
   }

   private void b(aqu var1, Random var2, int var3, int var4) {
      var2.setSeed(var1.J());
      long var5 = var2.nextLong();
      long var7 = var2.nextLong();
      long var9 = (long)var3 * var5;
      long var11 = (long)var4 * var7;
      var2.setSeed(var9 ^ var11 ^ var1.J());
      int var13 = var3 * 16 + 8 - 29;
      int var14 = var4 * 16 + 8 - 29;
      ej var15 = en.a.a(var2);
      this.a.add(new bkr(var2, var13, var14, var15));
      this.c();
      this.d = true;
   }

   public void a(aqu var1, Random var2, bjb var3) {
      if(!this.d) {
         this.a.clear();
         this.b(var1, var2, this.e(), this.f());
      }

      super.a(var1, var2, var3);
   }

   public boolean a(aqm var1) {
      return this.c.contains(var1)?false:super.a(var1);
   }

   public void b(aqm var1) {
      super.b(var1);
      this.c.add(var1);
   }

   public void a(fn var1) {
      super.a(var1);
      fv var2 = new fv();
      Iterator var3 = this.c.iterator();

      while(var3.hasNext()) {
         aqm var4 = (aqm)var3.next();
         fn var5 = new fn();
         var5.a("X", var4.a);
         var5.a("Z", var4.b);
         var2.a((gd)var5);
      }

      var1.a("Processed", (gd)var2);
   }

   public void b(fn var1) {
      super.b(var1);
      if(var1.b("Processed", 9)) {
         fv var2 = var1.c("Processed", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            fn var4 = var2.b(var3);
            this.c.add(new aqm(var4.f("X"), var4.f("Z")));
         }
      }

   }
}
