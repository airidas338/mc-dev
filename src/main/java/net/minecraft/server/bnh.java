package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bnh extends bnn {

   private boolean a;
   private int b;


   public bnh() {}

   public bnh(bnk var1, int var2, Random var3, bjb var4, ej var5) {
      super(var1, var2);
      this.m = var5;
      this.l = var4;
      this.a = var3.nextBoolean();
      this.b = var3.nextInt(3);
   }

   protected void a(fn var1) {
      super.a(var1);
      var1.a("T", this.b);
      var1.a("C", this.a);
   }

   protected void b(fn var1) {
      super.b(var1);
      this.b = var1.f("T");
      this.a = var1.n("C");
   }

   public static bnh a(bnk var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
      bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 4, 6, 5, var6);
      return a(var8) && bms.a(var1, var8) == null?new bnh(var0, var7, var2, var8, var6):null;
   }

   public boolean a(World var1, Random var2, bjb var3) {
      if(this.h < 0) {
         this.h = this.b(var1, var3);
         if(this.h < 0) {
            return true;
         }

         this.l.a(0, this.h - this.l.e + 6 - 1, 0);
      }

      this.a(var1, var3, 1, 1, 1, 3, 5, 4, aty.a.P(), aty.a.P(), false);
      this.a(var1, var3, 0, 0, 0, 3, 0, 4, aty.e.P(), aty.e.P(), false);
      this.a(var1, var3, 1, 0, 1, 2, 0, 3, aty.d.P(), aty.d.P(), false);
      if(this.a) {
         this.a(var1, var3, 1, 4, 1, 2, 4, 3, aty.r.P(), aty.r.P(), false);
      } else {
         this.a(var1, var3, 1, 5, 1, 2, 5, 3, aty.r.P(), aty.r.P(), false);
      }

      this.a(var1, aty.r.P(), 1, 4, 0, var3);
      this.a(var1, aty.r.P(), 2, 4, 0, var3);
      this.a(var1, aty.r.P(), 1, 4, 4, var3);
      this.a(var1, aty.r.P(), 2, 4, 4, var3);
      this.a(var1, aty.r.P(), 0, 4, 1, var3);
      this.a(var1, aty.r.P(), 0, 4, 2, var3);
      this.a(var1, aty.r.P(), 0, 4, 3, var3);
      this.a(var1, aty.r.P(), 3, 4, 1, var3);
      this.a(var1, aty.r.P(), 3, 4, 2, var3);
      this.a(var1, aty.r.P(), 3, 4, 3, var3);
      this.a(var1, var3, 0, 1, 0, 0, 3, 0, aty.r.P(), aty.r.P(), false);
      this.a(var1, var3, 3, 1, 0, 3, 3, 0, aty.r.P(), aty.r.P(), false);
      this.a(var1, var3, 0, 1, 4, 0, 3, 4, aty.r.P(), aty.r.P(), false);
      this.a(var1, var3, 3, 1, 4, 3, 3, 4, aty.r.P(), aty.r.P(), false);
      this.a(var1, var3, 0, 1, 1, 0, 3, 3, aty.f.P(), aty.f.P(), false);
      this.a(var1, var3, 3, 1, 1, 3, 3, 3, aty.f.P(), aty.f.P(), false);
      this.a(var1, var3, 1, 1, 0, 2, 3, 0, aty.f.P(), aty.f.P(), false);
      this.a(var1, var3, 1, 1, 4, 2, 3, 4, aty.f.P(), aty.f.P(), false);
      this.a(var1, aty.bj.P(), 0, 2, 2, var3);
      this.a(var1, aty.bj.P(), 3, 2, 2, var3);
      if(this.b > 0) {
         this.a(var1, aty.aO.P(), this.b, 1, 3, var3);
         this.a(var1, aty.aB.P(), this.b, 2, 3, var3);
      }

      this.a(var1, aty.a.P(), 1, 1, 0, var3);
      this.a(var1, aty.a.P(), 1, 2, 0, var3);
      this.a(var1, var3, var2, 1, 1, 0, ej.b(this.a(aty.ao, 1)));
      if(this.a(var1, 1, 0, -1, var3).c().r() == bof.a && this.a(var1, 1, -1, -1, var3).c().r() != bof.a) {
         this.a(var1, aty.aw.a(this.a(aty.aw, 3)), 1, 0, -1, var3);
      }

      for(int var4 = 0; var4 < 5; ++var4) {
         for(int var5 = 0; var5 < 4; ++var5) {
            this.b(var1, var5, 6, var4, var3);
            this.b(var1, aty.e.P(), var5, -1, var4, var3);
         }
      }

      this.a(var1, var3, 1, 1, 2, 1);
      return true;
   }
}
