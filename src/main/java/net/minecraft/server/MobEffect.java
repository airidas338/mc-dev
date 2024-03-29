package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobEffect {

   private static final Logger a = LogManager.getLogger();
   private int effectId;
   private int duration;
   private int amplifier;
   private boolean splash;
   private boolean ambient;
   private boolean visible;


   public MobEffect(int var1, int var2) {
      this(var1, var2, 0);
   }

   public MobEffect(int var1, int var2, int var3) {
      this(var1, var2, var3, false, true);
   }

   public MobEffect(int var1, int var2, int var3, boolean var4, boolean var5) {
      this.effectId = var1;
      this.duration = var2;
      this.amplifier = var3;
      this.ambient = var4;
      this.visible = var5;
   }

   public MobEffect(MobEffect var1) {
      this.effectId = var1.effectId;
      this.duration = var1.duration;
      this.amplifier = var1.amplifier;
      this.ambient = var1.ambient;
      this.visible = var1.visible;
   }

   public void a(MobEffect var1) {
      if(this.effectId != var1.effectId) {
         a.warn("This method should only be called for matching effects!");
      }

      if(var1.amplifier > this.amplifier) {
         this.amplifier = var1.amplifier;
         this.duration = var1.duration;
      } else if(var1.amplifier == this.amplifier && this.duration < var1.duration) {
         this.duration = var1.duration;
      } else if(!var1.ambient && this.ambient) {
         this.ambient = var1.ambient;
      }

      this.visible = var1.visible;
   }

   public int getEffectId() {
      return this.effectId;
   }

   public int getDuration() {
      return this.duration;
   }

   public int getAmplifier() {
      return this.amplifier;
   }

   public void a(boolean var1) {
      this.splash = var1;
   }

   public boolean e() {
      return this.ambient;
   }

   public boolean f() {
      return this.visible;
   }

   public boolean a(EntityLiving var1) {
      if(this.duration > 0) {
         if(MobEffectList.a[this.effectId].a(this.duration, this.amplifier)) {
            this.b(var1);
         }

         this.i();
      }

      return this.duration > 0;
   }

   private int i() {
      return --this.duration;
   }

   public void b(EntityLiving var1) {
      if(this.duration > 0) {
         MobEffectList.a[this.effectId].a(var1, this.amplifier);
      }

   }

   public String g() {
      return MobEffectList.a[this.effectId].a();
   }

   public int hashCode() {
      return this.effectId;
   }

   public String toString() {
      String var1 = "";
      if(this.getAmplifier() > 0) {
         var1 = this.g() + " x " + (this.getAmplifier() + 1) + ", Duration: " + this.getDuration();
      } else {
         var1 = this.g() + ", Duration: " + this.getDuration();
      }

      if(this.splash) {
         var1 = var1 + ", Splash: true";
      }

      if(!this.visible) {
         var1 = var1 + ", Particles: false";
      }

      return MobEffectList.a[this.effectId].j()?"(" + var1 + ")":var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof MobEffect)) {
         return false;
      } else {
         MobEffect var2 = (MobEffect)var1;
         return this.effectId == var2.effectId && this.amplifier == var2.amplifier && this.duration == var2.duration && this.splash == var2.splash && this.ambient == var2.ambient;
      }
   }

   public NBTTagCompound a(NBTTagCompound var1) {
      var1.setByte("Id", (byte)this.getEffectId());
      var1.setByte("Amplifier", (byte)this.getAmplifier());
      var1.setInt("Duration", this.getDuration());
      var1.setBoolean("Ambient", this.e());
      var1.setBoolean("ShowParticles", this.f());
      return var1;
   }

   public static MobEffect b(NBTTagCompound var0) {
      byte var1 = var0.getByte("Id");
      if(var1 >= 0 && var1 < MobEffectList.a.length && MobEffectList.a[var1] != null) {
         byte var2 = var0.getByte("Amplifier");
         int var3 = var0.getInt("Duration");
         boolean var4 = var0.getBoolean("Ambient");
         boolean var5 = true;
         if(var0.hasKeyOfType("ShowParticles", 1)) {
            var5 = var0.getBoolean("ShowParticles");
         }

         return new MobEffect(var1, var3, var2, var4, var5);
      } else {
         return null;
      }
   }

}
