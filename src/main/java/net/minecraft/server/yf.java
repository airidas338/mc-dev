package net.minecraft.server;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class yf extends AttributeMapBase {

   private final Set e = Sets.newHashSet();
   protected final Map d = new ul();


   public ye e(IAttribute var1) {
      return (ye)super.a(var1);
   }

   public ye b(String var1) {
      AttributeInstance var2 = super.a(var1);
      if(var2 == null) {
         var2 = (AttributeInstance)this.d.get(var1);
      }

      return (ye)var2;
   }

   public AttributeInstance load(IAttribute var1) {
      AttributeInstance var2 = super.load(var1);
      if(var1 instanceof AttributeRanged && ((AttributeRanged)var1).g() != null) {
         this.d.put(((AttributeRanged)var1).g(), var2);
      }

      return var2;
   }

   protected AttributeInstance c(IAttribute var1) {
      return new ye(this, var1);
   }

   public void a(AttributeInstance var1) {
      if(var1.a().c()) {
         this.e.add(var1);
      }

      Iterator var2 = this.c.get(var1.a()).iterator();

      while(var2.hasNext()) {
         IAttribute var3 = (IAttribute)var2.next();
         ye var4 = this.e(var3);
         if(var4 != null) {
            var4.f();
         }
      }

   }

   public Set b() {
      return this.e;
   }

   public Collection c() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         AttributeInstance var3 = (AttributeInstance)var2.next();
         if(var3.a().c()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   // $FF: synthetic method
   public AttributeInstance a(String var1) {
      return this.b(var1);
   }

   // $FF: synthetic method
   public AttributeInstance a(IAttribute var1) {
      return this.e(var1);
   }
}
