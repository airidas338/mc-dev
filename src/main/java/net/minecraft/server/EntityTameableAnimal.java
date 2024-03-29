package net.minecraft.server;

import java.util.UUID;

public abstract class EntityTameableAnimal extends EntityAnimal implements xt {

   protected aad bk = new aad(this);


   public EntityTameableAnimal(World var1) {
      super(var1);
      this.ck();
   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)0));
      this.ac.a(17, "");
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.b() == null) {
         var1.setString("OwnerUUID", "");
      } else {
         var1.setString("OwnerUUID", this.b());
      }

      var1.setBoolean("Sitting", this.cl());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      String var2 = "";
      if(var1.hasKeyOfType("OwnerUUID", 8)) {
         var2 = var1.getString("OwnerUUID");
      } else {
         String var3 = var1.getString("Owner");
         var2 = sf.a(var3);
      }

      if(var2.length() > 0) {
         this.b(var2);
         this.m(true);
      }

      this.bk.a(var1.getBoolean("Sitting"));
      this.n(var1.getBoolean("Sitting"));
   }

   protected void l(boolean var1) {
      EnumParticleEffect var2 = EnumParticleEffect.I;
      if(!var1) {
         var2 = EnumParticleEffect.l;
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

   public EntityLiving cm() {
      try {
         UUID var1 = UUID.fromString(this.b());
         return var1 == null?null:this.o.b(var1);
      } catch (IllegalArgumentException var2) {
         return null;
      }
   }

   public boolean e(EntityLiving var1) {
      return var1 == this.cm();
   }

   public aad cn() {
      return this.bk;
   }

   public boolean a(EntityLiving var1, EntityLiving var2) {
      return true;
   }

   public ScoreboardTeamBase bN() {
      if(this.cj()) {
         EntityLiving var1 = this.cm();
         if(var1 != null) {
            return var1.bN();
         }
      }

      return super.bN();
   }

   public boolean c(EntityLiving var1) {
      if(this.cj()) {
         EntityLiving var2 = this.cm();
         if(var1 == var2) {
            return true;
         }

         if(var2 != null) {
            return var2.c(var1);
         }
      }

      return super.c(var1);
   }

   public void a(DamageSource var1) {
      if(!this.o.isStatic && this.o.getGameRules().getBoolean("showDeathMessages") && this.k_() && this.cm() instanceof EntityPlayer) {
         ((EntityPlayer)this.cm()).sendMessage(this.br().b());
      }

      super.a(var1);
   }

   // $FF: synthetic method
   public Entity l_() {
      return this.cm();
   }
}
