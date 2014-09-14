package net.minecraft.server;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

public class MobEffectList {

   public static final MobEffectList[] a = new MobEffectList[32];
   private static final Map I = Maps.newHashMap();
   public static final MobEffectList b = null;
   public static final MobEffectList c = (new MobEffectList(1, new RegistryPrepender("speed"), false, 8171462)).c("potion.moveSpeed").b(0, 0).a(GenericAttributes.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
   public static final MobEffectList d = (new MobEffectList(2, new RegistryPrepender("slowness"), true, 5926017)).c("potion.moveSlowdown").b(1, 0).a(GenericAttributes.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2);
   public static final MobEffectList e = (new MobEffectList(3, new RegistryPrepender("haste"), false, 14270531)).c("potion.digSpeed").b(2, 0).a(1.5D);
   public static final MobEffectList f = (new MobEffectList(4, new RegistryPrepender("mining_fatigue"), true, 4866583)).c("potion.digSlowDown").b(3, 0);
   public static final MobEffectList g = (new MobEffectAttackDamage(5, new RegistryPrepender("strength"), false, 9643043)).c("potion.damageBoost").b(4, 0).a(GenericAttributes.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2);
   public static final MobEffectList h = (new InstantMobEffect(6, new RegistryPrepender("instant_health"), false, 16262179)).c("potion.heal");
   public static final MobEffectList i = (new InstantMobEffect(7, new RegistryPrepender("instant_damage"), true, 4393481)).c("potion.harm");
   public static final MobEffectList j = (new MobEffectList(8, new RegistryPrepender("jump_boost"), false, 2293580)).c("potion.jump").b(2, 1);
   public static final MobEffectList k = (new MobEffectList(9, new RegistryPrepender("nausea"), true, 5578058)).c("potion.confusion").b(3, 1).a(0.25D);
   public static final MobEffectList l = (new MobEffectList(10, new RegistryPrepender("regeneration"), false, 13458603)).c("potion.regeneration").b(7, 0).a(0.25D);
   public static final MobEffectList m = (new MobEffectList(11, new RegistryPrepender("resistance"), false, 10044730)).c("potion.resistance").b(6, 1);
   public static final MobEffectList n = (new MobEffectList(12, new RegistryPrepender("fire_resistance"), false, 14981690)).c("potion.fireResistance").b(7, 1);
   public static final MobEffectList o = (new MobEffectList(13, new RegistryPrepender("water_breathing"), false, 3035801)).c("potion.waterBreathing").b(0, 2);
   public static final MobEffectList p = (new MobEffectList(14, new RegistryPrepender("invisibility"), false, 8356754)).c("potion.invisibility").b(0, 1);
   public static final MobEffectList q = (new MobEffectList(15, new RegistryPrepender("blindness"), true, 2039587)).c("potion.blindness").b(5, 1).a(0.25D);
   public static final MobEffectList r = (new MobEffectList(16, new RegistryPrepender("night_vision"), false, 2039713)).c("potion.nightVision").b(4, 1);
   public static final MobEffectList s = (new MobEffectList(17, new RegistryPrepender("hunger"), true, 5797459)).c("potion.hunger").b(1, 1);
   public static final MobEffectList t = (new MobEffectAttackDamage(18, new RegistryPrepender("weakness"), true, 4738376)).c("potion.weakness").b(5, 0).a(GenericAttributes.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0);
   public static final MobEffectList u = (new MobEffectList(19, new RegistryPrepender("poison"), true, 5149489)).c("potion.poison").b(6, 0).a(0.25D);
   public static final MobEffectList v = (new MobEffectList(20, new RegistryPrepender("wither"), true, 3484199)).c("potion.wither").b(1, 2).a(0.25D);
   public static final MobEffectList w = (new MobEffectHealthBoost(21, new RegistryPrepender("health_boost"), false, 16284963)).c("potion.healthBoost").b(2, 2).a(GenericAttributes.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0);
   public static final MobEffectList x = (new MobEffectAbsorption(22, new RegistryPrepender("absorption"), false, 2445989)).c("potion.absorption").b(2, 2);
   public static final MobEffectList y = (new InstantMobEffect(23, new RegistryPrepender("saturation"), false, 16262179)).c("potion.saturation");
   public static final MobEffectList z = null;
   public static final MobEffectList A = null;
   public static final MobEffectList B = null;
   public static final MobEffectList C = null;
   public static final MobEffectList D = null;
   public static final MobEffectList E = null;
   public static final MobEffectList F = null;
   public static final MobEffectList G = null;
   public final int H;
   private final Map J = Maps.newHashMap();
   private final boolean K;
   private final int L;
   private String M = "";
   private int N = -1;
   private double O;
   private boolean P;


   protected MobEffectList(int var1, RegistryPrepender var2, boolean var3, int var4) {
      this.H = var1;
      a[var1] = this;
      I.put(var2, this);
      this.K = var3;
      if(var3) {
         this.O = 0.5D;
      } else {
         this.O = 1.0D;
      }

      this.L = var4;
   }

   public static MobEffectList b(String var0) {
      return (MobEffectList)I.get(new RegistryPrepender(var0));
   }

   public static String[] c() {
      String[] var0 = new String[I.size()];
      int var1 = 0;

      RegistryPrepender var3;
      for(Iterator var2 = I.keySet().iterator(); var2.hasNext(); var0[var1++] = var3.toString()) {
         var3 = (RegistryPrepender)var2.next();
      }

      return var0;
   }

   protected MobEffectList b(int var1, int var2) {
      this.N = var1 + var2 * 8;
      return this;
   }

   public int d() {
      return this.H;
   }

   public void a(EntityLiving var1, int var2) {
      if(this.H == l.H) {
         if(var1.bm() < var1.bt()) {
            var1.g(1.0F);
         }
      } else if(this.H == u.H) {
         if(var1.bm() > 1.0F) {
            var1.a(DamageSource.l, 1.0F);
         }
      } else if(this.H == v.H) {
         var1.a(DamageSource.m, 1.0F);
      } else if(this.H == s.H && var1 instanceof EntityHuman) {
         ((EntityHuman)var1).a(0.025F * (float)(var2 + 1));
      } else if(this.H == y.H && var1 instanceof EntityHuman) {
         if(!var1.o.D) {
            ((EntityHuman)var1).ck().a(var2 + 1, 1.0F);
         }
      } else if((this.H != h.H || var1.bl()) && (this.H != i.H || !var1.bl())) {
         if(this.H == i.H && !var1.bl() || this.H == h.H && var1.bl()) {
            var1.a(DamageSource.l, (float)(6 << var2));
         }
      } else {
         var1.g((float)Math.max(4 << var2, 0));
      }

   }

   public void a(Entity var1, Entity var2, EntityLiving var3, int var4, double var5) {
      int var7;
      if((this.H != h.H || var3.bl()) && (this.H != i.H || !var3.bl())) {
         if(this.H == i.H && !var3.bl() || this.H == h.H && var3.bl()) {
            var7 = (int)(var5 * (double)(6 << var4) + 0.5D);
            if(var1 == null) {
               var3.a(DamageSource.l, (float)var7);
            } else {
               var3.a(DamageSource.b(var1, var2), (float)var7);
            }
         }
      } else {
         var7 = (int)(var5 * (double)(4 << var4) + 0.5D);
         var3.g((float)var7);
      }

   }

   public boolean b() {
      return false;
   }

   public boolean a(int var1, int var2) {
      int var3;
      if(this.H == l.H) {
         var3 = 50 >> var2;
         return var3 > 0?var1 % var3 == 0:true;
      } else if(this.H == u.H) {
         var3 = 25 >> var2;
         return var3 > 0?var1 % var3 == 0:true;
      } else if(this.H == v.H) {
         var3 = 40 >> var2;
         return var3 > 0?var1 % var3 == 0:true;
      } else {
         return this.H == s.H;
      }
   }

   public MobEffectList c(String var1) {
      this.M = var1;
      return this;
   }

   public String a() {
      return this.M;
   }

   protected MobEffectList a(double var1) {
      this.O = var1;
      return this;
   }

   public double h() {
      return this.O;
   }

   public boolean j() {
      return this.P;
   }

   public int k() {
      return this.L;
   }

   public MobEffectList a(IAttribute var1, String var2, double var3, int var5) {
      AttributeModifier var6 = new AttributeModifier(UUID.fromString(var2), this.a(), var3, var5);
      this.J.put(var1, var6);
      return this;
   }

   public void a(EntityLiving var1, AttributeMapBase var2, int var3) {
      Iterator var4 = this.J.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         AttributeInstance var6 = var2.a((IAttribute)var5.getKey());
         if(var6 != null) {
            var6.c((AttributeModifier)var5.getValue());
         }
      }

   }

   public void b(EntityLiving var1, AttributeMapBase var2, int var3) {
      Iterator var4 = this.J.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         AttributeInstance var6 = var2.a((IAttribute)var5.getKey());
         if(var6 != null) {
            AttributeModifier var7 = (AttributeModifier)var5.getValue();
            var6.c(var7);
            var6.b(new AttributeModifier(var7.a(), this.a() + " " + var3, this.a(var3, var7), var7.c()));
         }
      }

   }

   public double a(int var1, AttributeModifier var2) {
      return var2.d() * (double)(var1 + 1);
   }

}
