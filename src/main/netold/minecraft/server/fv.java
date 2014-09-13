package net.minecraft.server;
import com.google.common.collect.Lists;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class fv extends gd {

   private static final Logger b = LogManager.getLogger();
   private List c = Lists.newArrayList();
   private byte d = 0;


   void a(DataOutput var1) throws IOException {
      if(!this.c.isEmpty()) {
         this.d = ((gd)this.c.get(0)).a();
      } else {
         this.d = 0;
      }

      var1.writeByte(this.d);
      var1.writeInt(this.c.size());

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         ((gd)this.c.get(var2)).a(var1);
      }

   }

   void a(DataInput var1, int var2, fx var3) throws IOException {
      if(var2 > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         var3.a(8L);
         this.d = var1.readByte();
         int var4 = var1.readInt();
         this.c = Lists.newArrayList();

         for(int var5 = 0; var5 < var4; ++var5) {
            gd var6 = gd.a(this.d);
            var6.a(var1, var2 + 1, var3);
            this.c.add(var6);
         }

      }
   }

   public byte a() {
      return (byte)9;
   }

   public String toString() {
      String var1 = "[";
      int var2 = 0;

      for(Iterator var3 = this.c.iterator(); var3.hasNext(); ++var2) {
         gd var4 = (gd)var3.next();
         var1 = var1 + "" + var2 + ':' + var4 + ',';
      }

      return var1 + "]";
   }

   public void a(gd var1) {
      if(this.d == 0) {
         this.d = var1.a();
      } else if(this.d != var1.a()) {
         b.warn("Adding mismatching tag types to tag list");
         return;
      }

      this.c.add(var1);
   }

   public void a(int var1, gd var2) {
      if(var1 >= 0 && var1 < this.c.size()) {
         if(this.d == 0) {
            this.d = var2.a();
         } else if(this.d != var2.a()) {
            b.warn("Adding mismatching tag types to tag list");
            return;
         }

         this.c.set(var1, var2);
      } else {
         b.warn("index out of bounds to set tag in tag list");
      }
   }

   public gd a(int var1) {
      return (gd)this.c.remove(var1);
   }

   public boolean c_() {
      return this.c.isEmpty();
   }

   public fn b(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         gd var2 = (gd)this.c.get(var1);
         return var2.a() == 10?(fn)var2:new fn();
      } else {
         return new fn();
      }
   }

   public int[] c(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         gd var2 = (gd)this.c.get(var1);
         return var2.a() == 11?((ft)var2).c():new int[0];
      } else {
         return new int[0];
      }
   }

   public double d(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         gd var2 = (gd)this.c.get(var1);
         return var2.a() == 6?((fq)var2).g():0.0D;
      } else {
         return 0.0D;
      }
   }

   public float e(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         gd var2 = (gd)this.c.get(var1);
         return var2.a() == 5?((fs)var2).h():0.0F;
      } else {
         return 0.0F;
      }
   }

   public String f(int var1) {
      if(var1 >= 0 && var1 < this.c.size()) {
         gd var2 = (gd)this.c.get(var1);
         return var2.a() == 8?var2.a_():var2.toString();
      } else {
         return "";
      }
   }

   public gd g(int var1) {
      return (gd)(var1 >= 0 && var1 < this.c.size()?(gd)this.c.get(var1):new fr());
   }

   public int c() {
      return this.c.size();
   }

   public gd b() {
      fv var1 = new fv();
      var1.d = this.d;
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         gd var3 = (gd)var2.next();
         gd var4 = var3.b();
         var1.c.add(var4);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         fv var2 = (fv)var1;
         if(this.d == var2.d) {
            return this.c.equals(var2.c);
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() ^ this.c.hashCode();
   }

   public int f() {
      return this.d;
   }

}
