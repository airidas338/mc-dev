package net.minecraft.server;

public class bbk extends atr {

   public static final bet a = bet.a("explode");


   public bbk() {
      super(bof.u);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
      this.a(akf.d);
   }

   public void c(aqu var1, dt var2, bec var3) {
      super.c(var1, var2, var3);
      if(var1.z(var2)) {
         this.d(var1, var2, var3.a(a, Boolean.valueOf(true)));
         var1.g(var2);
      }

   }

   public void a(aqu var1, dt var2, bec var3, atr var4) {
      if(var1.z(var2)) {
         this.d(var1, var2, var3.a(a, Boolean.valueOf(true)));
         var1.g(var2);
      }

   }

   public void a(aqu var1, dt var2, aqo var3) {
      if(!var1.D) {
         aek var4 = new aek(var1, (double)((float)var2.n() + 0.5F), (double)((float)var2.o() + 0.5F), (double)((float)var2.p() + 0.5F), var3.c());
         var4.a = var1.s.nextInt(var4.a / 4) + var4.a / 8;
         var1.d((wv)var4);
      }
   }

   public void d(aqu var1, dt var2, bec var3) {
      this.a(var1, var2, var3, (xm)null);
   }

   public void a(aqu var1, dt var2, bec var3, xm var4) {
      if(!var1.D) {
         if(((Boolean)var3.b(a)).booleanValue()) {
            aek var5 = new aek(var1, (double)((float)var2.n() + 0.5F), (double)((float)var2.o() + 0.5F), (double)((float)var2.p() + 0.5F), var4);
            var1.d((wv)var5);
            var1.a((wv)var5, "game.tnt.primed", 1.0F, 1.0F);
         }

      }
   }

   public boolean a(aqu var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
      if(var4.bY() != null) {
         alq var9 = var4.bY().b();
         if(var9 == amk.d || var9 == amk.bL) {
            this.a(var1, var2, var3.a(a, Boolean.valueOf(true)), (xm)var4);
            var1.g(var2);
            if(var9 == amk.d) {
               var4.bY().a(1, (xm)var4);
            } else if(!var4.by.d) {
               --var4.bY().b;
            }

            return true;
         }
      }

      return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(aqu var1, dt var2, bec var3, wv var4) {
      if(!var1.D && var4 instanceof ahj) {
         ahj var5 = (ahj)var4;
         if(var5.au()) {
            this.a(var1, var2, var1.p(var2).a(a, Boolean.valueOf(true)), var5.c instanceof xm?(xm)var5.c:null);
            var1.g(var2);
         }
      }

   }

   public boolean a(aqo var1) {
      return false;
   }

   public bec a(int var1) {
      return this.P().a(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int c(bec var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
