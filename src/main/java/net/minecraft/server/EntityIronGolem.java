package net.minecraft.server;
import java.io.IOException;


public class EntityIronGolem extends EntityGolem {

   private int b;
   abi a;
   private int c;
   private int bk;


   public EntityIronGolem(World var1) {
      super(var1);
      this.a(1.4F, 2.9F);
      ((aay)this.s()).a(true);
      this.i.a(1, new zk(this, 1.0D, true));
      this.i.a(2, new zp(this, 0.9D, 32.0F));
      this.i.a(3, new zm(this, 0.6D, true));
      this.i.a(4, new zo(this, 1.0D));
      this.i.a(5, new zs(this));
      this.i.a(6, new zy(this, 0.6D));
      this.i.a(7, new zh(this, EntityHuman.class, 6.0F));
      this.i.a(8, new zx(this));
      this.bg.a(1, new aak(this));
      this.bg.a(2, new aal(this, false, new Class[0]));
      this.bg.a(3, new acr(this, EntityInsentient.class, 10, false, true, IMonster.e));
   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)0));
   }

   protected void E() {
      if(--this.b <= 0) {
         this.b = 70 + this.V.nextInt(50);
         this.a = this.o.ae().a(new Location(this), 32);
         if(this.a == null) {
            this.ch();
         } else {
            Location var1 = this.a.a();
            this.a(var1, (int)((float)this.a.b() * 0.6F));
         }
      }

      super.E();
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(100.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
   }

   protected int j(int var1) {
      return var1;
   }

   protected void s(Entity var1) {
      if(var1 instanceof IMonster && this.bb().nextInt(20) == 0) {
         this.d((EntityLiving)var1);
      }

      super.s(var1);
   }

   public void m() throws IOException {
      super.m();
      if(this.c > 0) {
         --this.c;
      }

      if(this.bk > 0) {
         --this.bk;
      }

      if(this.v * this.v + this.x * this.x > 2.500000277905201E-7D && this.V.nextInt(5) == 0) {
         int var1 = MathHelper.c(this.s);
         int var2 = MathHelper.c(this.t - 0.20000000298023224D);
         int var3 = MathHelper.c(this.u);
         IBlock var4 = this.o.getData(new Location(var1, var2, var3));
         Block var5 = var4.c();
         if(var5.r() != Material.AIR) {
            this.o.a(ew.L, this.s + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, this.aQ().b + 0.1D, this.u + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, 4.0D * ((double)this.V.nextFloat() - 0.5D), 0.5D, ((double)this.V.nextFloat() - 0.5D) * 4.0D, new int[]{Block.f(var4)});
         }
      }

   }

   public boolean a(Class var1) {
      return this.cl() && EntityHuman.class.isAssignableFrom(var1)?false:super.a(var1);
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.a("PlayerCreated", this.cl());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.l(var1.n("PlayerCreated"));
   }

   public boolean r(Entity var1) {
      this.c = 10;
      this.o.a((Entity)this, (byte)4);
      boolean var2 = var1.a(DamageSource.a((EntityLiving)this), (float)(7 + this.V.nextInt(15)));
      if(var2) {
         var1.w += 0.4000000059604645D;
         this.a(this, var1);
      }

      this.a("mob.irongolem.throw", 1.0F, 1.0F);
      return var2;
   }

   public abi n() {
      return this.a;
   }

   public void a(boolean var1) {
      this.bk = var1?400:0;
      this.o.a((Entity)this, (byte)11);
   }

   protected String bn() {
      return "mob.irongolem.hit";
   }

   protected String bo() {
      return "mob.irongolem.death";
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.irongolem.walk", 1.0F, 1.0F);
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Item.a((Block)aty.O), 1, (float)EnumFlowerType.b.b());
      }

      var4 = 3 + this.V.nextInt(3);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.a(Items.j, 1);
      }

   }

   public int ck() {
      return this.bk;
   }

   public boolean cl() {
      return (this.ac.a(16) & 1) != 0;
   }

   public void l(boolean var1) {
      byte var2 = this.ac.a(16);
      if(var1) {
         this.ac.b(16, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.ac.b(16, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public void a(DamageSource var1) {
      if(!this.cl() && this.aL != null && this.a != null) {
         this.a.a(this.aL.d_(), -5);
      }

      super.a(var1);
   }
}
