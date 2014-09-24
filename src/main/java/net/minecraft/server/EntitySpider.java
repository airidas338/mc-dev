package net.minecraft.server;
import java.io.IOException;


public class EntitySpider extends EntityMonster {

   public EntitySpider(World var1) {
      super(var1);
      this.a(1.4F, 0.9F);
      this.goalSelector.a(1, new yy(this));
      this.goalSelector.a(2, this.a);
      this.goalSelector.a(3, new zg(this, 0.4F));
      this.goalSelector.a(4, new agf(this, EntityHuman.class));
      this.goalSelector.a(4, new agf(this, EntityIronGolem.class));
      this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 0.8D));
      this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(6, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false, new Class[0]));
      this.targetSelector.a(2, new agh(this, EntityHuman.class));
      this.targetSelector.a(3, new agh(this, EntityIronGolem.class));
   }

   protected Navigation b(World var1) {
      return new aba(this, var1);
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Byte((byte)0));
   }

   public void s_() throws IOException {
      super.s_();
      if(!this.o.isStatic) {
         this.a(this.D);
      }

   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(16.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.30000001192092896D);
   }

   protected String z() {
      return "mob.spider.say";
   }

   protected String bn() {
      return "mob.spider.say";
   }

   protected String bo() {
      return "mob.spider.death";
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.spider.step", 0.15F, 1.0F);
   }

   protected Item A() {
      return Items.F;
   }

   protected void b(boolean var1, int var2) {
      super.b(var1, var2);
      if(var1 && (this.V.nextInt(3) == 0 || this.V.nextInt(1 + var2) > 0)) {
         this.a(Items.bB, 1);
      }

   }

   public boolean j_() {
      return this.n();
   }

   public void aB() {}

   public xs by() {
      return xs.c;
   }

   public boolean d(MobEffect var1) {
      return var1.getEffectId() == MobEffectList.u.H?false:super.d(var1);
   }

   public boolean n() {
      return (this.ac.a(16) & 1) != 0;
   }

   public void a(boolean var1) {
      byte var2 = this.ac.a(16);
      if(var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.ac.b(16, Byte.valueOf(var2));
   }

   public xq a(vu var1, xq var2) {
      Object var4 = super.a(var1, var2);
      if(this.o.random.nextInt(100) == 0) {
         EntitySkeleton var3 = new EntitySkeleton(this.o);
         var3.setPositionRotation(this.s, this.t, this.u, this.y, 0.0F);
         var3.a(var1, (xq)null);
         this.o.addEntity((Entity)var3);
         var3.a((Entity)this);
      }

      if(var4 == null) {
         var4 = new agg();
         if(this.o.aa() == EnumDifficulty.HARD && this.o.random.nextFloat() < 0.1F * var1.c()) {
            ((agg)var4).a(this.o.random);
         }
      }

      if(var4 instanceof agg) {
         int var5 = ((agg)var4).a;
         if(var5 > 0 && MobEffectList.a[var5] != null) {
            this.c(new MobEffect(var5, Integer.MAX_VALUE));
         }
      }

      return (xq)var4;
   }

   public float aR() {
      return 0.65F;
   }
}
