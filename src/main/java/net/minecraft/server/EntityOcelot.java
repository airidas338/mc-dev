package net.minecraft.server;
import java.io.IOException;

import com.google.common.base.Predicate;

public class EntityOcelot extends EntityTameableAnimal {

   private yp bm;
   private aag bn;


   public EntityOcelot(World var1) {
      super(var1);
      this.a(0.6F, 0.7F);
      ((aay)this.getNavigation()).save(true);
      this.goalSelector.a(1, new yy(this));
      this.goalSelector.a(2, this.bk);
      this.goalSelector.a(3, this.bn = new aag(this, 0.6D, Items.aU, true));
      this.goalSelector.a(5, new yz(this, 1.0D, 10.0F, 5.0F));
      this.goalSelector.a(6, new zr(this, 0.8D));
      this.goalSelector.a(7, new zg(this, 0.3F));
      this.goalSelector.a(8, new zq(this));
      this.goalSelector.a(9, new yt(this, 0.8D));
      this.goalSelector.a(10, new PathfinderGoalRandomStroll(this, 0.8D));
      this.goalSelector.a(11, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 10.0F));
      this.targetSelector.a(1, new aat(this, EntityChicken.class, false, (Predicate)null));
   }

   protected void h() {
      super.h();
      this.ac.a(18, Byte.valueOf((byte)0));
   }

   public void E() {
      if(this.q().a()) {
         double var1 = this.q().b();
         if(var1 == 0.6D) {
            this.c(true);
            this.d(false);
         } else if(var1 == 1.33D) {
            this.c(false);
            this.d(true);
         } else {
            this.c(false);
            this.d(false);
         }
      } else {
         this.c(false);
         this.d(false);
      }

   }

   protected boolean C() {
      return !this.cj() && this.W > 2400;
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(10.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.30000001192092896D);
   }

   public void e(float var1, float var2) {}

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("CatType", this.cr());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.r(var1.getInt("CatType"));
   }

   protected String z() {
      return this.cj()?(this.cp()?"mob.cat.purr":(this.V.nextInt(4) == 0?"mob.cat.purreow":"mob.cat.meow")):"";
   }

   protected String bn() {
      return "mob.cat.hitt";
   }

   protected String bo() {
      return "mob.cat.hitt";
   }

   protected float bA() {
      return 0.4F;
   }

   protected Item A() {
      return Items.aF;
   }

   public boolean r(Entity var1) {
      return var1.a(DamageSource.a((EntityLiving)this), 3.0F);
   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.bk.a(false);
         return super.a(var1, var2);
      }
   }

   protected void b(boolean var1, int var2) {}

   public boolean a(EntityHuman var1) {
      ItemStack var2 = var1.bg.h();
      if(this.cj()) {
         if(this.e(var1) && !this.o.isStatic && !this.d(var2)) {
            this.bk.a(!this.cl());
         }
      } else if(this.bn.f() && var2 != null && var2.b() == Items.aU && var1.h(this) < 9.0D) {
         if(!var1.by.canInstantlyBuild) {
            --var2.b;
         }

         if(var2.b <= 0) {
            var1.bg.a(var1.bg.c, (ItemStack)null);
         }

         if(!this.o.isStatic) {
            if(this.V.nextInt(3) == 0) {
               this.m(true);
               this.r(1 + this.o.random.nextInt(3));
               this.b(var1.aJ().toString());
               this.l(true);
               this.bk.a(true);
               this.o.a((Entity)this, (byte)7);
            } else {
               this.l(false);
               this.o.a((Entity)this, (byte)6);
            }
         }

         return true;
      }

      return super.a(var1);
   }

   public EntityOcelot b(EntityAgeable var1) {
      EntityOcelot var2 = new EntityOcelot(this.o);
      if(this.cj()) {
         var2.b(this.b());
         var2.m(true);
         var2.r(this.cr());
      }

      return var2;
   }

   public boolean d(ItemStack var1) {
      return var1 != null && var1.b() == Items.aU;
   }

   public boolean a(EntityAnimal var1) {
      if(var1 == this) {
         return false;
      } else if(!this.cj()) {
         return false;
      } else if(!(var1 instanceof EntityOcelot)) {
         return false;
      } else {
         EntityOcelot var2 = (EntityOcelot)var1;
         return !var2.cj()?false:this.cp() && var2.cp();
      }
   }

   public int cr() {
      return this.ac.a(18);
   }

   public void r(int var1) {
      this.ac.b(18, Byte.valueOf((byte)var1));
   }

   public boolean bQ() {
      return this.o.random.nextInt(3) != 0;
   }

   public boolean bR() {
      if(this.o.a(this.aQ(), (Entity)this) && this.o.a((Entity)this, this.aQ()).isEmpty() && !this.o.d(this.aQ())) {
         Location var1 = new Location(this.s, this.aQ().b, this.u);
         if(var1.o() < 63) {
            return false;
         }

         Block var2 = this.o.getData(var1.b()).c();
         if(var2 == Blocks.GRASS || var2.getMaterial() == Material.LEAVES) {
            return true;
         }
      }

      return false;
   }

   public String getName() {
      return this.k_()?this.aL():(this.cj()?LocaleI18n.a("entity.Cat.name"):super.getName());
   }

   public void m(boolean var1) {
      super.m(var1);
   }

   protected void ck() {
      if(this.bm == null) {
         this.bm = new yp(this, new abz(this), 16.0F, 0.8D, 1.33D);
      }

      this.goalSelector.a((PathfinderGoal)this.bm);
      if(!this.cj()) {
         this.goalSelector.a(4, this.bm);
      }

   }

   public xq a(vu var1, xq var2) {
      var2 = super.a(var1, var2);
      if(this.o.random.nextInt(7) == 0) {
         for(int var3 = 0; var3 < 2; ++var3) {
            EntityOcelot var4 = new EntityOcelot(this.o);
            var4.setPositionRotation(this.s, this.t, this.u, this.y, 0.0F);
            var4.b(-24000);
            this.o.d((Entity)var4);
         }
      }

      return var2;
   }

   // $FF: synthetic method
   public EntityAgeable a(EntityAgeable var1) {
      return this.b(var1);
   }
}
