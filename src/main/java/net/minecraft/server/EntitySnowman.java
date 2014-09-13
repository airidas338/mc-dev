package net.minecraft.server;
import java.io.IOException;


public class EntitySnowman extends EntityGolem implements IRangedEntity {

   public EntitySnowman(World var1) {
      super(var1);
      this.a(0.7F, 1.9F);
      ((aay)this.getNavigation()).save(true);
      this.goalSelector.a(1, new PathfinderGoalArrowAttack(this, 1.25D, 20, 10.0F));
      this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
      this.goalSelector.a(4, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new aaq(this, EntityInsentient.class, 10, true, false, IMonster.d));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(4.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.20000000298023224D);
   }

   public void m() throws IOException {
      super.m();
      if(!this.o.D) {
         int var1 = MathHelper.c(this.s);
         int var2 = MathHelper.c(this.t);
         int var3 = MathHelper.c(this.u);
         if(this.U()) {
            this.a(DamageSource.f, 1.0F);
         }

         if(this.o.b(new Location(var1, 0, var3)).a(new Location(var1, var2, var3)) > 1.0F) {
            this.a(DamageSource.c, 1.0F);
         }

         for(int var4 = 0; var4 < 4; ++var4) {
            var1 = MathHelper.c(this.s + (double)((float)(var4 % 2 * 2 - 1) * 0.25F));
            var2 = MathHelper.c(this.t);
            var3 = MathHelper.c(this.u + (double)((float)(var4 / 2 % 2 * 2 - 1) * 0.25F));
            if(this.o.getData(new Location(var1, var2, var3)).c().r() == Material.AIR && this.o.b(new Location(var1, 0, var3)).a(new Location(var1, var2, var3)) < 0.8F && Blocks.SNOW.c(this.o, new Location(var1, var2, var3))) {
               this.o.a(new Location(var1, var2, var3), Blocks.SNOW.P());
            }
         }
      }

   }

   protected Item A() {
      return Items.aD;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(16);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(Items.aD, 1);
      }

   }

   public void a(EntityLiving var1, float var2) {
      EntitySnowball var3 = new EntitySnowball(this.o, this);
      double var4 = var1.t + (double)var1.aR() - 1.100000023841858D;
      double var6 = var1.s - this.s;
      double var8 = var4 - var3.t;
      double var10 = var1.u - this.u;
      float var12 = MathHelper.sqrt(var6 * var6 + var10 * var10) * 0.2F;
      var3.shoot(var6, var8 + (double)var12, var10, 1.6F, 12.0F);
      this.a("random.bow", 1.0F, 1.0F / (this.bb().nextFloat() * 0.4F + 0.8F));
      this.o.d((Entity)var3);
   }

   public float aR() {
      return 1.7F;
   }
}
