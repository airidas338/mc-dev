package net.minecraft.server;
import java.io.IOException;


public class EntityCreeper extends EntityMonster {

   private int b;
   private int c;
   private int bk = 30;
   private int bl = 3;
   private int bm = 0;


   public EntityCreeper(World var1) {
      super(var1);
      this.goalSelector.a(1, new yy(this));
      this.goalSelector.a(2, new aae(this));
      this.goalSelector.a(2, this.a);
      this.goalSelector.a(3, new yp(this, new aeq(this), 6.0F, 1.0D, 1.2D));
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 1.0D, false));
      this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 0.8D));
      this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(6, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new aaq(this, EntityHuman.class, true));
      this.targetSelector.a(2, new PathfinderGoalHurtByTarget(this, false, new Class[0]));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
   }

   public int aF() {
      return this.u() == null?3:3 + (int)(this.bm() - 1.0F);
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      this.c = (int)((float)this.c + var1 * 1.5F);
      if(this.c > this.bk - 5) {
         this.c = this.bk - 5;
      }

   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)-1));
      this.ac.a(17, Byte.valueOf((byte)0));
      this.ac.a(18, Byte.valueOf((byte)0));
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.ac.a(17) == 1) {
         var1.setBoolean("powered", true);
      }

      var1.setShort("Fuse", (short)this.bk);
      var1.setByte("ExplosionRadius", (byte)this.bl);
      var1.setBoolean("ignited", this.cl());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.ac.b(17, Byte.valueOf((byte)(var1.n("powered")?1:0)));
      if(var1.b("Fuse", 99)) {
         this.bk = var1.getShort("Fuse");
      }

      if(var1.b("ExplosionRadius", 99)) {
         this.bl = var1.getByte("ExplosionRadius");
      }

      if(var1.n("ignited")) {
         this.cm();
      }

   }

   public void s_() throws IOException {
      if(this.isAlive()) {
         this.b = this.c;
         if(this.cl()) {
            this.a(1);
         }

         int var1 = this.ck();
         if(var1 > 0 && this.c == 0) {
            this.a("creeper.primed", 1.0F, 0.5F);
         }

         this.c += var1;
         if(this.c < 0) {
            this.c = 0;
         }

         if(this.c >= this.bk) {
            this.c = this.bk;
            this.cp();
         }
      }

      super.s_();
   }

   protected String bn() {
      return "mob.creeper.say";
   }

   protected String bo() {
      return "mob.creeper.death";
   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(var1.getEntity() instanceof EntitySkeleton) {
         int var2 = Item.b(Items.cq);
         int var3 = Item.b(Items.cB);
         int var4 = var2 + this.V.nextInt(var3 - var2 + 1);
         this.a(Item.b(var4), 1);
      } else if(var1.getEntity() instanceof EntityCreeper && var1.getEntity() != this && ((EntityCreeper)var1.getEntity()).n() && ((EntityCreeper)var1.getEntity()).cn()) {
         ((EntityCreeper)var1.getEntity()).co();
         this.a(new ItemStack(Items.bX, 1, 4), 0.0F);
      }

   }

   public boolean r(Entity var1) {
      return true;
   }

   public boolean n() {
      return this.ac.a(17) == 1;
   }

   protected Item A() {
      return Items.H;
   }

   public int ck() {
      return this.ac.a(16);
   }

   public void a(int var1) {
      this.ac.b(16, Byte.valueOf((byte)var1));
   }

   public void a(EntityLightning var1) {
      super.a(var1);
      this.ac.b(17, Byte.valueOf((byte)1));
   }

   protected boolean a(EntityHuman var1) throws IOException {
      ItemStack var2 = var1.bg.h();
      if(var2 != null && var2.b() == Items.d) {
         this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "fire.ignite", 1.0F, this.V.nextFloat() * 0.4F + 0.8F);
         var1.bv();
         if(!this.o.D) {
            this.cm();
            var2.a(1, (EntityLiving)var1);
            return true;
         }
      }

      return super.a(var1);
   }

   private void cp() {
      if(!this.o.D) {
         boolean var1 = this.o.Q().b("mobGriefing");
         float var2 = this.n()?2.0F:1.0F;
         this.o.a(this, this.s, this.t, this.u, (float)this.bl * var2, var1);
         this.J();
      }

   }

   public boolean cl() {
      return this.ac.a(18) != 0;
   }

   public void cm() {
      this.ac.b(18, Byte.valueOf((byte)1));
   }

   public boolean cn() {
      return this.bm < 1 && this.o.Q().b("doMobLoot");
   }

   public void co() {
      ++this.bm;
   }
}
