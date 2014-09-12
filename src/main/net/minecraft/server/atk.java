package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class atk {

   private final World b;
   private final Location c;
   private final ati d;
   private IBlock e;
   private final boolean f;
   private final List g;
   // $FF: synthetic field
   final ati a;


   public atk(ati var1, World var2, Location var3, IBlock var4) {
      this.a = var1;
      this.g = Lists.newArrayList();
      this.b = var2;
      this.c = var3;
      this.e = var4;
      this.d = (ati)var4.c();
      atl var5 = (atl)var4.b(var1.l());
      this.f = this.d.a;
      this.a(var5);
   }

   private void a(atl var1) {
      this.g.clear();
      switch(atj.a[var1.ordinal()]) {
      case 1:
         this.g.add(this.c.c());
         this.g.add(this.c.d());
         break;
      case 2:
         this.g.add(this.c.e());
         this.g.add(this.c.f());
         break;
      case 3:
         this.g.add(this.c.e());
         this.g.add(this.c.f().a());
         break;
      case 4:
         this.g.add(this.c.e().a());
         this.g.add(this.c.f());
         break;
      case 5:
         this.g.add(this.c.c().a());
         this.g.add(this.c.d());
         break;
      case 6:
         this.g.add(this.c.c());
         this.g.add(this.c.d().a());
         break;
      case 7:
         this.g.add(this.c.f());
         this.g.add(this.c.d());
         break;
      case 8:
         this.g.add(this.c.e());
         this.g.add(this.c.d());
         break;
      case 9:
         this.g.add(this.c.e());
         this.g.add(this.c.c());
         break;
      case 10:
         this.g.add(this.c.f());
         this.g.add(this.c.c());
      }

   }

   private void c() {
      for(int var1 = 0; var1 < this.g.size(); ++var1) {
         atk var2 = this.b((Location)this.g.get(var1));
         if(var2 != null && var2.a(this)) {
            this.g.set(var1, var2.c);
         } else {
            this.g.remove(var1--);
         }
      }

   }

   private boolean a(Location var1) {
      return ati.d(this.b, var1) || ati.d(this.b, var1.a()) || ati.d(this.b, var1.b());
   }

   private atk b(Location var1) {
      IBlock var3 = this.b.p(var1);
      if(ati.d(var3)) {
         return new atk(this.a, this.b, var1, var3);
      } else {
         Location var2 = var1.a();
         var3 = this.b.p(var2);
         if(ati.d(var3)) {
            return new atk(this.a, this.b, var2, var3);
         } else {
            var2 = var1.b();
            var3 = this.b.p(var2);
            return ati.d(var3)?new atk(this.a, this.b, var2, var3):null;
         }
      }
   }

   private boolean a(atk var1) {
      return this.c(var1.c);
   }

   private boolean c(Location var1) {
      for(int var2 = 0; var2 < this.g.size(); ++var2) {
         Location var3 = (Location)this.g.get(var2);
         if(var3.n() == var1.n() && var3.p() == var1.p()) {
            return true;
         }
      }

      return false;
   }

   protected int a() {
      int var1 = 0;
      Iterator var2 = en.a.iterator();

      while(var2.hasNext()) {
         ej var3 = (ej)var2.next();
         if(this.a(this.c.a(var3))) {
            ++var1;
         }
      }

      return var1;
   }

   private boolean b(atk var1) {
      return this.a(var1) || this.g.size() != 2;
   }

   private void c(atk var1) {
      this.g.add(var1.c);
      Location var2 = this.c.c();
      Location var3 = this.c.d();
      Location var4 = this.c.e();
      Location var5 = this.c.f();
      boolean var6 = this.c(var2);
      boolean var7 = this.c(var3);
      boolean var8 = this.c(var4);
      boolean var9 = this.c(var5);
      atl var10 = null;
      if(var6 || var7) {
         var10 = atl.a;
      }

      if(var8 || var9) {
         var10 = atl.b;
      }

      if(!this.f) {
         if(var7 && var9 && !var6 && !var8) {
            var10 = atl.g;
         }

         if(var7 && var8 && !var6 && !var9) {
            var10 = atl.h;
         }

         if(var6 && var8 && !var7 && !var9) {
            var10 = atl.i;
         }

         if(var6 && var9 && !var7 && !var8) {
            var10 = atl.j;
         }
      }

      if(var10 == atl.a) {
         if(ati.d(this.b, var2.a())) {
            var10 = atl.e;
         }

         if(ati.d(this.b, var3.a())) {
            var10 = atl.f;
         }
      }

      if(var10 == atl.b) {
         if(ati.d(this.b, var5.a())) {
            var10 = atl.c;
         }

         if(ati.d(this.b, var4.a())) {
            var10 = atl.d;
         }
      }

      if(var10 == null) {
         var10 = atl.a;
      }

      this.e = this.e.a(this.d.l(), var10);
      this.b.a(this.c, this.e, 3);
   }

   private boolean d(Location var1) {
      atk var2 = this.b(var1);
      if(var2 == null) {
         return false;
      } else {
         var2.c();
         return var2.b(this);
      }
   }

   public atk a(boolean var1, boolean var2) {
      Location var3 = this.c.c();
      Location var4 = this.c.d();
      Location var5 = this.c.e();
      Location var6 = this.c.f();
      boolean var7 = this.d(var3);
      boolean var8 = this.d(var4);
      boolean var9 = this.d(var5);
      boolean var10 = this.d(var6);
      atl var11 = null;
      if((var7 || var8) && !var9 && !var10) {
         var11 = atl.a;
      }

      if((var9 || var10) && !var7 && !var8) {
         var11 = atl.b;
      }

      if(!this.f) {
         if(var8 && var10 && !var7 && !var9) {
            var11 = atl.g;
         }

         if(var8 && var9 && !var7 && !var10) {
            var11 = atl.h;
         }

         if(var7 && var9 && !var8 && !var10) {
            var11 = atl.i;
         }

         if(var7 && var10 && !var8 && !var9) {
            var11 = atl.j;
         }
      }

      if(var11 == null) {
         if(var7 || var8) {
            var11 = atl.a;
         }

         if(var9 || var10) {
            var11 = atl.b;
         }

         if(!this.f) {
            if(var1) {
               if(var8 && var10) {
                  var11 = atl.g;
               }

               if(var9 && var8) {
                  var11 = atl.h;
               }

               if(var10 && var7) {
                  var11 = atl.j;
               }

               if(var7 && var9) {
                  var11 = atl.i;
               }
            } else {
               if(var7 && var9) {
                  var11 = atl.i;
               }

               if(var10 && var7) {
                  var11 = atl.j;
               }

               if(var9 && var8) {
                  var11 = atl.h;
               }

               if(var8 && var10) {
                  var11 = atl.g;
               }
            }
         }
      }

      if(var11 == atl.a) {
         if(ati.d(this.b, var3.a())) {
            var11 = atl.e;
         }

         if(ati.d(this.b, var4.a())) {
            var11 = atl.f;
         }
      }

      if(var11 == atl.b) {
         if(ati.d(this.b, var6.a())) {
            var11 = atl.c;
         }

         if(ati.d(this.b, var5.a())) {
            var11 = atl.d;
         }
      }

      if(var11 == null) {
         var11 = atl.a;
      }

      this.a(var11);
      this.e = this.e.a(this.d.l(), var11);
      if(var2 || this.b.p(this.c) != this.e) {
         this.b.a(this.c, this.e, 3);

         for(int var12 = 0; var12 < this.g.size(); ++var12) {
            atk var13 = this.b((Location)this.g.get(var12));
            if(var13 != null) {
               var13.c();
               if(var13.b(this)) {
                  var13.c(this);
               }
            }
         }
      }

      return this;
   }

   public IBlock b() {
      return this.e;
   }
}
