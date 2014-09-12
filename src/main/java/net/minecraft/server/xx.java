package net.minecraft.server;

import java.util.UUID;

public abstract class xx extends abq implements xt {

   protected aad bk = new aad(this);


   public xx(World var1) {
      super(var1);
      this.ck();
   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)0));
      this.ac.a(17, "");
   }

   public void b(fn var1) {
      super.b(var1);
      if(this.b() == null) {
         var1.a("OwnerUUID", "");
      } else {
         var1.a("OwnerUUID", this.b());
      }

      var1.a("Sitting", this.cl());
   }

   public void a(fn var1) {
      super.a(var1);
      String var2 = "";
      if(var1.b("OwnerUUID", 8)) {
         var2 = var1.j("OwnerUUID");
      } else {
         String var3 = var1.j("Owner");
         var2 = sf.a(var3);
      }

      if(var2.length() > 0) {
         this.b(var2);
         this.m(true);
      }

      this.bk.a(var1.n("Sitting"));
      this.n(var1.n("Sitting"));
   }

   protected void l(boolean var1) {
      ew var2 = ew.I;
      if(!var1) {
         var2 = ew.l;
      }

      for(int var3 = 0; var3 < 7; ++var3) {
         double var4 = this.V.nextGaussian() * 0.02D;
         double var6 = this.V.nextGaussian() * 0.02D;
         double var8 = this.V.nextGaussian() * 0.02D;
         this.o.a(var2, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var4, var6, var8, new int[0]);
      }

   }

   public boolean cj() {
      return (this.ac.a(16) & 4) != 0;
   }

   public void m(boolean var1) {
      byte var2 = this.ac.a(16);
      if(var1) {
         this.ac.b(16, Byte.valueOf((byte)(var2 | 4)));
      } else {
         this.ac.b(16, Byte.valueOf((byte)(var2 & -5)));
      }

      this.ck();
   }

   protected void ck() {}

   public boolean cl() {
      return (this.ac.a(16) & 1) != 0;
   }

   public void n(boolean var1) {
      byte var2 = this.ac.a(16);
      if(var1) {
         this.ac.b(16, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.ac.b(16, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public String b() {
      return this.ac.e(17);
   }

   public void b(String var1) {
      this.ac.b(17, var1);
   }

   public xm cm() {
      try {
         UUID var1 = UUID.fromString(this.b());
         return var1 == null?null:this.o.b(var1);
      } catch (IllegalArgumentException var2) {
         return null;
      }
   }

   public boolean e(xm var1) {
      return var1 == this.cm();
   }

   public aad cn() {
      return this.bk;
   }

   public boolean a(xm var1, xm var2) {
      return true;
   }

   public ScoreboardTeamBase bN() {
      if(this.cj()) {
         xm var1 = this.cm();
         if(var1 != null) {
            return var1.bN();
         }
      }

      return super.bN();
   }

   public boolean c(xm var1) {
      if(this.cj()) {
         xm var2 = this.cm();
         if(var1 == var2) {
            return true;
         }

         if(var2 != null) {
            return var2.c(var1);
         }
      }

      return super.c(var1);
   }

   public void a(wh var1) {
      if(!this.o.D && this.o.Q().b("showDeathMessages") && this.k_() && this.cm() instanceof EntityPlayer) {
         ((EntityPlayer)this.cm()).a(this.br().b());
      }

      super.a(var1);
   }

   // $FF: synthetic method
   public Entity l_() {
      return this.cm();
   }
}
