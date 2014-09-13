package net.minecraft.server;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class agi extends afm implements afr {

   private static final UUID b = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   private static final ya c = (new ya(b, "Drinking speed penalty", -0.25D, 0)).a(false);
   private static final alq[] bk = new alq[]{amk.aT, amk.aY, amk.aC, amk.bB, amk.bA, amk.H, amk.y, amk.y};
   private int bl;


   public agi(aqu var1) {
      super(var1);
      this.a(0.6F, 1.95F);
      this.i.a(1, new yy(this));
      this.i.a(2, new zz(this, 1.0D, 60, 10.0F));
      this.i.a(2, new zy(this, 1.0D));
      this.i.a(2, this.a);
      this.i.a(3, new zh(this, ahd.class, 8.0F));
      this.i.a(3, new zx(this));
      this.bg.a(1, new aal(this, false, new Class[0]));
      this.bg.a(2, new aaq(this, ahd.class, true));
   }

   protected void h() {
      super.h();
      this.H().a(21, Byte.valueOf((byte)0));
   }

   protected String z() {
      return null;
   }

   protected String bn() {
      return null;
   }

   protected String bo() {
      return null;
   }

   public void a(boolean var1) {
      this.H().b(21, Byte.valueOf((byte)(var1?1:0)));
   }

   public boolean n() {
      return this.H().a(21) == 1;
   }

   protected void aW() {
      super.aW();
      this.a(afs.a).a(26.0D);
      this.a(afs.d).a(0.25D);
   }

   public void m() {
      if(!this.o.D) {
         if(this.n()) {
            if(this.bl-- <= 0) {
               this.a(false);
               amj var1 = this.bz();
               this.c(0, (amj)null);
               if(var1 != null && var1.b() == amk.bz) {
                  List var2 = amk.bz.h(var1);
                  if(var2 != null) {
                     Iterator var3 = var2.iterator();

                     while(var3.hasNext()) {
                        wq var4 = (wq)var3.next();
                        this.c(new wq(var4));
                     }
                  }
               }

               this.a(afs.d).c(c);
            }
         } else {
            short var5 = -1;
            if(this.V.nextFloat() < 0.15F && this.a(bof.h) && !this.a(wp.o)) {
               var5 = 8237;
            } else if(this.V.nextFloat() < 0.15F && this.au() && !this.a(wp.n)) {
               var5 = 16307;
            } else if(this.V.nextFloat() < 0.05F && this.bm() < this.bt()) {
               var5 = 16341;
            } else if(this.V.nextFloat() < 0.25F && this.u() != null && !this.a(wp.c) && this.u().h(this) > 121.0D) {
               var5 = 16274;
            } else if(this.V.nextFloat() < 0.25F && this.u() != null && !this.a(wp.c) && this.u().h(this) > 121.0D) {
               var5 = 16274;
            }

            if(var5 > -1) {
               this.c(0, new amj(amk.bz, 1, var5));
               this.bl = this.bz().l();
               this.a(true);
               xz var6 = this.a(afs.d);
               var6.c(c);
               var6.b(c);
            }
         }

         if(this.V.nextFloat() < 7.5E-4F) {
            this.o.a((wv)this, (byte)15);
         }
      }

      super.m();
   }

   protected float c(wh var1, float var2) {
      var2 = super.c(var1, var2);
      if(var1.j() == this) {
         var2 = 0.0F;
      }

      if(var1.s()) {
         var2 = (float)((double)var2 * 0.15D);
      }

      return var2;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = this.V.nextInt(3);
         alq var6 = bk[this.V.nextInt(bk.length)];
         if(var2 > 0) {
            var5 += this.V.nextInt(var2 + 1);
         }

         for(int var7 = 0; var7 < var5; ++var7) {
            this.a(var6, 1);
         }
      }

   }

   public void a(xm var1, float var2) {
      if(!this.n()) {
         ahv var3 = new ahv(this.o, this, 32732);
         double var4 = var1.t + (double)var1.aR() - 1.100000023841858D;
         var3.z -= -20.0F;
         double var6 = var1.s + var1.v - this.s;
         double var8 = var4 - this.t;
         double var10 = var1.u + var1.x - this.u;
         float var12 = uv.a(var6 * var6 + var10 * var10);
         if(var12 >= 8.0F && !var1.a(wp.d)) {
            var3.a(32698);
         } else if(var1.bm() >= 8.0F && !var1.a(wp.u)) {
            var3.a(32660);
         } else if(var12 <= 3.0F && !var1.a(wp.t) && this.V.nextFloat() < 0.25F) {
            var3.a(32696);
         }

         var3.c(var6, var8 + (double)(var12 * 0.2F), var10, 0.75F, 8.0F);
         this.o.d((wv)var3);
      }
   }

   public float aR() {
      return 1.62F;
   }

}
