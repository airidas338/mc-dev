package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class lp implements id {

   private int a;
   private final List b = Lists.newArrayList();


   public lp() {}

   public lp(int var1, Collection var2) {
      this.a = var1;
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         xz var4 = (xz)var3.next();
         this.b.add(new lq(this, var4.a().a(), var4.b(), var4.c()));
      }

   }

   public void a(hd var1) {
      this.a = var1.e();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1.c(64);
         double var5 = var1.readDouble();
         ArrayList var7 = Lists.newArrayList();
         int var8 = var1.e();

         for(int var9 = 0; var9 < var8; ++var9) {
            UUID var10 = var1.g();
            var7.add(new ya(var10, "Unknown synced attribute modifier", var1.readDouble(), var1.readByte()));
         }

         this.b.add(new lq(this, var4, var5, var7));
      }

   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.writeInt(this.b.size());
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         lq var3 = (lq)var2.next();
         var1.a(var3.a());
         var1.writeDouble(var3.b());
         var1.b(var3.c().size());
         Iterator var4 = var3.c().iterator();

         while(var4.hasNext()) {
            ya var5 = (ya)var4.next();
            var1.a(var5.a());
            var1.writeDouble(var5.d());
            var1.writeByte(var5.c());
         }
      }

   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
